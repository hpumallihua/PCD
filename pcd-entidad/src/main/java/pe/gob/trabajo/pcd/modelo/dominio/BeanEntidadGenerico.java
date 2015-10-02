package pe.gob.trabajo.pcd.modelo.dominio;

import java.util.Date;

public class BeanEntidadGenerico implements java.io.Serializable {
	
	private static final long serialVersionUID = -8570457436165882563L;
	
	protected String descripcion;
	protected String flag;
	protected Character estadoRegistro;
	protected Date fechaCreacion;
	protected Date fechaActualizacion;
	protected Long idUsuarioCreador;
	protected Long idUsroActualizador;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Character getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(Character estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Long getIdUsuarioCreador() {
		return idUsuarioCreador;
	}
	public void setIdUsuarioCreador(Long idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}
	public Long getIdUsroActualizador() {
		return idUsroActualizador;
	}
	public void setIdUsroActualizador(Long idUsroActualizador) {
		this.idUsroActualizador = idUsroActualizador;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFlag() {
		return flag;
	}
	
	public String getAuditData() {
		return "BeanEntidadGenerico [descripcion=" + descripcion + ", flag="
				+ flag + ", estadoRegistro=" + estadoRegistro
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", idUsuarioCreador=" + idUsuarioCreador
				+ ", idUsroActualizador=" + idUsroActualizador + "]";
	}
	
}
