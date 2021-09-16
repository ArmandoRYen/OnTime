package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IEstado;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.service.IEstadoService;

public class EstadoServiceImpl implements IEstadoService {
	
	@Inject
	private IEstado mD;

	@Override
	public void insertar(Estado estado) {
		mD.insertar(estado);		
	}

	@Override
	public List<Estado> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idEstado) {
		mD.eliminar(idEstado);		
	}

}
