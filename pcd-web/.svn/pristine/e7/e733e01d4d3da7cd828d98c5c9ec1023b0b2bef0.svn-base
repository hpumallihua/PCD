package pe.gob.trabajo.pcd.vista.seguridad;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;




// TODO: Auto-generated Javadoc
/**
 * The Class FiltroSesionUsuario.
 *
 * @author Silnet
 * The Class FiltroSesionUsuario.
 */
public class FiltroSesion implements Filter {
	
	/** The logger. */
	private Log logger = LogFactory.getLog(this.getClass());

	/** The Constant SESION_USUARIO_ID. */
	public static final String SESION_USUARIO_ID = "FiltroSesion.sesionActiva";
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) {
		// Nada.
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession();

		UsuarioSesion usuario = (UsuarioSesion) httpSession.getAttribute(SESION_USUARIO_ID);

		if (usuario == null) {
			this.logger.info("--------- FIN DE SESION ---------");
			httpSession.setAttribute(SESION_USUARIO_ID, null);
			httpResponse.sendRedirect(httpRequest.getContextPath()+ "/login.xhtml");
			return;
		}

		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// nada
	}

}
