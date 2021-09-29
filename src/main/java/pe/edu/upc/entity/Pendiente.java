package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pendiente")
public class Pendiente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPendiente;
	
	@Column(name="nombrePendiente", nullable=false, length=30)
	private String nombrePendiente;
	
	@Column(name="nombreTipoPendiente", nullable=false, length=30)
	private String nombreTipoPendiente;
	
	@ManyToOne
	@JoinColumn(name="idEstado",nullable=false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="idPersona",nullable=false)
	private Persona persona;

	public Pendiente() {
		super();
	}

	public Pendiente(int idPendiente, String nombrePendiente, String nombreTipoPendiente, Estado estado,
			Persona persona) {
		super();
		this.idPendiente = idPendiente;
		this.nombrePendiente = nombrePendiente;
		this.nombreTipoPendiente = nombreTipoPendiente;
		this.estado = estado;
		this.persona = persona;
	}

	public int getIdPendiente() {
		return idPendiente;
	}

	public void setIdPendiente(int idPendiente) {
		this.idPendiente = idPendiente;
	}

	public String getNombrePendiente() {
		return nombrePendiente;
	}

	public void setNombrePendiente(String nombrePendiente) {
		this.nombrePendiente = nombrePendiente;
	}

	public String getNombreTipoPendiente() {
		return nombreTipoPendiente;
	}

	public void setNombreTipoPendiente(String nombreTipoPendiente) {
		this.nombreTipoPendiente = nombreTipoPendiente;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
