package ar.edu.unlam.scaw.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.ActividadDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("ServicioActividad")
@Transactional
public class ServicioActividadImpl implements ServicioActividad {

	@Inject
	private ActividadDao actividadDao;
	
	@Override
	public void registarActividad (Actividad a) {
		actividadDao.crearActividad(a);
	}
	
	@Override
	public void deleteActividad (Usuario usuario) {
		actividadDao.deleteActividad(usuario);
	}

	@Override
	public List<Actividad> listarActividadesXUsuario(Usuario u) {
		return actividadDao.listaActividadesXUsuario(u);
	}

}
