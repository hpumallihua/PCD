package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpresa;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEstablecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarEmpresaMB.
 */
public class RegistrarEstablecimientoMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarEstablecimientoMB.class);
	
	/** The empresa bean. */
	private Empresa empresaBean;
	
	/** The establecimiento bean. */
	private Establecimiento establecimientoBean;
	
	/** The empleador bean. */
	private Empleador empleadorBean;
	
	/** The opcion menu. */
	private int opcionMenu;
	
	/** The opcion empresa. */
	private int opcionEmpresa;
	
	/**
	 * Instantiates a new registrar empresa mb.
	 */
	public RegistrarEstablecimientoMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		
		Empresa bean = (Empresa) getSpringBean("EmpresaPrt");
		logger.debug("EmpresaPrt: Empresa:" + bean);
		setEmpresaBean(bean);
		
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
	 * Gets the opcion empresa.
	 *
	 * @return the opcion empresa
	 */
	public int getOpcionEmpresa() {
		return opcionEmpresa;
	}

	/**
	 * Sets the opcion empresa.
	 *
	 * @param opcionEmpresa the new opcion empresa
	 */
	public void setOpcionEmpresa(int opcionEmpresa) {
		this.opcionEmpresa = opcionEmpresa;
	}

	/**
	 * Gets the empresa bean.
	 *
	 * @return the empresa bean
	 */
	public Empresa getEmpresaBean() {
		return empresaBean;
	}

	/**
	 * Sets the empresa bean.
	 *
	 * @param empresaBean the new empresa bean
	 */
	public void setEmpresaBean(Empresa empresaBean) {
		this.empresaBean = empresaBean;
	}
	
	/**
	 * Gets the establecimiento bean.
	 *
	 * @return the establecimiento bean
	 */
	public Establecimiento getEstablecimientoBean() {
		return establecimientoBean;
	}

	/**
	 * Sets the establecimiento bean.
	 *
	 * @param establecimientoBean the new establecimiento bean
	 */
	public void setEstablecimientoBean(Establecimiento establecimientoBean) {
		this.establecimientoBean = establecimientoBean;
	}
	
	/**
	 * Seleccionar.
	 *
	 * @param e the e
	 */
	public void seleccionar(ActionEvent e) {
		empresaBean = (Empresa) getRowParameter(e, "EmpresaPrt");
		opcionEmpresa = 1;
//		logger.debug(EmpresaBean);
	}
	
	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		init();
	}
	
	
	/**
	 * Metodo que busca empresa por RUC
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarEmpresa(ActionEvent e) {
		logger.debug("Validando empresa... ");
		Empresa empresa 	= empresaBean;
		String 	ruc 		= empresa.getRuc();
		logger.debug("Ruc: 				--"+ruc+"--");		
		if (empresa != null && ruc!= null && !ruc.equals("") && ruc.length() == 11) {
			Empresa empresaencontrada = (Empresa) getServicio().getEmpresaService().buscarPorRuc(ruc);
			if (empresaencontrada!=null && empresaencontrada.getId() !=null && empresaencontrada.getId().compareTo(0L) == 1) {
				setEmpresaBean(empresaencontrada);				
			} else {
				//agregarMensajeErrorTransaccion("No se encontraron datos");
				init(); 
			}
		}
		
	}
	
	/**
	 * Metod que Busca empresas por ruc.
	 *
	 * @param e the e
	 */
	public void buscarEmpresas(ActionEvent e) {
		logger.debug("RUC: --" + empresaBean.getRuc());
		logger.debug("RUC: --" + empresaBean.getNombreComercial());
		Empresa empresa = null;
		if (empresaBean != null || empresaBean.getRuc()!= null || !empresaBean.getRuc().equals("")) {
			empresa = (Empresa) getServicio().getEmpresaService().buscarPorRuc(empresaBean.getRuc());
			empresaBean = empresa;
		} else if (empresaBean != null || empresaBean.getNombreComercial()!= null || !empresaBean.getNombreComercial().equals("")) {
			empresa = (Empresa) getServicio().getEmpresaService().buscarPorNombreComercial(empresaBean.getNombreComercial());
			empresaBean = empresa;
		} else {
			agregarMensajeErrorTransaccion("No se encontraron datos");
		}			
	}

	
	/**
	 * Gets the empresas.
	 *
	 * @return the empresas
	 */
	public List<Empresa> getEmpresas(){
		
		return null;
	}
	
	
	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		if (getUsuarioSesion().isRolAdministrador()) {
			empresaBean = null; //getServicio().getMaestroService().obtenerEmpresa(getUsuarioSesion().getPersona());			
		}
		return empresaBean;
	}
	

	
	/**
	 * Gets the items tipo establecimiento.
	 *
	 * @return the items tipo establecimiento
	 */
	public List<?> getItemsTipoEstablecimiento(){
		List<TipoEstablecimiento> lista = (List<TipoEstablecimiento>)getServicio().getMaestroService().getAllObject(TipoEstablecimiento.class);
		return Items.getItems(lista, "descripcion", "id");
	}
	
	/**
	 * Gets the items ciiu.
	 *
	 * @return the items ciiu
	 */
	public List<?> getItemsCiiu(){
		List<Ciiu> lista = (List<Ciiu>)getServicio().getMaestroService().getAllObject(Ciiu.class);
		return null; //Items.getItems(lista, "descripcion", "id");		
	}
	
	/**
	 * Gets the list establecimiento.
	 *
	 * @return the list establecimiento
	 */
	public List<?> getListEstablecimiento(){
		List<Establecimiento> lista = new ArrayList<Establecimiento>();
		if (empresaBean.getId()!=null) {
			lista = (List<Establecimiento>)getServicio().getEmpresaService().buscarEstablecimientoPorEmpresa(empresaBean);
		}
		return  lista;		
	}
	
	/**
	 * Menu Listar establecimiento.
	 *
	 * @param e the e
	 */
	public void menuEstablecimiento(ActionEvent e){
		Establecimiento establecimiento = new Establecimiento();
		setEstablecimientoBean(establecimiento);
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}
	
	/**
	 * Nuevo establecimiento.
	 *
	 * @param e the e
	 */
	public void nuevoEstablecimiento(ActionEvent e){
		Establecimiento establecimiento = new Establecimiento();
		setEstablecimientoBean(establecimiento);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}
	
	/**
	 * Metodo recibe un objeto Establecimiento y actualiza los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void editarEstablecimiento(ActionEvent e) {
		Establecimiento bean = (Establecimiento)getRowParameter(e, "establecimientoPrm");
		setAccionRealizada(Constantes.ACCION_EDITAR);
		//UtilBean.initNullObject(getBean());		
		if (bean != null) {
			if (bean instanceof Establecimiento) {
				establecimientoBean = bean;
			}
		}	
		
	}
	
	/**
	 * Metodo que elimina un registro de la base de datos.
	 *
	 * @param e the e
	 */
	public void eliminarEstablecimiento(ActionEvent e) {
		try {
			Establecimiento establecimiento = (Establecimiento)getRowParameter(e, "establecimientoPrm");
			if (establecimiento!=null) {
				List<Empleador> empleadoresEncontrados = (List<Empleador>)getServicio().getPedidoService().buscarEmpleadorPorEstablecimiento(establecimiento);
				if (empleadoresEncontrados!=null && empleadoresEncontrados.size()>0) {
					agregarMensajeErrorTransaccion("No se puede eliminar el establecimiento con rol de Empleador");
				} else {
					getServicio().getEmpresaService().removeObject(getRowParameter(e, "establecimientoPrm"));
					setAccionRealizada(Constantes.ACCION_LISTAR);
					agregarMensajeExitoTransaccion("La operación se realizó correctamente");
				}
				
			}
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo eliminar");
		}
	}
	
	/**
	 * Cancelar establecimiento.
	 *
	 * @param e the e
	 */
	public void cancelarEstablecimiento(ActionEvent e){
		logger.debug("cancelar vista Establecimiento... ");
		Establecimiento establecimiento = new Establecimiento();
		setEstablecimientoBean(establecimiento);
		setAccionRealizada(Constantes.ACCION_LISTAR);		
	}

	
	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardarEstablecimiento(ActionEvent e) {
		logger.debug("Guardando Establecimiento... ");
		Establecimiento bean = establecimientoBean;
		bean.setEmpresa(empresaBean);
		
		try {
			Establecimiento establecimientoGuardado = (Establecimiento) getServicio().getEmpresaService().guardarEstablecimiento(bean);
			if (establecimientoGuardado != null && establecimientoGuardado.getId() !=null && establecimientoGuardado.getId().compareTo(0L) == 1) {
				
				List<Establecimiento> lista = (List<Establecimiento>)getServicio().getEmpresaService().buscarEstablecimientoPorEmpresa(empresaBean);
				if (lista != null && lista.size() <= 1) {
					guardarEmpleador(establecimientoGuardado);
				}
				
				setAccionRealizada(Constantes.ACCION_LISTAR);
				agregarMensajeExitoTransaccion("Datos guardados correctamente");
				logger.debug("Guardado: " + bean.getId());
			} else {
				agregarMensajeErrorTransaccion("Ya existe una establecimiento registrado con los mismos datos");
			}
		} catch (Exception e1) {
			logger.error(e1.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
		

	}
	
	
	/**
	 * Guardar empleador.
	 *
	 * @param establecimiento the establecimiento
	 */
	public void guardarEmpleador(Establecimiento establecimiento){
		
		if (establecimiento != null && establecimiento.getId() != null ) {
			try {
				empleadorBean = new Empleador();
				empleadorBean.setEstablecimiento(establecimiento);
				getServicio().getEmpresaService().guardarEmpleador(empleadorBean);	
				logger.debug("Guardado empleador : " + empleadorBean.getId());
			} catch (Exception e) {
				logger.error(e.getStackTrace());
				logger.debug("Error guardado empleador : "+ e.getMessage());
			}
		}
		
	}

	/**
	 * Gets the empleador bean.
	 *
	 * @return the empleador bean
	 */
	public Empleador getEmpleadorBean() {
		return empleadorBean;
	}

	/**
	 * Sets the empleador bean.
	 *
	 * @param empleadorBean the new empleador bean
	 */
	public void setEmpleadorBean(Empleador empleadorBean) {
		this.empleadorBean = empleadorBean;
	}
	
}
