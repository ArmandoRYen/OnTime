package pe.edu.upc.daoimpl;

import pe.edu.upc.entity.TipoQuehacer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITipoQuehacerDao;

public class TipoQuehacerDaoimpl implements ITipoQuehacerDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pu")
	private EntityManager em;
	@Override
	public void Insertar(TipoQuehacer tipoquehacer) {
		// TODO Auto-generated method stub
		em.persist(tipoquehacer);
	}
	@Transactional
	@Override
	public void Eliminar(int idtipoquehacer) {
		// TODO Auto-generated method stub
		TipoQuehacer tipoquehacer = new TipoQuehacer();
		tipoquehacer = em.getReference(TipoQuehacer.class, idtipoquehacer);
		em.remove(tipoquehacer);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoQuehacer> listar() {
		// TODO Auto-generated method stub
		List <TipoQuehacer> lista = new ArrayList<TipoQuehacer>();
		Query q = em.createQuery("select m from TipoQuehacer m");
		lista = (List<TipoQuehacer>) q.getResultList();
		return lista;
	}
	

}
