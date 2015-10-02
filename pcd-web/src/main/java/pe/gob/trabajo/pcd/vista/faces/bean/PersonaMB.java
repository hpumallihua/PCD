package pe.gob.trabajo.pcd.vista.faces.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.vista.bean.UploaderBean;

import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Ubigeo;


// TODO: Auto-generated Javadoc
/**
 * The Class PersonaMB.
 */
public class PersonaMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(PersonaMB.class);

	/** The lista personas. */
	private List<Persona> listaPersonas;
	
	/** The persona buscada. */
	private Persona personaBuscada;

	/** The bean upload. */
	private UploaderBean beanUpload = new UploaderBean();
	
	/** The bean upload foto. */
	private UploaderBean beanUploadFoto = new UploaderBean();
	
	/** The persona bean. */
	private Persona personaBean;

	/**
	 * Gets the persona bean.
	 *
	 * @return the persona bean
	 */
	public Persona getPersonaBean() {
		return personaBean;
	}

	/**
	 * Sets the persona bean.
	 *
	 * @param personaBean the new persona bean
	 */
	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	/**
	 * Instantiates a new persona mb.
	 */
	public PersonaMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	@Override
	public void init() {
//		Persona bean = (Persona) getSpringBean("PersonaProt");
//		logger.debug("PersonaProt: persona:" + bean);
////		logger.debug("PersonaProt: postulante:" + bean.getPostulante());
//		setBean(bean);
//
//		Persona beanBusqueda = (Persona) getSpringBean("PersonaProt");
//		logger.debug("PersonaProt: persona:" + bean);
////		logger.debug("PersonaProt: postulante:" + bean.getPostulante());
//		setPersonaBuscada(beanBusqueda);
//
//		beanUpload = new UploaderBean();
//		beanUploadFoto = new UploaderBean();
	}

	/**
	 * Inits the.
	 *
	 * @param e the e
	 */
	public void init(ActionEvent e) {
		init();
	}

	/**
	 * Nuevo.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		init();
	}

	/**
	 * Gets the persona buscada.
	 *
	 * @return the persona buscada
	 */
	public Persona getPersonaBuscada() {
		return personaBuscada;
	}

	/**
	 * Sets the persona buscada.
	 *
	 * @param personaBuscada the new persona buscada
	 */
	public void setPersonaBuscada(Persona personaBuscada) {
		this.personaBuscada = personaBuscada;
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
	 * Guardar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void guardar(ActionEvent e) {
//		logger.debug("Guardando... ");
//		Persona bean = (Persona) getBean();
//		bean.getPostulante().setFchaCrcon(getTime());
//		bean.getPostulante().setUsroCrdor(getUsuarioSesion().getUsuario().getNmbreUsro());
//		bean.getPostulante().setFchaActlzcon(getTime());
//		bean.getPostulante().setUsroActlzdor(getUsuarioSesion().getUsuario().getNmbreUsro());
//		
//		logger.debug(bean.getDcmntoIdntdad());
//		logger.debug(bean.getDcmntoIdntdad().equals(""));
//		if (bean.getDcmntoIdntdad() == null
//				|| bean.getDcmntoIdntdad().equals("")) {
//			throw new ValidatorException(
//					agregarMensajeError("Debe ingresar el numero de documento"));
//		}
//		try {
//			String curriculum = guardarArchivo(bean);
//			if (curriculum != null && !curriculum.equals("")) {
//				bean.getPostulante().setCrrclum(curriculum);
//			}
//			String foto = guardarFoto(bean);
//			if (foto != null && !foto.equals("")) {
//				bean.setFtgrfia(foto);
//			}
//		} catch (IOException e1) {
//			logger.error(e1.getStackTrace());
//		}
//		getServicio().getPersonaService().guardarPersona(bean);
//		logger.debug("Guardado: " + bean.getIdPrsna());
//		buscar(e);
	}

	/**
	 * Editar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {
//		logger.debug("Obteniendo... ");
//		Long id = (Long) getRowParameter(e, "personaIdPrm");
//		Persona bean = getServicio().getPersonaService()
//				.obtenerPostulantePorPersona(id).getPersona();
//		setBean(bean);
//		logger.debug("Obtenido: " + bean.getTpoDcmntoIdntdad());
	}

	/**
	 * Gets the lista personas.
	 *
	 * @return the lista personas
	 */
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	/**
	 * Buscar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscar(ActionEvent e) {
		listaPersonas = getServicio().getPersonaService().buscarPorEjemplo(
				getPersonaBuscada());
	}

	/**
	 * Gets the personas.
	 *
	 * @return the personas
	 */
	public List<Persona> getPersonas() {
		// List<Persona> lista = null;
		// try {
		// lista = (List<Persona>) getServicio().getPersonaService().getAll();
		// } catch (Exception e) {
		// logger.error(e.getStackTrace());
		// }
		// for (Persona persona : lista) {
		// logger.debug(persona.getAplldoPtrno());
		// }
		// return lista;
		return listaPersonas;
	}

	/**
	 * Buscar persona.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarPersona(ActionEvent e) {
//		logger.debug("Evento...");
//		Persona bean = (Persona) getBean();
//		Integer tipoDoc = bean.getTpoDcmntoIdntdad();
//		logger.debug("Tipo:" + bean.getTpoDcmntoIdntdad());
//		logger.debug("Numero:" + bean.getDcmntoIdntdad());
//
//		if (bean.getDcmntoIdntdad().length() > 3) {
//			logger.debug("Buscar...");
//			Persona beanBuscado = getServicio().getPersonaService()
//					.buscarPorDocumentoIdentidad(bean.getTpoDcmntoIdntdad(),
//							bean.getDcmntoIdntdad());
//			if (beanBuscado != null) {
//				setBean(beanBuscado);
//			} else {
//				init();
//				((Persona) getBean()).setTpoDcmntoIdntdad(tipoDoc);
//			}
//		}
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
//		if (this.beanUpload.getArchivoUpload() != null && this.beanUpload.getArchivoUpload().getSize() > 0) {
//			String rutaAGuardar = "C:\\archivosRich\\";// getParametro(Constantes.RUTA_DOCUMENTOS);
//			codArchiUpload = bean.getDcmntoIdntdad() + "_" + this.beanUpload.getArchivoUpload().getName();
//			String navegacion_nomArchivo = this.beanUpload.guardarArchivo(rutaAGuardar, codArchiUpload);
////			navegacion_nomArchivo = this.beanUpload.getArchivoUpload().getName();
//		}
		return codArchiUpload;
	}
	
	/**
	 * Mostrar upload.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void mostrarUpload(ActionEvent e) {
		logger.debug("Obteniendo... ");
		String curriculumPrm = (String) getRowParameter(e, "curriculumPrm");
		String rutaGuardada = "C:\\archivosRich\\";
		UploaderBean.descargarArchivo(rutaGuardada, curriculumPrm);
	}
	
	/**
	 * Guardar foto.
	 *
	 * @param bean the bean
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String guardarFoto(Persona bean) throws IOException {
		String codArchiUpload = "";
//		if (this.beanUploadFoto.getArchivoUpload() != null && this.beanUploadFoto.getArchivoUpload().getSize() > 0) {
//			String rutaAGuardar = "C:\\archivosRich\\";// getParametro(Constantes.RUTA_DOCUMENTOS);
//			codArchiUpload = bean.getDcmntoIdntdad() + "_" + this.beanUploadFoto.getArchivoUpload().getName();
//			String navegacion_nomArchivo = this.beanUploadFoto.guardarArchivo(rutaAGuardar, codArchiUpload);
//		}
		return codArchiUpload;
	}
	
	/**
	 * Autocomplete.
	 *
	 * @param suggest the suggest
	 * @return the list
	 */
	public List<Persona> autocomplete(Object suggest) {
        String pref = (String)suggest;
        ArrayList<Persona> result = (ArrayList<Persona>) getServicio().getPersonaService().buscarPorTexto(pref);
        
//        List<Persona> consulta = (ArrayList<Persona>) getServicio().getPersonaService().buscarPorTexto(pref);
//        
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
	
	/**
	 * Seleccion departamento.
	 *
	 * @param e the e
	 */
	public void seleccionDepartamento(ValueChangeEvent e) {
		logger.debug("seleccionDepartamento");
		getDepartamento().setIdDprtmnto((String)e.getNewValue());
		logger.debug(e.getNewValue());
		setProvincia(new Ubigeo());
	}
	
	/**
	 * Seleccion provincia.
	 *
	 * @param e the e
	 */
	public void seleccionProvincia(ValueChangeEvent e) {
		logger.debug("seleccionProvincia");
		getProvincia().setIdDprtmnto(getDepartamento().getIdDprtmnto());
		getProvincia().setIdPrvnca((String)e.getNewValue());
		logger.debug(e.getNewValue());
		setDistrito(new Ubigeo());
	}
	
	/**
	 * Seleccion distrito.
	 *
	 * @param e the e
	 */
	public void seleccionDistrito(ValueChangeEvent e) {
		logger.debug("seleccionDistrito");
		getDistrito().setIdDprtmnto(getDepartamento().getIdDprtmnto());
		getDistrito().setIdPrvnca(getProvincia().getIdPrvnca());
		getDistrito().setIdDstrto((String)e.getNewValue());
		logger.debug(e.getNewValue());
	}

}
