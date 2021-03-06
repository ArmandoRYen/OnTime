package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.TipoEvento;

public interface ITipoEventoDao {
	public void insertar(TipoEvento tipoevento);
	public List<TipoEvento>listar();
	public void eliminar(int idTipoevento);
	List<TipoEvento> listarPorNombrePersona(String nombre);
	
}
