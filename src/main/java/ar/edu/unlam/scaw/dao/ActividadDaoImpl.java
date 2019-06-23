package ar.edu.unlam.scaw.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;

@Repository("ActividadDao")
public class ActividadDaoImpl implements ActividadDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	Actividad a = new Actividad();
	
	@Override
	public void crearActividad(Actividad a) {
		sessionFactory.getCurrentSession().save(a);
		
	}

	@Override
	public List<Actividad> listaActividadesXUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Actividad> listado = session.createCriteria(Actividad.class)
							.createAlias("usuario", "u")
							.add(Restrictions.eq("u.id", usuario.getId())).list();
						
		return listado;
	}
	
	@Override
	public void deleteActividad(Usuario usuario) {
		
		final Session session = sessionFactory.getCurrentSession();
        
		Query q = session.createQuery("from Actividad a where a.usuario = :idUsuario ");
		q.setParameter("idUsuario", usuario);
		Actividad actividad = (Actividad)q.list().get(0);
		
		sessionFactory.getCurrentSession().delete(actividad);
	}

	
	

}
