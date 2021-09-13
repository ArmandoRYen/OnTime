package pe.edu.upc.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoEvento")


public class TipoEvento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoEvento;
	
	@Column(name="nombreTipoEvento", nullable=false, length=30)
	private String nombreTipoEvento;
	
	@Column(name="colorTipoEvento", nullable=false, length=30)
	private String colorTipoEvento;

	public TipoEvento(int idTipoEvento, String nombreTipoEvento, String colorTipoEvento) {
		super();
		this.idTipoEvento = idTipoEvento;
		this.nombreTipoEvento = nombreTipoEvento;
		this.colorTipoEvento = colorTipoEvento;
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

	@Override
	public int hashCode() {
		return Objects.hash(colorTipoEvento, idTipoEvento, nombreTipoEvento);
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
				&& Objects.equals(nombreTipoEvento, other.nombreTipoEvento);
	}
	/*relacion many to one */
	

}
