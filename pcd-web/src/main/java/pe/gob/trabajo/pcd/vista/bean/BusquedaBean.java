package pe.gob.trabajo.pcd.vista.bean;

import java.util.Date;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.RolLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaBean.
 */
public class BusquedaBean {

	/** The empresa. */
	Empresa empresa;
	
	/** The especialidad. */
	EspecialidadProfesional especialidad;
	
	/** The puesto. */
	Puesto puesto;
	
	/** The rol. */
	RolLaboral rol;
	
	/** The sector. */
	Sector sector;
	
	/** The tipo formacion. */
	TipoFormacion tipoFormacion;
	
	/** The formacion. */
	Formacion formacion;
	
	/** The profesional idioma. */
	ProfesionalIdioma profesionalIdioma;
	
	/** The profesional. */
	Profesional profesional;
	
	/** The disponibilidad inmediata. */
	Boolean disponibilidadInmediata;
	
	/** The edades. */
	String edades;
	//No mapeado
	/** The nivel educativo. */
	String nivelEducativo;
	
	/** The nivel idioma. */
	String nivelIdioma;
	
	/** The nivel educativo descripcion. */
	String nivelEducativoDescripcion;
	
	/** The nivel idioma descripcion. */
	String nivelIdiomaDescripcion;
	
	/** The ids cargos empleos. */
	String idsCargosEmpleos;
	
	/** The ids ocupaciones empleos. */
	String idsOcupacionesEmpleos;
	
	/** The ids empresas empleos. */
	String idsEmpresasEmpleos;
	
	/** The ids sectores empleos. */
	String idsSectoresEmpleos;
	
	/** The incluir cv. */
	Boolean incluirCV;
	
	/** The profesion. */
	Profesion profesion;
	
	/** The ids sectores empleos. */
	String idsLugaresResidenciaDep;
	String idsLugaresResidenciaProv;
	String idsLugaresResidenciaDis;
	
	/** The pedido. */
	Pedido pedido;
	Date   fechaRegistroIni;
	Date   fechaRegistroFin;
	

	/**
	 * Instantiates a new busqueda bean.
	 */
	public BusquedaBean() {
		init();
	}

	/**
	 * Inits the.
	 */
	public void init() {
		empresa = new Empresa();
		especialidad = new EspecialidadProfesional();
		puesto = new Puesto();
		sector = new Sector();
		rol = new RolLaboral();
		tipoFormacion = new TipoFormacion();
		formacion = new Formacion();
		profesionalIdioma = new ProfesionalIdioma();
		profesionalIdioma.setIdioma(new Idioma());
		profesional = new Profesional();
		profesional.setPersona(new Persona());
		profesional.getPersona().setLugarResidencia(new Ubigeo());
		disponibilidadInmediata = false;
		nivelEducativo=null;
		nivelIdioma=null;
		profesion = new Profesion();
		pedido	  = new Pedido();
		setFechaRegistroIni(null);
		setFechaRegistroFin(null);
	}

	/**
	 * Gets the nivel educativo.
	 *
	 * @return the nivel educativo
	 */
	public String getNivelEducativo() {
		return nivelEducativo;
	}

	/**
	 * Sets the nivel educativo.
	 *
	 * @param nivelEducativo the new nivel educativo
	 */
	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	/**
	 * Gets the nivel idioma.
	 *
	 * @return the nivel idioma
	 */
	public String getNivelIdioma() {
		return nivelIdioma;
	}

	/**
	 * Sets the nivel idioma.
	 *
	 * @param nivelIdioma the new nivel idioma
	 */
	public void setNivelIdioma(String nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

	
	/**
	 * @return the idsLugaresResidenciaDep
	 */
	public String getIdsLugaresResidenciaDep() {
		return idsLugaresResidenciaDep;
	}

	/**
	 * @param idsLugaresResidenciaDep the idsLugaresResidenciaDep to set
	 */
	public void setIdsLugaresResidenciaDep(String idsLugaresResidenciaDep) {
		this.idsLugaresResidenciaDep = idsLugaresResidenciaDep;
	}

	/**
	 * @return the idsLugaresResidenciaProv
	 */
	public String getIdsLugaresResidenciaProv() {
		return idsLugaresResidenciaProv;
	}

	/**
	 * @param idsLugaresResidenciaProv the idsLugaresResidenciaProv to set
	 */
	public void setIdsLugaresResidenciaProv(String idsLugaresResidenciaProv) {
		this.idsLugaresResidenciaProv = idsLugaresResidenciaProv;
	}

	/**
	 * @return the idsLugaresResidenciaDis
	 */
	public String getIdsLugaresResidenciaDis() {
		return idsLugaresResidenciaDis;
	}

	/**
	 * @param idsLugaresResidenciaDis the idsLugaresResidenciaDis to set
	 */
	public void setIdsLugaresResidenciaDis(String idsLugaresResidenciaDis) {
		this.idsLugaresResidenciaDis = idsLugaresResidenciaDis;
	}

	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Sets the empresa.
	 *
	 * @param empresa the new empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Gets the especialidad.
	 *
	 * @return the especialidad
	 */
	public EspecialidadProfesional getEspecialidad() {
		return especialidad;
	}

	/**
	 * Sets the especialidad.
	 *
	 * @param especialidad the new especialidad
	 */
	public void setEspecialidad(EspecialidadProfesional especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Gets the puesto.
	 *
	 * @return the puesto
	 */
	public Puesto getPuesto() {
		return puesto;
	}

	/**
	 * Sets the puesto.
	 *
	 * @param puesto the new puesto
	 */
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	/**
	 * Gets the sector.
	 *
	 * @return the sector
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * Sets the sector.
	 *
	 * @param sector the new sector
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	/**
	 * Gets the tipo formacion.
	 *
	 * @return the tipo formacion
	 */
	public TipoFormacion getTipoFormacion() {
		return tipoFormacion;
	}

	/**
	 * Sets the tipo formacion.
	 *
	 * @param tipoFormacion the new tipo formacion
	 */
	public void setTipoFormacion(TipoFormacion tipoFormacion) {
		this.tipoFormacion = tipoFormacion;
	}

	/**
	 * Gets the formacion.
	 *
	 * @return the formacion
	 */
	public Formacion getFormacion() {
		return formacion;
	}

	/**
	 * Sets the formacion.
	 *
	 * @param formacion the new formacion
	 */
	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}

	/**
	 * Gets the profesional idioma.
	 *
	 * @return the profesional idioma
	 */
	public ProfesionalIdioma getProfesionalIdioma() {
		return profesionalIdioma;
	}

	/**
	 * Sets the profesional idioma.
	 *
	 * @param profesionalIdioma the new profesional idioma
	 */
	public void setProfesionalIdioma(ProfesionalIdioma profesionalIdioma) {
		this.profesionalIdioma = profesionalIdioma;
	}

	/**
	 * Gets the profesional.
	 *
	 * @return the profesional
	 */
	public Profesional getProfesional() {
		return profesional;
	}

	/**
	 * Sets the profesional.
	 *
	 * @param profesional the new profesional
	 */
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	/**
	 * Gets the disponibilidad inmediata.
	 *
	 * @return the disponibilidad inmediata
	 */
	public Boolean getDisponibilidadInmediata() {
		return disponibilidadInmediata;
	}

	/**
	 * Sets the disponibilidad inmediata.
	 *
	 * @param disponibilidadInmediata the new disponibilidad inmediata
	 */
	public void setDisponibilidadInmediata(Boolean disponibilidadInmediata) {
		this.disponibilidadInmediata = disponibilidadInmediata;
	}

	/**
	 * Gets the edades.
	 *
	 * @return the edades
	 */
	public String getEdades() {
		return edades;
	}

	/**
	 * Sets the edades.
	 *
	 * @param edades the new edades
	 */
	public void setEdades(String edades) {
		this.edades = edades;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public RolLaboral getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(RolLaboral rol) {
		this.rol = rol;
	}
	
	/**
	 * Gets the nivel educativo descripcion.
	 *
	 * @return the nivel educativo descripcion
	 */
	public String getNivelEducativoDescripcion() {
		return nivelEducativoDescripcion;
	}

	/**
	 * Sets the nivel educativo descripcion.
	 *
	 * @param nivelEducativoDescripcion the new nivel educativo descripcion
	 */
	public void setNivelEducativoDescripcion(String nivelEducativoDescripcion) {
		this.nivelEducativoDescripcion = nivelEducativoDescripcion;
	}

	/**
	 * Gets the nivel idioma descripcion.
	 *
	 * @return the nivel idioma descripcion
	 */
	public String getNivelIdiomaDescripcion() {
		return nivelIdiomaDescripcion;
	}

	/**
	 * Sets the nivel idioma descripcion.
	 *
	 * @param nivelIdiomaDescripcion the new nivel idioma descripcion
	 */
	public void setNivelIdiomaDescripcion(String nivelIdiomaDescripcion) {
		this.nivelIdiomaDescripcion = nivelIdiomaDescripcion;
	}

	/**
	 * Gets the incluir cv.
	 *
	 * @return the incluir cv
	 */
	public Boolean getIncluirCV() {
		return incluirCV;
	}

	/**
	 * Sets the incluir cv.
	 *
	 * @param incluirCV the new incluir cv
	 */
	public void setIncluirCV(Boolean incluirCV) {
		this.incluirCV = incluirCV;
	}

	/**
	 * Gets the ids cargos empleos.
	 *
	 * @return the ids cargos empleos
	 */
	public String getIdsCargosEmpleos() {
		return idsCargosEmpleos;
	}

	/**
	 * Sets the ids cargos empleos.
	 *
	 * @param idsCargosEmpleos the new ids cargos empleos
	 */
	public void setIdsCargosEmpleos(String idsCargosEmpleos) {
		this.idsCargosEmpleos = idsCargosEmpleos;
	}

	/**
	 * Gets the ids ocupaciones empleos.
	 *
	 * @return the ids ocupaciones empleos
	 */
	public String getIdsOcupacionesEmpleos() {
		return idsOcupacionesEmpleos;
	}

	/**
	 * Sets the ids ocupaciones empleos.
	 *
	 * @param idsOcupacionesEmpleos the new ids ocupaciones empleos
	 */
	public void setIdsOcupacionesEmpleos(String idsOcupacionesEmpleos) {
		this.idsOcupacionesEmpleos = idsOcupacionesEmpleos;
	}

	/**
	 * Gets the ids empresas empleos.
	 *
	 * @return the ids empresas empleos
	 */
	public String getIdsEmpresasEmpleos() {
		return idsEmpresasEmpleos;
	}

	/**
	 * Sets the ids empresas empleos.
	 *
	 * @param idsEmpresasEmpleos the new ids empresas empleos
	 */
	public void setIdsEmpresasEmpleos(String idsEmpresasEmpleos) {
		this.idsEmpresasEmpleos = idsEmpresasEmpleos;
	}

	/**
	 * Gets the ids sectores empleos.
	 *
	 * @return the ids sectores empleos
	 */
	public String getIdsSectoresEmpleos() {
		return idsSectoresEmpleos;
	}

	/**
	 * Sets the ids sectores empleos.
	 *
	 * @param idsSectoresEmpleos the new ids sectores empleos
	 */
	public void setIdsSectoresEmpleos(String idsSectoresEmpleos) {
		this.idsSectoresEmpleos = idsSectoresEmpleos;
	}

	/**
	 * @return the profesion
	 */
	public Profesion getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion the profesion to set
	 */
	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Date getFechaRegistroIni() {
		return fechaRegistroIni;
	}

	public void setFechaRegistroIni(Date fechaRegistroIni) {
		this.fechaRegistroIni = fechaRegistroIni;
	}

	public Date getFechaRegistroFin() {
		return fechaRegistroFin;
	}

	public void setFechaRegistroFin(Date fechaRegistroFin) {
		this.fechaRegistroFin = fechaRegistroFin;
	}
	
}
