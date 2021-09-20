package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPruebaDao;
import pe.edu.upc.entity.Prueba;
import pe.edu.upc.service.IPruebaService;

@Named
@RequestScoped
public class PruebaServiceImpl implements IPruebaService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPruebaDao prD;

	@Override
	public void insertar(Prueba prueba) {
		prD.insertar(prueba);		
	}

	@Override
	public List<Prueba> listar() {
		return prD.listar();
	}

	@Override
	public void eliminar(int idPrueba) {
		prD.eliminar(idPrueba);		
	}

}
