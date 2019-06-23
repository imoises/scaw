package ar.edu.unlam.scaw.controladores;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
	public final static Logger logger = Logger.getLogger(ControladorUser.class);
	public static final String ADD_COMENTARIO = "El usuario agrego un comentario.";
	
	@Inject
	ServicioUsuario servicioUsuario;
	@Inject
	ServicioActividad servicioActividad;
	
	@RequestMapping(path="/mostrarUsuario",method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView mostrarUsuario(@ModelAttribute("usuario") Usuario user,HttpServletRequest request){

		ModelMap model = new ModelMap();
		if("habilitado".equals(request.getSession().getAttribute("estado"))){
			try{
				int idUsuario = (int) request.getSession().getAttribute("idUsuario");
				Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
				
				List<Actividad> listaActividades = servicioActividad.listarActividadesXUsuario(usuario);
				Texto t = new Texto();
				
				model.put("keyListaActividades", listaActividades);
				model.put("textoModel", t);
				
				//para vencer pass en 30 dias
				Calendar calendar = Calendar.getInstance();
			    calendar.setTime(new Date());
			    calendar.add(Calendar.DAY_OF_MONTH, -30);
			    Timestamp fechaHace30dias = new Timestamp(calendar.getTimeInMillis());
				
				if(usuario.getFechaUltimoCambioPass().before(fechaHace30dias)){
					model.put("msg", "Debe modificar su contraseña ya que han pasado más de 30 días desde el último cambio");
				}

				
				String msg = (String) request.getSession().getAttribute("msg");
				if(msg != null && !msg.isEmpty()){
					model.put("msg", msg);
					request.getSession().removeAttribute("msg");
				}
			}catch(Exception e){
				logger.error("Error al mostrar usuario", e);
			}
		} else{
			logger.error("Intento de acceso no autorizado a mostrar usuario.");
			return new ModelAndView("error401");
		}
		
		return new ModelAndView("homeUsuario",model);
	}
	
	@RequestMapping(path = "/guardarComentario",method = RequestMethod.POST)
	public ModelAndView guardarComentario(@ModelAttribute("textoModel") Texto text, HttpServletRequest request) {		

		if("habilitado".equals(request.getSession().getAttribute("estado"))){
			try{
				int idUsuario = (int) request.getSession().getAttribute("idUsuario");
				Usuario usuario = servicioUsuario.buscarUsuarioXIdSERVICE(idUsuario);
				
				Actividad a = new Actividad();
				
				a.setDescripcion(ADD_COMENTARIO);
				a.setFecha(new Timestamp(System.currentTimeMillis()));
				a.setUsuario(usuario);
				
				servicioActividad.registarActividad(a);
				
				text.setDescripcion(text.getDescripcion());
				
				servicioUsuario.agregarTextoAUsuarioSERVICE(usuario, text);
			}catch(Exception e){
				logger.error("Error al guardar comentario", e);
			}
		} else{
			logger.error("Intento de acceso no autorizado a guardar comentario.");
			return new ModelAndView("error401");
		}

		return new ModelAndView("redirect:/mostrarUsuario");
	}


}