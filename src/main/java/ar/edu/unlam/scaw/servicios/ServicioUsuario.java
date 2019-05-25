package ar.edu.unlam.scaw.servicios;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface ServicioUsuario {
	public Usuario buscarUsuarioXIdSERVICE(int id);
	public void agregarTextoAUsuarioSERVICE(Usuario usuario, Texto t);
	boolean agregarUsuario(Usuario usuario);
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario);
	List<Usuario> buscarUsuarioPorEmail(Usuario usuario);
	void updateUsuario(Usuario usuario);
	String envioEmail(String destinatario, String asunto, String cuerpo);
}
