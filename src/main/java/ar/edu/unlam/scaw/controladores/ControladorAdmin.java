package ar.edu.unlam.scaw.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioAdmin;

@Controller
public class ControladorAdmin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioAdmin servicioAdmin;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/administrar")
	public ModelAndView irAAdministar() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		List<Usuario> usuarios = servicioAdmin.consultarUsuarios();
		modelo.put("usuarios", usuarios);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("homeAdmin", modelo);
	}
	
	

	@RequestMapping(path = "/habilitar-usuario/{idUsuario}", method = RequestMethod.GET)
	public ModelAndView irAHabilitarUsuario(@PathVariable int idUsuario) {

		ModelMap modelo = new ModelMap();
		
		servicioAdmin.habilitarUsuario(idUsuario);
		
		List<Usuario> usuarios = servicioAdmin.consultarUsuarios();
		modelo.put("usuarios", usuarios);
		return new ModelAndView("homeAdmin", modelo);
	}
	
	
	
	
	
	
	
	
	

}
