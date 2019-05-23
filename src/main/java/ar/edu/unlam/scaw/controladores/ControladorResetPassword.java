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
	public ModelAndView resetPassword(@ModelAttribute("usuario") Usuario resetPassword, @RequestParam("newPassword") String newPassword) {
		ModelMap modelo = new ModelMap();
		
		if(resetPassword.getEmail() == "" || resetPassword.getPassword() == "" || newPassword == "") {
			modelo.put("msg", "Debes rellenar los campos.");
			return new ModelAndView("resetPassword", modelo);
		}
		
		Usuario usuario = servicioUsuario.consultarUsuarioPorEmailYPassword(resetPassword);
		String hashedPassword = DigestUtils.md5Hex(newPassword);
		
		if(usuario != null) {
			
			if(!hashedPassword.equals(usuario.getPassword())) 
			{
				usuario.setPassword(newPassword);
				servicioUsuario.actualizarPasswordUsuario(usuario);
				modelo.put("msg", "Contraseña cambiada correctamente.");
				
			}else {
				modelo.put("msg", "La contraseña no pueden ser las mismas.");
			}
				
		}else {
			modelo.put("msg", "Los datos ingresados son incorrectos.");
		}
		
		return new ModelAndView("resetPassword", modelo);
	}
}
