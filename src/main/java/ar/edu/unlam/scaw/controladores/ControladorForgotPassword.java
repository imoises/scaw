package ar.edu.unlam.scaw.controladores;

import java.security.SecureRandom;
import java.util.List;

import javax.inject.Inject;

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

@Controller
public class ControladorForgotPassword {
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	// Funcion para generar caracteres random.
	String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	@RequestMapping("/forgot_password")
	public ModelAndView index()
	{
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("forgotPassword", modelo);
	}
	
	@RequestMapping(path = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("usuario") Usuario forgotPassword) {
		ModelMap modelo = new ModelMap();
		
		if(forgotPassword.getEmail() == "") {
			modelo.put("msg", "Debes rellenar los campos.");
			return new ModelAndView("forgotPassword", modelo);
		}
		
		Usuario usuario = servicioUsuario.buscarUsuarioPorEmail(forgotPassword.getEmail());
		
		if(usuario != null) {
			
			String randomCharacters = randomString(12);
			String hashedPassword = DigestUtils.md5Hex(randomCharacters); // Ver esto
			
			usuario.setPassword(randomCharacters);
			
			String destinatario =  usuario.getEmail();
		    String asunto = "Recupero de contraseña";
		    String cuerpo = "Nueva contraseña: " + randomCharacters;
			String value = servicioUsuario.envioEmail(destinatario, asunto, cuerpo);
			
			servicioUsuario.updateUsuario(usuario);
			modelo.put("msg", value);

		}else {
			modelo.put("msg", "Los datos ingresados son incorrectos.");
		}
		
		return new ModelAndView("forgotPassword", modelo);
	}
	
}
