package pe.gob.trabajo.pcd.modelo.dominio;

import java.util.ArrayList;
import java.util.List;

// Generated 03/02/2011 12:12:29 PM by Hibernate Tools 3.4.0.Beta1

/**
 * TiprmContactoMedio generated by hbm2java
 */
public class ContactoMedio extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {

	private static final long serialVersionUID = 9187207399419819150L;
	
	private TipoContacto tipoContacto;
	private Contacto contacto;
	private String valor;
	private Integer orden;
	
	private ContactoRedSocial contactoRedSocial;
	private List<ContactoMedio> contactoMedios = new ArrayList<ContactoMedio>();
	private List<TipoContacto> tipoContactos = new ArrayList<TipoContacto>();

	public void setTipoContactos(List<TipoContacto> tipoContactos) {
		this.tipoContactos = tipoContactos;
	}


	public ContactoMedio() {
	}
	

	public ContactoMedio(TipoContacto tipoContacto, Contacto contacto, String valor, Integer orden) {
		this.contacto = contacto;
		this.tipoContacto = tipoContacto;
		this.tipoContacto.setId(tipoContacto.getId());
		this.contacto.setId(contacto.getId());		
		this.valor = valor;
		this.orden = orden;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public ContactoRedSocial getContactoRedSocial() {
		return contactoRedSocial;
	}

	public void setContactoRedSocial(ContactoRedSocial contactoRedSocial) {
		this.contactoRedSocial = contactoRedSocial;
	}
	
	public List<ContactoMedio> getContactoMedios(){
		ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>();
		for(ContactoMedio contactoMedio : lista){
			if(contactoMedio!=null){
				lista.add(contactoMedio);
			}
		}
		return lista;
	}
	public List<ContactoMedio> getContactoMedios2(){
		ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>();
		for(ContactoMedio contactoMedio : contactoMedios){
			if(contactoMedio!=null){
				lista.add(contactoMedio);
			}
		}
		return lista;
	}
	public List<ContactoMedio> getValoresContactoMedio() {
		ArrayList<ContactoMedio> lista = new ArrayList<ContactoMedio>();

		for (ContactoMedio contactoMedio : contactoMedios) {
			if (contactoMedio != null) {
				lista.add(contactoMedio);
			}
		}
		return lista;
	}
	
	public List<TipoContacto> getTipoContactos(){
		ArrayList<TipoContacto> lista = new ArrayList<TipoContacto>();
		for(TipoContacto tipo : lista){
			if(tipo !=null){
				lista.add(tipo);
			}
		}
		return lista;
	}
}
