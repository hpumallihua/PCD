package pe.gob.trabajo.pcd.servicio.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringApplicationContextProvider.
 */
public class SpringApplicationContextProvider implements ApplicationContextAware {
	
	/** The context. */
	private static ApplicationContext CONTEXT;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext context) throws BeansException {
	    CONTEXT = context;
	}
	
	/**
	 * Gets the bean.
	 *
	 * @param beanName the bean name
	 * @return the bean
	 */
	public static Object getBean(String beanName) {
	    return CONTEXT.getBean(beanName);
	}

}
