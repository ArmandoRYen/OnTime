package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.INotificacionDao;
import pe.edu.upc.entity.Notificacion;
import pe.edu.upc.service.INotificacionService;

public class NotificacionServiceImpl implements INotificacionService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private INotificacionDao ntD;

	@Override
	public void insertar(Notificacion notificacion) {
		ntD.insertar(notificacion);		
	}

	@Override
	public List<Notificacion> listar() {
		return ntD.listar();
	}

	@Override
	public void eliminar(int idNotificacion) {
		ntD.eliminar(idNotificacion);		
	}

}
