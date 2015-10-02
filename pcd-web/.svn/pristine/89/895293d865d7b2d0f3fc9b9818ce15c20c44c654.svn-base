package pe.gob.trabajo.pcd.modelo.dao;

import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.DistritoId;
import pe.gob.trabajo.pcd.modelo.dominio.EmpleadoMaestro;
import pe.gob.trabajo.pcd.modelo.dominio.EmpresaSunat;
import pe.gob.trabajo.pcd.modelo.dominio.EscalaRemuneracion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoOcupacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.Menu;
import pe.gob.trabajo.pcd.modelo.dominio.Nacionalidad;
import pe.gob.trabajo.pcd.modelo.dominio.Nivel;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Oficina;
import pe.gob.trabajo.pcd.modelo.dominio.Pais;
import pe.gob.trabajo.pcd.modelo.dominio.Perfil;
import pe.gob.trabajo.pcd.modelo.dominio.Person;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Provincia;
import pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Sistema;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDocumento;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpresa;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEstablecimiento;


// TODO: Auto-generated Javadoc
/**
 * The Interface ProveedorMaestroDAO.
 */
public interface ProveedorMaestroDAO extends GenericDao<Object, Long> {
	
	/**
	 * Gets the maestro empresas no registradas.
	 *
	 * @param rucEmpresasRegistradas the ruc empresas registradas
	 * @return the maestro empresas no registradas
	 */
	public List<EmpresaSunat> getMaestroEmpresasNoRegistradas(List<String> rucEmpresasRegistradas);
	
	/**
	 * Gets the maestro empresas.
	 *
	 * @return the maestro empresas
	 */
	public List<EmpresaSunat> getMaestroEmpresas();
	
	/**
	 * Gets the maestro profesiones2.
	 *
	 * @return the maestro profesiones2
	 */
	public List<EmpleadoMaestro> getMaestroProfesiones2();
	
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
	 * Gets the maestro distrito.
	 *
	 * @param id the id
	 * @return the maestro distrito
	 */
	public Distrito getMaestroDistrito(DistritoId id);
	
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
	 * Buscar distritos.
	 *
	 * @param nombre the nombre
	 * @return the list
	 */
	public List<Ubigeo> buscarDistritos(String nombre);
	
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
	 * @param idSistema id sistema
	 * @return objeto maestro perfiles
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
	 * Gets the maestro oficinas.
	 *
	 * @return the maestro oficinas
	 */
	public List<Oficina> getMaestroOficinas();
	
	/**
	 * @param ruc
	 * @return
	 */
	public EmpresaSunat getMaestroEmpresasPorRuc(String ruc);

}
