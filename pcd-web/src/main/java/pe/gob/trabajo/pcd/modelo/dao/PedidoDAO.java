package pe.gob.trabajo.pcd.modelo.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;


// TODO: Auto-generated Javadoc
/**
 * The Interface PedidoDAO.
 */
public interface PedidoDAO extends GenericDao<Pedido, Long> {
	
	/**
	 * Buscar por ruc.
	 *
	 * @param ruc de la empresa
	 * @return objeto empresa
	 */
	public Empresa buscarPorRuc(String ruc);
	
	/**
	 * Buscar por nombre comercial.
	 *
	 * @param empresaNombre the empresa nombre
	 * @return the list
	 */
	public List<Empresa> buscarPorNombreComercial(String empresaNombre);
	
	/**
	 * Buscar establecimiento por empresa.
	 *
	 * @param empresa the empresa
	 * @return the list
	 */
	public List<Establecimiento> buscarEstablecimientoPorEmpresa(Empresa empresa);
	
	/**
	 * Buscar empleador por establecimiento.
	 *
	 * @param establecimiento the establecimiento
	 * @return the list
	 */
	public List<Empleador> buscarEmpleadorPorEstablecimiento(Establecimiento establecimiento);
	
	/**
	 * Buscar pedidos por descripcion.
	 *
	 * @param string the description
	 * @return the list
	 */
	public List<Pedido> buscarPedidos(String descripcion, 
			  Date fecIni, 
			  Date fecFin, 
			  String cargo,
			  String profesion,
			  String estudio);
	
	/**
	 * Buscar pedidos por bean pedido.
	 *
	 * @param busquedaBean the BusquedaBean
	 * @return the list
	 */
	public List<Pedido> buscarPedidos(BusquedaBean busquedaBean);
	
	/**
	 * Buscar postulacion por bean postulacion.
	 *
	 * @param postulacion the Postulacion
	 * @return the Postulacion
	 */
	public Postulacion buscarPostulacion(Postulacion postulacion);
	
	/**
	 * Buscar postulacion por bean postulacion.
	 *
	 * @param postulacion the Postulacion
	 * @return the list
	 */
	public List<Postulacion> buscarPostulacionesPorPedido(Pedido pedido);
}
