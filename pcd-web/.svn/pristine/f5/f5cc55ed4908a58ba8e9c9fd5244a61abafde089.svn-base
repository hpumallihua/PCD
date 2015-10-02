package pe.gob.trabajo.pcd.servicio.spring.comun;

import java.util.List;

import pe.gob.trabajo.pcd.modelo.dao.GenericDao;
import pe.gob.trabajo.pcd.servicio.comun.GenericService;


// TODO: Auto-generated Javadoc
/**
 * The Class GenericServiceImpl.
 *
 * @param <T> the generic type
 */
public class GenericServiceImpl<T> implements GenericService<T> {
	
	/** The dao. */
	private GenericDao<T, Long> dao;

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#exists(java.lang.Long)
	 */
	public boolean exists(Long paramPK) {
		return dao.exists(paramPK);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#findByPK(java.lang.Long)
	 */
	public Object findByPK(Long id) {
		return dao.findByPK(id);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getAll(java.lang.Object)
	 */
	public List<?> getAll(Object object) {
		return dao.getAll();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#insert(java.lang.Object)
	 */
	public void insert(Object object) {
		// TODO Auto-generated method stub
		dao.insert((T) object);
//		ParametroDAO myDao = (ParametroDAO) getDao();
//		Parametro p = new Parametro();
////		p.setIdPrmtro(1L);
//		myDao.insert(p);
//		if (p.getIdPrmtro().intValue() % 2 == 0) {
//			throw new UnsupportedOperationException();			
//		}
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#remove(java.lang.Object)
	 */
	public void remove(Object object) {
		dao.remove((T)object);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#update(java.lang.Object)
	 */
	public void update(Object object) {
		dao.update((T)object);
		
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getDao()
	 */
	public GenericDao<T, Long> getDao() {
		return dao;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#setDao(java.lang.Object)
	 */
	public void setDao(Object dao) {
		this.dao = (GenericDao<T, Long>) dao;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getAll()
	 */
	public List<T> getAll() {
		return dao.getAll();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#save(java.lang.Object)
	 */
	public Object save(Object object) {
		return dao.save((T) object);
		
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#findObjectByPK(java.lang.Object, java.lang.Class)
	 */
	public Object findObjectByPK(Object id, Class<?> clazz) {
		return dao.findObjectByPK(id, clazz);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getAllObject(java.lang.Class)
	 */
	public List<?> getAllObject(Class<?> clazz) {
		return dao.getAllObject(clazz);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getAllObject(java.lang.Class, java.lang.String)
	 */
	public List<?> getAllObject(Class<?> clazz, String varOrden) {
		return dao.getAllObject(clazz,varOrden);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#getAllObject(java.lang.Class, java.lang.String, int)
	 */
	public List<?> getAllObject(Class<?> clazz, String varOrden, int numResultados) {
		return dao.getAllObject(clazz, varOrden, numResultados);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#insertObject(java.lang.Object)
	 */
	public void insertObject(Object object) {
		dao.insertObject(object);
		
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#removeObject(java.lang.Object)
	 */
	public void removeObject(Object object) {
		dao.removeObject(object);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.GenericService#saveObject(java.lang.Object)
	 */
	public Object saveObject(Object object) {
		return dao.saveObject(object);
	}

}
