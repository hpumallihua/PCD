package pe.gob.trabajo.pcd.vista.faces.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.vista.faces.bean.RegistrarEmpresaMB;

// TODO: Auto-generated Javadoc
/**
 * The Class Items.
 */
public class Items {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(Items.class);
	
	/** The Constant NULL_VALUE. */
	public static final String NULL_VALUE = "0";
	
	/** The Constant FIRST_ITEM_SELECT. */
	public static final String FIRST_ITEM_SELECT = "-- Seleccione --";
	
	/** The Constant FIRST_ITEM_ALL. */
	public static final String FIRST_ITEM_ALL = "-- Todos --";
	
	/** The Constant FIRST_ITEM_ANY. */
	public static final String FIRST_ITEM_ANY = "-- Cualquiera --";
	
	/**
	 * Gets the primer item.
	 *
	 * @param primerItemString the primer item string
	 * @return the primer item
	 */
	public static SelectItem getPrimerItem(String primerItemString){
		return getPrimerItem(primerItemString, false);
	}
	
	/**
	 * Gets the primer item.
	 *
	 * @param primerItemString the primer item string
	 * @param disabled the disabled
	 * @return the primer item
	 */
	public static SelectItem getPrimerItem(String primerItemString, boolean disabled) {
		return (primerItemString == null) ? null : new SelectItem(NULL_VALUE, primerItemString, null,
				disabled);
	}
	
	/**
	 * Gets the items.
	 *
	 * @param list the list
	 * @param propEtiqueta the prop etiqueta
	 * @param propValor the prop valor
	 * @return the items
	 */
	public static List<SelectItem> getItems(List<?> list, String propEtiqueta, String propValor) {
		return getItems(list, propEtiqueta, propValor, null);
	}
	
	/**
	 * Gets the items.
	 *
	 * @param list the list
	 * @param propEtiqueta the prop etiqueta
	 * @param propValor the prop valor
	 * @param etiquetaPrimero the etiqueta primero
	 * @return the items
	 */
	public static List<SelectItem> getItems(List<?> list, String propEtiqueta, String propValor, String etiquetaPrimero) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			if (list != null && !list.isEmpty()) {
				if (etiquetaPrimero != null)
					items.add(getPrimerItem(etiquetaPrimero, false));
				for (int i = 0; i < list.size(); i++) {
					Object bean = list.get(i);
					if (bean != null) {
						String etiqueta = "";
						if (propEtiqueta != null && !propEtiqueta.equals("")) {
							etiqueta = BeanUtils.getProperty(bean, propEtiqueta);
						}
						SelectItem item = new SelectItem(BeanUtils.getProperty(bean, propValor), etiqueta);
						items.add(item);
					}
				}
			}
		} catch (IllegalAccessException e) {
			logger.error(e.getStackTrace());
		} catch (InvocationTargetException e) {
			logger.error(e.getStackTrace());
		} catch (NoSuchMethodException e) {
			logger.error(e.getStackTrace());
		}
		return items;
	}
}
