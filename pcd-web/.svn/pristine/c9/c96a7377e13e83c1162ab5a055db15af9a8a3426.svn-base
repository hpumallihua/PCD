package pe.gob.trabajo.pcd.servicio.comun;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Interface GenericService.
 *
 * @param <T> the generic type
 */
public interface GenericService <T> {
	
	/**
	 * Sets the dao.
	 *
	 * @param dao the new dao
	 */
	public void setDao(Object dao);
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public Object getDao();
	
	/**
	 * Gets the all.
	 *
	 * @param object the object
	 * @return the all
	 */
	public abstract List<?> getAll(Object object);
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public abstract List<T> getAll();
	
	/**
	 * Find by pk.
	 *
	 * @param id the id
	 * @return the object
	 */
	public abstract Object findByPK(Long id);
	
	/**
	 * Update.
	 *
	 * @param object the object
	 */
	public abstract void update(Object object);
	
	/**
	 * Removes the.
	 *
	 * @param object the object
	 */
	public abstract void remove(Object object);
	
	/**
	 * Insert.
	 *
	 * @param object the object
	 */
	public abstract void insert(Object object);
	
	/**
	 * Save.
	 *
	 * @param object the object
	 * @return the object
	 */
	public abstract Object save(Object object);
	
	/**
	 * Exists.
	 *
	 * @param paramPK the param pk
	 * @return true, if successful
	 */
	public abstract boolean exists(Long paramPK);
	
	/**
	 * Gets the all object.
	 *
	 * @param clazz the clazz
	 * @return the all object
	 */
	public abstract List<?> getAllObject(Class<?> clazz);
	
	/**
	 * Gets the all object.
	 *
	 * @param clazz the clazz
	 * @param varOrden the var orden
	 * @return the all object
	 */
	public abstract List<?> getAllObject(Class<?> clazz, String varOrden);
	
	/**
	 * Gets the all object.
	 *
	 * @param clazz the clazz
	 * @param varOrden the var orden
	 * @param numResultados the num resultados
	 * @return the all object
	 */
	public abstract List<?> getAllObject(Class<?> clazz, String varOrden, int numResultados);
	
	/**
	 * Find object by pk.
	 *
	 * @param id the id
	 * @param clazz the clazz
	 * @return the object
	 */
	public abstract Object findObjectByPK(Object id, Class<?> clazz);
	
	/**
	 * Removes the object.
	 *
	 * @param object the object
	 */
	public abstract void removeObject(Object object);
	
	/**
	 * Insert object.
	 *
	 * @param object the object
	 */
	public abstract void insertObject(Object object);
	
	/**
	 * Save object.
	 *
	 * @param object the object
	 * @return the object
	 */
	public abstract Object saveObject(Object object);
}
