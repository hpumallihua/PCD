package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.List;

import pe.gob.trabajo.pcd.vista.faces.util.Items;

import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarContactoMedioMB.
 */
public class RegistrarContactoMedioMB extends GenericManagedBean {

	/** The tipo contacto. */
	private TipoContacto tipoContacto;

	/** The contacto. */
	private Contacto contacto;

	/** The valor. */
	private String valor;

	/** The orden. */
	private Integer orden;

	/** The lista. */
	private ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>() {
	};

	/** The tipo contactos. */
	private List<TipoContacto> tipoContactos;

	/** The persona bean. */
	private Persona personaBean;

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
	 * Gets the tipo contactos.
	 * 
	 * @return the tipo contactos
	 */
	public List<TipoContacto> getTipoContactos() {
		return tipoContactos;
	}

	/**
	 * Sets the tipo contactos.
	 * 
	 * @param tipoContactos
	 *            the new tipo contactos
	 */
	public void setTipoContactos(List<TipoContacto> tipoContactos) {
		this.tipoContactos = tipoContactos;
	}

	/** The profesional bean. */
	private Profesional profesionalBean;

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
	 * Cargar lista.
	 */
	public void cargarLista() {
		contactoMedio = new ContactoMedio(tipoContacto, contacto, valor, orden);
		this.lista.add(contactoMedio);
	}

	/**
	 * Gets the tipo contacto.
	 * 
	 * @return the tipo contacto
	 */
	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	/**
	 * Sets the tipo contacto.
	 * 
	 * @param tipoContacto
	 *            the new tipo contacto
	 */
	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	/**
	 * Gets the contacto.
	 * 
	 * @return the contacto
	 */
	public Contacto getContacto() {
		return contacto;
	}

	/**
	 * Sets the contacto.
	 * 
	 * @param contacto
	 *            the new contacto
	 */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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
	 * Gets the orden.
	 * 
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * Sets the orden.
	 * 
	 * @param orden
	 *            the new orden
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Gets the lista.
	 * 
	 * @return the lista
	 */
	public ArrayList<ContactoMedio> getLista() {
		return lista;
	}

	/**
	 * Sets the lista.
	 * 
	 * @param lista
	 *            the new lista
	 */
	public void setLista(ArrayList<ContactoMedio> lista) {
		this.lista = lista;
	}

	/**
	 * Gets the contacto medio.
	 * 
	 * @return the contacto medio
	 */
	public ContactoMedio getContactoMedio() {
		return contactoMedio;
	}

	/**
	 * Sets the contacto medio.
	 * 
	 * @param contactoMedio
	 *            the new contacto medio
	 */
	public void setContactoMedio(ContactoMedio contactoMedio) {
		this.contactoMedio = contactoMedio;
	}

	/** The contacto medio. */
	private ContactoMedio contactoMedio;

	/**
	 * Instantiates a new registrar contacto medio mb.
	 */
	public RegistrarContactoMedioMB() {

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
	 * All contacto medio.
	 * 
	 * @return the list
	 */
	public List<TipoContacto> allContactoMedio() {
		List<TipoContacto> lista = (List<TipoContacto>) getServicio()
				.getMaestroService().getAllObject(TipoContacto.class);
		for (TipoContacto tipoContacto : lista)
			lista.add(tipoContacto);
		return lista;
	}

	// /////////////////BORRRAR/*
	/**
	 * Gets the contactos.
	 * 
	 * @return the contactos
	 */
	public List<Contacto> getContactos() {
		return (List<Contacto>) getServicio().getPersonaService()
				.obtenerContactos(profesionalBean.getPersona());
	}

	// ///////////////BORRRAR*/

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
	 * Gets the tipos contactos.
	 * 
	 * @return the tipos contactos
	 */
	public List<TipoContacto> getTiposContactos() {
		ArrayList<TipoContacto> lista = new ArrayList<TipoContacto>();
		for (TipoContacto tipo : lista) {
			if (tipo != null) {
				lista.add(tipo);
			}
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>();

		for (ContactoMedio contactoMedio : lista) {
			if (contactoMedio != null) {
				lista.add(contactoMedio);
			}
		}
	}

	/**
	 * Gets the valores contacto.
	 * 
	 * @return the valores contacto
	 */
	public List<ContactoMedio> getValoresContacto() {
		ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>();

		for (ContactoMedio contactoMedio : lista) {
			if (contactoMedio != null) {
				lista.add(contactoMedio);
			}
		}
		return lista;
	}

}
