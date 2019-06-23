package ar.edu.unlam.scaw.servicios;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface ServicioActividad {
	public void registarActividad(Actividad a);
	public List<Actividad> listarActividadesXUsuario(Usuario u);
	void deleteActividad(Usuario usuario);
}
