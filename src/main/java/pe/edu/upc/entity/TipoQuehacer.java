package pe.edu.upc.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoQuehacer")

public class TipoQuehacer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoQuehacer;
	
	@Column(name="nombreTipoQuehacer", nullable=false, length=30)
	private String nombreTipoQuehacer;

	public TipoQuehacer(int idTipoQuehacer, String nombreTipoQuehacer) {
		super();
		this.idTipoQuehacer = idTipoQuehacer;
		this.nombreTipoQuehacer = nombreTipoQuehacer;
	}

	public TipoQuehacer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoQuehacer() {
		return idTipoQuehacer;
	}

	public void setIdTipoQuehacer(int idTipoQuehacer) {
		this.idTipoQuehacer = idTipoQuehacer;
	}

	public String getNombreTipoQuehacer() {
		return nombreTipoQuehacer;
	}

	public void setNombreTipoQuehacer(String nombreTipoQuehacer) {
		this.nombreTipoQuehacer = nombreTipoQuehacer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoQuehacer, nombreTipoQuehacer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoQuehacer other = (TipoQuehacer) obj;
		return idTipoQuehacer == other.idTipoQuehacer && Objects.equals(nombreTipoQuehacer, other.nombreTipoQuehacer);
	}
	

}
