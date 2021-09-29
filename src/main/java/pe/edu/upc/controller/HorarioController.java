package pe.edu.upc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import pe.edu.upc.entity.Evento;
import pe.edu.upc.serviceimpl.EventoServiceImpl;
import pe.edu.upc.serviceimpl.LoginService;

@Named
@RequestScoped
public class HorarioController {

	private ScheduleModel model;

	private List<Evento> listaEventos;

	@Inject
	private LoginService lService;

	@Inject
	private EventoServiceImpl eService;

	@PostConstruct
	public void init() {

		listaEventos = eService.listarPorNombre(lService.getPersona().getNombrePersona());
		model = new DefaultScheduleModel();

		for (int i = 0; i < listaEventos.size(); i++) {
			DefaultScheduleEvent event = new DefaultScheduleEvent();
			event.setTitle(listaEventos.get(i).getTipoEvento().getNombreTipoEvento());

			event.setStartDate(addDays(listaEventos.get(i).getFechaEvento(),-1));
			event.setEndDate(event.getStartDate());
			event.setDescription(listaEventos.get(i).getNombreEvento());
			model.addEvent(event);
		}

	}

	public ScheduleModel getModel() {
		return model;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public static Date addDays(Date d, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, days);
		d.setTime(c.getTime().getTime());
		return d;
	}

}
