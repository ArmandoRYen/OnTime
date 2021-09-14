package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.TipoNota;
import pe.edu.upc.service.ITipoNotaService;

@Named
@RequestScoped
public class TipoNotaController {
	
	@Inject
	private ITipoNotaService tnService;
	private TipoNota tiponota;
	List<TipoNota> ListaTipoNota;
	
	@PostConstruct
	public void init() {
		this.ListaTipoNota=new ArrayList<TipoNota>();
		this.tiponota=new TipoNota();
		this.listar();
	}
/*	public String nuevaTipoNota() {
		this.setTiponota(new TipoNota());
		return"pagina"
	}*/
	public void insertar() {
		tnService.insertar(tiponota);
		limpiarTipoNota();
	}
	public void listar() {
		ListaTipoNota=tnService.listar();
	}
	public void limpiarTipoNota() {
		this.init();
	}
	public void eliminar(TipoNota tnota) {
		tnService.eliminar(tnota.getIdTipoNota());
	}
	
	public TipoNota getTiponota() {
		return tiponota;
	}
	public void setTiponota(TipoNota tiponota) {
		this.tiponota = tiponota;
	}
	public List<TipoNota> getListaTipoNota() {
		return ListaTipoNota;
	}
	public void setListaTipoNota(List<TipoNota> listaTipoNota) {
		ListaTipoNota = listaTipoNota;
	}

}
