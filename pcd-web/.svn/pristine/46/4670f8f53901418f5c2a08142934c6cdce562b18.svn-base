package pe.gob.trabajo.pcd.servicio.comun;

import java.util.Collection;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmpresaService.
 */
public interface EmpresaService extends GenericService<Empresa> {
	
	/**
	 * Gets the empresa dao.
	 *
	 * @return the empresa dao
	 */
	public EmpresaDAO getEmpresaDAO();
	
	
	/**
	 * Gets the maestro dao.
	 *
	 * @return the maestro dao
	 */
	public ProveedorMaestroDAO getProveedorMaestroDAO();
	
	/**
	 * Buscar por ruc.
	 *
	 * @param ruc empresa
	 * @return objecto empresa
	 */
	public Empresa buscarPorRuc(String ruc);
	
	/**
	 * Buscar por nombre comercial.
	 *
	 * @param empresaNombre the empresa nombre
	 * @return lista de empresas por nombre comercial
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
	 * @return lista establecimientos
	 */
	public List<Establecimiento> buscarEstablecimientoPorEmpresa(Empresa empresa);
	
	/**
	 * Guardar Empleador.
	 *
	 * @param empleador the empleador
	 */
	public void guardarEmpleador(Empleador empleador);
	
	
	public List<Empresa> buscarPorRangoFecha(String fechaInicio, String fechaFin);
	
	public List<Empresa> buscarEmpresas(BusquedaBean busquedaBean);
}
