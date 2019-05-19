package ar.edu.unlam.scaw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.scaw.modelo.Pregunta;
import ar.edu.unlam.scaw.modelo.Seguridad;
import ar.edu.unlam.scaw.modelo.Usuario;

@Repository("SeguridadDao")
public class SeguridadDaoImpl implements SeguridadDao{

	@Override
	public List<Seguridad> seguridades(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> preguntas(Seguridad s) {
		// TODO Auto-generated method stub
		return null;
	}

}
