package ar.edu.unlam.scaw.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.Usuario;

@Service("servicioRegistrarse")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private UsuarioDao servicioUsuarioDao;
	
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

	
}
