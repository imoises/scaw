package ar.edu.unlam.scaw.modelo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private Timestamp fecha;
	
	//para el mapeo con la entity Usuario
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="ID_USUARIO")	
    private Usuario usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public String getDescripcion(){
		return descripcion;
	}
	
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	public Usuario getUsuario(){
		return usuario;
	}
	
	
}
