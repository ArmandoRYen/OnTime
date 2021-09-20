package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IFotoDao;
import pe.edu.upc.entity.Foto;

public class FotoDaoImpl implements IFotoDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Foto foto) {
		em.persist(foto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> listar() {
		List<Foto> lista = new ArrayList<Foto>(); 
		Query q = em.createQuery("select ft from Foto ft");
		lista =(List<Foto>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idFoto) {
		Foto foto = new Foto();
		foto = em.getReference(Foto.class, idFoto);
		em.remove(foto);
	}

}
