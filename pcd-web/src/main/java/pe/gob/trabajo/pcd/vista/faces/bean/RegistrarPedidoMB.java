package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empleador;
import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EspecialidadProfesional;
import pe.gob.trabajo.pcd.modelo.dominio.Establecimiento;
import pe.gob.trabajo.pcd.modelo.dominio.Idioma;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Postulacion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarPedidoMB.
 */
public class RegistrarPedidoMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(RegistrarPedidoMB.class);
	
	/** The pedido bean. */
	private Pedido	  pedidoBean;
	
	/** The filters for search. */
	private BusquedaBean busquedaBean;
	private String descripcionPedido;
	private Date   fechaIni;
	private Date   fechaFin;
	private Empresa empresaBean;
	
	/** The list pedidos. */
	List<Pedido> listaPedidos = new ArrayList<Pedido>();
	
	/** The list profesionales.	 */
	List<Profesional> listaPersonasPedido = new ArrayList<Profesional>();
	
	/** The list postulaciones. */
	List<Postulacion> listaPostulaciones = new ArrayList<Postulacion>();
	
	/**
	 * Instantiates a new registrar pedido mb.
	 */
	public RegistrarPedidoMB() {
		init();
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		Pedido bean = (Pedido) getSpringBean("PedidoPrt");
		logger.debug("PedidoPrt: Pedido:" + bean);
		setPedidoBean(bean);
		
		Empresa empresa  = new Empresa(); 
		
		busquedaBean = new BusquedaBean();
		setAccionRealizada(Constantes.ACCION_NUEVO);
		listaPedidos = new ArrayList<Pedido>();  
		listaPostulaciones = new ArrayList<Postulacion>();
		logger.debug("Rol :"+getUsuarioSesion().getUsuario().getRol().getDescripcion());
				
		if (empresaBean!=null && getUsuarioSesion().isRolAdministrador()) {
			Empresa empresasession = empresaBean;
		} else {
			empresaBean = new Empresa();
		}
	}
	
	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		init();
		logger.debug("Nuevo Pedido... ");
	}
	
	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {
		logger.debug("Guardando pedido... ");
		Pedido bean = pedidoBean;
		validar();
		Empresa emp = new Empresa();
		emp.setId(pedidoBean.getEmpleador().getId());
		bean.setEmpleador(emp);
		try {
			if (bean.getId()==null) {
				bean.setFechaRegistro(new Date());
			} 
			if ("0".equals(bean.getEstadoRegistro())) {
				bean.setFechaCierre(new Date());
			}
			Pedido pedidoGuardada = (Pedido) getServicio().getPedidoService().guardarPedido(bean);
			if (pedidoGuardada != null && pedidoGuardada.getId() !=null && pedidoGuardada.getId().compareTo(0L) == 1) {
				setPedidoBean(pedidoGuardada);
				agregarMensajeExitoTransaccion("Datos del puesto guardados correctamente");
				logger.debug("Guardado  : " + bean.getId());
			}
			//init(); 
		} catch (Exception e1) {
			logger.error(e1.getStackTrace());
			e1.printStackTrace();
			agregarMensajeErrorTransaccion("No se pudo guardar el pedido");
		} finally {
			UtilBean.initNullObject(bean);
		}
	}
	
	/**
	 * Metodo encargado de validar todos los campos obligatorios..
	 */
	private void validar() {
		logger.debug("Validando empresa... ");
		Pedido bean = (Pedido) pedidoBean;
		logger.debug(bean.getDescripcion());
		if (bean.getId() != null && (bean.getId().equals(0L))) {
			bean.setId(null);
		}
	}
	
	/**
	 * Limpiar busqueda.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void limpiarBusqueda(ActionEvent e) {
		init();
	}
	
	/**
	 * devuelve items de tipo cargo.
	 *
	 * @return lista de items tipo cargo
	 */
	public List<?> getItemsCargo(){
		List<PersonaCargo> lista = (List<PersonaCargo>) getServicio().getMaestroService().getMaestroPersonaCargo();
		return Items.getItems(lista, "nombre", "id");
	}
	
	/**
	 * devuelve items de tipo nivel educativo.
	 *
	 * @return the items nivel educativo
	 */
	public List<?> getItemsNivelEducativo(){
		List<NivelEducativo> lista = (List<NivelEducativo>) getServicio().getMaestroService().getMaestroNivelesEducativos();
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * devuelve items de tipo ocupacion.
	 *
	 * @return lista de items tipo ocupacion
	 */
	public List<?> getItemsOcupacion(){
		List<Ocupacion> lista = (List<Ocupacion>) getServicio().getMaestroService().buscarOcupaciones(null);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * devuelve items de tipo profesion.
	 *
	 * @return lista de items tipo profesion
	 */
	public List<?> getItemsProfesion(){
		List<Profesion> lista = (List<Profesion>) getServicio().getMaestroService().buscarProfesiones(null);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * devuelve items de tipo idioma.
	 *
	 * @return lista de items tipo idioma
	 */
	public List<?> getItemsIdioma(){
		List<Idioma> lista = (List<Idioma>) getServicio().getMaestroService().getAllObject(Idioma.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * devuelve items de tipo nivel idioma.
	 *
	 * @return lista de items tipo nivel idioma
	 */
	public List<?> getItemsNivelIdioma(){
		List<NivelIdioma> lista = (List<NivelIdioma>) getServicio().getMaestroService().getAllObject(NivelIdioma.class);
		return Items.getItems(lista, "valor", "id");
	}
	
	/**
	 * Metodo que busca empresa por RUC
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarEmpresa(ActionEvent e) {
		logger.debug("Validando empresa... ");
		Empresa empresa 	= pedidoBean.getEmpleador();
		String 	ruc 		= empresa.getRuc();
		logger.debug("Ruc: 				--"+ruc+"--");		
		if (empresa != null && ruc!= null && !ruc.equals("") && ruc.length() == 11) {
			Empresa empresaencontrada = (Empresa) getServicio().getPedidoService().buscarPorRuc(ruc);
			if (empresaencontrada!=null && empresaencontrada.getId() !=null && empresaencontrada.getId().compareTo(0L) == 1) {
				pedidoBean.setEmpleador(empresaencontrada);				
			} else {
				agregarMensajeErrorTransaccion("No se encontraron datos");
				init(); 
			}
		}	
		
	}
	
	/**
	 * Metodo que busca pedido
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscarPedido(ActionEvent e) {
		logger.debug("Validando datos de la busqueda... ");
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("Descripc: --"+descripcionPedido+"--");
		logger.debug("fechaIni: --"+fechaIni+"--");
		logger.debug("fechaFin: --"+fechaFin+"--");
		
		logger.debug("Descripc:      --"+busquedaBean.getPedido().getDescripcion()+"--");
		logger.debug("Fecha Ini:     --"+busquedaBean.getFechaRegistroIni()+"--");
		logger.debug("Fecha Fin:     --"+busquedaBean.getFechaRegistroFin()+"--");
		logger.debug("NiveEducativo: --"+busquedaBean.getPedido().getNivelEducativo()+"--");
		
		if (empresaBean!=null && getUsuarioSesion().isRolEmpleador()) {
			busquedaBean.setEmpresa(empresaBean);
		}
		
		listaPedidos = (ArrayList<Pedido>) getServicio().getPedidoService().buscarPedidos(busquedaBean);
		
	}	
	
	/**
	 * devuelve listado de pedidos.
	 *
	 * @return lista de pedidos
	 */
	public List<Pedido> getListaPedidos(){
		return listaPedidos;
	}
	
	/**
	 * devuelve listado de profesionales.
	 *
	 * @return lista de profesionales
	 */	
	public List<Profesional> getListaPersonasPedido() {
		List<Profesional> lista = new ArrayList<Profesional>();
		if (pedidoBean!=null) {
			
//			lista = getServicio().getProfesionalService().buscar			
		}
		return listaPersonasPedido;
	}

//	public void setListaPersonasPedido(List<Profesional> listaPersonasPedido) {
//		this.listaPersonasPedido = listaPersonasPedido;
//	}
	
	/**
	 * Metodo recibe un objeto Pedido y actualiza los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void editarPedido(ActionEvent e) {
		Pedido bean = (Pedido)getRowParameter(e, "pedidoPrm");
		setAccionRealizada(Constantes.ACCION_EDITAR);
		if (bean != null) {
			if (bean instanceof Pedido) {
				pedidoBean = bean;
			}
		}	
	}
	
	
	/**
	 * Metodo recibe un objeto Pedido y consulta los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void consultaPedido(ActionEvent e) {
		Pedido bean = (Pedido)getRowParameter(e, "pedidoPrm");
		setAccionRealizada(Constantes.ACCION_VISUALIZAR);
		if (bean != null) {
			if (bean instanceof Pedido) {
				pedidoBean = bean;
			}
		}	
	}
	
	/**
	 * Metodo recibe un objeto Pedido y guarda la postulacion en la base de datos.
	 *
	 * @param e the e
	 */
	public void postularPedido(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_VISUALIZAR);
		if (pedidoBean != null) {
			logger.debug("Descripcion del Pedido: --"+pedidoBean.getDescripcion()+"--");
			Profesional profesional = (Profesional) getRowParameter(e, "profesionalPrm");
			Long idUser = null;
			
			if (profesional != null) {
				idUser = profesional.getId();
//				profesional = new Profesional();
//				profesional.setId(idUser);
			} else {
				profesional = getProfesionalSesionMB();			
				idUser = profesional.getId();				
			}
			if (idUser!=null) {
				logger.debug("id user: "+idUser);
				Postulacion postulacion = new Postulacion();
				postulacion.setPedido(pedidoBean);
				postulacion.setProfesional(profesional);
				Postulacion postulacionGuardada = null;
				try {
					Postulacion postulacionEncontrada = getServicio().getPedidoService().buscarPostulacion(postulacion);
					if (postulacionEncontrada!= null && postulacionEncontrada.getId()!=null) {
						agregarMensajeErrorTransaccion("Ya existe la postulacion registrada con los mismos datos");
					} else {
						postulacionGuardada = getServicio().getPedidoService().guardarPostulacion(postulacion);
						if (postulacionGuardada != null && postulacionGuardada.getId() !=null && postulacionGuardada.getId().compareTo(0L) == 1) {
							agregarMensajeExitoTransaccion("Datos de la postulacion guardados correctamente");
							logger.debug("Guardado  : " + postulacionGuardada.getId());
						} else {
							agregarMensajeErrorTransaccion("Ya existe la postulacion registrada con los mismos datos");
						}
//					init(); 

					}
					
				} catch (Exception e1) {
					logger.error(e1.getStackTrace());
					agregarMensajeErrorTransaccion("No se pudo guardar la postulacion");
				} finally {
					UtilBean.initNullObject(postulacionGuardada);
				}
				
			}			
			
		}
	}
	
	public void consultaPostulaciones(ActionEvent e){
		Pedido bean = (Pedido)getRowParameter(e, "pedidoPrm");
		setAccionRealizada(Constantes.ACCION_VISUALIZAR);
		if (bean != null) {
			if (bean instanceof Pedido) {
				pedidoBean = bean;
				logger.debug("Pedido Id   : --"+pedidoBean.getId()+"--");
				logger.debug("Descripcion : --"+pedidoBean.getDescripcion()+"--");
				listaPostulaciones = (ArrayList<Postulacion>) getServicio().getPedidoService().buscarPostulacionesPorPedido(pedidoBean);
				logger.debug("tamaño lista : --"+listaPostulaciones.size()+"--");
			}
		}
	}
	
	
	/**
	 * Sets the pedido bean.
	 *
	 * @param pedidoBean the new pedido bean
	 */
	public void setPedidoBean(Pedido pedidoBean) {
		this.pedidoBean = pedidoBean;
	}

	/**
	 * Gets the pedido bean.
	 *
	 * @return objeto pedido
	 */
	public Pedido getPedidoBean() {
		return pedidoBean;
	}

	public void setBusquedaBean(BusquedaBean busquedaBean) {
		this.busquedaBean = busquedaBean;
	}

	public BusquedaBean getBusquedaBean() {
		return busquedaBean;
	}

	public List<Postulacion> getListaPostulaciones() {
		return listaPostulaciones;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresaBean = empresaBean;
	}

	public Empresa getEmpresaBean() {
		return empresaBean;
	}

}
