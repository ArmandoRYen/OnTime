package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Evento")
public class Evento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvento;
	
	@Column(name="nombreEvento", nullable=false, length=30)
	private String nombreEvento;
	
	@Column(name="descripcionEvento", nullable=false, length=50)
	private String descripcionEvento;
	
	@Column(name="fechaEvento", nullable=false)
	private Date fechaEvento;

	@ManyToOne
	@JoinColumn(name="idTipoEvento", nullable=false)
	private TipoEvento idTipoEvento;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona idPersona;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(int idEvento, String nombreEvento, String descripcionEvento, Date fechaEvento,
			TipoEvento idTipoEvento, Persona idPersona) {
		super();
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.idTipoEvento = idTipoEvento;
		this.idPersona = idPersona;
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

	public TipoEvento getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(TipoEvento idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
	
	
}
