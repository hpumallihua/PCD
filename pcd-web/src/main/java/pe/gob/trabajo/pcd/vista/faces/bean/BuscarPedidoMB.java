package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpresa;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEstablecimiento;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarEmpresaMB.
 */
public class BuscarPedidoMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(BuscarPedidoMB.class);
	
	/** The pedido bean. */
	private Pedido pedidoBean;
	
	private List<Pedido> listaPedidos = new ArrayList<Pedido>();
	private BusquedaBean  busquedaBean;
	
	/**
	 * Instantiates a new registrar pedido mb.
	 */
	public BuscarPedidoMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		
		Pedido bean = (Pedido) getSpringBean("PedidoPrt");
		logger.debug("PedidoPrt: Pedido:" + bean);
		logger.info("PedidoPrt: Pedido:" + bean);
		setPedidoBean(bean);
		
		
		BusquedaBean bb = new BusquedaBean();
		setBusquedaBean(bb);
		
		listaPedidos = new ArrayList<Pedido>();
	}
	
	/**
	 * Gets the pedido bean.
	 *
	 * @return the pedido bean
	 */
	public Pedido getPedidoBean() {
		return pedidoBean;
	}

	/**
	 * Sets the pedido bean.
	 *
	 * @param pedidoBean the new pedido bean
	 */
	public void setPedidoBean(Pedido pedidoBean) {
		this.pedidoBean = pedidoBean;
	}
	
	/**
	 * Seleccionar.
	 *
	 * @param e the e
	 */
	public void seleccionar(ActionEvent e) {
		pedidoBean = (Pedido) getRowParameter(e, "PedidoPrt");

	}
	
	/**
	 * Metodo que prepara el bean empresa para modificar
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void modificar(ActionEvent e) {
		
		Pedido bean = pedidoBean;
		logger.debug("Modificar: Pedido:" + bean);
		setPedidoBean(bean);
		
	}

	/**
	 * Metodo que busca pedido
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarPedido(ActionEvent e) {
		logger.info("Validando datos de la busqueda... ");
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.info("Nombre:      --"+busquedaBean.getPedido().getNombre()+"--");
		logger.info("Fecha Ini:   --"+busquedaBean.getFechaRegistroIni()+"--");
		logger.info("Fecha Fin:   --"+busquedaBean.getFechaRegistroFin()+"--");
		
		if (busquedaBean.getFechaRegistroIni() != null && busquedaBean.getFechaRegistroFin() == null) {
			busquedaBean.setFechaRegistroFin(new Date());
		}
		if (busquedaBean.getFechaRegistroIni()!=null && busquedaBean.getFechaRegistroFin()!=null) {
			if (busquedaBean.getFechaRegistroIni().compareTo(busquedaBean.getFechaRegistroFin()) > 0  ) {
				throw new ValidatorException( agregarMensajeErrorTransaccion("La fecha inicial no debe ser mayor a la fecha final"));
			}
		}
		if (pedidoBean!=null && getUsuarioSesion().isRolAdministrador()) {
			logger.info("id pedido="+pedidoBean.getId());
			busquedaBean.setPedido(pedidoBean);
		}
		listaPedidos = (ArrayList<Pedido>) getServicio().getPedidoService().buscarPedidos(busquedaBean);
	}
	
	/**
	 * Gets the pedidos.
	 *
	 * @return the pedidos
	 */
	public List<Pedido> getListaPedidos(){
		return listaPedidos;
	}
	
	/**
	 * Limpiar busqueda.
	 *
	 * @param e the e
	 */
	public void limpiarBusqueda(ActionEvent e) {
		init();
	}
	

	public BusquedaBean getBusquedaBean() {
		return busquedaBean;
	}

	public void setBusquedaBean(BusquedaBean busquedaBean) {
		this.busquedaBean = busquedaBean;
	}
	

	
}
