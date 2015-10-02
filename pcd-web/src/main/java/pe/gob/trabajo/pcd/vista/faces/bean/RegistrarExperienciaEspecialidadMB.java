package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarExperienciaEspecialidadMB.
 */
public class RegistrarExperienciaEspecialidadMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarExperienciaEspecialidadMB.class);
	
	/** The unidad tiempo. */
	private Integer unidadTiempo;
	
	/**
	 * Gets the unidad tiempo.
	 *
	 * @return the unidad tiempo
	 */
	public Integer getUnidadTiempo() {
		return unidadTiempo;
	}

	/**
	 * Sets the unidad tiempo.
	 *
	 * @param unidadTiempo the new unidad tiempo
	 */
	public void setUnidadTiempo(Integer unidadTiempo) {
		this.unidadTiempo = unidadTiempo;
	}

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
	 * @param e the e
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 *
	 * @param e the e
	 */
	public void validarDato(ActionEvent e) {
		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {
		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getBean();
		try {
			validar();
			
			if (bean.getPrincipal() != null && bean.getPrincipal().compareTo(Constantes.EMPLEO_PRINCIPAL) == 0) {
				Profesional p = new Profesional();
				p.setId(bean.getProfesional().getId());
				List<ExperienciaEspecialidad> lista = getServicio().getProfesionalService().obtenerExperienciaEspecialidad(p);
				for (ExperienciaEspecialidad exp : lista) {
					exp.setPrincipal(Constantes.EMPLEO_SECUNDARIO);
					if (bean.getId() == null || (bean.getId() != null && exp.getId().compareTo(bean.getId()) != 0)) {
						getServicio().getProfesionalService().guardarExperienciaEspecialidad(exp);
					}
				}
			}
			
			bean = getServicio().getProfesionalService()
					.guardarExperienciaEspecialidad(bean);
			setBean(bean);
			if (bean != null && bean.getId() != null) {
				agregarMensajeExitoTransaccion("Dato guardado con éxito");
			} else {
				agregarMensajeErrorTransaccion("Error");
			}
			setAccionRealizada(Constantes.ACCION_LISTAR);
			unidadTiempo = 1;
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
//			UtilBean.initNullObject(bean);
		}
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	private void validar(){
		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getBean();
		
		boolean nombreAsignado = false;
		boolean idAsignado = false;
		
		nombreAsignado = bean.getDescripcionOcupacion() != null && !bean.getDescripcionOcupacion().equals("");
		idAsignado = bean.getIdOcupacion()!=null && !bean.getIdOcupacion().equals("");
		
		//Obligatorio, nombre no vacio
		if (((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
		} else {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar la ocupación"));
		}
		
		if (unidadTiempo != null) {
			bean.setMeses(bean.getMeses()*unidadTiempo);			
		}
	}

	/**
	 * Cancelar.
	 *
	 * @param e the e
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		init();

		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getSpringBean("ExperienciaEspecialidadPrt");
		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto Referencia y actualiza los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void editar(ActionEvent e) {
		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getRowParameter(
				e, "experienciaPrm");
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
	}

	/**
	 * Metodo que elimina un registro de la base de datos.
	 *
	 * @param e the e
	 */
	public void eliminar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("eliminar... ");
		ExperienciaEspecialidad bean = (ExperienciaEspecialidad) getRowParameter(
				e, "experienciaPrm");
		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La experiencia ha sido eliminada");

	}

	/**
	 * Gets the experiencia especialidad.
	 *
	 * @return the experiencia especialidad
	 */
	public List<ExperienciaEspecialidad> getExperienciaEspecialidad() {
		return (List<ExperienciaEspecialidad>) getServicio()
				.getProfesionalService().obtenerExperienciaEspecialidad(
						getProfesionalBean());
	}

	/**
	 * Gets the items especialidad profesional.
	 *
	 * @return the items especialidad profesional
	 */
	public List<?> getItemsEspecialidadProfesional() {
		List<EspecialidadProfesional> lista = (List<EspecialidadProfesional>) getServicio()
				.getMaestroService()
				.getAllObject(EspecialidadProfesional.class);

		return Items.getItems(lista, "descripcion", "id");
	}

}
