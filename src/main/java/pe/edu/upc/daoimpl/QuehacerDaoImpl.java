package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IQuehacerDao;
import pe.edu.upc.entity.Quehacer;

public class QuehacerDaoImpl implements IQuehacerDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	
	@Transactional
	@Override
	public void insertar(Quehacer quehacer) {
		// TODO Auto-generated method stub
		em.persist(quehacer);

	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Quehacer> listar() {
		List<Quehacer> lista = new ArrayList<Quehacer>();
		Query q = em.createQuery("select qh from Quehacer qh");
		lista =(List<Quehacer>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idquehacer) {
		Quehacer quehacer = new Quehacer();
		quehacer = em.getReference(Quehacer.class, idquehacer);
		em.remove(quehacer);
		
	}
	
	
	
	
}
