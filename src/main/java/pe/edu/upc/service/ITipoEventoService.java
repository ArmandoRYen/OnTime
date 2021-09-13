package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.TipoEvento;

public interface ITipoEventoService {
	public void insertar (TipoEvento tipoevento);
	public List<TipoEvento> listar();
	public void eliminar (int idTipoevento);

}
