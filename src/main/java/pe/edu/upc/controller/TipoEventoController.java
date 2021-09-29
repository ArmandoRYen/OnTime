package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;

@Named
@RequestScoped
public class TipoEventoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoEventoService teService;
	private TipoEvento tipoevento;
	List<TipoEvento> ListaTipoEvento;
	
	
	@PostConstruct
	public void init() {
		this.ListaTipoEvento =new ArrayList<TipoEvento>();
		this.tipoevento=new TipoEvento();
		this.listar();
		
	}
	public void insertar() {
		teService.insertar(tipoevento);
		limpiarTipoEvento();
	}
	
	public void listar() {
		ListaTipoEvento= teService.listar();
	}
	public void limpiarTipoEvento() {
		this.init();
	}
	
	public void eliminar(TipoEvento tipoe) {
		teService.eliminar(tipoe.getIdTipoEvento());//revisar
		this.listar();
	}
	public TipoEvento getTipoevento() {
		return tipoevento;
	}
	public void setTipoevento(TipoEvento tipoevento) {
		this.tipoevento = tipoevento;
	}
	public List<TipoEvento> getListaTipoEvento() {
		return ListaTipoEvento;
	}
	public void setListaTipoEvento(List<TipoEvento> listaTipoEvento) {
		ListaTipoEvento = listaTipoEvento;
	}

	
	
	

}
