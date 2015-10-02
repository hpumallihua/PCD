package pe.gob.trabajo.pcd.vista.faces.bean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.ContentTypeManager;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

import pe.gob.trabajo.pcd.modelo.dominio.Persona;

// TODO: Auto-generated Javadoc
/**
 * The Class ImagenBean.
 */
public class ImagenBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(ImagenBean.class);

	/** The image. */
	private BufferedImage image;

	/**
	 * Paint.
	 *
	 * @param OutputStream out
	 * @param Object data
	 * @throws IOException cuando se ha producido una excepción de E/S.
	 */
	public void paint(OutputStream out, Object data) throws IOException {
//		logger.debug(data);
//		try {
			if (data instanceof Persona) {
				Persona persona = (Persona) data;
				String foto = Constantes.FOTO_DEFECTO;
				if (persona.getFotografia() != null
						&& !persona.getFotografia().equals("")) {
					foto = persona.getFotografia();
				}
//				String archivo = Constantes.CARPETA_FOTOS + foto;
				String archivo = UtilBean.getParametrosMap().get("CARPETA_FOTOS") + File.separator + persona.getNumeroDocumentoIdentidad() + File.separator +  foto;
				File archivoObj = new File(archivo);
				if (!archivoObj.exists()) {
					archivoObj = new File(UtilBean.getParametrosMap().get("CARPETA_FOTOS") + File.separator
							+ Constantes.IMAGEN_DEFECTO);
					InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/images/foto.gif");
					image = ImageIO.read(is);					
				} else {
					image = ImageIO.read(archivoObj);					
				}
				ImageIO.write(image, ContentTypeManager.getTypeByString(archivo),out);
			}
			
			if (data instanceof String) {
				String imagen = (String)data;
				String foto = Constantes.FOTO_DEFECTO;
				if (imagen !=null && !imagen.equals("")) {
					foto = imagen;
				}
				String archivo = Constantes.CARPETA_IMAGENES_PREGUNTAS + foto;
				File archivoObj = new File(archivo);
				if (!archivoObj.exists()) {
					archivoObj = new File(Constantes.CARPETA_IMAGENES_PREGUNTAS
							+ Constantes.IMAGEN_DEFECTO);
				}
				image = ImageIO.read(archivoObj);
				ImageIO.write(image,ContentTypeManager.getTypeByString(archivo),out);
			}
			
//		} catch (Exception e) {
//			logger.error(e.getStackTrace());
//		}
	}
			
}