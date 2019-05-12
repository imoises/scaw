package ar.edu.unlam.scaw.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.scaw.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String rol;
	private String estado;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Actividad> actividad = new ArrayList<Actividad>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Texto> texto = new ArrayList<Texto>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Actividad> getActividad() {
		return actividad;
	}
	
	public void setActividad(List<Actividad> actividad) {
		this.actividad = actividad;
	}	

	public List<Texto> getTexto() {
		return texto;
	}
	
	public void setTexto(List<Texto> texto) {
		this.texto = texto;
	}	
}
