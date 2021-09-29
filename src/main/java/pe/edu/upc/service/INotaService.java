package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Nota;

public interface INotaService {
	public void insertar(Nota nota);
	public List<Nota> listar();
	public void eliminar(int idNota);
	List<Nota> listarPorNombre(String nombre);
}
