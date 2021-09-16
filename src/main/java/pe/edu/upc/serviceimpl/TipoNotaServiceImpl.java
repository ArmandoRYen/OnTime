package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoNota;
import pe.edu.upc.entity.TipoNota;
import pe.edu.upc.service.ITipoNotaService;

public class TipoNotaServiceImpl implements ITipoNotaService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoNota tnD;

	@Override
	public void insertar(TipoNota tiponota) {
		tnD.insertar(tiponota);
		
	}

	@Override
	public List<TipoNota> listar() {
		return tnD.listar();
	}

	@Override
	public void eliminar(int idTiponota) {
		tnD.eliminar(idTiponota);
		
	}
	

}
