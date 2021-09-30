package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEventoDao;
import pe.edu.upc.entity.Evento;
import pe.edu.upc.service.IEventoService;

@Named
@RequestScoped
public class EventoServiceImpl implements IEventoService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEventoDao evD;

	@Override
	public void insertar(Evento evento) {
		evD.insertar(evento);		
	}

	@Override
	public List<Evento> listar() {
		return evD.listar();
	}
	
	@Override
	public List<Evento> listarPorNombre(String nombre) {
		return evD.listarPorNombrePersona(nombre);
	}

	@Override
	public void eliminar(int idEvento) {
		evD.eliminar(idEvento);		
	}

	@Override
	public List<Evento> findByName(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

}
