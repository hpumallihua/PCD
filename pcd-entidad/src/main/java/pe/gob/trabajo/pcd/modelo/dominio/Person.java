package pe.gob.trabajo.pcd.modelo.dominio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 1088108989769380409L;
	
	private String dni;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String fechaNacimientoNoEstandar;
	private String codigoSexo;
	private String codigoUbigeo;
	private Date fechaNacimiento;
	
	private DateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the fechaNacimientoNoEstandar
	 */
	public String getFechaNacimientoNoEstandar() {
		return fechaNacimientoNoEstandar;
	}
	/**
	 * @param fechaNacimientoNoEstandar the fechaNacimientoNoEstandar to set
	 */
	public void setFechaNacimientoNoEstandar(String fechaNacimientoNoEstandar) {
		this.fechaNacimientoNoEstandar = fechaNacimientoNoEstandar;
	}
	/**
	 * @return the codigoSexo
	 */
	public String getCodigoSexo() {
		return codigoSexo;
	}
	/**
	 * @param codigoSexo the codigoSexo to set
	 */
	public void setCodigoSexo(String codigoSexo) {
		this.codigoSexo = codigoSexo;
	}
	/**
	 * @return the codigoUbigeo
	 */
	public String getCodigoUbigeo() {
		return codigoUbigeo;
	}
	/**
	 * @param codigoUbigeo the codigoUbigeo to set
	 */
	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		try {
			fechaNacimiento = df.parse(fechaNacimientoNoEstandar);
		} catch (ParseException e) {
			e.printStackTrace();
			fechaNacimiento = new Date();
		}
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
