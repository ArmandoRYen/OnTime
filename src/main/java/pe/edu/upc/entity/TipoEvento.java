package pe.edu.upc.entity;

import java.io.Serializable;
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
@Table(name="TipoEvento")


public class TipoEvento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoEvento;
	
	@Column(name="nombreTipoEvento", nullable=false, length=30)
	private String nombreTipoEvento;
	
	@Column(name="colorTipoEvento", nullable=false, length=10)
	private String colorTipoEvento;
	
	@ManyToOne
	@JoinColumn(name = "idPersona", nullable = false)
	private Persona persona;

	public TipoEvento(int idTipoEvento, String nombreTipoEvento, String colorTipoEvento, Persona persona) {
		super();
		this.idTipoEvento = idTipoEvento;
		this.nombreTipoEvento = nombreTipoEvento;
		this.colorTipoEvento = colorTipoEvento;
		this.persona = persona;
	}

	public TipoEvento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getNombreTipoEvento() {
		return nombreTipoEvento;
	}

	public void setNombreTipoEvento(String nombreTipoEvento) {
		this.nombreTipoEvento = nombreTipoEvento;
	}

	public String getColorTipoEvento() {
		return colorTipoEvento;
	}

	public void setColorTipoEvento(String colorTipoEvento) {
		this.colorTipoEvento = colorTipoEvento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorTipoEvento, idTipoEvento, nombreTipoEvento, persona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoEvento other = (TipoEvento) obj;
		return Objects.equals(colorTipoEvento, other.colorTipoEvento) && idTipoEvento == other.idTipoEvento
				&& Objects.equals(nombreTipoEvento, other.nombreTipoEvento) && Objects.equals(persona, other.persona);
	}

}
