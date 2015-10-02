package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import pe.gob.trabajo.pcd.modelo.SilnetException;
import pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;


// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaDAOImpl.
 */
public class EmpresaDAOImpl extends GenericDaoImpl<Empresa, Long>
		implements EmpresaDAO {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(EmpresaDAOImpl.class);

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO#buscarPorRuc(java.lang.String)
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
	 * @see pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO#buscarPorNombreComercial(java.lang.String)
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
	 * @see pe.gob.trabajo.pcd.modelo.dao.EmpresaDAO#buscarEstablecimientoPorEmpresa(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
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
	
	public List<Empresa> buscarPorRangoFecha(String fechaInicio, String fechaFin) {

		@SuppressWarnings("unchecked")
		List<Empresa> lista = getSession()
				.createQuery("from Empresa p where p.fechaCreacion between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') order by p.id asc")
				.setString(0, fechaInicio).setString(1, fechaFin).list();
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Empresa> buscarEmpresas(BusquedaBean busquedaBean) {
		List<Empresa> lista = new ArrayList<Empresa>();
		
		if (busquedaBean!=null && busquedaBean.getPedido()!=null) {
			Criteria criteria = getSession().createCriteria(Empresa.class);
			if (busquedaBean.getEmpresa().getNombreComercial() !=null && !busquedaBean.getEmpresa().getNombreComercial().equals("")) {
				String buscado = busquedaBean.getEmpresa().getNombreComercial().toUpperCase();
				buscado = buscado.replaceAll("A", "%");
				buscado = buscado.replaceAll("E", "%");
				buscado = buscado.replaceAll("I", "%");
				buscado = buscado.replaceAll("O", "%");
				buscado = buscado.replaceAll("U", "%");
				buscado = "%" + buscado + "%";
				logger.debug("\n buscado" + buscado);
				criteria.add(Restrictions.ilike("nombreComercial", "%"+buscado+"%"));
			}
			if (busquedaBean.getEmpresa().getRuc()!=null && !busquedaBean.getEmpresa().getRuc().equals("")) {
				criteria.add(Restrictions.eq("ruc", busquedaBean.getEmpresa().getRuc()));
			}
			if (busquedaBean.getEmpresa().getCiiu()!=null && !busquedaBean.getEmpresa().getCiiu().equals("")) {
				criteria.add(Restrictions.eq("ciiu", busquedaBean.getEmpresa().getCiiu()));
			}
			lista = criteria.list();			
		}  
			
		return lista;
	}	
	
}
