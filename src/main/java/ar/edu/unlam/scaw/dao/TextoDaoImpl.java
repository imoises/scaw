package ar.edu.unlam.scaw.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

import java.util.List;

import javax.inject.Inject;

@Repository("TextoDao")
public class TextoDaoImpl implements TextoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void agregarTextoAUsuario(Usuario usuario, Texto texto) {
		Session session = sessionFactory.getCurrentSession();
//		texto.setUsuario(usuario);
		session.save(texto);
	}

	

}
