package pe.gob.trabajo.pcd.vista.faces.util;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class AnalizadorArchivo.
 */
public class AnalizadorArchivo extends UtilApplicationMap implements Map {
	
	/**
	 * Obtener extension.
	 *
	 * @param stg the stg
	 * @return the string
	 */
	public String obtenerExtension(String stg) {
		String retorno = "";
		if (stg != null) {
			retorno = ContentTypeManager.getTypeByString(stg);
//			if (retorno == null) {
//				retorno = "archivo";
//			}
		}
		return retorno;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.util.UtilApplicationMap#get(java.lang.Object)
	 */
	public Object get(Object obj) {
		return obtenerExtension((String) obj);
	}
}
