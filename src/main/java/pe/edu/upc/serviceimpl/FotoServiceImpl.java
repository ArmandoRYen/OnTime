package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IFotoDao;
import pe.edu.upc.entity.Foto;
import pe.edu.upc.service.IFotoService;

@Named
@RequestScoped
public class FotoServiceImpl implements IFotoService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private IFotoDao ftD;

	@Override
	public void insertar(Foto foto) {
		ftD.insertar(foto);		
	}

	@Override
	public List<Foto> listar() {
		return ftD.listar();
	}

	@Override
	public void eliminar(int idFoto) {
		ftD.eliminar(idFoto);		
	}
	@Override
	public List<Foto>findbyName(Foto f){
		return ftD.find(f);
	}
}
