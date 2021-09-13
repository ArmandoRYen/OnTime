package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;

@Named
@RequestScoped
public class MotorController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMotorService mService;
	private Motor motor;
	List<Motor> ListaMotores;

	@PostConstruct
	public void init() {
		this.ListaMotores = new ArrayList<Motor>();
		this.motor = new Motor();
		this.listar();
	}
	
	public String nuevoMotor() {
		this.setMotor(new Motor());
		return "motor.xhtml";
	}

	public void insertar() {
		mService.insertar(motor);
		limpiarMotor();
	}
	
	public void listar() {
		ListaMotores = mService.listar();
	}
	
	public void limpiarMotor() {
		this.init();
	}
	
	public void eliminar(Motor motor) {
		mService.eliminar(motor.getId());
	}
	
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public List<Motor> getListaMotores() {
		return ListaMotores;
	}

	public void setListaMotores(List<Motor> listaMotores) {
		ListaMotores = listaMotores;
	}
	
	
}