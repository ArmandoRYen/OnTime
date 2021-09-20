package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Prueba;

public interface IPruebaService {
	public void insertar(Prueba prueba);
	public List<Prueba> listar();
	public void eliminar(int idPrueba);
}
