package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Nota;
import pe.edu.upc.service.INotaService;


import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.serviceimpl.LoginService;

@Named
@RequestScoped
public class NotaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private INotaService nService;
	
	@Inject
	private IPersonaService pService;
	
	private Nota nota;
	List<Nota> listaNotas;
	
	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private LoginService loginService;

	@PostConstruct
	public void init() {	
		this.listaNotas = new ArrayList<Nota>();
		this.nota = new Nota();		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();	
		this.listarNota();
		this.listarPersona();
	}

	public void insertar() {
		nota.setIdNota(0);
		Persona personaLogin = loginService.getPersona();
		if(personaLogin != null) {
			nota.setPersona(personaLogin);
			nService.insertar(nota);
			limpiarNota();
			this.listarNota();
		}
	}

	public void limpiarNota() {
		this.init();
	}	

	public void findByName() {
		if(nota.getNombreNota().isEmpty()) {
			this.listarNota();
		}else {
			listaNotas=this.nService.findByName(this.getNota());
		}
	}
	
	public void listarNota() {
		Persona personaLogin = loginService.getPersona();
		if(personaLogin == null) {			
			listaNotas = nService.listar();		
		} else {
			listaNotas = nService.listarPorNombre(personaLogin.getNombrePersona());
		}
	}
	
	public void listarPersona() {
		listaPersonas = pService.listar();
	}

	public void limpiarTipoEvento() {
		this.init();
	}
	
	public void limpiarPersona() {
		this.init();
	}

	public void eliminar(Nota nota) {
		nService.eliminar(nota.getIdNota());
		this.listarNota();
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public List<Nota> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<Nota> listaNotas) {
		this.listaNotas = listaNotas;
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
