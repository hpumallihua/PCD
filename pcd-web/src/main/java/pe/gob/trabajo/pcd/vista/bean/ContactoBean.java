package pe.gob.trabajo.pcd.vista.bean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import pe.gob.trabajo.pcd.modelo.dominio.Contacto;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactoBean.
 */
public class ContactoBean {
	
	/** The contacto. */
	Contacto contacto;
//	List<ItemContactoBean> listaContactos;
	
	/** The mapa contactos. */
HashMap<Long, ItemContactoBean> mapaContactos;
	
	/**
	 * Instantiates a new contacto bean.
	 */
	public ContactoBean() {
		contacto = new Contacto();
		contacto.setId(0L);
		mapaContactos = new LinkedHashMap<Long, ItemContactoBean>();
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
	 * @param contacto the new contacto
	 */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	/**
	 * Gets the mapa contactos.
	 *
	 * @return the mapa contactos
	 */
	public HashMap<Long, ItemContactoBean> getMapaContactos() {
		return mapaContactos;
	}

	/**
	 * Sets the mapa contactos.
	 *
	 * @param mapaContactos the mapa contactos
	 */
	public void setMapaContactos(HashMap<Long, ItemContactoBean> mapaContactos) {
		this.mapaContactos = mapaContactos;
	}
	
	/**
	 * Gets the lista contactos.
	 *
	 * @return the lista contactos
	 */
	public List<ItemContactoBean> getListaContactos() {
		List<ItemContactoBean> lista = new ArrayList<ItemContactoBean>();
		for (ItemContactoBean mapaItem : mapaContactos.values()) {
			lista.add(mapaItem);
		}
		return lista;
	}
	
}
