package pe.gob.trabajo.pcd.modelo.dao;

import java.util.Collection;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;


// TODO: Auto-generated Javadoc
/**
 * Interface EmpresaDAO.
 */
public interface EmpresaDAO extends GenericDao<Empresa, Long> {
	
	/**
	 * Buscar por ruc.
	 *
	 * @param ruc 
	 * @return objecto empresa
	 */
	public Empresa buscarPorRuc(String ruc);
	
	/**
	 * Buscar por nombre comercial.
	 *
	 * @param empresaNombre nombre de la empresa
	 * @return lista de empresa
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
	 * Buscar empresas por rango de fechas.
	 *
	 * @param fechaInicio, fechaFin 
	 * @return the list
	 */
	public List<Empresa> buscarPorRangoFecha(String fechaInicio, String fechaFin);
	
	/**
	 * Buscar empresas por been busqueda.
	 *
	 * @param busquedaBean the BusquedaBean
	 * @return the list
	 */
	public List<Empresa> buscarEmpresas(BusquedaBean busquedaBean);
}
