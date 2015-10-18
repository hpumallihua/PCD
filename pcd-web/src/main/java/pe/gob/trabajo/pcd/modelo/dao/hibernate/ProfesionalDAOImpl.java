package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Capacitacion;
import pe.gob.trabajo.pcd.modelo.dominio.Certificacion;
import pe.gob.trabajo.pcd.modelo.dominio.Conocimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Contacto;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaEspecialidad;
import pe.gob.trabajo.pcd.modelo.dominio.ExperienciaLaboral;
import pe.gob.trabajo.pcd.modelo.dominio.Formacion;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Preferencia;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProfesionalIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.servicio.util.UtilDate;
import pe.gob.trabajo.pcd.vista.bean.ReporteE1;
import pe.gob.trabajo.pcd.vista.bean.ReporteE2;
import pe.gob.trabajo.pcd.vista.bean.ReporteE3;
import pe.gob.trabajo.pcd.vista.bean.ReporteE4;
import pe.gob.trabajo.pcd.vista.bean.ReporteOferta;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfesionalDAOImpl.
 */
public class ProfesionalDAOImpl extends GenericDaoImpl<Profesional, Long>implements ProfesionalDAO {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ProfesionalDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarProfesional(java
	 * .util.HashMap, java.lang.Object)
	 */
	public List<Profesional> buscarProfesional(HashMap<String, Object> criterios, Object o) {
		Criteria criteria = getSession().createCriteria(Profesional.class);
		criteria.setProjection(Projections.groupProperty("experienciasLaborales"));
		return null;
	}

	/**
	 * Crear disjuncion like.
	 * 
	 * @param atributo
	 *            the atributo
	 * @param valores
	 *            the valores
	 * @return the disjunction
	 */
	private Disjunction crearDisjuncionLike(String atributo, Collection<?> valores) {
		Disjunction disjunction = Restrictions.disjunction();
		for (Object valor : valores) {
			valor = UtilBean.transformarCriterioBusquedaSimple((String) valor);
			Criterion esp = Restrictions.ilike(atributo, (String) valor, MatchMode.ANYWHERE);
			disjunction.add(esp);
		}
		return disjunction;
	}

	private Disjunction crearDisjuncion(String atributo, Collection<?> valores) {
		Disjunction disjunction = Restrictions.disjunction();
		for (Object valor : valores) {
			// valor = UtilBean.transformarCriterioBusquedaSimple((String)
			// valor);
			Criterion esp = Restrictions.eq(atributo, (String) valor);
			disjunction.add(esp);
		}
		return disjunction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarProfesional(java
	 * .util.List)
	 */
	public List<Profesional> buscarProfesional(List<?> ids) {
		Criteria criteria = getSession().createCriteria(Profesional.class);
		criteria.createAlias("persona", "persona");
		criteria.add(Restrictions.in("persona.numeroDocumentoIdentidad", ids));
		return (ArrayList<Profesional>) criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarProfesional(java
	 * .util.HashMap, java.util.List)
	 */
	public List<Profesional> buscarProfesional(HashMap<String, HashMap<String, List<?>>> criterios, List<?> ids) {

		Criteria criteria = getSession().createCriteria(Profesional.class);
		// criteria.add(Restrictions.isNotNull("id"));

		// persona
		criteria.createAlias("persona", "persona", Criteria.LEFT_JOIN);

		if (criterios.containsKey("especialidad")) {
			// experiencia en la especialidad
			// criteria.createAlias("experienciasEspecialidad",
			// "experienciaEspecialidad",Criteria.LEFT_JOIN);
			// criteria.createAlias("experienciasEspecialidad.especialidadProfesional",
			// "especialidad",Criteria.LEFT_JOIN);
			criteria.createAlias("experienciasEspecialidad", "especialidad", Criteria.LEFT_JOIN);
		}
		if (criterios.containsKey("puesto") || criterios.containsKey("rol") || criterios.containsKey("empresa")
				|| criterios.containsKey("sector")) {
			// experiencia laboral
			criteria.createAlias("experienciasLaborales", "experienciaLaboral", Criteria.LEFT_JOIN);

			// if (criterios.containsKey("puesto")) {
			// criteria.createAlias("experienciaLaboral.puesto",
			// "puesto",Criteria.LEFT_JOIN);
			// }
			// if (criterios.containsKey("rol")) {
			// criteria.createAlias("experienciaLaboral.rolLaboral",
			// "rol",Criteria.LEFT_JOIN);
			// }
			if (criterios.containsKey("empresa")) {
				criteria.createAlias("experienciaLaboral.empresa", "empresa", Criteria.LEFT_JOIN);
			}
			// if (criterios.containsKey("sector")) {
			// criteria.createAlias("experienciaLaboral.sector",
			// "sector",Criteria.LEFT_JOIN);
			// }
		}
		if (criterios.containsKey("tipoFormacion") || criterios.containsKey("nivelFormacion")
				|| criterios.containsKey("camposEstudio")) {
			// formacion
			criteria.createAlias("formaciones", "formacion", Criteria.LEFT_JOIN);
			// criteria.createAlias("formacion.tipoFormacion",
			// "tipoFormacion",Criteria.LEFT_JOIN);
		}
		if (criterios.containsKey("idiomas") || criterios.containsKey("nivelIdioma")) {
			// idiomas
			criteria.createAlias("idiomas", "idiomaProfesional", Criteria.LEFT_JOIN);
			criteria.createAlias("idiomaProfesional.idioma", "idioma", Criteria.LEFT_JOIN);
		}

		// if (criterios.containsKey("preferencias")) {
		// // preferencias
		// criteria.createAlias("preferencias", "preferencia",
		// Criteria.LEFT_JOIN);
		// }

		Disjunction disjunctionQuery = Restrictions.disjunction();

		Conjunction conjunctionQuery = Restrictions.conjunction();
		Iterator it = criterios.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			// logger.info(e.getKey() + " " + e.getValue());
			HashMap<String, List<?>> campoValores = (HashMap<String, List<?>>) e.getValue();

			if (e.getKey().toString().equals("especialidad")) {
				// Disjunction disjunction =
				// crearDisjuncionLike("especialidad.descripcion",
				// campoValores.get("descripcion"));
				// Disjunction disjunction =
				// crearDisjuncionLike("especialidad.descripcion",
				// campoValores.get("descripcion"));
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.in("especialidad.idOcupacion", campoValores.get("descripcion")));
				conjunctionQuery.add(disjunction);
			}
			if (e.getKey().toString().equals("rol")) {
				Disjunction djOcupacionEmpleo = Restrictions.disjunction();
				djOcupacionEmpleo.add(Restrictions.in("experienciaLaboral.idOcupacion", campoValores.get("rol")));
				conjunctionQuery.add(djOcupacionEmpleo);

				// Disjunction djRol = crearDisjuncionLike("rol.descripcion",
				// campoValores.get("rol"));
				// conjunctionQuery.add(djRol);
				// // criteria.add(Restrictions.in("rol.descripcion",
				// campoValores.get("rol")));
			}
			if (e.getKey().toString().equals("puesto")) {
				Disjunction djPuesto = Restrictions.disjunction();
				djPuesto.add(Restrictions.in("experienciaLaboral.cargo", campoValores.get("puesto")));
				conjunctionQuery.add(djPuesto);

				// Disjunction djPuesto =
				// crearDisjuncionLike("puesto.descripcion",
				// campoValores.get("puesto"));
				// conjunctionQuery.add(djPuesto);
				// // criteria.add(Restrictions.in("puesto.descripcion",
				// campoValores.get("puesto")));
			}
			if (e.getKey().toString().equals("empresa")) {
				conjunctionQuery.add(Restrictions.in("empresa.nombreComercial", campoValores.get("nombre")));
			}
			if (e.getKey().toString().equals("sector")) {
				Disjunction djSector = Restrictions.disjunction();
				djSector.add(Restrictions.in("experienciaLaboral.idSector", campoValores.get("descripcion")));
				conjunctionQuery.add(djSector);

				// conjunctionQuery.add(Restrictions.in("sector.descripcion",
				// campoValores.get("descripcion")));
			}
			if (e.getKey().toString().equals("tipoFormacion")) {
				Disjunction djProfesion = Restrictions.disjunction();
				djProfesion.add(Restrictions.in("formacion.idProfesion", campoValores.get("descripcion")));
				conjunctionQuery.add(djProfesion);
				// conjunctionQuery.add(Restrictions.in("tipoFormacion.descripcion",
				// campoValores.get("descripcion")));
			}
			if (e.getKey().toString().equals("nivelFormacion")) {
				Disjunction djNivel = Restrictions.disjunction();
				djNivel.add(Restrictions.in("formacion.idNivel", campoValores.get("nivelFormacion")));
				conjunctionQuery.add(djNivel);
				// conjunctionQuery.add(Restrictions.in("formacion.nivel",
				// campoValores.get("nivelFormacion")));
			}
			if (e.getKey().toString().equals("camposEstudio")) {
				conjunctionQuery.add(Restrictions.in("formacion.campoEstudio", campoValores.get("camposEstudio")));
			}
			if (e.getKey().toString().equals("idiomas")) {
				conjunctionQuery.add(Restrictions.in("idioma.descripcion", campoValores.get("descripcion")));
			}
			if (e.getKey().toString().equals("nivelIdioma")) {
				conjunctionQuery.add(Restrictions.in("idiomaProfesional.overall", campoValores.get("nivelIdioma")));
			}

			if (e.getKey().toString().equals("fechaNacimiento")) {
				List<Calendar[]> valor = (List<Calendar[]>) campoValores.get("fechaNacimiento");
				if (valor != null && !valor.isEmpty()) {
					Calendar[] rangoFechaNacimiento = valor.get(0);

					if (rangoFechaNacimiento != null) {
						Calendar fechaSuperior = rangoFechaNacimiento[0];
						Calendar fechaInferior = rangoFechaNacimiento[1];
						if (fechaInferior != null && fechaSuperior != null) {
							conjunctionQuery.add(Restrictions.between("persona.fechaNacimiento",
									fechaInferior.getTime(), fechaSuperior.getTime()));
						} else {
							if (rangoFechaNacimiento[1] != null) {
								conjunctionQuery.add(
										Restrictions.ge("persona.fechaNacimiento", rangoFechaNacimiento[1].getTime()));
							}
							if (rangoFechaNacimiento[0] != null) {
								conjunctionQuery.add(
										Restrictions.le("persona.fechaNacimiento", rangoFechaNacimiento[0].getTime()));
							}
						}
					}
				}
			}

			if (e.getKey().toString().equals("profesional")) {
				List<Profesional> valor = (List<Profesional>) campoValores.get("profesional");
				if (valor != null && !valor.isEmpty()) {
					Profesional profesionalBean = valor.get(0);

					if (profesionalBean != null) {

						// Disponibilidad de tiempo
						if (profesionalBean.getDisponibilidadTiempo() != null
								&& !profesionalBean.getDisponibilidadTiempo().equals(0)) {
							conjunctionQuery.add(
									Restrictions.ge("disponibilidadTiempo", profesionalBean.getDisponibilidadTiempo()));
						}
						// Disponibilidad de contratacion
						if (profesionalBean.getDisponibilidadContratacion() != null) {
							conjunctionQuery.add(Restrictions.eq("disponibilidadContratacion",
									profesionalBean.getDisponibilidadContratacion()));
						}

						if (profesionalBean.getPersona() != null) {

							// Nacionalidad
							if (profesionalBean.getPersona().getNacionalidad() != null
									&& !profesionalBean.getPersona().getNacionalidad().equals("0")) {
								conjunctionQuery.add(Restrictions.eq("persona.nacionalidad",
										profesionalBean.getPersona().getNacionalidad()));
							}
							// Ciudad
							// if (profesionalBean.getPersona()
							// .getLugarResidencia() != null
							// && profesionalBean.getPersona()
							// .getLugarResidencia().getNombre() != null
							// && !profesionalBean.getPersona()
							// .getLugarResidencia().getNombre()
							// .equals("")) {
							// String[] lugares = profesionalBean.getPersona()
							// .getLugarResidencia().getNombre()
							// .split(Constantes.SEPARADOR_CRITERIOS_CV);
							// List<String> listaLugares = new
							// ArrayList<String>();
							// for (int i = 0; i < lugares.length; i++) {
							// listaLugares.add(lugares[i]);
							// }
							//
							// Unico caso de lugar de residencia
							// criteria.createAlias("persona.distritoResidencia",
							// "distritoResidencia", Criteria.LEFT_JOIN);

							// Disjunction disjunction = crearDisjuncionLike(
							// "persona.distritoResidencia", listaLugares);
							// conjunctionQuery.add(disjunction);
							// criteria.add(Restrictions.ilike("lugarResidencia.nombre",
							// buscado, MatchMode.ANYWHERE));
							// }
							// Sexo
							if (profesionalBean.getPersona().getSexo() != null
									&& !profesionalBean.getPersona().getSexo().equals(0)) {
								conjunctionQuery
										.add(Restrictions.eq("persona.sexo", profesionalBean.getPersona().getSexo()));
							}
							// Estado civil
							if (profesionalBean.getPersona().getEstadoCivil() != null
									&& !profesionalBean.getPersona().getEstadoCivil().equals(0)) {
								conjunctionQuery.add(Restrictions.eq("persona.estadoCivil",
										profesionalBean.getPersona().getEstadoCivil()));
							}

						}

					}

				}
			}
			// Busqueda por lugar de residencia
			if (e.getKey().toString().equals("lugaresResidencia")) {
				List<String> listaLugares = (List<String>) campoValores.get("ciudades");

				Disjunction disjunction = Restrictions.disjunction();
				for (String valor : listaLugares) {
					String idDep = valor.substring(0, 2);
					String idProv = valor.substring(2, 4);
					String idDis = valor.substring(4);
					Conjunction conjuntion = Restrictions.conjunction();
					conjuntion.add(Restrictions.eq("persona.departamentoResidencia", idDep));
					conjuntion.add(Restrictions.eq("persona.provinciaResidencia", idProv));
					conjuntion.add(Restrictions.eq("persona.distritoResidencia", idDis));
					disjunction.add(conjuntion);
				}
				conjunctionQuery.add(disjunction);
			}
		}
		disjunctionQuery.add(Restrictions.in("persona.numeroDocumentoIdentidad", ids));
		disjunctionQuery.add(conjunctionQuery);

		criteria.add(disjunctionQuery);
		//
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("persona.apellidoPaterno"));
		// Query q = getSession().createQuery("from Profesional");
		// getSession().enableFilter("filtroCurriculum");
		// return q.list();
		return (ArrayList<Profesional>) criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarPreferenciasArea
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Area> buscarPreferenciasArea(Profesional profesional) {
		String hql = "select a from Preferencia p, Area a where p.id.idPrfrnca = a.id and p.id.idPrfsnal = ? and p.id.idTpoPrfrnca = ?";
		List<Area> lista = getSession().createQuery(hql).setLong(0, profesional.getId())
				.setLong(1, Constantes.TIPO_PREFERENCIA_AREA.getId()).list();
		return lista;
	}

	// public List<Sector> buscarPreferenciasSector(Profesional profesional) {
	// String hql =
	// "select s from Preferencia p, Sector s where p.id.idPrfrnca = s.id and
	// p.id.idPrfsnal = ? and p.id.idTpoPrfrnca = ?";
	// List<Sector> lista = getSession().createQuery(hql)
	// .setLong(0, profesional.getId())
	// .setLong(1, Constantes.TIPO_PREFERENCIA_SECTOR.getId())
	// .list();
	// return lista;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarPreferenciasCiudad
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Ubigeo> buscarPreferenciasCiudad(Profesional profesional) {
		String hql = "select u from Preferencia p, Ubigeo u where p.id.idPrfrnca = u.id and p.id.idPrfsnal = ? and p.id.idTpoPrfrnca = ?";
		List<Ubigeo> lista = getSession().createQuery(hql).setLong(0, profesional.getId())
				.setLong(1, Constantes.TIPO_PREFERENCIA_CIUDAD.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarReferencias(pe
	 * .gob.trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Referencia> buscarReferencias(Profesional profesional) {
		String hql = "select r from Referencia r";
		List<Referencia> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerIdiomas(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<ProfesionalIdioma> obtenerIdiomas(Profesional profesional) {
		String hql = "select pi from ProfesionalIdioma pi where pi.profesional.id = ? order by pi.nativo desc, pi.overall desc";
		List<ProfesionalIdioma> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerCertificaciones
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<Certificacion> obtenerCertificaciones(Profesional profesional) {
		String hql = "select c from Certificacion c where c.profesional.id = ?";
		List<Certificacion> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerReferencias(pe
	 * .gob.trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Referencia> obtenerReferencias(Profesional profesional) {
		String hql = "select r from Referencia r where r.profesional.id = ?";
		List<Referencia> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#
	 * obtenerExperienciaEspecialidad
	 * (pe.gob.trabajo.pcd.modelo.dominio.Profesional)
	 */
	public List<ExperienciaEspecialidad> obtenerExperienciaEspecialidad(Profesional profesional) {
		String hql = "select ex from ExperienciaEspecialidad ex where ex.profesional.id = ?";
		List<ExperienciaEspecialidad> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerEmpleos(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<ExperienciaLaboral> obtenerEmpleos(Profesional profesional) {

		String hql = "select e from ExperienciaLaboral e where e.profesional.id = ? order by e.principal desc, e.termino desc";
		ArrayList<ExperienciaLaboral> lista = (ArrayList<ExperienciaLaboral>) getSession().createQuery(hql)
				.setLong(0, profesional.getId()).list();

		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerContactos(pe.
	 * gob.trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Contacto> obtenerContactos(Profesional profesional) {

		String hql = "select c from Contacto c where c.persona.id = ?";
		List<Contacto> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerEstudios(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Formacion> obtenerEstudios(Profesional profesional) {
		String hql = "select f from Formacion f where f.profesional.id = ?";
		List<Formacion> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerEstudios(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Capacitacion> obtenerCapacitaciones(Profesional profesional) {
		String hql = "select f from Capacitacion f where f.profesional.id = ?";
		List<Capacitacion> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerEstudios(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Conocimiento> obtenerConocimientos(Profesional profesional) {
		String hql = "select f from Conocimiento f where f.profesional.id = ?";
		List<Conocimiento> lista = getSession().createQuery(hql).setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#borrarPreferencias(java
	 * .util.List, java.lang.Long, java.lang.Long)
	 */
	public int borrarPreferencias(List<Preferencia> preferencias, Long tipo, Long idProfesional) {
		int retorno = -1;
		List<Long> listaId = new ArrayList<Long>();
		listaId.add(0L);
		for (Preferencia item : preferencias) {
			listaId.add(item.getId().getIdPrfrnca());
		}
		String hqlBorrar = "delete from Preferencia p where p.id.idTpoPrfrnca = :tipo and p.id.idPrfrnca not in (:ids) and p.id.idPrfsnal = :idProfesional";
		retorno = getSession().createQuery(hqlBorrar).setLong("tipo", tipo).setParameterList("ids", listaId)
				.setLong("idProfesional", idProfesional).executeUpdate();

		return retorno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarPreferencias(java
	 * .lang.Long, java.lang.Long)
	 */
	public List<Preferencia> buscarPreferencias(Long tipo, Long idProfesional) {
		String hqlPreferencias = "from Preferencia p where p.id.idTpoPrfrnca = :tipo and p.id.idPrfsnal = :idProfesional";

		return getSession().createQuery(hqlPreferencias).setLong("tipo", tipo).setLong("idProfesional", idProfesional)
				.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarProfesional(java
	 * .util.HashMap)
	 */
	public List<ReporteE1> getReporteE1(HashMap<String, HashMap<String, List<?>>> criterios, String fechaInicio,
			String fechaFin) {

		List<ReporteE1> listaRetorno = new ArrayList<ReporteE1>();

		Iterator it = criterios.entrySet().iterator();

		List<String> direccion = null;
		List<String> profesional = null;
		List<String> tecnico = null;
		List<String> operativo = null;
		List<String> noCalificado = null;

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			String key = (String) e.getKey();
			HashMap<String, List<?>> campoValores = (HashMap<String, List<?>>) e.getValue();

			// List<?> valor = campoValores.get("");
			logger.info("Key = " + key + ", Value = " + campoValores);

			if (e.getKey().toString().equals("direccion")) {
				direccion = (List<String>) campoValores.get("idDireccion");
			}

			if (e.getKey().toString().equals("profesional")) {
				profesional = (List<String>) campoValores.get("idProfesional");
			}

			if (e.getKey().toString().equals("tecnico")) {
				tecnico = (List<String>) campoValores.get("idTecnico");
			}

			if (e.getKey().toString().equals("operativo")) {
				operativo = (List<String>) campoValores.get("idOperativo");
			}

			if (e.getKey().toString().equals("noCalificado")) {
				noCalificado = (List<String>) campoValores.get("idNoCalificado");
			}
		}

		String hql = "select p from Profesional p where p.fechaCreacion between to_date(:fechaInicio,'DD/MM/YYYY') and to_date(:fechaFin,'DD/MM/YYYY') ";
		List<Profesional> listaProfesionals = getSession().createQuery(hql).setString("fechaInicio", fechaInicio)
				.setString("fechaFin", fechaFin).list();

		Integer countDireccionM = 0;
		Integer countProfesionalM = 0;
		Integer countTecnicoM = 0;
		Integer countOperativoM = 0;
		Integer countNoCalificadoM = 0;

		Integer countDireccionF = 0;
		Integer countProfesionalF = 0;
		Integer countTecnicoF = 0;
		Integer countOperativoF = 0;
		Integer countNoCalificadoF = 0;

		for (Profesional prof : listaProfesionals) {

			String hql2 = "select el from ExperienciaLaboral el where el.profesional.id = ? and el.principal = ?";
			// String hql2 =
			// "select el from ExperienciaLaboral el where el.profesional.id = ?
			// ";
			List<ExperienciaLaboral> lista = getSession().createQuery(hql2).setLong(0, prof.getId()).setInteger(1, 1)
					.list();

			for (ExperienciaLaboral row : lista) {

				for (String d : direccion) {
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 1) {
						countDireccionM++;
					}
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 2) {
						countDireccionF++;
					}
				}

				for (String d : profesional) {
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 1) {
						countProfesionalM++;
					}
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 2) {
						countProfesionalF++;
					}
				}

				for (String d : tecnico) {
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 1) {
						countTecnicoM++;
					}
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 2) {
						countTecnicoF++;
					}
				}

				for (String d : operativo) {
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 1) {
						countOperativoM++;
					}
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 2) {
						countOperativoF++;
					}
				}

				for (String d : noCalificado) {
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 1) {
						countNoCalificadoM++;
					}
					if (row.getIdOcupacion().substring(0, 1).equalsIgnoreCase(d)
							&& row.getProfesional().getPersona().getSexo() == 2) {
						countNoCalificadoF++;
					}
				}
			}
		}

		String query = "select count(e.id) from Empresa e";

		Long cantEmpresas = (Long) getSession().createQuery(query).uniqueResult();

		ReporteE1 reporte = new ReporteE1();
		reporte.setCantOfeDirM(countDireccionM);
		reporte.setCantOfeDirF(countDireccionF);
		reporte.setCantOfeProM(countProfesionalM);
		reporte.setCantOfeProF(countProfesionalF);
		reporte.setCantOfeTecM(countTecnicoM);
		reporte.setCantOfeTecF(countTecnicoF);
		reporte.setCantOfeOpeM(countOperativoM);
		reporte.setCantOfeOpeF(countOperativoF);
		reporte.setCantOfeNoCalM(countNoCalificadoM);
		reporte.setCantOfeNoCalF(countNoCalificadoF);

		if (cantEmpresas != null)
			reporte.setCantEmpInscritas(cantEmpresas.intValue());

		listaRetorno.add(reporte);

		return listaRetorno;
	}

	public List<ReporteE2> getReporteE2(HashMap<String, HashMap<String, List<?>>> criterios, String fechaInicio,
			String fechaFin) {

		List<ReporteE2> listaRetorno = new ArrayList<ReporteE2>();

		Iterator it = criterios.entrySet().iterator();

		List<String> grupo1 = null;
		List<String> grupo2 = null;
		List<String> grupo3 = null;
		List<String> grupo4 = null;
		List<String> grupo5 = null;
		List<String> grupo6 = null;
		List<String> grupo7 = null;
		List<String> grupo8 = null;
		List<String> grupo9 = null;
		List<String> grupo10 = null;
		List<String> grupo11 = null;
		List<String> grupo12 = null;

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			String key = (String) e.getKey();
			HashMap<String, List<?>> campoValores = (HashMap<String, List<?>>) e.getValue();

			// List<?> valor = campoValores.get("");
			// logger.info("Key = " + key + ", Value = " + campoValores);

			if (e.getKey().toString().equals("grupo1")) {
				grupo1 = (List<String>) campoValores.get("listGrupo1");
			}

			if (e.getKey().toString().equals("grupo2")) {
				grupo2 = (List<String>) campoValores.get("listGrupo2");
			}

			if (e.getKey().toString().equals("grupo3")) {
				grupo3 = (List<String>) campoValores.get("listGrupo3");
			}

			if (e.getKey().toString().equals("grupo4")) {
				grupo4 = (List<String>) campoValores.get("listGrupo4");
			}

			if (e.getKey().toString().equals("grupo5")) {
				grupo5 = (List<String>) campoValores.get("listGrupo5");
			}
			if (e.getKey().toString().equals("grupo6")) {
				grupo6 = (List<String>) campoValores.get("listGrupo6");
			}
			if (e.getKey().toString().equals("grupo7")) {
				grupo7 = (List<String>) campoValores.get("listGrupo7");
			}
			if (e.getKey().toString().equals("grupo8")) {
				grupo8 = (List<String>) campoValores.get("listGrupo8");
			}
			if (e.getKey().toString().equals("grupo9")) {
				grupo9 = (List<String>) campoValores.get("listGrupo9");
			}
			if (e.getKey().toString().equals("grupo10")) {
				grupo10 = (List<String>) campoValores.get("listGrupo10");
			}
			if (e.getKey().toString().equals("grupo11")) {
				grupo11 = (List<String>) campoValores.get("listGrupo11");
			}
			if (e.getKey().toString().equals("grupo12")) {
				grupo12 = (List<String>) campoValores.get("listGrupo12");
			}
		}

		ReporteE2 reporteE2 = new ReporteE2();

		String query = "select p from Profesional p ";
		List<Profesional> listaProfesionals = getSession().createQuery(query).list();

		for (Profesional row : listaProfesionals) {

			String query2 = "select el from ExperienciaLaboral el where el.profesional.id = ? and el.principal = ?";

			List<ExperienciaLaboral> lista = getSession().createQuery(query2).setLong(0, row.getId()).setInteger(1, 1)
					.list();

			for (ExperienciaLaboral experiencia : lista) {

				for (String d : grupo1) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG1(reporteE2.getCantidadOfertaG1() + 1);
					}
				}
				for (String d : grupo2) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG2(reporteE2.getCantidadOfertaG2() + 1);
					}
				}
				for (String d : grupo3) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG3(reporteE2.getCantidadOfertaG3() + 1);
					}
				}
				for (String d : grupo4) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG4(reporteE2.getCantidadOfertaG4() + 1);
					}
				}
				for (String d : grupo5) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG5(reporteE2.getCantidadOfertaG5() + 1);
					}
				}
				for (String d : grupo6) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG6(reporteE2.getCantidadOfertaG6() + 1);
					}
				}
				for (String d : grupo7) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG7(reporteE2.getCantidadOfertaG7() + 1);
					}
				}
				for (String d : grupo8) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG8(reporteE2.getCantidadOfertaG8() + 1);
					}
				}
				for (String d : grupo9) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG9(reporteE2.getCantidadOfertaG9() + 1);
					}
				}
				for (String d : grupo10) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG10(reporteE2.getCantidadOfertaG10() + 1);
					}
				}
				for (String d : grupo11) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG11(reporteE2.getCantidadOfertaG11() + 1);
					}
				}
				for (String d : grupo12) {
					if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
						reporteE2.setCantidadOfertaG12(reporteE2.getCantidadOfertaG12() + 1);
					}
				}
			}
		}

		listaRetorno.add(reporteE2);

		return listaRetorno;
	}

	public List<ReporteE3> getReporteE3(String fechaInicio, String fechaFin) {

		List<ReporteE3> listaRetorno = new ArrayList<ReporteE3>();

		ReporteE3 reporteE3 = new ReporteE3();
		// Long resultado;
		BigDecimal resultado;

		String query = "select sum(Cantidad) as ho_18_24 from (SELECT valor1 AS Edad, COUNT(valor1) AS Cantidad "
				+ "FROM (SELECT trunc(MONTHS_BETWEEN(sysdate,D_FCHANCNTO)/12) AS valor1 "
				+ "FROM BPTBC_persona INNER JOIN BPTBC_profesional ON BPTBC_persona.N_CODPRSNA = BPTBC_profesional.N_CODPRSNAL "
				+ "WHERE  BPTBC_persona.N_NUMSEXO=? and "
				+ "BPTBC_profesional.D_FECCREA between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') "
				+ ") GROUP BY valor1 ) where Edad>=? and Edad <=?";

		String query2 = "select sum(Cantidad) as ho_18_24 from (SELECT valor1 AS Edad, COUNT(valor1) AS Cantidad "
				+ "FROM (SELECT trunc(MONTHS_BETWEEN(sysdate,D_FCHANCNTO)/12) AS valor1 "
				+ "FROM BPTBC_persona INNER JOIN BPTBC_profesional ON BPTBC_persona.N_CODPRSNA = BPTBC_profesional.N_CODPRSNAL "
				+ "WHERE  BPTBC_persona.N_NUMSEXO=? and "
				+ "BPTBC_profesional.D_FECCREA between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') "
				+ ") GROUP BY valor1 ) where Edad>=? ";

		/*
		 * String query3 = "SELECT SUM(cantidad) as sumatoria FROM(  " +
		 * "SELECT valor1 AS edad, COUNT(valor1) AS cantidad FROM(  " +
		 * "SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,pe.fechaNacimiento)/12)  AS valor1 FROM Profesional p INNER JOIN p.persona pe "
		 * +
		 * "WHERE p.persona.sexo =:sexo AND p.fechaCreacion BETWEEN TO_DATE(=:fechaInicio,'DD/MM/YYYY') and to_date(=:fechaFin,'DD/MM/YYYY') ) GROUP BY valor1 ) WHERE edad >=:edad1 AND edad <=:edad2"
		 * ;
		 * 
		 * String query4 =
		 * "SELECT SUM(cantidad) as sumatoria FROM(  SELECT valor1 AS edad, COUNT(valor1) AS cantidad FROM(  SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,pe.fechaNacimiento)/12) AS valor1 FROM Profesional p INNER JOIN p.persona pe "
		 * +
		 * "WHERE p.persona.sexo =:sexo AND p.fechaCreacion BETWEEN TO_DATE(:fechaInicio,'DD/MM/YYYY') and to_date(:fechaFin,'DD/MM/YYYY') ) GROUP BY valor1 ) WHERE edad >=:edad1 "
		 * ;
		 */

		Integer edad1 = 18;
		Integer edad2 = 24;
		Integer sexo = 1;

		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();

		logger.info("sum1" + resultado);

		if (resultado != null)
			reporteE3.setGrupo1OfeM(resultado.intValue());

		sexo = 2;

		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo1OfeF(resultado.intValue());

		edad1 = 25;
		edad2 = 29;
		sexo = 1;

		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo2OfeM(resultado.intValue());

		sexo = 2;
		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo2OfeF(resultado.intValue());

		edad1 = 30;
		edad2 = 45;
		sexo = 1;
		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo3OfeM(resultado.intValue());

		sexo = 2;
		resultado = (BigDecimal) getSession().createSQLQuery(query).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo3OfeF(resultado.intValue());

		edad1 = 46;
		sexo = 1;
		resultado = (BigDecimal) getSession().createSQLQuery(query2).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo4OfeM(resultado.intValue());

		sexo = 2;
		resultado = (BigDecimal) getSession().createSQLQuery(query2).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).uniqueResult();
		if (resultado != null)
			reporteE3.setGrupo4OfeF(resultado.intValue());

		listaRetorno.add(reporteE3);

		return listaRetorno;
	}

	public List<ReporteE4> getReporteE4(HashMap<String, HashMap<String, List<?>>> criterios, String fechaInicio,
			String fechaFin) {

		List<ReporteE4> listaRetorno = new ArrayList<ReporteE4>();

		Iterator it = criterios.entrySet().iterator();

		List<String> grupo1 = null;
		List<String> grupo2 = null;
		List<String> grupo3 = null;
		List<String> grupo4 = null;
		List<String> grupo5 = null;
		List<String> grupo6 = null;
		List<String> grupo7 = null;
		List<String> grupo8 = null;
		List<String> grupo9 = null;
		List<String> grupo10 = null;
		List<String> grupo11 = null;
		List<String> grupo12 = null;

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			String key = (String) e.getKey();
			HashMap<String, List<?>> campoValores = (HashMap<String, List<?>>) e.getValue();

			// List<?> valor = campoValores.get("");
			// logger.info("Key = " + key + ", Value = " + campoValores);

			if (e.getKey().toString().equals("grupo1")) {
				grupo1 = (List<String>) campoValores.get("listGrupo1");
			}

			if (e.getKey().toString().equals("grupo2")) {
				grupo2 = (List<String>) campoValores.get("listGrupo2");
			}

			if (e.getKey().toString().equals("grupo3")) {
				grupo3 = (List<String>) campoValores.get("listGrupo3");
			}

			if (e.getKey().toString().equals("grupo4")) {
				grupo4 = (List<String>) campoValores.get("listGrupo4");
			}

			if (e.getKey().toString().equals("grupo5")) {
				grupo5 = (List<String>) campoValores.get("listGrupo5");
			}
			if (e.getKey().toString().equals("grupo6")) {
				grupo6 = (List<String>) campoValores.get("listGrupo6");
			}
			if (e.getKey().toString().equals("grupo7")) {
				grupo7 = (List<String>) campoValores.get("listGrupo7");
			}
			if (e.getKey().toString().equals("grupo8")) {
				grupo8 = (List<String>) campoValores.get("listGrupo8");
			}
			if (e.getKey().toString().equals("grupo9")) {
				grupo9 = (List<String>) campoValores.get("listGrupo9");
			}
			if (e.getKey().toString().equals("grupo10")) {
				grupo10 = (List<String>) campoValores.get("listGrupo10");
			}
			if (e.getKey().toString().equals("grupo11")) {
				grupo11 = (List<String>) campoValores.get("listGrupo11");
			}
			if (e.getKey().toString().equals("grupo12")) {
				grupo12 = (List<String>) campoValores.get("listGrupo12");
			}
		}

		ReporteE4 reporteE2 = new ReporteE4();

		String query = "select p from Profesional p  ";
		List<Profesional> listaProfesionals = getSession().createQuery(query).list();

		for (Profesional row : listaProfesionals) {

			String query1 = "select count(d.id) from Discapacidad d where d.persona.id =:idPersona";

			Long resultado = (Long) getSession().createQuery(query1).setLong("idPersona", row.getId()).uniqueResult();

			if (resultado > 0) {

				String query2 = "select el from ExperienciaLaboral el where el.profesional.id = ? and el.principal = ?";

				List<ExperienciaLaboral> lista = getSession().createQuery(query2).setLong(0, row.getId())
						.setInteger(1, 1).list();

				for (ExperienciaLaboral experiencia : lista) {

					for (String d : grupo1) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG1(reporteE2.getCantidadOfertaG1() + 1);
						}
					}
					for (String d : grupo2) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG2(reporteE2.getCantidadOfertaG2() + 1);
						}
					}
					for (String d : grupo3) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG3(reporteE2.getCantidadOfertaG3() + 1);
						}
					}
					for (String d : grupo4) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG4(reporteE2.getCantidadOfertaG4() + 1);
						}
					}
					for (String d : grupo5) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG5(reporteE2.getCantidadOfertaG5() + 1);
						}
					}
					for (String d : grupo6) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG6(reporteE2.getCantidadOfertaG6() + 1);
						}
					}
					for (String d : grupo7) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG7(reporteE2.getCantidadOfertaG7() + 1);
						}
					}
					for (String d : grupo8) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG8(reporteE2.getCantidadOfertaG8() + 1);
						}
					}
					for (String d : grupo9) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG9(reporteE2.getCantidadOfertaG9() + 1);
						}
					}
					for (String d : grupo10) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG10(reporteE2.getCantidadOfertaG10() + 1);
						}
					}
					for (String d : grupo11) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG11(reporteE2.getCantidadOfertaG11() + 1);
						}
					}
					for (String d : grupo12) {
						if (experiencia.getIdOcupacion().equalsIgnoreCase(d)) {
							reporteE2.setCantidadOfertaG12(reporteE2.getCantidadOfertaG12() + 1);
						}
					}
				}

			}
		}

		BigDecimal resultado2;

		String query5 = "select sum(Cantidad) as ho_18_24 from (SELECT valor1 AS Edad, COUNT(valor1) AS Cantidad "
				+ "FROM (SELECT trunc(MONTHS_BETWEEN(sysdate,D_FCHANCNTO)/12) AS valor1 "
				+ "FROM BPTBC_persona INNER JOIN BPTBC_profesional ON BPTBC_persona.N_CODPRSNA = BPTBC_profesional.N_CODPRSNAL "
				+ "WHERE  "
				+ " (select count(*) from BPMVD_PSONDISCAPDA where n_codprsna =  BPTBC_persona. n_codprsna) > 0 and "
				+ " BPTBC_persona.N_NUMSEXO=? and "
				+ "BPTBC_profesional.D_FECCREA between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') "
				+ ") GROUP BY valor1 ) where Edad>=? and Edad <=?";

		String query6 = "select sum(Cantidad) as ho_18_24 from (SELECT valor1 AS Edad, COUNT(valor1) AS Cantidad "
				+ "FROM (SELECT trunc(MONTHS_BETWEEN(sysdate,D_FCHANCNTO)/12) AS valor1 "
				+ "FROM BPTBC_persona INNER JOIN BPTBC_profesional ON BPTBC_persona.N_CODPRSNA = BPTBC_profesional.N_CODPRSNAL "
				+ "WHERE  "
				+ " (select count(*) from BPMVD_PSONDISCAPDA where n_codprsna =  BPTBC_persona. n_codprsna) > 0 and "
				+ " BPTBC_persona.N_NUMSEXO=? and "
				+ "BPTBC_profesional.D_FECCREA between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') "
				+ ") GROUP BY valor1 ) where Edad>=? ";

		Integer edad1 = 18;
		Integer edad2 = 24;
		Integer sexo = 1;

		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();

		logger.info("sum1" + resultado2);

		if (resultado2 != null)
			reporteE2.setGrupo1OfeM(resultado2.intValue());

		sexo = 2;

		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo1OfeF(resultado2.intValue());

		edad1 = 25;
		edad2 = 29;
		sexo = 1;

		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo2OfeM(resultado2.intValue());

		sexo = 2;
		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo2OfeF(resultado2.intValue());

		edad1 = 30;
		edad2 = 45;
		sexo = 1;
		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo3OfeM(resultado2.intValue());

		sexo = 2;
		resultado2 = (BigDecimal) getSession().createSQLQuery(query5).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).setParameter(4, edad2).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo3OfeF(resultado2.intValue());

		edad1 = 46;
		sexo = 1;
		resultado2 = (BigDecimal) getSession().createSQLQuery(query6).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo4OfeM(resultado2.intValue());

		sexo = 2;
		resultado2 = (BigDecimal) getSession().createSQLQuery(query6).setParameter(0, sexo).setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, edad1).uniqueResult();
		if (resultado2 != null)
			reporteE2.setGrupo4OfeF(resultado2.intValue());

		listaRetorno.add(reporteE2);

		return listaRetorno;
	}

	public List<ReporteOferta> buscarPorRangoFecha(String fechaInicio, String fechaFin) {

		String hql = "select p from Profesional p where p.fechaCreacion between to_date(:fechaInicio,'DD/MM/YYYY') and to_date(:fechaFin,'DD/MM/YYYY') ";
		List<Profesional> listaProfesionals = getSession().createQuery(hql).setString("fechaInicio", fechaInicio)
				.setString("fechaFin", fechaFin).list();

		List<ReporteOferta> lista = new ArrayList<ReporteOferta>();

		for (Profesional row : listaProfesionals) {
			ReporteOferta fila = new ReporteOferta();
			fila.setId(row.getId());
			fila.setNombres(row.getPersona().getNombres());
			fila.setApPaterno(row.getPersona().getApellidoPaterno());
			fila.setApMaterno(row.getPersona().getApellidoMaterno());
			fila.setFechaRegistro(new SimpleDateFormat("dd/MM/yyyy").format(row.getFechaCreacion()));
			fila.setCorreo(row.getPersona().getCorreosElectronicos()[0]);
			lista.add(fila);
		}

		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#obtenerPostulaciones(pe.gob
	 * .trabajo.silnet2.modelo.dominio.Profesional)
	 */
	public List<Postulacion> obtenerPostulaciones(Profesional profesional) {
		String hql = "select p from Postulacion p where p.profesional.id = ?";
		@SuppressWarnings("unchecked")
		ArrayList<Postulacion> lista = (ArrayList<Postulacion>) getSession().createQuery(hql)
				.setLong(0, profesional.getId()).list();
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.gob.trabajo.pcd.modelo.dao.ProfesionalDAO#buscarProfesional(java.util.
	 * List, java.util.List, java.util.Date, java.util.Date)
	 */
	public List<Profesional> buscarProfesional(List<Long> idConsultores, List<String> idOficinas, Date fechaInicio,
			Date fechaFin) {
		List<Profesional> profesionales = new ArrayList<Profesional>();
		Criteria criteria = getSession().createCriteria(Profesional.class);
		criteria.createAlias("persona", "persona");

		if (idConsultores != null) {
			criteria.add(Restrictions.in("persona.idUsuarioCreador", idConsultores));
		}
		if (idOficinas != null) {
			criteria.add(Restrictions.in("codigoOficinaAsociada", idOficinas));
		}
		if (fechaInicio != null) {
			criteria.add(Restrictions.ge("persona.fechaCreacion", fechaInicio));
		}
		if (fechaFin != null) {
			criteria.add(Restrictions.le("persona.fechaCreacion", fechaFin));
		}
		profesionales = criteria.list();
		for (Profesional p : profesionales) {
			Hibernate.initialize(p.getExperienciasLaborales());
			for (ExperienciaLaboral el : p.getExperienciasLaborales()) {
				if (el != null) {
					Hibernate.initialize(el);
				}
			}
			for (Formacion f : p.getFormaciones()) {
				if (f != null) {
					Hibernate.initialize(f);
				}
			}
		}
		return profesionales;
	}

}
