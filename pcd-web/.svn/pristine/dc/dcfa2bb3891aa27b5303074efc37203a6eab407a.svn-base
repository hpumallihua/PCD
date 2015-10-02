package pe.gob.trabajo.pcd.vista.faces.util;

import java.util.Collection;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class GestorListas.
 */
public class GestorListas extends UtilApplicationMap implements Map {
	
	/**
	 * Obtener tamano.
	 *
	 * @param coleccion the coleccion
	 * @return the integer
	 */
	public Integer obtenerTamano(Collection coleccion) {
		Integer retorno = 0;
		if (coleccion != null) {
			retorno = coleccion.size();
		}
		return retorno;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.util.UtilApplicationMap#get(java.lang.Object)
	 */
	public Object get(Object obj) {
		return obtenerTamano((Collection) obj);
	}
}
