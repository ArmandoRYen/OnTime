package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Notificacion;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.INotificacionService;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.serviceimpl.LoginService;
import pe.edu.upc.entity.Evento;
import pe.edu.upc.service.IEventoService;

@Named
@RequestScoped
public class NotificacionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private INotificacionService ntService;
	
	@Inject
	private IEventoService evService;
	
	@Inject
	private IPersonaService pService;
	
	private Notificacion notificacion;
	List<Notificacion> listaNotificaciones;
	
	private Evento evento;
	List<Evento> listaEventos;

	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private LoginService loginService;
	
	@PostConstruct
	public void init() {
		
		this.listaNotificaciones = new ArrayList<Notificacion>();
		this.notificacion = new Notificacion();
		
		this.listaEventos = new ArrayList<Evento>();
		this.evento = new Evento();

		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();	
		
		this.listarNotificacion();
		this.listarEvento();
	}

	public void insertar() {
		notificacion.setIdNotificacion(0);
		Persona personaLogin = loginService.getPersona();
		if(personaLogin != null) {
			ntService.insertar(notificacion);
			limpiarNotificacion();
			this.listarNotificacion();
		}
	}

	public void limpiarNotificacion() {
		this.init();
	}
	
	public void listarNotificacion() {
		Persona personaLogin = loginService.getPersona();
		if (personaLogin == null) {
			listaNotificaciones = ntService.listar();
		} else {
			listaNotificaciones = ntService.listarPorNombre(personaLogin.getNombrePersona());
		}		
	}
	
	public void listarEvento() {
		listaEventos = evService.listar();
	}
	
	public void eliminar(Notificacion notificacion) {
		ntService.eliminar(notificacion.getIdNotificacion());
		this.listarNotificacion();
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	public List<Notificacion> getListaNotificaciones() {
		return listaNotificaciones;
	}

	public void setListaNotificaciones(List<Notificacion> listaNotificaciones) {
		this.listaNotificaciones = listaNotificaciones;
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



}

