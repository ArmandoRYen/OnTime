package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.TipoQuehacer;
import pe.edu.upc.service.ITipoQuehacerService;


@Named
@RequestScoped
public class TipoQuehacerController {

	@Inject
	private ITipoQuehacerService tqhService;
	private TipoQuehacer tipoquehacer;
	List<TipoQuehacer> ListaTipoQuehacer;
	
	@PostConstruct
	public void init() {
		this.ListaTipoQuehacer = new ArrayList<TipoQuehacer>();
		this.tipoquehacer = new TipoQuehacer();
		this.listar();
	}
	public void listar() {
			ListaTipoQuehacer = tqhService.listar();
		}
	
	public void insertar() {
		tqhService.Insertar(tipoquehacer);
		limpiarTipoQuehacer();
	}
	
	public void limpiarTipoQuehacer() {
		this.init();
	}
	
	public TipoQuehacer getTipoquehacer() {
		return tipoquehacer;
	}
	public void setTipoquehacer(TipoQuehacer tipoquehacer) {
		this.tipoquehacer = tipoquehacer;
	}
	public List<TipoQuehacer> getListaTipoQuehacer() {
		return ListaTipoQuehacer;
	}
	public void setListaTipoQuehacer(List<TipoQuehacer> listatipoquehacer){
	ListaTipoQuehacer = listatipoquehacer;	
	}
	
}
