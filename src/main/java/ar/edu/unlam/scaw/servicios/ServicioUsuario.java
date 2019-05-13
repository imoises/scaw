package ar.edu.unlam.scaw.servicios;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface ServicioUsuario {
	public Usuario buscarUsuarioXIdSERVICE(int id);
	public void agregarTextoAUsuarioSERVICE(Usuario usuario, Texto t);
	boolean agregarUsuario(Usuario usuario);
}
