package pe.gob.trabajo.pcd.vista.faces.bean;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaEvaluacionPerfil;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaInteresesOcupacionales;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;

/**
 * The Class RegistrarPreferenciasProfesionalesMB.
 */
public class RegistrarEvaluacionPerfilEmpleabilidadMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarEvaluacionPerfilEmpleabilidadMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;

	private Persona personaBean;

	/**
	 * @return the profesionalBean
	 */
	public Profesional getProfesionalBean() {
		return profesionalBean;
	}

	/**
	 * @param profesionalBean
	 *            the profesionalBean to set
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
	 * @param personaBean
	 *            the personaBean to set
	 */
	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	/**
	 * Seleccionar profesional.
	 * 
	 * @param e
	 *            the e
	 */
	public void seleccionarProfesional(ActionEvent e) {
		profesionalBean = getProfesionalSesionMB();
		this.personaBean = profesionalBean.getPersona();
		PersonaEvaluacionPerfil personaEvaluacionPerfil = (PersonaEvaluacionPerfil) getServicio().getPersonaService().findObjectByPK(personaBean.getId(), PersonaEvaluacionPerfil.class);
		if (personaEvaluacionPerfil == null) {
			personaEvaluacionPerfil = new PersonaEvaluacionPerfil();
			personaEvaluacionPerfil.setPersona(personaBean);
		}
		personaBean.setPersonaEvaluacionPerfil(personaEvaluacionPerfil);

		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 * 
	 * @param e
	 *            the e
	 */
	public void guardar(ActionEvent e) {
		validar();
		try {
			getServicio().getPersonaService().saveObject(personaBean.getPersonaEvaluacionPerfil());
			agregarMensajeExitoTransaccion("Dato guardado con éxito");
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("Error");
		} finally {
			setAccionRealizada(Constantes.ACCION_LISTAR);
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	private void validar() {

	}

	/**
	 * Cancelar.
	 * 
	 * @param e
	 *            the e
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 * 
	 * @param e
	 *            the e
	 */
	public void nuevo(ActionEvent e) {
		init();

		PersonaEvaluacionPerfil bean = new PersonaEvaluacionPerfil();
		bean.setPersona(personaBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

}
