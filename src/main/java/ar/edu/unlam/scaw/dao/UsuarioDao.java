package ar.edu.unlam.scaw.dao;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {

	Usuario consultarUsuario (Usuario usuario);

	List<Usuario> consultarUsuarios();

	void habilitarUsuario(int idUsuario);
	
	void deshabilitarUsuario(int idUsuario);

	public Usuario buscarUsuarioXId(int id);

	void insertUsuario(Usuario usuario);
	
	public Usuario buscarUsuarioPorEmail(String email);
	
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario);

	void updateUsuario(Usuario usuario);
	
	public boolean existeUsername(Usuario usuario);

	Usuario consultarUsuarioPorNickname(String nickname);

}
