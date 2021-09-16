package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IEvento;
import pe.edu.upc.entity.Evento;
import pe.edu.upc.service.IEventoService;

public class EventoServiceImpl implements IEventoService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEvento evD;

	@Override
	public void insertar(Evento evento) {
		evD.insertar(evento);		
	}

	@Override
	public List<Evento> listar() {
		return evD.listar();
	}

	@Override
	public void eliminar(int idEvento) {
		evD.eliminar(idEvento);		
	}

}
