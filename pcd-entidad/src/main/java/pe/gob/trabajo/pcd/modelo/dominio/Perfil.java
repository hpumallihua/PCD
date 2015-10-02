package pe.gob.trabajo.pcd.modelo.dominio;

public class Perfil {

	private static final long serialVersionUID = 1088108989769380409L;

	private PerfilId id;
	private Sistema sistema;
	private String nombre;
	private String abreviatura;

	public PerfilId getId() {
		return id;
	}

	public void setId(PerfilId id) {
		this.id = id;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}
