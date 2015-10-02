package pe.gob.trabajo.pcd.vista.faces.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import pe.gob.trabajo.pcd.App;
import pe.gob.trabajo.pcd.servicio.maestro.MaestroService;
import pe.gob.trabajo.pcd.servicio.spring.programado.CronServiceImpl;
import pe.gob.trabajo.pcd.servicio.util.SpringApplicationContextProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class SilnetIni.
 */
public class SilnetIni implements ServletContextListener, Job {

	/** The logger. */
	private static Logger logger = Logger.getLogger(SilnetIni.class);

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent e) {
		// Call your function from the event object here
		logger.info("SERVLET CARGADO");
		printParametrosApp();
		
		System.out.println("Primera ejecucion cargarDatos.");
		cargarDatos();
		try {
			startScheduler();
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("Cerrando silnet ...");
	}
	
	protected void startScheduler() throws SchedulerException, ParseException {
		
	    Properties properties = new Properties(); 
	    try {
	    	properties.load(SilnetIni.class.getClassLoader().getResourceAsStream("quartz.properties"));

	        } 
	   catch (IOException ex) {
	        ex.printStackTrace();
	    }
	    
//		SchedulerFactory sf=new StdSchedulerFactory();
		StdSchedulerFactory sf = new StdSchedulerFactory();
		sf.initialize(properties);
		
		Scheduler sched=sf.getScheduler();
		sched.start();
		
		JobDetail maestrosJob = new JobDetail("maestrosJob",sched.DEFAULT_GROUP,SilnetIni.class);
		CronTrigger maestrosTrigger = new CronTrigger();
		maestrosTrigger.setCronExpression(properties.getProperty("pe.gob.trabajo.pcd.CronExpression.maestros","0 0 23 * * ?"));
		maestrosTrigger.setName("maestrosTrigger");
		
		sched.scheduleJob(maestrosJob, maestrosTrigger);
		
//		SimpleTrigger st=new SimpleTrigger("mytrigger",sched.DEFAULT_GROUP,new Date(),
//				null,SimpleTrigger.REPEAT_INDEFINITELY,30L*1000L);
		
		
		
		JobDetail indexerJob = new JobDetail("indexerJob", sched.DEFAULT_GROUP, CronServiceImpl.class);		
		CronTrigger indexerTrigger = new CronTrigger();
		indexerTrigger.setCronExpression(properties.getProperty("pe.gob.trabajo.pcd.CronExpression.indexer","0 0 23 * * ?"));
		indexerTrigger.setName("mytriggerIndex");
		
		sched.scheduleJob(indexerJob, indexerTrigger);
		
		
	}
	
	public void cargarDatos() {
		String nombreBean = "MaestroService";
		MaestroService maestroService = (MaestroService) SpringApplicationContextProvider
				.getBean(nombreBean);
		// Carga de datos inicial
		logger.info("Cargando Datos de Maestros ...");
//		System.setProperty("logfile.name", UtilBean.getParametrosMap().get("LOG_FILE").toString());
//		logger.info("logfile.name asignado !");
		maestroService.loadData();
		logger.info("Datos de Maestros Cargados !");
	}


	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		cargarDatos();
	}
	
	public void printParametrosApp() {
		UtilBean.actualizarParametros();
		Map<String, Object> map = UtilBean.getParametrosMap();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
		    logger.info(entry.getKey() + "/" + entry.getValue());
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}

}
