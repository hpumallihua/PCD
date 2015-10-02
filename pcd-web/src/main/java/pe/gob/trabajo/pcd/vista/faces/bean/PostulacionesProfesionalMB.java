package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarEmpleosMB.
 */
public class PostulacionesProfesionalMB extends GenericManagedBean {

	/** The profesional bean. */
	private Profesional profesionalBean;

	/**
	 * Instantiates a new registrar empleos mb.
	 */
	public PostulacionesProfesionalMB() {
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		
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
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
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
	 * Gets the Postulaciones.
	 * 
	 * @return the Postulaciones
	 */
	public List<Postulacion> getPostulaciones() {
		List<Postulacion> lista = getServicio().getProfesionalService().obtenerPostulaciones(profesionalBean);
		return lista;
	}

}
