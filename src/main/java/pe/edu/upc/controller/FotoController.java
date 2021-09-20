package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Foto;
import pe.edu.upc.service.IFotoService;

import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;



@Named
@RequestScoped
public class FotoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoEventoService teService;

	@Inject
	private IFotoService ftService;
	


	private TipoEvento tipoevento;
	List<TipoEvento> listaTipoEventos;
	
	private Foto foto;
	List<Foto> listaFotos;
	

	@PostConstruct
	public void init() {
		this.listaTipoEventos = new ArrayList<TipoEvento>();
		this.tipoevento = new TipoEvento();
		
		this.listaFotos = new ArrayList<Foto>();
		this.foto = new Foto();
		


		this.listarTipoEvento();
		this.listarFoto();

	}

	public String nuevoEvento() {
		this.setFoto(new Foto());
		return "Foto.xhtml";
	}

	public void insertar() {
		ftService.insertar(foto);
		limpiarFoto();
		this.listarFoto();
	}

	public void limpiarFoto() {
		this.init();
	}

	public void listarTipoEvento() {
		listaTipoEventos = teService.listar();
	}

	public void listarFoto() {
		listaFotos = ftService.listar();
	}
	


	public void limpiarTipoEvento() {
		this.init();
	}
	


	public void eliminar(Foto foto) {
		ftService.eliminar(foto.getIdFoto());
		this.listarFoto();
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

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}
	

	
	

}
