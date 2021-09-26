package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Persona")


public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPersona;
	
	@Column(name="nombrePersona", nullable=false, length=15)
	private String nombrePersona;
	
	@Column(name="contrasenaPersona", nullable=false, length=20)
	private String contrasenaPersona;
	
	@Column(name="tipoPersona", nullable=false)
	private char tipoPersona;
	
	@Column(name="sueldoPersona")
	private float sueldoPersona;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int idPersona, String nombrePersona, String contrasenaPersona, char tipoPersona,
			float sueldoPersona) {
		super();
		this.idPersona = idPersona;
		this.nombrePersona = nombrePersona;
		this.contrasenaPersona = contrasenaPersona;
		this.tipoPersona = tipoPersona;
		this.sueldoPersona = sueldoPersona;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getcontrasenaPersona() {
		return contrasenaPersona;
	}

	public void setcontrasenaPersona(String contrasenaPersona) {
		this.contrasenaPersona = contrasenaPersona;
	}

	public char getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(char tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public float getSueldoPersona() {
		return sueldoPersona;
	}

	public void setSueldoPersona(float sueldoPersona) {
		this.sueldoPersona = sueldoPersona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasenaPersona, idPersona, nombrePersona, sueldoPersona, tipoPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(contrasenaPersona, other.contrasenaPersona) && idPersona == other.idPersona
				&& Objects.equals(nombrePersona, other.nombrePersona)
				&& Float.floatToIntBits(sueldoPersona) == Float.floatToIntBits(other.sueldoPersona)
				&& tipoPersona == other.tipoPersona;
	}

	
	
}
