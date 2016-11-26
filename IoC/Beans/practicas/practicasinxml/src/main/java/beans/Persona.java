package beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Persona {
	@Autowired
	private String nombre;
	@Autowired
	private List<Rol> roles;

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", roles=" + roles + "]";
	}

}
