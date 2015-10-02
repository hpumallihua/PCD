package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.EstadoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarFormacionMB.
 */
public class RegistrarFormacionMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarFormacionMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The nivel formacion. */
	private NivelFormacion nivelFormacion;

	/**
	 * Gets the nivel formacion.
	 *
	 * @return the nivel formacion
	 */
	public NivelFormacion getNivelFormacion() {
		return nivelFormacion;
	}

	/**
	 * Sets the nivel formacion.
	 *
	 * @param nivelFormacion the new nivel formacion
	 */
	public void setNivelFormacion(NivelFormacion nivelFormacion) {
		this.nivelFormacion = nivelFormacion;
	}

	/**
	 * Instantiates a new registrar formacion mb.
	 */
	public RegistrarFormacionMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Formacion formacion = new Formacion();
		nivelFormacion = new NivelFormacion();
		//formacion.setNivel(nivelFormacion.getOrden());
		setBean(formacion);
	}

	// public ExperienciaLaboral getBean() {
	// return (ExperienciaLaboral) super.getBean();
	// }

	/**
	 * Gets the profesional bean.
	 *
	 * @return the profesional bean
	 */
	public Profesional getProfesionalBean() {
		return profesionalBean;
	}

	/**
	 * Sets the profesional bean.
	 *
	 * @param profesionalBean the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Seleccionar profesional.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		Formacion bean = (Formacion) getSpringBean("FormacionPrt");
		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto Formacion y actualiza los cambios en la base de datos..
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		Formacion bean = (Formacion) getRowParameter(e, "estudioPrm");

		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
		UtilBean.initNullObject(bean);
	}

	/**
	 * Metodo que elimina un registro de la base de datos. .
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
		Formacion bean = (Formacion) getRowParameter(e, "estudioPrm");
		try {
			getServicio().getMaestroService().removeObject(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo eliminar");
		}
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#getItemsEstadoFormacion()
	 */
	public List<?> getItemsEstadoFormacion() {
		List<EstadoFormacion> lista = (List<EstadoFormacion>) getServicio()
				.getMaestroService().getAllObject(EstadoFormacion.class);
		return Items.getItems(lista, "descripcion", "id");
	}
	
	/**
	 * Gets the items grupo profesion.
	 *
	 * @return the items grupo profesion
	 */
	public List<?> getItemsGrupoProfesion() {
		List<GrupoProfesion> lista = (List<GrupoProfesion>) getServicio()
				.getMaestroService().getMaestroGrupoProfesiones();
		return Items.getItems(lista, "descripcion", "id");
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios..
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		Formacion bean = (Formacion) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		Formacion bean = (Formacion) getBean();
//		logger.info(bean);
		try {
			validar();
			getServicio().getProfesionalService().guardarEstudio(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
//			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	public void validar() {
		Formacion bean = (Formacion) getBean();
		
		boolean nombreAsignado = false;
		boolean idAsignado = false;
		
		nombreAsignado = bean.getInstitucionFormativa() != null && bean.getInstitucionFormativa().getDescripcion() != null && !bean.getInstitucionFormativa().getDescripcion().equals("");
		idAsignado = bean.getInstitucionFormativa() != null && bean.getInstitucionFormativa().getId()!= null && !bean.getInstitucionFormativa().getId().equals(0L);
		
		if (!nombreAsignado || ((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
			if (!nombreAsignado) {
				bean.setInstitucionFormativa(null);
			}
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar la institución"));
		}

//		if (bean.getInstitucionFormativa() != null
////				&& (bean.getInstitucionFormativa().getDescripcion() != null && bean
////						.getInstitucionFormativa().getDescripcion().trim()
////						.equals(""))
//				&& (bean.getInstitucionFormativa().getId() == null || bean
//						.getInstitucionFormativa().getId().equals(0L))) {
//			bean.setInstitucionFormativa(null);
//		}
		if (bean.getTermino() != null
				&& bean.getTermino().before(bean.getInicio())) {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Error en la fecha de término"));
		}
	}

	/**
	 * Cancelar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Gets the estudios.
	 *
	 * @return objeto estudios
	 */
	public List<Formacion> getEstudios() {
		List<Formacion> lista = getServicio().getProfesionalService()
				.obtenerEstudios(profesionalBean);	
		return lista;
	}

}
