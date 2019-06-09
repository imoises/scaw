package ar.edu.unlam.scaw.servicios;

import ar.edu.unlam.scaw.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
	
	public Usuario consultarUsuarioPorNickname(String nickname);
	
	public Usuario buscarUsuarioPorEmail(String email);
}
