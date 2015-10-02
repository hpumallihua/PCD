package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministrarEspecialidadMB.
 */
public class AdministrarEspecialidadMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AdministrarEspecialidadMB.class);

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init(){
		setBean(new EspecialidadProfesional());
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}
	
	/**
	 * Inits the.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void init(ActionEvent e){
		init();
	}
	
	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		EspecialidadProfesional bean = (EspecialidadProfesional) getBean();
		validar();

		getServicio().getMaestroService().saveObject(bean);
		setBean(bean);
		if (bean != null && bean.getId() != null) {
			agregarMensajeExitoTransaccion("Dato guardado con éxito");
		} else {
			agregarMensajeErrorTransaccion("Error");
		}
		setAccionRealizada(Constantes.ACCION_LISTAR);

		UtilBean.initNullObject(bean);

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
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo encargado de actualizar un registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
		EspecialidadProfesional bean = (EspecialidadProfesional) getRowParameter(e,"especialidadPrm");
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
		EspecialidadProfesional bean = (EspecialidadProfesional) getRowParameter(e,"especialidadPrm");

		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La especialidad ha sido eliminada");

	}

	/**
	 * Lista de especialidades.
	 *
	 * @return List<EspecialidadProfesional> lista contiene el resultado de la consulta 
	 */
	public List<EspecialidadProfesional> getEspecialidades() {
		List<EspecialidadProfesional> lista = (List<EspecialidadProfesional>) getServicio()
		.getMaestroService()
		.getAllObject(EspecialidadProfesional.class);
		return lista;
	}
}
