package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.RedSocial;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.ContactoBean;
import pe.gob.trabajo.pcd.vista.bean.ItemContactoBean;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarContactoMB.
 */
public class RegistrarContactoMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarContactoMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;

	/** The persona bean. */
	private Persona personaBean;

	/** The valor. */
	private String valor;

	/** The tipo contactos. */
	private List<TipoContacto> tipoContactos;

	/** The contacto bean. */
	private ContactoBean contactoBean;

	/**
	 * Gets the contacto bean.
	 * 
	 * @return the contacto bean
	 */
	public ContactoBean getContactoBean() {
		return contactoBean;
	}

	/**
	 * Sets the contacto bean.
	 * 
	 * @param contactoBean
	 *            the new contacto bean
	 */
	public void setContactoBean(ContactoBean contactoBean) {
		this.contactoBean = contactoBean;
	}

	/**
	 * Gets the valor.
	 * 
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 * 
	 * @param valor
	 *            the new valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Gets the persona bean.
	 * 
	 * @return the persona bean
	 */
	public Persona getPersonaBean() {
		return personaBean;
	}

	/**
	 * Sets the persona bean.
	 * 
	 * @param personaBean
	 *            the new persona bean
	 */
	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	/**
	 * Gets the profesional bean.
	 * 
	 * @return the profesional bean
	 */
	public Profesional getProfesionalBean() {
		return profesionalBean;
	}

	/**
	 * Sets the profesional bean.
	 * 
	 * @param profesionalBean
	 *            the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Seleccionar profesional.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Seleccionar persona.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void seleccionarPersona(ActionEvent e) {
		this.personaBean = getPersonaSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Validar dato.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void validarDato(ActionEvent e) {
		Contacto bean = (Contacto) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO,
				Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion()
						.getUsuario().getId());
		guardar(e);
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		Contacto contacto = (Contacto) getContactoBean().getContacto();
//		List<ContactoMedio> medios = new ArrayList<ContactoMedio>();
		
		ContactoMedio cmNuevo = contacto.getContactoMedio();
		cmNuevo.setContacto(contacto);
		contacto.getContactoMedios().add(cmNuevo);

		try {
			if (contacto != null) {
//				for (ContactoMedio cm : contacto.getContactoMedios()) {
//					ContactoMedio cmNuevo = new ContactoMedio();
//					cmNuevo.setId(cm.getId());
//					cmNuevo.setContacto(contacto);
//					cmNuevo.setTipoContacto(cm.getTipoContacto());
//					cmNuevo.setValor(cm.getValor());
//					medios.add(cmNuevo);
//				}
				validar();
				getServicio().getPersonaService().guardarContacto(contacto,
						contacto.getContactoMedios());
				setBean(contacto);
				if (contacto != null && contacto.getId() != null) {
					agregarMensajeExitoTransaccion("Dato guardado con éxito");
				} else {
					agregarMensajeErrorTransaccion("Error");
				}
			}
			setAccionRealizada(Constantes.ACCION_LISTAR);
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un rrror");
		} finally {
			UtilBean.initNullObject(contacto);
		}
	}

	/**
	 * Metodo encargado de validar los campos obligatorios.
	 */
	public void validar() {

		Contacto bean = (Contacto) getContactoBean().getContacto();
		if (bean.getId() != null && bean.getId().equals(0L)) {
			bean.setId(null);
		}
		logger.debug(bean);
//		Collection<ContactoMedio> listaMedios = new HashSet<ContactoMedio>();
//		contactoBean.getListaContactos();
//		// int contadorContactos = 0;
//		for (ItemContactoBean icb : contactoBean.getListaContactos()) {
//			for (ContactoMedio cm : icb.getListaMedios()) {
//				if (cm != null && cm.getValor() != null
//						&& !cm.getValor().equals("")) {
//					if (cm.getId() != null && cm.getId().equals(0L)) {
//						cm.setId(null);
//					}
//					listaMedios.add(cm);
//					// ++contadorContactos;
//					// break;
//				}
//			}
//			// if (contadorContactos > 0) {
//			// break;
//			// }
//		}
//		// if (contadorContactos == 0) {
//		if (listaMedios.size() == 0) {
//			throw new ValidatorException(
//					agregarMensajeErrorTransaccion("Deberá ingresar al menos un dato de contacto"));
//		} else {
//			bean.setContactoMedios((Set<ContactoMedio>) listaMedios);
//		}
	}

	/**
	 * Cancelar.
	 * 
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 * 
	 * @param e
	 *            the e
	 */
	public void nuevo(ActionEvent e) {
		init();
		Contacto bean = new Contacto();
		bean.setPersona(profesionalBean.getPersona());
		UtilBean.initNullObject(bean);
//		setBean(bean);
//		setContactoBean(new ContactoBean());
//		initContactos();
		
		ContactoBean contactoBean = new ContactoBean();
		contactoBean.setContacto(bean);
		setContactoBean(contactoBean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Nuevo contacto medio.
	 * 
	 * @param e
	 *            the e
	 */
	public void nuevoContactoMedio(ActionEvent e) {
		init();
		TipoContacto tipo = (TipoContacto) getRowParameter(e, "tipoContactoPrm");

		ContactoMedio valor = new ContactoMedio();
		valor.setValor(valor.getValor());
		valor.setTipoContacto(tipo);
		setBean(valor);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Inits the contactos.
	 */
	private void initContactos() {
		Contacto bean = (Contacto) getBean();
		List<TipoContacto> listaTipoContacto = (List<TipoContacto>) getServicio()
				.getMaestroService().getAllObject(TipoContacto.class);
		// HashMap<Long, ItemContactoBean> mapaContactos = new
		// LinkedHashMap<Long, ItemContactoBean>();

		for (TipoContacto itemTipoContacto : listaTipoContacto) {
			contactoBean.setContacto(bean);
			ItemContactoBean itemContactoBean = new ItemContactoBean();
			itemContactoBean.setTipoContacto(itemTipoContacto);
			itemContactoBean.setListaMedios(getServicio().getPersonaService()
					.obtenerContactoMedios(bean, itemTipoContacto));
			contactoBean.getMapaContactos().put(itemTipoContacto.getId(),
					itemContactoBean);
		}
	}

	/**
	 * Metodo recibe un objeto Contacto y actualiza los cambios en la base de
	 * datos.
	 * 
	 * @param e
	 *            the e
	 */
	public void editar(ActionEvent e) {

		init();
		Contacto bean = (Contacto) getRowParameter(e, "contactoPrm");
		UtilBean.initNullObject(bean);
//		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
		List<ContactoMedio> medios = new ArrayList<ContactoMedio>();
		ContactoMedio cm = null;
		if (bean.getContactoMedios() != null && bean.getContactoMedios().size() > 0) {
			medios.addAll(bean.getContactoMedios());
			cm = medios.get(0);
		}		
		bean.setContactoMedio(cm);
		ContactoBean contactoBean = new ContactoBean();
		contactoBean.setContacto(bean);
		setContactoBean(contactoBean);
//		initContactos();
		
		/////////////
	}

	/**
	 * Metodo que elimina un registro de la base de datos..
	 * 
	 * @param e
	 *            the e
	 */
	public void eliminar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("eliminar... ");
		Contacto bean = (Contacto) getRowParameter(e, "contactoPrm");
		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La referencia ha sido eliminada");
	}

	/**
	 * Gets the contactos.
	 * 
	 * @return the contactos
	 */
	public List<Contacto> getContactos() {
		return (List<Contacto>) getServicio().getPersonaService()
				.obtenerContactos(profesionalBean.getPersona());
	}

	/**
	 * Gets the contactos2.
	 * 
	 * @return the contactos2
	 */
	public List<Contacto> getContactos2() {
		return (List<Contacto>) getServicio().getPersonaService()
				.obtenerContactos2(profesionalBean.getPersona());
	}

	/**
	 * Gets the contacto.
	 * 
	 * @return the contacto
	 */
	public Contacto getContacto() {
		return getServicio().getPersonaService().obtenerContacto(
				profesionalBean.getPersona());
	}

	/**
	 * Gets the contacto medios.
	 * 
	 * @return the contacto medios
	 */
	public List<ContactoMedio> getContactoMedios() {
		return (List<ContactoMedio>) getServicio().getPersonaService()
				.obtenerContactoMedios(profesionalBean.getPersona());
	}

	/**
	 * Gets the tipo contactos.
	 * 
	 * @return the tipo contactos
	 */
	public List<TipoContacto> getTipoContactos() {
		return (List<TipoContacto>) getServicio().getPersonaService()
				.obtenerTipoContactos(profesionalBean.getPersona());
	}

	/**
	 * Gets the tipos contactos.
	 * 
	 * @return the tipos contactos
	 */
	public List<TipoContacto> getTiposContactos() {
		ArrayList<TipoContacto> lista = new ArrayList<TipoContacto>();
		for (TipoContacto tipo : tipoContactos) {
			if (tipo != null) {
				tipoContactos.add(tipo);
			}
		}
		return lista;
	}

	/**
	 * Gets the items persona.
	 * 
	 * @return the items persona
	 */
	public List<?> getItemsPersona() {
		List<Persona> lista = (List<Persona>) getServicio().getMaestroService()
				.getAllObject(Persona.class);

		return Items.getItems(lista, "apellidoPaterno", "id");
	}

	/**
	 * Autocompletar persona.
	 * 
	 * @param suggest
	 *            the suggest
	 * @return the list
	 */
	public List<Persona> autocompletarPersona(Object suggest) {
		String pref = (String) suggest;
		ArrayList<Persona> result = new ArrayList<Persona>();
		Persona personaBuscada = new Persona();
		personaBuscada.setNombres(pref);
		List<Persona> consulta = (List<Persona>) getServicio()
				.getPersonaService().buscarPorNombres(pref);

		for (Persona persona : consulta) {
			Persona item = new Persona();
			item.setId(persona.getId());
			item.setNombres(persona.getNombres());
			item.setApellidoPaterno(persona.getApellidoPaterno());
			item.setApellidoMaterno(persona.getApellidoMaterno());
			result.add(item);
		}
		return result;
	}

	/**
	 * Gets the items contacto medio.
	 * 
	 * @return the items contacto medio
	 */
	public List<?> getItemsContactoMedio() {
		List<ContactoMedio> lista = (List<ContactoMedio>) getServicio()
				.getMaestroService().getAllObject(ContactoMedio.class);

		for (ContactoMedio contactoMedio : lista) {
			if (contactoMedio != null) {
				lista.add(contactoMedio);
			}
		}
		// logger.info(Items.getItems(lista, "tipoContacto",
		// "descripcion"));
		return Items.getItems(lista, "valor", "descripcion");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#
	 * getItemsTipoContacto()
	 */
	public List<?> getItemsTipoContacto() {
		List<TipoContacto> lista = (List<TipoContacto>) getServicio()
				.getMaestroService().getAllObject(TipoContacto.class);
		// logger.info(Items.getItems(lista, "descripcion", "id"));
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items red social.
	 * 
	 * @return the items red social
	 */
	public List<?> getItemsRedSocial() {
		List<RedSocial> lista = (List<RedSocial>) getServicio()
				.getMaestroService().getAllObject(RedSocial.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the personas contacto.
	 * 
	 * @return the personas contacto
	 */
	public List<Contacto> getPersonasContacto() {
		ArrayList<Contacto> lista = new ArrayList<Contacto>();

		for (Contacto contacto : lista) {
			if (contacto != null
					&& !contacto.getIdPersonaDestino().equals(
							personaBean.getId())) {
				lista.add(contacto);
			}
		}
		return lista;
	}

}
