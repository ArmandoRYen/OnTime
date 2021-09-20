package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Prueba;
import pe.edu.upc.service.IPruebaService;

import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;

@Named
@RequestScoped
public class PruebaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoEventoService teService;

	@Inject
	private IPruebaService prService;
	
	@Inject
	private IPersonaService pService;

	private TipoEvento tipoevento;
	List<TipoEvento> listaTipoEventos;
	
	private Prueba prueba;
	List<Prueba> listaPruebas;
	
	private Persona persona;
	List<Persona> listaPersonas;

	@PostConstruct
	public void init() {
		this.listaTipoEventos = new ArrayList<TipoEvento>();
		this.tipoevento = new TipoEvento();
		
		this.listaPruebas = new ArrayList<Prueba>();
		this.prueba = new Prueba();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();

		this.listarTipoEvento();
		this.listarPrueba();
		this.listarPersona();
	}

	public String nuevoEvento() {
		this.setPrueba(new Prueba());
		return "evento.xhtml";
	}

	public void insertar() {
		prService.insertar(prueba);
		limpiarPrueba();
		this.listarPrueba();
	}

	public void limpiarPrueba() {
		this.init();
	}

	public void listarTipoEvento() {
		listaTipoEventos = teService.listar();
	}

	public void listarPrueba() {
		listaPruebas = prService.listar();
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

	public void eliminar(Prueba prueba) {
		prService.eliminar(prueba.getIdPrueba());
		this.listarPrueba();
	}

	public TipoEvento getTipoevento() {
		return tipoevento;
	}

	public void setTipoevento(TipoEvento tipoevento) {
		this.tipoevento = tipoevento;
	}

	public List<TipoEvento> getListaTipoEventos() {
		return listaTipoEventos;
	}

	public void setListaTipoEventos(List<TipoEvento> listaTipoEventos) {
		this.listaTipoEventos = listaTipoEventos;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public List<Prueba> getListaPruebas() {
		return listaPruebas;
	}

	public void setListaPruebas(List<Prueba> listaPruebas) {
		this.listaPruebas = listaPruebas;
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
