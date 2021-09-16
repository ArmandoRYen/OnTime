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
	
	@Column(name="contraseñaPersona", nullable=false, length=20)
	private String contraseñaPersona;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int idPersona, String nombrePersona, String contraseñaPersona) {
		super();
		this.idPersona = idPersona;
		this.nombrePersona = nombrePersona;
		this.contraseñaPersona = contraseñaPersona;
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

	public String getContraseñaPersona() {
		return contraseñaPersona;
	}

	public void setContraseñaPersona(String contraseñaPersona) {
		this.contraseñaPersona = contraseñaPersona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseñaPersona, idPersona, nombrePersona);
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
		return Objects.equals(contraseñaPersona, other.contraseñaPersona) && idPersona == other.idPersona
				&& Objects.equals(nombrePersona, other.nombrePersona);
	}

}
