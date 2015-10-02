package pe.gob.trabajo.pcd.vista.faces.bean;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfesionalMB.
 */
public class EmpresaMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(EmpresaMB.class);

	/** The empresa bean. */
	private Empresa empresaBean;
	

	/**
	 * Instantiates a new profesional mb.
	 */
	public EmpresaMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Empresa bean = (Empresa) getSpringBean("EmpresaPrt");
		setEmpresaBean(bean);
	}

	/**
	 * Nuevo.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresaBean = empresaBean;
	}

	public Empresa getEmpresaBean() {
		return empresaBean;
	}
	
	public Empresa getEmpresa(){
		if (getUsuarioSesion().isRolEmpleador()) {
			if (getUsuarioSesion().getEmpresa() != null && 
				getUsuarioSesion().getEmpresa().getId() != null &&
				getUsuarioSesion().getEmpresa().getId().compareTo(0L) == 1			
			) {				
				empresaBean = getServicio().getEmpresaService().buscarPorRuc(getUsuarioSesion().getEmpresa().getRuc());			
			} else {
				init();
				empresaBean = getUsuarioSesion().getEmpresa();
			}
		}
		return empresaBean;		
	}
	
	/**
	 * Seleccionar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionar(ActionEvent e) {
		empresaBean = (Empresa)getRowParameter(e, "empresaPrm");
		logger.debug("Seleccionando Pedido" + empresaBean);
	}
}
