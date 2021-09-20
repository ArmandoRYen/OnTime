package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Evento;

public interface IEventoDao {
	public void insertar (Evento evento);
	public List<Evento> listar();
	public void eliminar(int idEvento);

}
