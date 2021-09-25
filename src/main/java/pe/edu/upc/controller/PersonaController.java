package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.serviceimpl.LoginService;

@Named
@RequestScoped
public class PersonaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPersonaService pService;

	@Inject
	private LoginService loginService;

	private Persona persona;

	private Persona personaIngreso;
	private Persona personaNuevo;
	List<Persona> ListaPersona;

	@PostConstruct
	public void init() {
		this.ListaPersona = new ArrayList<Persona>();
		this.persona = new Persona();
		this.personaIngreso = new Persona();
		this.personaNuevo = new Persona();
		this.listar();
	}

	public void insertar() {
		personaNuevo.setIdPersona(0);
		pService.insertar(personaNuevo);
		limpiarPersona();
	}

	public void login() {
		try {
			Persona personaAux = pService.comprobarLogin(personaIngreso);
			if (personaAux == null)
				limpiarPersona();
			else {
				loginService.setPersona(personaAux);
				limpiarPersona();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String login2() {
		Persona personaAux = pService.comprobarLogin(personaIngreso);
		if (personaAux == null) {
			limpiarPersona();
			return "login.xhtml";
		} else {
			loginService.setPersona(personaAux);
			limpiarPersona();
			return "tablero.xhtml";
		}
	}

	public void listar() {
		ListaPersona = pService.listar();
	}

	public void limpiarPersona() {
		this.init();
	}

	public void eliminar(Persona persona) {
		pService.eliminar(persona.getIdPersona());// revisar
		this.listar();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getListaPersona() {
		return ListaPersona;
	}

	public void setListaPersona(List<Persona> listaPersona) {
		ListaPersona = listaPersona;
	}

	public Persona getPersonaIngreso() {
		return personaIngreso;
	}

	public void setPersonaIngreso(Persona personaIngreso) {
		this.personaIngreso = personaIngreso;
	}

	public Persona getPersonaNuevo() {
		return personaNuevo;
	}

	public void setPersonaNuevo(Persona personaNuevo) {
		this.personaNuevo = personaNuevo;
	}

}
