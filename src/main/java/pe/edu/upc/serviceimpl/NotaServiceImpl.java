package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.INotaDao;
import pe.edu.upc.entity.Nota;
import pe.edu.upc.service.INotaService;

public class NotaServiceImpl implements INotaService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private INotaDao nD;

	@Override
	public void insertar(Nota nota) {
		nD.insertar(nota);		
	}

	@Override
	public List<Nota> listar() {
		return nD.listar();
	}

	@Override
	public void eliminar(int idNota) {
		nD.eliminar(idNota);		
	}

}
