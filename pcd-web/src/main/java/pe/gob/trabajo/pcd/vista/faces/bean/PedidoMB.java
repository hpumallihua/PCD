package pe.gob.trabajo.pcd.vista.faces.bean;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfesionalMB.
 */
public class PedidoMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(PedidoMB.class);

	/** The pedido bean. */
	private Pedido pedidoBean;
	

	/**
	 * Instantiates a new profesional mb.
	 */
	public PedidoMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Pedido bean = (Pedido) getSpringBean("PedidoPrt");
		Empresa empleador = new Empresa();
		bean.setEmpleador(empleador);
		setPedidoBean(bean);
	}

	/**
	 * Nuevo.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
	}

	
	public Pedido getPedido(){
		if (getUsuarioSesion().isRolAdministrador()) {
			if (pedidoBean != null && 
				pedidoBean.getId() != null &&
				pedidoBean.getId().compareTo(0L) == 1			
			) {				
				pedidoBean = (Pedido)getServicio().getPedidoService().buscarPedido(pedidoBean.getId());			
			} else { //if(pedidoBean == null){	
				init();
//				pedidoBean = new Pedido(); //.getPedido();
//				Empresa empleador = new Empresa();
//				pedidoBean.setEmpleador(empleador);
			}
		}
		return pedidoBean;		
	}
	
	/**
	 * Seleccionar.
	 *
	 * @param ActionEvent que ocurre cuando el usuario realiza una acción
	 */
	public void seleccionar(ActionEvent e) {
		pedidoBean = (Pedido)getRowParameter(e, "pedidoPrm");
		logger.debug("Seleccionando Pedido" + pedidoBean);
	}

	public Pedido getPedidoBean() {
		return pedidoBean;
	}

	public void setPedidoBean(Pedido pedidoBean) {
		this.pedidoBean = pedidoBean;
	}
}
