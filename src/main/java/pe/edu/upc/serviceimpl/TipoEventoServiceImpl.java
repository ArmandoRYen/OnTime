package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoEvento;
import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

public class TipoEventoServiceImpl implements ITipoEventoService{
	
	@Inject
	private ITipoEvento mD;

	@Override
	public void insertar(TipoEvento tipoevento) {
		mD.insertar(tipoevento);
		
	}

	@Override
	public List<TipoEvento> listar() {
	
		return mD.listar();
	}

	@Override
	public void eliminar(int idTipoevento) {
		mD.eliminar(idTipoevento);
		
	}

}
