package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.TipoQuehacer;

public interface ITipoQuehacerService {
	public void Insertar(TipoQuehacer tipoquehacer);
	public void Eliminar (int idtipoquehacer);
	public List<TipoQuehacer> listar();
	
	
	
}
