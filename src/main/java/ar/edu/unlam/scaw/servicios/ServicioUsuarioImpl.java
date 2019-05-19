package ar.edu.unlam.scaw.servicios;

import javax.inject.Inject;

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

}
