package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IPersona;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;

public class PersonaServiceImpl implements IPersonaService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersona pD;

	@Override
	public void insertar(Persona persona) {
		pD.insertar(persona);
		
	}

	@Override
	public List<Persona> listar() {
	
		return pD.listar();
	}

	@Override
	public void eliminar(int idPersona) {
		pD.eliminar(idPersona);
		
	}

}
