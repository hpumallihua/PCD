package pe.gob.trabajo.pcd.modelo.dao;

import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Parametro;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.RolLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;

// TODO: Auto-generated Javadoc
/**
 * Interface MaestroDAO.
 */
public interface MaestroDAO extends GenericDao<Object, Long> {
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
	
	public Usuario buscarUsuario(String nombreUsuario, String claveUsuario);
	
	public Usuario buscarUsuarioPorIdPersona(Long idPersona);
	
	/**
	 * Buscar empresas.
	 *
	 * @param empresa the empresa
	 * @return lista de empresas
	 */
	public List<Empresa> buscarEmpresas(Empresa empresa);
	
	/**
	 * Buscar personas.
	 *
	 * @param persona the persona
	 * @return lista de personas
	 */
	public List<Persona> buscarPersonas(Persona persona);
	
	/**
	 * Obtener empresa.
	 *
	 * @param empresa 
	 * @return objeto empresa
	 */
	public Empresa obtenerEmpresa(Empresa empresa);
	
	/**
	 * busqueda de the lugares.
	 *
	 * @param lugar the lugar
	 * @return the lugares
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.Ubigeo> getLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo lugar);
	
	/**
	 * Buscar especialidades.
	 *
	 * @param especialidad the especialidad
	 * @return lista de especialidades
	 */
	public List<EspecialidadProfesional> buscarEspecialidades(EspecialidadProfesional especialidad);
	
	/**
	 * Buscar puestos.
	 *
	 * @param especialidad the especialidad
	 * @return lista de rol laboral
	 */
	public List<RolLaboral> buscarPuestos(RolLaboral especialidad);
	
	/**
	 * Buscar sectores.
	 *
	 * @param sector 
	 * @return lista de sectores
	 */
	public List<Sector> buscarSectores(Sector sector);
	
	/**
	 * Buscar campo estudio.
	 *
	 * @param campo 
	 * @return lista de campo estudio
	 */
	public List<String> buscarCampoEstudio(String campo);
	
	/**
	 * Buscar lugares.
	 *
	 * @param lugar 
	 * @return lista de ubigeo
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.Ubigeo> buscarLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo lugar);
	
	/**
	 * Buscar puestos.
	 *
	 * @param puesto 
	 * @return lista de puestos
	 */
	public List<Puesto> buscarPuestos(Puesto puesto);
	
	/**
	 * Buscar tipo referencia.
	 *
	 * @param tipoReferencia the tipo referencia
	 * @return lista de tipo referencia
	 */
	public List<TipoReferencia> buscarTipoReferencia(TipoReferencia tipoReferencia);
	
	/**
	 * Buscar tipos formacion.
	 *
	 * @param tipoFormacion the tipo formacion
	 * @return lista de tipo formacion
	 */
	public List<TipoFormacion> buscarTiposFormacion(TipoFormacion tipoFormacion);
	
	/**
	 * Buscar nivel formacion.
	 *
	 * @param nivelFormacion the nivel formacion
	 * @return lista de nivel formacion
	 */
	public List<NivelFormacion> buscarNivelFormacion(NivelFormacion nivelFormacion);
	
	/**
	 * Buscar idioma.
	 *
	 * @param idioma the idioma
	 * @return lista de idioma
	 */
	public List<Idioma> buscarIdioma(Idioma idioma);
	
	/**
	 * Buscar nivel idioma.
	 *
	 * @param nivelIdioma the nivel idioma
	 * @return lista de ivel de idioma
	 */
	public List<NivelIdioma> buscarNivelIdioma(NivelIdioma nivelIdioma);
	
	/**
	 * Buscar roles.
	 *
	 * @param rol the rol
	 * @return lista de rol laboral
	 */
	public List<RolLaboral> buscarRoles(RolLaboral rol);
	
	/**
	 * Buscar areas.
	 *
	 * @param area the area
	 * @return lista de areas
	 */
	public List<Area> buscarAreas(Area area);
	
	/**
	 * Buscar instituciones formativas.
	 *
	 * @param institucionFormativa the institucion formativa
	 * @return lista de institucion formativa
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa> buscarInstitucionesFormativas(pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa institucionFormativa);
	
	/**
	 * Buscar estudio.
	 *
	 * @param estudio the estudio
	 * @return lista de estudios
	 */
	public List<String> buscarEstudio(String estudio);
	
	/**
	 * Gets the ruc empresas registradas.
	 *
	 * @return the ruc empresas registradas
	 */
	public List<?> getRucEmpresasRegistradas();
	
	/**
	 * Esta registrada.
	 *
	 * @param ruc 
	 * @return true si ruc esta registrado y false caso contrario
	 */
	public Boolean estaRegistrada(String ruc);
	
	/**
	 * Actualizar lista empresas.
	 *
	 * @return the integer
	 */
	public Integer actualizarListaEmpresas();
	
	/**
	 * Borrar registros empresas.
	 *
	 * @return the integer
	 */
	public Integer borrarRegistrosEmpresas();
	
	/**
	 * Gets the parametro.
	 *
	 * @param parametro the parametro
	 * @return the parametro
	 */
	public Parametro getParametro(String parametro);
}
