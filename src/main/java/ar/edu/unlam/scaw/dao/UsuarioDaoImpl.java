package ar.edu.unlam.scaw.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.scaw.modelo.Usuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("UsuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nickname", usuario.getNickname()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}
	
	@Override
	public void insertUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}
	
	@Override
	public Usuario consultarUsuarioPorNickname(String nickname) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nickname", nickname))
				.uniqueResult();
	}
	
	@Override
	public List<Usuario> consultarUsuariosInactivos() {
		
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> usuarios = (List<Usuario>) session.createCriteria(Usuario.class)
				.add(Restrictions.isNotNull("fecha_inactivo"))
				.list();
		return usuarios;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}
	
	@Override
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> consultarUsuarios() {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario para traer los que tengan rol user
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> usuarios = (List<Usuario>) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("rol", "usuario"))
				.list();
		return usuarios;
	}
	
	@Override
	public void habilitarUsuario(int idUsuario) {

		final Session session = sessionFactory.getCurrentSession();
        
		Query q = session.createQuery("from Usuario u where u.id = :idUsuario ");
		q.setParameter("idUsuario", idUsuario);
		Usuario user = (Usuario)q.list().get(0);

		user.setEstado("habilitado");
		user.setFechaInactivo(null);
		session.update(user);
	}
	
	@Override
	public void deshabilitarUsuario(int idUsuario) {

		final Session session = sessionFactory.getCurrentSession();
        
		Query q = session.createQuery("from Usuario u where u.id = :idUsuario ");
		q.setParameter("idUsuario", idUsuario);
		Usuario user = (Usuario)q.list().get(0);

		user.setEstado("deshabilitado");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateFormat.format(new Date());
		
		try {
			Date date1 = dateFormat.parse(fecha);
			user.setFechaInactivo(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		session.update(user);
	}
	
	@Override
	public void updateUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}
	
	@Override
	public void deleteUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().delete(usuario);
	}

	@Override
	public Usuario buscarUsuarioXId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Usuario.class, id);
	}
	

	@Override
	public boolean existeUsername(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		Usuario usuarioEncontrado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nickname", usuario.getNickname()))
				.uniqueResult();
		return (usuarioEncontrado != null);
	}
	
	

}
