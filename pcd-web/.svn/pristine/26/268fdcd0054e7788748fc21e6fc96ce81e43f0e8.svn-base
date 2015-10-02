package pe.gob.trabajo.pcd.vista.faces.util;

import java.util.Map;

public class ConvertidorTextoHtml extends UtilApplicationMap implements Map {
	
	public static final char ESPACIO 					= '\u0020'; //	SPACE
	public static final String ESPACIO_HTML 			= "&#160;";
	
	public static final char SALTO_DE_LINEA 			= (char)10; //	NEW LINE
	public static final String SALTO_DE_LINEA_HTML 		= "<br/>";
	
	public static final char TABULACION 				= '\u0009'; //	TABULACION
	public static final String TABULACION_HTML 			= "&#160;" + "&#160;"+ "&#160;";
	
	public static final String DOBLE_ESPACIO 			= "  ";
	public static final String DOBLE_ESPACIO_HTML 		= "&#160;" + "&#160;";
	
	public static final String SIGNO_MAYOR 			= ">";
	public static final String SIGNO_MAYOR_HTML 		= "&#62;";
	
	public static final String SIGNO_MENOR 			= "<";
	public static final String SIGNO_MENOR_HTML 		= "&#60;";
	
	private String reemplazarSaltosLinea(String str){
		String retorno = str;
		if (str != null) {
			retorno = retorno.replaceAll(SIGNO_MAYOR, SIGNO_MAYOR_HTML);
			retorno = retorno.replaceAll(SIGNO_MENOR, SIGNO_MENOR_HTML);
			retorno = retorno.replaceAll(String.valueOf(SALTO_DE_LINEA), SALTO_DE_LINEA_HTML);
			retorno = retorno.replaceAll(String.valueOf(TABULACION), TABULACION_HTML);
			retorno = retorno.replaceAll(DOBLE_ESPACIO, DOBLE_ESPACIO_HTML);
		}
		return retorno;
	}
	
	@Override
	public Object get(Object obj) {
		return reemplazarSaltosLinea((String)obj);
	}

}
