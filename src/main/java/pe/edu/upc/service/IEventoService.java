package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Evento;

public interface IEventoService {
	public void insertar(Evento evento);
	public List<Evento> listar();
	public void eliminar(int idEvento);
	List<Evento> listarPorNombre(String nombre);
}
