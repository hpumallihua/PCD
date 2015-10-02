package pe.gob.trabajo.pcd.servicio.spring.busqueda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Hibernate;

import pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.DistritoId;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Preferencia;
import pe.gob.trabajo.pcd.modelo.dominio.PreferenciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoPreferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService;
import pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.ReporteBean;
import pe.gob.trabajo.pcd.vista.bean.ReporteE1;
import pe.gob.trabajo.pcd.vista.bean.ReporteE2;
import pe.gob.trabajo.pcd.vista.bean.ReporteE3;
import pe.gob.trabajo.pcd.vista.bean.ReporteE4;
import pe.gob.trabajo.pcd.vista.bean.ReporteOferta;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfesionalServiceImpl.
 */
public class ProfesionalServiceImpl extends GenericServiceImpl<Profesional>
		implements ProfesionalService {

	/** The profesional dao. */
	public ProfesionalDAO profesionalDAO;

	/** The proveedor maestro dao. */
	private ProveedorMaestroDAO proveedorMaestroDAO;

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
	 * @param proveedorMaestroDAO
	 *            the new proveedor maestro dao
	 */
	public void setProveedorMaestroDAO(ProveedorMaestroDAO proveedorMaestroDAO) {
		this.proveedorMaestroDAO = proveedorMaestroDAO;
	}

	/**
	 * Gets the profesional dao.
	 * 
	 * @return the profesional dao
	 */
	public ProfesionalDAO getProfesionalDAO() {
		return profesionalDAO;
	}

	/**
	 * Sets the profesional dao.
	 * 
	 * @param profesionalDAO
	 *            the new profesional dao
	 */
	public void setProfesionalDAO(ProfesionalDAO profesionalDAO) {
		this.profesionalDAO = profesionalDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	@Override
	public ProfesionalDAO getDao() {
		return profesionalDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#buscarProfesional
	 * (java.util.List)
	 */
	public List<Profesional> buscarProfesional(List<?> ids) {

		List<Profesional> consulta = getProfesionalDAO().buscarProfesional(ids);
		for (Profesional itemProfesional : consulta) {
			Hibernate.initialize(itemProfesional.getPersona());
			Hibernate.initialize(itemProfesional.getPersona()
					.getTipoDocumentoIdentidad());
			Hibernate.initialize(itemProfesional.getPersona()
					.getLugarResidencia());
			if (itemProfesional.getPersona().getDepartamentoResidencia() != null
					&& itemProfesional.getPersona().getProvinciaResidencia() != null
					&& itemProfesional.getPersona().getDistritoResidencia() != null) {
				Distrito distritoResidencia = (Distrito) getProveedorMaestroDAO()
						.findObjectByPK(
								new DistritoId(itemProfesional.getPersona()
										.getDistritoResidencia(),
										itemProfesional.getPersona()
												.getProvinciaResidencia(),
										itemProfesional.getPersona()
												.getDepartamentoResidencia()),
								Distrito.class);
				if (distritoResidencia != null) {
					itemProfesional.getPersona().setNombreLugarResidencia(
							distritoResidencia.getNombre());
				}
			}

			Hibernate.initialize(itemProfesional.getPersona()
					.getLugarNacimiento());
			Hibernate.initialize(itemProfesional.getPersona().getContactos());
			for (Contacto contacto : itemProfesional.getPersona()
					.getContactos()) {
				if (contacto != null) {
					Hibernate.initialize(contacto);
					// Hibernate.initialize(contacto.getPersona());
					Hibernate.initialize(contacto.getContactoMedios());
				}
			}
		}

		return consulta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * buscarProfesionales(java.lang.String[], java.lang.String[],
	 * java.lang.String[], java.lang.String[], java.lang.String[],
	 * java.lang.String[], java.lang.String[], java.lang.String[],
	 * java.lang.String[], java.lang.String[],
	 * pe.gob.trabajo.pcd.modelo.dominio.Profesional, java.lang.Integer[],
	 * pe.gob.trabajo.pcd.modelo.dominio.Preferencia[], java.util.List)
	 */
	public List<Profesional> buscarProfesionales(String[] especialidades,
			String[] puestos, String[] roles, String[] empresas,
			String[] sectores, String[] tiposFormacion,
			String[] nivelFormacion, String[] camposEstudio, String[] idiomas,
			String[] nivelIdioma, Profesional profesional, Integer[] edades,
			String[] lugares, List<?> ids) {
		HashMap<String, HashMap<String, List<?>>> criterios = new HashMap<String, HashMap<String, List<?>>>(
				0);

		// Especialidades
		if (especialidades != null && especialidades.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			// Definiendo las clases de consulta
			List<String> listaEspecialidades = new ArrayList<String>();
			for (int i = 0; i < especialidades.length; i++) {
				// EspecialidadProfesional esp = new EspecialidadProfesional();
				// esp.setDescripcion(especialidades[i]);
				listaEspecialidades.add(especialidades[i]);
			}
			claveValores.put("descripcion", listaEspecialidades);
			criterios.put("especialidad", claveValores);
		}

		// Puestos
		if (puestos != null && puestos.length > 0) {
			HashMap<String, List<?>> claveValoresPuestos = new HashMap<String, List<?>>(
					0);
			List<String> listaPuestos = new ArrayList<String>();
			for (int i = 0; i < puestos.length; i++) {
				listaPuestos.add(puestos[i]);
			}
			claveValoresPuestos.put("puesto", listaPuestos);
			criterios.put("puesto", claveValoresPuestos);
		}

		// Roles
		if (roles != null && roles.length > 0) {
			HashMap<String, List<?>> claveValoresRoles = new HashMap<String, List<?>>(
					0);
			List<String> listaRoles = new ArrayList<String>();
			for (int i = 0; i < roles.length; i++) {
				listaRoles.add(roles[i]);
			}
			claveValoresRoles.put("rol", listaRoles);
			criterios.put("rol", claveValoresRoles);
		}

		// Empresas
		if (empresas != null && empresas.length > 0) {
			HashMap<String, List<?>> claveValoresEmpresas = new HashMap<String, List<?>>(
					0);
			// Definiendo las clases de consulta
			List<String> listaEmpresas = new ArrayList<String>();
			for (int i = 0; i < empresas.length; i++) {
				// Empresa emp = new Empresa();
				// emp.setNombre(empresas[i]);
				listaEmpresas.add(empresas[i]);
			}
			claveValoresEmpresas.put("nombre", listaEmpresas);
			criterios.put("empresa", claveValoresEmpresas);
		}

		// Sectores
		if (sectores != null && sectores.length > 0) {
			HashMap<String, List<?>> claveValoresSectores = new HashMap<String, List<?>>(
					0);
			List<Long> listaSectores = new ArrayList<Long>();
			for (int i = 0; i < sectores.length; i++) {
				listaSectores.add(new Long(sectores[i]));
			}
			claveValoresSectores.put("descripcion", listaSectores);
			criterios.put("sector", claveValoresSectores);
		}

		// Tipo formacion
		if (tiposFormacion != null && tiposFormacion.length > 0) {
			HashMap<String, List<?>> claveValoresTiposFormacion = new HashMap<String, List<?>>(
					0);
			List<String> listaTiposFormacion = new ArrayList<String>();
			for (int i = 0; i < tiposFormacion.length; i++) {
				listaTiposFormacion.add(tiposFormacion[i]);
			}
			claveValoresTiposFormacion.put("descripcion", listaTiposFormacion);
			criterios.put("tipoFormacion", claveValoresTiposFormacion);
		}

		// Nivel formacion
		if (nivelFormacion != null) {
			HashMap<String, List<?>> claveValoresNivelesFormacion = new HashMap<String, List<?>>(
					0);
			List<String> listaNivelesFormacion = new ArrayList<String>();
			for (int i = 0; i < nivelFormacion.length; i++) {
				listaNivelesFormacion.add(nivelFormacion[i]);
			}
			claveValoresNivelesFormacion.put("nivelFormacion",
					listaNivelesFormacion);
			criterios.put("nivelFormacion", claveValoresNivelesFormacion);
		}

		// Campos de estudio
		if (camposEstudio != null && camposEstudio.length > 0) {
			HashMap<String, List<?>> claveValoresCamposEstudio = new HashMap<String, List<?>>(
					0);
			List<String> listaCamposEstudio = new ArrayList<String>();
			for (int i = 0; i < camposEstudio.length; i++) {
				listaCamposEstudio.add(camposEstudio[i]);
			}
			claveValoresCamposEstudio.put("camposEstudio", listaCamposEstudio);
			criterios.put("camposEstudio", claveValoresCamposEstudio);
		}

		// idiomas
		if (idiomas != null && idiomas.length > 0) {
			HashMap<String, List<?>> claveValoresIdiomas = new HashMap<String, List<?>>(
					0);
			List<String> listaIdiomas = new ArrayList<String>();
			for (int i = 0; i < idiomas.length; i++) {
				listaIdiomas.add(idiomas[i]);
			}
			claveValoresIdiomas.put("descripcion", listaIdiomas);
			criterios.put("idiomas", claveValoresIdiomas);
		}

		// Nivel idioma
		if (nivelIdioma != null) {
			HashMap<String, List<?>> claveValoresNivelesIdioma = new HashMap<String, List<?>>(
					0);
			List<Long> listaNivelesIdioma = new ArrayList<Long>();
			for (int i = 0; i < nivelIdioma.length; i++) {
				listaNivelesIdioma.add(Long.valueOf(nivelIdioma[i]));
			}
			claveValoresNivelesIdioma.put("nivelIdioma", listaNivelesIdioma);
			criterios.put("nivelIdioma", claveValoresNivelesIdioma);
		}

		// Profesional
		if (profesional != null) {
			HashMap<String, List<?>> claveValoresProfesional = new HashMap<String, List<?>>(
					0);
			List<Object> listaProfesionales = new ArrayList<Object>();
			listaProfesionales.add(profesional);
			claveValoresProfesional.put("profesional", listaProfesionales);
			criterios.put("profesional", claveValoresProfesional);
		}

		// Edades
		if (edades != null) {
			Calendar[] rangoFechaNacimiento = new Calendar[2];
			Integer edadSuperior = edades[1];
			Integer edadInferior = edades[0];
			// edadSuperior no nulo y mayor que cero
			if (edadSuperior != null && edadSuperior.compareTo(0) == 1) {
				Calendar cal = Calendar.getInstance();
				cal.roll(Calendar.YEAR, (-edadSuperior.intValue()) - 1);
				rangoFechaNacimiento[1] = cal;
			}
			// edadInferior no nulo y mayor que cero
			if (edadInferior != null && edadInferior.compareTo(0) == 1) {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.YEAR, (-edadInferior.intValue()) - 0);
				rangoFechaNacimiento[0] = cal;
			}

			HashMap<String, List<?>> claveValoresEdades = new HashMap<String, List<?>>(
					0);
			List<Object> listaEdades = new ArrayList<Object>();
			listaEdades.add(rangoFechaNacimiento);
			claveValoresEdades.put("fechaNacimiento", listaEdades);
			criterios.put("fechaNacimiento", claveValoresEdades);
		}

		// Datos de ejemplo
		// preferencias = new Preferencia[2];
		// preferencias[0] = new Preferencia();
		// preferencias[0].setId(new PreferenciaId(1L, 2L, 0L));
		//
		// preferencias[1] = new Preferencia();
		// preferencias[1].setId(new PreferenciaId(1L, 1L, 0L));

		// Preferencias
		if (lugares != null && lugares.length > 0) {
			HashMap<String, List<?>> claveValoresPreferencias = new HashMap<String, List<?>>(
					0);
			// Definiendo las clases de consulta
			List<String> listaPreferencias = new ArrayList<String>();
			for (int i = 0; i < lugares.length; i++) {
				listaPreferencias.add(lugares[i]);
			}
			claveValoresPreferencias.put("ciudades", listaPreferencias);
			criterios.put("lugaresResidencia", claveValoresPreferencias);
		}

		List<Profesional> consulta = (ArrayList<Profesional>) getDao()
				.buscarProfesional(criterios, ids);
		for (Profesional itemProfesional : consulta) {
			Hibernate.initialize(itemProfesional.getPersona());
			Hibernate.initialize(itemProfesional.getPersona()
					.getTipoDocumentoIdentidad());
			Hibernate.initialize(itemProfesional.getPersona()
					.getLugarResidencia());
			if (itemProfesional.getPersona().getDepartamentoResidencia() != null
					&& itemProfesional.getPersona().getProvinciaResidencia() != null
					&& itemProfesional.getPersona().getDistritoResidencia() != null) {
				Distrito distritoResidencia = (Distrito) getProveedorMaestroDAO()
						.findObjectByPK(
								new DistritoId(itemProfesional.getPersona()
										.getDistritoResidencia(),
										itemProfesional.getPersona()
												.getProvinciaResidencia(),
										itemProfesional.getPersona()
												.getDepartamentoResidencia()),
								Distrito.class);
				if (distritoResidencia != null) {
					itemProfesional.getPersona().setNombreLugarResidencia(
							distritoResidencia.getNombre());
				}
			}
			Hibernate.initialize(itemProfesional.getPersona()
					.getLugarNacimiento());
			Hibernate.initialize(itemProfesional.getPersona().getContactos());
//			for (Certificacion c : consulta) {
//				
//			}
//			Hibernate.initialize(itemProfesional.getExperienciasEspecialidad());
//			Hibernate.initialize(itemProfesional.getExperienciasLaborales());
//			Hibernate.initialize(itemProfesional.getCertificaciones());
//			Hibernate.initialize(itemProfesional.getIdiomas());
//			Hibernate.initialize(itemProfesional.getFormaciones());
			for (Contacto contacto : itemProfesional.getPersona()
					.getContactos()) {
				if (contacto != null) {
					Hibernate.initialize(contacto);
					// Hibernate.initialize(contacto.getPersona());
					Hibernate.initialize(contacto.getContactoMedios());
				}
			}
		}
		return consulta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * guardarCertificacion(pe.gob.trabajo.pcd.modelo.dominio.Certificacion)
	 */
	public Certificacion guardarCertificacion(Certificacion certificacion) {
		if (certificacion.getId() == null) {
			certificacion.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		certificacion.setFechaActualizacion(new Date());
		certificacion.setFechaCreacion(new Date());
		getDao().saveObject(certificacion);
		// getDao().getAllObject(Certificacion.class);
		return certificacion;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * guardarExperienciaEspecialidad
	 * (pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad)
	 */
	public ExperienciaEspecialidad guardarExperienciaEspecialidad(
			ExperienciaEspecialidad experienciaEspecialidad) {
		if (experienciaEspecialidad.getId() == null) {
			experienciaEspecialidad
					.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		experienciaEspecialidad.setFechaActualizacion(new Date());
		experienciaEspecialidad.setFechaCreacion(new Date());
		getDao().saveObject(experienciaEspecialidad);

		return experienciaEspecialidad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#guardarIdioma
	 * (pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma)
	 */
	public ProfesionalIdioma guardarIdioma(ProfesionalIdioma idioma) {
		if (idioma.getId() == null) {
			idioma.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		idioma.setFechaActualizacion(new Date());
		idioma.setFechaCreacion(new Date());
		getDao().saveObject(idioma);
		return idioma;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * guardarPreferencia(pe.gob.trabajo.pcd.modelo.dominio.Preferencia)
	 */
	public Preferencia guardarPreferencia(Preferencia preferencia) {
		if (preferencia.getId() == null) {
			preferencia.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		preferencia.setFechaActualizacion(new Date());
		preferencia.setFechaCreacion(new Date());
		getDao().saveObject(preferencia);
		return preferencia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * guardarPreferencias(java.util.List, java.util.List, java.util.List,
	 * pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public int guardarPreferencias(List areas, List sectores, List ciudades,
			Profesional profesional) {
		Long idProfesional = profesional.getId();
		int retorno = -1;

		getDao().saveObject(profesional);
		 retorno = getDao().borrarPreferencias(areas,
		 Constantes.TIPO_PREFERENCIA_AREA.getId(), idProfesional);
		 getDao().saveCollection(areas);
		retorno += getDao().borrarPreferencias(sectores,
				Constantes.TIPO_PREFERENCIA_SECTOR.getId(), idProfesional);
		getDao().saveCollection(sectores);
		 retorno += getDao().borrarPreferencias(ciudades,
		 Constantes.TIPO_PREFERENCIA_CIUDAD.getId(), idProfesional);
		 getDao().saveCollection(ciudades);
		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#guardarReferencia
	 * (pe.gob.trabajo.pcd.modelo.dominio.Referencia)
	 */
	public Referencia guardarReferencia(Referencia referencia) {
		getDao().saveObject(referencia);
		// logger.info("referencia guardada");
		return referencia;
	}

	/**
	 * Guardar collection.
	 * 
	 * @param col
	 *            the col
	 */
	public void guardarCollection(Collection<Preferencia> col) {
		for (Preferencia obj : col) {
			guardarPreferencia(obj);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#guardarContacto
	 * (pe.gob.trabajo.pcd.modelo.dominio.Contacto)
	 */
	public Contacto guardarContacto(Contacto contacto) {
		if (contacto.getId() == null) {
			contacto.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		contacto.setFechaActualizacion(new Date());
		contacto.setFechaCreacion(new Date());
		getDao().saveObject(contacto);
		// logger.info("contacto guardado");
		return contacto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerPreferencias(pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Preferencia> obtenerPreferencias(Profesional profesional) {
		List<Preferencia> retorno = new ArrayList<Preferencia>();
		if (profesional != null && !profesional.getId().equals(0L)) {
			List<Preferencia> prefCiudad = getDao().buscarPreferencias(Constantes.TIPO_PREFERENCIA_CIUDAD.getId(), profesional.getId());
			List<Preferencia> prefArea = getDao().buscarPreferencias(Constantes.TIPO_PREFERENCIA_AREA.getId(), profesional.getId());
			List<Preferencia> prefSector = getDao().buscarPreferencias(Constantes.TIPO_PREFERENCIA_SECTOR.getId(), profesional.getId());
			
			retorno.addAll(prefCiudad);
			retorno.addAll(prefArea);
			retorno.addAll(prefSector);
		}
		for (Preferencia p : retorno) {
			Hibernate.initialize(p.getTipoPreferencia());
		}
		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerPreferenciasSector
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Preferencia> obtenerPreferenciasSector(Profesional profesional) {
		List<Preferencia> preferencias = getDao()
				.buscarPreferencias(Constantes.TIPO_PREFERENCIA_SECTOR.getId(),
						profesional.getId());

		// List<Preferencia> preferencias = obtenerPreferencias(profesional);
		List<Preferencia> retorno = new ArrayList<Preferencia>();
		List<Sector> listaSector = null;

		for (Preferencia preferencia : preferencias) {
			if (preferencia.getTipoPreferencia().getId()
					.compareTo(Constantes.TIPO_PREFERENCIA_SECTOR.getId()) == 0) {
				Sector sector = (Sector) proveedorMaestroDAO.findObjectByPK(
						preferencia.getId().getIdPrfrnca(), Sector.class);
				if (sector != null) {
					PreferenciaId preferenciaId = new PreferenciaId();
					preferenciaId.setIdPrfrnca(sector.getId());
					preferenciaId.setIdPrfsnal(profesional.getId());
					preferenciaId
							.setIdTpoPrfrnca(Constantes.TIPO_PREFERENCIA_SECTOR
									.getId());

					Preferencia itemPreferenciaSector = new Preferencia();
					itemPreferenciaSector.setSector(sector);
					itemPreferenciaSector.setId(preferenciaId);
					itemPreferenciaSector
							.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_SECTOR);
					retorno.add(itemPreferenciaSector);
				}
			}
		}

		// for (Sector sector : listaSector) {
		// PreferenciaId preferenciaId = new PreferenciaId();
		// preferenciaId.setIdPrfrnca(sector.getId());
		// preferenciaId.setIdPrfsnal(profesional.getId());
		// preferenciaId.setIdTpoPrfrnca(Constantes.TIPO_PREFERENCIA_SECTOR
		// .getId());
		//
		// Preferencia itemPreferenciaSector = new Preferencia();
		// itemPreferenciaSector.setSector(sector);
		// itemPreferenciaSector.setId(preferenciaId);
		// itemPreferenciaSector
		// .setTipoPreferencia(Constantes.TIPO_PREFERENCIA_SECTOR);
		// retorno.add(itemPreferenciaSector);
		// // logger.info(preferenciaId.getIdPrfrnca()
		// // + preferenciaId.getIdTpoPrfrnca()
		// // + preferenciaId.getIdPrfsnal());
		// }
		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerPreferenciasArea
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Preferencia> obtenerPreferenciasArea(Profesional profesional) {
		List<Preferencia> retorno = new ArrayList<Preferencia>();
		if (profesional != null && !profesional.getId().equals(0L)) {
			List<Area> listaAreas = getDao()
					.buscarPreferenciasArea(profesional);
			for (Area area : listaAreas) {
				PreferenciaId preferenciaId = new PreferenciaId();
				preferenciaId.setIdPrfrnca(area.getId());
				preferenciaId.setIdPrfsnal(profesional.getId());
				preferenciaId.setIdTpoPrfrnca(Constantes.TIPO_PREFERENCIA_AREA
						.getId());

				Preferencia itemPreferenciaArea = new Preferencia();
				itemPreferenciaArea.setArea(area);
				itemPreferenciaArea.setId(preferenciaId);
				itemPreferenciaArea
						.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_AREA);
				retorno.add(itemPreferenciaArea);
			}
		}
		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerPreferenciasCiudad
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Preferencia> obtenerPreferenciasCiudad(Profesional profesional) {
		List<Preferencia> retorno = new ArrayList<Preferencia>();
		if (profesional != null && !profesional.getId().equals(0L)) {
			List<Ubigeo> listaCiudades = getDao().buscarPreferenciasCiudad(
					profesional);
			for (Ubigeo ciudad : listaCiudades) {
				PreferenciaId preferenciaId = new PreferenciaId();
				preferenciaId.setIdPrfrnca(ciudad.getId());
				preferenciaId.setIdPrfsnal(profesional.getId());
				preferenciaId
						.setIdTpoPrfrnca(Constantes.TIPO_PREFERENCIA_CIUDAD
								.getId());

				Preferencia itemPreferenciaArea = new Preferencia();
				itemPreferenciaArea.setCiudad(ciudad);
				itemPreferenciaArea.setId(preferenciaId);
				itemPreferenciaArea
						.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_CIUDAD);
				retorno.add(itemPreferenciaArea);
			}
		}
		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerReferencias(pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Referencia> obtenerReferencias(Profesional profesional) {
		// List<Referencia> listaReferencia =
		// getDao().buscarReferencias(profesional);
		// if (profesional != null && !profesional.getId().equals(0L)) {
		// for(Referencia referencia:listaReferencia){
		// Referencia item = new Referencia();
		// item.setId(referencia.getId());
		// //item.setDescripcion(referencia.getDescripcion());
		// listaReferencia.add(item);
		// }
		// }
		//
		// return listaReferencia;
		List<Referencia> lista = getProfesionalDAO().obtenerReferencias(
				profesional);
		for (Referencia referencia : lista) {
			// Hibernate.initialize(referencia.getPuesto());
			if (referencia.getCargo() != null) {
				PersonaCargo cargo = (PersonaCargo) getProveedorMaestroDAO()
						.findObjectByPK(referencia.getCargo(),
								PersonaCargo.class);
				if (cargo != null) {
					referencia.setDescripcionCargo(cargo.getDescripcion());
				}
			}
			Hibernate.initialize(referencia.getEmpresa());
			Hibernate.initialize(referencia.getPersona());
			Hibernate.initialize(referencia.getTipoReferencia());

		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#obtenerIdiomas
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<ProfesionalIdioma> obtenerIdiomas(Profesional profesional) {
		List<ProfesionalIdioma> lista = getProfesionalDAO().obtenerIdiomas(
				profesional);
		for (ProfesionalIdioma idioma : lista) {
			if (idioma.getOverall() != null) {
				NivelIdioma nivelIdioma = (NivelIdioma) getProfesionalDAO()
						.findObjectByPK(idioma.getOverall(), NivelIdioma.class);
				if (nivelIdioma != null) {
					idioma.setNivelIdioma(nivelIdioma);
				}
			}
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerCertificaciones(pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Certificacion> obtenerCertificaciones(Profesional profesional) {
		List<Certificacion> lista = getProfesionalDAO().obtenerCertificaciones(
				profesional);
		for (Certificacion certificacion : lista) {
			// Hibernate.initialize(certificacion.getEspecialidadProfesional());
			if (certificacion.getIdOcupacion() != null) {
				Ocupacion ocupacion = (Ocupacion) proveedorMaestroDAO
						.findObjectByPK(certificacion.getIdOcupacion(),
								Ocupacion.class);
				if (ocupacion != null) {
					certificacion.setDescripcionObjetoOcupacion(ocupacion
							.getDescripcion());
				}
			}
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerExperienciaEspecialidad
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<ExperienciaEspecialidad> obtenerExperienciaEspecialidad(
			Profesional profesional) {
		List<ExperienciaEspecialidad> lista = getProfesionalDAO()
				.obtenerExperienciaEspecialidad(profesional);
		for (ExperienciaEspecialidad experienciaEspecialidad : lista) {
			// Hibernate.initialize(experienciaEspecialidad
			// .getEspecialidadProfesional());
			Ocupacion ocupacion = (Ocupacion) proveedorMaestroDAO
					.findObjectByPK(experienciaEspecialidad.getIdOcupacion(),
							Ocupacion.class);
			if (ocupacion != null) {
				experienciaEspecialidad.setDescripcionOcupacion(ocupacion
						.getDescripcion());
			}
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#guardarEmpleo
	 * (pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral)
	 */
	public ExperienciaLaboral guardarEmpleo(ExperienciaLaboral empleo) {
		getDao().saveObject(empleo);
		return empleo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#obtenerEmpleos
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<ExperienciaLaboral> obtenerEmpleos(Profesional profesional) {
		ArrayList<ExperienciaLaboral> lista = (ArrayList<ExperienciaLaboral>) getProfesionalDAO().obtenerEmpleos(
				profesional);
		for (ExperienciaLaboral empleo : lista) {
			Hibernate.initialize(empleo.getEmpresa());
			// Hibernate.initialize(empleo.getPuesto());
			if (empleo.getCargo() != null) {
				PersonaCargo cargo = (PersonaCargo) getProveedorMaestroDAO()
						.findObjectByPK(empleo.getCargo(), PersonaCargo.class);
				if (cargo != null) {
					empleo.setDescripcionCargo(cargo.getNombre());
				}
			}
			// Hibernate.initialize(empleo.getRolLaboral());
			if (empleo.getIdOcupacion() != null) {
				Ocupacion ocupacion = (Ocupacion) getProveedorMaestroDAO()
						.findObjectByPK(empleo.getIdOcupacion(),
								Ocupacion.class);
				if (ocupacion != null) {
					empleo.setDescripcionOcupacion(ocupacion.getDescripcion());
				}
			}
			// Hibernate.initialize(empleo.getSector());
			if (empleo.getIdSector() != null) {
				Sector sector = (Sector) getProveedorMaestroDAO()
						.findObjectByPK(empleo.getIdSector(), Sector.class);
				if (sector != null) {
					empleo.setDescripcionSector(sector.getDescripcion());
				}
			}
			Hibernate.initialize(empleo.getArea());
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#obtenerContactos
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Contacto> obtenerContactos(Profesional profesional) {
		List<Contacto> lista = getProfesionalDAO()
				.obtenerContactos(profesional);
		for (Contacto contacto : lista) {
			Hibernate.initialize(contacto.getPersona());
			Hibernate.initialize(contacto.getContactoMedios());
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#obtenerEstudios
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Formacion> obtenerEstudios(Profesional profesional) {
		List<Formacion> lista = getProfesionalDAO()
				.obtenerEstudios(profesional);
		for (Formacion formacion : lista) {
			if (formacion.getIdNivel() != null
					&& !formacion.getIdNivel().equals("")) {
				NivelEducativo nivel = (NivelEducativo) proveedorMaestroDAO
						.findObjectByPK(formacion.getIdNivel(),
								NivelEducativo.class);
				if (nivel != null) {
					formacion.setDescripcionNivel(nivel.getDescripcion());
				}
			}
			if (formacion.getIdProfesion() != null
					&& !formacion.getIdProfesion().equals("")) {
				Profesion profesion = (Profesion) proveedorMaestroDAO
						.findObjectByPK(formacion.getIdProfesion(),
								Profesion.class);
				if (profesion != null) {
					formacion.setDescripcionProfesion(profesion
							.getDescripcion());
					formacion.setIdGrupoProfesion(profesion.getGrupoProfesion()
							.getId());
				}
			}
			Hibernate.initialize(formacion.getTipoFormacion());
			Hibernate.initialize(formacion.getEstado());
			Hibernate.initialize(formacion.getInstitucionFormativa());
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#guardarEstudio
	 * (pe.gob.trabajo.pcd.modelo.dominio.Formacion)
	 */
	public Formacion guardarEstudio(Formacion formacion) {
		// if(formacion.getId()==null){
		// formacion.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		// }
		// formacion.setFechaActualizacion(new Date());
		// formacion.setFechaCreacion(new Date());
		getDao().saveObject(formacion);
		return formacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * obtenerProfesional(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public Profesional obtenerProfesional(Persona persona) {
		Profesional profesional = null;
		if (persona != null) {
			profesional = (Profesional) getProfesionalDAO().findObjectByPK(
					persona.getId(), Profesional.class);
			if (profesional != null) {
				Hibernate.initialize(profesional.getPersona());
				Hibernate.initialize(profesional.getPersona()
						.getTipoDocumentoIdentidad());
				Hibernate.initialize(profesional.getPersona()
						.getLugarResidencia());
				Hibernate.initialize(profesional.getPersona()
						.getLugarNacimiento());
				Hibernate.initialize(profesional.getPersona().getContactos());
				for (Contacto contacto : profesional.getPersona()
						.getContactos()) {
					if (contacto != null) {
						Hibernate.initialize(contacto);
						Hibernate.initialize(contacto.getContactoMedios());
					}
				}
			}
		}
		return profesional;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.ProfesionalService#
	 * buscarProfesionales(java.lang.String[], java.lang.String[],
	 * java.lang.String[], java.lang.String[], java.lang.String[])
	 */
	public List<ReporteE1> getReporteE1(String[] direcciones,
			String[] profesionales, String[] tecnicos, String[] operativos,
			String[] noCalificados,String fechaInicio, String fechaFin) {
		HashMap<String, HashMap<String, List<?>>> criterios = new HashMap<String, HashMap<String, List<?>>>(
				0);

		// direcciones
		if (direcciones != null && direcciones.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listadirecciones = new ArrayList<String>();
			for (int i = 0; i < direcciones.length; i++) {
				listadirecciones.add(direcciones[i]);
			}
			claveValores.put("idDireccion", listadirecciones);
			criterios.put("direccion", claveValores);
		}

		// profesionales
		if (profesionales != null && profesionales.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaProfesionales = new ArrayList<String>();
			for (int i = 0; i < profesionales.length; i++) {
				listaProfesionales.add(profesionales[i]);
			}
			claveValores.put("idProfesional", listaProfesionales);
			criterios.put("profesional", claveValores);
		}

		// tecnicos
		if (tecnicos != null && tecnicos.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaTecnicos = new ArrayList<String>();
			for (int i = 0; i < tecnicos.length; i++) {
				listaTecnicos.add(tecnicos[i]);
			}
			claveValores.put("idTecnico", listaTecnicos);
			criterios.put("tecnico", claveValores);
		}

		// operativos
		if (operativos != null && operativos.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaOperativos = new ArrayList<String>();
			for (int i = 0; i < operativos.length; i++) {
				listaOperativos.add(operativos[i]);
			}
			claveValores.put("idOperativo", listaOperativos);
			criterios.put("operativo", claveValores);
		}

		// noCalificados
		if (noCalificados != null && noCalificados.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaNoCalificados = new ArrayList<String>();
			for (int i = 0; i < noCalificados.length; i++) {
				listaNoCalificados.add(noCalificados[i]);
			}
			claveValores.put("idNoCalificado", listaNoCalificados);
			criterios.put("noCalificado", claveValores);
		}

		List<ReporteE1> consulta = (ArrayList<ReporteE1>) getDao()
				.getReporteE1(criterios, fechaInicio, fechaFin);

		return consulta;
	}

	public List<ReporteE2> getReporteE2(String[] grupo1, String[] grupo2,
			String[] grupo3, String[] grupo4, String[] grupo5, String[] grupo6,
			String[] grupo7, String[] grupo8, String[] grupo9,
			String[] grupo10, String[] grupo11, String[] grupo12,
			String fechaInicio, String fechaFin) {

		HashMap<String, HashMap<String, List<?>>> criterios = new HashMap<String, HashMap<String, List<?>>>(
				0);

		// grupo1
		if (grupo1 != null && grupo1.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo1 = new ArrayList<String>();
			for (int i = 0; i < grupo1.length; i++) {
				listaGrupo1.add(grupo1[i]);
			}
			claveValores.put("listGrupo1", listaGrupo1);
			criterios.put("grupo1", claveValores);
		}

		// grupo2
		if (grupo2 != null && grupo2.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo2 = new ArrayList<String>();
			for (int i = 0; i < grupo2.length; i++) {
				listaGrupo2.add(grupo2[i]);
			}
			claveValores.put("listGrupo2", listaGrupo2);
			criterios.put("grupo2", claveValores);
		}

		// grupo3
		if (grupo3 != null && grupo3.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo3 = new ArrayList<String>();
			for (int i = 0; i < grupo3.length; i++) {
				listaGrupo3.add(grupo3[i]);
			}
			claveValores.put("listGrupo3", listaGrupo3);
			criterios.put("grupo3", claveValores);
		}

		// grupo4
		if (grupo4 != null && grupo4.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo4 = new ArrayList<String>();
			for (int i = 0; i < grupo4.length; i++) {
				listaGrupo4.add(grupo4[i]);
			}
			claveValores.put("listGrupo4", listaGrupo4);
			criterios.put("grupo4", claveValores);
		}

		// grupo5
		if (grupo5 != null && grupo5.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo5 = new ArrayList<String>();
			for (int i = 0; i < grupo5.length; i++) {
				listaGrupo5.add(grupo5[i]);
			}
			claveValores.put("listGrupo5", listaGrupo5);
			criterios.put("grupo5", claveValores);
		}

		// grupo6
		if (grupo6 != null && grupo6.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo6 = new ArrayList<String>();
			for (int i = 0; i < grupo6.length; i++) {
				listaGrupo6.add(grupo6[i]);
			}
			claveValores.put("listGrupo6", listaGrupo6);
			criterios.put("grupo6", claveValores);
		}

		// grupo7
		if (grupo7 != null && grupo7.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo7 = new ArrayList<String>();
			for (int i = 0; i < grupo7.length; i++) {
				listaGrupo7.add(grupo7[i]);
			}
			claveValores.put("listGrupo7", listaGrupo7);
			criterios.put("grupo7", claveValores);
		}

		// grupo8
		if (grupo8 != null && grupo8.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo8 = new ArrayList<String>();
			for (int i = 0; i < grupo8.length; i++) {
				listaGrupo8.add(grupo8[i]);
			}
			claveValores.put("listGrupo8", listaGrupo8);
			criterios.put("grupo8", claveValores);
		}

		// grupo9
		if (grupo9 != null && grupo9.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo9 = new ArrayList<String>();
			for (int i = 0; i < grupo9.length; i++) {
				listaGrupo9.add(grupo9[i]);
			}
			claveValores.put("listGrupo9", listaGrupo9);
			criterios.put("grupo9", claveValores);
		}

		// grupo10
		if (grupo10 != null && grupo10.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo10 = new ArrayList<String>();
			for (int i = 0; i < grupo10.length; i++) {
				listaGrupo10.add(grupo10[i]);
			}
			claveValores.put("listGrupo10", listaGrupo10);
			criterios.put("grupo10", claveValores);
		}

		// grupo11
		if (grupo11 != null && grupo11.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo11 = new ArrayList<String>();
			for (int i = 0; i < grupo11.length; i++) {
				listaGrupo11.add(grupo11[i]);
			}
			claveValores.put("listGrupo11", listaGrupo11);
			criterios.put("grupo11", claveValores);
		}

		// grupo12
		if (grupo12 != null && grupo12.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo12 = new ArrayList<String>();
			for (int i = 0; i < grupo12.length; i++) {
				listaGrupo12.add(grupo2[i]);
			}
			claveValores.put("listGrupo12", listaGrupo12);
			criterios.put("grupo12", claveValores);
		}

		List<ReporteE2> consulta = (ArrayList<ReporteE2>) getDao().getReporteE2(
				criterios, fechaInicio, fechaFin);

		return consulta;
	}

	public List<ReporteE3> getReporteE3(String fechaInicio, String fechaFin) {

		List<ReporteE3> consulta = (ArrayList<ReporteE3>) getDao()
				.getReporteE3(fechaInicio, fechaFin);

		return consulta;
	}
	
	public List<ReporteE4> getReporteE4(String[] grupo1, String[] grupo2,
			String[] grupo3, String[] grupo4, String[] grupo5, String[] grupo6,
			String[] grupo7, String[] grupo8, String[] grupo9,
			String[] grupo10, String[] grupo11, String[] grupo12,
			String fechaInicio, String fechaFin) {

		HashMap<String, HashMap<String, List<?>>> criterios = new HashMap<String, HashMap<String, List<?>>>(
				0);

		// grupo1
		if (grupo1 != null && grupo1.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo1 = new ArrayList<String>();
			for (int i = 0; i < grupo1.length; i++) {
				listaGrupo1.add(grupo1[i]);
			}
			claveValores.put("listGrupo1", listaGrupo1);
			criterios.put("grupo1", claveValores);
		}

		// grupo2
		if (grupo2 != null && grupo2.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo2 = new ArrayList<String>();
			for (int i = 0; i < grupo2.length; i++) {
				listaGrupo2.add(grupo2[i]);
			}
			claveValores.put("listGrupo2", listaGrupo2);
			criterios.put("grupo2", claveValores);
		}

		// grupo3
		if (grupo3 != null && grupo3.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo3 = new ArrayList<String>();
			for (int i = 0; i < grupo3.length; i++) {
				listaGrupo3.add(grupo3[i]);
			}
			claveValores.put("listGrupo3", listaGrupo3);
			criterios.put("grupo3", claveValores);
		}

		// grupo4
		if (grupo4 != null && grupo4.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo4 = new ArrayList<String>();
			for (int i = 0; i < grupo4.length; i++) {
				listaGrupo4.add(grupo4[i]);
			}
			claveValores.put("listGrupo4", listaGrupo4);
			criterios.put("grupo4", claveValores);
		}

		// grupo5
		if (grupo5 != null && grupo5.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo5 = new ArrayList<String>();
			for (int i = 0; i < grupo5.length; i++) {
				listaGrupo5.add(grupo5[i]);
			}
			claveValores.put("listGrupo5", listaGrupo5);
			criterios.put("grupo5", claveValores);
		}

		// grupo6
		if (grupo6 != null && grupo6.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo6 = new ArrayList<String>();
			for (int i = 0; i < grupo6.length; i++) {
				listaGrupo6.add(grupo6[i]);
			}
			claveValores.put("listGrupo6", listaGrupo6);
			criterios.put("grupo6", claveValores);
		}

		// grupo7
		if (grupo7 != null && grupo7.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo7 = new ArrayList<String>();
			for (int i = 0; i < grupo7.length; i++) {
				listaGrupo7.add(grupo7[i]);
			}
			claveValores.put("listGrupo7", listaGrupo7);
			criterios.put("grupo7", claveValores);
		}

		// grupo8
		if (grupo8 != null && grupo8.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo8 = new ArrayList<String>();
			for (int i = 0; i < grupo8.length; i++) {
				listaGrupo8.add(grupo8[i]);
			}
			claveValores.put("listGrupo8", listaGrupo8);
			criterios.put("grupo8", claveValores);
		}

		// grupo9
		if (grupo9 != null && grupo9.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo9 = new ArrayList<String>();
			for (int i = 0; i < grupo9.length; i++) {
				listaGrupo9.add(grupo9[i]);
			}
			claveValores.put("listGrupo9", listaGrupo9);
			criterios.put("grupo9", claveValores);
		}

		// grupo10
		if (grupo10 != null && grupo10.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo10 = new ArrayList<String>();
			for (int i = 0; i < grupo10.length; i++) {
				listaGrupo10.add(grupo10[i]);
			}
			claveValores.put("listGrupo10", listaGrupo10);
			criterios.put("grupo10", claveValores);
		}

		// grupo11
		if (grupo11 != null && grupo11.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo11 = new ArrayList<String>();
			for (int i = 0; i < grupo11.length; i++) {
				listaGrupo11.add(grupo11[i]);
			}
			claveValores.put("listGrupo11", listaGrupo11);
			criterios.put("grupo11", claveValores);
		}

		// grupo12
		if (grupo12 != null && grupo12.length > 0) {
			HashMap<String, List<?>> claveValores = new HashMap<String, List<?>>(
					0);
			List<String> listaGrupo12 = new ArrayList<String>();
			for (int i = 0; i < grupo12.length; i++) {
				listaGrupo12.add(grupo2[i]);
			}
			claveValores.put("listGrupo12", listaGrupo12);
			criterios.put("grupo12", claveValores);
		}

		List<ReporteE4> consulta = (ArrayList<ReporteE4>) getDao().getReporteE4(
				criterios, fechaInicio, fechaFin);

		return consulta;
	}
	
	public List<ReporteOferta> buscarPorRangoFecha(String fechaInicio, String fechaFin) {

		List<ReporteOferta> consulta = (ArrayList<ReporteOferta>) getDao()
				.buscarPorRangoFecha(fechaInicio, fechaFin);

		return consulta;
	}
	
	public List<Postulacion> obtenerPostulaciones(Profesional profesional) {
		List<Postulacion> lista = getProfesionalDAO().obtenerPostulaciones(profesional);
		for (Postulacion postulacion : lista) {
			Hibernate.initialize(postulacion.getPedido());
			Hibernate.initialize(postulacion.getPedido().getEmpleador());
		}
		return lista;
	}
	
	public List<Profesional> buscarProfesionales(List<Long> idConsultores, List<String> idOficinas, Date fechaInicio, Date fechaFin) {
		List<Profesional> profesionales = new ArrayList<Profesional>();
		profesionales = getProfesionalDAO().buscarProfesional(idConsultores, idOficinas, fechaInicio, fechaFin);
		
		for (Profesional p : profesionales) {
			for (ExperienciaLaboral empleo : p.getExperienciasLaborales()) {
				if (empleo != null) {
					if (empleo.getCargo() != null) {
						PersonaCargo cargo = (PersonaCargo) getProveedorMaestroDAO()
								.findObjectByPK(empleo.getCargo(), PersonaCargo.class);
						if (cargo != null) {
							empleo.setDescripcionCargo(cargo.getNombre());
						}
					}					
				}
			}
			Distrito d = getProveedorMaestroDAO().getMaestroDistrito(new DistritoId(p.getPersona().getDistritoResidencia(), p.getPersona().getProvinciaResidencia(), p.getPersona().getDepartamentoResidencia()));
			if (d != null) {
				p.getPersona().setNombreLugarResidencia(d.getNombre());
			}
		}
		
		
		return profesionales;
	}

}
