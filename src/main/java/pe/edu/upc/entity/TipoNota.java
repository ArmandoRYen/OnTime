package pe.edu.upc.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoNota")

public class TipoNota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoNota;
	
	@Column(name="nombreTipoNota", nullable=false, length=30)
	private String nombreTipoNota;

	public TipoNota(int idTipoNota, String nombreTipoNota) {
		super();
		this.idTipoNota = idTipoNota;
		this.nombreTipoNota = nombreTipoNota;
	}

	public TipoNota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoNota() {
		return idTipoNota;
	}

	public void setIdTipoNota(int idTipoNota) {
		this.idTipoNota = idTipoNota;
	}

	public String getNombreTipoNota() {
		return nombreTipoNota;
	}

	public void setNombreTipoNota(String nombreTipoNota) {
		this.nombreTipoNota = nombreTipoNota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoNota, nombreTipoNota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoNota other = (TipoNota) obj;
		return idTipoNota == other.idTipoNota && Objects.equals(nombreTipoNota, other.nombreTipoNota);
	}
	
	

}
