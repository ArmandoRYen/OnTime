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
@Table(name = "Evento")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;

	@Column(name = "nombreEvento", nullable = false, length = 30)
	private String nombreEvento;

	@Column(name = "descripcionEvento", nullable = false, length = 50)
	private String descripcionEvento;

	@Column(name = "fechaEvento", nullable = false)
	private Date fechaEvento;

	@Column(name = "complejidadEvento", nullable = false)
	private int complejidadEvento;

	@ManyToOne
	@JoinColumn(name = "idTipoEvento", nullable = false)
	private TipoEvento tipoEvento;

	@ManyToOne
	@JoinColumn(name = "idPersona", nullable = false)
	private Persona persona;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(int idEvento, String nombreEvento, String descripcionEvento, Date fechaEvento, int complejidadEvento,
			TipoEvento tipoEvento, Persona persona) {
		super();
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.complejidadEvento = complejidadEvento;
		this.tipoEvento = tipoEvento;
		this.persona = persona;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public int getComplejidadEvento() {
		return complejidadEvento;
	}

	public void setComplejidadEvento(int complejidadEvento) {
		this.complejidadEvento = complejidadEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(complejidadEvento, descripcionEvento, fechaEvento, idEvento, nombreEvento, persona,
				tipoEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return complejidadEvento == other.complejidadEvento
				&& Objects.equals(descripcionEvento, other.descripcionEvento)
				&& Objects.equals(fechaEvento, other.fechaEvento) && idEvento == other.idEvento
				&& Objects.equals(nombreEvento, other.nombreEvento) && Objects.equals(persona, other.persona)
				&& Objects.equals(tipoEvento, other.tipoEvento);
	}
	
	

}
