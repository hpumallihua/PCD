package pe.gob.trabajo.pcd.vista.faces.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.store.jdbc.JdbcDirectory;
import org.apache.lucene.store.jdbc.dialect.Dialect;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Estado;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa;
import pe.gob.trabajo.pcd.modelo.dominio.Parametro;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.lucene.config.LuceneConfigBean;
import pe.gob.trabajo.pcd.servicio.maestro.MaestroService;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.servicio.util.SpringApplicationContextProvider;
import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;
import pe.gob.trabajo.pcd.vista.faces.bean.SesionMB;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilBean.
 */
public class UtilBean implements Serializable {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(UtilBean.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1244418622145026240L;
	
	/** The patron nombre empresa. */
	private static Pattern patronNombreEmpresa;// = Pattern.compile("^[0-9]|[a-zA-Z]{2,}");
	
	/** The patron ruc empresa. */
	private static Pattern patronRucEmpresa;// = Pattern.compile("^[0-9]{11}$");
	
	/** The parametros. */
	protected static Map<String, Object> parametros;
	
	/** The jdbc index dir. */
	protected static JdbcDirectory jdbcIndexDir;
	
	/** The estilo campo requerido. */
	private static String estiloCampoRequerido;
	
	/** The estilo campo numerico. */
	private static String estiloCampoNumerico;
	
	/** The estilo campo solo decimal. */
	private static String campoSoloDecimal;
	
	/** The estilo campo solo entero. */
	private static String campoSoloEntero;
	
	static {
		
		parametros = new HashMap<String, Object>();
		parametros.put("ARCHIVO_TAMANO_MAXIMO", Constantes.ARCHIVO_TAMANO_MAXIMO);
		parametros.put("ROL_ADMINISTRADOR", Constantes.ROL_ADMINISTRADOR);
		parametros.put("ELEMENTOS_POR_PAGINA", Constantes.ELEMENTOS_POR_PAGINA);
		parametros.put("MAXIMO_ELEMENTOS_BUSQUEDA", Constantes.MAXIMO_ELEMENTOS_BUSQUEDA);
		parametros.put("CARPETA_FOTOS", Constantes.CARPETA_FOTOS);
		parametros.put("CARPETA_CV", Constantes.CARPETA_CV);
		parametros.put("PATRON_NOMBRE_EMPRESA", Constantes.PATRON_NOMBRE_EMPRESA);
		parametros.put("PATRON_RUC_EMPRESA", Constantes.PATRON_RUC_EMPRESA);
		parametros.put("ESTILO_REQUERIDO", Constantes.ESTILO_CAMPO_REQUERIDO);
		parametros.put("ESTADO_VALIDACION_VALIDO", Constantes.ESTADO_VALIDACION_VALIDO);
		parametros.put("ESTADO_VALIDACION_INVALIDO", Constantes.ESTADO_VALIDACION_INVALIDO);
		parametros.put("LOG_FILE", "/jboss/standalone/log/silnetint/silnetint.log");
		
		patronNombreEmpresa = Pattern.compile(Constantes.PATRON_NOMBRE_EMPRESA);
		patronRucEmpresa = Pattern.compile(Constantes.PATRON_RUC_EMPRESA);
		estiloCampoRequerido = Constantes.ESTILO_CAMPO_REQUERIDO;
		estiloCampoNumerico = Constantes.ESTILO_CAMPO_NUMERICO;
		campoSoloDecimal  = Constantes.CAMPO_SOLO_DECIMAL;
		campoSoloEntero   = Constantes.CAMPO_SOLO_ENTERO;
		actualizarParametros();	
		
	}
	
	/**
	 * Actualizar parametros.
	 */
	public static void actualizarParametros() {
		
		String nombreBean = "MaestroService";		
		MaestroService maestroService = (MaestroService) SpringApplicationContextProvider.getBean(nombreBean);
		HashMap<String, Parametro> mapParametros = maestroService.getParametros();
		
		Parametro parmTamano = mapParametros.get("ARCHIVO_TAMANO_MAXIMO");
		if (parmTamano != null) {
			parametros.put("ARCHIVO_TAMANO_MAXIMO",new Long(parmTamano.getValor()));
		}
		Parametro parmElementos = mapParametros.get("ELEMENTOS_POR_PAGINA");
		if (parmElementos != null) {
			parametros.put("ELEMENTOS_POR_PAGINA",new Long(parmElementos.getValor()));
		}
		Parametro parmElementosBusqueda = mapParametros.get("MAXIMO_ELEMENTOS_BUSQUEDA");
		if (parmElementosBusqueda != null) {
			parametros.put("MAXIMO_ELEMENTOS_BUSQUEDA",new Long(parmElementosBusqueda.getValor()));
		}
		Parametro parmFotos = mapParametros.get("CARPETA_FOTOS");
		if (parmFotos != null) {
			parametros.put("CARPETA_FOTOS",parmFotos.getValor());
		}
		Parametro parmCV = mapParametros.get("CARPETA_CV");
		if (parmCV != null) {
			parametros.put("CARPETA_CV",parmCV.getValor());
		}
		Parametro parmPatronNombreEmpresa = mapParametros.get("PATRON_NOMBRE_EMPRESA");
		if (parmPatronNombreEmpresa != null) {
			parametros.put("PATRON_NOMBRE_EMPRESA",parmPatronNombreEmpresa.getValor());
			patronNombreEmpresa = Pattern.compile(parmPatronNombreEmpresa.getValor());
		}
		Parametro parmPatronRucEmpresa = mapParametros.get("PATRON_RUC_EMPRESA");
		if (parmPatronRucEmpresa != null) {
			parametros.put("PATRON_RUC_EMPRESA",parmPatronRucEmpresa.getValor());
			patronRucEmpresa = Pattern.compile(parmPatronRucEmpresa.getValor());
		}
		Parametro parmEstiloRequerido = mapParametros.get("ESTILO_CAMPO_REQUERIDO");
		if (parmEstiloRequerido != null) {
			parametros.put("ESTILO_CAMPO_REQUERIDO",parmEstiloRequerido.getValor());
			estiloCampoRequerido = parmEstiloRequerido.getValor();
		}
		Parametro parmEstiloNumerico = mapParametros.get("ESTILO_CAMPO_NUMERICO");
		if (parmEstiloNumerico != null) {
			parametros.put("ESTILO_CAMPO_NUMERICO",parmEstiloNumerico.getValor());
			estiloCampoNumerico = parmEstiloNumerico.getValor();
		}
		Parametro parmSoloDecimal = mapParametros.get("CAMPO_SOLO_DECIMAL");
		if (parmEstiloNumerico != null) {
			parametros.put("CAMPO_SOLO_DECIMAL",parmSoloDecimal.getValor());
			campoSoloDecimal = parmSoloDecimal.getValor();
		}
		Parametro parmSoloEntero = mapParametros.get("CAMPO_SOLO_ENTERO");
		if (parmEstiloNumerico != null) {
			parametros.put("CAMPO_SOLO_ENTERO",parmSoloEntero.getValor());
			campoSoloEntero = parmSoloEntero.getValor();
		}
		
		Parametro parmLogFile = mapParametros.get("LOG_FILE");
		if (parmLogFile != null) {
			parametros.put("LOG_FILE", parmLogFile.getValor());
		}
		
		LuceneConfigBean luceneConfig = (LuceneConfigBean) SpringApplicationContextProvider.getBean("luceneConfigBean");
		SessionFactoryImpl sessionFactory = (SessionFactoryImpl) SpringApplicationContextProvider.getBean("sessionFactory");
		DataSource dataSource = SessionFactoryUtils.getDataSource((SessionFactory) sessionFactory);
		
		try {
			jdbcIndexDir = new JdbcDirectory(dataSource, (Dialect) Class.forName(luceneConfig.getDialecto()).newInstance(), "INDICE_CV");
		} catch (InstantiationException e) {
			logger.error(e.getStackTrace());
		} catch (IllegalAccessException e) {
			logger.error(e.getStackTrace());
		} catch (ClassNotFoundException e) {
			logger.error(e.getStackTrace());
		}
	}

	/**
	 * Gets the jdbc index dir.
	 *
	 * @return the jdbc index dir
	 */
	public static JdbcDirectory getJdbcIndexDir() {
		return jdbcIndexDir;
	}

	/** The rec texto. */
	private transient RecortadorTexto recTexto = new RecortadorTexto();
	
	/** The conv texto. */
	private transient ConvertidorTextoHtml convTexto = new ConvertidorTextoHtml();
	
	/** The ini hib. */
	private transient InicializadorHibernate iniHib = new InicializadorHibernate();
	
	/** The ana archivo. */
	private transient AnalizadorArchivo anaArchivo = new AnalizadorArchivo();
	
	/** The gestor lista. */
	private transient GestorListas gestorLista = new GestorListas();
	
	/**
	 * Gets the parametros map.
	 *
	 * @return the parametros map
	 */
	public static Map<String, Object> getParametrosMap() {
		return parametros;
	}
	
	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public Map<String, Object> getParametros() {
		return parametros;
	}
	
	/**
	 * Gets the recortar texto.
	 *
	 * @return the recortar texto
	 */
	public RecortadorTexto getRecortarTexto() {
		return recTexto;
	}

	/**
	 * Gets the convertir html.
	 *
	 * @return the convertir html
	 */
	public ConvertidorTextoHtml getConvertirHtml() {
		return convTexto;
	}

	/**
	 * Gets the obtener extension.
	 *
	 * @return the obtener extension
	 */
	public AnalizadorArchivo getObtenerExtension() {
		return anaArchivo;
	}

	/**
	 * Gets the obtener tamano.
	 *
	 * @return the obtener tamano
	 */
	public GestorListas getObtenerTamano() {
		return gestorLista;
	}

	/**
	 * Gets the estilo campo requerido.
	 *
	 * @return the estilo campo requerido
	 */
	public String getEstiloCampoRequerido() {
		return estiloCampoRequerido;
	}
	
	/**
	 * Gets the estilo campo numerico.
	 *
	 * @return the estilo campo numerico
	 */
	public String getEstiloCampoNumerico() {
		return estiloCampoNumerico;
	}
	
	/**
	 * Gets the campo solo decimal.
	 *
	 * @return the campo solo numero decimal
	 */
	public String getCampoSoloDecimal() {
		return campoSoloDecimal;
	}
	
	/**
	 * Gets the campo solo entero.
	 *
	 * @return the campo solo numero entero
	 */
	public String getCampoSoloEntero() {
		return campoSoloEntero;
	}
	
	/**
	 * Gets the inicializar.
	 *
	 * @return the inicializar
	 */
	public InicializadorHibernate getInicializar() {
		return iniHib;
	}

	/**
	 * Inits the null object.
	 *
	 * @param bean the bean
	 * @return the object
	 */
	public static Object initNullObject(Object bean) {
		if (bean != null) {

			if (bean instanceof Persona) {
				Persona persona = (Persona) bean;
				if (persona.getTipoDocumentoIdentidad() == null) {
//					persona.setTipoDocumentoIdentidad((TipoDocumentoIdentidad) getSpringBean("TipoDocumentoIdentidadPrt"));
				}
				if (persona.getLugarResidencia() == null) {
					persona.setLugarResidencia((Ubigeo) getSpringBean("UbigeoPrt"));
				}
				if (persona.getLugarNacimiento() == null) {
					persona.setLugarNacimiento((Ubigeo) getSpringBean("UbigeoPrt"));
				}
			}

			if (bean instanceof Certificacion) {
				Certificacion certificacion = (Certificacion) bean;
//				if (certificacion.getEspecialidadProfesional() == null) {
//					certificacion
//							.setEspecialidadProfesional(new EspecialidadProfesional());
//				}
			}

			if (bean instanceof Referencia) {
				Referencia referencia = (Referencia) bean;
				if (referencia.getPuesto() == null) {
					referencia.setPuesto(new Puesto());
				}
				if (referencia.getEmpresa() == null) {
					referencia.setEmpresa(new Empresa());
				}
				if (referencia.getTipoReferencia() == null) {
					referencia.setTipoReferencia(new TipoReferencia());
				}
				// No es necesario ?
				if (referencia.getPersona() == null) {
					referencia.setPersona(new Persona());
				}
			}

			if (bean instanceof Contacto) {
				Contacto contacto = (Contacto) bean;
				if (contacto.getId() == null) {
					contacto.setId(0L);
				}
//				if (contacto.getPersona() == null
//						&& contacto.getContactoMedios() == null) {
//					contacto.setPersona(new Persona());
//					contacto.setContactoMedios((List<ContactoMedio>) new ArrayList<ContactoMedio>());
//				}
				if (contacto.getPersona() == null) {
					contacto.setPersona(new Persona());
				}
//				if (contacto.getContactoMedios() == null) {
//					contacto.setContactoMedios((List<ContactoMedio>) new ArrayList<ContactoMedio>());
//				}
				if (contacto.getContactoMedio().getTipoContacto() == null) {
					ContactoMedio contactoMedio = new ContactoMedio();
					TipoContacto tipoContacto = new TipoContacto();
					contactoMedio.setTipoContacto(tipoContacto);
					contacto.setContactoMedio(contactoMedio);
				}
			}

			if (bean instanceof ExperienciaLaboral) {
				ExperienciaLaboral experiencia = (ExperienciaLaboral) bean;
				if (experiencia.getEmpresa() == null) {
					experiencia.setEmpresa(new Empresa());
				}
//				if (experiencia.getRolLaboral() == null) {
//					experiencia.setRolLaboral(new RolLaboral());
//				}
				if (experiencia.getArea() == null) {
					experiencia.setArea(new Area());
				}
//				if (experiencia.getPuesto() == null) {
//					experiencia.setPuesto(new Puesto());
//				}
//				if (experiencia.getSector() == null) {
//					experiencia.setSector(new Sector());
//				}
			}

			if (bean instanceof Formacion) {
				Formacion formacion = (Formacion) bean;
				if (formacion.getTipoFormacion() == null) {
					formacion.setTipoFormacion(new TipoFormacion());
				}
				if (formacion.getInstitucionFormativa() == null) {
					formacion
							.setInstitucionFormativa(new InstitucionFormativa());
				}
				if (formacion.getEstado() == null) {
					formacion.setEstado(new Estado());
				}
			}

		}
		return bean;
	}

	/**
	 * Gets the spring bean.
	 *
	 * @param nombreBean the nombre bean
	 * @return the spring bean
	 */
	public static Object getSpringBean(String nombreBean) {
		ApplicationContext appContext;
		ServletContext context = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		return appContext.getBean(nombreBean);
	}

	/**
	 * Gets the extension.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @return the extension
	 */
	public static String getExtension(String nombreArchivo) {
		String retorno = ".";
		if (nombreArchivo != null) {
			retorno += nombreArchivo
					.substring(nombreArchivo.lastIndexOf('.') + 1);
		}
		return retorno;
	}

	/**
	 * Gets the item seleccione vacio.
	 *
	 * @return the item seleccione vacio
	 */
	public SelectItem getItemSeleccioneVacio() {
		SelectItem item = new SelectItem("", Items.FIRST_ITEM_SELECT);
		return item;
	}

	/**
	 * Gets the item seleccione cero.
	 *
	 * @return the item seleccione cero
	 */
	public SelectItem getItemSeleccioneCero() {
		SelectItem item = new SelectItem(Items.NULL_VALUE,
				Items.FIRST_ITEM_SELECT);
		return item;
	}

	/**
	 * Gets the item todos cero.
	 *
	 * @return the item todos cero
	 */
	public SelectItem getItemTodosCero() {
		SelectItem item = new SelectItem(Items.NULL_VALUE, Items.FIRST_ITEM_ALL);
		return item;
	}

	/**
	 * Gets the usuario sesion.
	 *
	 * @return the usuario sesion
	 */
	public static UsuarioSesion getUsuarioSesion() {
		UsuarioSesion usuarioSesion = new UsuarioSesion();
		SesionMB sesionBean = (SesionMB) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("sesionMB");
		if (sesionBean != null) {
			usuarioSesion = sesionBean.getUsuarioSesion();
		}
		return usuarioSesion;
	}
	
	public static Usuario getUsuarioTransaccion() {
		Usuario usuario = new Usuario();
		if (UtilBean.getUsuarioSesion().getUsuario() != null) {
			usuario = UtilBean.getUsuarioSesion().getUsuario();
		}
		
		if (UtilBean.getUsuarioSesion().isRolEmpleador()) {
			if (UtilBean.getUsuarioSesion().getEmpresa() != null && 
					UtilBean.getUsuarioSesion().getEmpresa().getUsuario() != null) {
				usuario = UtilBean.getUsuarioSesion().getEmpresa().getUsuario();
			}
		}
		
		if (UtilBean.getUsuarioSesion().isRolProfesional()) {
			if (UtilBean.getUsuarioSesion().getPersona() != null && 
					UtilBean.getUsuarioSesion().getPersona().getUsuario() != null) {
				usuario = UtilBean.getUsuarioSesion().getPersona().getUsuario();
			}
		}
		
//		if (!UtilBean.getUsuarioSesion().isRolEmpleador()) {
//			if (UtilBean.getUsuarioSesion().getPersona() != null && 
//					UtilBean.getUsuarioSesion().getPersona().getUsuario() != null) {
//				usuario = UtilBean.getUsuarioSesion().getPersona().getUsuario();
//			}			
//		} else {
//			if (UtilBean.getUsuarioSesion().getEmpresa() != null && 
//					UtilBean.getUsuarioSesion().getEmpresa().getUsuario() != null) {
//				usuario = UtilBean.getUsuarioSesion().getEmpresa().getUsuario();
//			}
//		}
		
		return usuario;
	}
	
	/**
	 * Transformar criterio busqueda simple.
	 *
	 * @param buscado the buscado
	 * @return the string
	 */
	public static String transformarCriterioBusquedaSimple(String buscado) {
		buscado = buscado.toUpperCase();
		buscado = buscado.replaceAll("A", "%");
		buscado = buscado.replaceAll("E", "%");
		buscado = buscado.replaceAll("I", "%");
		buscado = buscado.replaceAll("O", "%");
		buscado = buscado.replaceAll("U", "%");
		buscado = "%" + buscado + "%";
//		logger.debug("\n buscado" + buscado);
		return buscado;
	}
	
	/**
	 * Gets the url app.
	 *
	 * @return the url app
	 */
	public String getUrlApp(){
		String url = "";
		ServletContext contexto = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		url = contexto.getContextPath();
		return url;
	}
	
	/**
	 * Checks if is existen mensajes.
	 *
	 * @return true, if is existen mensajes
	 */
	public boolean isExistenMensajes() {
//		for (Iterator it = FacesContext.getCurrentInstance().getMessages(); it.hasNext();) {
//			FacesMessage m = (FacesMessage) it.next();
//			logger.info(m.getDetail());
//		}
		return FacesContext.getCurrentInstance().getMessages().hasNext();
	}
	
	/**
	 * Nombre valido empresa.
	 *
	 * @param nombre the nombre
	 * @return true, if successful
	 */
	public static boolean nombreValidoEmpresa(String nombre){
		boolean retorno = false;
		retorno = patronNombreEmpresa.matcher(nombre).find();
		return retorno;
	}
	
	/**
	 * Ruc valido empresa.
	 *
	 * @param ruc the ruc
	 * @return true, if successful
	 */
	public static boolean rucValidoEmpresa(String ruc){
		boolean retorno = false;
		retorno = patronRucEmpresa.matcher(ruc).find();
		return retorno;
	}
	
	public static HashMap<String, String[]> obtenerParametrosBusqueda(List listaMaestra, String datosBuscar ,String campoId, String campoDescripcion) {
		HashMap<String, String[]> mapa = new HashMap<String, String[]>();
		List<String> listaIds = new ArrayList<String>();
		List<String> listaDescripciones = new ArrayList<String>();
		
		String[] itemsBuscar = datosBuscar.split(Constantes.SEPARADOR_CRITERIOS_CV);
		try {
			if (itemsBuscar != null && itemsBuscar.length > 0) {
				for (Object itemMaestro : listaMaestra) {
					for (int i = 0; i < itemsBuscar.length; i++) {
						String esp = itemsBuscar[i];
						String itmId = BeanUtils.getProperty(itemMaestro, campoId);
						String itmDescripcion = BeanUtils.getProperty(itemMaestro, campoDescripcion);
						if (itmDescripcion != null && itmDescripcion.contains(esp)) {
							listaIds.add(itmId);
							listaDescripciones.add(itmDescripcion);
							continue;
						}
					}				
				}				
			}
			
		} catch (IllegalAccessException e) {
			logger.error(e.getStackTrace());
		} catch (InvocationTargetException e) {
			logger.error(e.getStackTrace());
		} catch (NoSuchMethodException e) {
			logger.error(e.getStackTrace());
		} finally {
			mapa.put("ids", (String[]) listaIds.toArray(new String[0]));
			mapa.put("valores", (String[]) listaDescripciones.toArray(new String[0]));
		}
		return mapa;
		
	}
}
