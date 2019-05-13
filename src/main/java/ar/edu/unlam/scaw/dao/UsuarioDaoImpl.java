package ar.edu.unlam.scaw.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.scaw.modelo.Usuario;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuarioPorEmail(Usuario usuario) {
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.list());
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
	public void habilitarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		
		String hqlUpdate = "update Usuario u set u.estado = :estadoNuevo where u.id = :idUsuario";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		session.createQuery( hqlUpdate )
		        .setString( "estadoNuevo", "1" )
		        .setString( "idUsuario", String.valueOf(usuario.getId()))
		        .executeUpdate();
		session.close();
	}

	@Override
	public Usuario buscarUsuarioXId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Usuario.class, id);
	}

	

}
