package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Capacitacion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarCapacitacionMB.
 */
public class RegistrarCapacitacionMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarCapacitacionMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;

	/**
	 * Instantiates a new registrar Capacitacion mb.
	 */
	public RegistrarCapacitacionMB() {
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Capacitacion capacitacion = new Capacitacion();
		// Capacitacion.setNivel(nivelCapacitacion.getOrden());
		setBean(capacitacion);
	}

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
	 * @param profesionalBean
	 *            the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Seleccionar profesional.
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		Capacitacion bean = (Capacitacion) getSpringBean("CapacitacionPrt");
		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto Capacitacion y actualiza los cambios en la base
	 * de datos..
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		Capacitacion bean = (Capacitacion) getRowParameter(e, "capacitacionPrm");

		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
		UtilBean.initNullObject(bean);
	}

	/**
	 * Metodo que elimina un registro de la base de datos. .
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
		Capacitacion bean = (Capacitacion) getRowParameter(e, "capacitacionPrm");
		try {
			getServicio().getMaestroService().removeObject(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo eliminar");
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios..
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		Capacitacion bean = (Capacitacion) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO,
				getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		Capacitacion bean = (Capacitacion) getBean();
		// logger.info(bean);
		try {
			validar();
			getServicio().getProfesionalService().guardarCapacitacion(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			// logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	public void validar() {
		Capacitacion bean = (Capacitacion) getBean();

	}

	/**
	 * Cancelar.
	 *
	 * @param ActionEvent
	 *            e ocurre cuando el usuario realiza una acción
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Gets the estudios.
	 *
	 * @return objeto estudios
	 */
	public List<Capacitacion> getCapacitaciones() {
		List<Capacitacion> lista = getServicio().getProfesionalService().obtenerCapacitaciones(profesionalBean);
		return lista;
	}

}
