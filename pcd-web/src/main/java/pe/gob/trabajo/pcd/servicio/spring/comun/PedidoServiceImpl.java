package pe.gob.trabajo.pcd.servicio.spring.comun;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import pe.gob.trabajo.pcd.modelo.dao.PedidoDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.servicio.comun.PedidoService;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;

// TODO: Auto-generated Javadoc
/**
 * The Class PedidoServiceImpl.
 */
public class PedidoServiceImpl extends GenericServiceImpl<Pedido> implements PedidoService {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(PedidoServiceImpl.class);
	
	/** The pedido dao. */
	public PedidoDAO pedidoDAO;
	
	/** The proveedor maestro dao. */
	private ProveedorMaestroDAO proveedorMaestroDAO;
	
	/**
	 * Gets the proveedor maestro dao.
	 *
	 * @return the proveedor maestro dao
	 */
	public ProveedorMaestroDAO getProveedorMaestroDAO() {
		return proveedorMaestroDAO;
	}

	/**
	 * Sets the proveedor maestro dao.
	 *
	 * @param proveedorMaestroDAO the new proveedor maestro dao
	 */
	public void setProveedorMaestroDAO(ProveedorMaestroDAO proveedorMaestroDAO) {
		this.proveedorMaestroDAO = proveedorMaestroDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#getPedidoDAO()
	 */
	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	/**
	 * Sets the pedido dao.
	 *
	 * @param pedidoDAO the new pedido dao
	 */
	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		setDao(pedidoDAO);
		this.pedidoDAO = pedidoDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	@Override
	public PedidoDAO getDao() {
		return pedidoDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarPorRuc(java.lang.String)
	 */
	public Empresa buscarPorRuc(String ruc) {
		Empresa empresa = getDao().buscarPorRuc(ruc);
		if (empresa != null) {
			Hibernate.initialize(empresa.getTipoEmpresa());
		}
		logger.debug("Empresa encontrada");
		return empresa;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarEstablecimientoPorEmpresa(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
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
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarEmpleadorPorEstablecimiento(pe.gob.trabajo.pcd.modelo.dominio.Establecimiento)
	 */
	public List<Empleador> buscarEmpleadorPorEstablecimiento(Establecimiento establecimiento) {
		List<Empleador> retorno = getDao().buscarEmpleadorPorEstablecimiento(establecimiento);
		if (retorno != null) {
			for (Empleador empleador : retorno) {
				if (empleador != null) {
					Hibernate.initialize(empleador);
					Hibernate.initialize(empleador.getEstablecimiento());
				}
			}
		}
		logger.debug("Empleadores encontrados");
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarPorNombreComercial(java.lang.String)
	 */
	public List<Empresa> buscarPorNombreComercial(String empresaNombre){
		if (empresaNombre == null ) {
			empresaNombre = "";
		}
		return getDao().buscarPorNombreComercial(empresaNombre);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#guardarCollection(java.util.Collection)
	 */
	public void guardarCollection(Collection<Establecimiento> col) {
		for (Establecimiento obj : col) {
			guardarEstablecimiento(obj);
		}
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#guardarEstablecimiento(pe.gob.trabajo.pcd.modelo.dominio.Establecimiento)
	 */
	public Establecimiento guardarEstablecimiento(Establecimiento establecimiento) {
		getDao().saveObject(establecimiento); 
		return establecimiento;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#guardarPedido(pe.gob.trabajo.pcd.modelo.dominio.Pedido)
	 */
	public Pedido guardarPedido(Pedido pedido) {
		getDao().saveObject(pedido); 
		return pedido;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#getAllPedidos()
	 */
	public List<Pedido> getAllPedidos() {
		List<Pedido> lista = getDao().getAll();
		if (lista != null) {
			for (Pedido pedido : lista) {
				if (pedido != null) {
					Hibernate.initialize(pedido);
					Hibernate.initialize(pedido.getEmpleador());
				}
			}
		}
		logger.debug("pedidos encontrados");
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.PedidoService#buscarPedido(String descripcion)
	 */
	public List<Pedido> buscarPedidos(String descripcion, 
									  Date fecIni, 
									  Date fecFin, 
									  String cargo,
									  String profesion,
									  String estudio){
		
		List<Pedido> consulta = getDao().buscarPedidos(descripcion, fecIni, fecFin, cargo, profesion, estudio);
		if (consulta != null) {
			for (Pedido pedido : consulta) {
				if (pedido != null) {
					Hibernate.initialize(pedido);
					Hibernate.initialize(pedido.getEmpleador());
				}
			}
		}
		
		return consulta;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.PedidoService#buscarPedidos(BusquedaBean busquedaBean)
	 */
	public List<Pedido> buscarPedidos(BusquedaBean busquedaBean){
		
		List<Pedido> consulta = getDao().buscarPedidos(busquedaBean);
		if (consulta != null) {
			for (Pedido pedido : consulta) {
				if (pedido != null) {
					Hibernate.initialize(pedido);
					Hibernate.initialize(pedido.getEmpleador());
				}
			}
		}
		
		return consulta;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarPedido(java.lang.Long)
	 */
	public Pedido buscarPedido(Long pedidoId) {
		Pedido pedido = (Pedido)getDao().findObjectByPK(pedidoId, Pedido.class);
		if (pedido != null) {
			Hibernate.initialize(pedido);
			Hibernate.initialize(pedido.getEmpleador());
		}
		logger.debug("pedido encontrado");
		return pedido;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#buscarPostulacion(pe.gob.trabajo.pcd.modelo.dominio.Postulacion)
	 */
	public Postulacion buscarPostulacion(Postulacion postulacion) {
		Postulacion retorno = getDao().buscarPostulacion(postulacion); 
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PedidoService#guardarPostulacion(pe.gob.trabajo.pcd.modelo.dominio.Postulacion)
	 */
	public Postulacion guardarPostulacion(Postulacion postulacion) {
		getDao().saveObject(postulacion); 
		return postulacion;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.busqueda.PedidoService#buscarPostulaciones(Pedido pedido)
	 */
	public List<Postulacion> buscarPostulacionesPorPedido(Pedido pedido){
		List<Postulacion> consulta = getDao().buscarPostulacionesPorPedido(pedido);
		if (consulta != null) {
			for (Postulacion postulacion : consulta) {
				if (postulacion != null) {
					Hibernate.initialize(postulacion);
					Hibernate.initialize(postulacion.getPedido());
					Hibernate.initialize(postulacion.getPedido().getEmpleador());
					Hibernate.initialize(postulacion.getProfesional());
					Hibernate.initialize(postulacion.getProfesional().getPersona());
					Hibernate.initialize(postulacion.getProfesional().getPersona().getUsuario());
				}
			}
		}
		return consulta;
	}	
	
}
