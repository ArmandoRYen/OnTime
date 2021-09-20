package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Notificacion;

public interface INotificacionDao {
	public void insertar (Notificacion notificacion);
	public List<Notificacion> listar();
	public void eliminar(int idNotificacion);

}
