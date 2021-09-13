package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoNota;
import pe.edu.upc.entity.TipoNota;
import pe.edu.upc.service.ITipoNotaService;

public class TipoNotaServiceImpl implements ITipoNotaService {
	
	@Inject
	private ITipoNota mD;

	@Override
	public void insertar(TipoNota tiponota) {
		mD.insertar(tiponota);
		
	}

	@Override
	public List<TipoNota> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTiponota) {
		mD.eliminar(idTiponota);
		
	}
	

}
