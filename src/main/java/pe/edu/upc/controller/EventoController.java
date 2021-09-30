package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.optionconfig.elements.Elements;
import org.primefaces.model.charts.optionconfig.elements.ElementsLine;
import org.primefaces.model.charts.radar.RadarChartDataSet;
import org.primefaces.model.charts.radar.RadarChartModel;
import org.primefaces.model.charts.radar.RadarChartOptions;

import pe.edu.upc.entity.Evento;
import pe.edu.upc.service.IEventoService;

import pe.edu.upc.entity.TipoEvento;
import pe.edu.upc.service.ITipoEventoService;
import pe.edu.upc.serviceimpl.LoginService;
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

	@Inject
	private LoginService loginService;
	
	
    private DonutChartModel donutModel;
	private HorizontalBarChartModel horizontalBarModel;
	private RadarChartModel radarModel;


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
		this.createHorizontalBarModel();
		this.createRadarChartModel();
		this.createDonutChartModel();
	}

	public void insertarEvento() {
		evento.setIdEvento(0);
		Persona personaLogin = loginService.getPersona();
		if(personaLogin != null) {
			evento.setPersona(personaLogin);
			evService.insertar(evento);
			limpiarEvento();
			this.listarEvento();
		}
	}

	public void insertarTipoEvento() {
		tipoevento.setIdTipoEvento(0);
		Persona personaLogin = loginService.getPersona();
		if (personaLogin != null) {
			System.out.println(personaLogin.getNombrePersona());
			tipoevento.setPersona(personaLogin);
			teService.insertar(tipoevento);
			limpiarEvento();
			this.listarTipoEvento();
		} else {
			System.out.println("null");
		}
	}

	public void limpiarEvento() {
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

	public void listarEvento() {
		Persona personaLogin = loginService.getPersona();
		if (personaLogin == null) {
			listaEventos = evService.listar();
		} else {
			listaEventos = evService.listarPorNombre(personaLogin.getNombrePersona());
		}
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

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries eventos = new ChartSeries();
		eventos.setLabel("Eventos");
		
		int cont = 0;
		for(int i = 0; i < listaTipoEventos.size(); i++) {
			for(int j = 0; j < listaEventos.size(); j++) {
				if(listaTipoEventos.get(i).getIdTipoEvento() == listaEventos.get(j).getTipoEvento().getIdTipoEvento()) {
					cont++;
				}
			}
			eventos.set(listaTipoEventos.get(i).getNombreTipoEvento(), cont);
			cont = 0;
		}

		horizontalBarModel.addSeries(eventos);

		horizontalBarModel.setTitle("Horizontal and Stacked");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Número de eventos");
		xAxis.setMin(0);
		xAxis.setMax(10);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Tipo de Evento");
	}

	public RadarChartModel getRadarChartModel() {
		
		return radarModel;
	}
	
	private void createRadarChartModel() {
		radarModel = new RadarChartModel();
        ChartData data = new ChartData();

        RadarChartDataSet radarDataSet = new RadarChartDataSet();
        radarDataSet.setLabel("Complejidad");
        radarDataSet.setFill(true);
        radarDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        radarDataSet.setBorderColor("rgb(255, 99, 132)");
        radarDataSet.setPointBackgroundColor("rgb(255, 99, 132)");
        radarDataSet.setPointBorderColor("#fff");
        radarDataSet.setPointHoverBackgroundColor("#fff");
        radarDataSet.setPointHoverBorderColor("rgb(255, 99, 132)");
        List<Number> dataVal = new ArrayList<>();
        List<String> labels = new ArrayList<>();


		for(int i = 0; i < listaTipoEventos.size(); i++) {
			for(int j = 0; j < listaEventos.size(); j++) {
					dataVal.add(listaEventos.get(j).getComplejidadEvento());									
		}
			labels.add(listaTipoEventos.get(i).getNombreTipoEvento());
			
			}
        radarDataSet.setData(dataVal);
        data.addChartDataSet(radarDataSet);
        data.setLabels(labels);

        /* Options */
        RadarChartOptions options = new RadarChartOptions();
        Elements elements = new Elements();
        ElementsLine elementsLine = new ElementsLine();
        elementsLine.setTension(0);
        elementsLine.setBorderWidth(3);
        elements.setLine(elementsLine);
        options.setElements(elements);

        radarModel.setOptions(options);
        radarModel.setData(data);
		
	}
	
	public void setRadarChartModel(RadarChartModel radarmodel){
		this.radarModel = radarmodel;
		
	}

	private void createDonutChartModel() {
		donutModel = new DonutChartModel();
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        List<String> bgColors = new ArrayList<>();        
        List<String> labels = new ArrayList<>();
        
		for(int i = 0; i < listaTipoEventos.size(); i++) {
			for(int j = 0; j < listaEventos.size(); j++) {
					values.add(listaEventos.get(j).getComplejidadEvento());					
				
			}
			labels.add(listaTipoEventos.get(i).getNombreTipoEvento());
		
		
		}
        dataSet.setData(values);

        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        data.setLabels(labels);

        donutModel.setData(data);
		
		
		
	}
	
	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}
	
}
