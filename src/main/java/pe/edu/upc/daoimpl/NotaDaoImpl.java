package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.INota;
import pe.edu.upc.entity.Nota;

public class NotaDaoImpl implements INota, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Nota nota) {
		em.persist(nota);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nota> listar() {
		List<Nota> lista = new ArrayList<Nota>(); 
		Query q = em.createQuery("select no from Nota no");
		lista =(List<Nota>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idNota) {
		Nota nota = new Nota();
		nota = em.getReference(Nota.class, idNota);
		em.remove(nota);
	}

}
