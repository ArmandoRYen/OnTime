package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.dao.IEstado;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.entity.Pendiente;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPendienteService;
import pe.edu.upc.service.IPersonaService;

public class PendienteController implements Serializable {

	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPendienteService peService;
	
	private Pendiente pendiente;
	List<Pendiente> listapendiente;
	

	@Inject
	private IPersonaService pService;
	
	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private IEstado eService;
	
	private Estado estado;
	List<Estado> listaestado;
	
	@PostConstruct
	public void init() {
		this.listapendiente = new ArrayList<Pendiente>();
		this.pendiente = new Pendiente();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();
		
		this.estado=new Estado();
		this.listaestado = new ArrayList<Estado>();

		this.listaestado();
		this.listarpendiente();
		this.listarPersona();		
	}
	public String nuevoPendiente() {
		this.setPendiente (new Pendiente());
		return "pendiente.xhtml";
	}


	public void insertar() {
		peService.insertar(pendiente);
		limpiarPendiente();
		this.listarpendiente();
	}


	public void listarpendiente() {
		listapendiente = peService.listar();
	}
	
	public void listaestado() {
		listaestado = eService.listar();
	}

	
	public void listarPersona() {
		listaPersonas = pService.listar();
	}

	
	public void limpiarPendiente() {
		this.init();
	}

	public void eliminar(Pendiente pendiente) {
		peService.eliminar(pendiente.getIdPendiente());
		this.listarpendiente();
	}

	public Pendiente getPendiente() {
		return pendiente;
	}
	public void setPendiente(Pendiente pendiente) {
		this.pendiente = pendiente;
	}
	public List<Pendiente> getListapendiente() {
		return listapendiente;
	}
	public void setListapendiente(List<Pendiente> listapendiente) {
		this.listapendiente = listapendiente;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Estado> getListaestado() {
		return listaestado;
	}
	public void setListaestado(List<Estado> listaestado) {
		this.listaestado = listaestado;
	}

}
