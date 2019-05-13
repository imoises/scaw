package ar.edu.unlam.scaw.controladores;

import javax.inject.Inject;

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

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("/registrarse")
	public ModelAndView Registrar() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("registrarse", modelo);
	}
	
	@RequestMapping(path = "/registrarusuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario agregarusuario) {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);

		if(servicioUsuario.agregarUsuario(agregarusuario)) {
			return new ModelAndView("redirect:/login");
		}
		
		return new ModelAndView("/registrarse", modelo);
	}
	
}
