package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPersonaDao;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;

@Named
@RequestScoped
public class PersonaServiceImpl implements IPersonaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPersonaDao pD;

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

	@Override
	public Persona comprobarLogin(Persona persona) {
		List<Persona> personas = pD.listarLogin(persona);
		System.out.println("Personas: " + personas.size());
		if(personas.isEmpty()) return null;
		else return personas.get(0);
		
	}

}
