package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Deuda;

public interface IDeudaService {
	public void insertar(Deuda deuda);
	public List<Deuda> listar();
	public void eliminar(int idDeuda);
}
