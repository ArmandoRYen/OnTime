package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Foto;

public interface IFotoService {
	public void insertar(Foto foto);
	public List<Foto> listar();
	public void eliminar(int idFoto);
}
