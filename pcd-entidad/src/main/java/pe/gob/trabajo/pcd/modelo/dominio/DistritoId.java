package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1

/**
 * TiprfPrfsnalPreferenciaId generated by hbm2java
 */
public class DistritoId implements java.io.Serializable {

	private static final long serialVersionUID = -4289702337165151550L;

	private String idDistrito;
	private String idProvincia;
	private String idDepartamento;

	public DistritoId() {
	}

	public DistritoId(String idDistrito, String idProvincia,
			String idDepartamento) {
		super();
		this.idDistrito = idDistrito;
		this.idProvincia = idProvincia;
		this.idDepartamento = idDepartamento;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDepartamento == null) ? 0 : idDepartamento.hashCode());
		result = prime * result
				+ ((idDistrito == null) ? 0 : idDistrito.hashCode());
		result = prime * result
				+ ((idProvincia == null) ? 0 : idProvincia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistritoId other = (DistritoId) obj;
		if (idDepartamento == null) {
			if (other.idDepartamento != null)
				return false;
		} else if (!idDepartamento.equals(other.idDepartamento))
			return false;
		if (idDistrito == null) {
			if (other.idDistrito != null)
				return false;
		} else if (!idDistrito.equals(other.idDistrito))
			return false;
		if (idProvincia == null) {
			if (other.idProvincia != null)
				return false;
		} else if (!idProvincia.equals(other.idProvincia))
			return false;
		return true;
	}

}