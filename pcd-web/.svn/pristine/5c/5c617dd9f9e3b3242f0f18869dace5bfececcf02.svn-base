package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaIntegranteFamilia;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarCertificacionMB.
 */
public class RegistrarPersonaComposicionFamiliarMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarPersonaComposicionFamiliarMB.class);
	
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
		PersonaIntegranteFamilia bean = (PersonaIntegranteFamilia) getBean();
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
		PersonaIntegranteFamilia bean = new PersonaIntegranteFamilia();
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
		PersonaIntegranteFamilia bean = (PersonaIntegranteFamilia) getRowParameter(e,
				"integranteFamiliaPrm");
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
		PersonaIntegranteFamilia bean = (PersonaIntegranteFamilia) getRowParameter(e,
				"integranteFamiliaPrm");

		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("El integrante de la familia ha sido eliminado");

	}

	/**
	 * Gets the NecesidadesApoyo.
	 *
	 * @return the NecesidadesApoyo
	 */
	public List<PersonaIntegranteFamilia> getIntegrantesFamilia() {
		return (List<PersonaIntegranteFamilia>) getServicio().getPersonaService().obtenerIntegrantesFamilia(personaBean);

	}

}
