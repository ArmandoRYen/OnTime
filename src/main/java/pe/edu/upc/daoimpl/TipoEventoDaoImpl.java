package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoEvento;
import pe.edu.upc.entity.TipoEvento;

public class TipoEventoDaoImpl implements ITipoEvento {
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(TipoEvento tipoevento) {
		em.persist(tipoevento);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoEvento> listar() {
		
		List<TipoEvento> lista =new ArrayList<TipoEvento>();
		Query q =em.createQuery("select m from TipoEvento m");
		lista =(List<TipoEvento>) q.getResultList();
		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idTipoevento) {
		TipoEvento tipoe=new TipoEvento();
		tipoe=em.getReference(TipoEvento.class, idTipoevento);
		em.remove(tipoe);
		
		
	}

}
