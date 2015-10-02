package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1


/**
 * TiprfPrfsnalCertificacion generated by hbm2java
 */
public class Certificacion extends BeanEntidadGenericoAutogeneradoValidable implements java.io.Serializable {
	
	private static final long serialVersionUID = -1110807273537100315L;
	
//	private EspecialidadProfesional especialidadProfesional;
	private Profesional profesional;
	private String nombre;
	private Integer anio;
	private Integer vigenteHasta;
	
	private String idOcupacion;
	private String descripcionOcupacion;
	private String descripcionObjetoOcupacion;
	
//	public EspecialidadProfesional getEspecialidadProfesional() {
//		return especialidadProfesional;
//	}
//	public void setEspecialidadProfesional(
//			EspecialidadProfesional especialidadProfesional) {
//		this.especialidadProfesional = especialidadProfesional;
//	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getVigenteHasta() {
		return vigenteHasta;
	}
	public void setVigenteHasta(Integer vigenteHasta) {
		this.vigenteHasta = vigenteHasta;
	}
	public String getIdOcupacion() {
		return idOcupacion;
	}
	public void setIdOcupacion(String idOcupacion) {
		this.idOcupacion = idOcupacion;
	}
	public String getDescripcionOcupacion() {
		return descripcionOcupacion;
	}
	public void setDescripcionOcupacion(String descripcionOcupacion) {
		this.descripcionOcupacion = descripcionOcupacion;
	}
	/**
	 * @return the descripcionObjetoOcupacion
	 */
	public String getDescripcionObjetoOcupacion() {
		return descripcionObjetoOcupacion;
	}
	/**
	 * @param descripcionObjetoOcupacion the descripcionObjetoOcupacion to set
	 */
	public void setDescripcionObjetoOcupacion(String descripcionObjetoOcupacion) {
		this.descripcionObjetoOcupacion = descripcionObjetoOcupacion;
	}
	
}