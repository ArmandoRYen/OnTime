package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IEstadoDao;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.service.IEstadoService;

public class EstadoServiceImpl implements IEstadoService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEstadoDao esD;

	@Override
	public void insertar(Estado estado) {
		esD.insertar(estado);		
	}

	@Override
	public List<Estado> listar() {
		return esD.listar();
	}

	@Override
	public void eliminar(int idEstado) {
		esD.eliminar(idEstado);		
	}

}
