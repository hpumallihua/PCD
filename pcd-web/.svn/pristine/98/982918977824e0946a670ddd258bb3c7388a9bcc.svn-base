package pe.gob.trabajo.pcd.vista.faces.bean;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;
import pe.gob.trabajo.pcd.vista.seguridad.FiltroSesion;

// TODO: Auto-generated Javadoc
/**
 * The Class SesionMB.
 */
public class SesionMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(SesionMB.class);

	/** The opcion menu. */
	private int opcionMenu;
	
	/** The opcion asistente. */
	private int opcionAsistente;
	
	private Integer contexto;

	static {
		// CronServiceImpl.indexarArchivosBD();
	}

	/** The session. */
	HttpSession session;

	/**
	 * Instantiates a new sesion mb.
	 */
	public SesionMB() {
		init();
	}

	@Override
	public void init() {
		setBean(new UsuarioSesion());
	}

	/**
	 * Gets the opcion menu.
	 *
	 * @return the opcion menu
	 */
	public int getOpcionMenu() {
		return opcionMenu;
	}

	/**
	 * Sets the opcion menu.
	 *
	 * @param opcionMenu the new opcion menu
	 */
	public void setOpcionMenu(int opcionMenu) {
		this.opcionMenu = opcionMenu;
	}

	/**
	 * Gets the opcion asistente.
	 *
	 * @return the opcion asistente
	 */
	public int getOpcionAsistente() {
		return opcionAsistente;
	}

	/**
	 * Sets the opcion asistente.
	 *
	 * @param opcionAsistente the new opcion asistente
	 */
	public void setOpcionAsistente(int opcionAsistente) {
		this.opcionAsistente = opcionAsistente;
	}

	/**
	 * @return the contexto
	 */
	public Integer getContexto() {
		return contexto;
	}

	/**
	 * @param contexto the contexto to set
	 */
	public void setContexto(Integer contexto) {
		this.contexto = contexto;
	}

	/**
	 * Metodo que verifica el nombre de usuario y clave de un usuario.
	 *
	 * @return string Retorna la pagina de inicio si la verificación es correcta, caso contrario
	 * retorna un mensaje indicando que los datos de acceso son incorrectos.
	 */
	public String logIn() {
		String navegacion = "ninguno";
		UsuarioSesion bean = (UsuarioSesion) getBean();
		bean.setPersona(null);
		bean.setEmpresa(null);
		bean.setUsuario(null);
		bean.setPaginaInicial(navegacion);
		Persona persona = null;
		Empresa empresa = null;
		
		Usuario usuario = getServicio().getMaestroService().buscarUsuarioPorUsuarioClave(bean.getNombreUsuario(), bean.getClave());
		
		if (usuario != null) {
			if (usuario.getRol().getId().compareTo(Constantes.ROL_EMPLEADOR.getId()) == 0) {
				empresa = usuario.getEmpresa();
			} else {
				persona = usuario.getPersona();
			}
		}
		bean.setUsuario(usuario);
		bean.setEmpresa(empresa);
		bean.setPersona(persona);
		
//		Persona persona = getServicio().getPersonaService()
//				.buscarPorUsuarioClave(bean.getNombreUsuario(), bean.getClave());
		if (persona != null) {
			// logger.debug(persona.getApellidoPaterno());
//			bean.setPersona(persona);
			navegacion = "buscarProfesionales";
			
			if (persona.getUsuario() != null
					&& persona.getUsuario().getRol() != null) {
				if (Constantes.ROL_ADMINISTRADOR.getId().compareTo(persona.getUsuario().getRol().getId()) == 0) {
					navegacion = "buscarProfesionales";
				}
				if (Constantes.ROL_CONSULTOR_EMPLEO.getId().compareTo(persona.getUsuario().getRol().getId()) == 0) {
					navegacion = "buscarProfesionales";
				}
				if (Constantes.ROL_CONSULTOR_ABE.getId().compareTo(persona.getUsuario().getRol().getId()) == 0) {
					navegacion = "buscarProfesionales";
				}
				if (Constantes.ROL_CONSULTOR_CUL.getId().compareTo(persona.getUsuario().getRol().getId()) == 0) {
					navegacion = "buscarProfesionales";
				}
				if (Constantes.ROL_PROFESIONAL.getId().compareTo(persona.getUsuario().getRol().getId()) == 0) {
					navegacion = "profesionalDatosPersonales";
				}
				bean.setUsuario(persona.getUsuario());
			}
			
//			if (persona.getUsuario() != null
//					&& persona.getUsuario().getRol() != null
//					&& !persona.getUsuario().getRol().getId()
//							.equals(Constantes.ROL_EMPLEADOR.getId())) {
//				// logger.debug(persona.getUsuario());
//				bean.setUsuario(persona.getUsuario());
//				navegacion = "buscarProfesionales";
//			} else {
////				bean.getPersona().setUsuario(new Usuario());
//			}
		} else if(empresa != null) {
			navegacion = "ninguno";
			
			if (usuario != null
					&& usuario.getRol() != null) {
				if (Constantes.ROL_EMPLEADOR.getId().compareTo(usuario.getRol().getId()) == 0) {
					navegacion = "empresaDatos";
				}
			}
		} else {
			logger.debug("persona no encontrada...");
			agregarMensaje("Nombre de usuario y/o clave incorrecta");
		}

		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

		bean.setPaginaInicial(navegacion);
		session.setAttribute(FiltroSesion.SESION_USUARIO_ID, bean);
		// logger.debug("=====>" + navegacion);
		return navegacion;
	}

	
	/**
	 * Metodo que se encarga de terminar la sesión de un usuario y redirecciona a la pagina de login.
	 *
	 * @throws IOException  cuando se ha producido una excepción de E/S.
	 */
	public void logOut() throws IOException {

		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		session.setAttribute(FiltroSesion.SESION_USUARIO_ID, null);
		UsuarioSesion bean = (UsuarioSesion) getBean();
		bean.setNombreUsuario("");
		bean.setClave("");
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		String ctxPath = ctx.getExternalContext().getRequestContextPath();
		ctx.getExternalContext().redirect(ctxPath + "/login.xhtml");
		
		Map<String, Object> map = ctx.getExternalContext().getSessionMap();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
		    logger.info(entry.getKey() + "/" + entry.getValue());
		    ctx.getExternalContext().getSessionMap().remove(entry.getKey());
		}
	}
	
	public String registrarPostulante() {		
		String navegacion = "ninguno";
		UsuarioSesion bean = (UsuarioSesion) getBean();
		Persona persona = getServicio().getPersonaService().buscarPorDocumentoIdentidad(null, bean.getDni());
		if (persona != null) {
			agregarMensaje("La persona ya esta registrada, ingrese con su usuario y clave");
			return "login";
		}
		persona = getServicio()
				.getPersonaService().buscarPersona(bean.getDni(), bean.getFechaNacimiento(), bean.getSexo().toString());
		bean.setPersona(null);
		bean.setUsuario(null);
		bean.setPaginaInicial("ninguno");
		if (persona != null) {
			navegacion = "inicioProfesional";
			Usuario usuarioNuevo = new Usuario();
			usuarioNuevo.setRol(Constantes.ROL_PROFESIONAL);
			persona.setUsuario(usuarioNuevo);
			bean.setPersona(persona);
			bean.setUsuario(usuarioNuevo);
		} else {
			logger.debug("persona no encontrada...");
			agregarMensaje("Nombre de usuario y/o clave incorrecta");
		}

		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

		bean.setPaginaInicial(navegacion);
		session.setAttribute(FiltroSesion.SESION_USUARIO_ID, bean);
		init();
		return navegacion;
	}
	
	public String registrarEmpleador() {
		String navegacion = "ninguno";
		UsuarioSesion bean = (UsuarioSesion) getBean();
//		Persona persona = getServicio().getPersonaService().buscarPorDocumentoIdentidad(null, bean.getDni());
		Empresa empresa = getServicio().getEmpresaService().buscarPorRuc(bean.getRucEmpresa());
		if (empresa != null) {
			agregarMensaje("La empresa ya esta registrada, ingrese con su usuario y clave");
			return "login";
		}
		empresa = getServicio().getMaestroService().buscarEmpresa(bean.getRucEmpresa());
		bean.setPersona(null);
		bean.setEmpresa(null);
		bean.setUsuario(null);
		bean.setPaginaInicial("ninguno");
		
		if (empresa != null) {
			navegacion = "usuarioEmpresa";
			Usuario usuarioNuevo = new Usuario();
			usuarioNuevo.setRol(Constantes.ROL_EMPLEADOR);
			empresa.setUsuario(usuarioNuevo);
			bean.setEmpresa(empresa);
			bean.setUsuario(usuarioNuevo);
		} else {
			logger.debug("empresa no encontrada...");
			agregarMensaje("Nombre de usuario y/o clave incorrecta");
		}

		session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

		bean.setPaginaInicial(navegacion);
		session.setAttribute(FiltroSesion.SESION_USUARIO_ID, bean);
		// logger.debug("=====>" + navegacion);
		init();
		return navegacion;
	}

}
