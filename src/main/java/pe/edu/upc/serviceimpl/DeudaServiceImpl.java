package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDeudaDao;
import pe.edu.upc.entity.Deuda;
import pe.edu.upc.service.IDeudaService;

@Named
@RequestScoped
public class DeudaServiceImpl implements IDeudaService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDeudaDao deD;

	@Override
	public void insertar(Deuda deuda) {
		deD.insertar(deuda);		
	}

	@Override
	public List<Deuda> listar() {
		return deD.listar();
	}

	@Override
	public void eliminar(int idDeuda) {
		deD.eliminar(idDeuda);		
	}
	@Override
	public List<Deuda> listarPorNombre(String nombre){
		return deD.listarPorNombrePersona(nombre);
	}
	@Override
	public List<Deuda>findbyName(Deuda d){
		return deD.find(d);
	}

}
