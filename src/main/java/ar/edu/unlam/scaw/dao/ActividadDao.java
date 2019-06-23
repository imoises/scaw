package ar.edu.unlam.scaw.dao;

import java.util.List;

import ar.edu.unlam.scaw.modelo.Actividad;
import ar.edu.unlam.scaw.modelo.Usuario;

public interface ActividadDao {
	public void crearActividad(Actividad a);
	public List<Actividad> listaActividadesXUsuario(Usuario u);
	public void deleteActividad(Usuario usuario);
}
