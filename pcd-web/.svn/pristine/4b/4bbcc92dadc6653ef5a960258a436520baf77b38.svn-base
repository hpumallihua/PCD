package pe.gob.trabajo.pcd.vista.faces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Area;
import pe.gob.trabajo.pcd.modelo.dominio.Departamento;
import pe.gob.trabajo.pcd.modelo.dominio.Preferencia;
import pe.gob.trabajo.pcd.modelo.dominio.PreferenciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.modelo.dominio.TipoPreferencia;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.faces.util.Items;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarPreferenciasProfesionalesMB.
 */
public class RegistrarPreferenciasProfesionalesMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RegistrarPreferenciasProfesionalesMB.class);

	/** The profesional bean. */
	private Profesional profesionalBean;
	
	/** The disponibilidad inmediata. */
	Boolean disponibilidadInmediata;
	
	/** The unidad tiempo. */
	private Integer unidadTiempo;

	/** The lista areas seleccionadas. */
	private List listaAreasSeleccionadas;
	
	/** The lista sectores seleccionados. */
	private List listaSectoresSeleccionados;
	
	/** The lista ciudades seleccionadas. */
	private List listaCiudadesSeleccionadas;

	// public RegistrarPreferenciasProfesionalesMB() {
	// init();
	// }
	//
	// public void init() {
	//
	// }

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
	 * Gets the disponibilidad inmediata.
	 *
	 * @return the disponibilidad inmediata
	 */
	public Boolean getDisponibilidadInmediata() {
		return disponibilidadInmediata;
	}

	/**
	 * Sets the disponibilidad inmediata.
	 *
	 * @param disponibilidadInmediata the new disponibilidad inmediata
	 */
	public void setDisponibilidadInmediata(Boolean disponibilidadInmediata) {
		this.disponibilidadInmediata = disponibilidadInmediata;
	}

	/**
	 * Gets the unidad tiempo.
	 *
	 * @return objeto unidad tiempo
	 */
	public Integer getUnidadTiempo() {
		return unidadTiempo;
	}

	/**
	 * Sets the unidad tiempo.
	 *
	 * @param unidadTiempo the new unidad tiempo
	 */
	public void setUnidadTiempo(Integer unidadTiempo) {
		this.unidadTiempo = unidadTiempo;
	}

	/**
	 * Gets the lista areas seleccionadas.
	 *
	 * @return the lista areas seleccionadas
	 */
	public List getListaAreasSeleccionadas() {
		return listaAreasSeleccionadas;
	}

	/**
	 * Sets the lista areas seleccionadas.
	 *
	 * @param listaAreasSeleccionadas the new lista areas seleccionadas
	 */
	public void setListaAreasSeleccionadas(List listaAreasSeleccionadas) {
		this.listaAreasSeleccionadas = listaAreasSeleccionadas;
	}

	/**
	 * Gets the lista sectores seleccionados.
	 *
	 * @return the lista sectores seleccionados
	 */
	public List getListaSectoresSeleccionados() {
		return listaSectoresSeleccionados;
	}

	/**
	 * Sets the lista sectores seleccionados.
	 *
	 * @param listaSectoresSeleccionados the new lista sectores seleccionados
	 */
	public void setListaSectoresSeleccionados(List listaSectoresSeleccionados) {
		this.listaSectoresSeleccionados = listaSectoresSeleccionados;
	}

	/**
	 * Gets the lista ciudades seleccionadas.
	 *
	 * @return the lista ciudades seleccionadas
	 */
	public List getListaCiudadesSeleccionadas() {
		return listaCiudadesSeleccionadas;
	}

	/**
	 * Sets the lista ciudades seleccionadas.
	 *
	 * @param listaCiudadesSeleccionadas the new lista ciudades seleccionadas
	 */
	public void setListaCiudadesSeleccionadas(List listaCiudadesSeleccionadas) {
		this.listaCiudadesSeleccionadas = listaCiudadesSeleccionadas;
	}

	/**
	 * Seleccionar profesional.
	 *
	 * @param e the e
	 */
	public void seleccionarProfesional(ActionEvent e) {
		this.profesionalBean = getProfesionalSesionMB();

		setAccionRealizada(Constantes.ACCION_LISTAR);
		// List<SelectItem> lista = new ArrayList<SelectItem>();
		// listaAreaSectorSeleccionada =
		// Items.getItems(getPreferencias(),"descripcion", "id.idPrfrnca");
		listaAreasSeleccionadas = new ArrayList();
		listaSectoresSeleccionados = new ArrayList();
		listaCiudadesSeleccionadas = new ArrayList();
		
		List<Preferencia> preferencias = getPreferencias();
		for (Preferencia preferencia : preferencias) {
			if (preferencia.getTipoPreferencia().getId().compareTo(Constantes.TIPO_PREFERENCIA_CIUDAD.getId()) == 0) {
				listaCiudadesSeleccionadas.add((Object) preferencia.getId().getIdPrfrnca().toString());
			}
			if (preferencia.getTipoPreferencia().getId().compareTo(Constantes.TIPO_PREFERENCIA_AREA.getId()) == 0) {
				listaAreasSeleccionadas.add((Object) preferencia.getId().getIdPrfrnca().toString());
			}
			if (preferencia.getTipoPreferencia().getId().compareTo(Constantes.TIPO_PREFERENCIA_SECTOR.getId()) == 0) {
				listaSectoresSeleccionados.add((Object) preferencia.getId().getIdPrfrnca().toString());
			}
		}
		disponibilidadInmediata = false;
		if (profesionalBean.getDisponibilidadContratacion() != null
				&& profesionalBean.getDisponibilidadContratacion().compareTo(0) == 0) {
			disponibilidadInmediata = true;
		}
	}

	/**
	 * Metodo que guarda un nuevo registro en la base de datos.
	 *
	 * @param e the e
	 */
	public void guardar(ActionEvent e) {

		validar();

		try {

			List<Preferencia> listaAreas = new ArrayList<Preferencia>();
			List<Preferencia> listaSectores = new ArrayList<Preferencia>();
			List<Preferencia> listaCiudades = new ArrayList<Preferencia>();

			for (Object area : listaAreasSeleccionadas) {
				Preferencia preferenciaArea = new Preferencia();
				preferenciaArea.setId(new PreferenciaId(
						Constantes.TIPO_PREFERENCIA_AREA.getId(), new Long(area
								.toString()), profesionalBean.getId()));
				preferenciaArea.setProfesional(getProfesionalBean());
				preferenciaArea
						.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_AREA);
				listaAreas.add(preferenciaArea);
			}
			for (Object sector : listaSectoresSeleccionados) {
				Preferencia preferenciaSector = new Preferencia();
				preferenciaSector.setId(new PreferenciaId(
						Constantes.TIPO_PREFERENCIA_SECTOR.getId(), new Long(
								sector.toString()), profesionalBean.getId()));
				preferenciaSector.setProfesional(getProfesionalBean());
				preferenciaSector
						.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_SECTOR);
				listaSectores.add(preferenciaSector);
			}
			for (Object ciudad : listaCiudadesSeleccionadas) {
				Preferencia preferenciaCiudad = new Preferencia();
				preferenciaCiudad.setId(new PreferenciaId(
						Constantes.TIPO_PREFERENCIA_CIUDAD.getId(), new Long(
								ciudad.toString()), profesionalBean.getId()));
				preferenciaCiudad.setProfesional(getProfesionalBean());
				preferenciaCiudad
						.setTipoPreferencia(Constantes.TIPO_PREFERENCIA_CIUDAD);
				listaCiudades.add(preferenciaCiudad);
			}

			int retorno = getServicio().getProfesionalService()
					.guardarPreferencias(listaAreas, listaSectores,
							listaCiudades, profesionalBean);

//			if (retorno != -1) {
				agregarMensajeExitoTransaccion("Dato guardado con éxito");
//			} else {
//				agregarMensajeErrorTransaccion("Error");
//			}
		} catch (Exception e2) {
			logger.error(e2.getStackTrace());
			agregarMensajeErrorTransaccion("Error");
		} finally {
			setAccionRealizada(Constantes.ACCION_LISTAR);
			unidadTiempo = 1;
		}
	}

	/**
	 * Metodo encargado de validar todos los campos obligatorios.
	 */
	private void validar() {
		if (profesionalBean.getTipoTrabajo() != null
				&& profesionalBean.getTipoTrabajo().equals(0)) {
			profesionalBean.setTipoTrabajo(null);
		}
		if (unidadTiempo != null) {
			profesionalBean.setDisponibilidadContratacion(profesionalBean
					.getDisponibilidadContratacion() * unidadTiempo);
		}
		if (disponibilidadInmediata) {
			profesionalBean.setDisponibilidadContratacion(0);
		} else if (profesionalBean.getDisponibilidadContratacion() != null
				&& profesionalBean.getDisponibilidadContratacion().compareTo(0) == 0) {
			profesionalBean.setDisponibilidadContratacion(null);
		}

		if (profesionalBean.getSueldoMinimo() > profesionalBean
				.getSueldoMaximo()) {
			throw new ValidatorException(
					agregarMensajeErrorTransaccion("Error: El sueldo máximo no puede ser menor al Sueldo Mínimo"));
		}
	}

	/**
	 * Cancelar.
	 *
	 * @param e the e
	 */
	public void cancelar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
	}

	/**
	 * Metodo que inicializa los objetos para un nuevo registro.
	 *
	 * @param e the e
	 */
	public void nuevo(ActionEvent e) {
		init();
		// long id = 3;
		PreferenciaId preferenciaId = new PreferenciaId();
		TipoPreferencia tipoPreferencia = new TipoPreferencia();

		// Profesional profe3 = new Profesional();
		// profe3.setId(id);

		Preferencia bean = new Preferencia();
		bean.setProfesional(profesionalBean);
		bean.setId(preferenciaId);
		bean.setTipoPreferencia(tipoPreferencia);
		bean.setArea(new Area());
		bean.setSector(new Sector());
		// UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_NUEVO);
	}

	/**
	 * Metodo recibe un objeto Preferencia y actualiza los cambios en la base de datos.
	 *
	 * @param e the e
	 */
	public void editar(ActionEvent e) {

		Preferencia bean = (Preferencia) getRowParameter(e, "preferenciaPrm");
		// UtilBean.initNullObject(bean);
		setBean(bean);
		setAccionRealizada(Constantes.ACCION_EDITAR);
	}

	/**
	 * Metodo que elimina un registro de la base de datos. 
	 *
	 * @param e the e
	 */
	public void eliminar(ActionEvent e) {
		setAccionRealizada(Constantes.ACCION_LISTAR);
		logger.debug("eliminar... ");
		Preferencia bean = (Preferencia) getRowParameter(e, "preferenciaPrm");
		getServicio().getMaestroService().removeObject(bean);
		agregarMensajeExitoTransaccion("La preferencia ha sido eliminada");

	}

	// public List<?> getPreferencia() {
	// Profesional profesional = new Profesional();
	// profesional.setId(3L);
	// return (List<Preferencia>) getServicio().getProfesionalService()
	// .obtenerPreferencias(profesional);
	// }

	/**
	 * Gets the preferencias.
	 *
	 * @return the preferencias
	 */
	public List<Preferencia> getPreferencias() {
		return (List<Preferencia>) getServicio().getProfesionalService()
				.obtenerPreferencias(getProfesionalBean());
	}

	/**
	 * Gets the preferencias area.
	 *
	 * @return the preferencias area
	 */
	public List<Preferencia> getPreferenciasArea() {
		return (List<Preferencia>) getServicio().getProfesionalService()
				.obtenerPreferenciasArea(getProfesionalBean());
	}

	/**
	 * Gets the preferencias sector.
	 *
	 * @return the preferencias sector
	 */
	public List<Preferencia> getPreferenciasSector() {
		return (List<Preferencia>) getServicio().getProfesionalService()
				.obtenerPreferenciasSector(getProfesionalBean());
	}

	/**
	 * Gets the preferencias ciudad.
	 *
	 * @return the preferencias ciudad
	 */
	public List<Preferencia> getPreferenciasCiudad() {
		return (List<Preferencia>) getServicio().getProfesionalService()
				.obtenerPreferenciasCiudad(getProfesionalBean());
	}

	/**
	 * Gets the areas.
	 *
	 * @return the areas
	 */
	public List<?> getAreas() {
		List<Area> lista = (List<Area>) getServicio().getMaestroService()
				.getAllObject(Area.class);
		try {

		} catch (Exception e) {
			e.setStackTrace(null);
			agregarMensajeError("hhh");
		}
		return lista;
	}

	/**
	 * Gets the items area.
	 *
	 * @return the items area
	 */
	public List<?> getItemsArea() {
		List<Area> lista = (List<Area>) getServicio().getMaestroService()
				.getAllObject(Area.class,"descripcion");
		return Items.getItems(lista, "descripcion", "id");
	}

	// Método para obtener el sector
	/**
	 * Gets the items sector.
	 *
	 * @return the items sector
	 */
	public List<?> getItemsSector() {
		List<Sector> lista = (List<Sector>) getServicio().getMaestroService().getMaestroSectores();
//				.getAllObject(Sector.class);
//		.getAllObject(Sector.class,"descripcion");

		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the items tipo preferencia.
	 *
	 * @return the items tipo preferencia
	 */
	public List<?> getItemsTipoPreferencia() {
		List<TipoPreferencia> lista = (List<TipoPreferencia>) getServicio()
				.getMaestroService().getAllObject(TipoPreferencia.class);

		return Items.getItems(lista, "descripcion", "id");
	}

	/**
	 * Gets the ciudades.
	 *
	 * @return the ciudades
	 */
	public List<?> getCiudades() {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();
		List<Departamento> listaDepartamentos = getServicio().getMaestroService().getMaestroDepartamentos();
		for (Departamento departamento : listaDepartamentos) {
			String codigoTxt = departamento.getId();
			Integer codigoInt = Integer.valueOf(codigoTxt);
			listaItems.add(new SelectItem(codigoInt.toString(),departamento.getDescripcion()));
		}
//				.getLugares(null);
//		listaItems = Items.getItems(listaDepartamentos, "nombre", "id",
//				Items.FIRST_ITEM_SELECT);
		return listaItems;
	}

	/**
	 * Cambio lista.
	 *
	 * @param e the e
	 */
	public void cambioLista(ValueChangeEvent e) {
//		Object[] oldValue = null;
//		Object[] newValue = null;
//		if (e.getOldValue() != null) {
//			oldValue = ((Collection<?>) e.getOldValue()).toArray();
//		}
//		if (e.getNewValue() != null) {
//			newValue = ((Collection<?>) e.getNewValue()).toArray();
//		}
//		for (Object o : listaAreasSeleccionadas) {
//			logger.info(o);
//		}
//		logger.info(e);
//		logger.info(listaAreasSeleccionadas);
	}
}
