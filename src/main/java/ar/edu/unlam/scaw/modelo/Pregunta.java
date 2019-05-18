package ar.edu.unlam.scaw.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pregunta;
	
	@ManyToMany(mappedBy = "preguntas")
    private List<Seguridad> seguridad = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Seguridad> getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(List<Seguridad> seguridad) {
		this.seguridad = seguridad;
	}
	
	
	
}
