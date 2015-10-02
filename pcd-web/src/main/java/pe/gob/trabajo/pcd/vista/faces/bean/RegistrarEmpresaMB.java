package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.Date;
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
public class RegistrarEmpresaMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarEmpresaMB.class);
	
	/** The empresa bean. */
	private Empresa empresaBean;
	
	/** The opcion menu. */
	private int opcionMenu;
	
	/** The opcion empresa. */
	private int opcionEmpresa;
	
	/**
	 * Instantiates a new registrar empresa mb.
	 */
	public RegistrarEmpresaMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		
		Empresa bean = (Empresa) getSpringBean("EmpresaPrt");
		logger.debug("EmpresaPrt: Empresa:" + bean+ " date: "+new Date());
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
		if (getUsuarioSesion().isRolAdministrador() && empresaBean==null) {
			empresaBean = new Empresa();
		}
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
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {
		logger.debug("Guardando empresa... ");
		Empresa bean = empresaBean; 
//		bean.setEstablecimiento(null);
		validar();

		try {
			Empresa empresaGuardada = (Empresa) getServicio().getEmpresaService().save(bean);
			if (empresaGuardada != null && empresaGuardada.getId() !=null && empresaGuardada.getId().compareTo(0L) == 1) {

				setEmpresaBean(empresaGuardada);
				agregarMensajeExitoTransaccion("Datos del empleador guardados correctamente");
				logger.debug("Guardado empresa : " + bean.getId());
				
			} else {
				agregarMensajeErrorTransaccion("Ya existe una empresa registrada con los mismos datos");
			}
		} catch (Exception e1) {
			logger.error(e1.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
		
	}
	
	/**
	 * Metodo que prepara el bean empresa para modificar
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void modificar(ActionEvent e) {
		
		Empresa bean = (Empresa)getRowParameter(e, "empresaPrm");
		logger.debug("Modificar: Empresa:" + bean);
		if (bean != null) {
			if (bean instanceof Empresa) {
				setEmpresaBean(bean);
			}
		}	
		
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios..
	 */
	private void validar() {
		logger.debug("Validando empresa... ");
		Empresa bean = (Empresa) empresaBean;
		logger.debug(bean.getRuc());
		if (bean.getId() != null && (bean.getId().equals(0L))) {
			bean.setId(null);
		}
		if (bean.getRuc() == null || bean.getRuc().equals("")) {
			throw new ValidatorException( agregarMensajeErrorTransaccion("Debe ingresar el numero de ruc"));
		}
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
				init();
				Empresa emp = getServicio().getMaestroService().buscarEmpresa(ruc);
				setEmpresaBean(emp);


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
	 * Limpiar busqueda.
	 *
	 * @param e the e
	 */
	public void limpiarBusqueda(ActionEvent e) {
		init();
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
	 * Gets the items tipo empresa.
	 *
	 * @return the items tipo empresa
	 */
	public List<?> getItemsTipoEmpresa(){
		List<TipoEmpresa> lista = (List<TipoEmpresa>)getServicio().getMaestroService().getAllObject(TipoEmpresa.class);
		return Items.getItems(lista, "descripcion", "id");		
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
	

	public void guardarUsuario(ActionEvent e) {
		if (empresaBean.getId() != null && empresaBean.getId().compareTo(0L) == 0) {
			guardar(e);
		}
		
		try {
			Usuario usuario = getUsuarioSesion().getEmpresa().getUsuario();
			if (usuario == null || usuario.getId() == null || usuario.getId().compareTo(0L) == 0) {
				usuario = new Usuario();
			}
			String nombreUsuario = getUsuarioSesion().getEmpresa().getUsuario().getNombreUsuario();
			String clave = getUsuarioSesion().getEmpresa().getUsuario().getClaveUsuario();
			usuario.setEmpresa(empresaBean);
			usuario.setRol(Constantes.ROL_EMPLEADOR);
			usuario.setNombreUsuario(nombreUsuario);
			if (!"".equals(clave)) {
				usuario.setClaveUsuario(clave);
				getServicio().getEmpresaService().saveObject(usuario);
				empresaBean.setUsuario(usuario);
				getUsuarioSesion().getEmpresa().setUsuario(usuario);
				agregarMensajeExitoTransaccion("Usuario guardado correctamente");
			} else {
				agregarMensajeErrorTransaccion("No se guardaron datos");
			}
			logger.info(usuario.getClaveUsuario());
			
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		}
	}
	
}
