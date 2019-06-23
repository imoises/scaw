package ar.edu.unlam.scaw.controladores;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

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

@Controller
public class ControladorForgotPassword {
	
	public final static Logger logger = Logger.getLogger(ControladorForgotPassword.class);
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioPasswordSegura servicioPasswordSegura;
	
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
		try{	
			if(forgotPassword.getEmail() == "") {
				modelo.put("msg", "Debes rellenar los campos.");
				return new ModelAndView("forgotPassword", modelo);
			}
			
			Usuario usuario = servicioUsuario.buscarUsuarioPorEmail(forgotPassword.getEmail());
			
			if(usuario != null) {
				
				String randomCharacters = randomString(12);
				String hashedPassword = servicioPasswordSegura.passwordEncoder().encode(randomCharacters);
				
				usuario.setPassword(hashedPassword);
				
				String destinatario =  usuario.getEmail();
			    String asunto = "Recupero de contraseña";
			    String cuerpo = "Nueva contraseña: " + randomCharacters;
				String value = servicioUsuario.envioEmail(destinatario, asunto, cuerpo);
				
				usuario.setFechaUltimoCambioPass(new Timestamp(System.currentTimeMillis()));
	        	
				servicioUsuario.updateUsuario(usuario);
				modelo.put("msg", value);
	
			}else {
				String msj = "Los datos ingresados son incorrectos.";
				modelo.put("msg", msj);
				logger.info(msj);
			}
		
		}catch(Exception e){
			logger.error("Error en ForgotPassword", e);
		}
		
		
		return new ModelAndView("forgotPassword", modelo);
	}
	
}
