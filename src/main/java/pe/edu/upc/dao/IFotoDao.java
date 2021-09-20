package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Foto;

public interface IFotoDao {
	public void insertar(Foto foto);
	public List<Foto> listar();
	public void eliminar(int idFoto);
}
