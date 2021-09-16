package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Quehacer;

public interface IQuehacer {
	public void insertar(Quehacer quehacer);
	public List<Quehacer> listar();
	public void eliminar(int idQuehacer);
	
	
}
