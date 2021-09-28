package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPendienteDao;
import pe.edu.upc.entity.Pendiente;

public class PendienteDaoImpl implements IPendienteDao, Serializable {
	
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Pendiente pendiente) {
		// TODO Auto-generated method stub
		em.persist(pendiente);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pendiente> listar() {
		List<Pendiente> lista = new ArrayList<Pendiente>();
		Query q = em.createQuery("select qh from Pendiente qh");
		lista =(List<Pendiente>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idpendiente) {
		Pendiente pendiente = new Pendiente();
		pendiente = em.getReference(Pendiente.class, idpendiente);
		em.remove(pendiente);		
	}
}
