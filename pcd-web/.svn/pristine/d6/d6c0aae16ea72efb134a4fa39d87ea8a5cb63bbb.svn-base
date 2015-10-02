package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pe.gob.trabajo.pcd.modelo.dao.GenericDao;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDaoImpl.
 * 
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
public class GenericDaoImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, PK> {

	/** The logger. */
	private static Log logger = LogFactory.getFactory().getInstance(
			GenericDaoImpl.class);

	/** The persistent class. */
	private Class<T> persistentClass;

	/**
	 * Instantiates a new generic dao impl.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#insert(java.lang.Object)
	 */
	public void insert(T t) {
		getHibernateTemplate().persist(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#findByPK(java.io.Serializable
	 * )
	 */
	public T findByPK(PK id) {
		return (T) getSession().get(persistentClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.GenericDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> entities = new ArrayList<T>();
		try {
			String s = "select c from " + persistentClass.getSimpleName()
					+ " c";
			entities = getHibernateTemplate().loadAll(persistentClass);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}

		return entities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#remove(java.lang.Object)
	 */
	public void remove(T t) {
		getHibernateTemplate().delete(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#update(java.lang.Object)
	 */
	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#exists(java.io.Serializable)
	 */
	public boolean exists(PK id) {
		Object entity = getHibernateTemplate().load(this.persistentClass, id);

		return (entity != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.GenericDao#save(java.lang.Object)
	 */
	public T save(T object) {
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#findObjectByPK(java.lang
	 * .Object, java.lang.Class)
	 */
	public Object findObjectByPK(Object id, Class<?> clazz) {
		Object obj = getHibernateTemplate().get(clazz, (Serializable) id);
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#getAllObject(java.lang.Class
	 * )
	 */
	public List<?> getAllObject(Class<?> clazz) {
		List<?> lista = getHibernateTemplate().find(
				"from " + clazz.getSimpleName() + " c ");
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#getAllObject(java.lang.Class
	 * , java.lang.String)
	 */
	public List<?> getAllObject(Class<?> clazz, String varOrden) {
		String orden = "";
		if (varOrden != null && !"".equals(varOrden.trim())) {
			orden = " c order by c." + varOrden;
		}
		List<?> lista = getHibernateTemplate().find(
				"from " + clazz.getSimpleName() + orden);
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#getAllObject(java.lang.Class
	 * , java.lang.String, int)
	 */
	public List<?> getAllObject(Class<?> clazz, String varOrden,
			int numResultados) {
		String orden = "";
		if (varOrden != null && !"".equals(varOrden.trim())) {
			orden = " c order by c." + varOrden;
		}
		List<?> lista = getSession()
				.createQuery("from " + clazz.getSimpleName() + orden)
				.setMaxResults(numResultados).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#insertObject(java.lang.Object
	 * )
	 */
	public void insertObject(Object object) {
		// TODO Auto-generated method stub
		// new NotImplementedException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#removeObject(java.lang.Object
	 * )
	 */
	public void removeObject(Object object) {
		getHibernateTemplate().delete(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#saveObject(java.lang.Object)
	 */
	public Object saveObject(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.GenericDao#saveCollection(java.util
	 * .Collection)
	 */
	public void saveCollection(Collection col) {
		for (Object obj : col) {
			getHibernateTemplate().saveOrUpdate(obj);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.GenericDao#getHibernateSession()
	 */
	public Session getHibernateSession() {
		return getSessionFactory().getCurrentSession();
	}

}
