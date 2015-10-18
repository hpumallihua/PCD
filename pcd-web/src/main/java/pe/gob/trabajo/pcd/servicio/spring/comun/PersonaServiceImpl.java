package pe.gob.trabajo.pcd.servicio.spring.comun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import pe.gob.trabajo.pcd.modelo.dao.MaestroDAO;
import pe.gob.trabajo.pcd.modelo.dao.PersonaDAO;
import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Discapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.DistritoId;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Person;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaDiscapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaIntegranteFamilia;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaNecesidadApoyo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.comun.PersonaService;
import pe.gob.trabajo.pcd.servicio.util.UtilDate;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonaServiceImpl.
 */
public class PersonaServiceImpl extends GenericServiceImpl<Persona> implements
		PersonaService {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(PersonaServiceImpl.class);
	
	/** The persona dao. */
	public PersonaDAO personaDAO;
	
	/** The proveedor maestro dao. */
	private ProveedorMaestroDAO proveedorMaestroDAO;
	
	/**
	 * Gets the proveedor maestro dao.
	 *
	 * @return the proveedor maestro dao
	 */
	public ProveedorMaestroDAO getProveedorMaestroDAO() {
		return proveedorMaestroDAO;
	}

	/**
	 * Sets the proveedor maestro dao.
	 *
	 * @param proveedorMaestroDAO the new proveedor maestro dao
	 */
	public void setProveedorMaestroDAO(ProveedorMaestroDAO proveedorMaestroDAO) {
		this.proveedorMaestroDAO = proveedorMaestroDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#getPersonaDAO()
	 */
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	/**
	 * Sets the persona dao.
	 *
	 * @param personaDAO the new persona dao
	 */
	public void setPersonaDAO(PersonaDAO personaDAO) {
		setDao(personaDAO);
		this.personaDAO = personaDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.spring.comun.GenericServiceImpl#getDao()
	 */
	@Override
	public PersonaDAO getDao() {
		return personaDAO;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarPorDocumentoIdentidad(java.lang.String, java.lang.String)
	 */
	public Persona buscarPorDocumentoIdentidad(String idTipo, String numero) {
		Persona persona = getDao().buscarPorDocumentoIdentidad(idTipo, numero);
//		Hibernate.initialize(itemProfesional.getPersona());
		
		if (persona != null) {
			Hibernate.initialize(persona.getTipoDocumentoIdentidad());
			Hibernate.initialize(persona.getLugarResidencia());
			Hibernate.initialize(persona.getLugarNacimiento());
			if (persona.getUsuario() != null) {
				Hibernate.initialize(persona.getUsuario());
			}
			if (persona.getDepartamentoResidencia() != null &&
					persona.getProvinciaResidencia() != null &&
							persona.getDistritoResidencia() != null) {
				Distrito distritoResidencia = (Distrito) getProveedorMaestroDAO().findObjectByPK(new DistritoId(persona.getDistritoResidencia(), persona.getProvinciaResidencia(), persona.getDepartamentoResidencia()), Distrito.class);
				if (distritoResidencia != null) {
					persona.setNombreLugarResidencia(distritoResidencia.getNombre());
				}
			}
			Hibernate.initialize(persona.getContactos());
			for (Contacto contacto : persona.getContactos()) {
				if (contacto != null) {
					Hibernate.initialize(contacto);
//					Hibernate.initialize(contacto.getPersona());
					Hibernate.initialize(contacto.getContactoMedios());
				}
			}
		}
		return persona;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarProfesionalPorDocumentoIdentidad(java.lang.String, java.lang.String)
	 */
	public Profesional buscarProfesionalPorDocumentoIdentidad(String idTipo, String numero) {
		Profesional profesional = getDao().buscarProfesionalPorDocumentoIdentidad(idTipo, numero);
//		Persona persona = buscarPorDocumentoIdentidad(idTipo, numero);
		if (profesional != null) {
			Hibernate.initialize(profesional);
			Hibernate.initialize(profesional.getPersona());
			Persona persona = profesional.getPersona();
			Hibernate.initialize(persona.getTipoDocumentoIdentidad());
			Hibernate.initialize(persona.getLugarResidencia());
			if (persona.getDepartamentoResidencia() != null &&
					persona.getProvinciaResidencia() != null &&
							persona.getDistritoResidencia() != null) {
				Distrito distritoResidencia = (Distrito) getProveedorMaestroDAO().findObjectByPK(new DistritoId(persona.getDistritoResidencia(), persona.getProvinciaResidencia(), persona.getDepartamentoResidencia()), Distrito.class);
				if (distritoResidencia != null) {
					persona.setNombreLugarResidencia(distritoResidencia.getNombre());
				}
			}
			Hibernate.initialize(persona.getLugarNacimiento());
			Hibernate.initialize(persona.getContactos());
			for (Contacto contacto : persona.getContactos()) {
				if (contacto != null) {
					Hibernate.initialize(contacto);
					Hibernate.initialize(contacto.getContactoMedios());
				}
			}
		}
		return profesional;
	}
	
	/**
	 * Buscar persona por documento.
	 *
	 * @param persona the persona
	 * @return the persona
	 */
	public Persona buscarPersonaPorDocumento(Persona persona) {
		Persona retorno = getDao().buscarPorDocumentoIdentidad(persona.getTipoDocumentoIdentidad(), persona.getNumeroDocumentoIdentidad());
		if (retorno != null) {
			if (retorno.getDepartamentoResidencia() != null &&
					retorno.getProvinciaResidencia() != null &&
					retorno.getDistritoResidencia() != null) {
				Distrito distritoResidencia = (Distrito) getProveedorMaestroDAO().findObjectByPK(new DistritoId(retorno.getDistritoResidencia(), retorno.getProvinciaResidencia(), retorno.getDepartamentoResidencia()), Distrito.class);
				if (distritoResidencia != null) {
					retorno.setNombreLugarResidencia(distritoResidencia.getNombre());
				}
			}			
		}
		return retorno;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#guardarPersona(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public Persona guardarPersona(Persona persona) {
		if (persona.getId() == null) {
			Persona personaEncontrada = buscarPersonaPorDocumento(persona);
			if (personaEncontrada != null && personaEncontrada.getId() != null) {
				return persona;
			}
		}
		List<Discapacidad> discapacidades = persona.getDiscapacidades();
		
		int eliminados = getDao().eliminarDiscapacidades(persona.getId());
//		for (Discapacidad dp : discapacidadesPersistencia) {
////			boolean encontrado = false;
//			for (Discapacidad discapacidad : discapacidades) {
//				if (dp.getTipoDiscapacidad().getId().compareTo(discapacidad.getTipoDiscapacidad().getId()) == 0) {
////					encontrado = true;
//					continue;					
//				}
//				//Borrar
//				getDao().removeObject(dp);
//			}
//		}
		
//		List<Discapacidad> discapacidadesBorrar = new ArrayList<Discapacidad>();
//		List<TipoDiscapacidad> tipos = (List<TipoDiscapacidad>) getDao().getAllObject(TipoDiscapacidad.class);
//		for (TipoDiscapacidad tipo : tipos) {
//			for (Discapacidad dp : discapacidadesPersistencia) {
//				if (dp.getTipoDiscapacidad().getId().compareTo(tipo.getId()) == 0) {
//					for (Discapacidad discapacidad : discapacidades) {
//						if (dp.getTipoDiscapacidad().getId().compareTo(discapacidad.getTipoDiscapacidad().getId()) == 0) {
//							discapacidadesBorrar.add(discapacidad);
//							continue;
//						}
//						//Borrar
//						getDao().removeObject(dp);
//					}
//					continue;
//				}
//				//Borrar
//				getDao().removeObject(dp);
//			}
//		}
//		
//		discapacidades.removeAll(discapacidadesBorrar);
		
		getPersonaDAO().save(persona);
//		getDao().saveCollection(persona.getDiscapacidades());
		persona.getProfesional().setPersona(persona);
		getPersonaDAO().saveObject(persona.getProfesional());			
		return persona;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarPorEjemplo(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Persona> buscarPorEjemplo(Persona bean) {
		return getDao().buscarPorEjemplo(bean);
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarPorUsuarioClave(java.lang.String, java.lang.String)
	 */
	public Persona buscarPorUsuarioClave(String nombreUsuario, String clave) {
		Usuario usuario = getDao().buscarUsuarioPorUsuarioClave(nombreUsuario, clave);
		
		if (usuario != null) {
			if (usuario.getRol() != null) {
				Hibernate.initialize(usuario.getRol());
			}
			
			usuario.getPersona().setUsuario(usuario);
			return usuario.getPersona();
		} else {
			Persona persona = getDao().buscarPersonaPorDocumentoClave(nombreUsuario, clave);
			
			if (persona != null) {
				if (persona.getUsuario()!=null && persona.getUsuario().getRol() != null ) {
					Hibernate.initialize(persona.getUsuario().getRol());
				}
				return persona;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarPorTexto(java.lang.String)
	 */
	public List<Persona> buscarPorTexto(String personaTexto) {
		if (personaTexto == null ) {
			personaTexto = "";
		}
		ArrayList<Persona> result = new ArrayList<Persona>();
//		List<Persona> consulta = (ArrayList<Persona>) getDao().buscarPorTexto(personaTexto);
        
//        for (Persona persona : consulta) {
//        	Persona item = new Persona();
//        	item.setAplldoPtrno(persona.getAplldoPtrno());
//        	item.setAplldoMtrno(persona.getAplldoMtrno());
//        	item.setNmbres(persona.getNmbres());
//        	item.setIdPrsna(persona.getIdPrsna());
//        	result.add(item);
//		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#buscarPorNombres(java.lang.String)
	 */
	public List<Persona> buscarPorNombres(String personaNombres){
		if (personaNombres == null ) {
			personaNombres = "";
		}
		return getDao().buscarPorNombres(personaNombres);
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerContactos(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Contacto> obtenerContactos(Persona persona){
		List<Contacto> lista = getPersonaDAO().obtenerContactos(persona);
		for(Contacto contacto : lista){
			Hibernate.initialize(contacto.getPersona());
			if (contacto.getContactoMedios() != null && !contacto.getContactoMedios().isEmpty()) {
				Hibernate.initialize(contacto.getContactoMedios());
				for (ContactoMedio cm : contacto.getContactoMedios()) {
					Hibernate.initialize(cm);
					Hibernate.initialize(cm.getTipoContacto());
				}				
			}
		}		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerContactos2(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Contacto> obtenerContactos2(Persona persona){
		List<Contacto> lista = getPersonaDAO().obtenerContactos2(persona);
		for(Contacto contacto : lista){
			Hibernate.initialize(contacto.getPersona());
			Hibernate.initialize(contacto.getContactoMedios());
			//Hibernate.initialize(contacto.getContactoMedios().set(0, null));
		}		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerContacto(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public Contacto obtenerContacto(Persona persona){
		Contacto contacto = getPersonaDAO().obtenerContacto(persona);
			Hibernate.initialize(contacto.getPersona());
			Hibernate.initialize(contacto.getContactoMedios());
			
		return contacto;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerContactoMedios(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<ContactoMedio> obtenerContactoMedios(Persona persona){
		List<ContactoMedio> lista = getPersonaDAO().obtenerContactoMedios(persona);
		for(ContactoMedio medio :lista){
			Hibernate.initialize(medio.getTipoContacto());
			Hibernate.initialize(medio.getContacto());
		}
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerContactoMedios(pe.gob.trabajo.pcd.modelo.dominio.Contacto, pe.gob.trabajo.pcd.modelo.dominio.TipoContacto)
	 */
	public List<ContactoMedio> obtenerContactoMedios(Contacto contacto, TipoContacto tipoContacto){
		List<ContactoMedio> lista = getPersonaDAO().obtenerContactoMedios(contacto, tipoContacto);
		for(ContactoMedio medio :lista){
			Hibernate.initialize(medio.getTipoContacto());
			Hibernate.initialize(medio.getContacto());
		}
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#obtenerTipoContactos(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<TipoContacto> obtenerTipoContactos(Persona persona){
		List<TipoContacto> lista = getPersonaDAO().obtenerTipoContactos(persona);
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.servicio.comun.PersonaService#guardarContacto(pe.gob.trabajo.pcd.modelo.dominio.Contacto, java.util.Collection)
	 */
	public Contacto guardarContacto(Contacto contacto, Collection<ContactoMedio> medios){
		
//		List<ContactoMedio> medios = new ArrayList<ContactoMedio>();
//		for (ContactoMedio cm : contacto.getContactoMedios()) {
//			ContactoMedio cmNuevo = new ContactoMedio();
//			cmNuevo.setId(cm.getId());
//			cmNuevo.setContacto(contacto);
//			cmNuevo.setTipoContacto(cm.getTipoContacto());
//			cmNuevo.setValor(cm.getValor());
//			medios.add(cmNuevo);
//		}
//		contacto.setContactoMedios(null);
		getPersonaDAO().saveObject(contacto);
		
		for (ContactoMedio cm : medios) {
			cm.setContacto(contacto);
//			medios.add(cm);
		}
//		getPersonaDAO().borrarContactoMedios(medios, contacto);
		getPersonaDAO().saveCollection(contacto.getContactoMedios());
		
		logger.debug("contacto guardado");
		return contacto;
	}
	
	public Persona buscarPersona(String dni, Date fechaNacimiento, String sexo) {
		Persona personaBuscada = null;
		
		personaBuscada = buscarPorDocumentoIdentidad(null, dni);
		
		if (personaBuscada != null) {
			if (!((UtilDate.compararFecha(fechaNacimiento, personaBuscada.getFechaNacimiento())) && 
					(sexo.equals(personaBuscada.getSexo().toString())))) {
				personaBuscada = null;
			}
		} else {
			personaBuscada = null;
		}
		if (personaBuscada == null) {
			List<Person> personas = proveedorMaestroDAO.getMaestroPersonas(dni);
			for (Person p : personas) {
				if ((UtilDate.compararFecha(fechaNacimiento, p.getFechaNacimiento())) && (sexo.equals(p.getCodigoSexo()))) {
					personaBuscada = Persona.construirPersona(p);
					continue;
				}
			}			
		}
		return personaBuscada;
	}

	public List<PersonaNecesidadApoyo> obtenerNecesidadesApoyo(Persona persona) {
		List<PersonaNecesidadApoyo> lista = getPersonaDAO().obtenerNecesidadesApoyo(persona);
		return lista;
	}
	
	public List<PersonaDiscapacidad> obtenerDiscapacidades(Persona persona) {
		List<PersonaDiscapacidad> lista = getPersonaDAO().obtenerDiscapacidades(persona);
		return lista;
	}
	
	public List<PersonaIntegranteFamilia> obtenerIntegrantesFamilia(Persona persona) {
		List<PersonaIntegranteFamilia> lista = getPersonaDAO().obtenerIntegrantesFamilia(persona);
		for(PersonaIntegranteFamilia integrante:lista) {
			if(integrante != null) {
				Ocupacion ocupacion = (Ocupacion) proveedorMaestroDAO
						.findObjectByPK(integrante.getCodigoOcupacion().toString(),Ocupacion.class);
				if (ocupacion != null) {
					integrante.setDescripcionOcupacion(ocupacion.getDescripcion());
				}				
			}
		}
		return lista;
	}
	
	public List<Persona> buscarConsultores() {
		List<Persona> consultores = personaDAO.obtenerConsultores();
		return consultores;
	}

}
