package ar.edu.unlam.scaw.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.ModeloRegistrarse;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioRegistrarUsuario;

@Controller
public class ControladorRegistrarse {
	
	@Inject
	private ServicioRegistrarUsuario servicioRegistrarUsuario;
	
	@RequestMapping(path = "/validar-registrarse", method = RequestMethod.POST)
	public ModelAndView validarRegistrarUsuario(@ModelAttribute("modeloRegistrarse") ModeloRegistrarse mUsuarioAReg) {
		
		if(servicioRegistrarUsuario.validarUsuarioARegistrar(mUsuarioAReg)) {
			
			servicioRegistrarUsuario.registatUsuario(mUsuarioAReg);
			
			return new ModelAndView("ok");
		}
		
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		modelo.put("modeloRegistrarse", mUsuarioAReg);
		
		return new ModelAndView("login", modelo);
	}
	
}
