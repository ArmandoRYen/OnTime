package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Prueba")
public class Prueba implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrueba;
	
	@Column(name="nombrePrueba", nullable=false, length=30)
	private String nombrePrueba;
	
	@ManyToOne
	@JoinColumn(name="idTipoEvento", nullable=false)
	private TipoEvento idTipoEvento;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona persona;
	
	@Column(name="numeroNota", nullable=false)
	private Float numeroNota;
	
	@Column(name="Ponderado", nullable=false)
	private Float Ponderado;

	public Prueba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prueba(int idPrueba, String nombrePrueba, TipoEvento idTipoEvento, Float numeroNota, Float ponderado) {
		super();
		this.idPrueba = idPrueba;
		this.nombrePrueba = nombrePrueba;
		this.idTipoEvento = idTipoEvento;
		this.numeroNota = numeroNota;
		Ponderado = ponderado;
	}

	public int getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(int idPrueba) {
		this.idPrueba = idPrueba;
	}

	public String getNombrePrueba() {
		return nombrePrueba;
	}

	public void setNombrePrueba(String nombrePrueba) {
		this.nombrePrueba = nombrePrueba;
	}

	public TipoEvento getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(TipoEvento idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public Float getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(Float numeroNota) {
		this.numeroNota = numeroNota;
	}

	public Float getPonderado() {
		return Ponderado;
	}

	public void setPonderado(Float ponderado) {
		Ponderado = ponderado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	
	
	

}
