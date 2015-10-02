package pe.gob.trabajo.pcd.vista.faces.bean;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfesionalMB.
 */
public class ProfesionalMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ProfesionalMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The opcion menu. */
	private int opcionMenu;
	
	/** The opcion profesional. */
	private int opcionProfesional;

	/**
	 * Instantiates a new profesional mb.
	 */
	public ProfesionalMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Profesional bean = (Profesional) getSpringBean("ProfesionalPrt");
		bean.getPersona().setPaisNacimiento(getLocale());
		bean.getPersona().setNacionalidad(getLocale());
		bean.getPersona().setPaisResidencia(getLocale());
		// logger.debug("ProfesionalPrt: Profesional:" + bean);
		setProfesionalBean(bean);
	}

	/**
	 * Gets the opcion menu.
	 *
	 * @return the opcion menu
	 */
	public int getOpcionMenu() {
		return opcionMenu;
	}

	/**
	 * Sets the opcion menu.
	 *
	 * @param opcionMenu the new opcion menu
	 */
	public void setOpcionMenu(int opcionMenu) {
		this.opcionMenu = opcionMenu;
	}

	/**
	 * Gets the opcion profesional.
	 *
	 * @return the opcion profesional
	 */
	public int getOpcionProfesional() {
		return opcionProfesional;
	}

	/**
	 * Sets the opcion profesional.
	 *
	 * @param opcionProfesional the new opcion profesional
	 */
	public void setOpcionProfesional(int opcionProfesional) {
		this.opcionProfesional = opcionProfesional;
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
	 * @param profesionalBean the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Seleccionar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionar(ActionEvent e) {
		profesionalBean = (Profesional) getRowParameter(e, "profesionalPrm");
	}

	/**
	 * Nuevo.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
	}

	/**
	 * Gets the profesional.
	 *
	 * @return the profesional
	 */
	public Profesional getProfesional() {
		if (getUsuarioSesion().isRolProfesional()) {
			if (getUsuarioSesion().getPersona() != null && 
					getUsuarioSesion().getPersona().getId() != null &&
					getUsuarioSesion().getPersona().getId().compareTo(0L) == 1) {
				profesionalBean = getServicio().getProfesionalService()
						.obtenerProfesional(getUsuarioSesion().getPersona());				
			} else {
				init();
				profesionalBean.setPersona(getUsuarioSesion().getPersona());
			}
		}
		return profesionalBean;
	}
}
