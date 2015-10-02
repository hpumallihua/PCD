package pe.gob.trabajo.pcd.servicio.spring.comun;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.servicio.comun.EmpresaService;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaServiceImpl.
 */
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa> implements
		EmpresaService {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(EmpresaServiceImpl.class);
	
	/** The empresa dao. */
	public EmpresaDAO empresaDAO;
	
	/** The proveedor maestro dao. */
	private ProveedorMaestroDAO proveedorMaestroDAO;

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#getEmpresaDAO()
	 */
	public EmpresaDAO getEmpresaDAO() {
		return empresaDAO;
	}

	/**
	 * Sets the empresa dao.
	 *
	 * @param empresaDAO the new empresa dao
	 */
	public void setEmpresaDAO(EmpresaDAO empresaDAO) {
		setDao(empresaDAO);
		this.empresaDAO = empresaDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	@Override
	public EmpresaDAO getDao() {
		return empresaDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#buscarPorRuc(java.lang.String)
	 */
	public Empresa buscarPorRuc(String ruc) {
		Empresa empresa = getDao().buscarPorRuc(ruc);
		if (empresa != null) {
			Hibernate.initialize(empresa.getTipoEmpresa()); 
			if (empresa.getCiiu()!=null) {
				Ciiu ciiu = (Ciiu) getProveedorMaestroDAO().findObjectByPK(empresa.getCiiu(), Ciiu.class);
				empresa.setCiiuDescripcion(ciiu.getDescripcion());
			}
		}
		logger.debug("Empresa encontrada");
		return empresa;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#buscarEstablecimientoPorEmpresa(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
	 */
	public List<Establecimiento> buscarEstablecimientoPorEmpresa(Empresa empresa) {
		List<Establecimiento> retorno = getDao().buscarEstablecimientoPorEmpresa(empresa);
		if (retorno != null) {
//			Hibernate.initialize(retorno.getEmpresa());
			for (Establecimiento establecimiento : retorno) {
				if (establecimiento != null) {
					Hibernate.initialize(establecimiento);
					Hibernate.initialize(establecimiento.getTipoEstablecimiento());
//					Hibernate.initialize(establecimiento.getEmpresa());
				}
			}
		}
		logger.debug("Establecimiento encontrados");
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#buscarPorNombreComercial(java.lang.String)
	 */
	public List<Empresa> buscarPorNombreComercial(String empresaNombre){
		if (empresaNombre == null ) {
			empresaNombre = "";
		}
		return getDao().buscarPorNombreComercial(empresaNombre);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#guardarCollection(java.util.Collection)
	 */
	public void guardarCollection(Collection<Establecimiento> col) {
		for (Establecimiento obj : col) {
			guardarEstablecimiento(obj);
		}
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.EmpresaService#guardarEstablecimiento(pe.gob.trabajo.pcd.modelo.dominio.Establecimiento)
	 */
	public Establecimiento guardarEstablecimiento(Establecimiento establecimiento) {
		getDao().saveObject(establecimiento); 
		return establecimiento;
	}
	
	public void guardarEmpleador(Empleador empleador){
		getDao().saveObject(empleador);
	}

	public List<Empresa> buscarPorRangoFecha(String fechaInicio, String fechaFin){
		return getDao().buscarPorRangoFecha(fechaInicio, fechaFin);
	}
	
	public List<Empresa> buscarEmpresas(BusquedaBean busquedaBean){
		List<Empresa> retorno = getDao().buscarEmpresas(busquedaBean);
		if (retorno != null) {
			for (Empresa empresa : retorno) {
				if (empresa != null) {
					Hibernate.initialize(empresa);
					Hibernate.initialize(empresa.getUsuario());
					if (empresa.getCiiu()!=null) {
						Ciiu ciiu = (Ciiu) getProveedorMaestroDAO().findObjectByPK(empresa.getCiiu(), Ciiu.class);
						empresa.setCiiuDescripcion(ciiu.getDescripcion());
					}
				}
			}
		}
		logger.debug("Empresas encontradas");
		return retorno;
	}


	public void setProveedorMaestroDAO(ProveedorMaestroDAO proveedorMaestroDAO) {
		this.proveedorMaestroDAO = proveedorMaestroDAO;
	}

	public ProveedorMaestroDAO getProveedorMaestroDAO() {
		return proveedorMaestroDAO;
	}
}
