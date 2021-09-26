package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersonaDao;
import pe.edu.upc.entity.Persona;

public class PersonaDaoImpl implements IPersonaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Persona persona) {
		em.persist(persona);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listar() {
		List<Persona> lista = new ArrayList<Persona>();
		Query q = em.createQuery("select p from Persona p");
		lista = (List<Persona>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPersona) {
		Persona persona = new Persona();
		persona = em.getReference(Persona.class, idPersona);
		em.remove(persona);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listarLogin(Persona p) {
		List<Persona> lista = new ArrayList<Persona>();
		Query q = em
				.createQuery("select p from Persona p where p.nombrePersona like ?1 and p.contrasenaPersona like ?2");
		q.setParameter(1, "%" + p.getNombrePersona() + "%");
		q.setParameter(2, "%" + p.getcontrasenaPersona() + "%");
		lista = (List<Persona>) q.getResultList();
		return lista;
	}

}
