package ar.edu.unlam.scaw.controladores;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioPasswordSegura;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorResetPassword {
	
	public final static Logger logger = Logger.getLogger(ControladorResetPassword.class);
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioPasswordSegura servicioPasswordSegura;
	
	@RequestMapping("/reset_password")
	public ModelAndView index(HttpServletRequest request)
	{
		ModelMap modelo = new ModelMap();
		if("habilitado".equals(request.getSession().getAttribute("estado"))){
			Usuario usuario = new Usuario();
			modelo.put("usuario", usuario);
		} else{
			logger.error("Intento de acceso no autorizado a mostrar usuario.");
			return new ModelAndView("error401");
		}
		
		return new ModelAndView("resetPassword", modelo);
	}
	
	@RequestMapping(path = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("usuario") Usuario resetPassword, @RequestParam("newPassword") String newPassword, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if("habilitado".equals(request.getSession().getAttribute("estado"))){
			try{
				if(resetPassword.getPassword() == "" || newPassword == "") {
					modelo.put("msg", "Debes rellenar los campos.");
					return new ModelAndView("redirect:/mostrarUsuario", modelo);
				}
		
				String email = (String) request.getSession().getAttribute("email");
				resetPassword.setEmail(email);
				
				Usuario usuario = servicioUsuario.buscarUsuarioPorEmail(email);
				
				if(usuario != null) {
					
					if(servicioPasswordSegura.passwordEncoder().matches(resetPassword.getPassword(), usuario.getPassword()))
					{
						if(!servicioPasswordSegura.passwordEncoder().matches(newPassword, usuario.getPassword())) {	
							
							String hashedPassword = servicioPasswordSegura.passwordEncoder().encode(newPassword);
							usuario.setPassword(hashedPassword);
							servicioUsuario.updateUsuario(usuario);
							request.getSession().setAttribute("msg",  "Contraseña actualizada correctamente.");
						}else {
							request.getSession().setAttribute("msg",  "La contraseña nueva debe ser diferente que la anterior.");
						}
					}else {
						request.getSession().setAttribute("msg",  "Los datos ingresados son incorrectos.");
					}
						
				}else {
					request.getSession().setAttribute("msg",  "Los datos ingresados son incorrectos.");
				}
	
			}catch(Exception e){
				logger.error("Error al reiniciar contraseña", e);
			}
		} else{
			logger.error("Intento de acceso no autorizado a resetPassword.");
			return new ModelAndView("error401");
		}
		
		return new ModelAndView("redirect:/mostrarUsuario", modelo);
	}
}
