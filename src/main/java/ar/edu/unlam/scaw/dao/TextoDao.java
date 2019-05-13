package ar.edu.unlam.scaw.dao;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface TextoDao {
	public void agregarTextoAUsuario(Usuario u, Texto t);
}
