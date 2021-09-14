package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoQuehacerDao;
import pe.edu.upc.entity.TipoQuehacer;
import pe.edu.upc.service.ITipoQuehacerService;

public class TipoQuehacerServiceImpl implements ITipoQuehacerService{

	@Inject
	private ITipoQuehacerDao mD;
	
	@Override
	public void Insertar(TipoQuehacer tipoquehacer) {
		// TODO Auto-generated method stub
		mD.Insertar(tipoquehacer);
	}

	@Override
	public void Eliminar(int idtipoquehacer) {
		// TODO Auto-generated method stub
		mD.Eliminar(idtipoquehacer);
	}

	@Override
	public List<TipoQuehacer> listar() {
		// TODO Auto-generated method stub
		mD.listar();
		return null;
	}
		
}