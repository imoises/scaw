package ar.edu.unlam.scaw.controladores;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.recaptcha.VerifyUtils;
import ar.edu.unlam.scaw.servicios.ServicioActividad;
import ar.edu.unlam.scaw.servicios.ServicioAdmin;
import ar.edu.unlam.scaw.servicios.ServicioLogin;
import ar.edu.unlam.scaw.servicios.ServicioPasswordSegura;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {
	public final static String LOGEADO = "El usuario se logeo en la aplicación";
	public final static Logger logger = Logger.getLogger(ControladorLogin.class);
	public static int CANT_ERROR_LOGEO = 0 ;
	
	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioActividad servicioActividad;
	
	@Inject
	private ServicioPasswordSegura servicioPasswordSegura;
	@Inject
	private ServicioAdmin servicioAdmin;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {
		
		servicioAdmin.deleteUsuariosInactivosPorPeriodo();
		
		ModelMap modelo = new ModelMap();
		try{
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		
		
		logger.info("Se accede al login");
		
		}catch(Exception e){
			logger.error("Error en Login", e);
		}
		
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El mÃ©todo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request,HttpServletResponse response) {
		ModelMap model = new ModelMap();
		boolean valid = true;
	    String errorString = null;

		try{
		    if(usuario.getNickname().isEmpty() || usuario.getPassword().isEmpty()){
		    	valid = false; 
		    	errorString = "El nick y contraseña son requeridos!";
		    	Usuario u = new Usuario();
				model.put("error", errorString);
				model.put("usuario",u);
				logger.info("Usuario o contraseña incompletos.");
		    }
		    
		    if (valid) {
		    	 
		         String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		 
		         System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
		 
		         // Verify CAPTCHA.
		         valid = VerifyUtils.verify(gRecaptchaResponse);
		         if (!valid) {
		             errorString = "Captcha invalid!";
		             Usuario u = new Usuario();
		 			 model.put("error", errorString);
		 			 model.put("usuario",u);
		 			 logger.info("Captcha inválido.");
		         }else{
		         
		            Usuario usuarioBuscado = servicioLogin.consultarUsuarioPorNickname(usuario.getNickname());
					if (usuarioBuscado != null) {
						
						if(CANT_ERROR_LOGEO < 3 && (servicioPasswordSegura.passwordEncoder().matches(usuario.getPassword(), usuarioBuscado.getPassword())) ) {
							
							Actividad a = new Actividad();
							
							a.setDescripcion(LOGEADO);
							a.setFecha(new Timestamp(System.currentTimeMillis()));
							a.setUsuario(usuarioBuscado);
							
							servicioActividad.registarActividad(a);
				 			logger.info("Se loguea un usuario correctamente");
							
							request.getSession().setAttribute("rol", usuarioBuscado.getRol());
							request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
							request.getSession().setAttribute("email", usuarioBuscado.getEmail());
							request.getSession().setAttribute("estado", usuarioBuscado.getEstado());
							
							model.put("usuario", usuarioBuscado);
							if (usuarioBuscado.getRol().equals("admin")) {
								return new ModelAndView("redirect:/administrar",model);
							}else{
								if (usuarioBuscado.getEstado().equals("deshabilitado")) {
									return new ModelAndView("deshabilitado", model);
								}
								if (usuarioBuscado.getEstado().equals("habilitado")) {
									return new ModelAndView("redirect:/mostrarUsuario",model);
								}
								
							}
						}else {
							valid = false; 
					    	errorString = "Usuario o clave incorrecta!";
					    	Usuario u = new Usuario();
							model.put("error", errorString);
							model.put("usuario",u);
				 			logger.info(errorString);
				 			CANT_ERROR_LOGEO ++;
				 			if(CANT_ERROR_LOGEO == 3){
				 				servicioAdmin.deshabilitarUsuario(usuarioBuscado.getId());
				 				errorString = "El usuario se ha deshabilitados por ingresar 3 veces incorrectamente la contraseña.Comuniquese con su administrador!";
				 				model.put("usuario", usuarioBuscado);
								if (usuarioBuscado.getEstado().equals("deshabilitado")) {
									return new ModelAndView("deshabilitado", model);
								}
								CANT_ERROR_LOGEO=0;
				 			}
				 			
						}
						
					}else {
						// si el usuario no existe agrega un mensaje de error en el modelo.
						
						valid = false; 
				    	errorString = "Usuario o clave incorrecta!";
				    	Usuario u = new Usuario();
						model.put("error", errorString);
						model.put("usuario",u);
			 			logger.info(errorString);
						
					}
		         }
		     }
		}catch(Exception e){
			logger.error("Error en Login", e);
		}
			
		
	    
		return new ModelAndView("login", model);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}