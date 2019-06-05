package ar.edu.unlam.scaw.servicios;

import java.io.IOException;

public interface ServicioPasswordSegura {
	Boolean isACommonPassword(String password) throws IOException;
}
