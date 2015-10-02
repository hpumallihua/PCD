package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaNecesidadApoyo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarCertificacionMB.
 */
public class RegistrarPersonaNecesidadesApoyoMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarPersonaNecesidadesApoyoMB.class);
	
	/** The profesional bean. */
	private Profesional profesionalBean;
	
	private Persona personaBean;
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
	 * @return the personaBean
	 */
	public Persona getPersonaBean() {
		return personaBean;
	}

	/**
	 * @param personaBean the personaBean to set
	 */
	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	/**
	 * Seleccionar profesional.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {		
		profesionalBean = getProfesionalSesionMB();
		this.personaBean = profesionalBean.getPersona();
		
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		PersonaNecesidadApoyo bean = (PersonaNecesidadApoyo) getBean();
		try {
			validar();
			
			getServicio().getMaestroService().saveObject(bean);
			setBean(bean);
			if (bean != null && bean.getId() != null ) {
				agregarMensajeExitoTransaccion("Dato guardado con éxito");
			} else {
				agregarMensajeErrorTransaccion("Error");
			}
			setAccionRealizada(Constantes.ACCION_LISTAR);
		} catch (Exception e2) {
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		}
	}

	/**
	 * Metodo encargado de validar los campos obligatorios.
	 */
	public void validar() {
		
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
		PersonaNecesidadApoyo bean = new PersonaNecesidadApoyo();
		bean.setPersona(personaBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo encargado de actualizar un registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		PersonaNecesidadApoyo bean = (PersonaNecesidadApoyo) getRowParameter(e,
				"necesidadApoyoPrm");
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
		PersonaNecesidadApoyo bean = (PersonaNecesidadApoyo) getRowParameter(e,
				"necesidadApoyoPrm");

		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La Necesidad de Apoyo ha sido eliminada");

	}

	/**
	 * Gets the NecesidadesApoyo.
	 *
	 * @return the NecesidadesApoyo
	 */
	public List<PersonaNecesidadApoyo> getNecesidadesApoyo() {
		return (List<PersonaNecesidadApoyo>) getServicio().getPersonaService().obtenerNecesidadesApoyo(personaBean);

	}

}
