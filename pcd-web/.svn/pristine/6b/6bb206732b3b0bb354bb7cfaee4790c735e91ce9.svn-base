package pe.gob.trabajo.pcd.servicio.util;

import java.util.Locale;


// TODO: Auto-generated Javadoc
/**
 * The Class LocalComparable.
 */
public class LocalComparable implements Comparable {

	/** The bean. */
	Locale bean;
	
	/**
	 * Instantiates a new local comparable.
	 *
	 * @param bean the bean
	 */
	public LocalComparable(Locale bean){
		this.bean = bean;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		LocalComparable otro = (LocalComparable)o;
		return bean.getDisplayCountry().compareToIgnoreCase(otro.getBean().getDisplayCountry());
//		return 0;
	}
	
	/**
	 * Gets the bean.
	 *
	 * @return the bean
	 */
	public Locale getBean(){
		return bean;
	}


}
