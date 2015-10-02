package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.type.Type;

import pe.gob.trabajo.pcd.modelo.dao.MaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EmpresaCopia;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa;
import pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Parametro;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.RolLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion;
import pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroDAOImpl.
 */
public class MaestroDAOImpl extends GenericDaoImpl<Object, Long> implements
		MaestroDAO {

	/** The logger. */
	private static Logger logger = Logger.getLogger(MaestroDAOImpl.class);
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
		return buscarUsuario(nombreUsuario, null);
	}
	
	public Usuario buscarUsuario(String nombreUsuario, String claveUsuario) {
		Usuario usuario = null;
		try {
			Criteria criteria = getSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
			if (claveUsuario != null && !"".equals(claveUsuario)) {
				criteria.add(Restrictions.eq("claveUsuario", claveUsuario));				
			}
			usuario = (Usuario) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorIdPersona(Long idPersona) {
		Usuario usuario = null;
		try {
			Criteria criteria = getSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("persona.id", idPersona));
			usuario = (Usuario) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return usuario;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#obtenerEmpresa(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
	 */
	public Empresa obtenerEmpresa(
			Empresa empresa) {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		criteria.add(Restrictions.ilike("nmbre", empresa.getNombreComercial(),
				MatchMode.ANYWHERE));
		Empresa emp = (Empresa) criteria
				.uniqueResult();
		return emp;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#getLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo)
	 */
	public List<Ubigeo> getLugares(
			Ubigeo lugar) {
		List<Ubigeo> lista = null;//new ArrayList<Ubigeo>();
		Criteria criteria = getSession().createCriteria(
				Ubigeo.class);

		if (lugar == null) {
			criteria.add(Restrictions.ne("idDprtmnto", "00"));
			criteria.add(Restrictions.eq("idPrvnca", "00"));
			criteria.add(Restrictions.eq("idDstrto", "00"));
		} else {
			if (lugar.isDepartamento()) {
				logger.debug("lugar.isDepartamento()");
				logger.debug("lugar.getIdDprtmnto()= "
						+ lugar.getIdDprtmnto());
				logger.debug(lugar.getIdPrvnca());
				criteria.add(Restrictions.eq("idDprtmnto",
						lugar.getIdDprtmnto()));
				criteria.add(Restrictions.ne("idPrvnca", "00"));
				criteria.add(Restrictions.eq("idDstrto", "00"));
			}

			if (lugar.isProvincia()) {
				logger.debug("lugar.isProvincia()");
				logger.debug(lugar.getIdDprtmnto());
				logger.debug(lugar.getIdPrvnca());
				criteria.add(Restrictions.eq("idDprtmnto",
						lugar.getIdDprtmnto()));
				criteria.add(Restrictions.eq("idPrvnca", lugar.getIdPrvnca()));
				criteria.add(Restrictions.ne("idDstrto", "00"));
			}
		}

		criteria.addOrder(Order.asc("nombre"));
		lista = criteria.list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarEmpresas(pe.gob.trabajo.pcd.modelo.dominio.Empresa)
	 */
	public List<Empresa> buscarEmpresas(
			Empresa empresa) {
		String buscado = empresa.getNombreComercial().toUpperCase();
		buscado = "%" + buscado + "%";
		@SuppressWarnings("unchecked")
		List<Empresa> lista = getSession()
				.createQuery(
						"from Empresa e where e.nombreComercial like ? order by e.nombreComercial")
				.setString(0, buscado).setMaxResults(new Integer(UtilBean.getParametrosMap().get("MAXIMO_ELEMENTOS_BUSQUEDA").toString())).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarPersonas(pe.gob.trabajo.pcd.modelo.dominio.Persona)
	 */
	public List<Persona> buscarPersonas(
			Persona persona) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(persona
				.getApellidoPaterno());
		@SuppressWarnings("unchecked")
		List<Persona> lista = getSession()
				.createQuery(
						"from Persona p where p.apellidoPaterno like ? order by p.apellidoPaterno")
				.setString(0, buscado).setMaxResults(new Integer(UtilBean.getParametrosMap().get("MAXIMO_ELEMENTOS_BUSQUEDA").toString())).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarEspecialidades(pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional)
	 */
	public List<EspecialidadProfesional> buscarEspecialidades(
			EspecialidadProfesional especialidad) {
		String buscado = UtilBean
				.transformarCriterioBusquedaSimple(especialidad
						.getDescripcion());
		@SuppressWarnings("unchecked")
		List<EspecialidadProfesional> lista = getSession()
				.createQuery(
						"from EspecialidadProfesional e where e.descripcion like ? order by e.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarPuestos(pe.gob.trabajo.pcd.modelo.dominio.RolLaboral)
	 */
	public List<RolLaboral> buscarPuestos(RolLaboral puesto) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(puesto
				.getDescripcion());
		@SuppressWarnings("unchecked")
		List<RolLaboral> lista = getSession()
				.createQuery(
						"from RolLaboral r where r.descripcion like ? order by r.descripcion")
				.setString(0, buscado).list();
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarAreas(pe.gob.trabajo.pcd.modelo.dominio.Area)
	 */
	public List<Area> buscarAreas(Area area) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(area.getDescripcion());
		@SuppressWarnings("unchecked")
		List<Area> lista = getSession()
		.createQuery(
				"from Area a where a.descripcion like ? order by a.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarSectores(pe.gob.trabajo.pcd.modelo.dominio.Sector)
	 */
	public List<Sector> buscarSectores(Sector sector) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(sector
				.getDescripcion());
		@SuppressWarnings("unchecked")
		List<Sector> lista = getSession()
				.createQuery(
						"from Sector s where s.descripcion like ? order by s.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarCampoEstudio(java.lang.String)
	 */
	public List<String> buscarCampoEstudio(String campo) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(campo);
		@SuppressWarnings("unchecked")
		List<String> lista = getSession()
				.createQuery(
						"select distinct f.campoEstudio from Formacion f where f.campoEstudio like ? order by f.campoEstudio")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarLugares(pe.gob.trabajo.pcd.modelo.dominio.Ubigeo)
	 */
	public List<Ubigeo> buscarLugares(
			Ubigeo lugar) {
		String buscado = lugar.getNombre().toUpperCase();
		// buscado = buscado.replaceAll("A", "_");
		// buscado = buscado.replaceAll("E", "_");
		// buscado = buscado.replaceAll("I", "_");
		// buscado = buscado.replaceAll("O", "_");
		// buscado = buscado.replaceAll("U", "_");
		buscado = buscado + "%";
//		logger.debug("\n buscado" + buscado);
		@SuppressWarnings("unchecked")
		List<Ubigeo> lista = getSession()
				.createQuery(
						"select u from Ubigeo u where u.nombre like ? order by u.nombre")
				.setString(0, buscado)
				.setMaxResults(Constantes.MAXIMO_ELEMENTOS_AUTOCOMPLETADO)
				.list();
		for (Ubigeo itemLugar : lista) {
			itemLugar = obtenerUbigeo(itemLugar);
		}
		return lista;
	}
	
	/**
	 * Obtener ubigeo.
	 *
	 * @param ubigeo the ubigeo
	 * @return the ubigeo
	 */
	private Ubigeo obtenerUbigeo(Ubigeo ubigeo) {
//		Ubigeo ubigeoDestino = ubigeo;
		Ubigeo ubigeoProvincia = null;
		Ubigeo ubigeoRegion = null;
		if (ubigeo.isDistrito()) {
			ubigeoProvincia = (Ubigeo) getSession()
			.createQuery("select u from Ubigeo u where u.idDprtmnto = ? and u.idPrvnca = ? and u.idDstrto = '00'")
			.setString(0, ubigeo.getIdDprtmnto())
			.setString(1, ubigeo.getIdPrvnca())			
			.uniqueResult();
		}
		ubigeoRegion = (Ubigeo) getSession()
		.createQuery("select u from Ubigeo u where u.idDprtmnto = ? and u.idPrvnca = '00' and u.idDstrto = '00'")
		.setString(0, ubigeo.getIdDprtmnto())		
		.uniqueResult();
		
		Ubigeo itemProvincia = new Ubigeo();
		if (ubigeoProvincia != null) {
			itemProvincia.setNombre(ubigeoProvincia.getNombre());			
		}
		
		Ubigeo itemRegion = new Ubigeo();
		itemRegion.setNombre(ubigeoRegion.getNombre());
		
		
		ubigeo.setUbigeoProvincia(itemProvincia);
		ubigeo.setUbigeoRegion(itemRegion);
		return ubigeo;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarPuestos(pe.gob.trabajo.pcd.modelo.dominio.Puesto)
	 */
	public List<Puesto> buscarPuestos(Puesto puesto) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(puesto
				.getDescripcion());
		@SuppressWarnings("unchecked")
		List<Puesto> lista = getSession()
				.createQuery(
						"from Puesto p where p.descripcion like ? order by p.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarTipoReferencia(pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia)
	 */
	public List<TipoReferencia> buscarTipoReferencia(
			TipoReferencia tipoReferencia) {
		String buscado = UtilBean
				.transformarCriterioBusquedaSimple(tipoReferencia
						.getDescripcion());
		@SuppressWarnings("unchecked")
		List<TipoReferencia> lista = getSession()
				.createQuery(
						"from TipoReferencia t where t.descripcion like ? order by t.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarRoles(pe.gob.trabajo.pcd.modelo.dominio.RolLaboral)
	 */
	public List<RolLaboral> buscarRoles(RolLaboral rol) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(rol
				.getDescripcion());
		@SuppressWarnings("unchecked")
		List<RolLaboral> lista = getSession()
				.createQuery(
						"from RolLaboral r where r.descripcion like ? order by r.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarInstitucionesFormativas(pe.gob.trabajo.pcd.modelo.dominio.InstitucionFormativa)
	 */
	public List<InstitucionFormativa> buscarInstitucionesFormativas(
			InstitucionFormativa institucionFormativa) {
		String buscado = UtilBean
				.transformarCriterioBusquedaSimple(institucionFormativa
						.getDescripcion());
		@SuppressWarnings("unchecked")
		List<InstitucionFormativa> lista = getSession()
				.createQuery(
						"from InstitucionFormativa i where i.descripcion like ? order by i.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarEstudio(java.lang.String)
	 */
	public List<String> buscarEstudio(String estudio) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(estudio);
		@SuppressWarnings("unchecked")
		List<String> lista = getSession()
				.createQuery(
						"select distinct f.descripcion from Formacion f where f.descripcion like ? order by f.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarTiposFormacion(pe.gob.trabajo.pcd.modelo.dominio.TipoFormacion)
	 */
	public List<TipoFormacion> buscarTiposFormacion(TipoFormacion tipoFormacion) {
		String buscado = UtilBean
				.transformarCriterioBusquedaSimple(tipoFormacion
						.getDescripcion());
		@SuppressWarnings("unchecked")
		List<TipoFormacion> lista = getSession()
				.createQuery(
						"from TipoFormacion t where t.descripcion like ? order by t.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarNivelFormacion(pe.gob.trabajo.pcd.modelo.dominio.NivelFormacion)
	 */
	public List<NivelFormacion> buscarNivelFormacion(
			NivelFormacion nivelFormacion) {
		String buscado = UtilBean
				.transformarCriterioBusquedaSimple(nivelFormacion
						.getValor());
		@SuppressWarnings("unchecked")
		List<NivelFormacion> lista = getSession()
				.createQuery(
						"from NivelFormacion nf where nf.valor like ? order by nf.valor")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarIdioma(pe.gob.trabajo.pcd.modelo.dominio.Idioma)
	 */
	public List<Idioma> buscarIdioma(Idioma idioma) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(idioma
				.getDescripcion());
		@SuppressWarnings("unchecked")
		List<Idioma> lista = getSession()
				.createQuery(
						"from Idioma i where i.descripcion like ? order by i.descripcion")
				.setString(0, buscado).list();
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#buscarNivelIdioma(pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma)
	 */
	public List<NivelIdioma> buscarNivelIdioma(NivelIdioma nivelIdioma) {
		String buscado = UtilBean.transformarCriterioBusquedaSimple(nivelIdioma
				.getValor());
		@SuppressWarnings("unchecked")
		List<NivelIdioma> lista = getSession()
				.createQuery(
						"from NivelIdioma ni where ni.valor like ? order by ni.valor")
				.setString(0, buscado).list();
		return lista;
	}

	/**
	 * Gets the ciudades.
	 *
	 * @return the ciudades
	 */
	public List<Ubigeo> getCiudades() {
		List<Ubigeo> lista = null;

		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#getRucEmpresasRegistradas()
	 */
	public List<?> getRucEmpresasRegistradas() {
		List<String> lista = getSession().createQuery("select e.ruc from Empresa e").list();

//		while ( results.hasNext() ) {
//		    String ruc = results.next();
//		}
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#estaRegistrada(java.lang.String)
	 */
	public Boolean estaRegistrada(String ruc) {
		boolean registrada = false;
		List<Empresa> empresas = getSession().createQuery("select e from Empresa e where e.ruc = ?").setString(0, ruc).list();
		if (empresas != null && empresas.size() > 0) {
			registrada = true;
		}

//		while ( results.hasNext() ) {
//		    String ruc = results.next();
//		}
		return registrada;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#actualizarListaEmpresas()
	 */
	public Integer actualizarListaEmpresas() {
		Integer resultado = 0;
//		String hqlInsert = 	"";
//			INSERT INTO [Silnet].[dbo].[TIPRM_EMPRESA]
//	                 ([NMBRE]
//	                 ,[RUC]
//	                 ,[UBGO]
//	                 ,[DRCCON]
//	                 ,[GRO]
//	                 
//	                 ,[ESTDO_RGSTRO])
//	        SELECT e.[E_NOMBRE]
//	            ,e.[RUC]
//	            ,e.[E_UBIGEO]
//	            ,e.[E_DIRECCION]
//	            ,e.[E_GIRO]
//	            ,'A'
//	        FROM [Silnet].[dbo].[TMP_EMPRESA] e
//	        WHERE e.ruc not in (SELECT emp.ruc FROM TIPRM_EMPRESA emp)
		
//		hqlInsert = 	"	insert into Empresa (" + 
//							"						nombre			" + 
//							"						,ruc			" + 
//							"						,ubigeo			" + 
//							"						,direccion		" + 
//							"						,giro)			" + 
//							"				select 	c.nombre, c.ruc, c.ubigeo, c.direccion, c.giro" + 
//							"				from EmpresaCopia c " + 
//							"				where c.ruc not in (select emp.ruc from Empresa emp)";
//		
		
//		hqlInsert = 	"	insert into Empresa (" + 
//							"						nombre			" + 
//							"						,ruc			" + 
//							"						,ubigeo			" + 
//							"						,direccion		" + 
//							"						,giro)			" + 
//							"				select 	copia.nombre, copia.ruc, copia.ubigeo, copia.direccion, copia.giro" + 
//							"				from EmpresaCopia copia " + 
//							"				left join Empresa emp on copia.ruc = emp.ruc" +
//							"				where emp.ruc is null"; 
//							"				where not exists (select copia.ruc, emp.ruc from Empresa emp where copia.ruc = emp.ruc)";
//		logger.debug(hqlInsert);
//		resultado = getSession().createQuery( hqlInsert ).executeUpdate();

//		INSERT INTO [Silnet].[dbo].[TIPRM_EMPRESA]
//                 ([NMBRE]
//                 ,[RUC]
//                 ,[UBGO]
//                 ,[DRCCON]
//                 ,[GRO]
//                 
//                 ,[ESTDO_RGSTRO])
//        SELECT e.[E_NOMBRE]
//            ,e.[RUC]
//            ,e.[E_UBIGEO]
//            ,e.[E_DIRECCION]
//            ,e.[E_GIRO]
//            ,'A'
//        FROM [Silnet].[dbo].[TMP_EMPRESA] e
//        WHERE e.ruc not in (SELECT emp.ruc FROM TIPRM_EMPRESA emp)
		String sqlInsert = 	"	INSERT INTO " + getNombreTablaBD(Empresa.class) + " (" + 
							"						 " + getNombreCampoBD(Empresa.class, "nombre") + 
							"						," + getNombreCampoBD(Empresa.class, "ruc") + 
							"						," + getNombreCampoBD(Empresa.class, "ubigeo") + 
							"						," + getNombreCampoBD(Empresa.class, "direccion") + 
							"						," + getNombreCampoBD(Empresa.class, "giro") + 
							"						," + getNombreCampoBD(Empresa.class, "estadoRegistro") + ")	" + 
							"				SELECT		 			" + 
							"						 e." + getNombreCampoBD(EmpresaCopia.class, "nombre") + 
							"						,e." + getNombreCampoBD(EmpresaCopia.class, "ruc") + 
							"						,e." + getNombreCampoBD(EmpresaCopia.class, "ubigeo") + 
							"						,e." + getNombreCampoBD(EmpresaCopia.class, "direccion") +
							"						,e." + getNombreCampoBD(EmpresaCopia.class, "giro") + 
							"						,'A'			" + 
							"				from " + getNombreTablaBD(EmpresaCopia.class) + " e " + 
							"				where not exists (SELECT emp."+ getNombreCampoBD(Empresa.class, "ruc") + 
							" 									FROM " + getNombreTablaBD(Empresa.class) + " emp " + 
							"									WHERE e." + getNombreCampoBD(EmpresaCopia.class, "ruc") +" = emp." + getNombreCampoBD(Empresa.class, "ruc") + ")";
//		logger.debug(sqlInsert);
		resultado = getSession(false).createSQLQuery(sqlInsert).executeUpdate();
		logger.debug(resultado + " filas insertadas");
//		logger.debug("Empresa =======>");
//		logger.debug(getNombreTablaBD(Empresa.class));
//		logger.debug(getNombreCampoBD(Empresa.class, "nombre"));
//		logger.debug(getNombreCampoBD(Empresa.class, "ruc"));
//		logger.debug(getNombreCampoBD(Empresa.class, "ubigeo"));
//		logger.debug(getNombreCampoBD(Empresa.class, "direccion"));
//		logger.debug(getNombreCampoBD(Empresa.class, "giro"));
		return resultado;
	}
	
	/**
	 * Actualizar lista empresas3.
	 *
	 * @return the integer
	 */
	public Integer actualizarListaEmpresas3() {
		ClassMetadata catMeta = getSessionFactory().getClassMetadata(Empresa.class);
		Empresa empresa = new Empresa();
		Object[] propertyValues = catMeta.getPropertyValues(empresa, EntityMode.POJO);
		String[] propertyNames = catMeta.getPropertyNames();
		Type[] propertyTypes = catMeta.getPropertyTypes();
		catMeta.toString();

		// get a Map of all properties which are not collections or associations
		Map namedValues = new HashMap();
		for ( int i=0; i<propertyNames.length; i++ ) {
		    if ( !propertyTypes[i].isEntityType() && !propertyTypes[i].isCollectionType() ) {
		        namedValues.put( propertyNames[i], propertyValues[i] );
//		        logger.debug("Nombre: " + propertyNames[i]);
//		        logger.debug("Valor: " + propertyValues[i]);
		    }
		}
		
		getDbCellName(Empresa.class);
//		logger.debug("Empresa =======>");
//		logger.debug(getNombreTablaBD(Empresa.class));
//		logger.debug(getNombreCampoBD(Empresa.class, "nombre"));
//		logger.debug(getNombreCampoBD(Empresa.class, "ruc"));
//		logger.debug(getNombreCampoBD(Empresa.class, "ubigeo"));
//		logger.debug(getNombreCampoBD(Empresa.class, "direccion"));
//		logger.debug(getNombreCampoBD(Empresa.class, "giro"));
		return null;
	}
	
	 /**
 	 * Gets the nombre tabla bd.
 	 *
 	 * @param clazz the clazz
 	 * @return the nombre tabla bd
 	 */
 	public String getNombreTablaBD(Class clazz) {
		 SessionFactory factory = getHibernateTemplate().getSessionFactory();  
		 Class cls = clazz;  
		 AbstractEntityPersister classMetadata = (SingleTableEntityPersister) factory  
		 .getClassMetadata(cls);  
		 return classMetadata.getTableName();  
	}
	
	 /**
 	 * Gets the nombre campo bd.
 	 *
 	 * @param clazz the clazz
 	 * @param atributo the atributo
 	 * @return the nombre campo bd
 	 */
 	public String getNombreCampoBD(Class clazz, String atributo){
		 String resultado = "";
		 SessionFactory factory = getHibernateTemplate().getSessionFactory();
		 AbstractEntityPersister classMetadata = (SingleTableEntityPersister) factory.getClassMetadata(clazz);
		 boolean isCollection = classMetadata.getClassMetadata()  
		 .getPropertyType(atributo).isCollectionType();  
		 if (!isCollection) {  
			 String[] propertyColumnNames = classMetadata  
			 .getPropertyColumnNames(atributo);  
			 for (String columnName : propertyColumnNames) {  
//				 logger.debug(columnName);
				 resultado = columnName;
			 }  
		 }
		 return resultado;
	 }
	
	/**
	 * Gets the db cell name.
	 *
	 * @param objClass the obj class
	 * @return the db cell name
	 */
	public List<String> getDbCellName(Class objClass) {  
        List<String> resultList = new ArrayList<String>();  
        SessionFactory factory = getHibernateTemplate().getSessionFactory();  
        Class cls = objClass;  
        AbstractEntityPersister classMetadata = (SingleTableEntityPersister) factory  
                .getClassMetadata(cls);  
        //
        resultList.addAll(Arrays.asList(classMetadata  
                .getIdentifierColumnNames()));  
        String[] propertyNames = classMetadata.getPropertyNames();  
        for (String propertyName : propertyNames) {  
            //
            boolean isCollection = classMetadata.getClassMetadata()  
                    .getPropertyType(propertyName).isCollectionType();  
            if (!isCollection) {  
                String[] propertyColumnNames = classMetadata  
                        .getPropertyColumnNames(propertyName);  
                for (String columnName : propertyColumnNames) {  
                    resultList.add(columnName);  
                }  
            }  
        }  
        return resultList;  
    }  
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#borrarRegistrosEmpresas()
	 */
	public Integer borrarRegistrosEmpresas() {
		Integer resultado = 0;
//				getSession().createQuery( "delete from EmpresaCopia" ).executeUpdate();
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.MaestroDAO#getParametro(java.lang.String)
	 */
	public Parametro getParametro(String parametro) {
		Parametro retorno = null;
		try {
			retorno = (Parametro) getSession().createQuery("from Parametro p where p.nombre = ?").setString(0, parametro).uniqueResult();			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return retorno;
	}
}
