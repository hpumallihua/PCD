package pe.gob.trabajo.pcd.vista.faces.util;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class RecortadorTexto.
 */
public class RecortadorTexto extends UtilApplicationMap implements Map {
	
	/**
	 * Recortar texto.
	 *
	 * @param stg the stg
	 * @return the string
	 */
	public String recortarTexto(String stg) {
		String retorno = "";
		if (stg != null) {
			String[] palabras = stg.split(" ");
			if (palabras.length > 3) {
				for (int i = 0; i < palabras.length; i++) {
					String palabra = palabras[i];
					retorno += palabra + " ";
					if (i > 3) {
						retorno += "...";
						break;
					}
				}
			} else {
				if (stg.length() > 50) {
					retorno = stg.substring(0, 50) + "...";					
				} else {
					retorno = stg;
				}
			}
		}
		return retorno;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.util.UtilApplicationMap#get(java.lang.Object)
	 */
	public Object get(Object obj) {
		return recortarTexto((String) obj);
	}
}
