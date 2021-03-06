package ar.edu.unlam.scaw.controladores;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioActividad;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

@Controller
public class ControladorRegistrarse {
	public final static Logger logger = Logger.getLogger(ControladorRegistrarse.class);
	public static final String REG_COMENTARIO = "El usuario se registro.";
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioActividad servicioActividad;
//	@RequestMapping("/registrarse")
//	public ModelAndView Registrar() {
//		ModelMap modelo = new ModelMap();
//		
//		Usuario usuario = new Usuario();
//		modelo.put("usuario", usuario);
//		
//		return new ModelAndView("login", modelo);
//	}
	
	@RequestMapping("/registrar")
	public ModelAndView Registrar() {
		ModelAndView modelAndView = new ModelAndView("registrar");
        modelAndView.addObject("usuario", new Usuario()); 
        return modelAndView;
	}
	@RequestMapping(path = "/registrarUsuario", method=RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("usuario") @Valid Usuario usuarioReg, BindingResult result) {
        ModelAndView modelAndView = null ;
        ModelMap modelo = new ModelMap();
        try{
	        if(result.hasErrors()) {
	            modelAndView = new ModelAndView("registrar");
	        } else {
	        	usuarioReg.setFechaUltimoCambioPass(new Timestamp(System.currentTimeMillis()));
	        	if(servicioUsuario.registrarUsuario(usuarioReg)) {
					modelo.put("msgRegistrarExito", "Se ha registrado el usuario con �xito. Espere a que un administrador habilite su cuenta.");
					logger.info("Usuario registrado");
					
					Actividad a = new Actividad();
					
					a.setDescripcion(REG_COMENTARIO);
					a.setFecha(new Timestamp(System.currentTimeMillis()));
					a.setUsuario(usuarioReg);
					
					servicioActividad.registarActividad(a);
					
					return new ModelAndView("/registrar", modelo);
				}
	        	else {
	        		modelo.put("msgRegistrarError", "No se ha podido completar el registo correctamente. El usuario o email ya se encuentran registrados.");
	    			logger.info("Error al registar usuario, usuario o email ya registrado");
				}
	            modelAndView = new ModelAndView("registrar");
	        }
        
		}catch(Exception e){
			logger.error("Error al registrar usuario", e);
		}
        modelAndView.addObject(usuarioReg);
        return modelAndView;
    }
//	@RequestMapping(path = "/registrarUsuario", method = RequestMethod.POST)
//	public ModelAndView registrarUsuario(@ModelAttribute("usuario") @Valid Usuario usuario,BindingResult result) {
//		ModelMap modelo = new ModelMap();
//		try{
//			if (result.hasErrors()) {
//				return new ModelAndView("redirect:/registrarse");
//			}else{
//				return new ModelAndView("/login", modelo);
//			}
//			modelo.put("usuario", usuario);
//	
//			if(servicioUsuario.registrarUsuario(usuario)) {
//				modelo.put("msgRegistrarExito", "Se ha registrado el usuario con �xito. Espere a que un administrador habilite su cuenta.");
//				logger.info("Usuario registrado");
//				return new ModelAndView("/login", modelo);
//			}
//	
//			modelo.put("msgRegistrarError", "No se ha podido completar el registo correctamente. El usuario o email ya se encuentran registrados.");
//			logger.info("Error al registar usuario, usuario o email ya registrado");
//
//		}catch(Exception e){
//			logger.error("Error al registrar usuario", e);
//		}
//		return new ModelAndView("/login", modelo);
//	}
	
}
