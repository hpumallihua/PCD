package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import pe.gob.trabajo.pcd.modelo.dao.PedidoDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;


// TODO: Auto-generated Javadoc
/**
 * The Class PedidoDAOImpl.
 */
public class PedidoDAOImpl extends GenericDaoImpl<Pedido, Long> implements PedidoDAO {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(PedidoDAOImpl.class);

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPorRuc(java.lang.String)
	 */
	public Empresa buscarPorRuc(String ruc) {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		criteria.add(Restrictions.eq("ruc", ruc));
		try {
			Empresa retorno = (Empresa) criteria.uniqueResult();
			return retorno;
		} catch (HibernateException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPorNombreComercial(java.lang.String)
	 */
	public List<Empresa> buscarPorNombreComercial(String empresaNombre) {
		String buscado = empresaNombre.toUpperCase();
		buscado = buscado.replaceAll("A", "%");
		buscado = buscado.replaceAll("E", "%");
		buscado = buscado.replaceAll("I", "%");
		buscado = buscado.replaceAll("O", "%");
		buscado = buscado.replaceAll("U", "%");
		
		buscado = "%" + buscado + "%";
		logger.debug("\n buscado" + buscado);
		@SuppressWarnings("unchecked")
		List<Empresa> lista = getSession()
				.createQuery("from Empresa p where p.nombreComercial like ? order by p.nombreComercial")
				.setString(0, buscado).list();
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarEstablecimientoPorEmpresa(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
	 */
	public List<Establecimiento> buscarEstablecimientoPorEmpresa(Empresa empresa) {
		Long empresaId = empresa.getId();
		
		logger.debug("\n buscado empresa ID" + empresaId);
		
		@SuppressWarnings("unchecked")
		List<Establecimiento> lista = getSession()
				.createQuery("from Establecimiento p where p.empresa = ? order by 1 desc ")
				.setLong(0, empresaId).list();
		return lista;
	}
	
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarEmpleadorPorEstablecimiento(pe.gob.trabajo.pcd.modelo.dominio.Establecimiento)
	 */
	public List<Empleador> buscarEmpleadorPorEstablecimiento(Establecimiento establecimiento) {
		Long establecimientoId = establecimiento.getId();
		
		logger.debug("\n buscado empleadores del establecimiento ID" + establecimientoId);
		
		@SuppressWarnings("unchecked")
		List<Empleador> lista = getSession()
				.createQuery("from Empleador p where p.establecimiento = ? order by 1 desc ")
				.setLong(0, establecimientoId).list();
		return lista;
	}
	
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPedidos(String descripcion)
	 */
	@SuppressWarnings("unchecked")
	public List<Pedido> buscarPedidos(String descripcion, 
									  Date fecIni, 
									  Date fecFin, 
									  String cargo,
									  String profesion,
									  String estudio) {
		List<Pedido> lista = new ArrayList<Pedido>();
		if (descripcion!=null && !"".equals(descripcion)) {
			String buscado = descripcion.toUpperCase();
			buscado = buscado.replaceAll("A", "%");
			buscado = buscado.replaceAll("E", "%");
			buscado = buscado.replaceAll("I", "%");
			buscado = buscado.replaceAll("O", "%");
			buscado = buscado.replaceAll("U", "%");
			
			buscado = "%" + buscado + "%";
			logger.debug("\n buscado" + buscado);
			
			lista = getSession().createQuery("from Pedido p where upper(p.descripcion) like ? order by p.descripcion")
				    .setString(0, buscado).list();
			
		} else if (fecIni!=null && fecFin!=null) {
			Criteria crit = getSession().createCriteria(Pedido.class);
            crit.add(Restrictions.between("fechaRegistro", fecIni, fecFin));
			lista = crit.list();//getSession().createQuery("from Pedido p where p.fechaRegistro b like ? order by p.descripcion")
					//.setString(0, buscado).list();
		}
		return lista;
	}
	
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPedidos(String descripcion)
	 */
	@SuppressWarnings("unchecked")
	public List<Pedido> buscarPedidos(BusquedaBean busquedaBean) {
		List<Pedido> lista = new ArrayList<Pedido>();
		
		if (busquedaBean!=null && busquedaBean.getPedido()!=null) {
			Criteria criteria = getSession().createCriteria(Pedido.class);
			if (busquedaBean.getPedido().getNombre()!=null && !"".equals(busquedaBean.getPedido().getNombre())) {
				String buscado = busquedaBean.getPedido().getNombre().toUpperCase();
				buscado = buscado.replaceAll("A", "%");
				buscado = buscado.replaceAll("E", "%");
				buscado = buscado.replaceAll("I", "%");
				buscado = buscado.replaceAll("O", "%");
				buscado = buscado.replaceAll("U", "%");
				buscado = "%" + buscado + "%";
				logger.debug("\n buscado" + buscado);
				criteria.add(Restrictions.ilike("nombre", "%"+buscado+"%"));
			}
			if (busquedaBean.getFechaRegistroIni()!=null && busquedaBean.getFechaRegistroFin()!=null) {
				criteria.add(Restrictions.between( "fechaRegistro", busquedaBean.getFechaRegistroIni(), new Date(busquedaBean.getFechaRegistroFin().getTime() + 86400000) ));
			}
			if (busquedaBean.getPedido().getNivelEducativo()!=null && !"".equals(busquedaBean.getPedido().getNivelEducativo()) ) {
				criteria.add(Restrictions.eq("nivelEducativo", busquedaBean.getPedido().getNivelEducativo()));
			}
			if (busquedaBean.getEmpresa()!=null && busquedaBean.getEmpresa().getId()!=null) {
				
				String 	ruc 		= busquedaBean.getEmpresa().getRuc();
				if(ruc!= null && !"".equals(ruc)  && ruc.length() == 11) {
					List<Establecimiento> listaEstablecimiento = (List<Establecimiento>) buscarEstablecimientoPorEmpresa(busquedaBean.getEmpresa());
					for (Establecimiento establecimiento : listaEstablecimiento) {
						List<Empleador> listaEmpleador = (List<Empleador>) buscarEmpleadorPorEstablecimiento(establecimiento);
						for (Empleador empleador : listaEmpleador) {
							criteria.add(Restrictions.eq("empleador", empleador));							 
					}
				}
			  }
				
			}			
			lista = criteria.list();			
		}  
			
		return lista;
	}	
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPostulacion(Postulacion postulacion)
	 */
	public Postulacion buscarPostulacion(Postulacion postulacion) {
		Criteria criteria = getSession().createCriteria(Postulacion.class);
		criteria.add(Restrictions.eq("pedido.id",  postulacion.getPedido().getId()));
		criteria.add(Restrictions.eq("profesional.id", postulacion.getProfesional().getId()));
		Postulacion retorno = null;
		try {
			retorno = (Postulacion) criteria.uniqueResult();
		} catch (HibernateException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PedidoDAO#buscarPostulacionesPorPedido(Pedido pedido)
	 */
	public List<Postulacion> buscarPostulacionesPorPedido(Pedido pedido){
		Long pedidoId = pedido.getId();
		@SuppressWarnings("unchecked")
		List<Postulacion> lista = getSession()
		.createQuery("from Postulacion po where po.pedido = ? ")
		.setLong(0, pedidoId).list();
//		Criteria criteria = getSession().createCriteria(Postulacion.class);
		
		return lista;
	}
}
