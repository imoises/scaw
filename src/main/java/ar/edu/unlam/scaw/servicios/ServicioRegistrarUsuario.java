package ar.edu.unlam.scaw.servicios;

import ar.edu.unlam.scaw.modelo.ModeloRegistrarse;

public interface ServicioRegistrarUsuario {
	boolean validarUsuarioARegistrar(ModeloRegistrarse mr);
	void registatUsuario(ModeloRegistrarse mr);
}
