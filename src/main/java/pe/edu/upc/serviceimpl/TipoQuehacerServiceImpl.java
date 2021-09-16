package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoQuehacerDao;
import pe.edu.upc.entity.TipoQuehacer;
import pe.edu.upc.service.ITipoQuehacerService;

public class TipoQuehacerServiceImpl implements ITipoQuehacerService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoQuehacerDao tqD;
	
	@Override
	public void Insertar(TipoQuehacer tipoquehacer) {
		// TODO Auto-generated method stub
		tqD.Insertar(tipoquehacer);
	}

	@Override
	public void Eliminar(int idtipoquehacer) {
		// TODO Auto-generated method stub
		tqD.Eliminar(idtipoquehacer);
	}

	@Override
	public List<TipoQuehacer> listar() {
		// TODO Auto-generated method stub
		tqD.listar();
		return null;
	}
		
}