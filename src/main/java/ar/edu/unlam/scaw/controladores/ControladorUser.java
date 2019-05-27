package ar.edu.unlam.scaw.controladores;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioActividad;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

@Controller
public class ControladorUser {
	public static final String ADD_COMENTARIO = "El usuario agrego un comentario.";
	
	@Inject
	ServicioUsuario servicioUsuario;
	@Inject
	ServicioActividad servicioActividad;
	
	@RequestMapping(path="/mostrarUsuario",method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView mostrarUsuario(@ModelAttribute("usuario") Usuario user,HttpServletRequest request){
		
		int idUsuario = (int) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
		
		List<Actividad> listaActividades = servicioActividad.listarActividadesXUsuario(usuario);
		Texto t = new Texto();
		
		ModelMap model = new ModelMap();
		model.put("keyListaActividades", listaActividades);
		model.put("textoModel", t);
		
		String msg = (String) request.getSession().getAttribute("msg");
		if(msg != null && !msg.isEmpty()){
			model.put("msg", msg);
			request.getSession().removeAttribute("msg");
		}
		
		return new ModelAndView("homeUsuario",model);
	}
	
	@RequestMapping(path = "/guardarComentario",method = RequestMethod.POST)
	public ModelAndView guardarComentario(@ModelAttribute("textoModel") Texto text, HttpServletRequest request) {		
		
		int idUsuario = (int) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
		
		Actividad a = new Actividad();
		
		a.setDescripcion(ADD_COMENTARIO);
		a.setFecha(new Timestamp(System.currentTimeMillis()));
		a.setUsuario(usuario);
		
		servicioActividad.registarActividad(a);
		
		text.setDescripcion(text.getDescripcion());
		
		servicioUsuario.agregarTextoAUsuarioSERVICE(usuario, text);

		return new ModelAndView("redirect:/mostrarUsuario");
	}


}