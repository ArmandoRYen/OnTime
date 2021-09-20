package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IPendienteDao;
import pe.edu.upc.service.IPendienteService;
import pe.edu.upc.entity.Pendiente;

public class PendienteServiceImpl implements IPendienteService, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IPendienteDao pD;
	
	@Override
	public void insertar(Pendiente pendiente) {
		// TODO Auto-generated method stub
		pD.insertar(pendiente);
	}

	@Override
	public List<Pendiente> listar() {
		// TODO Auto-generated method stub
		return pD.listar();
	}

	@Override
	public void eliminar(int idPendiente) {
		// TODO Auto-generated method stub
		pD.eliminar(idPendiente);
	}


}
