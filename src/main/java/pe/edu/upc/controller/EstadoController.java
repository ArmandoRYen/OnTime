package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Estado;
import pe.edu.upc.service.IEstadoService;

@Named
@RequestScoped
public class EstadoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEstadoService esService;
	private Estado estado;
	List<Estado> ListaEstado;
	
	@PostConstruct
	public void init() {
		this.ListaEstado =new ArrayList<Estado>();
		this.estado = new Estado();
		this.listarEstado();		
	}
	
	public void insertar() {
		esService.insertar(estado);
	}
	public void listarEstado() {
		ListaEstado = esService.listar();
	}
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaEstado() {
		return ListaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		ListaEstado = listaEstado;
	}	
	
}


