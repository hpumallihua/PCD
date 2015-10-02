package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Puesto;
import pe.gob.trabajo.pcd.modelo.dominio.Referencia;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoReferencia;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarReferenciaMB.
 */
public class RegistrarReferenciaMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarReferenciaMB.class);
	
	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The bool. */
	private Boolean bool=false;

	/**
	 * Gets the bool.
	 *
	 * @return the bool
	 */
	public Boolean getBool() {
		return bool;
	}

	/**
	 * Sets the bool.
	 *
	 * @param bool the new bool
	 */
	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	/**
	 * Gets the profesional bean.
	 *
	 * @return the profesional bean
	 */
	public Profesional getProfesionalBean() {
		return profesionalBean;
	}

	/**
	 * Sets the profesional bean.
	 *
	 * @param profesionalBean the new profesional bean
	 */
	public void setProfesionalBean(Profesional profesionalBean) {
		this.profesionalBean = profesionalBean;
	}

	/**
	 * Seleccionar profesional.
	 *
	 * @param e the e
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	// private Persona persona;
	//
	// public Persona getPersona() {
	// return persona;
	// }
	//
	// public void setPersona(Persona persona) {
	// this.persona = persona;
	// }
	//
	// public RegistrarReferenciaMB() {
	//
	// init();
	// }
	//
	// public void init() {
	// //persona = new Persona();
	// }

	//
	// public void guardar(ActionEvent e) {
	// Referencia bean = (Referencia) getBean();
	// Long tipo = bean.getTipoReferencia().getId();
	//
	// TipoReferencia id = new TipoReferencia();
	// id.setId(tipo);
	//
	// }

	/**
	 * Validar Referencia.
	 *
	 * @param ActionEvent e oucurre cuando el usuario realiza una acción.
	 */
	public void validarDato(ActionEvent e) {
		Referencia bean = (Referencia) getBean();
		bean.cambiarValidacion(Constantes.ESTADO_VALIDACION_VALIDO, Constantes.ESTADO_VALIDACION_INVALIDO, getUsuarioSesion().getUsuario().getId());
		guardar(e);
	}
	
	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param ActionEvent e ocurre cuando el usuario hace clic en el boton guardar
	 */
	public void guardar(ActionEvent e) {
		Referencia bean = (Referencia) getBean();
		try {
			validar();
			getServicio().getProfesionalService().guardarReferencia(bean);
			setBean(bean);
			if (bean != null && bean.getId() != null) {
				agregarMensajeExitoTransaccion("Dato guardado con éxito");
			} else {
				agregarMensajeErrorTransaccion("Error");
			}
			setAccionRealizada(Constantes.ACCION_LISTAR);
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error");
		} finally {
			UtilBean.initNullObject(bean);
		}	
		
	}
	
	/**
	 * Metodo que recibe un objeto de tipo Referencia y valida los campos obligatorios.
	 */
	public void validar(){
		Referencia bean = (Referencia) getBean();
		
		boolean nombreAsignado = false;
		boolean idAsignado = false;
		
		if(bean != null){
			
			nombreAsignado = bean.getEmpresa() != null && bean.getEmpresa().getNombreComercial() != null && !bean.getEmpresa().getNombreComercial().equals("");
			idAsignado = bean.getEmpresa()!=null && bean.getEmpresa().getId() != null && !bean.getEmpresa().getId().equals(0L);
			//Obligatorio, nombre no vacio
			if (!((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
				throw new ValidatorException(
						agregarMensajeErrorTransaccion("Debe ingresar la empresa"));
			}
			
			nombreAsignado = bean.getTipoReferencia() != null && bean.getTipoReferencia().getDescripcion() != null && !bean.getTipoReferencia().getDescripcion().equals("");
			idAsignado = bean.getTipoReferencia() != null && bean.getTipoReferencia().getId()!= null && !bean.getTipoReferencia().getId().equals(0L);
			//Obligatorio, nombre no vacio
			if (!((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
				throw new ValidatorException(
						agregarMensajeErrorTransaccion("Debe ingresar el tipo de referencia"));
			}
			
			nombreAsignado = bean.getPuesto() != null && bean.getPuesto().getDescripcion() != null && !bean.getPuesto().getDescripcion().equals("");
			idAsignado = bean.getPuesto() != null && bean.getPuesto().getId()!= null && !bean.getPuesto().getId().equals(0L);
			//Obligatorio, nombre no vacio
			if (!((!nombreAsignado || idAsignado) && (!idAsignado || nombreAsignado))) {
				throw new ValidatorException(
						agregarMensajeErrorTransaccion("Debe ingresar el puesto"));
			}
			
			if (bean.getPersona()!=null && 
					(bean.getPersona().getId() == null || bean.getPersona().getId().equals(0L))) {
				bean.setPersona(null);
			}
					 
//			if (bean.getPuesto()!=null && 
//					(bean.getPuesto().getDescripcion() != null && bean.getPuesto().getDescripcion().trim().equals("")) && 
//					(bean.getPuesto().getId() == null || bean.getPuesto().getId().equals(0L))) {
//				bean.setPuesto(null);
//			}
//			if (bean.getEmpresa()!=null && 
//					(bean.getEmpresa().getNombre()!= null && bean.getEmpresa().getNombre().trim().equals("")) && 
//					(bean.getEmpresa().getId() == null || bean.getEmpresa().getId().equals(0L))) {
//				bean.setEmpresa(null);
//			}
//			if (bean.getTipoReferencia() !=null && 
//					(bean.getTipoReferencia().getDescripcion()!= null && bean.getTipoReferencia().getDescripcion().trim().equals("")) && 
//					(bean.getTipoReferencia().getId() == null || bean.getTipoReferencia().getId().equals(0L))) {
//				bean.setTipoReferencia(null);
//			}
			
			boolean telefonoVacio = true;
			boolean correoVacio = true;
			
			if (bean.getTelefonoPrincipal() != null && !bean.getTelefonoPrincipal().equals("")) {
				telefonoVacio = false;
			}
			
			if (bean.getEmail() != null && !bean.getEmail().equals("")) {
				correoVacio = false;
			}
			
			if (correoVacio && telefonoVacio) {
				throw new ValidatorException(
						agregarMensajeErrorTransaccion("Error: Ingrese su Email y/o telefono"));
			}
		}
	}
	
	/**
	 * Cancelar.
	 *
	 * @param ActionEvent e oucurre cuando el usuario realiza una acción.
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param ActionEvent e oucurre cuando el usuario realiza una acción
	 */
	public void nuevo(ActionEvent e) {
		init();
		// long id = 3;

		// Puesto puesto = new Puesto();
		// Empresa empresa = new Empresa();
		// Persona persona = new Persona();
		// TipoReferencia tipoReferencia = new TipoReferencia();

		// Profesional profe3 = new Profesional();
		// Persona persona = new Persona();
		// profe3.setId(id);
		// persona.setId(persona.getId());
		Referencia bean = new Referencia();
		// bean.setId(id);
//		bean.setPersona(new Persona());
//		bean.setPuesto(new Puesto());
//		bean.setEmpresa(new Empresa());
//		bean.setTipoReferencia(new TipoReferencia());
		bean.setProfesional(profesionalBean);
		UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo encargado de actualizar los cambios en la base de datos.
	 *
	 * @param ActionEvent e oucurre cuando el usuario realiza una acción
	 */
	public void editar(ActionEvent e) {

		Referencia bean = (Referencia) getRowParameter(e, "referenciaPrm");
		UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
	}

	/**
	 * Metodo que elimina un registro de la base de datos.
	 *
	 * @param ActionEvent e oucurre cuando el usuario realiza una acción
	 */
	public void eliminar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("eliminar... ");
		Referencia bean = (Referencia) getRowParameter(e, "referenciaPrm");
		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La referencia ha sido eliminada");
	}

	// public List<?> getReferencia() {
	// Profesional profesional = new Profesional();
	// profesional.setId(3L);
	//
	// return (List<Referencia>) getServicio().getProfesionalService()
	// .obtenerReferencias(getProfesionalBean());
	// }

	/**
	 * Metodo que devuelve una lista de Referencias.
	 *
	 * @return List<Referencia> referencias contiene la lista de Referencias
	 */
	public List<Referencia> getReferencias() {
		return (List<Referencia>) getServicio().getProfesionalService()
				.obtenerReferencias(getProfesionalBean());
	}

	// Método para obtener la lista de personas registradas
	/**
	 * Gets the items persona.
	 *
	 * @return List<?> persona
	 */
	public List<?> getItemsPersona() {
		List<Persona> lista = (List<Persona>) getServicio().getMaestroService()
				.getAllObject(Persona.class);

		return Items.getItems(lista, "apellidoPaterno", "id");
	}

	// Método para obtener la lista de empresas registradas
	/**
	 * Gets the items empresa.
	 *
	 * @return List<?> empresas
	 */
	public List<?> getItemsEmpresa() {
		List<Empresa> lista = (List<Empresa>) getServicio().getMaestroService()
				.getAllObject(Empresa.class);

		return Items.getItems(lista, "nombre", "id");
	}

	// Método para obtener el cargo que ocupa la persona
	/**
	 * Gets the items cargo.
	 *
	 * @return List<?> cargos
	 */
	public List<?> getItemsCargo() {
		List<TipoReferencia> lista = (List<TipoReferencia>) getServicio()
				.getMaestroService().getAllObject(TipoReferencia.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items puesto.
	 *
	 * @return List<?> puesto
	 */
	public List<?> getItemsPuesto() {

		List<Puesto> lista = (List<Puesto>) getServicio().getMaestroService()
				.getAllObject(Puesto.class);
		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items sector.
	 *
	 * @return List<?> sector 
	 */
	public List<?> getItemsSector() {
		List<Sector> lista = (List<Sector>) getServicio().getMaestroService()
				.getAllObject(Sector.class);

		return Items.getItems(lista, "descripcion", "id");
	}
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#autocompletarEmpresa(java.lang.Object)
	 */
	public List<Empresa> autocompletarEmpresa(Object suggest) {
        String pref = (String)suggest;
        ArrayList<Empresa> result = new ArrayList<Empresa>();
        
        List<Empresa> consulta = (List<Empresa>) getServicio().getMaestroService().buscarEmpresas(pref);
        
        for (Empresa empresa : consulta) {
        	Empresa item = new Empresa();
        	item.setId(empresa.getId());
        	item.setNombreComercial(empresa.getNombreComercial());
        	result.add(item);
		}
        return result;
    }
	
	/**
	 * Autocompletar persona.
	 *
	 * @param Object suggest para buscar una perona segun su preferencia
	 * @return List<Persona> list contiene el resultado de la busqueda
	 */
	public List<Persona> autocompletarPersona(Object suggest) {
        String pref = (String)suggest;
        ArrayList<Persona> result = new ArrayList<Persona>();
        Persona personaBuscada = new Persona();
        personaBuscada.setNombres(pref);
        List<Persona> consulta = (List<Persona>) getServicio().getPersonaService().buscarPorNombres(pref);
        
        for (Persona persona : consulta) {
        	Persona item = new Persona();
        	item.setId(persona.getId());
        	item.setNombres(persona.getNombres());
        	item.setApellidoPaterno(persona.getApellidoPaterno());
        	item.setApellidoMaterno(persona.getApellidoMaterno());
        	result.add(item);
		}
        return result;
    }
	
	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#autocompletarCargo(java.lang.Object)
	 */
	public List<PersonaCargo> autocompletarCargo(Object suggest) {
		String pref = (String) suggest;
		ArrayList<PersonaCargo> result = new ArrayList<PersonaCargo>();
		Puesto puesto = new Puesto();
		puesto.setDescripcion(pref);
		List<PersonaCargo> consulta = (List<PersonaCargo>) getServicio()
				.getMaestroService().buscarCargos(pref);

		for (PersonaCargo cargoBuscado : consulta) {
			PersonaCargo item = new PersonaCargo();
			item.setId(cargoBuscado.getId());
			item.setDescripcion(cargoBuscado.getDescripcion());
			item.setNombre(cargoBuscado.getNombre());
			result.add(item);
		}
		return result;
	}
	
	/**
	 * Autocompletar tipo referencia.
	 *
	 * @param suggest suggest para buscar una perona segun su tipo referencia
	 * @return List<TipoReferencia> list contiene el resultado de la busqueda
	 */
	public List<TipoReferencia> autocompletarTipoReferencia(Object suggest) {
        String pref = (String)suggest;
        ArrayList<TipoReferencia> result = new ArrayList<TipoReferencia>();
        TipoReferencia tipoReferencia = new TipoReferencia();
        tipoReferencia.setDescripcion(pref);
        List<TipoReferencia> consulta = (List<TipoReferencia>) getServicio().getMaestroService().buscarTipoReferencia(tipoReferencia);
        
        for (TipoReferencia tipoReferenciaBuscado : consulta) {
        	TipoReferencia item = new TipoReferencia();
        	item.setId(tipoReferenciaBuscado.getId());
        	item.setDescripcion(tipoReferenciaBuscado.getDescripcion());
        	result.add(item);
		}
        return result;
    }
	
	
	
}
