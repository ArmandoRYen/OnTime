package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEventoDao;
import pe.edu.upc.entity.Evento;

public class EventoDaoImpl implements IEventoDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Evento evento) {
		em.persist(evento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> listar() {
		List<Evento> lista = new ArrayList<Evento>(); 
		Query q = em.createQuery("select ev from Evento ev");
		lista =(List<Evento>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idEvento) {
		Evento evento = new Evento();
		evento = em.getReference(Evento.class, idEvento);
		em.remove(evento);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> listarPorNombrePersona(String nombre) {
		List<Evento> lista =new ArrayList<Evento>();
		Query q =em.createQuery("select ev from Evento ev where ev.persona.nombrePersona like ?1");
		q.setParameter(1, "%" + nombre + "%");
		lista =(List<Evento>) q.getResultList();
		return lista;
	}

}
