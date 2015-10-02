package pe.gob.trabajo.pcd.modelo.dominio;

import java.io.Serializable;

public class EmpresaRHId implements Serializable {
	
	private static final long serialVersionUID = 7732945327488399967L;
	
	String ruc;
	String ubigeo;
	
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmpresaRHId))
			return false;
		EmpresaRHId castOther = (EmpresaRHId) other;

		return (this.getRuc() == castOther.getRuc())
				&& ((this.getUbigeo() == castOther.getUbigeo()) || (this
						.getRuc() != null
						&& castOther.getRuc() != null && this
						.getRuc().equals(castOther.getRuc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getUbigeo().hashCode();
		result = 37 * result
				+ (getRuc() == null ? 0 : this.getRuc().hashCode());
		return result;
	}
}
