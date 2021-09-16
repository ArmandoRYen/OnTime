package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersona;
import pe.edu.upc.entity.Persona;

public class PersonaDaoImpl implements IPersona, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Persona persona) {
		em.persist(persona);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listar() {
		
		List<Persona> lista =new ArrayList<Persona>();
		Query q =em.createQuery("select p from Persona p");
		lista =(List<Persona>) q.getResultList();
		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPersona) {
		Persona persona=new Persona();
		persona=em.getReference(Persona.class, idPersona);
		em.remove(persona);
		
		
	}

}
