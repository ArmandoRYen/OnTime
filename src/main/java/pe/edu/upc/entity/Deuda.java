package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Deuda")
public class Deuda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDeuda;
	
	@Column(name="nombreAcreedor", nullable=false, length=30)
	private String nombreAcreedor;
	
	@Column(name="MoneyPago", nullable=false, length=30)
	private int  MoneyPago;
	
	@Column(name="FechaPago", nullable=false)
	private Date  FechaPago;
	
	@Column(name="PagoRealizado", nullable=false)
	private Boolean  PagoRealizado;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona idPersona;

	public Deuda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deuda(int idDeuda, String nombreAcreedor, int moneyPago, Date fechaPago, Boolean pagoRealizado,
			Persona idPersona) {
		super();
		this.idDeuda = idDeuda;
		this.nombreAcreedor = nombreAcreedor;
		MoneyPago = moneyPago;
		FechaPago = fechaPago;
		PagoRealizado = pagoRealizado;
		this.idPersona = idPersona;
	}

	public int getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(int idDeuda) {
		this.idDeuda = idDeuda;
	}

	public String getNombreAcreedor() {
		return nombreAcreedor;
	}

	public void setNombreAcreedor(String nombreAcreedor) {
		this.nombreAcreedor = nombreAcreedor;
	}

	public int getMoneyPago() {
		return MoneyPago;
	}

	public void setMoneyPago(int moneyPago) {
		MoneyPago = moneyPago;
	}

	public Date getFechaPago() {
		return FechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		FechaPago = fechaPago;
	}

	public Boolean getPagoRealizado() {
		return PagoRealizado;
	}

	public void setPagoRealizado(Boolean pagoRealizado) {
		PagoRealizado = pagoRealizado;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
	
	

}
