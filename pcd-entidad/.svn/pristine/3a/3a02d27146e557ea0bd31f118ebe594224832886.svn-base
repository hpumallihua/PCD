package pe.gob.trabajo.pcd.modelo.dominio;

import java.util.Date;

public class BeanEntidadGenericoAutogeneradoValidable extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {
	private static final long serialVersionUID = 4172008138838921951L;
	
	private Long idUsroValidador;
	private Date fechaValidacion;
	private Character validado;
	
	public Long getIdUsroValidador() {
		return idUsroValidador;
	}
	public void setIdUsroValidador(Long idUsroValidador) {
		this.idUsroValidador = idUsroValidador;
	}
	public Date getFechaValidacion() {
		return fechaValidacion;
	}
	public void setFechaValidacion(Date fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}
	public Character getValidado() {
		return validado;
	}
	public void setValidado(Character validado) {
		this.validado = validado;
	}
	
	public void cambiarValidacion(Character valido, Character invalido, Long idUsuario) {
		if (validado != null && validado.equals(valido)) {
			validado = invalido;
		} else {
			validado = valido;
		}
		this.setIdUsroValidador(idUsuario);
		this.setFechaValidacion(new Date());
	}
}
