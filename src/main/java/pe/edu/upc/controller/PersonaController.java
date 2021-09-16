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

@Named
@RequestScoped
public class PersonaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersonaService pService;
	private Persona persona;
	List<Persona> ListaPersona;
	
	@PostConstruct
	public void init() {
		this.ListaPersona =new ArrayList<Persona>();
		this.persona=new Persona();
		this.listar();	
	}
	public void insertar() {
		pService.insertar(persona);
		limpiarPersona();
	}
	public void listar() {
		ListaPersona= pService.listar();
	}
	public void limpiarPersona() {
		this.init();
	}
	public void eliminar(Persona persona) {
		pService.eliminar(persona.getIdPersona());//revisar
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
	
	

}
