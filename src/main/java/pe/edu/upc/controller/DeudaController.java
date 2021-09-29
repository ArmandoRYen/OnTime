package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Deuda;
import pe.edu.upc.service.IDeudaService;


import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.serviceimpl.LoginService;
@Named
@RequestScoped
public class DeudaController implements Serializable {

	private static final long serialVersionUID = 1L;

	

	@Inject
	private IDeudaService deService;
	
	@Inject
	private IPersonaService pService;

	
	private Deuda deuda;
	List<Deuda> listaDeudas;
	
	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private LoginService loginService;

	@PostConstruct
	public void init() {

		this.listaDeudas = new ArrayList<Deuda>();
		this.deuda = new Deuda();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();

		this.listarDeuda();
		this.listarPersona();
	}

	public void insertar() {
		deuda.setIdDeuda(0);
		Persona personaLogin=loginService.getPersona();
		if(personaLogin!=null) {
			deuda.setPersona(personaLogin);
			deService.insertar(deuda);
			limpiarDeuda();
			this.listarDeuda();
		}
		
	}

	public void limpiarDeuda() {
		this.init();
	}



	public void listarDeuda() {
		Persona personaLogin=loginService.getPersona();
		if(personaLogin==null) {
			listaDeudas = deService.listar();
		} else {
			listaDeudas=deService.listarPorNombre(personaLogin.getNombrePersona());
		}
		
	}
	
	public void listarPersona() {
		listaPersonas = pService.listar();
	}

	
	public void limpiarPersona() {
		this.init();
	}

	public void eliminar(Deuda deuda) {
		deService.eliminar(deuda.getIdDeuda());
		this.listarDeuda();
	}

	public Deuda getDeuda() {
		return deuda;
	}

	public void setDeuda(Deuda deuda) {
		this.deuda = deuda;
	}

	public List<Deuda> getListaDeudas() {
		return listaDeudas;
	}

	public void setListaDeudas(List<Deuda> listaDeudas) {
		this.listaDeudas = listaDeudas;
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


	

}
