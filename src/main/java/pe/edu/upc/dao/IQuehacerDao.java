package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Quehacer;

public interface IQuehacerDao {
	public void insertar (Quehacer quehacer);
	public List<Quehacer> listar();
	public void eliminar(int idquehacer);
	
	
}
