package pe.gob.trabajo.pcd.servicio.spring.maestro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import pe.gob.trabajo.pcd.modelo.dao.MaestroDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.EmpleadoMaestro;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EmpresaSunat;
import pe.gob.trabajo.pcd.modelo.dominio.EscalaRemuneracion;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoOcupacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.Menu;
import pe.gob.trabajo.pcd.modelo.dominio.Nacionalidad;
import pe.gob.trabajo.pcd.modelo.dominio.Nivel;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion;
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
import pe.gob.trabajo.pcd.servicio.maestro.MaestroService;
import pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.servicio.util.SpringApplicationContextProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroServiceImpl.
 */
public class MaestroServiceImpl extends GenericServiceImpl<Object> implements
		MaestroService {

	/** The logger. */
	private static Logger logger = Logger.getLogger(MaestroServiceImpl.class);
	
	/** The lugares. */
	private List<Ubigeo>		 lugares;
	
	/** The tipos documento. */
	private List<TipoDocumento>  tiposDocumento;
	
	/** The cargos. */
	private List<PersonaCargo> 	 cargos;
	
	/** The grupos profesion. */
	private List<GrupoProfesion> gruposProfesion;
	
	/** The profesiones. */
	private List<Profesion> profesiones;
	
	/** The ocupaciones. */
	private List<Ocupacion> ocupaciones;
	
	/** The empresas. */
	private List<Empresa> empresas;
	
	/** The sectores. */
	private List<Sector> sectores;
	
	/** The niveles educativos. */
	private List<NivelEducativo> nivelesEducativos;
	
	/** The ciius. */
	private List<Ciiu> ciius;

	// private ParametroDAO parametroDAO;
	//
	// public ParametroDAO getParametroDAO() {
	// return parametroDAO;
	// }
	//
	// public void setParametroDAO(ParametroDAO parametroDAO) {
	// this.parametroDAO = parametroDAO;
	// }
	/** The maestro dao. */
	private MaestroDAO maestroDAO;
	
	/** The proveedor maestro dao. */
	private ProveedorMaestroDAO proveedorMaestroDAO;
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#loadData()
	 */
	public void loadData() {
//		if (empresas == null || empresas.isEmpty())
			empresas = (List<Empresa>) maestroDAO.getAllObject(Empresa.class);
		
//		if (lugares == null || lugares.isEmpty())
			lugares = proveedorMaestroDAO.buscarDistritos(null);
		
//		if (tiposDocumento == null || tiposDocumento.isEmpty())
			tiposDocumento = proveedorMaestroDAO.getMaestroTipoDocumentos();
		
//		if (cargos == null || cargos.isEmpty())
			cargos = proveedorMaestroDAO.getMaestroPersonaCargo();
		
//		if (gruposProfesion == null || gruposProfesion.isEmpty())
			gruposProfesion = (List<GrupoProfesion>) proveedorMaestroDAO.getAllObject(GrupoProfesion.class);
		
//		if (profesiones == null || profesiones.isEmpty())
			profesiones = (List<Profesion>) proveedorMaestroDAO.getAllObject(Profesion.class);
		
//		if (ocupaciones == null || ocupaciones.isEmpty())
			ocupaciones = (List<Ocupacion>) proveedorMaestroDAO.getAllObject(Ocupacion.class);
		
//		if (sectores == null || sectores.isEmpty())
			sectores = (List<Sector>) proveedorMaestroDAO.getAllObject(Sector.class,"descripcion");
		
//		if (nivelesEducativos == null || nivelesEducativos.isEmpty())
			nivelesEducativos = (List<NivelEducativo>) proveedorMaestroDAO.getAllObject(NivelEducativo.class,"descripcion");
		
//		if (ciius == null || ciius.isEmpty())
			ciius = (List<Ciiu>) proveedorMaestroDAO.getAllObject(Ciiu.class,"descripcion");
	}
	
	/**
	 * Gets the maestro dao.
	 *
	 * @return the maestro dao
	 */
	public MaestroDAO getMaestroDAO() {
		return maestroDAO;
	}

	/**
	 * Sets the maestro dao.
	 *
	 * @param maestroDAO the new maestro dao
	 */
	public void setMaestroDAO(MaestroDAO maestroDAO) {
		setDao(maestroDAO);
		this.maestroDAO = maestroDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	public MaestroDAO getDao() {
		return maestroDAO;
	}

	/**
	 * Gets the proveedor maestro dao.
	 *
	 * @return the proveedor maestro dao
	 */
	public ProveedorMaestroDAO getProveedorMaestroDAO() {
		return proveedorMaestroDAO;
	}

	/**
	 * Sets the proveedor maestro dao.
	 *
	 * @param proveedorMaestroDAO the new proveedor maestro dao
	 */
	public void setProveedorMaestroDAO(ProveedorMaestroDAO proveedorMaestroDAO) {
		this.proveedorMaestroDAO = proveedorMaestroDAO;
	}
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
		Usuario usuario = maestroDAO.buscarUsuarioPorNombreUsuario(nombreUsuario);
		return usuario;
	}
	
	public Usuario buscarUsuarioPorUsuarioClave(String nombreUsuario, String claveUsuario) {
		Usuario usuario = maestroDAO.buscarUsuario(nombreUsuario, claveUsuario);
		if (usuario != null) {
			Hibernate.initialize(usuario.getRol());
			if (usuario.getRol().getId().compareTo(Constantes.ROL_EMPLEADOR.getId()) == 0) {
				Hibernate.initialize(usuario.getEmpresa());
				usuario.getEmpresa().setUsuario(usuario);
			} else {
				Hibernate.initialize(usuario.getPersona());
				usuario.getPersona().setUsuario(usuario);
			}
			
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorIdPersona(Long idPersona) {
		return maestroDAO.buscarUsuarioPorIdPersona(idPersona);
	}

//	public List<Empresa> buscarEmpresas(Empresa empresa) {
//		if (empresa.getNombreComercial() == null) {
//			empresa.setNombreComercial("");
//		}
//		return getDao().buscarEmpresas(empresa);
//	}
	
	/* (non-Javadoc)
 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarEmpresas(java.lang.String)
 */
public List<Empresa> buscarEmpresas(String nombreComercial) {
		if (nombreComercial == null) {
			nombreComercial = "";
		}
//		loadData();
		List<Empresa> empresasFiltradas = new ArrayList<Empresa>();
		for (Empresa e : empresas) {
			if (e.getNombreComercial() != null && e.getNombreComercial().toLowerCase().contains(nombreComercial.toLowerCase())) {
				empresasFiltradas.add(e);
			}
		}
		return empresasFiltradas;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarPersonas(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Persona> buscarPersonas(Persona persona) {
		if (persona.getApellidoPaterno() == null) {
			persona.setApellidoPaterno("");
		}
		return getDao().buscarPersonas(persona);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo)
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.Ubigeo> getLugares(
			pe.gob.trabajo.pcd.modelo.dominio.Ubigeo lugar) {
		List<pe.gob.trabajo.pcd.modelo.dominio.Ubigeo> lista = getDao()
				.getLugares(lugar);
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarEspecialidades(pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional)
	 */
	public List<EspecialidadProfesional> buscarEspecialidades(
			EspecialidadProfesional especialidad) {
		if (especialidad.getDescripcion() == null) {
			especialidad.setDescripcion("");
		}
		return getDao().buscarEspecialidades(especialidad);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarPuestos(pe.gob.trabajo.pcd.modelo.dominio.RolLaboral)
	 */
	public List<RolLaboral> buscarPuestos(RolLaboral puesto) {
		if (puesto.getDescripcion() == null) {
			puesto.setDescripcion("");
		}
		return getDao().buscarPuestos(puesto);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarSectores(java.lang.String)
	 */
	public List<Sector> buscarSectores(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<Sector> sectoresFiltrados = new ArrayList<Sector>();
		for (Sector s : sectores) {
			if (s.getDescripcion() != null && s.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
				sectoresFiltrados.add(s);
			}
		}
		return sectoresFiltrados;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarCiius(java.lang.String)
	 */
	public List<Ciiu> buscarCiius(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<Ciiu> ciiusFiltrados = new ArrayList<Ciiu>();
		for (Ciiu s : ciius) {
			if (s.getDescripcion() != null && s.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
				ciiusFiltrados.add(s);
			}
		}
		return ciiusFiltrados;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarCampoEstudio(java.lang.String)
	 */
	public List<String> buscarCampoEstudio(String campo) {
		if (campo == null) {
			campo = "";
		}
		return getDao().buscarCampoEstudio(campo);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo)
	 */
	public List<Ubigeo> buscarLugares(Ubigeo lugar) {
		if (lugar.getNombre() == null) {
			lugar.setNombre("");
		}
		
		List<Ubigeo> distritosFiltrados = new ArrayList<Ubigeo>();
		for (Ubigeo d : lugares) {
			if (d.getNombre() != null && d.getNombre().toLowerCase().contains(lugar.getNombre().toLowerCase())) {
				distritosFiltrados.add(d);
			}
		}
		return distritosFiltrados;
	}

//	public List<Puesto> buscarPuestos(Puesto puesto) {
//		if (puesto.getDescripcion() == null) {
//			puesto.setDescripcion("");
//		}
//		return getDao().buscarPuestos(puesto);
//	}
	
	/* (non-Javadoc)
 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarCargos(java.lang.String)
 */
public List<PersonaCargo> buscarCargos(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<PersonaCargo> distritosFiltrados = new ArrayList<PersonaCargo>();
		for (PersonaCargo c : cargos) {
			if (c.getNombre() != null && c.getNombre().toLowerCase().contains(descripcion.toLowerCase())) {
				distritosFiltrados.add(c);
			}
		}
		return distritosFiltrados;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarProfesiones(java.lang.String)
	 */
	public List<Profesion> buscarProfesiones(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<Profesion> distritosFiltrados = new ArrayList<Profesion>();
		for (Profesion p : profesiones) {
			if (p.getDescripcion() != null && p.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
				distritosFiltrados.add(p);
			}
		}
		return distritosFiltrados;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarTipoReferencia(pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia)
	 */
	public List<TipoReferencia> buscarTipoReferencia(
			TipoReferencia tipoReferencia) {
		if (tipoReferencia.getDescripcion() == null) {
			tipoReferencia.setDescripcion("");
		}
		return getDao().buscarTipoReferencia(tipoReferencia);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarOcupaciones(java.lang.String)
	 */
	public List<Ocupacion> buscarOcupaciones(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<Ocupacion> ocupacionesFiltradas = new ArrayList<Ocupacion>();
		for (Ocupacion o : ocupaciones) {
			if (o.getDescripcion() != null && o.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
				ocupacionesFiltradas.add(o);
			}
		}
		return ocupacionesFiltradas;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarAreas(pe.gob.trabajo.pcd.modelo.dominio.Area)
	 */
	public List<Area> buscarAreas(Area area) {
		if (area.getDescripcion() == null) {
			area.setDescripcion("");
		}
		return getDao().buscarAreas(area);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarInstitucionFormativas(pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa)
	 */
	public List<pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa> buscarInstitucionFormativas(
			pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa institucionFormativa) {
		if (institucionFormativa.getDescripcion() == null) {
			institucionFormativa.setDescripcion("");
		}
		return getDao().buscarInstitucionesFormativas(institucionFormativa);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarEstudio(java.lang.String)
	 */
	public List<String> buscarEstudio(String campo) {
		if (campo == null) {
			campo = "";
		}
		return getDao().buscarEstudio(campo);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarTiposFormacion(pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion)
	 */
	public List<TipoFormacion> buscarTiposFormacion(TipoFormacion tipoFormacion) {
		if (tipoFormacion.getDescripcion() == null) {
			tipoFormacion.setDescripcion("");
		}
		return getDao().buscarTiposFormacion(tipoFormacion);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarNivelesEducativos(java.lang.String)
	 */
	public List<NivelEducativo> buscarNivelesEducativos(String descripcion) {
		if (descripcion == null) {
			descripcion = "";
		}
		
		List<NivelEducativo> nivelesFiltrados = new ArrayList<NivelEducativo>();
		for (NivelEducativo n : nivelesEducativos) {
			if (n.getDescripcion() != null && n.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
				nivelesFiltrados.add(n);
			}
		}
		return nivelesFiltrados;
	}

	/**
	 * Buscar nivel formacion.
	 *
	 * @param nivelFormacion the nivel formacion
	 * @return the list
	 */
	public List<NivelFormacion> buscarNivelFormacion(
			NivelFormacion nivelFormacion) {
		if (nivelFormacion.getValor() == null) {
			nivelFormacion.setValor("");
		}
		// if(nivelFormacion.getDescripcion()==null){
		// nivelFormacion.setDescripcion("");
		// }
		return getDao().buscarNivelFormacion(nivelFormacion);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarIdioma(pe.gob.trabajo.pcd.modelo.dominio.Idioma)
	 */
	public List<Idioma> buscarIdioma(Idioma idioma) {
		if (idioma.getDescripcion() == null) {
			idioma.setDescripcion("");
		}
//		return getDao().buscarIdioma(idioma);
		List<Idioma> idiomasFiltrados = new ArrayList<Idioma>();
		List<Idioma> idiomas = (List<Idioma>) getAllObject(Idioma.class);
		
		for (Idioma n : idiomas) {
			if (n.getDescripcion() != null && n.getDescripcion().toLowerCase().contains(idioma.getDescripcion().toLowerCase())) {
				idiomasFiltrados.add(n);
			}
		}
		return idiomasFiltrados;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#buscarNivelIdioma(pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma)
	 */
	public List<NivelIdioma> buscarNivelIdioma(NivelIdioma nivelIdioma) {
		if (nivelIdioma.getValor() == null) {
			nivelIdioma.setValor("");
		}
//		return getDao().buscarNivelIdioma(nivelIdioma);
		List<NivelIdioma> nivelesFiltrados = new ArrayList<NivelIdioma>();
		List<NivelIdioma> niveles = (List<NivelIdioma>) getAllObject(NivelIdioma.class);
		
		for (NivelIdioma n : niveles) {
			if (n.getValor() != null && n.getValor().toLowerCase().contains(nivelIdioma.getValor().toLowerCase())) {
				nivelesFiltrados.add(n);
			}
		}
		return nivelesFiltrados;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getProveedorMaestroObject(java.lang.Class, java.lang.String, int)
	 */
	public List<?> getProveedorMaestroObject(Class<?> clazz, String varOrden,
			int numResultados) {
		return getProveedorMaestroDAO().getAllObject(clazz, varOrden,
				numResultados);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getProveedorMaestroObject(java.lang.Class)
	 */
	public List<?> getProveedorMaestroObject(Class<?> clazz) {
		return getProveedorMaestroDAO().getAllObject(clazz);
	}

	/**
	 * Borrar registros empresas.
	 *
	 * @return the integer
	 */
	public Integer borrarRegistrosEmpresas() {
		Integer resultado = 0;
		Transaction tx = getDao().getHibernateSession().beginTransaction();
		resultado = getDao().borrarRegistrosEmpresas();
		tx.commit();
		return resultado;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#obtenerMaestroProfesiones2()
	 */
	public List<EmpleadoMaestro> obtenerMaestroProfesiones2() {
		List<EmpleadoMaestro> listaEmpresasProveedor = getProveedorMaestroDAO()
				.getMaestroProfesiones2();
		return listaEmpresasProveedor;
	}

	/**
	 * Obtener maestro empresas.
	 *
	 * @return the list
	 */
	public List<EmpresaSunat> obtenerMaestroEmpresas() {
		List<EmpresaSunat> listaEmpresasProveedor = getProveedorMaestroDAO()
				.getMaestroEmpresas();
		return listaEmpresasProveedor;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#cargaEmpresas()
	 */
	public void cargaEmpresas() {
		System.out.println("Cargando datos de tablas parametricas...");
		System.out.println("SERVLET CARGADO");
		String nombreBean = "MaestroService";
		MaestroService maestroService = (MaestroService) SpringApplicationContextProvider
				.getBean(nombreBean);

		// Carga de datos inicial
		System.out.println("Cargando Datos de Maestros ...");
		maestroService.loadData();
		System.out.println("Datos de Maestros Cargados !");
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getParametro(java.lang.String)
	 */
	public Parametro getParametro(String parametro) {
		return getDao().getParametro(parametro);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getParametros()
	 */
	public HashMap<String, Parametro> getParametros() {
		HashMap<String, Parametro> parametros = new HashMap<String, Parametro>();
		List<Parametro> lista = (List<Parametro>) getDao().getAllObject(Parametro.class);
		for (Parametro parametro : lista) {
			parametros.put(parametro.getNombre(), parametro);
		}
		return parametros;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroGrupoOcupaciones()
	 */
	public List<GrupoOcupacion> getMaestroGrupoOcupaciones() {
		List<GrupoOcupacion> listagGrupoOcupacions = getProveedorMaestroDAO()
				.getMaestroGrupoOcupaciones();
		return listagGrupoOcupacions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroOcupaciones()
	 */
	public List<Ocupacion> getMaestroOcupaciones() {
//		List<Ocupacion> listaOcupacions = getProveedorMaestroDAO()
//				.getMaestroOcupaciones();
		return ocupaciones;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroGrupoProfesiones()
	 */
	public List<GrupoProfesion> getMaestroGrupoProfesiones() {
//		List<GrupoProfesion> listaGrupoProfesions = getProveedorMaestroDAO()
//				.getMaestroGrupoProfesiones();
		return gruposProfesion;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroProfesiones()
	 */
	public List<Profesion> getMaestroProfesiones() {
//		List<Profesion> listaProfesions = getProveedorMaestroDAO()
//				.getMaestroProfesiones();
		return profesiones;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroNivelesEducativos()
	 */
	public List<NivelEducativo> getMaestroNivelesEducativos() {
//		List<NivelEducativo> listaNivelEducativos = getProveedorMaestroDAO()
//				.getMaestroNivelesEducativos();
		return nivelesEducativos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroCiiu()
	 */
	public List<Ciiu> getMaestroCiiu() {
		List<Ciiu> listaCiius = getProveedorMaestroDAO().getMaestroCiiu();
		return listaCiius;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroDepartamentos()
	 */
	public List<Departamento> getMaestroDepartamentos() {
		List<Departamento> listaDepartamentos = getProveedorMaestroDAO()
				.getMaestroDepartamentos();
		return listaDepartamentos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroProvincias(java.lang.String)
	 */
	public List<Provincia> getMaestroProvincias(String idDpto) {
		List<Provincia> listaProvincias = getProveedorMaestroDAO()
				.getMaestroProvincias(idDpto);
		return listaProvincias;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroDistritos(pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId)
	 */
	public List<Distrito> getMaestroDistritos(ProvinciaId id) {
		List<Distrito> listaDistritos = getProveedorMaestroDAO()
				.getMaestroDistritos(id);
		return listaDistritos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroEscalaRemuneraciones()
	 */
	public List<EscalaRemuneracion> getMaestroEscalaRemuneraciones() {
		List<EscalaRemuneracion> listaEscalaRemuneraciones = getProveedorMaestroDAO()
				.getMaestroEscalaRemuneraciones();
		return listaEscalaRemuneraciones;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroNacionalidades()
	 */
	public List<Nacionalidad> getMaestroNacionalidades() {
		List<Nacionalidad> listaNacionalidades = getProveedorMaestroDAO()
				.getMaestroNacionalidades();
		return listaNacionalidades;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroNiveles()
	 */
	public List<Nivel> getMaestroNiveles() {
		List<Nivel> listaNiveles = getProveedorMaestroDAO()
				.getMaestroNiveles();
		return listaNiveles;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroPaises()
	 */
	public List<Pais> getMaestroPaises() {
		List<Pais> listaPaises = getProveedorMaestroDAO()
				.getMaestroPaises();
		return listaPaises;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroPersonaCargo()
	 */
	public List<PersonaCargo> getMaestroPersonaCargo() {
//		List<PersonaCargo> listaPersonaCargo = getProveedorMaestroDAO()
//				.getMaestroPersonaCargo();
//		return listaPersonaCargo;
		return cargos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroTipoDocumentos()
	 */
	public List<TipoDocumento> getMaestroTipoDocumentos() {
//		List<TipoDocumento> listaTipoDocumento = getProveedorMaestroDAO()
//				.getMaestroTipoDocumentos();
		return tiposDocumento;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroTipoEmpresas()
	 */
	public List<TipoEmpresa> getMaestroTipoEmpresas() {
		List<TipoEmpresa> listaTipoEmpresa = getProveedorMaestroDAO().getMaestroTipoEmpresas();
		return listaTipoEmpresa;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroTipoEstablecimientos()
	 */
	public List<TipoEstablecimiento> getMaestroTipoEstablecimientos() {
		List<TipoEstablecimiento> listaTipoEstablecimiento = getProveedorMaestroDAO().getMaestroTipoEstablecimientos();
		return listaTipoEstablecimiento;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroSistemas()
	 */
	public List<Sistema> getMaestroSistemas() {
		List<Sistema> listaSistema = getProveedorMaestroDAO()
				.getMaestroSistemas();
		return listaSistema;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroSectores()
	 */
	public List<Sector> getMaestroSectores() {
		return sectores;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroMenus(java.lang.String)
	 */
	public List<Menu> getMaestroMenus(String idSistema) {
		List<Menu> listaMenus = getProveedorMaestroDAO()
				.getMaestroMenus(idSistema);
		return listaMenus;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroPerfiles(java.lang.String)
	 */
	public List<Perfil> getMaestroPerfiles(String idSistema) {
		List<Perfil> listaPerfiles = getProveedorMaestroDAO()
				.getMaestroPerfiles(idSistema);
		return listaPerfiles;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroPersonas(java.lang.String)
	 */
	public List<Person> getMaestroPersonas(String nroDocumento) {
		List<Person> listaPersonas = getProveedorMaestroDAO()
				.getMaestroPersonas(nroDocumento);
		return listaPersonas;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getMaestroOficinas()
	 */
	public List<Oficina> getMaestroOficinas() {
		List<Oficina> listaOficinas = getProveedorMaestroDAO()
				.getMaestroOficinas();
		return listaOficinas;
	}
	
	public Empresa buscarEmpresa(String ruc) {
		Empresa empresaBuscada = null;
		if (empresaBuscada == null) {
			EmpresaSunat empresaSunat = proveedorMaestroDAO.getMaestroEmpresasPorRuc(ruc);
			if (empresaSunat != null) {
				empresaBuscada = Empresa.construirEmpresa(empresaSunat);
				if (empresaBuscada.getCiiu()!=null) {
					Ciiu c = (Ciiu)proveedorMaestroDAO.findObjectByPK(empresaBuscada.getCiiu(), Ciiu.class);
					empresaBuscada.setCiiuDescripcion(c.getDescripcion());
				}
			}
		}
		return empresaBuscada;
	}
	
	public Persona buscarPersonaPorDocumento(String numeroDocumento) {
		List<Person> personas = proveedorMaestroDAO.getMaestroPersonas(numeroDocumento);
		for (Person p : personas) {
			return Persona.construirPersona(p);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.maestro.MaestroService#getProveedorMaestroObject(java.lang.Class, java.lang.String, int)
	 */
	public Object getProveedorMaestroObjectByPK(Object id, Class<?> clazz) {
		return getProveedorMaestroDAO().findObjectByPK(id, clazz);
	}
}
