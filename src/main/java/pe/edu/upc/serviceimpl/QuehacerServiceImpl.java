package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.entity.Quehacer;
import pe.edu.upc.service.IQuehacer;

public class QuehacerServiceImpl implements IQuehacer, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IQuehacer qD;
	
	@Override
	public void insertar(Quehacer quehacer) {
		// TODO Auto-generated method stub
		qD.insertar(quehacer);
	}

	@Override
	public List<Quehacer> listar() {
		// TODO Auto-generated method stub
		return qD.listar();
	}

	@Override
	public void eliminar(int idQuehacer) {
		// TODO Auto-generated method stub
		qD.eliminar(idQuehacer);
	}

}
