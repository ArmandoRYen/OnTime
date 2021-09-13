package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.TipoNota;

public interface ITipoNota {
	public void insertar (TipoNota tiponota);
	public List<TipoNota> listar();
	public void eliminar(int idTiponota);

}
