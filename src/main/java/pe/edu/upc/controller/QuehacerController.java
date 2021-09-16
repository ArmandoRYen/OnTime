package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEstado;
import pe.edu.upc.entity.Estado;
import pe.edu.upc.entity.Persona;
import pe.edu.upc.entity.Quehacer;
import pe.edu.upc.entity.TipoQuehacer;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.service.IQuehacer;
import pe.edu.upc.service.ITipoQuehacerService;


@Named
@RequestScoped
public class QuehacerController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IQuehacer qService;
	
	private Quehacer quehacer;
	List<Quehacer> listaquehacer;
	
	@Inject
	private ITipoQuehacerService tqservice;
	
	private TipoQuehacer tipoquehacer;
	List<TipoQuehacer> listatipoquehacer;

	@Inject
	private IPersonaService pService;
	
	private Persona persona;
	List<Persona> listaPersonas;
	
	@Inject
	private IEstado eService;
	
	private Estado estado;
	List<Estado> listaestado;
	
	@PostConstruct
	public void init() {
		this.listaquehacer = new ArrayList<Quehacer>();
		this.quehacer = new Quehacer();
		
		this.listatipoquehacer = new ArrayList<TipoQuehacer>();
		this.tipoquehacer = new TipoQuehacer();
		
		this.listaestado = new ArrayList<Estado>();
		this.persona = new Persona();

		this.listaestado();
		this.listartipoquehacer();
		this.listarquehacer();
		this.listarPersona();		
	}



	public void insertar() {
		qService.insertar(quehacer);
		limpiarNota();
		this.listarquehacer();
	}

	public void limpiarNota() {
		this.init();
	}

	public void listarquehacer() {
		listaquehacer = qService.listar();
	}
	
	public void listaestado() {
		listaestado = eService.listar();
	}

	
	public void listartipoquehacer() {
		listatipoquehacer = tqservice.listar();
	}
	
	public void listarPersona() {
		listaPersonas = pService.listar();
	}

	public void limpiarTipoquehacer() {
		this.init();
	}
	
	public void limpiarPersona() {
		this.init();
	}

	public void eliminar(Quehacer quehacer) {
		qService.eliminar(quehacer.getIdQuehacer());
		this.listarquehacer();
	}

	
	
	
	
	public Quehacer getQuehacer() {
		return quehacer;
	}

	public void setQuehacer(Quehacer quehacer) {
		this.quehacer = quehacer;
	}

	public List<Quehacer> getListaquehacer() {
		return listaquehacer;
	}

	public void setListaquehacer(List<Quehacer> listaquehacer) {
		this.listaquehacer = listaquehacer;
	}

	public TipoQuehacer getTipoquehacer() {
		return tipoquehacer;
	}

	public void setTipoquehacer(TipoQuehacer tipoquehacer) {
		this.tipoquehacer = tipoquehacer;
	}

	public List<TipoQuehacer> getListatipoquehacer() {
		return listatipoquehacer;
	}

	public void setListatipoquehacer(List<TipoQuehacer> listatipoquehacer) {
		this.listatipoquehacer = listatipoquehacer;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaestado() {
		return listaestado;
	}

	public void setListaestado(List<Estado> listaestado) {
		this.listaestado = listaestado;
	}
	
	
}
