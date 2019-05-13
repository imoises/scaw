package ar.edu.unlam.scaw.servicios;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioAdmin {

	List<Usuario> consultarUsuarios();

	Usuario consultarUsuario(Usuario usuario);
	
	void habilitarUsuario(Usuario usuario);
}
