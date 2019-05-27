package ar.edu.unlam.scaw.controladores;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import ar.edu.unlam.scaw.servicios.ServicioLogin;

@Controller
public class ControladorLogin {
	public static final String LOGEADO = "El usuario se logeo en la aplicación";
	
	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioActividad servicioActividad;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
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
	    
	    if(usuario.getNickname().isEmpty() || usuario.getPassword().isEmpty()){
	    	valid = false; 
	    	errorString = "El nick y contraseña son requeridos!";
	    	Usuario u = new Usuario();
			model.put("error", errorString);
			model.put("usuario",u);
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
	         }else{
	         
	            Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
				if (usuarioBuscado != null) {
					Actividad a = new Actividad();
					
					a.setDescripcion(LOGEADO);
					a.setFecha(new Timestamp(System.currentTimeMillis()));
					a.setUsuario(usuarioBuscado);
					
					servicioActividad.registarActividad(a);
					
					request.getSession().setAttribute("rol", usuarioBuscado.getRol());
					request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
					request.getSession().setAttribute("email", usuarioBuscado.getEmail());
					
					model.put("usuario", usuarioBuscado);
					if (usuarioBuscado.getRol().equals("admin")) {
						return new ModelAndView("redirect:/administrar",model);
					}else{
						if (usuarioBuscado.getEstado().equals("deshabilitado")) {
							return new ModelAndView("deshabilitado", model);
						}
						if (usuarioBuscado.getEstado().equals("habilitado")) {
							return new ModelAndView("redirect:/mostrarUsuario");
						}
						
					}
					
				} else {
					// si el usuario no existe agrega un mensaje de error en el modelo.
					
					valid = false; 
			    	errorString = "Usuario o clave incorrecta!";
			    	Usuario u = new Usuario();
					model.put("error", errorString);
					model.put("usuario",u);
					
				}
	         }
	     }
	    
	    
			
			
		
	    
		return new ModelAndView("login", model);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}
