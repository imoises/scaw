package ar.edu.unlam.scaw.dao;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Pregunta;
import ar.edu.unlam.scaw.modelo.Seguridad;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface SeguridadDao {
	List<Seguridad> seguridades(Usuario u);
	
	List<Pregunta> preguntas(Seguridad s);
}
