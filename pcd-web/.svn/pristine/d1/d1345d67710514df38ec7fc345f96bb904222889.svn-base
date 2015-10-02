package pe.gob.trabajo.pcd.servicio.maestro;

import java.util.HashMap;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.EmpleadoMaestro;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EscalaRemuneracion;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoOcupacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.Menu;
import pe.gob.trabajo.pcd.modelo.dominio.Nacionalidad;
import pe.gob.trabajo.pcd.modelo.dominio.Nivel;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Oficina;
import pe.gob.trabajo.pcd.modelo.dominio.Pais;
import pe.gob.trabajo.pcd.modelo.dominio.Parametro;
import pe.gob.trabajo.pcd.modelo.dominio.Perfil;
import pe.gob.trabajo.pcd.modelo.dominio.Person;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Provincia;
import pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId;
import pe.gob.trabajo.pcd.modelo.dominio.RolLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.Sistema;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDocumento;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpresa;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEstablecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.comun.GenericService;

// TODO: Auto-generated Javadoc
/**
 * The Interface MaestroService.
 */
public interface MaestroService extends GenericService<Object> {
	
	/**
	 * Metodo encargado de cargar la data del esquema simintra.
	 */
	public void loadData();
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
	
	public Usuario buscarUsuarioPorUsuarioClave(String nombreUsuario, String claveUsuario);
	
	public Usuario buscarUsuarioPorIdPersona(Long idPersona);
	
	public Persona buscarPersonaPorDocumento(String numeroDocumento);
	
	/**
	 * Buscar empresas.
	 *
	 * @param nombreComercial the nombre comercial
	 * @return the list
	 */
	public List<Empresa> buscarEmpresas(String nombreComercial);
	
	/**
	 * Buscar personas.
	 *
	 * @param persona the persona
	 * @return the list
	 */
	public List<Persona> buscarPersonas(Persona persona);
	
	/**
	 * Gets the lugares.
	 *
	 * @param lugar the lugar
	 * @return the lugares
	 */
	public List<Ubigeo> getLugares(Ubigeo lugar);
	
	/**
	 * Buscar especialidades.
	 *
	 * @param especialidad the especialidad
	 * @return the list
	 */
	public List<EspecialidadProfesional> buscarEspecialidades(EspecialidadProfesional especialidad);
	
	/**
	 * Buscar puestos.
	 *
	 * @param puesto the puesto
	 * @return the list
	 */
	public List<RolLaboral> buscarPuestos(RolLaboral puesto);
	
//	public List<Sector> buscarSectores(Sector sector);
	/**
 * Buscar sectores.
 *
 * @param descripcion the descripcion
 * @return the list
 */
public List<Sector> buscarSectores(String descripcion);
	
	/**
	 * Buscar campo estudio.
	 *
	 * @param campo the campo
	 * @return the list
	 */
	public List<String> buscarCampoEstudio(String campo);
	
	/**
	 * Buscar lugares.
	 *
	 * @param lugar the lugar
	 * @return the list
	 */
	public List<Ubigeo> buscarLugares(Ubigeo lugar);
	
//	public List<Puesto> buscarPuestos(Puesto puesto);
	/**
 * Buscar cargos.
 *
 * @param descripcion the descripcion
 * @return the list
 */
public List<PersonaCargo> buscarCargos(String descripcion);
	
	/**
	 * Buscar profesiones.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	public List<Profesion> buscarProfesiones(String descripcion);
	
	/**
	 * Buscar tipo referencia.
	 *
	 * @param tipoReferencia the tipo referencia
	 * @return the list
	 */
	public List<TipoReferencia> buscarTipoReferencia(TipoReferencia tipoReferencia);
	
	/**
	 * Buscar tipos formacion.
	 *
	 * @param tipoFormacion the tipo formacion
	 * @return the list
	 */
	public List<TipoFormacion> buscarTiposFormacion(TipoFormacion tipoFormacion);
	
//	public List<NivelFormacion> buscarNivelFormacion(NivelFormacion nivelFormacion);
	/**
 * Buscar niveles educativos.
 *
 * @param descripcion the descripcion
 * @return the list
 */
public List<NivelEducativo> buscarNivelesEducativos(String descripcion);
	
	/**
	 * Buscar idioma.
	 *
	 * @param idioma the idioma
	 * @return the list
	 */
	public List<Idioma> buscarIdioma(Idioma idioma);
	
	/**
	 * Buscar nivel idioma.
	 *
	 * @param nivelIdioma the nivel idioma
	 * @return the list
	 */
	public List<NivelIdioma> buscarNivelIdioma(NivelIdioma nivelIdioma); 
	
//	public List<RolLaboral> buscarRoles(RolLaboral rol);
	/**
 * Buscar ocupaciones.
 *
 * @param descripcion the descripcion
 * @return the list
 */
public List<Ocupacion> buscarOcupaciones(String descripcion);
	
	/**
	 * Buscar areas.
	 *
	 * @param area the area
	 * @return the list
	 */
	public List<Area> buscarAreas(Area area);
	
	/**
	 * Buscar institucion formativas.
	 *
	 * @param institucionFormativa the institucion formativa
	 * @return the list
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa> buscarInstitucionFormativas(pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa institucionFormativa);
	
	/**
	 * Buscar estudio.
	 *
	 * @param campo the campo
	 * @return the list
	 */
	public List<String> buscarEstudio(String campo);
	
	/**
	 * Gets the proveedor maestro object.
	 *
	 * @param clazz the clazz
	 * @param varOrden the var orden
	 * @param numResultados the num resultados
	 * @return the proveedor maestro object
	 */
	public List<?> getProveedorMaestroObject(Class<?> clazz, String varOrden, int numResultados);
	
	/**
	 * Gets the proveedor maestro object.
	 *
	 * @param clazz the clazz
	 * @return the proveedor maestro object
	 */
	public List<?> getProveedorMaestroObject(Class<?> clazz);
	
	/**
	 * Carga empresas.
	 */
	public void cargaEmpresas();
	
	/**
	 * Gets the parametro.
	 *
	 * @param parametro the parametro
	 * @return the parametro
	 */
	public Parametro getParametro(String parametro);
	
	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public HashMap<String, Parametro> getParametros();
	
	/**
	 * Obtener maestro profesiones2.
	 *
	 * @return the list
	 */
	public List<EmpleadoMaestro> obtenerMaestroProfesiones2();
	
	/**
	 * Gets the maestro grupo ocupaciones.
	 *
	 * @return the maestro grupo ocupaciones
	 */
	public List<GrupoOcupacion> getMaestroGrupoOcupaciones();
	
	/**
	 * Gets the maestro ocupaciones.
	 *
	 * @return the maestro ocupaciones
	 */
	public List<Ocupacion> getMaestroOcupaciones();
	
	/**
	 * Gets the maestro grupo profesiones.
	 *
	 * @return the maestro grupo profesiones
	 */
	public List<GrupoProfesion> getMaestroGrupoProfesiones();
	
	/**
	 * Gets the maestro profesiones.
	 *
	 * @return the maestro profesiones
	 */
	public List<Profesion> getMaestroProfesiones();
	
	/**
	 * Gets the maestro niveles educativos.
	 *
	 * @return the maestro niveles educativos
	 */
	public List<NivelEducativo> getMaestroNivelesEducativos();
	
	/**
	 * Gets the maestro ciiu.
	 *
	 * @return the maestro ciiu
	 */
	public List<Ciiu> getMaestroCiiu();
	
	/**
	 * Gets the maestro departamentos.
	 *
	 * @return the maestro departamentos
	 */
	public List<Departamento> getMaestroDepartamentos();
	
	/**
	 * Gets the maestro provincias.
	 *
	 * @param idDpto the id dpto
	 * @return the maestro provincias
	 */
	public List<Provincia> getMaestroProvincias(String idDpto);
	
	/**
	 * Gets the maestro distritos.
	 *
	 * @param id the id
	 * @return the maestro distritos
	 */
	public List<Distrito> getMaestroDistritos(ProvinciaId id);
	
	/**
	 * Gets the maestro escala remuneraciones.
	 *
	 * @return the maestro escala remuneraciones
	 */
	public List<EscalaRemuneracion> getMaestroEscalaRemuneraciones();
	
	/**
	 * Gets the maestro nacionalidades.
	 *
	 * @return the maestro nacionalidades
	 */
	public List<Nacionalidad> getMaestroNacionalidades();
	
	/**
	 * Gets the maestro niveles.
	 *
	 * @return the maestro niveles
	 */
	public List<Nivel> getMaestroNiveles();
	
	/**
	 * Gets the maestro paises.
	 *
	 * @return the maestro paises
	 */
	public List<Pais> getMaestroPaises();
	
	/**
	 * Gets the maestro persona cargo.
	 *
	 * @return the maestro persona cargo
	 */
	public List<PersonaCargo> getMaestroPersonaCargo();
	
	/**
	 * Gets the maestro tipo documentos.
	 *
	 * @return the maestro tipo documentos
	 */
	public List<TipoDocumento> getMaestroTipoDocumentos();
	
	/**
	 * Gets the maestro tipo empresas.
	 *
	 * @return the maestro tipo empresas
	 */
	public List<TipoEmpresa> getMaestroTipoEmpresas();
	
	/**
	 * Gets the maestro tipo establecimientos.
	 *
	 * @return the maestro tipo establecimientos
	 */
	public List<TipoEstablecimiento> getMaestroTipoEstablecimientos();
	
	/**
	 * Gets the maestro sistemas.
	 *
	 * @return the maestro sistemas
	 */
	public List<Sistema> getMaestroSistemas();
	
	/**
	 * Gets the maestro menus.
	 *
	 * @param idSistema the id sistema
	 * @return the maestro menus
	 */
	public List<Menu> getMaestroMenus(String idSistema);
	
	/**
	 * Gets the maestro perfiles.
	 *
	 * @param idSistema the id sistema
	 * @return the maestro perfiles
	 */
	public List<Perfil> getMaestroPerfiles(String idSistema);
	
	/**
	 * Gets the maestro personas.
	 *
	 * @param nroDocumento the nro documento
	 * @return the maestro personas
	 */
	public List<Person> getMaestroPersonas(String nroDocumento);
	
	/**
	 * Gets the maestro sectores.
	 *
	 * @return the maestro sectores
	 */
	public List<Sector> getMaestroSectores();
	
	/**
	 * Gets the MaestroOficinas.
	 *
	 * @return the MaestroOficinas
	 */
	public List<Oficina> getMaestroOficinas();
	
	public Empresa buscarEmpresa(String ruc);
	
	/**
	 * Gets the maestro ciius.
	 *
	 * @return the maestro ciius
	 */
	public List<Ciiu> buscarCiius(String descripcion);
	
	public Object getProveedorMaestroObjectByPK(Object id, Class<?> clazz);
}
