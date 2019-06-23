package ar.edu.unlam.scaw.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.controladores.ControladorLogin;
import ar.edu.unlam.scaw.dao.TextoDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;
import ar.edu.unlam.scaw.servicios.ServicioPasswordSegura;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{

	public final static Logger logger = Logger.getLogger(ServicioUsuarioImpl.class);
	
	@Inject
	private UsuarioDao servicioUsuarioDao;
	
	@Inject
	private TextoDao textoDao;
	
	@Inject
	private ServicioPasswordSegura servicioPasswordSegura;
	
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
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = dateFormat.format(new Date());
				
				try {
					Date date1 = dateFormat.parse(fecha);
					usuarioNuevo.setFechaInactivo(date1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				String password = servicioPasswordSegura.passwordEncoder().encode(usuarioNuevo.getPassword());
				usuarioNuevo.setPassword(password);
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
	public void deleteUsuario(Usuario usuario) {
		servicioUsuarioDao.deleteUsuario(usuario);
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
        logger.info("Envio de email");
		String remitente = "tallerwebtp";  
		
	    java.util.Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "tallerweb123");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticaci�n mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podr�an a�adir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "tallerweb123");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	        logger.error(me);
	        return "Error en el envio.";
	    }

        logger.info("Envio de email correcto");
		return "La nueva contrase�a se envi� correctamente!";
	}

}
