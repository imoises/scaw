package ar.edu.unlam.scaw.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.scaw.dao.SeguridadDao;
import ar.edu.unlam.scaw.dao.UsuarioDao;
import ar.edu.unlam.scaw.modelo.ModeloRegistrarse;
import ar.edu.unlam.scaw.modelo.Pregunta;
import ar.edu.unlam.scaw.modelo.Seguridad;
import ar.edu.unlam.scaw.modelo.Usuario;

@Service("servicioRegistrarUsuario")
@Transactional
public class ServicioRegistrarUsuarioImpl implements ServicioRegistrarUsuario{

	@Inject
	private UsuarioDao usuarioDao;	
	@Inject
	private SeguridadDao seguridadDao;
	
	@Override
	public boolean validarUsuarioARegistrar(ModeloRegistrarse mr) {
		
		if(mr.getNickname().isEmpty() ||
		   mr.getNombre().isEmpty() ||
		   mr.getApellido().isEmpty() ||
		   mr.getEmail().isEmpty() ||
		   mr.getPassword().isEmpty() ||
		   mr.getConfirmaPassword().isEmpty() ||
		   mr.getPregunta().isEmpty() ||
		   mr.getRespuesta().isEmpty() ||
		   mr.getConfirmaRespusta().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void registatUsuario(ModeloRegistrarse mr) {
		
		Usuario u = new Usuario();
		u.setNickname(mr.getNickname());
		u.setNombre(mr.getNombre());
		u.setApellido(mr.getApellido());
		u.setEmail(mr.getEmail());
		u.setPassword(mr.getPassword());
		u.setRol("usuario");
		u.setEstado("deshabilitado");
		
		Seguridad s = new Seguridad();
		s.setRespuesta(mr.getRespuesta());
		
		Pregunta p = new Pregunta();
		p.setPregunta(mr.getPregunta());
	
	}
	
	

}
