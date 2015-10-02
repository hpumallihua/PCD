package pe.gob.trabajo.pcd.servicio.spring.auditoria;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.trabajo.pcd.modelo.dao.AuditoriaDAO;
import pe.gob.trabajo.pcd.modelo.dominio.AuditData;
import pe.gob.trabajo.pcd.modelo.dominio.BeanEntidadGenerico;
import pe.gob.trabajo.pcd.modelo.dominio.BeanEntidadGenericoAutogenerado;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.servicio.auditoria.AuditoriaService;
import pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class AuditoriaServiceImpl.
 */
public class AuditoriaServiceImpl extends GenericServiceImpl<AuditData>
		implements AuditoriaService {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AuditoriaServiceImpl.class);

	/** The auditoria dao. */
	public AuditoriaDAO auditoriaDAO;

	/**
	 * Instantiates a new auditoria service impl.
	 */
	public AuditoriaServiceImpl() {

	}

	/**
	 * Gets the auditoria dao.
	 * 
	 * @return the auditoria dao
	 */
	public AuditoriaDAO getAuditoriaDAO() {
		if (auditoriaDAO == null) {
			String nombreBean = "AuditoriaDAO";
			ApplicationContext appContext;
			ServletContext context = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			appContext = WebApplicationContextUtils
					.getRequiredWebApplicationContext(context);
			auditoriaDAO = (AuditoriaDAO) appContext.getBean(nombreBean);
		}
		return auditoriaDAO;
	}

	/**
	 * Sets the auditoria dao.
	 * 
	 * @param auditoriaDAO
	 *            the new auditoria dao
	 */
	public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
		this.auditoriaDAO = auditoriaDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	public AuditoriaDAO getDao() {
		return auditoriaDAO;
	}

	/**
	 * Insertar auditoria.
	 * 
	 * @param entidad
	 *            the entidad
	 */
	public void insertarAuditoria(Object entidad) {
		logger.debug("=============> insertarAuditoria");
		BeanEntidadGenerico bean = (BeanEntidadGenerico) entidad;
		if (bean.getFechaCreacion() == null) {
			bean.setEstadoRegistro(Constantes.ESTADO_REGISTRO_ACTIVO);
		}
		bean.setIdUsuarioCreador(UtilBean.getUsuarioTransaccion().getId());
		bean.setIdUsroActualizador(UtilBean.getUsuarioTransaccion().getId());
		bean.setFechaCreacion(new Date());
		bean.setFechaActualizacion(new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.servicio.auditoria.AuditoriaService#
	 * grabarAuditoriaGrabados(java.lang.Object)
	 */
	public void grabarAuditoriaGrabados(Object entidad) {

		logger.debug("=============> grabarAuditoriaGrabados");
		 AuditData auditData = new AuditData();
		 auditData.setUsuario(UtilBean.getUsuarioTransaccion().getId());
		 auditData.setFecha(new Date());
		 auditData.setOperacion("TRANSACCION");
		 auditData.setDatos(((BeanEntidadGenerico)entidad).getAuditData());
		 getAuditoriaDAO().saveObject(auditData);
	}

	// private void insertarEntidad(BeanEntidadGenericoAutogenerado entidad) {
	// entidad.setId(null);
	// insertarAuditoria(entidad);
	// getAuditoriaDAO().saveObject(entidad);
	// }

	/**
	 * Insertar entidad.
	 * 
	 * @param entidad
	 *            the entidad
	 * @param clazz
	 *            the clazz
	 * @return the object
	 */
	private Object insertarEntidad(BeanEntidadGenericoAutogenerado entidad,
			Class<?> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			BeanUtils.copyProperties(entidad, obj);
			insertarAuditoria(entidad);
			((BeanEntidadGenericoAutogenerado) obj).setId(null);
		} catch (InstantiationException e) {
			logger.error(e.getStackTrace());
		} catch (IllegalAccessException e) {
			logger.error(e.getStackTrace());
		}
		getAuditoriaDAO().saveObject(obj);
		return obj;
	}

	/**
	 * Comprobar guardados.
	 * 
	 * @param entidad
	 *            the entidad
	 */
	public void comprobarGuardados(Object entidad) {
		logger.debug("=============> comprobarGuardados");
		if (entidad != null && UtilBean.getUsuarioSesion().isRolAdministrador()) {

			// Al guardar Empleos
			if (entidad instanceof ExperienciaLaboral) {
				ExperienciaLaboral bean = (ExperienciaLaboral) entidad;

				// Comprobar Puesto
				// if (bean.getPuesto() != null
				// && (bean.getPuesto().getId() == null || bean
				// .getPuesto().getId().equals(0L))
				// && (bean.getPuesto().getDescripcion() != null && !bean
				// .getPuesto().getDescripcion().trim().equals(""))) {
				// // Comprobar la existencia de este puesto antes de crear uno
				// // nuevo
				// bean.setPuesto((Puesto) insertarEntidad(bean.getPuesto(),
				// Puesto.class));
				// }

				// Comprobar Rol
				// if (bean.getRolLaboral() != null
				// && (bean.getRolLaboral().getId() == null || bean
				// .getRolLaboral().getId().equals(0L))
				// && (bean.getRolLaboral().getDescripcion() != null && !bean
				// .getRolLaboral().getDescripcion().trim()
				// .equals(""))) {
				// // Comprobar la existencia de este rol antes de crear uno
				// // nuevo
				// bean.setRolLaboral((RolLaboral) insertarEntidad(
				// bean.getRolLaboral(), RolLaboral.class));
				// }

				// Comprobar Empresa
				// if (bean.getEmpresa() != null
				// && (bean.getEmpresa().getId() == null || bean
				// .getEmpresa().getId().equals(0L))
				// && (bean.getEmpresa().getNombreComercial() != null && !bean
				// .getEmpresa().getNombreComercial().trim().equals(""))) {
				// // Comprobar la existencia de esta empresa antes de crear
				// // una nueva
				// bean.setEmpresa((Empresa) insertarEntidad(
				// bean.getEmpresa(), Empresa.class));
				// }

				// Comprobar Sector
				// if (bean.getSector() != null
				// && (bean.getSector().getId() == null || bean
				// .getSector().getId().equals(0L))
				// && (bean.getSector().getDescripcion() != null && !bean
				// .getSector().getDescripcion().trim().equals(""))) {
				// // Comprobar la existencia de este sector antes de crear uno
				// // nuevo
				// bean.setSector((Sector) insertarEntidad(bean.getSector(),
				// Sector.class));
				// }

			}

			if (entidad instanceof Referencia) {
				Referencia bean = (Referencia) entidad;
				// Comprobar Puesto
				if (bean.getPuesto() != null
						&& (bean.getPuesto().getId() == null || bean
								.getPuesto().getId().equals(0L))
						&& (bean.getPuesto().getDescripcion() != null && !bean
								.getPuesto().getDescripcion().trim().equals(""))) {
					// Comprobar la existencia de este puesto antes de crear uno
					// nuevo
					bean.setPuesto((Puesto) insertarEntidad(bean.getPuesto(),
							Puesto.class));
				}
				// Comprobar Empresa
				// if (bean.getEmpresa() != null
				// && (bean.getEmpresa().getId() == null || bean
				// .getEmpresa().getId().equals(0L))
				// && (bean.getEmpresa().getNombreComercial() != null && !bean
				// .getEmpresa().getNombreComercial().trim().equals(""))) {
				// // Comprobar la existencia de esta empresa antes de crear
				// // una nueva
				// bean.setEmpresa((Empresa) insertarEntidad(
				// bean.getEmpresa(), Empresa.class));
				// }
				// Comprobar Tipo Referencia
				// if (bean.getTipoReferencia() != null
				// && (bean.getTipoReferencia().getId() == null || bean
				// .getTipoReferencia().getId().equals(0L))
				// && (bean.getTipoReferencia().getDescripcion() != null &&
				// !bean
				// .getTipoReferencia().getDescripcion().trim()
				// .equals(""))) {
				// // Comprobar la existencia un tipo de referencia antes de
				// // crear
				// // una nueva
				// bean.setTipoReferencia((TipoReferencia) insertarEntidad(
				// bean.getTipoReferencia(), TipoReferencia.class));
				// }
				// // Comprobar Persona
				// if (bean.getPersona() != null
				// && (bean.getPersona().getId() == null || bean
				// .getPersona().getId().equals(0L))
				// && (bean.getPersona().getApellidoPaterno() != null && !bean
				// .getPersona().getApellidoPaterno().trim().equals(""))) {
				// // Comprobar la existencia de esta empresa antes de crear
				// // una nueva
				// bean.setPersona((Persona) insertarEntidad(
				// bean.getPersona(), Persona.class));
				// }
			}

			// Al guardar Estudios / Formacion
			if (entidad instanceof Formacion) {
				Formacion bean = (Formacion) entidad;

				// Comprobar Institucion
				// if (bean.getInstitucionFormativa() != null
				// && (bean.getInstitucionFormativa().getId() == null || bean
				// .getInstitucionFormativa().getId().equals(0L))
				// && (bean.getInstitucionFormativa().getDescripcion() != null
				// && !bean
				// .getInstitucionFormativa().getDescripcion()
				// .trim().equals(""))) {
				// // Comprobar la existencia de esta institucion formativa
				// // antes de crear una nueva
				// bean.setInstitucionFormativa((InstitucionFormativa)
				// insertarEntidad(
				// bean.getInstitucionFormativa(),
				// InstitucionFormativa.class));
				// }
			}

		}
	}

	/**
	 * Filtrar busqueda.
	 */
	public void filtrarBusqueda() {

		// logger.info("filtrarBusqueda");
		//
		// if (!UtilBean.getUsuarioSesion().isRolAdministrador()) {
		// Session session = getAuditoriaDAO().getHibernateSession();
		//
		// logger.info(session.isOpen());
		// logger.info("Aplicando filtro:");
		//
		// Filter filtro2 = session.enableFilter("filtroPreferencias");
		// Collection vars = new ArrayList();
		// vars.add(new Long(1));
		// vars.add(new Long(2));
		// vars.add(new Long(3));
		// filtro2.setParameterList("preferenciasParam", vars );
		// filtro2.setParameter("tipoPreferenciasParam", 2L );
		//
		// // Desactivamos el filtro
		// // session.disableFilter("filtroCurriculum");
		//
		// }
		// logger.info("Saliendo..");
	}
}
