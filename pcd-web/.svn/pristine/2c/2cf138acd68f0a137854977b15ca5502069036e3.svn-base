package pe.gob.trabajo.pcd.servicio.comun;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dao.PersonaDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaIntegranteFamilia;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaNecesidadApoyo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;

// TODO: Auto-generated Javadoc
/**
 * The Interface PersonaService.
 */
public interface PersonaService extends GenericService<Persona> {
	
	/**
	 * Gets the persona dao.
	 *
	 * @return the persona dao
	 */
	public PersonaDAO getPersonaDAO();
	
	/**
	 * Buscar por documento identidad.
	 *
	 * @param idTipo the id tipo
	 * @param numero the numero
	 * @return the persona
	 */
	public Persona buscarPorDocumentoIdentidad(String idTipo, String numero);
	
	/**
	 * Guardar persona.
	 *
	 * @param persona the persona
	 * @return the persona
	 */
	public Persona guardarPersona(Persona persona);
	
	/**
	 * Obtener contactos.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<Contacto> obtenerContactos(Persona persona);
	
	/**
	 * Obtener contactos2.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<Contacto> obtenerContactos2(Persona persona);
	
	/**
	 * Obtener contacto.
	 *
	 * @param persona the persona
	 * @return the contacto
	 */
	public Contacto obtenerContacto(Persona persona);
	
	/**
	 * Obtener contacto medios.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<ContactoMedio> obtenerContactoMedios(Persona persona);
	
	/**
	 * Obtener contacto medios.
	 *
	 * @param contacto the contacto
	 * @param tipoContacto the tipo contacto
	 * @return the list
	 */
	public List<ContactoMedio> obtenerContactoMedios(Contacto contacto, TipoContacto tipoContacto);
	
	/**
	 * Obtener tipo contactos.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<TipoContacto> obtenerTipoContactos(Persona persona);
	
	/**
	 * Buscar por ejemplo.
	 *
	 * @param bean the bean
	 * @return the list
	 */
	public List<Persona> buscarPorEjemplo(Persona bean);
	
	/**
	 * Buscar por usuario clave.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @param clave the clave
	 * @return the persona
	 */
	public Persona buscarPorUsuarioClave(String nombreUsuario, String clave);
	
	/**
	 * Buscar por texto.
	 *
	 * @param personaTexto the persona texto
	 * @return the list
	 */
	public List<Persona> buscarPorTexto(String personaTexto);
	
	/**
	 * Buscar profesional por documento identidad.
	 *
	 * @param idTipo the id tipo
	 * @param numero the numero
	 * @return the profesional
	 */
	public Profesional buscarProfesionalPorDocumentoIdentidad(String idTipo, String numero);
	
	/**
	 * Guardar contacto.
	 *
	 * @param contacto the contacto
	 * @param medios the medios
	 * @return the contacto
	 */
	public Contacto guardarContacto(Contacto contacto, Collection<ContactoMedio> medios);
	
	/**
	 * Buscar por nombres.
	 *
	 * @param personaNombres the persona nombres
	 * @return the list
	 */
	public List<Persona> buscarPorNombres(String personaNombres);
	
	public Persona buscarPersona(String dni, Date fechaNacimiento, String sexo);
	
	/**
	 * Obtener necesidades de apoyo.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<PersonaNecesidadApoyo> obtenerNecesidadesApoyo(Persona persona);
	
	/**
	 * Obtener Integrantes Familia.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<PersonaIntegranteFamilia> obtenerIntegrantesFamilia(Persona persona);
	
	public List<Persona> buscarConsultores();
}
