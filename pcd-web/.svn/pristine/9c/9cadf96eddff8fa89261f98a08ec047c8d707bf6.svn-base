package pe.gob.trabajo.pcd.servicio.comun;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import pe.gob.trabajo.pcd.modelo.dao.PedidoDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;

// TODO: Auto-generated Javadoc
/**
 * The Interface PedidoService.
 */
public interface PedidoService extends GenericService<Pedido> {
	
	/**
	 * Gets the pedido dao.
	 *
	 * @return the pedido dao
	 */
	public PedidoDAO getPedidoDAO();
	
	/**
	 * Buscar por ruc.
	 *
	 * @param ruc the ruc
	 * @return object empresa
	 */
	public Empresa buscarPorRuc(String ruc);
	
	/**
	 * Buscar por nombre comercial.
	 *
	 * @param empresaNombre the empresa nombre
	 * @return lista de empresa por nombre comercial
	 */
	public List<Empresa> buscarPorNombreComercial(String empresaNombre);
	
	/**
	 * Guardar collection.
	 *
	 * @param coleccion de establecimientos
	 */
	public void guardarCollection(Collection<Establecimiento> col);
	
	/**
	 * Guardar establecimiento.
	 *
	 * @param establecimiento the establecimiento
	 * @return objeto establecimiento
	 */
	public Establecimiento guardarEstablecimiento(Establecimiento establecimiento);
	
	/**
	 * Buscar establecimiento por empresa.
	 *
	 * @param empresa the empresa
	 * @return lista de establecimientos por empresa
	 */
	public List<Establecimiento> buscarEstablecimientoPorEmpresa(Empresa empresa);
	
	/**
	 * Guardar pedido.
	 *
	 * @param pedido the pedido
	 * @return objeto pedido
	 */
	public Pedido guardarPedido(Pedido pedido);
	
	/**
	 * Buscar empleador por establecimiento.
	 *
	 * @param establecimiento the establecimiento
	 * @return lista de empleados por establecimientos
	 */
	public List<Empleador> buscarEmpleadorPorEstablecimiento(Establecimiento establecimiento);
	
	/**
	 * Listar pedido.
	 *
	 * @return list pedidos
	 */
	public List<Pedido> getAllPedidos();
	
	
	/**
	 * Listar pedido.
	 *
	 * @param  descripcioncion
	 * @return list pedidos
	 */
	public List<Pedido> buscarPedidos(String descripcion, 
			  Date fecIni, 
			  Date fecFin, 
			  String cargo,
			  String profesion,
			  String estudio);
	
	
	/**
	 * Listar pedido.
	 *
	 * @param  BusquedaBean
	 * @return list pedidos
	 */
	public List<Pedido> buscarPedidos(BusquedaBean busquedaBean);
	
	/** (non-Javadoc)
	 * @param pedidoId
	 * @return pedido
	 */
	public Pedido buscarPedido(Long pedidoId);
	
	/**
	 * Guardar postulacion.
	 *
	 * @param postulacion the Postulacion
	 * @return objeto postulacion
	 */
	public Postulacion guardarPostulacion(Postulacion postulacion);
	
	/**
	 * Buscar postulacion.
	 *
	 * @param postulacion the Postulacion
	 * @return objeto Postulacion
	 */
	public Postulacion buscarPostulacion(Postulacion postulacion);
	
	/**
	 * Buscar postulacion por pedido.
	 *
	 * @param postulacion the Postulacion
	 * @return list Postulaciones
	 */
	public List<Postulacion> buscarPostulacionesPorPedido(Pedido pedido);
	
}
