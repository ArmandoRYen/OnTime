package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Nota;

public interface INota {
	public void insertar (Nota nota);
	public List<Nota> listar();
	public void eliminar(int idNota);

}
