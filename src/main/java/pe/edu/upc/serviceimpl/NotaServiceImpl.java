package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.INotaDao;
import pe.edu.upc.entity.Nota;
import pe.edu.upc.service.INotaService;

@Named
@RequestScoped
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

	@Override
	public List<Nota> listarPorNombre(String nombre) {
		return nD.listarPorNombrePersona(nombre);
	}
}
