package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Foto")
public class Foto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFoto;
	
	@Column(name="nombreFoto", nullable=false, length=20)
	private String nombreFoto;
	
	@Column(name="Imagen")
	@Lob
	private byte[] Imagen;
	
	@ManyToOne
	@JoinColumn(name="idTipoEvento", nullable=false)
	private TipoEvento idTipoEvento;

	public Foto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Foto(int idFoto, String nombreFoto, byte[] imagen, TipoEvento idTipoEvento) {
		super();
		this.idFoto = idFoto;
		this.nombreFoto = nombreFoto;
		Imagen = imagen;
		this.idTipoEvento = idTipoEvento;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public byte[] getImagen() {
		return Imagen;
	}

	public void setImagen(byte[] imagen) {
		Imagen = imagen;
	}

	public TipoEvento getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(TipoEvento idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	
	

}
