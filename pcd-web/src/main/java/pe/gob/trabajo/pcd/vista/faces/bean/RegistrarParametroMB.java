package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Configuracion;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarParametroMB.
 */
public class RegistrarParametroMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarParametroMB.class);
	
	/** The parametro. */
	String parametro;
	
	/** The titulo lista. */
	String tituloLista;
	
	/** The titulo formulario. */
	String tituloFormulario;
	
	/**
	 * Constructor.
	 */
	public RegistrarParametroMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		super.init();
		setBean(new Configuracion());
	}
	
	/**
	 * Inits the.
	 *
	 * @param e the e
	 */
	public void init(ActionEvent e) {
		init();
	}
	
	/**
	 * Gets the parametro.
	 *
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}

	/**
	 * Sets the parametro.
	 *
	 * @param parametro the new parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	/**
	 * Gets the titulo lista.
	 *
	 * @return the titulo lista
	 */
	public String getTituloLista() {
		return tituloLista;
	}

	/**
	 * Sets the titulo lista.
	 *
	 * @param tituloLista the new titulo lista
	 */
	public void setTituloLista(String tituloLista) {
		this.tituloLista = tituloLista;
	}

	/**
	 * Gets the titulo formulario.
	 *
	 * @return the titulo formulario
	 */
	public String getTituloFormulario() {
		return tituloFormulario;
	}

	/**
	 * Sets the titulo formulario.
	 *
	 * @param tituloFormulario the new titulo formulario
	 */
	public void setTituloFormulario(String tituloFormulario) {
		this.tituloFormulario = tituloFormulario;
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		Object bean = new Object();
		try {
			bean = Class.forName("pe.gob.trabajo.pcd.modelo.dominio." + parametro).newInstance();
		} catch (InstantiationException e1) {
			logger.error(e1.getStackTrace());
		} catch (IllegalAccessException e1) {
			logger.error(e1.getStackTrace());
		} catch (ClassNotFoundException e1) {
			logger.error(e1.getStackTrace());
		}
//		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}
	
	/**
	 * Metodo recibe un objeto Configuracion y actualiza los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void editar(ActionEvent e) {
		Configuracion bean = (Configuracion) getRowParameter(e, "configuracionPrm");
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
		UtilBean.initNullObject(bean);
	}
	
	/**
	 * Metodo que elimina un registro de la base de datos. 
	 *
	 * @param e the e
	 */
	public void eliminar(ActionEvent e) {
		Configuracion bean = (Configuracion) getRowParameter(e, "configuracionPrm");
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
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {
		Configuracion bean = (Configuracion) getBean();
//		logger.info(bean);
		try {
			validar();
			getServicio().getMaestroService().saveObject(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			UtilBean.actualizarParametros();
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
//		Configuracion bean = (Configuracion) getBean();
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
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public List<Configuracion> getParametros() {
		List<Configuracion> lista = null;
		try {
			lista = (List<Configuracion>) getServicio().getMaestroService().getAllObject(Class.forName("pe.gob.trabajo.pcd.modelo.dominio." + parametro));
		} catch (ClassNotFoundException e) {
			logger.error(e.getStackTrace());
		}
		return lista;
	}
	
}
