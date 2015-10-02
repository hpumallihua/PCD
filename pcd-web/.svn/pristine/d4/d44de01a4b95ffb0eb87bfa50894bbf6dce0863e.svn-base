package pe.gob.trabajo.pcd.vista.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean;

import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemContactoBean.
 */
public class ItemContactoBean extends GenericManagedBean {
	
	/** The tipo contacto. */
	TipoContacto tipoContacto;
	
	/** The lista medios. */
	List<ContactoMedio> listaMedios;
	
	/**
	 * Instantiates a new item contacto bean.
	 */
	public ItemContactoBean() {
		tipoContacto = new TipoContacto();
		listaMedios = new ArrayList<ContactoMedio>();
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
	 * @param tipoContacto the new tipo contacto
	 */
	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	/**
	 * Gets the lista medios.
	 *
	 * @return the lista medios
	 */
	public List<ContactoMedio> getListaMedios() {
		return listaMedios;
	}

	/**
	 * Sets the lista medios.
	 *
	 * @param listaMedios the new lista medios
	 */
	public void setListaMedios(List<ContactoMedio> listaMedios) {
		this.listaMedios = listaMedios;
	}
	
	/**
	 * Agregar medio.
	 *
	 * @param e the e
	 */
	public void agregarMedio(ActionEvent e) {
		ContactoMedio medio = new ContactoMedio();
		Contacto contacto = (Contacto)getRowParameter(e, "contactoPrm");
		medio.setTipoContacto(tipoContacto);
		medio.setContacto(contacto);
		listaMedios.add(medio);
	}
	
	/**
	 * Eliminar medio.
	 *
	 * @param e the e
	 */
	public void eliminarMedio(ActionEvent e) {
		ContactoMedio medio = (ContactoMedio)getRowParameter(e, "medioPrm");
		listaMedios.remove(medio);
	}
	
}
