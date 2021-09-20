package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPruebaDao;
import pe.edu.upc.entity.Prueba;

public class PruebaDaoImpl implements IPruebaDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Prueba prueba) {
		em.persist(prueba);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prueba> listar() {
		List<Prueba> lista = new ArrayList<Prueba>(); 
		Query q = em.createQuery("select pr from Prueba pr");
		lista =(List<Prueba>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPrueba) {
		Prueba prueba = new Prueba();
		prueba = em.getReference(Prueba.class, idPrueba);
		em.remove(prueba);
	}

}
