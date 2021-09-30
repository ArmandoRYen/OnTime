package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.INotificacionDao;
import pe.edu.upc.entity.Notificacion;

public class NotificacionDaoImpl implements INotificacionDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Notificacion notificacion) {
		em.persist(notificacion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notificacion> listar() {
		List<Notificacion> lista = new ArrayList<Notificacion>(); 
		Query q = em.createQuery("select nt from Notificacion nt");
		lista =(List<Notificacion>) q.getResultList();		
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idNotificacion) {
		Notificacion notificacion = new Notificacion();
		notificacion = em.getReference(Notificacion.class, idNotificacion);
		em.remove(notificacion);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Notificacion> listarPorNombrePersona(String nombre) {
		List<Notificacion> lista =new ArrayList<Notificacion>();
		Query q =em.createQuery("select n from Notificacion n where n.persona.nombrePersona like ?1");
		q.setParameter(1, "%" + nombre + "%");
		lista =(List<Notificacion>) q.getResultList();
		return lista;
	}

}
