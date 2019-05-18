				package ar.edu.unlam.scaw.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Seguridad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String respuesta;	
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")	
	private Usuario u;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "SEGURIDAD_PREGUNTA", 
        joinColumns = { @JoinColumn(name = "ID_SEGURIDAD") }, 
        inverseJoinColumns = { @JoinColumn(name = "ID_PREGUNTA") }
    )
    List<Pregunta> preguntas = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public void setUsuario(Usuario u){
		this.u = u;
	}
	public Usuario getUsuario(){
		return u;
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
}

