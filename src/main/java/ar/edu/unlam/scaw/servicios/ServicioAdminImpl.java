package ar.edu.unlam.scaw.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.ActividadDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioAdmin")
@Transactional
public class ServicioAdminImpl implements ServicioAdmin {

	@Inject
	private UsuarioDao servicioAdminDao;
	
	@Inject
	private ActividadDao servicioActividadDao;

	@Override
	public Usuario consultarUsuario (Usuario usuario) {
		return servicioAdminDao.consultarUsuario(usuario);
	}
	
	@Override
	public List<Usuario> consultarUsuarios() {
		return servicioAdminDao.consultarUsuarios();
	}
	
	@Override
	public void deleteUsuariosInactivosPorPeriodo() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Usuario> usuarios = servicioAdminDao.consultarUsuariosInactivos();	
		
		String today = dateFormat.format(new Date());
		
		try {
			Date date1 = dateFormat.parse(today);
			
			for(Usuario usuario : usuarios) {
				
				Date date = usuario.getFechaInactivo();
				
				long diffInMillies = Math.abs(date1.getTime() - date.getTime());
		    	long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    	
		    	if(diffDays > 90) {
		    		servicioActividadDao.deleteActividad(usuario);
		    		servicioAdminDao.deleteUsuario(usuario);
		    	}
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void habilitarUsuario (int idUsuario) {
		servicioAdminDao.habilitarUsuario(idUsuario);
	}
	
	@Override
	public void deshabilitarUsuario (int idUsuario) {
		servicioAdminDao.deshabilitarUsuario(idUsuario);
	}

}
