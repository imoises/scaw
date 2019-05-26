package ar.edu.unlam.scaw.servicios;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface ServicioUsuario {
	public Usuario buscarUsuarioXIdSERVICE(int id);
	public void agregarTextoAUsuarioSERVICE(Usuario usuario, Texto t);
	boolean registrarUsuario(Usuario usuario);
	public Usuario consultarUsuarioPorEmailYPassword(Usuario usuario);
	public Usuario buscarUsuarioPorEmail(String email);
	void updateUsuario(Usuario usuario);
	String envioEmail(String destinatario, String asunto, String cuerpo);
}
