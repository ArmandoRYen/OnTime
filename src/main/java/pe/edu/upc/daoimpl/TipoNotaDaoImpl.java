package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoNota;
import pe.edu.upc.entity.TipoNota;

public class TipoNotaDaoImpl implements ITipoNota {

	@PersistenceContext(unitName="pu")
	private EntityManager em;
	@Override
	public void insertar(TipoNota tiponota) {
		em.persist(tiponota);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoNota> listar() {
		List<TipoNota> lista = new ArrayList<TipoNota>();
		Query q = em.createQuery("select m from TipoNota m");
		lista = (List<TipoNota>) q.getResultList();
		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idTiponota) {
		TipoNota tiponot = new TipoNota();
		tiponot= em.getReference(TipoNota.class, idTiponota);
		em.remove(tiponot);
		
	}

}
