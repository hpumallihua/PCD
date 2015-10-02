package pe.gob.trabajo.pcd.vista.faces.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Discapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.TipoDiscapacidad;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.UploaderBean;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarDatosPersonalesMB.
 */
public class RegistrarDatosPersonalesMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarDatosPersonalesMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The bean upload. */
	private UploaderBean beanUpload;
	
	/** The bean upload foto. */
	private UploaderBean beanUploadFoto;
	
	/** The discapacidades. */
	public List discapacidades = new ArrayList();
	
	/**
	 * Instantiates a new registrar datos personales mb.
	 */
	public RegistrarDatosPersonalesMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Profesional bean = (Profesional) getSpringBean("ProfesionalPrt");
//		logger.debug("ProfesionalPrt: Profesional:" + bean);
		setProfesionalBean(bean);
		// UtilBean.initNullObject(bean.getPersona());

		beanUpload = new UploaderBean();
		beanUploadFoto = new UploaderBean();
	}
	
	/**
	 * Cargar discapacidades.
	 *
	 * @param discapacidadesPersona the discapacidades persona
	 */
	private void cargarDiscapacidades(List<Discapacidad> discapacidadesPersona) {
		discapacidades = new ArrayList();
		for (Discapacidad discapacidad : discapacidadesPersona) {
			if (discapacidad != null && discapacidad.getTipoDiscapacidad() != null) {
				discapacidades.add(discapacidad.getTipoDiscapacidad().getId());				
			}
		}
	}

	/**
	 * Gets the profesional bean.
	 *
	 * @return objeto profesional 
	 */
	public Profesional getProfesionalBean() {
//		cargarDiscapacidades(profesionalBean.getPersona().getDiscapacidades());
//		if (discapacidades == null || discapacidades.isEmpty()) {
//			cargarDiscapacidades(profesionalBean.getPersona().getDiscapacidades());
//		}
		return profesionalBean;
	}

	/**
	 * Sets the profesional bean.
	 *
	 * @param profesionalBean the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Gets the bean upload.
	 *
	 * @return the bean upload
	 */
	public UploaderBean getBeanUpload() {
		return beanUpload;
	}

	/**
	 * Sets the bean upload.
	 *
	 * @param beanUpload the new bean upload
	 */
	public void setBeanUpload(UploaderBean beanUpload) {
		this.beanUpload = beanUpload;
	}

	/**
	 * Gets the bean upload foto.
	 *
	 * @return the bean upload foto
	 */
	public UploaderBean getBeanUploadFoto() {
		return beanUploadFoto;
	}

	/**
	 * Sets the bean upload foto.
	 *
	 * @param beanUploadFoto the new bean upload foto
	 */
	public void setBeanUploadFoto(UploaderBean beanUploadFoto) {
		this.beanUploadFoto = beanUploadFoto;
	}

	/**
	 * Gets the discapacidades.
	 *
	 * @return the discapacidades
	 */
	public List getDiscapacidades() {
		cargarDiscapacidades(profesionalBean.getPersona().getDiscapacidades());
		return discapacidades;
	}

	/**
	 * Sets the discapacidades.
	 *
	 * @param discapacidades the new discapacidades
	 */
	public void setDiscapacidades(List discapacidades) {
		this.discapacidades = discapacidades;
	}

	
	/**
	 * Buscar persona.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarPersona(ActionEvent e) {
		logger.debug("Evento...");
		Persona bean = profesionalBean.getPersona();
		// Long tipoDoc = bean.getTipoDocumentoIdentidad().getId();
		// logger.debug("Tipo:" + bean.getTipoDocumentoIdentidad().getId());
		// logger.debug("Numero:" + bean.getNumeroDocumentoIdentidad());

		if (bean.getNumeroDocumentoIdentidad().length() > 7) {
			logger.debug("Buscar...");
			Profesional beanBuscado = getServicio().getPersonaService()
					.buscarProfesionalPorDocumentoIdentidad(
							bean.getTipoDocumentoIdentidad(),
							bean.getNumeroDocumentoIdentidad());
			if (beanBuscado != null) {
				profesionalBean = beanBuscado;
				UtilBean.initNullObject(beanBuscado.getPersona());
				ProfesionalMB mb = (ProfesionalMB) getFacesBean("profesionalMB");
				if (mb != null) {
//					beanBuscado.getPersona().getDiscapacidades();
//					cargarDiscapacidades(beanBuscado.getPersona().getDiscapacidades());
					mb.setProfesionalBean(beanBuscado);
				}
				// getProfesionalBean().setPersona(beanBuscado);
			} else {
				init();
				Persona persona = getServicio().getMaestroService().buscarPersonaPorDocumento(bean.getNumeroDocumentoIdentidad());
				profesionalBean.setPersona(persona);
				// getProfesionalBean().getPersona().getTipoDocumentoIdentidad().setId(tipoDoc);

			}
		}
	}

	/**
	 * Guardar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
		logger.debug("Guardando... ");
		Persona bean = (Persona) profesionalBean.getPersona();
		bean.setProfesional(profesionalBean);
		validar();

		try {
			String curriculum = guardarArchivo(bean);
			if (curriculum != null && !curriculum.equals("")) {
				profesionalBean.setCurriculum(curriculum);
			} else if (curriculum == null) {
				UtilBean.initNullObject(bean);
				throw new ValidatorException(agregarMensajeErrorTransaccion("Error al guardar el archivo"));
			}
			String foto = guardarFoto(bean);
			if (foto != null && !foto.equals("")) {
				bean.setFotografia(foto);
			} else if (foto == null) {
				UtilBean.initNullObject(bean);
				throw new ValidatorException(
						agregarMensajeErrorTransaccion("Error al guardar el archivo"));
			}
			
			if (bean.getDiscapacidades() != null) {
				bean.getDiscapacidades().clear();				
			} else {
				bean.setDiscapacidades(new ArrayList<Discapacidad>());
			}
			for (Object d : discapacidades) {
				Discapacidad dp = new Discapacidad();
				dp.setPersona(bean);
				dp.setTipoDiscapacidad(new TipoDiscapacidad(new Long(d.toString())));
				bean.getDiscapacidades().add(dp);
			}
			
			Persona personaGuardada = getServicio().getPersonaService().guardarPersona(bean);
			if (personaGuardada != null && personaGuardada.getId() !=null && personaGuardada.getId().compareTo(0L) == 1) {
				agregarMensajeExitoTransaccion("Datos personales guardados correctamente");
				logger.debug("Guardado: " + bean.getId());
				//Desactivado: investigar sobre el indexado incremental
//				if (curriculum != null && !curriculum.equals("")) {
//					String rutaAGuardar = UtilBean.getParametrosMap().get("CARPETA_CV") + File.separator 
//					+ bean.getNumeroDocumentoIdentidad() + File.separator + curriculum;
//					Indexer.indexarArchivo(rutaAGuardar, personaGuardada.getProfesional());
//				}
			} else {
				agregarMensajeErrorTransaccion("Ya existe una persona registrada con los mismos datos");
			}
		} catch (IOException e1) {
			logger.error(e1.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		} finally {
			UtilBean.initNullObject(bean);
		}
		// buscar(e);
	}

	/**
	 * Validar.
	 */
	private void validar() {
		logger.debug("Validando... ");
		Persona bean = (Persona) profesionalBean.getPersona();
		bean.setProfesional(profesionalBean);
		logger.debug(bean.getNumeroDocumentoIdentidad());
		if (bean.getId() != null && (bean.getId().equals(0L))) {
			bean.setId(null);
			//"#{sesionMB.usuarioSesion.persona.nombres} #{sesionMB.usuarioSesion.persona.apellidoPaterno}"
			//nuevo
			bean.setFechaCreacion(new Date());
			bean.setIdUsuarioCreador(getUsuarioSesion().getUsuario().getId());
			
			//nuevo
			bean.getProfesional().setFechaCreacion(new Date());
			bean.getProfesional().setIdUsuarioCreador(getUsuarioSesion().getUsuario().getId());
			bean.getProfesional().setCodigoOficinaAsociada(getUsuarioSesion().getUsuario().getCodigoOficinaAsociada());
		}
		if (bean.getProfesional().getId() != null
				&& bean.getProfesional().getId().equals(0L)) {
			bean.getProfesional().setId(null);
		}
		if (bean.getNumeroDocumentoIdentidad() == null
				|| bean.getNumeroDocumentoIdentidad().equals("")) {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Debe ingresar el numero de documento"));
		}
		
		if (bean.getProfesional().getCategoriaLicenciaDeConducir() != null
				&& bean.getProfesional().getCategoriaLicenciaDeConducir().compareTo(0) == 0) {
			bean.getProfesional().setCategoriaLicenciaDeConducir(null);
		}
//		if (bean.getLugarNacimiento() != null
//				&& (bean.getLugarNacimiento().getId() == null || bean
//						.getLugarNacimiento().getId().equals(0L))) {
//			bean.setLugarNacimiento(null);
//		}
//		if (bean.getLugarResidencia() != null
//				&& (bean.getLugarResidencia().getId() == null || bean
//						.getLugarResidencia().getId().equals(0L))) {
//			bean.setLugarResidencia(null);
//		}
//		if (bean.getNumeroDocumentoIdentidad() != null
//				&& bean.getTipoDocumentoIdentidad().getId().equals(1L)) {
//			if (!isNumber(bean.getNumeroDocumentoIdentidad())) {
//				throw new ValidatorException(
//						agregarMensajeErrorTransaccion("Debe ingresar el DNI correctamente"));
//			}
//		}

	}

	/**
	 * metodo que valida si es numero.
	 *
	 * @param campo 
	 * @return true, si es numero false caso contrario
	 */
	private boolean isNumber(String campo) {
		try {
			int a = Integer.parseInt(campo.trim());
			logger.debug("convertido a:" + a);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Guardar archivo.
	 *
	 * @param bean the bean
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String guardarArchivo(Persona bean) throws IOException {
		String codArchiUpload = "";
		if (this.beanUpload.getArchivoUpload() != null
				&& this.beanUpload.getArchivoUpload().getSize() > 0) {
			String rutaAGuardar = UtilBean.getParametrosMap().get("CARPETA_CV") + File.separator
					+ bean.getNumeroDocumentoIdentidad() + File.separator;
			codArchiUpload = "CV_"
					+ bean.getNumeroDocumentoIdentidad()
					+ UtilBean.getExtension(this.beanUpload.getArchivoUpload()
							.getName());
			String[] retornoCargaArchivo = this.beanUpload.guardarArchivo(
					rutaAGuardar, codArchiUpload);
			if (retornoCargaArchivo[0] != null
					&& !retornoCargaArchivo[0].equals(Constantes.CODIGO_OK)) {
				agregarMensajeErrorTransaccion(retornoCargaArchivo[1]);
				codArchiUpload = null;
			}
		}
		return codArchiUpload;
	}

	/**
	 * Guardar foto.
	 *
	 * @param bean the bean
	 * @return the string
	 * @throws IOException cuando se ha producido una excepción de E/S
	 */
	public String guardarFoto(Persona bean) throws IOException {
		String codArchiUpload = "";
		if (this.beanUploadFoto.getArchivoUpload() != null
				&& this.beanUploadFoto.getArchivoUpload().getSize() > 0) {
			String rutaAGuardar = UtilBean.getParametrosMap().get("CARPETA_FOTOS") + File.separator
					+ bean.getNumeroDocumentoIdentidad() + File.separator;
			codArchiUpload = "FT_"
					+ bean.getNumeroDocumentoIdentidad()
					+ UtilBean.getExtension(this.beanUploadFoto
							.getArchivoUpload().getName());
			String[] retornoCargaArchivo = this.beanUploadFoto.guardarArchivo(
					rutaAGuardar, codArchiUpload);
			if (retornoCargaArchivo[0] != null
					&& !retornoCargaArchivo[0].equals(Constantes.CODIGO_OK)) {
				agregarMensajeErrorTransaccion(retornoCargaArchivo[1]);
				codArchiUpload = null;
			}
		}
		return codArchiUpload;
	}

	/**
	 * Mostrar upload.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void mostrarUpload(ActionEvent e) {
		logger.debug("Obteniendo... ");
		// String curriculumPrm = (String) getRowParameter(e, "curriculumPrm");
		Profesional profesional = (Profesional) getRowParameter(e,
				"profesionalPrm");
		String rutaGuardada = UtilBean.getParametrosMap().get("CARPETA_CV") + File.separator
				+ profesional.getPersona().getNumeroDocumentoIdentidad()
				+ File.separator;
		UploaderBean
				.descargarArchivo(rutaGuardada, profesional.getCurriculum());
	}

	
	
	/**
	 * Limpiar curriculum.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void limpiarCurriculum(ActionEvent e) {
		profesionalBean.setCurriculum(null);
	}
	
	public void cambiarClaveUsuario(ActionEvent e) {		
		try {
			if (!"".equals(nuevaClave)) {
				Usuario usuario = getServicio().getMaestroService().buscarUsuarioPorIdPersona(profesionalBean.getPersona().getId());
				if (usuario == null) {
					usuario = new Usuario();
					usuario.setPersona(profesionalBean.getPersona());
					usuario.setRol(Constantes.ROL_PROFESIONAL);
					usuario.setNombreUsuario(nuevoUsuario);
					usuario.setClaveUsuario(nuevaClave);
				} else {
					usuario.setClaveUsuario(nuevaClave);
				}
				getServicio().getPersonaService().saveObject(usuario);					
				agregarMensajeExitoTransaccion("Usuario guardado correctamente");
			} else {
				agregarMensajeErrorTransaccion("No se guardaron datos");
			}
			
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		}
	}
	public void guardarUsuario(ActionEvent e) {
		if (profesionalBean.getPersona().getId() != null && profesionalBean.getPersona().getId().compareTo(0L) == 0) {
			guardar(e);
		}
		
		try {
			Usuario usuario = getUsuarioSesion().getPersona().getUsuario();
			if (usuario == null || usuario.getId() == null || usuario.getId().compareTo(0L) == 0) {
				usuario = new Usuario();
			}
			String nombreUsuario = getUsuarioSesion().getPersona().getUsuario().getNombreUsuario();
			String clave = getUsuarioSesion().getPersona().getUsuario().getClaveUsuario();
			usuario.setPersona(profesionalBean.getPersona());
			usuario.setRol(Constantes.ROL_PROFESIONAL);
			usuario.setNombreUsuario(nombreUsuario);
			if (!"".equals(clave)) {
				usuario.setClaveUsuario(clave);
				getServicio().getPersonaService().saveObject(usuario);
				profesionalBean.getPersona().setUsuario(usuario);
				getUsuarioSesion().getPersona().setUsuario(usuario);
				agregarMensajeExitoTransaccion("Usuario guardado correctamente");
			} else {
				agregarMensajeErrorTransaccion("No se guardaron datos");
			}
			
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("No se pudo guardar");
		}
	}
}
