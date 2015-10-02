package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.CategoriaLicenciaConducir;
import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.DistritoId;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EstadoCivil;
import pe.gob.trabajo.pcd.modelo.dominio.EstadoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Oficina;
import pe.gob.trabajo.pcd.modelo.dominio.Parentesco;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.RolLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDiscapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDocumento;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpleo;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.servicio.util.LocalComparable;
import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.locator.ServiceLocator;
import pe.gob.trabajo.pcd.vista.seguridad.FiltroSesion;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericManagedBean.
 */
public class GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(GenericManagedBean.class);

	/** The bean. */
	private Object bean;

	/** The servicio. */
	private ServiceLocator servicio;
	/** The app context. */
	private ApplicationContext appContext;

	// private String mensajeError;

	/** The locale. */
	public static Locale locale = new Locale("es", "PE");

	/** The tz. */
	public static TimeZone tz = TimeZone.getTimeZone("America/Lima");

	/** The acciones. */
	protected static Map<String, Integer> acciones;

	/** The constantes. */
	protected static Map<String, Object> constantes;

	static {
		acciones = new HashMap<String, Integer>();
		acciones.put("ACCION_LISTAR", Constantes.ACCION_LISTAR);
		acciones.put("ACCION_NUEVO", Constantes.ACCION_NUEVO);
		acciones.put("ACCION_EDITAR", Constantes.ACCION_EDITAR);
		acciones.put("ACCION_VISUALIZAR", Constantes.ACCION_VISUALIZAR);
		acciones.put("ACCION_PROCESAR", Constantes.ACCION_PROCESAR);

		constantes = new HashMap<String, Object>();
		constantes.put("ARCHIVO_TAMANO_MAXIMO",
				Constantes.ARCHIVO_TAMANO_MAXIMO);
		constantes.put("ROL_ADMINISTRADOR", Constantes.ROL_ADMINISTRADOR);
		constantes.put("CONTEXTO_ADMINISTRADOR", Constantes.CONTEXTO_ADMINISTRADOR);
		constantes.put("CONTEXTO_POSTULANTE", Constantes.CONTEXTO_POSTULANTE);
		constantes.put("CONTEXTO_EMPLEADOR", Constantes.CONTEXTO_EMPLEADOR);
		constantes.put("CONTEXTO_PEDIDO", Constantes.CONTEXTO_PEDIDO);
		constantes.put("CONTEXTO_PEDIDO", Constantes.CONTEXTO_PEDIDO);
		constantes.put("CONTEXTO_POSTULACION", Constantes.CONTEXTO_POSTULACION);
	}

	/** The accion realizada. */
	public Integer accionRealizada;
	
	public Boolean usuarioValido = false;
	
	protected String nuevaClave;
	protected String nuevoUsuario;
	
	/**
	 * @return the nuevoUsuario
	 */
	public String getNuevoUsuario() {
		return nuevoUsuario;
	}

	/**
	 * @param nuevoUsuario the nuevoUsuario to set
	 */
	public void setNuevoUsuario(String nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	/**
	 * @return the nuevaClave
	 */
	public String getNuevaClave() {
		return nuevaClave;
	}

	/**
	 * @param nuevaClave the nuevaClave to set
	 */
	public void setNuevaClave(String nuevaClave) {
		this.nuevaClave = nuevaClave;
	}
	
	/**
	 * Inits the.
	 */
	public void init() {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		setBean(new Object());
	}

	/**
	 * Inits the.
	 * 
	 * @param Class
	 *            clazz
	 */
	public void init(Class clazz) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		try {
			setBean(clazz.newInstance());
		} catch (InstantiationException e) {
			logger.error(e.getStackTrace());
		} catch (IllegalAccessException e) {
			logger.error(e.getStackTrace());
		}
	}

	/**
	 * Gets the bean.
	 * 
	 * @return the bean
	 */
	public Object getBean() {
		return bean;
	}

	/**
	 * Sets the bean.
	 * 
	 * @param Object
	 *            bean
	 */
	public void setBean(Object bean) {
		this.bean = bean;
	}

	/**
	 * Gets the servicio.
	 * 
	 * @return the servicio
	 */
	public ServiceLocator getServicio() {
		return servicio;
	}

	/**
	 * Sets the servicio.
	 * 
	 * @param ServiceLocator
	 *            servicio
	 */
	public void setServicio(ServiceLocator servicio) {
		this.servicio = servicio;
	}

	/**
	 * Gets the acciones.
	 * 
	 * @return the acciones
	 */
	public Map<String, Integer> getAcciones() {
		return acciones;
	}

	/**
	 * Gets the constantes.
	 * 
	 * @return the constantes
	 */
	public Map<String, Object> getConstantes() {
		return constantes;
	}

	/**
	 * Gets the accion realizada.
	 * 
	 * @return the accionRealizada
	 */
	public Integer getAccionRealizada() {
		return accionRealizada;
	}

	/**
	 * Sets the accion realizada.
	 * 
	 * @param Integer
	 *            accionRealizada
	 */
	public void setAccionRealizada(Integer accionRealizada) {
		this.accionRealizada = accionRealizada;
	}

	/**
	 * @return the usuarioValido
	 */
	public Boolean getUsuarioValido() {
		return usuarioValido;
	}

	/**
	 * @param usuarioValido the usuarioValido to set
	 */
	public void setUsuarioValido(Boolean usuarioValido) {
		this.usuarioValido = usuarioValido;
	}

	/**
	 * Gets the row parameter.
	 * 
	 * @param ActionEvent
	 *            e
	 * @param String
	 *            nombre
	 * @return Object object
	 */
	public Object getRowParameter(ActionEvent e, String nombre) {
		UIParameter parametro = (UIParameter) e.getComponent().findComponent(nombre);
		if (parametro != null) {
			return parametro.getValue();
		}
		return null;
	}

	/**
	 * Agregar mensaje error.
	 * 
	 * @param String
	 *            mensaje
	 * @return FacesMessage message
	 */
	public FacesMessage agregarMensajeError(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage("messages", message);
		// this.mensajeError = mensaje;
		return message;
	}

	/**
	 * Agregar mensaje.
	 * 
	 * @param String
	 *            mensaje
	 * @return FacesMessage message
	 */
	public FacesMessage agregarMensaje(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage("messages", message);
		// this.mensajeError = mensaje;
		return message;
	}

	/**
	 * Agregar mensaje error transaccion.
	 * 
	 * @param String
	 *            mensaje
	 * @return FacesMessage message
	 */
	public FacesMessage agregarMensajeErrorTransaccion(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
				mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage("transaccion", message);
		// FacesContext.getCurrentInstance().addMessage("transaccionWarn",
		// message);
		// this.mensajeError = mensaje;
		return message;
	}

	/**
	 * Agregar mensaje exito transaccion.
	 * 
	 * @param String
	 *            mensaje
	 * @return FacesMessage message
	 */
	public FacesMessage agregarMensajeExitoTransaccion(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensaje, mensaje);
		FacesContext.getCurrentInstance().addMessage("transaccion", message);
		// this.mensajeError = mensaje;
		return message;
	}

	/**
	 * Agregar mensaje transaccion exitosa.
	 * 
	 * @param Integer
	 *            accion
	 */
	public void agregarMensajeTransaccionExitosa(Integer accion) {
		String transaccion = "";
		if (Constantes.ACCION_NUEVO.equals(accion)) {
			transaccion = "Registro correcto";
		}
		if (Constantes.ACCION_EDITAR.equals(accion)) {
			transaccion = "Actualización exitosa";
		}
		if (Constantes.ACCION_ELIMINAR.equals(accion)) {
			transaccion = "Los datos fueron eliminados correctamente";
		}
		agregarMensajeExitoTransaccion(transaccion);
	}

	/**
	 * Gets the items tipo documento.
	 * 
	 * @return Items tipo documento
	 */
	public List<SelectItem> getItemsTipoDocumento() {
		// List<TipoDocumentoIdentidad> lista = (List<TipoDocumentoIdentidad>)
		// getServicio().getMaestroService().getAllObject(TipoDocumentoIdentidad.class);
		List<TipoDocumento> lista = (List<TipoDocumento>) getServicio()
				.getMaestroService().getMaestroTipoDocumentos();

		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items sexo.
	 * 
	 * @return the items sexo
	 */
	public List<SelectItem> getItemsSexo() {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();

		listaItems.add(Items.getPrimerItem(Items.FIRST_ITEM_SELECT));

		SelectItem itmMasculino = new SelectItem("1", "Masculino");
		listaItems.add(itmMasculino);

		SelectItem itmFemenino = new SelectItem("2", "Femenino");
		listaItems.add(itmFemenino);

		return listaItems;
	}

	/**
	 * Gets the items jefe hogar.
	 * 
	 * @return List<SelectItem> listaItems combo jefe hogar
	 */
	public List<SelectItem> getItemsJefeHogar() {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();
		SelectItem itmMasculino = new SelectItem("1", "Si");
		listaItems.add(itmMasculino);
		SelectItem itmFemenino = new SelectItem("0", "No");
		listaItems.add(itmFemenino);
		return listaItems;
	}

	/**
	 * Gets the items estado civil.
	 * 
	 * @return Items estado civil
	 */
	public List<SelectItem> getItemsEstadoCivil() {
		List<EstadoCivil> lista = (List<EstadoCivil>) getServicio()
				.getMaestroService().getAllObject(EstadoCivil.class);
		return Items.getItems(lista, "valor", "id");
	}
	
	/**
	 * Gets the items Categorias de licencia de conducir.
	 * 
	 * @return Items Categorias de licencia de conducir
	 */
	public List<SelectItem> getItemsCategoriaLicenciaConducir() {
		List<EstadoCivil> lista = (List<EstadoCivil>) getServicio()
				.getMaestroService().getAllObject(CategoriaLicenciaConducir.class);
		return Items.getItems(lista, "valor", "id");
	}

	/**
	 * Gets the items unidad tiempo.
	 * 
	 * @return the items unidad tiempo
	 */
	public List<SelectItem> getItemsUnidadTiempo() {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();

		listaItems.add(Items.getPrimerItem(Items.FIRST_ITEM_SELECT));

		SelectItem itmMasculino = new SelectItem("1", "Horas");
		listaItems.add(itmMasculino);

		SelectItem itmFemenino = new SelectItem("2", "Meses");
		listaItems.add(itmFemenino);

		return listaItems;
	}

	// public List<TipoEstudio> getTiposEstudio() {
	// List<TipoEstudio> lista = (List<TipoEstudio>)
	// getServicio().getMaestroService().getAllObject(TipoEstudio.class);
	// return lista;
	// }

	// public List<NivelEstudio> getNivelesEstudio() {
	// List<NivelEstudio> lista = (List<NivelEstudio>)
	// getServicio().getMaestroService().getAllObject(NivelEstudio.class);
	// return lista;
	// }
	//
	// public List<UnidadTiempo> getUnidadesTiempo() {
	// List<UnidadTiempo> lista = (List<UnidadTiempo>)
	// getServicio().getMaestroService().getAllObject(UnidadTiempo.class);
	// return lista;
	// }
	//
	// public List<TipoTrabajo> getTiposTrabajo() {
	// List<TipoTrabajo> lista = (List<TipoTrabajo>)
	// getServicio().getMaestroService().getAllObject(TipoTrabajo.class);
	// return lista;
	// }

	// public List<CondicionLaboral> getCondicionesLaborales() {
	// List<CondicionLaboral> lista = (List<CondicionLaboral>)
	// getServicio().getMaestroService().getAllObject(CondicionLaboral.class);
	// return lista;
	// }

	/**
	 * Gets the spring bean.
	 * 
	 * @param nombreBean
	 *            the nombre bean
	 * @return the spring bean
	 */
	public Object getSpringBean(String nombreBean) {

		ServletContext context = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		this.appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);

		// ClassPathXmlApplicationContext appContext =
		// new ClassPathXmlApplicationContext(new String[]
		// {"/WEB-INF/config/applicationContext-bean.xml"});

		return appContext.getBean(nombreBean);
	}

	/**
	 * Gets the faces bean.
	 * 
	 * @param nombreBean
	 *            the nombre bean
	 * @return the faces bean
	 */
	public Object getFacesBean(String nombreBean) {
		Object bean = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(nombreBean);
		return bean;
	}

	/**
	 * Gets the usuario sesion.
	 * 
	 * @return the usuario sesion
	 */
	public UsuarioSesion getUsuarioSesion() {
		// UsuarioSesion usuario = null;

		// HttpSession httpSession = httpRequest.getSession();
		// UsuarioSesion usuario = (UsuarioSesion)
		// httpSession.getAttribute(SESION_USUARIO_ID);
		UsuarioSesion usuario = (UsuarioSesion) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get(FiltroSesion.SESION_USUARIO_ID);

		// SesionMB sesion = (SesionMB)getFacesBean("sesionMB");
		// if (sesion != null) {
		// usuario = (UsuarioSesion)sesion.getBean();
		// }
		return usuario;
	}

	/**
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public Date getTime() {
		return new Date();
	}

	/**
	 * Gets the items pais.
	 * 
	 * @return the items pais
	 */
	public List<SelectItem> getItemsPais() {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();

		List<LocalComparable> listaLocale = Constantes.LISTA_LOCALE;
		Collections.sort(listaLocale);
		for (LocalComparable locale : listaLocale) {
			if (locale.getBean().getDisplayCountry() != null
					&& !locale.getBean().getDisplayCountry().equals("")) {
				SelectItem itmLocale = new SelectItem(locale.getBean()
						.getCountry(), locale.getBean().getDisplayCountry());
				listaItems.add(itmLocale);
			}
		}

		return listaItems;
	}

	/**
	 * Gets the lista locale.
	 * 
	 * @return the lista locale
	 */
	public List<LocalComparable> getListaLocale() {
		return Constantes.LISTA_LOCALE;
	}

	/** The departamento. */
	private Ubigeo departamento;

	/** The provincia. */
	private Ubigeo provincia;

	/** The distrito. */
	private Ubigeo distrito;

	/**
	 * Gets the departamento.
	 * 
	 * @return the departamento
	 */
	public Ubigeo getDepartamento() {
		return departamento;
	}

	/**
	 * Sets the departamento.
	 * 
	 * @param departamento
	 *            the new departamento
	 */
	public void setDepartamento(Ubigeo departamento) {
		this.departamento = departamento;
	}

	/**
	 * Gets the provincia.
	 * 
	 * @return the provincia
	 */
	public Ubigeo getProvincia() {
		return provincia;
	}

	/**
	 * Sets the provincia.
	 * 
	 * @param provincia
	 *            the new provincia
	 */
	public void setProvincia(Ubigeo provincia) {
		this.provincia = provincia;
	}

	/**
	 * Gets the distrito.
	 * 
	 * @return the distrito
	 */
	public Ubigeo getDistrito() {
		return distrito;
	}

	/**
	 * Sets the distrito.
	 * 
	 * @param distrito
	 *            the new distrito
	 */
	public void setDistrito(Ubigeo distrito) {
		this.distrito = distrito;
	}

	/**
	 * Gets the items departamentos.
	 * 
	 * @return the items departamentos
	 */
	public List<SelectItem> getItemsDepartamentos() {
		if (departamento == null) {
			departamento = new pe.gob.trabajo.pcd.modelo.dominio.Ubigeo();
		}

		List<SelectItem> listaItems = null;// new ArrayList<SelectItem>();

		List<Ubigeo> listaDepartamentos = getServicio().getMaestroService()
				.getLugares(null);
		listaItems = Items.getItems(listaDepartamentos, "nmbre", "idDprtmnto",
				Items.FIRST_ITEM_SELECT);

		return listaItems;
	}

	/**
	 * Gets the items provincias.
	 * 
	 * @return the items provincias
	 */
	public List<SelectItem> getItemsProvincias() {
		// logger.debug("getItemsProvincias...");
		if (provincia == null) {
			provincia = new Ubigeo();
		}

		// logger.debug(departamento != null && departamento.getIdDprtmnto()!=
		// null && !departamento.getIdDprtmnto().equals("0"));

		if (departamento != null && departamento.getIdDprtmnto() != null
				&& !departamento.getIdDprtmnto().equals("0")) {
			// logger.debug(departamento.isDepartamento());
			// logger.debug(departamento.isProvincia());
			// logger.debug(departamento.isDistrito());
			return getProvincias(departamento);
		}
		return new ArrayList<SelectItem>();
	}

	/**
	 * Gets the provincias.
	 * 
	 * @param departamento
	 *            the departamento
	 * @return the provincias
	 */
	public List<SelectItem> getProvincias(Ubigeo departamento) {
		List<SelectItem> listaItems = null;// new ArrayList<SelectItem>();
		List<Ubigeo> listaProvincias = getServicio().getMaestroService()
				.getLugares(departamento);
		listaItems = Items.getItems(listaProvincias, "nmbre", "idPrvnca",
				Items.FIRST_ITEM_SELECT);
		return listaItems;
	}

	/**
	 * Gets the items distritos.
	 * 
	 * @return the items distritos
	 */
	public List<SelectItem> getItemsDistritos() {
		if (distrito == null) {
			distrito = new pe.gob.trabajo.pcd.modelo.dominio.Ubigeo();
		}
		// logger.debug("getItemsDistritos:");
		// logger.debug(provincia.getIdDprtmnto());
		// logger.debug(provincia.getIdPrvnca());
		// logger.debug(provincia != null && provincia.getIdPrvnca() != null &&
		// !provincia.getIdPrvnca().equals("0"));
		if (provincia != null && provincia.getIdPrvnca() != null
				&& !provincia.getIdPrvnca().equals("0")) {
			return getDistritos(provincia);
		}
		return new ArrayList<SelectItem>();
	}

	/**
	 * Gets the distritos.
	 * 
	 * @param provincia2
	 *            the provincia2
	 * @return the distritos
	 */
	public List<SelectItem> getDistritos(Ubigeo provincia2) {
		List<SelectItem> listaItems = null;// new ArrayList<SelectItem>();
		List<Ubigeo> listaDistritos = getServicio().getMaestroService()
				.getLugares(provincia2);
		listaItems = Items.getItems(listaDistritos, "nmbre", "idUbgo",
				Items.FIRST_ITEM_SELECT);
		return listaItems;
	}

	/**
	 * Gets the profesional sesion mb.
	 * 
	 * @return the profesional sesion mb
	 */
	public Profesional getProfesionalSesionMB() {
		Profesional profesionalBean = null;
		ProfesionalMB profesionalMB = (ProfesionalMB) getFacesBean("profesionalMB");
		if (profesionalMB != null) {
			profesionalBean = profesionalMB.getProfesionalBean();
		}
		return profesionalBean;
	}

	/**
	 * Gets the persona sesion mb.
	 * 
	 * @return the persona sesion mb
	 */
	public Persona getPersonaSesionMB() {
		Persona personaBean = null;
		PersonaMB personaMB = (PersonaMB) getFacesBean("personaMB");
		if (personaMB != null) {
			personaBean = personaMB.getPersonaBean();
		}
		return personaBean;
	}

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public String getLocale() {
		Locale aLocale = new Locale("es","PE");
		String retorno = aLocale.getCountry();
//		Locale localidad = FacesContext.getCurrentInstance()
//				.getExternalContext().getRequestLocale();
//		if (localidad != null) {
//			retorno = localidad.getCountry();
//		}
		return retorno;
	}

	/**
	 * Gets the time zone.
	 * 
	 * @return the time zone
	 */
	public String getTimeZone() {
		return tz.getID();
	}

	/**
	 * Gets the items estado formacion.
	 * 
	 * @return the items estado formacion
	 */
	public List<?> getItemsEstadoFormacion() {
		List<EstadoFormacion> lista = (List<EstadoFormacion>) getServicio()
				.getMaestroService().getAllObject(EstadoFormacion.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items tipo formacion.
	 * 
	 * @return the items tipo formacion
	 */
	public List<?> getItemsTipoFormacion() {
		List<TipoFormacion> lista = (List<TipoFormacion>) getServicio()
				.getMaestroService().getAllObject(TipoFormacion.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items tipo contacto.
	 * 
	 * @return the items tipo contacto
	 */
	public List<?> getItemsTipoContacto() {
		List<TipoContacto> lista = (List<TipoContacto>) getServicio()
				.getMaestroService().getAllObject(TipoContacto.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items nivel formacion.
	 * 
	 * @return the items nivel formacion
	 */
	public List<?> getItemsNivelFormacion() {
		List<NivelFormacion> lista = (List<NivelFormacion>) getServicio()
				.getMaestroService().getAllObject(NivelFormacion.class);
		return Items.getItems(lista, "valor", "id");
	}

	/**
	 * Gets the items idioma.
	 * 
	 * @return the items idioma
	 */
	public List<?> getItemsIdioma() {
		List<Idioma> lista = (List<Idioma>) getServicio().getMaestroService()
				.getAllObject(Idioma.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items nivel idioma.
	 * 
	 * @return the items nivel idioma
	 */
	public List<?> getItemsNivelIdioma() {
		List<NivelIdioma> lista = (List<NivelIdioma>) getServicio()
				.getMaestroService().getAllObject(NivelIdioma.class);
		return Items.getItems(lista, "valor", "id");
	}

	/**
	 * Gets the items tipo empleo.
	 * 
	 * @return the items tipo empleo
	 */
	public List<?> getItemsTipoEmpleo() {
		List<TipoEmpleo> lista = (List<TipoEmpleo>) getServicio()
				.getMaestroService().getAllObject(TipoEmpleo.class);
		return Items.getItems(lista, "valor", "id");
	}

	/**
	 * Gets the items parentesco.
	 * 
	 * @return the items parentesco
	 */
	public List<?> getItemsParentesco() {
		List<Parentesco> lista = (List<Parentesco>) getServicio()
				.getMaestroService().getAllObject(Parentesco.class);
		return Items.getItems(lista, "valor", "id");
	}

	/**
	 * Gets the items niveles formacion.
	 * 
	 * @return the items niveles formacion
	 */
	public List<?> getItemsNivelesFormacion() {
		List<NivelEducativo> lista = (List<NivelEducativo>) getServicio()
				.getMaestroService().getMaestroNivelesEducativos();
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items tipos discapacidad.
	 * 
	 * @return the items tipos discapacidad
	 */
	public List<?> getItemsTiposDiscapacidad() {
		List<Idioma> lista = (List<Idioma>) getServicio().getMaestroService()
				.getAllObject(TipoDiscapacidad.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	// Autocompletar

	/**
	 * Autocompletar ocupacion.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Ocupacion> autocompletarOcupacion(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Ocupacion> result = new ArrayList<Ocupacion>();

		List<Ocupacion> consulta = (List<Ocupacion>) getServicio()
				.getMaestroService().buscarOcupaciones(pref);

		for (Ocupacion ocupacionBuscada : consulta) {
			Ocupacion item = new Ocupacion();
			item.setId(ocupacionBuscada.getId());
			item.setDescripcion(ocupacionBuscada.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar empresa.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Empresa> autocompletarEmpresa(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Empresa> result = new ArrayList<Empresa>();

		List<Empresa> consulta = (List<Empresa>) getServicio()
				.getMaestroService().buscarEmpresas(pref);

		for (Empresa empresa : consulta) {
			Empresa item = new Empresa();
			item.setId(empresa.getId());
			item.setNombreComercial(empresa.getNombreComercial());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar cargo.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<PersonaCargo> autocompletarCargo(Object suggest) {
		String pref = (String) suggest;
		ArrayList<PersonaCargo> result = new ArrayList<PersonaCargo>();
		Puesto puesto = new Puesto();
		puesto.setDescripcion(pref);
		List<PersonaCargo> consulta = (List<PersonaCargo>) getServicio()
				.getMaestroService().buscarCargos(pref);

		for (PersonaCargo cargoBuscado : consulta) {
			PersonaCargo item = new PersonaCargo();
			item.setId(cargoBuscado.getId());
			item.setDescripcion(cargoBuscado.getDescripcion());
			item.setNombre(cargoBuscado.getNombre());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar campo.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<String> autocompletarCampo(Object suggest) {
		String pref = (String) suggest;
		List<String> result = (List<String>) getServicio().getMaestroService()
				.buscarCampoEstudio(pref);
		return result;
	}

	/**
	 * Autocompletar profesion.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Profesion> autocompletarProfesion(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Profesion> result = new ArrayList<Profesion>();
		List<Profesion> consulta = (List<Profesion>) getServicio()
				.getMaestroService().buscarProfesiones(pref);

		for (Profesion profesion : consulta) {
			Profesion item = new Profesion();
			item.setId(profesion.getId());
			item.setDescripcion(profesion.getDescripcion());
			item.setGrupoProfesion(profesion.getGrupoProfesion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar ciudad.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Ubigeo> autocompletarCiudad(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Ubigeo> result = new ArrayList<Ubigeo>();
		Ubigeo ubigeoBuscado = new Ubigeo();
		ubigeoBuscado.setNombre(pref);
		List<Ubigeo> consulta = (List<Ubigeo>) getServicio()
				.getMaestroService().buscarLugares(ubigeoBuscado);

		for (Ubigeo lugar : consulta) {
			Ubigeo item = new Ubigeo();
			item.setId(lugar.getId());
			item.setNombre(lugar.getNombre());
			item.setIdDprtmnto(lugar.getIdDprtmnto());
			item.setIdPrvnca(lugar.getIdPrvnca());
			item.setIdDstrto(lugar.getIdDstrto());
			item.setUbigeoRegion(lugar.getUbigeoRegion());
			item.setUbigeoProvincia(lugar.getUbigeoProvincia());
			item.setUbigeoDistrito(lugar.getUbigeoDistrito());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar institucion.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<InstitucionFormativa> autocompletarInstitucion(Object suggest) {
		String pref = (String) suggest;
		ArrayList<InstitucionFormativa> result = new ArrayList<InstitucionFormativa>();
		InstitucionFormativa institucionBuscada = new InstitucionFormativa();
		institucionBuscada.setDescripcion(pref);
		List<InstitucionFormativa> consulta = (List<InstitucionFormativa>) getServicio()
				.getMaestroService().buscarInstitucionFormativas(
						institucionBuscada);

		for (InstitucionFormativa institucion : consulta) {
			InstitucionFormativa item = new InstitucionFormativa();
			item.setId(institucion.getId());
			item.setDescripcion(institucion.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar estudio.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<String> autocompletarEstudio(Object suggest) {
		String pref = (String) suggest;
		List<String> result = (List<String>) getServicio().getMaestroService()
				.buscarEstudio(pref);
		return result;
	}

	/**
	 * Autocompletar area.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Area> autocompletarArea(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Area> result = new ArrayList<Area>();
		Area area = new Area();
		area.setDescripcion(pref);
		List<Area> consulta = (List<Area>) getServicio().getMaestroService()
				.buscarAreas(area);

		for (Area puestoBuscado : consulta) {
			Area item = new Area();
			item.setId(puestoBuscado.getId());
			item.setDescripcion(puestoBuscado.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar sector.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Sector> autocompletarSector(Object suggest) {

		String pref = (String) suggest;
		ArrayList<Sector> result = new ArrayList<Sector>();

		List<Sector> consulta = (List<Sector>) getServicio()
				.getMaestroService().buscarSectores(pref);

		for (Sector sectorBuscado : consulta) {
			Sector item = new Sector();
			item.setId(sectorBuscado.getId());
			item.setDescripcion(sectorBuscado.getDescripcion());
			result.add(item);
		}
		return result;
	}
	
	/**
	 * Autocompletar sector.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Ciiu> autocompletarCiiu(Object suggest) {

		String pref = (String) suggest;
		ArrayList<Ciiu> result = new ArrayList<Ciiu>();

		List<Ciiu> consulta = (List<Ciiu>) getServicio().getMaestroService().buscarCiius(pref);

		for (Ciiu ciiuBuscado : consulta) {
			Ciiu item = new Ciiu();
			item.setId(ciiuBuscado.getId());
			item.setDescripcion(ciiuBuscado.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar idioma.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Idioma> autocompletarIdioma(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Idioma> result = new ArrayList<Idioma>();
		Idioma idiomaBuscado = new Idioma();
		idiomaBuscado.setDescripcion(pref);
		List<Idioma> consulta = getServicio().getMaestroService().buscarIdioma(
				idiomaBuscado);
		for (Idioma idioma : consulta) {
			Idioma item = new Idioma();
			item.setId(idioma.getId());
			item.setDescripcion(idioma.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar nivel idioma.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<NivelIdioma> autocompletarNivelIdioma(Object suggest) {
		String pref = (String) suggest;
		ArrayList<NivelIdioma> result = new ArrayList<NivelIdioma>();
		NivelIdioma nivelIdiomaBuscado = new NivelIdioma();
		nivelIdiomaBuscado.setValor(pref);
		List<NivelIdioma> consulta = (List<NivelIdioma>) getServicio()
				.getMaestroService().buscarNivelIdioma(nivelIdiomaBuscado);
		for (NivelIdioma nivelIdioma : consulta) {
			NivelIdioma item = new NivelIdioma();
			item.setId(nivelIdioma.getId());
			item.setValor(nivelIdioma.getValor());
			result.add(item);
		}

		return result;
	}

	/**
	 * Autocompletar residencia.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Ubigeo> autocompletarResidencia(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Ubigeo> result = new ArrayList<Ubigeo>();
		Ubigeo ubigeoBuscado = new Ubigeo();
		ubigeoBuscado.setNombre(pref);
		List<Ubigeo> consulta = (List<Ubigeo>) getServicio()
				.getMaestroService().buscarLugares(ubigeoBuscado);

		for (Ubigeo lugar : consulta) {
			Ubigeo item = new Ubigeo();
			item.setId(lugar.getId());
			item.setNombre(lugar.getNombre());
			item.setIdDprtmnto(lugar.getIdDprtmnto());
			item.setIdPrvnca(lugar.getIdPrvnca());
			item.setIdDstrto(lugar.getIdDstrto());
			item.setUbigeoRegion(lugar.getUbigeoRegion());
			item.setUbigeoProvincia(lugar.getUbigeoProvincia());
			item.setUbigeoDistrito(lugar.getUbigeoDistrito());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar tipo formacion.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<TipoFormacion> autocompletarTipoFormacion(Object suggest) {
		String pref = (String) suggest;
		ArrayList<TipoFormacion> result = new ArrayList<TipoFormacion>();
		TipoFormacion tipoFormacionBuscada = new TipoFormacion();
		tipoFormacionBuscada.setDescripcion(pref);
		List<TipoFormacion> consulta = (List<TipoFormacion>) getServicio()
				.getMaestroService().buscarTiposFormacion(tipoFormacionBuscada);

		for (TipoFormacion tipoFormacion : consulta) {
			TipoFormacion item = new TipoFormacion();
			item.setId(tipoFormacion.getId());
			item.setDescripcion(tipoFormacion.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar nivel educativo.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<NivelEducativo> autocompletarNivelEducativo(Object suggest) {
		String pref = (String) suggest;
		ArrayList<NivelEducativo> result = new ArrayList<NivelEducativo>();
		List<NivelEducativo> consulta = (List<NivelEducativo>) getServicio()
				.getMaestroService().buscarNivelesEducativos(pref);

		for (NivelEducativo nivel : consulta) {
			NivelEducativo item = new NivelEducativo();
			item.setId(nivel.getId());
			item.setDescripcion(nivel.getDescripcion());
			result.add(item);
		}
		return result;
	}

	/**
	 * Autocompletar rol.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<RolLaboral> autocompletarRol(Object suggest) {
		String pref = (String) suggest;
		ArrayList<RolLaboral> result = new ArrayList<RolLaboral>();
		RolLaboral rol = new RolLaboral();
		rol.setDescripcion(pref);
		List<RolLaboral> consulta = (List<RolLaboral>) getServicio()
				.getMaestroService().buscarPuestos(rol);

		for (RolLaboral rolBuscado : consulta) {
			RolLaboral item = new RolLaboral();
			item.setId(rolBuscado.getId());
			item.setDescripcion(rolBuscado.getDescripcion());
			result.add(item);
		}
		return result;
	}

	// public List<EspecialidadProfesional> autocompletarEspecialidad(
	// Object suggest) {
	// String pref = (String) suggest;
	// ArrayList<EspecialidadProfesional> result = new
	// ArrayList<EspecialidadProfesional>();
	// EspecialidadProfesional especialidadBuscada = new
	// EspecialidadProfesional();
	// especialidadBuscada.setDescripcion(pref);
	// List<EspecialidadProfesional> consulta = (List<EspecialidadProfesional>)
	// getServicio()
	// .getMaestroService().buscarEspecialidades(especialidadBuscada);
	//
	// for (EspecialidadProfesional especialidad : consulta) {
	// EspecialidadProfesional item = new EspecialidadProfesional();
	// item.setId(especialidad.getId());
	// item.setDescripcion(especialidad.getDescripcion());
	// result.add(item);
	// }
	// return result;
	// }
	public String getParametro() {
		Map<String, String> params =FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap();
		String parameterOne = params.get("usuario");
		return parameterOne;
	}
	
	/**
	 * @return lista Oficinas
	 */
	public List<SelectItem> getItemsOficinas() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Oficina> lista = (List<Oficina>) getServicio().getMaestroService().getMaestroOficinas();
		for(Oficina o : lista) {
//			Distrito d = getServicio().getMaestroService().getMaestroDistrito(o.getCodigoDepartamento(), o.getCodigoProvincia(), o.getCodigoDistrito());
			DistritoId id = new DistritoId(o.getCodigoDistrito(), o.getCodigoProvincia(), o.getCodigoDepartamento());
			Distrito d = (Distrito) getServicio().getMaestroService().getProveedorMaestroObjectByPK(id, Distrito.class);
			String nombreDistrito = "";
			if(d != null && d.getNombre() != null) {
				nombreDistrito = d.getNombre();
			}
			items.add(new SelectItem(o.getCodigoOficina(),o.getDescripcion() + " - " + nombreDistrito));
		}
		return items;
	}
	
	/**
	 * Buscar usuario.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarUsuario(ActionEvent e) {
		Usuario usuario = null;
		usuarioValido = true;
		try {
			String nombreUsuarioBuscado = null;
			if (getUsuarioSesion().isRolProfesional()) {
				nombreUsuarioBuscado = getUsuarioSesion().getPersona().getUsuario().getNombreUsuario();
			} else if (getUsuarioSesion().isRolEmpleador()) {
				nombreUsuarioBuscado = getUsuarioSesion().getEmpresa().getUsuario().getNombreUsuario();
			} else if (getUsuarioSesion().isRolAdministrador()) {
				nombreUsuarioBuscado = nuevoUsuario;
			}
			if (nombreUsuarioBuscado != null && !nombreUsuarioBuscado.equals("")) {
				usuario = getServicio().getMaestroService().buscarUsuarioPorNombreUsuario(nombreUsuarioBuscado);
				if (usuario != null) {
					usuarioValido = false;
				}
			}			
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
		}
	}
	
	public List<?> getItemsConsultores() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Persona> lista = (List<Persona>) getServicio().getPersonaService().buscarConsultores();
		for (Persona p:lista) {
			items.add(new SelectItem(p.getId(), p.getNombres() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno()));
		}
		return items;
	}
}
