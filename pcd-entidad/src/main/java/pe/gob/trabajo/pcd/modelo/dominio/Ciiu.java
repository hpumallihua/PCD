package pe.gob.trabajo.pcd.modelo.dominio;

public class Ciiu {

	private static final long serialVersionUID = 1088108989769380409L;

	private String id;
	private String descripcion;
	private Integer flgsunmin;
	private String ciiuSunat;

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

	public Integer getFlgsunmin() {
		return flgsunmin;
	}

	public void setFlgsunmin(Integer flgsunmin) {
		this.flgsunmin = flgsunmin;
	}

	public String getCiiuSunat() {
		return ciiuSunat;
	}

	public void setCiiuSunat(String ciiuSunat) {
		this.ciiuSunat = ciiuSunat;
	}

}
