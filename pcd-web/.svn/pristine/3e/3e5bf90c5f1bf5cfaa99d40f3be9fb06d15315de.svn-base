package pe.gob.trabajo.pcd.vista.bean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.ContentTypeManager;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;


// TODO: Auto-generated Javadoc
/**
 * The Class UploaderBean.
 */
public class UploaderBean implements Serializable {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(UploaderBean.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5795405519716114155L;
	
	/** The Constant MSG_UPLOAD_OK. */
	private static final String MSG_UPLOAD_OK  = "El Archivo se Cargo Satisfactoriamente.";
	
	/** The Constant MSG_UPLOAD_NOK. */
	private static final String MSG_UPLOAD_NOK = "El Archivo Cargado es Superior a los 2MB Permitidos.";

	/** The archivo upload. */
	private UploadedFile archivoUpload;
	
	/** The root path. */
	private String rootPath;
	
	/** The fichero. */
	private File fichero;
	
	/** The directorio. */
	private File directorio;
	
	/** The cod upload. */
	private int codUpload;

	// Mensajes Salida
	/** The msj nom archivo. */
	private String msjNomArchivo;
	
	/** The msj ruta archivo. */
	private String msjRutaArchivo;
	
	/** The msjvalidator upload archivo. */
	private String msjvalidatorUploadArchivo;
	
	/** The validator upload archivo. */
	private boolean validatorUploadArchivo;

	/**
	 * Instantiates a new uploader bean.
	 */
	public UploaderBean() {
		this.rootPath = "";
		this.fichero = null;
		this.directorio = null;
	}
	
	/**
	 * Download file.
	 *
	 * @return the string
	 */
	public String downloadFile(){
		logger.debug("downloadFile---->" + msjRutaArchivo + msjNomArchivo);
		descargarArchivo(msjRutaArchivo, msjNomArchivo);
		return "#";
	}
	
	/**
	 * Download listener.
	 *
	 * @param e the e
	 */
	public void downloadListener(ActionEvent e){
		UIParameter parmUIRuta = (UIParameter) e.getComponent().findComponent("ruta");
		msjRutaArchivo = parmUIRuta.getValue().toString();
		UIParameter parmUIArchivo = (UIParameter) e.getComponent().findComponent("archivo");
		msjNomArchivo = parmUIArchivo.getValue().toString();
		logger.debug("downloadListener---->" + msjRutaArchivo + msjNomArchivo);
	}

	/**
	 * Descargar archivo.
	 *
	 * @param dirdestino the dirdestino
	 * @param nombreArchivo the nombre archivo
	 */
	public static void descargarArchivo(String dirdestino, String nombreArchivo) {

		BufferedInputStream input = null;
		try {
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			
			String directorio = dirdestino;
			String destino = directorio + nombreArchivo;
			
			input = new BufferedInputStream(
					new FileInputStream(destino));
			int contentLength = input.available();
			
			response.setContentType(ContentTypeManager.getContenTypeByString(nombreArchivo));
			response.setContentLength(contentLength);
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ nombreArchivo + "\"");
			
			// Escribe el contenido de los ficheros de respuesta.
			while (contentLength-- > 0) {
				response.getOutputStream().write(input.read());
			}
			
			context.responseComplete();
		} catch (FileNotFoundException e) {
			setMessageError("Archivo no encontrado");
//			logger.error(e.getStackTrace());
		} catch (IOException e) {
			setMessageError("No se puede leer el archivo");
			logger.error(e.getStackTrace());
		} finally {
			try {
				if (input!=null) {
					input.close();					
				}
			} catch (IOException e) {
				logger.error(e.getStackTrace());
			}
		}
		
	}

	/**
	 * Guardar archivo.
	 *
	 * @param rutaArchivo the ruta archivo
	 * @param codArchiUpload the cod archi upload
	 * @return the string[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String[] guardarArchivo(String  rutaArchivo, String  codArchiUpload) throws IOException {
		logger.info("guardarArchivo...");
		
		String[] msgRETORNO = {"1","Error desconocido"};

		fichero = new File(archivoUpload.getName());
		logger.info("getContentType: " + this.archivoUpload.getContentType());
		logger.info("getName: " + this.archivoUpload.getName());
		logger.info("Ruta Upload 'ARCHIVO' 2: " + this.fichero);
		logger.info("getSize: " + this.archivoUpload.getSize());
		logger.info("Destino: " + rutaArchivo);
		
		Long tamanoMB = 1024 * 1024 * new Long(UtilBean.getParametrosMap().get("ARCHIVO_TAMANO_MAXIMO").toString());
		if (this.archivoUpload.getSize() <= tamanoMB) {
			directorio = new File(rutaArchivo);
			
			if (!(directorio.exists())) {
				logger.info("No existe la carpeta... creando... ");
				if (directorio.mkdirs()) {
					logger.info("Carpeta creada ");
				}
			} else {
				logger.info("Carpeta encontrada");
			}
			
			String rutaDestino = rutaArchivo + codArchiUpload;// + "." + fichero.getName().substring(fichero.getName().lastIndexOf('.') + 1);
			this.msjNomArchivo = codArchiUpload + "." + fichero.getName().substring(fichero.getName().lastIndexOf('.') + 1);
			
			byte[] fileData = archivoUpload.getBytes();
			InputStream input = archivoUpload.getInputStream();
			OutputStream output = new FileOutputStream(rutaDestino);
			
			while (true) {
				int n = input.read(fileData);
				
				if (n < 0) {
					break;
				}
				output.write(fileData, 0, n);
			}
			
			this.msjRutaArchivo = rutaDestino;
			this.msjvalidatorUploadArchivo = MSG_UPLOAD_OK;
			this.validatorUploadArchivo = true;
			
			input.close();
			output.close();
			
//				String contenType = ContentTypeManager.getContenTypeByString(fichero.getName());
			msgRETORNO[0] = Constantes.CODIGO_OK;
			msgRETORNO[1] = rutaArchivo + codArchiUpload;// + "." + fichero.getName().substring(fichero.getName().lastIndexOf('.') + 1);
		} else {
			logger.error("El tamano del archivo es mayor al permitido (" + UtilBean.getParametrosMap().get("ARCHIVO_TAMANO_MAXIMO") + " MB)");
			this.msjNomArchivo = "";
			this.msjRutaArchivo = "";
			this.msjvalidatorUploadArchivo = MSG_UPLOAD_NOK;
			this.validatorUploadArchivo = false;
			
			msgRETORNO[1] = "El tamaño del archivo es mayor al permitido (" + UtilBean.getParametrosMap().get("ARCHIVO_TAMANO_MAXIMO") + " MB)";
		}
		
		return msgRETORNO;
	}
	
	/**
	 * Copiar archivo.
	 *
	 * @param nombreAntiguo the nombre antiguo
	 * @param nombreArchivoFinal the nombre archivo final
	 */
	public static void copiarArchivo(String nombreAntiguo, String nombreArchivoFinal  ){
		String nombreFuente=nombreAntiguo;
		String nombreDestino=nombreArchivoFinal;
		FileInputStream fis;
		try {
			fis = new FileInputStream(nombreFuente);
			FileOutputStream fos = new FileOutputStream(nombreDestino); 
			FileChannel canalFuente = fis.getChannel(); 
			FileChannel canalDestino = fos.getChannel(); 
			canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
			fis.close(); 
			fos.close(); 
		} catch (FileNotFoundException e) {
			setMessageError("No se encontró el archivo");
			logger.error(e.getStackTrace());
		} catch (IOException e) {
			setMessageError("No se pudo copiar el archivo");
			logger.error(e.getStackTrace());
		} 
		
	}

	/**
	 * Renombrar archivo.
	 *
	 * @param rutaNomArchivo_01 the ruta nom archivo_01
	 * @param rutaNomArchivo_02 the ruta nom archivo_02
	 * @return true, if successful
	 */
	public boolean renombrarArchivo(String rutaNomArchivo_01,
			String rutaNomArchivo_02) {
		File archivo_01 = new File(rutaNomArchivo_01.trim());
		File archivo_02 = new File(rutaNomArchivo_02.trim());
		boolean nomCorrecto = archivo_01.renameTo(archivo_02);

		logger.info("nomArchivo_01: " + archivo_01);
		logger.info("nomArchivo_02: " + archivo_02);
		logger.info("nomCorrecto: " + nomCorrecto);

		if (nomCorrecto == true) {
			logger.info("El Renombrado ha sido Correcto");
		} else {
			logger.info("El Renombrado no se ha podido Realizar");
		}

		return nomCorrecto;
	}

	/**
	 * Eliminar archivo.
	 *
	 * @param rutaNomArchivo_01 the ruta nom archivo_01
	 * @return true, if successful
	 */
	public boolean eliminarArchivo(String rutaNomArchivo_01) {
		File archivo_01 = new File(rutaNomArchivo_01);
		boolean eliminaArchivo = archivo_01.delete();

		logger.info("RUTA ARCHIVO ELIMINACION: " + archivo_01);

		if (eliminaArchivo == true) {
			logger.info("El Fichero '" + rutaNomArchivo_01
					+ "' ha sido Borrado Correctamente");
		} else {
			logger.info("El Fichero '" + rutaNomArchivo_01
					+ "' no se ha podido Borrar");
		}

		return eliminaArchivo;
	}
	
	

	/**
	 * Gets the root path.
	 *
	 * @return the root path
	 */
	public String getRootPath() {
		return rootPath;
	}

	/**
	 * Gets the fichero.
	 *
	 * @return the fichero
	 */
	public File getFichero() {
		return fichero;
	}

	/**
	 * Gets the directorio.
	 *
	 * @return the directorio
	 */
	public File getDirectorio() {
		return directorio;
	}

	/**
	 * Sets the root path.
	 *
	 * @param rootPath the new root path
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	/**
	 * Sets the fichero.
	 *
	 * @param fichero the new fichero
	 */
	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	/**
	 * Sets the directorio.
	 *
	 * @param directorio the new directorio
	 */
	public void setDirectorio(File directorio) {
		this.directorio = directorio;
	}

	/**
	 * Gets the archivo upload.
	 *
	 * @return the archivo upload
	 */
	public UploadedFile getArchivoUpload() {
		return archivoUpload;
	}

	/**
	 * Sets the archivo upload.
	 *
	 * @param archivoUpload the new archivo upload
	 */
	public void setArchivoUpload(UploadedFile archivoUpload) {
		this.archivoUpload = archivoUpload;
	}

	/**
	 * Gets the msj nom archivo.
	 *
	 * @return the msj nom archivo
	 */
	public String getMsjNomArchivo() {
		return msjNomArchivo;
	}

	/**
	 * Gets the msj ruta archivo.
	 *
	 * @return the msj ruta archivo
	 */
	public String getMsjRutaArchivo() {
		return msjRutaArchivo;
	}

	/**
	 * Sets the msj nom archivo.
	 *
	 * @param msjNomArchivo the new msj nom archivo
	 */
	public void setMsjNomArchivo(String msjNomArchivo) {
		this.msjNomArchivo = msjNomArchivo;
	}

	/**
	 * Sets the msj ruta archivo.
	 *
	 * @param msjRutaArchivo the new msj ruta archivo
	 */
	public void setMsjRutaArchivo(String msjRutaArchivo) {
		this.msjRutaArchivo = msjRutaArchivo;
	}

	/**
	 * Gets the cod upload.
	 *
	 * @return the cod upload
	 */
	public int getCodUpload() {
		return codUpload;
	}

	/**
	 * Gets the msjvalidator upload archivo.
	 *
	 * @return the msjvalidator upload archivo
	 */
	public String getMsjvalidatorUploadArchivo() {
		return msjvalidatorUploadArchivo;
	}

	/**
	 * Sets the msjvalidator upload archivo.
	 *
	 * @param msjvalidatorUploadArchivo the new msjvalidator upload archivo
	 */
	public void setMsjvalidatorUploadArchivo(String msjvalidatorUploadArchivo) {
		this.msjvalidatorUploadArchivo = msjvalidatorUploadArchivo;
	}

	/**
	 * Checks if is validator upload archivo.
	 *
	 * @return true, if is validator upload archivo
	 */
	public boolean isValidatorUploadArchivo() {
		return validatorUploadArchivo;
	}

	/**
	 * Sets the validator upload archivo.
	 *
	 * @param validatorUploadArchivo the new validator upload archivo
	 */
	public void setValidatorUploadArchivo(boolean validatorUploadArchivo) {
		this.validatorUploadArchivo = validatorUploadArchivo;
	}

	/**
	 * Sets the cod upload.
	 *
	 * @param codUpload the new cod upload
	 */
	public void setCodUpload(int codUpload) {
		this.codUpload = codUpload;
	}

	/**
	 * Gets the serial version uid.
	 *
	 * @return the serial version uid
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	/**
	 * Sets the message error.
	 *
	 * @param msg the new message error
	 */
	protected static void setMessageError(String msg){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
        throw new ValidatorException(message);
    }

}