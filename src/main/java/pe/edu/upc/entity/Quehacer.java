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
@Table(name="QuehacerController")

public class Quehacer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQuehacer;
	
	@Column(name="nombreQuehacer", nullable=false, length=30)
	private String nombreQuehacer;

	@ManyToOne
	@JoinColumn(name="idTipoQuehacer",nullable=false)
	private TipoQuehacer tipoQuehacer;
	
	@ManyToOne
	@JoinColumn(name="idEstado",nullable=false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="idPersona",nullable=false)
	private Persona persona;

	public Quehacer(int idQuehacer, String nombreQuehacer, TipoQuehacer tipoQuehacer, Estado estado) {
		super();
		this.idQuehacer = idQuehacer;
		this.nombreQuehacer = nombreQuehacer;
		this.tipoQuehacer = tipoQuehacer;
		this.estado = estado;
	}

	public Quehacer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdQuehacer() {
		return idQuehacer;
	}

	public void setIdQuehacer(int idQuehacer) {
		this.idQuehacer = idQuehacer;
	}

	public String getNombreQuehacer() {
		return nombreQuehacer;
	}

	public void setNombreQuehacer(String nombreQuehacer) {
		this.nombreQuehacer = nombreQuehacer;
	}

	public TipoQuehacer getTipoQuehacer() {
		return tipoQuehacer;
	}

	public void setTipoQuehacer(TipoQuehacer tipoQuehacer) {
		this.tipoQuehacer = tipoQuehacer;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
