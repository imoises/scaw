package ar.edu.unlam.scaw.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.TextoDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{
	
	@Inject
	private UsuarioDao servicioUsuarioDao;
	
	@Inject
	private TextoDao textoDao;
	
	@Override
	public void agregarTextoAUsuarioSERVICE(Usuario u,Texto t) {
		textoDao.agregarTextoAUsuario(u, t);
		
	}

	@Override
	public Usuario buscarUsuarioXIdSERVICE(int id) {
		return servicioUsuarioDao.buscarUsuarioXId(id);
	}
	
	@Override
	public boolean registrarUsuario(Usuario usuario) {
		Usuario usuarioExistente = servicioUsuarioDao.buscarUsuarioPorEmail(usuario.getEmail());
		if(usuarioExistente == null) {
			if(!servicioUsuarioDao.existeUsername(usuario)) {
				Usuario usuarioNuevo = usuario;
				usuarioNuevo.setRol("usuario");
				usuarioNuevo.setEstado("deshabilitado");
				servicioUsuarioDao.insertUsuario(usuarioNuevo);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateUsuario(Usuario usuario) {
		servicioUsuarioDao.updateUsuario(usuario);
	}
	
	
	@Override
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario) {
		return servicioUsuarioDao.consultarUsuarioPorEmailYPassword(usuario);
	}
	
	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return servicioUsuarioDao.buscarUsuarioPorEmail(email);
	}
	
	@Override
	public String envioEmail(String destinatario, String asunto, String cuerpo)
	{
		String remitente = "tallerwebtp";  
		
	    java.util.Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "tallerweb123");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "tallerweb123");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	        return "Error en el envio.";
	    }
	    
		return "La nueva contraseña se envió correctamente!";
	}

}
