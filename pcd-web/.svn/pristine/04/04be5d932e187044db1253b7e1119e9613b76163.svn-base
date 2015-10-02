package pe.gob.trabajo.pcd.modelo.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

public abstract interface GenericDao<T, PK extends Serializable> {

    /**
     * Metodo generico utilizado para obtener todos los objetos de un tipo
     * particular.
     * 
     * @return Listado de objetos
     */
    public abstract List<T> getAll();

    public abstract List<?> getAllObject(Class<?> clazz);
    public abstract List<?> getAllObject(Class<?> clazz, String varOrden);
    public abstract List<?> getAllObject(Class<?> clazz, String varOrden, int numResultados);
    /**
     * Metodo generico para obteher un objeto basandose en su clase e
     * identificador. ObjectRetrievalFailureException Runtime Exception es
     * lanzada si no se encuentra nada.
     * 
     * @param id
     *            Identificador (clave primaria) del objeto a obtener
     * @return Objeto cargado
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    public abstract T findByPK(PK id);
    public abstract Object findObjectByPK(Object id, Class<?> clazz);

    /**
     * Metodo generico para salvar un objeto - maneja actializacion e
     * inserccion.
     * 
     * @param object
     *            Objeto a salver
     */
    public abstract void update(T object);

    /**
     * Metodo generico para borrar un objeto basado en su clase e identificador
     * 
     * @param id
     *            the identifier (primary key) of the object to remove
     */
    public abstract void remove(T object);
    public abstract void removeObject(Object object);

    /**
     * Metodo generico para insertar un objeto - solo maneja.
     */
    public abstract void insert(T object);
    public abstract void insertObject(Object object);

    /**
     * Verifica la existencia de un objeto por clave primaria
     * 
     * @param paramPK
     *            Clave primaria
     * @return Verdadero si el objeto existe
     */

    public abstract boolean exists(PK paramPK);
    
    public abstract T save(T object);
    public abstract Object saveObject(Object object);
    public void saveCollection(Collection col);
    public Session getHibernateSession();
}
