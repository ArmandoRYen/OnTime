package pe.edu.upc.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstado;	
	private String nombreestado;	

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreestado() {
		return nombreestado;
	}

	public void setNombreestado(String nombreEstado) {
		this.nombreestado = nombreEstado;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(idEstado, nombreestado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return idEstado == other.idEstado && Objects.equals(nombreestado, other.nombreestado);
	}		
}
