package pe.gob.trabajo.pcd.servicio.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import pe.gob.trabajo.pcd.modelo.dominio.Rol;
import pe.gob.trabajo.pcd.modelo.dominio.TipoPreferencia;

// TODO: Auto-generated Javadoc
/**
 * The Class Constantes.
 */
public class Constantes {
	
	/** The Constant ACCION_LISTAR. */
	public static final Integer ACCION_LISTAR = 0;
	
	/** The Constant ACCION_NUEVO. */
	public static final Integer ACCION_NUEVO = 1;
	
	/** The Constant ACCION_EDITAR. */
	public static final Integer ACCION_EDITAR = 2;
	
	/** The Constant ACCION_VISUALIZAR. */
	public static final Integer ACCION_VISUALIZAR = 3;
	
	/** The Constant ACCION_ELIMINAR. */
	public static final Integer ACCION_ELIMINAR = 4;
	
	/** The Constant ACCION_PROCESAR. */
	public static final Integer ACCION_PROCESAR = 5;
	
	/** The Constant TIPO_EVALUACION_EXAMEN. */
	public static final Integer TIPO_EVALUACION_EXAMEN = 1;
	
	/** The Constant TIPO_EVALUACION_ENTREVISTA. */
	public static final Integer TIPO_EVALUACION_ENTREVISTA = 2;
	
	/** The Constant ROL_ADMINISTRADOR. */
	public static final Rol ROL_ADMINISTRADOR = new Rol(1L);
	
	/** The Constant ROL_auditor. */
	public static final Rol ROL_CONSULTOR_ABE = new Rol(2L);
	
	/** The Constant ROL_GESTOR. */
	public static final Rol ROL_CONSULTOR_EMPLEO = new Rol(3L);
	
	/** The Constant ROL_PROFESIONAL. */
	public static final Rol ROL_PROFESIONAL = new Rol(4L);
	
	/** The Constant ROL_CLIENTE. */
	public static final Rol ROL_EMPLEADOR = new Rol(5L);
	
	/** The Constant ROL_CONSULTOR_CUL. */
	public static final Rol ROL_CONSULTOR_CUL = new Rol(6L);
	
	/** The lista locale. */
	public static List<LocalComparable> LISTA_LOCALE;
	static {
		LISTA_LOCALE = new ArrayList<LocalComparable>();
		for (Locale aLocale : DateFormat.getAvailableLocales()) {
			LISTA_LOCALE.add(new LocalComparable(aLocale));
		}
	};
	
	/** The Constant CARPETA_FOTOS. */
	public static final String CARPETA_FOTOS = "/silnetint/fotos/";
	
	/** The Constant CARPETA_CV. */
	public static final String CARPETA_CV = "/silnetint/cv/";
	
	/** The Constant ARCHIVO_TAMANO_MAXIMO. */
	public static final long ARCHIVO_TAMANO_MAXIMO = 2 * 1024 * 1024; //2 MB
	
	/** The Constant CODIGO_OK. */
	public static final String CODIGO_OK = "101";
	
	/** The Constant CARPETA_IMAGENES_PREGUNTAS. */
	public static final String CARPETA_IMAGENES_PREGUNTAS = "/silnetint/tiposExamenes/";
	
	/** The Constant FOTO_DEFECTO. */
	public static final String FOTO_DEFECTO = "foto.gif";
	
	/** The Constant IMAGEN_DEFECTO. */
	public static final String IMAGEN_DEFECTO = "foto.gif";
	
	/** The Constant ESTADO_REGISTRO_ACTIVO. */
	public static final Character ESTADO_REGISTRO_ACTIVO = 'A';
	
	/** The Constant ESTADO_REGISTRO_INACTIVO. */
	public static final Character ESTADO_REGISTRO_INACTIVO = 'I';
	
	/** The Constant ESTADO_VALIDACION_VALIDO. */
	public static final Character ESTADO_VALIDACION_VALIDO = 'V';
	
	/** The Constant ESTADO_VALIDACION_INVALIDO. */
	public static final Character ESTADO_VALIDACION_INVALIDO = 'I';
	
	/** The Constant TIPO_PREFERENCIA_AREA. */
	public static final TipoPreferencia TIPO_PREFERENCIA_AREA = new TipoPreferencia(1L, "Área");
	
	/** The Constant TIPO_PREFERENCIA_SECTOR. */
	public static final TipoPreferencia TIPO_PREFERENCIA_SECTOR = new TipoPreferencia(2L, "Sector");
	
	/** The Constant TIPO_PREFERENCIA_CIUDAD. */
	public static final TipoPreferencia TIPO_PREFERENCIA_CIUDAD = new TipoPreferencia(3L, "Ciudad");
	
	/** The Constant ELEMENTOS_POR_PAGINA. */
	public static final Integer ELEMENTOS_POR_PAGINA = 15;
	
	/** The Constant MAXIMO_ELEMENTOS_BUSQUEDA. */
	public static final Integer MAXIMO_ELEMENTOS_BUSQUEDA = 55;
	
	/** The Constant MAXIMO_ELEMENTOS_AUTOCOMPLETADO. */
	public static final Integer MAXIMO_ELEMENTOS_AUTOCOMPLETADO = 15;
	
	/** The Constant PATRON_NOMBRE_EMPRESA. */
	public static final String PATRON_NOMBRE_EMPRESA = "^[0-9]|[a-zA-Z]{2,}";
	
	/** The Constant PATRON_RUC_EMPRESA. */
	public static final String PATRON_RUC_EMPRESA = "^[0-9]{11}$";
	
	/** The Constant ESTILO_CAMPO_REQUERIDO. */
	public static final String ESTILO_CAMPO_REQUERIDO = "border-color: #A59D9D;border-width: 1px;border-style: solid;background-color: #F8F6F1;background-image: url(/);";
	
	/** The Constant ESTILO_CAMPO_NUMERICO. */
	public static final String ESTILO_CAMPO_NUMERICO = "text-align:right;";
	
	/** The Constant CAMPO_SOLO_DECIMAL. */
	public static final String CAMPO_SOLO_DECIMAL =	"this.value=this.value.replace(/[^\\d\\.]/,'')";
	
	/** The Constant CAMPO_SOLO_ENTERO. */
	public static final String CAMPO_SOLO_ENTERO =	"this.value=this.value.replace(/[^\\d]/,'')";
	
	/** The Constant SEPARADOR_CRITERIOS_CV. */
	public static final String SEPARADOR_CRITERIOS_CV = ";";
	
	/** The Constant EMPLEO_PRINCIPAL. */
	public static final Integer EMPLEO_PRINCIPAL = 1;
	
	/** The Constant EMPLEO_SECUNDARIO. */
	public static final Integer EMPLEO_SECUNDARIO = 0;
	
	/** The Constant CONTEXTO_POSTULANTE. */
	public static final Integer CONTEXTO_ADMINISTRADOR = 100;
	
	/** The Constant CONTEXTO_POSTULANTE. */
	public static final Integer CONTEXTO_POSTULANTE = 200;
	
	/** The Constant CONTEXTO_EMPLEADOR. */
	public static final Integer CONTEXTO_EMPLEADOR = 300;
	
	/** The Constant CONTEXTO_PEDIDO. */
	public static final Integer CONTEXTO_PEDIDO = 400;
	
	/** The Constant CONTEXTO_POSTULACION. */
	public static final Integer CONTEXTO_POSTULACION = 500;
	
	public static Properties INTERESES_OCUPACIONALES_PROP = getPropertyFile("pe/gob/trabajo/pcd/vista/recursos/intereses.properties");
	
	@SuppressWarnings("finally")
	public static Properties getPropertyFile( String file ){
		 
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			
			String filename = file;
			input = Constantes.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
				System.out.println("No se pudo encontrar " + filename);
				return null;
			}
			
			//load a properties file from class path, inside static method
			prop.load(input);
			
			//get the property value and print it out
//			System.out.println(prop.getProperty("key"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return prop;
		}
		
	}
}
