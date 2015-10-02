package pe.gob.trabajo.pcd.vista.faces.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Hibernate;

// TODO: Auto-generated Javadoc
/**
 * The Class InicializadorHibernate.
 */
public class InicializadorHibernate extends UtilApplicationMap implements Map {

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.util.UtilApplicationMap#get(java.lang.Object)
	 */
	@Override
	public Object get(Object obj) {
		Hibernate.initialize(obj);
		if (obj instanceof Collection) {
			Collection coll = (Collection) obj;
			for (Iterator it = coll.iterator(); it.hasNext();) {
				Object item = (Object) it.next();
				Hibernate.initialize(item);
			}
		}
		return obj;
	}

}
