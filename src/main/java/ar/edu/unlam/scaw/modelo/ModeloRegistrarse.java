package ar.edu.unlam.scaw.modelo;

public class ModeloRegistrarse {
	
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String confirmaPassword;
	private String pregunta;
	private String respuesta;
	private String confirmaRespusta;
	
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
	public String getConfirmaPassword() {
		return confirmaPassword;
	}
	public void setConfirmaPassword(String confirmaPassword) {
		this.confirmaPassword = confirmaPassword;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getConfirmaRespusta() {
		return confirmaRespusta;
	}
	public void setConfirmaRespusta(String confirmaRespusta) {
		this.confirmaRespusta = confirmaRespusta;
	}
	
}
