package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITipoEventoDao;
import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

@Named
@RequestScoped
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

	@Override
	public List<TipoEvento> findByName(TipoEvento tipoevento) {
		// TODO Auto-generated method stub
		return null;
	}

}
