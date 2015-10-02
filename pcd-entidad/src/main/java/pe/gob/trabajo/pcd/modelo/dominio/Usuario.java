package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1


/**
 * TiprmUsuario generated by hbm2java
 */
public class Usuario extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {
	
	private static final long serialVersionUID = -9210993854765871966L;
	
	private Persona persona;
	private Empresa empresa;
	private Rol rol;
	private String nombreUsuario;
	private String claveUsuario;
	private String codigoOficinaAsociada;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClaveUsuario() {
		return claveUsuario;
	}
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	
	
	/**
	 * @return the codigoOficinaAsociada
	 */
	public String getCodigoOficinaAsociada() {
		return codigoOficinaAsociada;
	}
	/**
	 * @param codigoOficinaAsociada the codigoOficinaAsociada to set
	 */
	public void setCodigoOficinaAsociada(String codigoOficinaAsociada) {
		this.codigoOficinaAsociada = codigoOficinaAsociada;
	}
	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String getAuditData() {
		return "Usuario ["
				+ (nombreUsuario != null ? "nombreUsuario=" + nombreUsuario
						+ ", " : "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", "
						: "")
				+ (flag != null ? "flag=" + flag + ", " : "")
				+ (estadoRegistro != null ? "estadoRegistro=" + estadoRegistro
						+ ", " : "")
				+ (fechaCreacion != null ? "fechaCreacion=" + fechaCreacion
						+ ", " : "")
				+ (fechaActualizacion != null ? "fechaActualizacion="
						+ fechaActualizacion + ", " : "")
				+ (idUsuarioCreador != null ? "idUsuarioCreador="
						+ idUsuarioCreador + ", " : "")
				+ (idUsroActualizador != null ? "idUsroActualizador="
						+ idUsroActualizador : "") + "]";
	}	
}