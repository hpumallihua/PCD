package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pe.gob.trabajo.pcd.modelo.dao.PersonaDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ContactoMedio;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaDiscapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaIntegranteFamilia;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaNecesidadApoyo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoContacto;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;


// TODO: Auto-generated Javadoc
/**
 * The Class PersonaDAOImpl.
 */
public class PersonaDAOImpl extends GenericDaoImpl<Persona, Long>
		implements PersonaDAO {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(PersonaDAOImpl.class);

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarPorDocumentoIdentidad(java.lang.String, java.lang.String)
	 */
	public Persona buscarPorDocumentoIdentidad(String idTipo, String numero) {
		Criteria criteria = getSession().createCriteria(Persona.class);
//		criteria.createAlias("tipoDocumentoIdentidad", "tipoDoc");
//		if (idTipo != null && !idTipo.equals(0)) {
//			criteria.add(Restrictions.eq("tipoDoc.id", idTipo));
//		}
		criteria.add(Restrictions.eq("numeroDocumentoIdentidad", numero));
		try {
			Persona retorno = (Persona) criteria.uniqueResult();
			return retorno;
		} catch (HibernateException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarProfesionalPorDocumentoIdentidad(java.lang.String, java.lang.String)
	 */
	public Profesional buscarProfesionalPorDocumentoIdentidad(String idTipo, String numero) {
		Criteria criteria = getSession().createCriteria(Profesional.class);
		criteria.createAlias("persona", "persona");
//		if (idTipo != null && !idTipo.equals(0)) {
//			criteria.add(Restrictions.eq("tipoDoc.id", idTipo));
//		}
		criteria.add(Restrictions.eq("persona.numeroDocumentoIdentidad", numero));
		try {
			Profesional retorno = (Profesional) criteria.uniqueResult();
			return retorno;
		} catch (HibernateException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarPorEjemplo(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Persona> buscarPorEjemplo(Persona bean) {
		Criteria criteria = getSession().createCriteria(Persona.class);
//
//		criteria.add(Restrictions.isNotNull("idPrsna"));
//		criteria.add(Restrictions.isNotNull("dcmntoIdntdad"));
//		criteria.createAlias("postulante", "postulante");
//		criteria.add(Restrictions.isNotNull("postulante.idPrsna"));
//
//		if (bean.getAplldoPtrno() != null && !bean.getAplldoPtrno().equals("")) {
//			criteria.add(Restrictions.ilike("aplldoPtrno", "%"
//					+ bean.getAplldoPtrno().trim() + "%"));
//		}
//		if (bean.getAplldoMtrno() != null && !bean.getAplldoMtrno().equals("")) {
//			criteria.add(Restrictions.ilike("aplldoMtrno", "%"
//					+ bean.getAplldoMtrno().trim() + "%"));
//		}
//		if (bean.getNmbres() != null && !bean.getNmbres().equals("")) {
//			criteria.add(Restrictions.ilike("nmbres", "%"
//					+ bean.getNmbres().trim() + "%"));
//		}
//		if (bean.getSxo() != null && !bean.getSxo().equals(0)) {
//			criteria.add(Restrictions.eq("sxo", bean.getSxo()));
//		}
//		if (bean.getNcnldad() != null && !bean.getNcnldad().equals("")) {
//			criteria.add(Restrictions.eq("ncnldad", bean.getNcnldad()));
//		}
//		if (bean.getDrccon() != null && !bean.getDrccon().equals("")) {
//			String direccion = bean.getDrccon().toUpperCase();
//			direccion = direccion.replaceAll("A", "%");
//			direccion = direccion.replaceAll("E", "%");
//			direccion = direccion.replaceAll("I", "%");
//			direccion = direccion.replaceAll("O", "%");
//			direccion = direccion.replaceAll("U", "%");
//			direccion = "%" + direccion + "%";
//			logger.info(direccion);
//			criteria.add(Restrictions.ilike("drccon", direccion));
//		}
//		if (bean.getEstdoCvil() != null && !bean.getEstdoCvil().equals(0)) {
//			criteria.add(Restrictions.eq("estdoCvil", bean.getEstdoCvil()));
//		}
//		if (bean.getEmil() != null && !bean.getEmil().equals("")) {
//			String email = bean.getEmil().toUpperCase();
//			email = email.replaceAll("A", "%");
//			email = email.replaceAll("E", "%");
//			email = email.replaceAll("I", "%");
//			email = email.replaceAll("O", "%");
//			email = email.replaceAll("U", "%");
//			email = "%" + email + "%";
//			criteria.add(Restrictions.ilike("emil", email));
//		}
//		if (bean.getTlfno() != null && !bean.getTlfno().equals("")) {
//			String telefono = "%" + bean.getTlfno() + "%";
//			criteria.add(Restrictions.ilike("tlfno", telefono));
//		}
//		if (bean.getDcmntoIdntdad() != null && !bean.getDcmntoIdntdad().equals("")) {
//			String doc = "%" + bean.getDcmntoIdntdad() + "%";
//			criteria.add(Restrictions.ilike("dcmntoIdntdad", doc));
//		}

		criteria.addOrder(Order.asc("aplldoPtrno"));
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarUsuarioPorUsuarioClave(java.lang.String, java.lang.String)
	 */
	public Usuario buscarUsuarioPorUsuarioClave(String usuario, String clave) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nombreUsuario", usuario));
		criteria.add(Restrictions.eq("claveUsuario", clave));
		try {
			Usuario retorno = (Usuario) criteria.uniqueResult();
			if (retorno != null) {
				Hibernate.initialize(retorno.getPersona());
				Hibernate.initialize(retorno.getRol());				
			}
			return retorno;
		} catch (HibernateException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarPersonaPorDocumentoClave(java.lang.String, java.lang.String)
	 */
	public Persona buscarPersonaPorDocumentoClave(String documento, String clave) {
		Persona persona = buscarPorDocumentoIdentidad(null, documento);
		if (persona != null && persona.getFechaNacimiento() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			String claveGenerada = sdf.format(persona.getFechaNacimiento());
			if (claveGenerada.equals(clave)) {
				return persona;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarPorTexto(java.lang.String)
	 */
	public List<Persona> buscarPorTexto(String personaTexto) {
		personaTexto = personaTexto.toUpperCase();
		personaTexto = "%" + personaTexto + "%";
		
		Criteria criteria = getSession().createCriteria(Persona.class);

		criteria.add(Restrictions.isNotNull("idPrsna"));
//		criteria.add(Restrictions.isNotNull("dcmntoIdntdad"));
		criteria.createAlias("usuario", "usuario");
		criteria.createAlias("usuario.rol", "usuario.rol");
		criteria.add(Restrictions.eq("usuario.rol.idRol", Constantes.ROL_PROFESIONAL.getId()));
		
		criteria.add(Restrictions.disjunction()
						.add(Restrictions.ilike("aplldoPtrno", personaTexto))
						.add(Restrictions.ilike("aplldoMtrno", personaTexto))
						.add(Restrictions.ilike("nmbres", personaTexto))
		);
		criteria.addOrder(Order.asc("aplldoPtrno"));
//		criteria.set
		return (ArrayList<Persona>)criteria.list();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#buscarPorNombres(java.lang.String)
	 */
	public List<Persona> buscarPorNombres(String personaNombres) {
		String buscado = personaNombres.toUpperCase();
		buscado = buscado.replaceAll("A", "%");
		buscado = buscado.replaceAll("E", "%");
		buscado = buscado.replaceAll("I", "%");
		buscado = buscado.replaceAll("O", "%");
		buscado = buscado.replaceAll("U", "%");
		
		buscado = "%" + buscado + "%";
		logger.debug("\n buscado" + buscado);
		@SuppressWarnings("unchecked")
		List<Persona> lista = getSession()
				.createQuery(
						"from Persona p where concat(p.nombres, ' ',p.apellidoPaterno,' ',p.apellidoMaterno) like ? order by p.nombres")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerContactos(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Contacto> obtenerContactos(Persona persona) {
		
		String hql = "select c from Contacto c where c.persona.id = ?";
		List<Contacto> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerContactos2(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Contacto> obtenerContactos2(Persona persona) {
		String hql = "select c from Contacto c";
		List<Contacto> lista = (List<Contacto>) getSession().createQuery(hql).list();
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerContacto(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public Contacto obtenerContacto(Persona persona){
		String hql= "select c from Contacto c where c.persona.id = ?";
		Contacto contacto = (Contacto) getSession().createQuery(hql);
		return contacto;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerContactoMedios(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<ContactoMedio> obtenerContactoMedios(Persona persona){
		String hql = "select m from ContactoMedio m where m.contacto.persona.id = ?";
		List<ContactoMedio> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerTipoContactos(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<TipoContacto> obtenerTipoContactos(Persona persona){
		String hql = "select t from TipoContacto t";
		//List<TipoContacto> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		List<TipoContacto> lista = (List<TipoContacto>) getSession().createQuery(hql).list();
		return lista;		
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerContactoMedios(pe.gob.trabajo.pcd.modelo.dominio.Contacto, pe.gob.trabajo.pcd.modelo.dominio.TipoContacto)
	 */
	public List<ContactoMedio> obtenerContactoMedios(Contacto contacto, TipoContacto tipoContacto){
		String hql = "select m from ContactoMedio m where m.contacto.id = ? and m.tipoContacto.id = ?";
		List<ContactoMedio> lista = getSession().createQuery(hql)
			.setLong(0, contacto.getId())
			.setLong(1, tipoContacto.getId())
			.list();
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#borrarContactoMedios(java.util.Collection, pe.gob.trabajo.pcd.modelo.dominio.Contacto)
	 */
	public int borrarContactoMedios(Collection<ContactoMedio> medios, Contacto contacto){
		
		int retorno = -1;
		List<Long> listaId = new ArrayList<Long>();
		listaId.add(0L);
		for (ContactoMedio item : medios) {
			listaId.add(item.getId());
		}
		String hqlBorrar = "select m from ContactoMedio m where m.id not in (:ids) and m.contacto.id = :idContacto"; 
		List<ContactoMedio> listaBorrar = getSession().createQuery(hqlBorrar)
			.setLong("idContacto", contacto.getId())
			.setParameterList("ids", listaId).list();
//			.executeUpdate();
//		for (ContactoMedio cmBorrar : listaBorrar) {
//			logger.info(cmBorrar);
//		}
		for (ContactoMedio cmBorrar : listaBorrar) {
			getSession().delete(cmBorrar);
		}
		return retorno;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#eliminarDiscapacidades(java.lang.Long)
	 */
	public int eliminarDiscapacidades(Long idPersona){
		if (idPersona != null) {
			String hql = "delete from Discapacidad d where d.persona.id = ?";
			return getSession().createQuery(hql)
					.setLong(0, idPersona)
					.executeUpdate();			
		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerNecesidadesApoyo(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<PersonaNecesidadApoyo> obtenerNecesidadesApoyo(Persona persona) {
		
		String hql = "select c from PersonaNecesidadApoyo c where c.persona.id = ?";
		List<PersonaNecesidadApoyo> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerNecesidadesApoyo(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<PersonaDiscapacidad> obtenerDiscapacidades(Persona persona) {
		
		String hql = "select c from PersonaDiscapacidad c where c.persona.id = ?";
		List<PersonaDiscapacidad> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.PersonaDAO#obtenerIntegrantesFamilia(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<PersonaIntegranteFamilia> obtenerIntegrantesFamilia(Persona persona) {
		
		String hql = "select c from PersonaIntegranteFamilia c where c.persona.id = ?";
		List<PersonaIntegranteFamilia> lista = getSession().createQuery(hql).setLong(0, persona.getId()).list();
		
		return lista;
	}
	
	public List<Persona> obtenerConsultores() {
		@SuppressWarnings("unchecked")
		List<Persona> lista = getSession()
				.createQuery(
						"select u.persona from Usuario u")
				.list();
		return lista;
	}

}
