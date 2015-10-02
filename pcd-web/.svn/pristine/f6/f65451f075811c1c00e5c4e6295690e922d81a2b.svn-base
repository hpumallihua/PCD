package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarEmpleosMB.
 */
public class RegistrarEmpleosMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarEmpleosMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;

	/**
	 * Instantiates a new registrar empleos mb.
	 */
	public RegistrarEmpleosMB() {
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		setBean(new ExperienciaLaboral());
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
	 * @param profesionalBean
	 *            the new profesional bean
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
		ExperienciaLaboral bean = (ExperienciaLaboral) getSpringBean("ExperienciaLaboralPrt");
		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto ExperienciaLaboral y actualiza los cambios en la
	 * base de datos.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		ExperienciaLaboral bean = (ExperienciaLaboral) getRowParameter(e,
				"empleoPrm");
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
		UtilBean.initNullObject(bean);
	}

	/**
	 * Metodo que elimina un registro de la base de datos.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
		ExperienciaLaboral bean = (ExperienciaLaboral) getRowParameter(e,
				"empleoPrm");
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
	 * Metodo encargado de validar todos los campos obligatorios.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		ExperienciaLaboral bean = (ExperienciaLaboral) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO,
				Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion()
						.getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		ExperienciaLaboral bean = (ExperienciaLaboral) getBean();
		// logger.info(bean);
		try {
			validar();
			
			if (bean.getPrincipal() != null && bean.getPrincipal().compareTo(Constantes.EMPLEO_PRINCIPAL) == 0) {
				Profesional p = new Profesional();
				p.setId(bean.getProfesional().getId());
				List<ExperienciaLaboral> lista = getServicio().getProfesionalService().obtenerEmpleos(p);
				for (ExperienciaLaboral exp : lista) {
					exp.setPrincipal(Constantes.EMPLEO_SECUNDARIO);
					if (bean.getId() == null || (bean.getId() != null && exp.getId().compareTo(bean.getId()) != 0)) {
						getServicio().getProfesionalService().guardarEmpleo(exp);
					}
				}
			}
			
			getServicio().getProfesionalService().guardarEmpleo(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	public void validar() {
		ExperienciaLaboral bean = (ExperienciaLaboral) getBean();

		boolean nombreAsignado = false;
		boolean idAsignado = false;

		nombreAsignado = bean.getDescripcionCargo() != null
				&& !bean.getDescripcionCargo().equals("");
		idAsignado = bean.getCargo() != null
				&& !bean.getCargo().trim().equals("");

		// Obligatorio, nombre no vacio
		if (((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar el puesto"));
		}

		nombreAsignado = bean.getEmpresa() != null
				&& bean.getEmpresa().getNombreComercial() != null
				&& !bean.getEmpresa().getNombreComercial().equals("");
		idAsignado = bean.getEmpresa() != null
				&& bean.getEmpresa().getId() != null
				&& !bean.getEmpresa().getId().equals(0L);

		// Obligatorio, nombre no vacio
		if (((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar la empresa"));
		}

		nombreAsignado = bean.getArea() != null
				&& bean.getArea().getDescripcion() != null
				&& !bean.getArea().getDescripcion().equals("");
		idAsignado = bean.getArea() != null && bean.getArea().getId() != null
				&& !bean.getArea().getId().equals(0L);

		if (!nombreAsignado
				|| ((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
			if (!nombreAsignado) {
				bean.setArea(null);
			}
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar el área"));
		}

		nombreAsignado = bean.getDescripcionOcupacion() != null
				&& !bean.getDescripcionOcupacion().equals("");
		idAsignado = bean.getIdOcupacion() != null
				&& !bean.getIdOcupacion().equals("");

		if (!nombreAsignado
				|| ((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
			if (!nombreAsignado) {
				bean.setIdOcupacion(null);
			}
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar una Ocupación"));
		}

		nombreAsignado = bean.getDescripcionSector() != null
				&& !bean.getDescripcionSector().equals("");
		idAsignado = bean.getIdSector() != null
				&& !bean.getIdSector().equals(0L);

		if (!nombreAsignado
				|| ((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
			if (!nombreAsignado) {
				bean.setIdSector(null);
			}
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar el sector"));
		}

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
	 * Gets the empleos.
	 * 
	 * @return the empleos
	 */
	public List<ExperienciaLaboral> getEmpleos() {
		List<ExperienciaLaboral> lista = getServicio().getProfesionalService()
				.obtenerEmpleos(profesionalBean);
		return lista;
	}

}
