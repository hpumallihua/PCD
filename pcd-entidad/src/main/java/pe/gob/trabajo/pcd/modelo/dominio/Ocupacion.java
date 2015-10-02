package pe.gob.trabajo.pcd.modelo.dominio;

public class Ocupacion {

	private static final long serialVersionUID = 1088108989769380409L;

	private String id;
	private GrupoOcupacion grupoOcupacion;
	private String descripcion;
	private Integer flgsunmin;
	private String flginei;

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

	

	public GrupoOcupacion getGrupoOcupacion() {
		return grupoOcupacion;
	}

	public void setGrupoOcupacion(GrupoOcupacion grupoOcupacion) {
		this.grupoOcupacion = grupoOcupacion;
	}

	public Integer getFlgsunmin() {
		return flgsunmin;
	}

	public void setFlgsunmin(Integer flgsunmin) {
		this.flgsunmin = flgsunmin;
	}

	public String getFlginei() {
		return flginei;
	}

	public void setFlginei(String flginei) {
		this.flginei = flginei;
	}

}
