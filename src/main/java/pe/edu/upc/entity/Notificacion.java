package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Notificacion")
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNotificacion;
	
	@Column(name="nombreNotificacion", nullable=false, length=30)
	private String nombreNotificacion;
	
	@Column(name="fechaNotificacion", nullable=false)
	private Date fechaNotificacion;
	
	@ManyToOne
	@JoinColumn(name="idEvento", nullable=false)
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="idPersona",nullable=false)
	private Persona persona;

	public Notificacion() {
		super();
	}	

	public Notificacion(int idNotificacion, String nombreNotificacion, Date fechaNotificacion, Evento evento,
			Persona persona) {
		super();
		this.idNotificacion = idNotificacion;
		this.nombreNotificacion = nombreNotificacion;
		this.fechaNotificacion = fechaNotificacion;
		this.evento = evento;
		this.persona = persona;
	}

	public int getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public String getNombreNotificacion() {
		return nombreNotificacion;
	}

	public void setNombreNotificacion(String nombreNotificacion) {
		this.nombreNotificacion = nombreNotificacion;
	}

	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}

	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evento, fechaNotificacion, idNotificacion, nombreNotificacion, persona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacion other = (Notificacion) obj;
		return Objects.equals(evento, other.evento) && Objects.equals(fechaNotificacion, other.fechaNotificacion)
				&& idNotificacion == other.idNotificacion
				&& Objects.equals(nombreNotificacion, other.nombreNotificacion)
				&& Objects.equals(persona, other.persona);
	}

}


