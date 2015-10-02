package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.Calendar;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarCertificacionMB.
 */
public class RegistrarCertificacionMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarCertificacionMB.class);
	
	/** The profesional bean. */
	private Profesional profesionalBean;

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
	 * Metodo encargado de validar los campos obligatorios.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		Certificacion bean = (Certificacion) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		Certificacion bean = (Certificacion) getBean();
		try {
			validar();
			
			getServicio().getProfesionalService().guardarCertificacion(
					(Certificacion) getBean());
			setBean(bean);
			if (bean != null && bean.getId() != null) {
				agregarMensajeExitoTransaccion("Dato guardado con éxito");
			} else {
				agregarMensajeErrorTransaccion("Error");
			}
			setAccionRealizada(Constantes.ACCION_LISTAR);
		} catch (Exception e2) {
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
	}

	/**
	 * Metodo encargado de validar los campos obligatorios.
	 */
	public void validar() {
		Certificacion bean = (Certificacion) getBean();
		Calendar c1 = Calendar.getInstance();
		
		boolean nombreAsignado = false;
		boolean idAsignado = false;
		
		nombreAsignado = bean.getDescripcionObjetoOcupacion() != null && !bean.getDescripcionObjetoOcupacion().equals("");
		idAsignado = bean.getIdOcupacion() != null && !bean.getIdOcupacion().equals("");
		
		if (!nombreAsignado || ((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
			if (!nombreAsignado) {
				bean.setIdOcupacion(null);
			}
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar una Ocupación"));
		}

		if (bean.getVigenteHasta() != null && bean.getVigenteHasta() == 0) {
			bean.setVigenteHasta(null);
		} /*else {
			if (bean.getVigenteHasta().equals("")) {
				bean.setVigenteHasta(null);
			}
		}*/
		if (bean.getVigenteHasta() != null && bean.getVigenteHasta() > 0
				&& bean.getAnio() > bean.getVigenteHasta()
				&& !(bean.getVigenteHasta() == 0)) {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Error Año es mayor que Vigente Hasta:"));
		}
		if (bean.getAnio() > c1.get(Calendar.YEAR)) {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Error Año es mayor al Actual"));
		}

//		if (bean != null && bean.getEspecialidadProfesional() != null) {
//			if (bean.getEspecialidadProfesional().getId() != null
//					&& bean.getEspecialidadProfesional().getId().equals(0L)) {
//				bean.setEspecialidadProfesional(null);
//			}
//		}

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
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
		Integer anio = 2011;
		Certificacion bean = new Certificacion();
		if (bean.getAnio() == null) {
			bean.setAnio(anio);
		}
		bean.setProfesional(profesionalBean);
		UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo encargado de actualizar un registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		Certificacion bean = (Certificacion) getRowParameter(e,
				"certificacionPrm");
		UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
	}

	/**
	 * Metodo que elimina un registro de la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("eliminar... ");
		Certificacion bean = (Certificacion) getRowParameter(e,
				"certificacionPrm");

		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("El Certificado ha sido eliminado");

	}

	/**
	 * Gets the certificaciones.
	 *
	 * @return the certificaciones
	 */
	public List<Certificacion> getCertificaciones() {
//		logger.info(getProfesionalBean());
		return (List<Certificacion>) getServicio().getProfesionalService()
				.obtenerCertificaciones(getProfesionalBean());

	}

	// public List<?> getItemsIdioma() {
	// List<Idioma> lista = (List<Idioma>) getServicio().getMaestroService()
	// .getAllObject(Idioma.class);
	// return Items.getItems(lista, "descripcion", "id");
	// }
	//
	// public List<?> getItemsTecnologia(){
	// List<Tecnologia> lista = (List<Tecnologia>)
	// getServicio().getMaestroService().getAllObject(Tecnologia.class);
	// return Items.getItems(lista, "dscrpcon", "idTcnlga");
	// }

	/**
	 * Gets the items especialidad profesional.
	 *
	 * @return the items especialidad profesional
	 */
	public List<?> getItemsEspecialidadProfesional() {
		List<EspecialidadProfesional> lista = (List<EspecialidadProfesional>) getServicio()
				.getMaestroService()
				.getAllObject(EspecialidadProfesional.class);
		// List<EspecialidadProfesional> listaRetorno = new
		// ArrayList<EspecialidadProfesional>();
		// for (EspecialidadProfesional bean : lista) {
		// EspecialidadProfesional item = new EspecialidadProfesional();
		// item.setId(bean.getId());
		// item.setDescripcion(bean.getDescripcion());
		// listaRetorno.add(item);
		// }
		// return Items.getItems(listaRetorno, "descripcion", "id");
		return Items.getItems(lista, "descripcion", "id");
	}

}
