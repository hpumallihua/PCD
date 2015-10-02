package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Ciiu;
import pe.gob.trabajo.pcd.modelo.dominio.Configuracion;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.EmpleadoMaestro;
import pe.gob.trabajo.pcd.modelo.dominio.EscalaRemuneracion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoOcupacion;
import pe.gob.trabajo.pcd.modelo.dominio.GrupoProfesion;
import pe.gob.trabajo.pcd.modelo.dominio.Menu;
import pe.gob.trabajo.pcd.modelo.dominio.Nacionalidad;
import pe.gob.trabajo.pcd.modelo.dominio.Nivel;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Pais;
import pe.gob.trabajo.pcd.modelo.dominio.Perfil;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Provincia;
import pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Sistema;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDocumento;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarMaestroMB.
 */
public class RegistrarMaestroMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarMaestroMB.class);
	
	/** The parametro. */
	String parametro;
	
	/** The titulo lista. */
	String tituloLista;
	
	/** The titulo formulario. */
	String tituloFormulario;
	
	/**
	 * Instantiates a new registrar maestro mb.
	 */
	public RegistrarMaestroMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		super.init();
		setBean(new Configuracion());
	}
	
	/**
	 * Inits the.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void init(ActionEvent e) {
		init();
	}
	
	/**
	 * Gets the parametro.
	 *
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}

	/**
	 * Sets the parametro.
	 *
	 * @param parametro the new parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	/**
	 * Gets the titulo lista.
	 *
	 * @return the titulo lista
	 */
	public String getTituloLista() {
		return tituloLista;
	}

	/**
	 * Sets the titulo lista.
	 *
	 * @param tituloLista the new titulo lista
	 */
	public void setTituloLista(String tituloLista) {
		this.tituloLista = tituloLista;
	}

	/**
	 * Gets the titulo formulario.
	 *
	 * @return the titulo formulario
	 */
	public String getTituloFormulario() {
		return tituloFormulario;
	}

	/**
	 * Sets the titulo formulario.
	 *
	 * @param tituloFormulario the new titulo formulario
	 */
	public void setTituloFormulario(String tituloFormulario) {
		this.tituloFormulario = tituloFormulario;
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		Object bean = new Object();
		try {
			bean = Class.forName("pe.gob.trabajo.pcd.modelo.dominio." + parametro).newInstance();
		} catch (InstantiationException e1) {
			logger.error(e1.getStackTrace());
		} catch (IllegalAccessException e1) {
			logger.error(e1.getStackTrace());
		} catch (ClassNotFoundException e1) {
			logger.error(e1.getStackTrace());
		}
//		bean.setProfesional(profesionalBean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}
	
	/**
	 * Metodo recibe un objeto Referencia y actualiza los cambios en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
//		Configuracion bean = (Configuracion) getRowParameter(e, "maestroPrm");
		setBean(getRowParameter(e, "maestroPrm"));
		setAccionRealizada(Constantes.ACCION_EDITAR);
		UtilBean.initNullObject(getBean());
	}
	
	/**
	 * Metodo que elimina un registro de la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
//		Configuracion bean = (Configuracion) getRowParameter(e, "maestroPrm");
		try {
			getServicio().getMaestroService().removeObject(getRowParameter(e, "maestroPrm"));
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo eliminar");
		}
	}
	
	/**
	 * Metodo que se guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {
//		Configuracion bean = (Configuracion) getBean();
//		logger.info(bean);
		try {
			validar();
			getServicio().getMaestroService().saveObject(getBean());
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo guardar");
		} finally {
			UtilBean.initNullObject(getBean());			
		}
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	public void validar() {
//		Configuracion bean = (Configuracion) getBean();
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
	 * Gets the lista maestro.
	 *
	 * @return the lista maestro
	 */
	public List<?> getListaMaestro() {
		List<?> lista = null;
		try {
			lista = (List) getServicio().getMaestroService().getAllObject(Class.forName("pe.gob.trabajo.pcd.modelo.dominio." + parametro),"",500);
		} catch (ClassNotFoundException e) {
			logger.error(e.getStackTrace());
		}
		return lista;
	}
	
	/**
	 * Gets the lista maestro empresas.
	 *
	 * @return the lista maestro empresas
	 */
	public List<?> getListaMaestroEmpresas() {
		List<?> lista = null;
		try {
			lista = (List) getServicio().getMaestroService().getAllObject(Class.forName("pe.gob.trabajo.pcd.modelo.dominio." + parametro),"nombres",500);
		} catch (ClassNotFoundException e) {
			logger.error(e.getStackTrace());
		}
		return lista;
	}
	
	/**
	 * Listar maestro profesiones2.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarMaestroProfesiones2(ActionEvent e){
		List<EmpleadoMaestro> lista = (List) getServicio().getMaestroService().obtenerMaestroProfesiones2();
			for (EmpleadoMaestro emp : lista) {
				logger.info(emp.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar maestro grupo ocupaciones.
	 *
	 * @param e the e
	 */
	public void listarMaestroGrupoOcupaciones(ActionEvent e){
		List<GrupoOcupacion> lista = (List) getServicio().getMaestroService().getMaestroGrupoOcupaciones();
			for (GrupoOcupacion row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar maestro ocupaciones.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarMaestroOcupaciones(ActionEvent e){
		List<Ocupacion> lista = (List) getServicio().getMaestroService().getMaestroOcupaciones();
			for (Ocupacion row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar maestro grupo profesiones.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarMaestroGrupoProfesiones(ActionEvent e){
		List<GrupoProfesion> lista = (List) getServicio().getMaestroService().getMaestroGrupoProfesiones();
			for (GrupoProfesion row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar maestro profesiones.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarMaestroProfesiones(ActionEvent e){
		List<Profesion> lista = (List) getServicio().getMaestroService().getMaestroProfesiones();
			for (Profesion row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar niveles educativos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarNivelesEducativos(ActionEvent e){
		List<NivelEducativo> lista = (List) getServicio().getMaestroService().getMaestroNivelesEducativos();
			for (NivelEducativo row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar ciius.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarCiius(ActionEvent e){
		List<Ciiu> lista = (List) getServicio().getMaestroService().getMaestroCiiu();
			for (Ciiu row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar departamentos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarDepartamentos(ActionEvent e){
		List<Departamento> lista = (List) getServicio().getMaestroService().getMaestroDepartamentos();
			for (Departamento row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar provincias.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarProvincias(ActionEvent e){
		String idDpto = "05";
		List<Provincia> lista = (List) getServicio().getMaestroService().getMaestroProvincias(idDpto);
			for (Provincia row : lista) {
				logger.info(row.getNombre());
			}
//		return lista;
	}
	
	/**
	 * Listar distritos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarDistritos(ActionEvent e){
		ProvinciaId id = new ProvinciaId("03", "05");
		List<Distrito> lista = (List) getServicio().getMaestroService().getMaestroDistritos(id);
			for (Distrito row : lista) {
				logger.info(row.getNombre());
			}
//		return lista;
	}
	
	/**
	 * Listar escala remuneraciones.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarEscalaRemuneraciones(ActionEvent e){
		List<EscalaRemuneracion> lista = (List) getServicio().getMaestroService().getMaestroEscalaRemuneraciones();
			for (EscalaRemuneracion row : lista) {
				logger.info(row.getNombre());
			}
//		return lista;
	}
	
	/**
	 * Listar nacionalidades.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarNacionalidades(ActionEvent e){
		List<Nacionalidad> lista = (List) getServicio().getMaestroService().getMaestroNacionalidades();
			for (Nacionalidad row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar niveles.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarNiveles(ActionEvent e){
		List<Nivel> lista = (List) getServicio().getMaestroService().getMaestroNiveles();
			for (Nivel row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar paises.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarPaises(ActionEvent e){
		List<Pais> lista = (List) getServicio().getMaestroService().getMaestroPaises();
			for (Pais row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar persona cargo.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarPersonaCargo(ActionEvent e){
		List<PersonaCargo> lista = (List) getServicio().getMaestroService().getMaestroPersonaCargo();
			for (PersonaCargo row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar tipo documento.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarTipoDocumento(ActionEvent e){
		List<TipoDocumento> lista = (List) getServicio().getMaestroService().getMaestroTipoDocumentos();
			for (TipoDocumento row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar sistemas.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarSistemas(ActionEvent e){
		List<Sistema> lista = (List) getServicio().getMaestroService().getMaestroSistemas();
			for (Sistema row : lista) {
				logger.info(row.getNombre());
			}
//		return lista;
	}
	
	/**
	 * Listar menus.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void listarMenus(ActionEvent e){
		String idSistema = "01"; 
		List<Menu> lista = (List) getServicio().getMaestroService().getMaestroMenus(idSistema);
			for (Menu row : lista) {
				logger.info(row.getDescripcion());
			}
//		return lista;
	}
	
	/**
	 * Listar perfiles.
	 *
	 * @param e the e
	 */
	public void listarPerfiles(ActionEvent e){
		String idSistema = "01"; 
		List<Perfil> lista = (List) getServicio().getMaestroService().getMaestroPerfiles(idSistema);
			for (Perfil row : lista) {
				logger.info(row.getNombre());
			}
//		return lista;
	}
	
	/**
	 * Prueba lista meestros.
	 *
	 * @param e the e
	 */
	public void pruebaListaMeestros(ActionEvent e){
		
//		listarCiius(e);
//		listarDepartamentos(e);
//		listarProvincias(e);
//		listarDistritos(e);
//		listarEscalaRemuneraciones(e);
//		listarNacionalidades(e);
//		listarNiveles(e);
//		listarPaises(e);
//		listarPersonaCargo(e);
//		listarTipoDocumento(e);
		
		listarSistemas(e);
		listarMenus(e);
		listarPerfiles(e);
		
	}
	
}
