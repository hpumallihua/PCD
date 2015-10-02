package pe.gob.trabajo.pcd.modelo.dao;

import java.util.Collection;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaIntegranteFamilia;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaNecesidadApoyo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;


// TODO: Auto-generated Javadoc
/**
 * The Interface PersonaDAO.
 */
public interface PersonaDAO extends GenericDao<Persona, Long> {
	
	/**
	 * Buscar por documento identidad.
	 *
	 * @param idTipo the id tipo
	 * @param numero the numero
	 * @return the persona
	 */
	public Persona buscarPorDocumentoIdentidad(String idTipo, String numero);
	
	/**
	 * Buscar por ejemplo.
	 *
	 * @param bean the bean
	 * @return the list
	 */
	public List<Persona> buscarPorEjemplo(Persona bean);
	
	/**
	 * Buscar usuario por usuario clave.
	 *
	 * @param usuario the usuario
	 * @param clave the clave
	 * @return objeto usuario
	 */
	public Usuario buscarUsuarioPorUsuarioClave(String usuario, String clave);
	
	/**
	 * Buscar persona por documento clave.
	 *
	 * @param documento the documento
	 * @param clave the clave
	 * @return the persona
	 */
	public Persona buscarPersonaPorDocumentoClave(String documento, String clave);
	
	/**
	 * Buscar por texto.
	 *
	 * @param personaTexto the persona texto
	 * @return lista de personas
	 */
	public List<Persona> buscarPorTexto(String personaTexto);
	
	/**
	 * Buscar profesional por documento identidad.
	 *
	 * @param idTipo the id tipo
	 * @param numero the numero
	 * @return lista de profesionales
	 */
	public Profesional buscarProfesionalPorDocumentoIdentidad(String idTipo, String numero);
	
	/**
	 * Obtener contactos.
	 *
	 * @param persona the persona
	 * @return lista de contactos
	 */
	public List<Contacto> obtenerContactos(Persona persona);
	
	/**
	 * Obtener contactos2.
	 *
	 * @param persona the persona
	 * @return lista de contactos 
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
	 * Buscar por nombres.
	 *
	 * @param personaNombres the persona nombres
	 * @return the list
	 */
	public List<Persona> buscarPorNombres(String personaNombres);
	
//	public List<Discapacidad> obtenerDiscapacidades(Long idPersona);
		/**
	 * Eliminar discapacidades.
	 *
	 * @param idPersona the id persona
	 * @return the int
	 */
	public int eliminarDiscapacidades(Long idPersona);
	
	/**
	 * Borrar contacto medios.
	 *
	 * @param medios the medios
	 * @param contacto the contacto
	 * @return the int
	 */
	public int borrarContactoMedios(Collection<ContactoMedio> medios, Contacto contacto);
	
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
	
	public List<Persona> obtenerConsultores();
}
