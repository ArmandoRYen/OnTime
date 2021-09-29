package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDeudaDao;
import pe.edu.upc.entity.Deuda;

public class DeudaDaoImpl implements IDeudaDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Deuda deuda) {
		em.persist(deuda);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deuda> listar() {
		List<Deuda> lista = new ArrayList<Deuda>(); 
		Query q = em.createQuery("select de from Deuda de");
		lista =(List<Deuda>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idDeuda) {
		Deuda deuda = new Deuda();
		deuda = em.getReference(Deuda.class, idDeuda);
		em.remove(deuda);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Deuda>listarPorNombrePersona(String nombre){
		List<Deuda>lista=new ArrayList<Deuda>();
		Query q=em.createQuery("select de from Deuda de where de.persona.nombrePersona like ?1");
		q.setParameter(1,"%"+nombre+"%");
		lista=(List<Deuda>) q.getResultList();
		return lista;
	}

}
