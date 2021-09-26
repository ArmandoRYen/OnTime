package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoEventoDao;
import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

public class TipoEventoServiceImpl implements ITipoEventoService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoEventoDao teD;

	@Override
	public void insertar(TipoEvento tipoevento) {
		teD.insertar(tipoevento);
		
	}

	@Override
	public List<TipoEvento> listar() {
	
		return teD.listar();
	}
	
	@Override
	public List<TipoEvento> listarPorNombre(String nombre) {
		return teD.listarPorNombrePersona(nombre);
	}

	@Override
	public void eliminar(int idTipoevento) {
		teD.eliminar(idTipoevento);
		
	}

}
