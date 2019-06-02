package ar.edu.unlam.scaw.controladores;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

@Controller
public class ControladorRegistrarse {
	public final static Logger logger = Logger.getLogger(ControladorRegistrarse.class);

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("/registrarse")
	public ModelAndView Registrar() {
		ModelMap modelo = new ModelMap();
		
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping(path = "/registrarUsuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap modelo = new ModelMap();
		try{
			//Usuario usuario = new Usuario();
			modelo.put("usuario", usuario);
	
			if(servicioUsuario.registrarUsuario(usuario)) {
				modelo.put("msgRegistrarExito", "Se ha registrado el usuario con éxito. Espere a que un administrador habilite su cuenta.");
				logger.info("Usuario registrado");
				return new ModelAndView("/login", modelo);
			}
	
			modelo.put("msgRegistrarError", "No se ha podido completar el registo correctamente. El usuario o email ya se encuentran registrados.");
			logger.info("Error al registar usuario, usuario o email ya registrado");

		}catch(Exception e){
			logger.error("Error al registrar usuario", e);
		}
		return new ModelAndView("/login", modelo);
	}
	
}
