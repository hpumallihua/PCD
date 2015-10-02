package pe.gob.trabajo.pcd.modelo.dominio;

import java.io.Serializable;

public class PersonId implements Serializable {

	private static final long serialVersionUID = 1088108989769380409L;

	private String numdoc;
	private String idTipoDocumento;

	public PersonId() {
		super();
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTipoDocumento == null) ? 0 : idTipoDocumento.hashCode());
		result = prime * result + ((numdoc == null) ? 0 : numdoc.hashCode());
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
		PersonId other = (PersonId) obj;
		if (idTipoDocumento == null) {
			if (other.idTipoDocumento != null)
				return false;
		} else if (!idTipoDocumento.equals(other.idTipoDocumento))
			return false;
		if (numdoc == null) {
			if (other.numdoc != null)
				return false;
		} else if (!numdoc.equals(other.numdoc))
			return false;
		return true;
	}

}
