package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarIdiomaMB.
 */
public class RegistrarIdiomaMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarIdiomaMB.class);
	
	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The nivel idioma. */
	private NivelIdioma nivelIdioma;

	/**
	 * Gets the nivel idioma.
	 *
	 * @return the nivel idioma
	 */
	public NivelIdioma getNivelIdioma() {
		return nivelIdioma;
	}

	/**
	 * Sets the nivel idioma.
	 *
	 * @param nivelIdioma the new nivel idioma
	 */
	public void setNivelIdioma(NivelIdioma nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
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
	 * Seleccionar profesional.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios..
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		ProfesionalIdioma bean = (ProfesionalIdioma) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
//		logger.info((ProfesionalIdioma) getBean());
		ProfesionalIdioma bean = getServicio().getProfesionalService()
				.guardarIdioma((ProfesionalIdioma) getBean());
		setBean(bean);
		if (bean != null && bean.getId() != null) {
			agregarMensajeExitoTransaccion("Dato guardado con éxito");
		} else {
			agregarMensajeErrorTransaccion("Error");
		}
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
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
//		long id = 3;
		Idioma idioma = new Idioma();
//		Profesional profe3 = new Profesional();
//		profe3.setId(id);
		ProfesionalIdioma bean = new ProfesionalIdioma();
		bean.setProfesional(profesionalBean);
		bean.setIdioma(idioma);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto Referencia y actualiza los cambios en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		ProfesionalIdioma bean = (ProfesionalIdioma) getRowParameter(e,
				"idiomaPrm");
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
		ProfesionalIdioma bean = (ProfesionalIdioma) getRowParameter(e,
				"idiomaPrm");
		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("El idioma ha sido eliminado");

	}

	/**
	 * Gets the idiomas.
	 *
	 * @return the idiomas
	 */
	public List<ProfesionalIdioma> getIdiomas() {
//		logger.info(getProfesionalBean());
		return (List<ProfesionalIdioma>) getServicio().getProfesionalService().obtenerIdiomas(getProfesionalBean());
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#getItemsIdioma()
	 */
	public List<?> getItemsIdioma() {
		List<Idioma> lista = (List<Idioma>) getServicio().getMaestroService()
				.getAllObject(Idioma.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#getItemsNivelIdioma()
	 */
	public List<?> getItemsNivelIdioma() {
		List<NivelIdioma> lista = (List<NivelIdioma>) getServicio()
				.getMaestroService().getAllObject(NivelIdioma.class);
		return Items.getItems(lista, "valor", "id");
	}
}
