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
@Table(name="Nota")
public class Nota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNota;
	
	@Column(name="nombreNota", nullable=false, length=30)
	private String nombreNota;
	
	@Column(name="descripcionNota", nullable=false, length=50)
	private String descripcionNota;

	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona idPersona;


	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Nota(int idNota, String nombreNota, String descripcionNota, Persona idPersona) {
		super();
		this.idNota = idNota;
		this.nombreNota = nombreNota;
		this.descripcionNota = descripcionNota;
		this.idPersona = idPersona;
	}


	public int getIdNota() {
		return idNota;
	}


	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}


	public String getNombreNota() {
		return nombreNota;
	}


	public void setNombreNota(String nombreNota) {
		this.nombreNota = nombreNota;
	}


	public String getDescripcionNota() {
		return descripcionNota;
	}


	public void setDescripcionNota(String descripcionNota) {
		this.descripcionNota = descripcionNota;
	}


	public Persona getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	
	
	
}
