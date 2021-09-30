package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Deuda;

public interface IDeudaDao {
	public void insertar(Deuda deuda);
	public List<Deuda> listar();
	public void eliminar(int idDeuda);
	List<Deuda>listarPorNombrePersona(String nombre);
	
}
