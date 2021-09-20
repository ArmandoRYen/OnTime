package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Notificacion;

public interface INotificacionService {
	public void insertar(Notificacion notificacion);
	public List<Notificacion> listar();
	public void eliminar(int idNotificacion);
}
