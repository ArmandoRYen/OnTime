package pe.edu.upc.serviceimpl;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.upc.entity.Persona;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Persona persona;

	public LoginService() {
		this.persona = null;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void logout() {
		this.persona = null;
	}

}
