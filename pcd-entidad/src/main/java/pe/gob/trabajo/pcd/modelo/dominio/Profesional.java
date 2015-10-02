package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1

import java.util.ArrayList;
import java.util.List;

/**
 * TiprfProfesional generated by hbm2java
 */
public class Profesional extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {
	
	private static final long serialVersionUID = 1801830648122847506L;
	
	private Persona persona;
	private String curriculum;
	private String empleoDeseado;
	private Integer tipoTrabajo;
	private Double sueldoMinimo;
	private Double sueldoMaximo;
	private Integer trabajarFuera;
	private Integer disponibilidadContratacion;
	private Integer disponibilidadTiempo;
	private Integer situacionActual;
	private Integer categoriaLicenciaDeConducir;
	private String codigoOficinaAsociada;
	/**
	 * @return the categoriaLicenciaDeConducir
	 */
	public Integer getCategoriaLicenciaDeConducir() {
		return categoriaLicenciaDeConducir;
	}
	/**
	 * @param categoriaLicenciaDeConducir the categoriaLicenciaDeConducir to set
	 */
	public void setCategoriaLicenciaDeConducir(Integer categoriaLicenciaDeConducir) {
		this.categoriaLicenciaDeConducir = categoriaLicenciaDeConducir;
	}

	private List<Preferencia> preferencias = new ArrayList<Preferencia>();
	private List<ProfesionalIdioma> idiomas = new ArrayList<ProfesionalIdioma>();
	private List<Referencia> referencias = new ArrayList<Referencia>();
	private List<Certificacion> certificaciones = new ArrayList<Certificacion>();
	private List<Formacion> formaciones = new ArrayList<Formacion>();
	private List<ExperienciaLaboral> experienciasLaborales = new ArrayList<ExperienciaLaboral>();
	private List<ExperienciaEspecialidad> experienciasEspecialidad = new ArrayList<ExperienciaEspecialidad>();
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String getEmpleoDeseado() {
		return empleoDeseado;
	}
	public void setEmpleoDeseado(String empleoDeseado) {
		this.empleoDeseado = empleoDeseado;
	}
	public Integer getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(Integer tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public Double getSueldoMinimo() {
		return sueldoMinimo;
	}
	public void setSueldoMinimo(Double sueldoMinimo) {
		this.sueldoMinimo = sueldoMinimo;
	}
	public Double getSueldoMaximo() {
		return sueldoMaximo;
	}
	public void setSueldoMaximo(Double sueldoMaximo) {
		this.sueldoMaximo = sueldoMaximo;
	}
	public Integer getTrabajarFuera() {
		return trabajarFuera;
	}
	public void setTrabajarFuera(Integer trabajarFuera) {
		this.trabajarFuera = trabajarFuera;
	}
	public Integer getDisponibilidadContratacion() {
		return disponibilidadContratacion;
	}
	public void setDisponibilidadContratacion(Integer disponibilidadContratacion) {
		this.disponibilidadContratacion = disponibilidadContratacion;
	}
	public Integer getDisponibilidadTiempo() {
		return disponibilidadTiempo;
	}
	public void setDisponibilidadTiempo(Integer disponibilidadTiempo) {
		this.disponibilidadTiempo = disponibilidadTiempo;
	}
	public Integer getSituacionActual() {
		return situacionActual;
	}
	public void setSituacionActual(Integer situacionActual) {
		this.situacionActual = situacionActual;
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
	public List<Preferencia> getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
	public List<ProfesionalIdioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<ProfesionalIdioma> idiomas) {
		this.idiomas = idiomas;
	}
	public List<Referencia> getReferencias() {
		return referencias;
	}
	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	public List<Certificacion> getCertificaciones() {
		return certificaciones;
	}
	public void setCertificaciones(List<Certificacion> certificaciones) {
		this.certificaciones = certificaciones;
	}
	public List<Formacion> getFormaciones() {
		return formaciones;
	}
	public void setFormaciones(List<Formacion> formaciones) {
		this.formaciones = formaciones;
	}
	public List<ExperienciaLaboral> getExperienciasLaborales() {
		return experienciasLaborales;
	}
	public void setExperienciasLaborales(
			List<ExperienciaLaboral> experienciasLaborales) {
		this.experienciasLaborales = experienciasLaborales;
	}
	public List<ExperienciaEspecialidad> getExperienciasEspecialidad() {
		return experienciasEspecialidad;
	}
	public void setExperienciasEspecialidad(
			List<ExperienciaEspecialidad> experienciasEspecialidad) {
		this.experienciasEspecialidad = experienciasEspecialidad;
	}
	
	public Boolean getTrabajoFuera() {
		Boolean retorno = false;
		if (trabajarFuera != null && !trabajarFuera.equals(0)) {
			retorno = true;
		}
		return retorno;
	}
	
	public void setTrabajoFuera(Boolean cnd) {
		this.trabajarFuera = null;
		if (cnd) {
			this.trabajarFuera = 1;
		}
	}
}
