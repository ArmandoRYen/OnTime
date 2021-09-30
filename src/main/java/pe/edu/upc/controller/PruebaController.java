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
import pe.edu.upc.serviceimpl.LoginService;
import pe.edu.upc.entity.Persona;

@Named
@RequestScoped
public class PruebaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoEventoService teService;

	@Inject
	private IPruebaService prService;
	
	private TipoEvento tipoevento;
	List<TipoEvento> listaTipoEventos;
	
	private Prueba prueba;
	List<Prueba> listaPruebas;
	
	@Inject
	private LoginService loginService;

	@PostConstruct
	public void init() {
		this.listaTipoEventos = new ArrayList<TipoEvento>();
		this.tipoevento = new TipoEvento();
		
		this.listaPruebas = new ArrayList<Prueba>();
		this.prueba = new Prueba();
		
		this.listarTipoEvento();
		this.listarPrueba();
	}

	public String nuevoPrueba() {
		this.setPrueba(new Prueba());
		return "pago.xhtml";
	}

	public void insertarPrueba() {
		prueba.setPersona(loginService.getPersona());
		prService.insertar(prueba);
		limpiarPrueba();
		this.listarPrueba();
	}

	public void limpiarPrueba() {
		this.init();
	}

	public void listarTipoEvento() {
		Persona personaLogin = loginService.getPersona();
		if (personaLogin == null) {
			listaTipoEventos = teService.listar();
		} else {
			listaTipoEventos = teService.listarPorNombre(personaLogin.getNombrePersona());
		}

	}

	public void listarPrueba() {
		Persona personaLogin = loginService.getPersona();
		if (personaLogin == null) {
			listaPruebas = prService.listar();
		} else {
			listaPruebas = prService.listarPorNombre(personaLogin.getNombrePersona());
		}
	}
	
	public void limpiarTipoEvento() {
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


	

	
	

}
