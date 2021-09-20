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

	@PostConstruct
	public void init() {

		this.listaDeudas = new ArrayList<Deuda>();
		this.deuda = new Deuda();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();

		this.listarDeuda();
		this.listarPersona();
	}

	public String nuevoDeuda() {
		this.setDeuda(new Deuda());
		return "Deuda.xhtml";
	}

	public void insertar() {
		deService.insertar(deuda);
		limpiarDeuda();
		this.listarDeuda();
	}

	public void limpiarDeuda() {
		this.init();
	}



	public void listarDeuda() {
		listaDeudas = deService.listar();
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
