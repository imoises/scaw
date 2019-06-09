package ar.edu.unlam.scaw.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioActividad;
import ar.edu.unlam.scaw.servicios.ServicioAdmin;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {
	public final static Logger logger = Logger.getLogger(ControladorAdmin.class);

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioAdmin servicioAdmin;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioActividad servicioActividad;

	@RequestMapping("/administrar")
	public ModelAndView irAAdministar(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		if("admin".equals(request.getSession().getAttribute("rol"))){
			try {
				List<Usuario> usuarios = servicioAdmin.consultarUsuarios();
				modelo.put("usuarios", usuarios);
				
			}catch(Exception e){
				logger.error("Error al consultar usuarios para administrar.", e);
			}
		} else{
			logger.error("Intento de acceso a Administrar no autorizado");
			return new ModelAndView("error401");
		}

		
		return new ModelAndView("homeAdmin", modelo);
	}

	@RequestMapping(path = "/habilitar-usuario/{idUsuario}", method = RequestMethod.GET)
	public ModelAndView irAHabilitarUsuario(@PathVariable int idUsuario, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		if("admin".equals(request.getSession().getAttribute("rol"))){
			try{
				servicioAdmin.habilitarUsuario(idUsuario);
			
				List<Usuario> usuarios = servicioAdmin.consultarUsuarios();
				modelo.put("usuarios", usuarios);
	
			}catch(Exception e){
				logger.error("Error al habilitar usuario.", e);
			}
		} else{
			logger.error("Intento de acceso no autorizado a habilitar usuario - IDUsuario: " + idUsuario);
			return new ModelAndView("error401");
		}

		return new ModelAndView("redirect:/administrar", modelo);
	}

	@RequestMapping(path = "/deshabilitar-usuario/{idUsuario}", method = RequestMethod.GET)
	public ModelAndView irADeshabilitarUsuario(@PathVariable int idUsuario, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		if("admin".equals(request.getSession().getAttribute("rol"))){
			try{
				servicioAdmin.deshabilitarUsuario(idUsuario);
				
				List<Usuario> usuarios = servicioAdmin.consultarUsuarios();
				modelo.put("usuarios", usuarios);
		
			}catch(Exception e){
				logger.error("Error al deshabilitar usuario.", e);
			}
		} else{
			logger.error("Intento de acceso no autorizado a deshabilitar usuario - IDUsuario: " + idUsuario);
			return new ModelAndView("error401");
		}
		return new ModelAndView("redirect:/administrar", modelo);
	}
	
	@RequestMapping(path = "/actividad-usuario/{idUsuario}", method = RequestMethod.GET)
	public ModelAndView irAActividadUsuario(@PathVariable int idUsuario, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		if("admin".equals(request.getSession().getAttribute("rol"))){
			try{
				Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
				
				List<Actividad> actividades = servicioActividad.listarActividadesXUsuario(usuario);
				if(actividades.size() == 0) {
					modelo.put("error", "El usuario aún no registra actividades.");
					return new ModelAndView("verActividades", modelo);
				}
				modelo.put("actividades", actividades);
			}
			catch(Exception e){
				logger.error("Error: ", e);
				modelo.put("error", "El usuario no existe.");
			}
		} else{
			logger.error("Intento de acceso no autorizado a Ver actividad - IDUsuario: " + idUsuario);
			return new ModelAndView("error401");
		}
		return new ModelAndView("verActividades", modelo);
	}
	

}
