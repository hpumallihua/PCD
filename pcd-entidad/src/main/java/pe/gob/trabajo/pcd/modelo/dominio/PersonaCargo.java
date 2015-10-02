package pe.gob.trabajo.pcd.modelo.dominio;

public class PersonaCargo {

	private static final long serialVersionUID = 1088108989769380409L;

	private String id;
	private String nombre;
	private String descripcion;
	private String flgAct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFlgAct() {
		return flgAct;
	}

	public void setFlgAct(String flgAct) {
		this.flgAct = flgAct;
	}

}
