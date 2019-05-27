package ar.edu.unlam.scaw.controladores;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioUsuario;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorResetPassword 
{
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("/reset_password")
	public ModelAndView index()
	{
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("resetPassword", modelo);
	}
	
	@RequestMapping(path = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("usuario") Usuario resetPassword, @RequestParam("newPassword") String newPassword, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		if(resetPassword.getPassword() == "" || newPassword == "") {
			modelo.put("msg", "Debes rellenar los campos.");
			return new ModelAndView("redirect:/mostrarUsuario", modelo);
		}

		String email = (String) request.getSession().getAttribute("email");
		resetPassword.setEmail(email);
		
		Usuario usuario = servicioUsuario.consultarUsuarioPorEmailYPassword(resetPassword);
		String hashedPassword = DigestUtils.md5Hex(newPassword);
		
		if(usuario != null) {
			
			if(!hashedPassword.equals(usuario.getPassword())) 
			{
				usuario.setPassword(newPassword);
				servicioUsuario.updateUsuario(usuario);
				request.getSession().setAttribute("msg",  "Contraseña actualizada correctamente.");
				
			}else {
				request.getSession().setAttribute("msg",  "La contraseña nueva debe ser diferente que la anterior.");
			}
				
		}else {
			request.getSession().setAttribute("msg",  "Los datos ingresados son incorrectos.");
		}
		
		return new ModelAndView("redirect:/mostrarUsuario", modelo);
	}
}
