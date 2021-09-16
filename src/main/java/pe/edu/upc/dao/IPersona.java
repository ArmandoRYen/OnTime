package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Persona;

public interface IPersona {
	public void insertar(Persona persona);
	public List<Persona>listar();
	public void eliminar(int idPersona);
	

}
