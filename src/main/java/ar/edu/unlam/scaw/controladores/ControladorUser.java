package ar.edu.unlam.scaw.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

//@Controller
public class ControladorUser {

	@Inject
	ServicioUsuario servicioUsuario;
	
	@RequestMapping(path = "/guardarComentario")
	public ModelAndView guardarComentario(@ModelAttribute("textoModel") Texto text, HttpServletRequest request) {		
		
		Texto t = new Texto();
		int idUsuario = (int) request.getSession().getAttribute("id");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
		t.setDescripcion(text.getDescripcion());
		servicioUsuario.agregarTextoAUsuarioSERVICE(usuario, text);

//		return new ModelAndView("redirect:/misActividades");
		return new ModelAndView("homeUsuario");
	}
	
	


}
