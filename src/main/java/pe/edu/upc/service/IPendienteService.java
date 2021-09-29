package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Pendiente;

public interface IPendienteService {
	public void insertar(Pendiente pendiente);
	public List<Pendiente> listar();
	public void eliminar(int idpendiente);
	List<Pendiente> listarPorNombre(String nombre);
}
