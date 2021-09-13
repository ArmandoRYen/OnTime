package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;

public class MotorDaoImpl implements IMotorDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Motor motor) {
		em.persist(motor);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motor> listar() {
		List<Motor> lista = new ArrayList<Motor>();
		Query q = em.createQuery("select m from Motor m");
		lista = (List<Motor>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override	
	public void eliminar(int idMotor) {
		Motor motor = new Motor();
		motor = em.getReference(Motor.class, idMotor);
		em.remove(motor);		
	}
	
}

