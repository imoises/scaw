package ar.edu.unlam.scaw.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.runners.Parameterized.Parameter;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	
	@NotBlank(message = "Nickname es requerido.")
	private String nickname;
	@NotBlank(message = "Nombre es requerido.")
	private String nombre;
	@NotBlank(message = "Apellido es requerido.")
	private String apellido;
	@Column(unique = true)
	@Email
	@NotBlank(message = "Email es requerido.")
	private String email;
	@NotNull
	@Size(min = 12, max = 30,message = "Contraseña debe ser de una longitud mayor 12.")
	@NotBlank(message = "Contraseña es requerido.")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])$",message="La contraseña debe tener al menos un dígito, al menos una minúscula ,al menos un caracter especial y al menos una mayúscula.")
	private String password;
//	@NotBlank(message = "La confirmacion de la contraseña es requerido.")
//	@Valid
//	private String cpassword;
	private String rol;
	private String estado;
	
	

	@OneToMany(mappedBy="u")
	private List<Seguridad> listaSeg = new ArrayList<>(); 
	
	
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
		this.password = password;
	}
//	public String getCpassword() {
//		return cpassword;
//	}
//
//	public void setCpassword(String cpassword) {
//		this.cpassword = cpassword;
//	}

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
