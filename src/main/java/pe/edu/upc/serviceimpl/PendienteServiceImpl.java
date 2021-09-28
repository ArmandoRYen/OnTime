package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPendienteDao;
import pe.edu.upc.service.IPendienteService;
import pe.edu.upc.entity.Pendiente;

@Named
@RequestScoped
public class PendienteServiceImpl implements IPendienteService, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IPendienteDao pD;
	
	@Override
	public void insertar(Pendiente pendiente) {
		pD.insertar(pendiente);
	}

	@Override
	public List<Pendiente> listar() {
		return pD.listar();
	}

	@Override
	public void eliminar(int idPendiente) {
		pD.eliminar(idPendiente);
	}


}
