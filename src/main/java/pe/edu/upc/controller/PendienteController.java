package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEstadoDao;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.entity.Pendiente;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPendienteService;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.serviceimpl.LoginService;

@Named
@RequestScoped
public class PendienteController implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPendienteService peService;
	
	private Pendiente pendiente;
	List<Pendiente> listaPendientes;
	List<String> listaTipoPendientes;

	@Inject
	private IPersonaService pService;
	
	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private IEstadoDao eService;
	
	private Estado estado;
	List<Estado> listaestado;
	
	@Inject
	private LoginService loginService;
	
	@PostConstruct
	public void init() {
		this.listaPendientes = new ArrayList<Pendiente>();
		this.pendiente = new Pendiente();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();
		
		this.estado=new Estado();
		this.listaestado = new ArrayList<Estado>();
		
		this.listaTipoPendientes = new ArrayList<String>();
		
		this.listaestado();
		this.listarpendiente();
		this.listarPersona();		
		this.listarTipoPendiente();
	}
	

	public void insertar() {
		pendiente.setIdPendiente(0);
		Persona personaLogin = loginService.getPersona();
		if(personaLogin != null) {
			pendiente.setPersona(personaLogin);
			peService.insertar(pendiente);
			limpiarPendiente();
			this.listarpendiente();
		}
	}

	public void listarpendiente() {
		Persona personaLogin = loginService.getPersona();
		if(personaLogin == null) {	
			listaPendientes = peService.listar();
		} else {
			listaPendientes = peService.listarPorNombre(personaLogin.getNombrePersona()); 
		}
	}
	
	public void listaestado() {
		listaestado = eService.listar();
	}
	
	public void listarPersona() {
		listaPersonas = pService.listar();
	}
	
	public void listarTipoPendiente() {
		listaTipoPendientes.add(new String ("Limpieza"));
		listaTipoPendientes.add(new String ("Cocina"));
		listaTipoPendientes.add(new String ("Compra"));
		listaTipoPendientes.add(new String ("Trabajo"));
		listaTipoPendientes.add(new String ("Universidad"));
		listaTipoPendientes.add(new String ("Otro"));
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
	public List<Pendiente> getListaPendientes() {
		return listaPendientes;
	}
	public void setListaPendientes(List<Pendiente> listaPendientes) {
		this.listaPendientes = listaPendientes;
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
	public List<String> getListaTipoPendientes() {
		return listaTipoPendientes;
	}
	public void setListaTipoPendientes(List<String> listaTipoPendientes) {
		this.listaTipoPendientes = listaTipoPendientes;
	}
	
}
