package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Evento;
import pe.edu.upc.service.IEventoService;

import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;

@Named
@RequestScoped
public class EventoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoEventoService teService;

	@Inject
	private IEventoService evService;
	
	@Inject
	private IPersonaService pService;

	private TipoEvento tipoevento;
	List<TipoEvento> listaTipoEventos;
	
	private Evento evento;
	List<Evento> listaEventos;
	
	private Persona persona;
	List<Persona> listaPersonas;

	@PostConstruct
	public void init() {
		this.listaTipoEventos = new ArrayList<TipoEvento>();
		this.tipoevento = new TipoEvento();
		
		this.listaEventos = new ArrayList<Evento>();
		this.evento = new Evento();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();

		this.listarTipoEvento();
		this.listarEvento();
		this.listarPersona();
	}

	public String nuevoEvento() {
		this.setEvento(new Evento());
		return "evento.xhtml";
	}

	public void insertar() {
		evService.insertar(evento);
		limpiarEvento();
		this.listarEvento();
	}

	public void limpiarEvento() {
		this.init();
	}

	public void listarTipoEvento() {
		listaTipoEventos = teService.listar();
	}

	public void listarEvento() {
		listaEventos = evService.listar();
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

	public void eliminar(Evento evento) {
		evService.eliminar(evento.getIdEvento());
		this.listarEvento();
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
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
