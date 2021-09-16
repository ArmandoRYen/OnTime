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

import pe.edu.upc.entity.TipoNota;
import pe.edu.upc.service.ITipoNotaService;

import pe.edu.upc.entity.Persona;
import pe.edu.upc.service.IPersonaService;

@Named
@RequestScoped
public class NotaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoNotaService tnService;

	@Inject
	private INotaService nService;
	
	@Inject
	private IPersonaService pService;

	private TipoNota tiponota;
	List<TipoNota> listaTipoNotas;
	
	private Nota nota;
	List<Nota> listaNotas;
	
	private Persona persona;
	List<Persona> listaPersonas;

	@PostConstruct
	public void init() {
		this.listaTipoNotas = new ArrayList<TipoNota>();
		this.tiponota = new TipoNota();
		
		this.listaNotas = new ArrayList<Nota>();
		this.nota = new Nota();
		
		this.listaPersonas = new ArrayList<Persona>();
		this.persona = new Persona();

		this.listarTipoNotas();
		this.listarNota();
		this.listarPersona();
	}

	public String nuevaNota() {
		this.setNota(new Nota());
		return "nota.xhtml";
	}

	public void insertar() {
		nService.insertar(nota);
		limpiarNota();
		this.listarNota();
	}

	public void limpiarNota() {
		this.init();
	}

	public void listarTipoNotas() {
		listaTipoNotas = tnService.listar();
	}

	public void listarNota() {
		listaNotas = nService.listar();
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

	public TipoNota getTiponota() {
		return tiponota;
	}

	public void setTiponota(TipoNota tiponota) {
		this.tiponota = tiponota;
	}

	public List<TipoNota> getListaTipoNotas() {
		return listaTipoNotas;
	}

	public void setListaTipoNotas(List<TipoNota> listaTipoNotas) {
		this.listaTipoNotas = listaTipoNotas;
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
