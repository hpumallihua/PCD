package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO;
import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.DistritoId;
import pe.gob.trabajo.pcd.modelo.dominio.EmpleadoMaestro;
import pe.gob.trabajo.pcd.modelo.dominio.EmpresaSunat;
import pe.gob.trabajo.pcd.modelo.dominio.EscalaRemuneracion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoOcupacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.Menu;
import pe.gob.trabajo.pcd.modelo.dominio.Nacionalidad;
import pe.gob.trabajo.pcd.modelo.dominio.Nivel;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Oficina;
import pe.gob.trabajo.pcd.modelo.dominio.Pais;
import pe.gob.trabajo.pcd.modelo.dominio.Perfil;
import pe.gob.trabajo.pcd.modelo.dominio.Person;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Provincia;
import pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Sistema;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDocumento;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEmpresa;
import pe.gob.trabajo.pcd.modelo.dominio.TipoEstablecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;

// TODO: Auto-generated Javadoc
/**
 * The Class ProveedorMaestroDAOImpl.
 */
public class ProveedorMaestroDAOImpl extends GenericDaoImpl<Object, Long>
		implements ProveedorMaestroDAO {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(ProveedorMaestroDAOImpl.class);

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroEmpresasNoRegistradas(java.util.List)
	 */
	public List<EmpresaSunat> getMaestroEmpresasNoRegistradas(
			List<String> rucEmpresasRegistradas) {
		List<EmpresaSunat> empresas = getSession()
				.createQuery(
						"select e from EmpresaSunat e where e.id.ruc not in (:lista)")
				.setParameterList("lista", rucEmpresasRegistradas)
				.setMaxResults(500).list();

		return empresas;
	}

	// static int factor = 100;
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroEmpresas()
	 */
	public List<EmpresaSunat> getMaestroEmpresas() {
		logger.debug("getMaestroEmpresas Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<EmpresaSunat> empresas = new ArrayList<EmpresaSunat>();
		getSession().createQuery(
				"select e from EmpresaSunat e")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroEmpresas Terminado: " + new Date());

		return empresas;
	}

	/**
	 * Gets the maestro empresas3.
	 *
	 * @return the maestro empresas3
	 */
	public List<EmpresaSunat> getMaestroEmpresas3() {
		return new ArrayList<EmpresaSunat>();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroProfesiones2()
	 */
	public List<EmpleadoMaestro> getMaestroProfesiones2() {
		logger.debug("getMaestroProfesiones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<EmpleadoMaestro> empresas = getSession().createQuery(
				"select e from EmpleadoMaestro e")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroProfesiones Terminado: " + new Date());

		return empresas;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroGrupoOcupaciones()
	 */
	public List<GrupoOcupacion> getMaestroGrupoOcupaciones() {
		logger.debug("getMaestroGrupoOcupaciones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<GrupoOcupacion> grupoOcupacions = getSession().createQuery(
				"select g from GGrupoOcupacion g")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroGrupoOcupaciones Terminado: " + new Date());

		return grupoOcupacions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroOcupaciones()
	 */
	public List<Ocupacion> getMaestroOcupaciones() {
		logger.debug("getMaestroOcupaciones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Ocupacion> ocupacions = getSession().createQuery(
				"select o from Ocupacion o")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroOcupaciones Terminado: " + new Date());

		return ocupacions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroGrupoProfesiones()
	 */
	public List<GrupoProfesion> getMaestroGrupoProfesiones() {
		logger.debug("getMaestroGrupoProfesiones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<GrupoProfesion> grupoProfesions = getSession().createQuery(
				"select g from GGrupoProfesion g")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroGrupoProfesiones Terminado: " + new Date());

		return grupoProfesions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroNivelesEducativos()
	 */
	public List<NivelEducativo> getMaestroNivelesEducativos() {
		logger.debug("getMaestroNivelesEducativos Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<NivelEducativo> nivelEducativos = getSession().createQuery(
				"select n from NivelEducativo n")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroNivelesEducativos Terminado: " + new Date());

		return nivelEducativos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroProfesiones()
	 */
	public List<Profesion> getMaestroProfesiones() {
		logger.debug("getMaestroProfesiones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Profesion> profesions = getSession().createQuery(
				"select p from Profesion p")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroProfesiones Terminado: " + new Date());

		return profesions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroCiiu()
	 */
	public List<Ciiu> getMaestroCiiu() {
		logger.debug("getMaestroCiiu Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Ciiu> ciius = getSession().createQuery("select c from Ciiu c")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroCiiu Terminado: " + new Date());

		return ciius;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroDepartamentos()
	 */
	public List<Departamento> getMaestroDepartamentos() {
		logger.debug("getMaestroDepartamentos Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Departamento> departamentos = getSession().createQuery(
				"select d from Departamento d")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroDepartamentos Terminado: " + new Date());

		return departamentos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroProvincias(java.lang.String)
	 */
	public List<Provincia> getMaestroProvincias(String idDpto) {
		logger.debug("getMaestroProvincias Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Provincia> provincias = getSession()
				.createQuery(
						"select p from Provincia p where p.id.idDepartamento = ? ")
				// .setMaxResults(5000 * factor)
				.setString(0, idDpto).list();
		tx.commit();

		logger.debug("getMaestroProvincias Terminado: " + new Date());

		return provincias;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroDistritos(pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId)
	 */
	public List<Distrito> getMaestroDistritos(ProvinciaId id) {
		logger.debug("getMaestroDistritos Iniciado: " + new Date());
		if (id == null) {
			return getMaestroDistritos();
		}
		
		Transaction tx = getSession().beginTransaction();
		List<Distrito> distritos = getSession()
				.createQuery(
						"select d from Distrito d where d.id.idProvincia = ? and d.id.idDepartamento = ? ")
				// .setMaxResults(5000 * factor)
				.setString(0, id.getIdProvincia())
				.setString(1, id.getIdDepartamento()).list();
		tx.commit();

		logger.debug("getMaestroDistritos Terminado: " + new Date());

		return distritos;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroDistrito(pe.gob.trabajo.pcd.modelo.dominio.DistritoId)
	 */
	public Distrito getMaestroDistrito(DistritoId id) {
		logger.debug("getMaestroDistrito Iniciado: " + new Date());
		
		Transaction tx = getSession().beginTransaction();
		List<Distrito> distritos = getSession()
				.createQuery(
						"select d from Distrito d where d.id.idDepartamento = ? and d.id.idProvincia = ? and d.id.idDistrito = ? ")
				// .setMaxResults(5000 * factor)
				.setString(0, id.getIdDepartamento())
				.setString(1, id.getIdProvincia())
				.setString(2, id.getIdDistrito())
				.list();
		tx.commit();

		logger.debug("getMaestroDistritos Terminado: " + new Date());
		if (distritos != null && !distritos.isEmpty()) {
			return distritos.get(0);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroDistritos(pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId)
	 */
	public List<Distrito> getMaestroDistritos() {
		logger.debug("getMaestroDistritos Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Distrito> distritos = getSession()
				.createQuery(
						"select d from Distrito d")
						// .setMaxResults(5000 * factor)
						.list();
		tx.commit();
		
		logger.debug("getMaestroDistritos Terminado: " + new Date());
		
		return distritos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#buscarDistritos(java.lang.String)
	 */
	public List<Ubigeo> buscarDistritos(String nombre) {
		logger.debug("buscarDistritos Iniciado: " + new Date());

		// nombre = nombre.toLowerCase();
		// nombre = "%" + nombre + "%";

		// Criteria criteria = getSession().createCriteria(Distrito.class);
		//
		// criteria.add(Restrictions.isNotNull("id"));
		// criteria.createAlias("nombre", "nombre");
		// criteria.add(Restrictions.ilike("nombre", nombre));
		// criteria.addOrder(Order.asc("nombre"));

		Transaction tx = getSession().beginTransaction();
		List<Distrito> distritos = getSession().createQuery(
				"select d from Distrito d ").list();
		tx.commit();

		logger.debug("buscarDistritos Terminado: " + new Date());

		// List<Distrito> distritos = (ArrayList<Distrito>)criteria.list();
		// List<Distrito> distritosFiltrados = new ArrayList<Distrito>();
		// for (Distrito d : distritos) {
		// if (d.getNombre().toLowerCase().contains(nombre)) {
		// distritosFiltrados.add(d);
		// }
		// }

		List<Ubigeo> lugares = new ArrayList<Ubigeo>();

		for (Distrito d : distritos) {
			Ubigeo item = new Ubigeo();
			item.setId(new Long(d.getId().getIdDistrito()));
			item.setNombre(d.getNombre());
			item.setIdDprtmnto(d.getId().getIdDepartamento());
			item.setIdPrvnca(d.getId().getIdProvincia());
			item.setIdDstrto(d.getId().getIdDistrito());

			Ubigeo distrito = new Ubigeo();
			distrito.setNombre(d.getNombre());

			Ubigeo provincia = new Ubigeo();
			provincia.setNombre(d.getProvincia().getNombre());

			Ubigeo departamento = new Ubigeo();
			departamento.setNombre(d.getProvincia().getDepartamento()
					.getDescripcion());

			item.setUbigeoRegion(departamento);
			item.setUbigeoProvincia(provincia);
			item.setUbigeoDistrito(distrito);
			lugares.add(item);
		}
		logger.debug("buscarDistritos Transformado: " + new Date());
		return lugares;

		// Transaction tx = getSession().beginTransaction();
		// List<Distrito> distritos =
		// getSession().createQuery("select d from Distrito d where d.nombre = ? and d.id.idDepartamento = ? ")
		// // .setMaxResults(5000 * factor)
		// .setString(0, id.getIdProvincia())
		// .setString(1, id.getIdDepartamento())
		// .list();
		// tx.commit();

		// return distritos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroEscalaRemuneraciones()
	 */
	public List<EscalaRemuneracion> getMaestroEscalaRemuneraciones() {
		logger.debug("getMaestroEscalaRemuneraciones Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<EscalaRemuneracion> escalaRemuneracions = getSession()
				.createQuery("select e from EscalaRemuneracion e")
				// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroEscalaRemuneraciones Terminado: " + new Date());

		return escalaRemuneracions;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroNacionalidades()
	 */
	public List<Nacionalidad> getMaestroNacionalidades() {
		logger.debug("getMaestroNacionalidades Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Nacionalidad> nacionalidads = getSession().createQuery(
				"select n from Nacionalidad n")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroNacionalidades Terminado: " + new Date());

		return nacionalidads;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroNiveles()
	 */
	public List<Nivel> getMaestroNiveles() {
		logger.debug("getMaestroNiveles Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Nivel> nivels = getSession().createQuery("select n from Nivel n")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroNiveles Terminado: " + new Date());

		return nivels;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroPaises()
	 */
	public List<Pais> getMaestroPaises() {
		logger.debug("getMaestroPaises Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Pais> paises = getSession().createQuery("select p from Pais p")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroPaises Terminado: " + new Date());

		return paises;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroPersonaCargo()
	 */
	public List<PersonaCargo> getMaestroPersonaCargo() {
		logger.debug("getMaestroPersonaCargo Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<PersonaCargo> personaCargos = getSession().createQuery(
				"select p from PersonaCargo p")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroPersonaCargo Terminado: " + new Date());

		return personaCargos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroTipoDocumentos()
	 */
	public List<TipoDocumento> getMaestroTipoDocumentos() {
		logger.debug("getMaestroTipoDocumentos Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<TipoDocumento> tipoDocumentos = getSession().createQuery(
				"select t from TipoDocumento t")
//				"select t from TipoDocumento t where t.flgsunmin =:estado")
//				.setInteger("estado", 1)
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroTipoDocumentos Terminado: " + new Date());

		return tipoDocumentos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroTipoEmpresas()
	 */
	public List<TipoEmpresa> getMaestroTipoEmpresas() {
		logger.debug("getMaestroTipoEmpresas Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<TipoEmpresa> tipoEmpresas = getSession().createQuery(
				"select t from TipoEmpresa t")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroTipoEmpresas Terminado: " + new Date());

		return tipoEmpresas;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroTipoEstablecimientos()
	 */
	public List<TipoEstablecimiento> getMaestroTipoEstablecimientos() {
		logger.debug("getMaestroTipoEstablecimientos Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<TipoEstablecimiento> tipoEstablecimientos = getSession()
				.createQuery("select t from TipoEstablecimiento t")
				// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroTipoEstablecimientos Terminado: " + new Date());

		return tipoEstablecimientos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroSistemas()
	 */
	public List<Sistema> getMaestroSistemas() {
		logger.debug("getMaestroSistemas Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Sistema> sistemas = getSession().createQuery(
				"select s from Sistema s")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroSistemas Terminado: " + new Date());

		return sistemas;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroMenus(java.lang.String)
	 */
	public List<Menu> getMaestroMenus(String idSistema) {
		logger.debug("getMaestroMenus Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Menu> menus = getSession()
				.createQuery("select m from Menu m where m.id.idSistema = ?")
				// .setMaxResults(5000 * factor)
				.setString(0, idSistema).list();
		tx.commit();

		logger.debug("getMaestroMenus Terminado: " + new Date());

		return menus;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroPerfiles(java.lang.String)
	 */
	public List<Perfil> getMaestroPerfiles(String idSistema) {
		logger.debug("getMaestroPerfiles Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Perfil> perfils = getSession()
				.createQuery("select p from Perfil p where p.id.idSistema = ?")
				// .setMaxResults(5000 * factor)
				.setString(0, idSistema).list();
		tx.commit();

		logger.debug("getMaestroPerfiles Terminado: " + new Date());

		return perfils;
	}

	/**
	 * Gets the maestro ciius.
	 *
	 * @return the maestro ciius
	 */
	public List<Ciiu> getMaestroCiius() {
		logger.debug("getMaestroCiius Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Ciiu> tipoEstablecimientos = getSession().createQuery(
				"select t from TipoEstablecimiento t")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroTipoEstablecimientos Terminado: " + new Date());

		return tipoEstablecimientos;
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroPersonas(java.lang.String)
	 */
	public List<Person> getMaestroPersonas(String nroDocumento) {
		logger.debug("getMaestroPersonas Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Person> personas = getSession()
				.createQuery("select p from Person p where p.dni = ?")
				// .setMaxResults(5000 * factor)
				.setString(0, nroDocumento).list();
		tx.commit();

		logger.debug("getMaestroPersonas Terminado: " + new Date());

		return personas;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroOficinas()
	 */
	public List<Oficina> getMaestroOficinas() {
		logger.debug("getMaestroOficinas Iniciado: " + new Date());
		Transaction tx = getSession().beginTransaction();
		List<Oficina> oficinas = getSession().createQuery("select o from Oficina o where o.codigoOficina > 0 and o.codigoOficina < 31")
		// .setMaxResults(5000 * factor)
				.list();
		tx.commit();

		logger.debug("getMaestroOficinas Terminado: " + new Date());

		return oficinas;
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.modelo.dao.ProveedorMaestroDAO#getMaestroEmpresasPorRuc(String)
	 */
	public EmpresaSunat getMaestroEmpresasPorRuc(String ruc) {
		EmpresaSunat empresa = (EmpresaSunat) getSession()
				.createQuery(
						"select e from EmpresaSunat e where e.ruc = ?")
				.setString(0, ruc).uniqueResult();

		return empresa;
	}

}
