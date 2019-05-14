package ar.edu.unlam.scaw.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Texto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;
	
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="ID_USUARIO")
    private Usuario usuario;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
//	public void setUsuario(Usuario usuario){
//		this.usuario = usuario;
//	}
//	public Usuario getUsuario(){
//		return usuario;
//	}
	
}
