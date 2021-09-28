package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Pendiente;

public interface IPendienteDao {
	public void insertar (Pendiente pendiente);
	public List<Pendiente> listar();
	public void eliminar(int idpendiente);	
}
