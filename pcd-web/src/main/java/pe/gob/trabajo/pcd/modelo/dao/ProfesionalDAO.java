package pe.gob.trabajo.pcd.modelo.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Preferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.vista.bean.ReporteBean;
import pe.gob.trabajo.pcd.vista.bean.ReporteE1;
import pe.gob.trabajo.pcd.vista.bean.ReporteE2;
import pe.gob.trabajo.pcd.vista.bean.ReporteE3;
import pe.gob.trabajo.pcd.vista.bean.ReporteE4;
import pe.gob.trabajo.pcd.vista.bean.ReporteOferta;


// TODO: Auto-generated Javadoc
/**
 * The Interface ProfesionalDAO.
 */
public interface ProfesionalDAO extends GenericDao<Profesional, Long> {
	
	/**
	 * Buscar profesional.
	 *
	 * @param criterios <[deficinicion de clase],[<[nombre atributo], [lista objetos/valores]>]>
	 * @param ids the ids
	 * @return lista de profesionales
	 */
	public List<Profesional> buscarProfesional(HashMap<String, HashMap<String, List<?>>> criterios, List<?> ids);
	
	/**
	 * Buscar profesional.
	 *
	 * @param criterios the criterios
	 * @param o the o
	 * @return lista de profesionales
	 */
	public List<Profesional> buscarProfesional(HashMap<String, Object> criterios, Object o);
	
	/**
	 * Buscar profesional.
	 *
	 * @param ids the ids
	 * @return the list
	 */
	public List<Profesional> buscarProfesional(List<?> ids);
	
	/**
	 * Buscar preferencias area.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Area> buscarPreferenciasArea(Profesional profesional);
//	public List<Sector> buscarPreferenciasSector(Profesional profesional);
	/**
 * Buscar preferencias ciudad.
 *
 * @param profesional the profesional
 * @return the list
 */
public List<Ubigeo> buscarPreferenciasCiudad(Profesional profesional);
	
	/**
	 * Buscar referencias.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Referencia> buscarReferencias(Profesional profesional);
	
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
	 * Obtener referencias.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<Referencia> obtenerReferencias(Profesional profesional);
	
	/**
	 * Obtener experiencia especialidad.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<ExperienciaEspecialidad> obtenerExperienciaEspecialidad(Profesional profesional);
	
	/**
	 * Obtener empleos.
	 *
	 * @param profesional the profesional
	 * @return the list
	 */
	public List<ExperienciaLaboral> obtenerEmpleos(Profesional profesional);
	
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
	 * Borrar preferencias.
	 *
	 * @param preferencias the preferencias
	 * @param tipo the tipo
	 * @param idProfesional the id profesional
	 * @return the int
	 */
	public int borrarPreferencias(List<Preferencia> preferencias, Long tipo, Long idProfesional);
	
	/**
	 * Buscar preferencias.
	 *
	 * @param tipo the tipo
	 * @param idProfesional the id profesional
	 * @return the list
	 */
	public List<Preferencia> buscarPreferencias(Long tipo, Long idProfesional);
	
	/**
	 * Buscar profesional.
	 *
	 * @param criterios the criterios
	 * @return the list
	 */
	public List<ReporteE1> getReporteE1(HashMap<String, HashMap<String, List<?>>> criterios, String fechaInicio, String fechaFin);
	
	public List<ReporteE2> getReporteE2(HashMap<String, HashMap<String, List<?>>> criterios,String fechaInicio, String fechaFin);
	
	public List<ReporteE3> getReporteE3(String fechaInicio, String fechaFin);
	
	public List<ReporteE4> getReporteE4(HashMap<String, HashMap<String, List<?>>> criterios,String fechaInicio, String fechaFin);
	
	public List<ReporteOferta> buscarPorRangoFecha(String fechaInicio, String fechaFin);
	
	public List<Postulacion> obtenerPostulaciones(Profesional profesional);
	
	public List<Profesional> buscarProfesional(List<Long> idConsultores, List<String> idOficinas, Date fechaInicio, Date fechaFin);
	
}