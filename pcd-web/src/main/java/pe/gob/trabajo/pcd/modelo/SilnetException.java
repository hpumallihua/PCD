package pe.gob.trabajo.pcd.modelo;

import org.apache.log4j.Logger;

public class SilnetException extends Exception {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(SilnetException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -6028271267923434937L;

	public SilnetException(Exception e) {
		logger.error(e.getStackTrace());
	}
}
