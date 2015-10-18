package pe.gob.trabajo.pcd.servicio.busqueda;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pe.gob.trabajo.pcd.servicio.comun.GenericService;
import pe.gob.trabajo.pcd.vista.bean.ReporteBean;
import pe.gob.trabajo.pcd.vista.bean.ReporteE1;
import pe.gob.trabajo.pcd.vista.bean.ReporteE2;
import pe.gob.trabajo.pcd.vista.bean.ReporteE3;
import pe.gob.trabajo.pcd.vista.bean.ReporteE4;
import pe.gob.trabajo.pcd.vista.bean.ReporteEmpresa;
import pe.gob.trabajo.pcd.vista.bean.ReporteOferta;
import pe.gob.trabajo.pcd.modelo.dominio.Capacitacion;
import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.Conocimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Preferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfesionalService.
 */
public interface ProfesionalService extends GenericService<Profesional> {

	/**
	 * Buscar profesionales.
	 *
	 * @param especialidades the especialidades
	 * @param puestos the puestos
	 * @param roles the roles
	 * @param empresas the empresas
	 * @param sectores the sectores
	 * @param tiposFormacion the tipos formacion
	 * @param nivelFormacion the nivel formacion
	 * @param camposEstudio the campos estudio
	 * @param idiomas the idiomas
	 * @param nivelIdioma the nivel idioma
	 * @param profesional the profesional
	 * @param edades the edades
	 * @param preferencias the preferencias
	 * @param ids the ids
	 * @return the list
	 */
	public List<Profesional> buscarProfesionales(String[] especialidades,
			String[] puestos, String[] roles, String[] empresas,
			String[] sectores, String[] tiposFormacion,
			String[] nivelFormacion, String[] camposEstudio, String[] idiomas,
			String[] nivelIdioma, Profesional profesional, Integer[] edades,
			String[] lugares, List<?> ids);

	/**
	 * Buscar profesional.
	 *
	 * @param ids the ids
	 * @return the list
	 */
	public List<Profesional> buscarProfesional(List<?> ids);

	/**
	 * Guardar certificacion.
	 *
	 * @param certificacion the certificacion
	 * @return the certificacion
	 */
	public Certificacion guardarCertificacion(Certificacion certificacion);

	/**
	 * Obtener idiomas.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<ProfesionalIdioma> obtenerIdiomas(Profesional profesional);

	/**
	 * Obtener certificaciones.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Certificacion> obtenerCertificaciones(Profesional profesional);
	
	/**
	 * Obtener certificaciones.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Capacitacion> obtenerCapacitaciones(Profesional profesional);
	
	/**
	 * Obtener certificaciones.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Conocimiento> obtenerConocimientos(Profesional profesional);
	
	

	/**
	 * Obtener experiencia especialidad.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<ExperienciaEspecialidad> obtenerExperienciaEspecialidad(
			Profesional profesional);

	/**
	 * Guardar idioma.
	 *
	 * @param idiomma the idiomma
	 * @return the profesional idioma
	 */
	public ProfesionalIdioma guardarIdioma(ProfesionalIdioma idiomma);

	/**
	 * Guardar preferencia.
	 *
	 * @param preferencia the preferencia
	 * @return the preferencia
	 */
	public Preferencia guardarPreferencia(Preferencia preferencia);

	/**
	 * Obtener preferencias.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Preferencia> obtenerPreferencias(Profesional profesional);

	/**
	 * Obtener referencias.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Referencia> obtenerReferencias(Profesional profesional);

	/**
	 * Guardar referencia.
	 *
	 * @param referencia the referencia
	 * @return the referencia
	 */
	public Referencia guardarReferencia(Referencia referencia);

	/**
	 * Guardar contacto.
	 *
	 * @param contacto the contacto
	 * @return the contacto
	 */
	public Contacto guardarContacto(Contacto contacto);
	
	/**
	 * Guardar Capacitacion.
	 *
	 * @param contacto the Capacitacion
	 * @return the Capacitacion
	 */
	public Capacitacion guardarCapacitacion(Capacitacion capacitacion);
	
	/**
	 * Guardar Conocimiento.
	 *
	 * @param contacto the Capacitacion
	 * @return the Capacitacion
	 */
	public Conocimiento guardarConocimiento(Conocimiento conocimiento);

	/**
	 * Guardar experiencia especialidad.
	 *
	 * @param experienciaEspecialidad the experiencia especialidad
	 * @return the experiencia especialidad
	 */
	public ExperienciaEspecialidad guardarExperienciaEspecialidad(
			ExperienciaEspecialidad experienciaEspecialidad);

	/**
	 * Obtener empleos.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<ExperienciaLaboral> obtenerEmpleos(Profesional profesional);

	/**
	 * Guardar empleo.
	 *
	 * @param empleo the empleo
	 * @return the experiencia laboral
	 */
	public ExperienciaLaboral guardarEmpleo(ExperienciaLaboral empleo);

	/**
	 * Obtener contactos.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Contacto> obtenerContactos(Profesional profesional);

	/**
	 * Obtener estudios.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Formacion> obtenerEstudios(Profesional profesional);

	/**
	 * Guardar estudio.
	 *
	 * @param formacion the formacion
	 * @return the formacion
	 */
	public Formacion guardarEstudio(Formacion formacion);

	/**
	 * Obtener preferencias sector.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Preferencia> obtenerPreferenciasSector(Profesional profesional);

	/**
	 * Obtener preferencias area.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Preferencia> obtenerPreferenciasArea(Profesional profesional);

	/**
	 * Obtener preferencias ciudad.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Preferencia> obtenerPreferenciasCiudad(Profesional profesional);

	/**
	 * Guardar preferencias.
	 *
	 * @param areas the areas
	 * @param sectores the sectores
	 * @param ciudades the ciudades
	 * @param profesional the profesional
	 * @return the int
	 */
	public int guardarPreferencias(List areas, List sectores, List ciudades,
			Profesional profesional);

	/**
	 * Obtener profesional.
	 *
	 * @param persona the persona
	 * @return the profesional
	 */
	public Profesional obtenerProfesional(Persona persona);

	/**
	 * Buscar profesionales.
	 *
	 * @param direcciones the direcciones
	 * @param profesionales the profesionales
	 * @param tecnicos the tecnicos
	 * @param operativos the operativos
	 * @param noCalificados the no calificados
	 * @return the list
	 */
	public List<ReporteE1> getReporteE1(String[] direcciones,
			String[] profesionales, String[] tecnicos, String[] operativos,
			String[] noCalificados, String fechaInicio, String fechaFin);
	
	public List<ReporteE2> getReporteE2(String[] grupo1, String[] grupo2,String[] grupo3, String[] grupo4, String[] grupo5,String[] grupo6,String[] grupo7, String[] grupo8, String[] grupo9, String[] grupo10, String[] grupo11, String[] grupo12, String fechaInicio, String fechaFin);
	
	public List<ReporteE3> getReporteE3(String fechaInicio, String fechaFin);
	
	public List<ReporteE4> getReporteE4(String[] grupo1, String[] grupo2,String[] grupo3, String[] grupo4, String[] grupo5,String[] grupo6,String[] grupo7, String[] grupo8, String[] grupo9, String[] grupo10, String[] grupo11, String[] grupo12, String fechaInicio, String fechaFin);

	public List<ReporteOferta> buscarPorRangoFecha(String fechaInicio, String fechaFin);
	
	public List<Postulacion> obtenerPostulaciones(Profesional profesional);
	
	public List<Profesional> buscarProfesionales(List<Long> idConsultores, List<String> idOficinas, Date fechaInicio, Date fechaFin);
	
}
