package pe.gob.trabajo.pcd.servicio.spring.programado;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.lucene.store.jdbc.JdbcDirectory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import pe.gob.trabajo.pcd.servicio.lucene.busqueda.Indexer;
import pe.gob.trabajo.pcd.servicio.maestro.MaestroService;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;


// TODO: Auto-generated Javadoc
/**
 * The Class CronServiceImpl.
 */
public class CronServiceImpl implements Job {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CronServiceImpl.class);
	
	/** The maestro service. */
private MaestroService maestroService;

//	public MaestroDAO getMaestroDAO() {
//		if (maestroDAO == null) {
//			String nombreBean = "MaestroDAO";
//			ApplicationContext appContext;
//			ServletContext context = (ServletContext) FacesContext
//					.getCurrentInstance().getExternalContext().getContext();
//			appContext = WebApplicationContextUtils
//					.getRequiredWebApplicationContext(context);
//			maestroDAO = (MaestroDAO) appContext.getBean(nombreBean);
//		}
//		return maestroDAO;
//	}

//	public void setMaestroDAO(MaestroDAO maestroDAO) {
//		this.maestroDAO = maestroDAO;
//	}

	/**
 * Gets the maestro service.
 *
 * @return the maestro service
 */
public MaestroService getMaestroService() {
		return maestroService;
	}

	/**
	 * Sets the maestro service.
	 *
	 * @param maestroService the new maestro service
	 */
	public void setMaestroService(MaestroService maestroService) {
		this.maestroService = maestroService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
		
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		indexarArchivos();
	}
	
	/**
	 * Indexar archivos.
	 */
	public void indexarArchivos(){
		try {
			logger.info("Indexando...");
			Indexer.indexarCarpeta(UtilBean.getParametrosMap().get("CARPETA_CV").toString(), UtilBean.getParametrosMap().get("CARPETA_CV").toString());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
	}
	
	/**
	 * Indexar archivos bd.
	 */
	public static void indexarArchivosBD() {
		JdbcDirectory jdbcDir = UtilBean.getJdbcIndexDir();
		try {
			if (!jdbcDir.tableExists()) {
				jdbcDir.create();				
			} 
			Indexer.indexarCarpetaBD(jdbcDir, UtilBean.getParametrosMap().get("CARPETA_CV").toString());
		} catch (IOException e) {
			logger.error(e.getStackTrace());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
	}

}
