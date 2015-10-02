package pe.gob.trabajo.pcd.servicio.util;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringUtil.
 */
public class SpringUtil {
	
	/**
	 * Gets the spring bean.
	 *
	 * @param nombreBean the nombre bean
	 * @return the spring bean
	 */
	public Object getSpringBean(String nombreBean){
		ApplicationContext appContext;
		ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		
//		appContext.
		
		return appContext.getBean(nombreBean);
	}
	
	/**
	 * Gets the column heasingsf.
	 *
	 * @param factory the factory
	 * @param clazz the clazz
	 * @return the column heasingsf
	 */
	public String[] getColumnHeasingsf(SessionFactory factory, Class clazz ) {
		
//		ClassMetadata metaClass = factory.getClassMetadata(clazz);
//		metaClass.get
//		logger.info(Hibernate.entity(clazz).toString());
		
		String[] mYp = factory.getClassMetadata(clazz).getPropertyNames();  
//		logger.info("getColumnHeasingsf: "+mYp.length);  
//		for (int i = 0; i < mYp.length; i++) {  
//			logger.info("getColumnHeasingsf: "+i+":"+mYp[i]);  
//		}  
		
		return mYp; 
	} 
}
