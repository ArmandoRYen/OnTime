package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.TipoQuehacer;

public interface ITipoQuehacerDao {
	public void Insertar(TipoQuehacer tipoquehacer);
	public void Eliminar (int idtipoquehacer);
	public List<TipoQuehacer> listar();
	
	
	
	
	
}
