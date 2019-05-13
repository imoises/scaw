package ar.edu.unlam.scaw.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String rol;
	private String estado;

//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private List<Actividad> actividad = new ArrayList<Actividad>();
//	
//	@OneToMany(mappedBy = "usuario")
//	private List<Texto> texto = new ArrayList<Texto>();
//	
//	@OneToMany(mappedBy="usuario")
//	private List<PreguntaRecuperacion> preguntas = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		this.password = DigestUtils.md5Hex(password);
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
	
//	public List<Actividad> getActividad() {
//		return actividad;
//	}
//	
//	public void setActividad(List<Actividad> actividad) {
//		this.actividad = actividad;
//	}	
//
//	public List<Texto> getTexto() {
//		return texto;
//	}
//	
//	public void setTexto(List<Texto> texto) {
//		this.texto = texto;
//	}	
}
