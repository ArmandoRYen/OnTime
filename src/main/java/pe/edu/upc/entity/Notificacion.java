package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name= "Notificacion")
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNotificacion;
	
	@Column(name="nombreNotificacion", nullable=false, length=30)
	private String nombreNotificacion;
	
	@Column(name="horaNotificacion", nullable=false)
	private Date horaNotificacion;

	@Column(name="diaNotificacion", nullable=false, length=60)
	private String diaNotificacion;
	
	@ManyToOne
	@JoinColumn(name="idEvento", nullable=false)
	private Evento idEvento;

	public Notificacion() {
		super();
	}

	public Notificacion(int idNotificacion, String nombreNotificacion, Date horaNotificacion, String diaNotificacion,
			Evento idEvento) {
		super();
		this.idNotificacion = idNotificacion;
		this.nombreNotificacion = nombreNotificacion;
		this.horaNotificacion = horaNotificacion;
		this.diaNotificacion = diaNotificacion;
		this.idEvento = idEvento;
	}

	public int getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public String getNombreNotificacion() {
		return nombreNotificacion;
	}

	public void setNombreNotificacion(String nombreNotificacion) {
		this.nombreNotificacion = nombreNotificacion;
	}

	public Date getHoraNotificacion() {
		return horaNotificacion;
	}

	public void setHoraNotificacion(Date horaNotificacion) {
		this.horaNotificacion = horaNotificacion;
	}

	public String getDiaNotificacion() {
		return diaNotificacion;
	}

	public void setDiaNotificacion(String diaNotificacion) {
		this.diaNotificacion = diaNotificacion;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaNotificacion, horaNotificacion, idEvento, idNotificacion, nombreNotificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacion other = (Notificacion) obj;
		return Objects.equals(diaNotificacion, other.diaNotificacion)
				&& Objects.equals(horaNotificacion, other.horaNotificacion) && Objects.equals(idEvento, other.idEvento)
				&& idNotificacion == other.idNotificacion
				&& Objects.equals(nombreNotificacion, other.nombreNotificacion);
	}
	
	
}


