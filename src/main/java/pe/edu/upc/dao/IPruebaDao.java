package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Prueba;

public interface IPruebaDao {
	public void insertar(Prueba prueba);
	public List<Prueba> listar();
	public void eliminar(int idPrueba);
	public List<Prueba> listarPorNombrePersona(String nombre);
}
