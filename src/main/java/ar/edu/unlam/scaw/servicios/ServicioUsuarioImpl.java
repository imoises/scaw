package ar.edu.unlam.scaw.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.TextoDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

@Service("servicioRegistrarse")
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
	public boolean agregarUsuario(Usuario usuario) {
		List<Usuario> miUsuario = servicioUsuarioDao.buscarUsuarioPorEmail(usuario);
		if(miUsuario.size() == 0) {
			Usuario userpro = usuario;
			userpro.setRol("usuario");
			userpro.setEstado("deshabilitado");
			servicioUsuarioDao.insertUsuario(userpro);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void updateUsuario(Usuario usuario) {
		servicioUsuarioDao.updateUsuario(usuario);
	}
	
	
	@Override
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario) {
		return servicioUsuarioDao.consultarUsuarioPorEmailYPassword(usuario);
	}

}
