package ar.edu.unlam.scaw.dao;

import ar.edu.unlam.scaw.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
}
