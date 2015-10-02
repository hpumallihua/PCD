package pe.gob.trabajo.pcd.modelo.dominio;

public class Nivel {

	private static final long serialVersionUID = 1088108989769380409L;

	private Long id;
	private String descripcion;
	private String flgAct;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFlgAct() {
		return flgAct;
	}

	public void setFlgAct(String flgAct) {
		this.flgAct = flgAct;
	}

}
