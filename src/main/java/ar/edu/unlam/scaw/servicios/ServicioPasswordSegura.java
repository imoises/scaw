package ar.edu.unlam.scaw.servicios;

import java.io.IOException;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface ServicioPasswordSegura {
	Boolean isACommonPassword(String password) throws IOException;
	
	PasswordEncoder passwordEncoder();
}
