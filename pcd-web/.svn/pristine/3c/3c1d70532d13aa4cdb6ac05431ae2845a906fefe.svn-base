package pe.gob.trabajo.pcd.servicio.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilDate.
 */
public class UtilDate {
	
/**
 * Gets the diferencia.
 *
 * @param inicio the inicio
 * @param fin the fin
 * @return the diferencia
 */
	public static String getDiferencia(Date inicio, Date fin){
		
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(inicio);
		
		Calendar calActual = Calendar.getInstance();
		calActual.setTime(fin);
		
		long diff = (calInicio.getTime().getTime() - calActual.getTime().getTime())/1000;

		NumberFormat df = new DecimalFormat("00");
		return df.format((diff/(60*60)) % 60) + ":" + df.format((diff/60) % 60) + ":" + df.format(diff % 60);

	}
	
	public static boolean compararFecha(Date fechaA, Date fechaB) {
		boolean retorno = false;
		if (fechaA != null && fechaB != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			retorno = sdf.format(fechaA).equals(sdf.format(fechaB));			
		}
		return retorno;
	}
	
	public static Date getFinDia(Date fecha) {
		Date retorno = fecha;
		if (fecha != null ) {
			Calendar c = Calendar.getInstance();
			c.setTime(fecha);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
			c.roll(Calendar.DAY_OF_MONTH, 1);
			c.add(Calendar.SECOND, -1);
			retorno = c.getTime();
		}
		return retorno;
	}
	
	public static Date getInicioDia(Date fecha) {
		Date retorno = fecha;
		if (fecha != null ) {
			Calendar c = Calendar.getInstance();
			c.setTime(fecha);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
			retorno = c.getTime();
		}
		return retorno;
	}
}
