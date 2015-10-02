package pe.gob.trabajo.pcd.modelo.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaInteresesOcupacionales;

// TODO: Auto-generated Javadoc
/**
 * The Class ListaUtil.
 *
 * @author Silnet
 * The Class ListaUtil.
 */
public class ListaUtil {
	
	private static final long DAY_IN_MILLISECONDS = (24 * 60 * 60 * 1000);
	private static final long MONTH_IN_MILLISECONDS = (30 * DAY_IN_MILLISECONDS);
	
	public static void main(String [] args) {
		System.out.println(DAY_IN_MILLISECONDS);
		System.out.println(MONTH_IN_MILLISECONDS);
//		System.out.println(getInteresesOcupacionales(new Persona(), getPropertyFile("/pe/gob/trabajo/pcd/vista/recursos/intereses.properties")));
		
	}
	
	public static String getInteresesOcupacionales(Persona persona, Properties prop) {
		String retorno = "";
		if(persona == null || persona.getPersonaInteresesOcupacionales() == null) {
			return retorno;
		}
		for (Field f: PersonaInteresesOcupacionales.class.getDeclaredFields()) {
			if(f.getType().isInstance(Boolean.TRUE)) {
				
				Object valor;
				try {
					f.setAccessible(true);
					valor = f.get(persona.getPersonaInteresesOcupacionales());
					if(valor != null) {
						Boolean tieneValor = new Boolean(valor.toString());
						if(tieneValor) {
//							System.out.println(f.getName() + "=" + prop.getProperty(f.getName()));
							retorno += ", " + prop.getProperty(f.getName());
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return retorno.replaceFirst(", ", "");
	}
	
	public static String getExperiencias(List<ExperienciaLaboral> lista) {
		String retorno = "";
		for (ExperienciaLaboral el : lista) {
			if (el != null) {
				retorno += ", " + el.getDescripcionCargo();
			}
		}
		return retorno.replaceFirst(", ", "");
	}
	
	public static Integer getExperienciaMeses(List<ExperienciaLaboral> lista) {
		int retorno = 0;
		
		for (ExperienciaLaboral el : lista) {
			if (el != null && el.getInicio() != null) {
				Date d1 = el.getInicio();
				Date d2 = el.getTermino();
				if(d2 == null){
					d2 = new Date();
				}
				//in milliseconds
				long diff = d2.getTime() - d1.getTime();
				
				long diffMeses = diff / MONTH_IN_MILLISECONDS;
				retorno += diffMeses;
			}
		}
		return retorno;
	}
	
	public static Integer getMaximoNivelEducativo(List<Formacion> lista) {
		Integer retorno = null;
		int maximo = 0;
		for (Formacion f : lista) {
			if (f != null && f.getIdNivel() != null) {
				int idNivel = new Integer(f.getIdNivel()).intValue();
				if(idNivel > maximo){
					retorno = new Integer( f.getIdNivel());
				}
			}
		}
		return retorno;
	}
	
	
	
}


