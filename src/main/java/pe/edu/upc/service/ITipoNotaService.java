package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.TipoNota;

public interface ITipoNotaService {
	public void insertar(TipoNota tiponota);
	public List<TipoNota> listar();
	public void eliminar(int idTiponota);

}
