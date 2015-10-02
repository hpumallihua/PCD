package pe.gob.trabajo.pcd.vista.faces.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Hits;

import pe.gob.trabajo.pcd.modelo.dominio.Distrito;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.NivelIdioma;
import pe.gob.trabajo.pcd.modelo.dominio.Ocupacion;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaCargo;
import pe.gob.trabajo.pcd.modelo.dominio.Profesion;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.dominio.ProvinciaId;
import pe.gob.trabajo.pcd.modelo.dominio.Sector;
import pe.gob.trabajo.pcd.servicio.lucene.busqueda.BuscadorService;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.vista.bean.BusquedaBean;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;

// TODO: Auto-generated Javadoc
/**
 * The Class BuscarProfesionalMB.
 */
public class BuscarProfesionalMB extends GenericManagedBean {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(BuscarProfesionalMB.class);

	/** The bean. */
	BusquedaBean bean;

	/** The lista profesionales. */
	List<Profesional> listaProfesionales = new ArrayList<Profesional>();

	/**
	 * Instantiates a new buscar profesional mb.
	 */
	public BuscarProfesionalMB() {
		init();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#init()
	 */
	public void init() {
		bean = new BusquedaBean();
	}

	/* (non-Javadoc)
	 * @see pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean#getBean()
	 */
	public BusquedaBean getBean() {
		return bean;
	}

	/**
	 * Sets the bean.
	 *
	 * @param BusquedaBean bean 
	 */
	public void setBean(BusquedaBean bean) {
		this.bean = bean;
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
	 * Buscar.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void buscar(ActionEvent e) {
		
		String textoBusquedaCV = "";
//		String[] especialidades = null;
		String[] cargos = null;
		String[] lugares = null;
		String[] empresas = null;
		String[] sectores = null;

		String[] profesiones = null;
		Long[] nivelesFormacion = null;
		//Long nivelFormacion = null;
		String[] camposEstudio = null;
		String[] idiomas = null;
//		Long[] nivelesIdioma = null;
	//	Long nivelIdioma = null;
		Integer[] edades = null;
		
		String[] nivelesEducativos=null;
		String[] nivelesIdiomas=null;
		
		String[] ocupacionesExperiencia = null;
		String[] ocupacionesEmpleos = null;

		if (getBean().getEspecialidad() != null
				&& getBean().getEspecialidad().getDescripcion() != null				
				&& !getBean().getEspecialidad().getDescripcion().equals("")) {
			textoBusquedaCV += getBean().getEspecialidad().getDescripcion();
			List<Ocupacion> lista = getServicio().getMaestroService().getMaestroOcupaciones();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getEspecialidad().getDescripcion(), "id", "descripcion");
			ocupacionesExperiencia = mapaBusqueda.get("ids");
//			ocupacionesExperiencia = mapaBusqueda.get("valores");
		}
		
		
		//Nivel de formación
		if(getBean().getNivelEducativo()!=null && !getBean().getNivelEducativo().equals("")){
//			nivelFormacionn=getBean().getNivelEducativo().split(",");
			
			List<NivelEducativo> lista = getServicio().getMaestroService().getMaestroNivelesEducativos();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getNivelEducativo(), "id", "descripcion");
			nivelesEducativos = mapaBusqueda.get("ids");
		}
		//Nivel de Idiomas
		if(getBean().getNivelIdioma()!=null && !getBean().getNivelIdioma().equals("")){
//			nivelesIdiomas = getBean().getNivelIdioma().split(Constantes.SEPARADOR_CRITERIOS_CV);
			
			List<NivelIdioma> lista = (List<NivelIdioma>) getServicio().getMaestroService().getAllObject(NivelIdioma.class);
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getNivelIdioma(), "id", "valor");
			nivelesIdiomas = mapaBusqueda.get("ids");
		}
		
		if (getBean().getPuesto() != null
				&& getBean().getPuesto().getDescripcion() != null
				&& !getBean().getPuesto().getDescripcion().equals("")) {
			textoBusquedaCV += "," + getBean().getPuesto().getDescripcion();
						
			List<PersonaCargo> lista = getServicio().getMaestroService().getMaestroPersonaCargo();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getPuesto().getDescripcion(), "id", "descripcion");
			cargos = mapaBusqueda.get("ids");
		}
		if (getBean().getEmpresa() != null
				&& getBean().getEmpresa().getNombreComercial() != null
				&& !getBean().getEmpresa().getNombreComercial().equals("")) {
			textoBusquedaCV += "," + getBean().getEmpresa().getNombreComercial();
			empresas = getBean().getEmpresa().getNombreComercial().split(Constantes.SEPARADOR_CRITERIOS_CV);
		}
		if (getBean().getSector() != null
				&& getBean().getSector().getDescripcion() != null
				&& !getBean().getSector().getDescripcion().equals("")) {
			textoBusquedaCV += "," + getBean().getSector().getDescripcion();
//			sectores = getBean().getSector().getDescripcion().split(Constantes.SEPARADOR_CRITERIOS_CV);
			
			List<Sector> lista = getServicio().getMaestroService().getMaestroSectores();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getSector().getDescripcion(), "id", "descripcion");
			sectores = mapaBusqueda.get("ids");
		}
		
		if(getBean().getRol()!= null
				&& getBean().getRol().getDescripcion()!=null
				&& !getBean().getRol().getDescripcion().equals("")){
			textoBusquedaCV += "," + getBean().getRol().getDescripcion();
//			roles = getBean().getRol().getDescripcion().split(",");
			
			List<Ocupacion> lista = getServicio().getMaestroService().getMaestroOcupaciones();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getRol().getDescripcion(), "id", "descripcion");
			ocupacionesEmpleos = mapaBusqueda.get("ids");
		}
		
		if (getBean().getProfesion() != null
				&& getBean().getProfesion().getDescripcion() != null
				&& !getBean().getProfesion().getDescripcion().equals("")) {
			textoBusquedaCV += "," + getBean().getProfesion().getDescripcion();
//			profesiones = getBean().getTipoFormacion().getDescripcion().split(",");
			
			List<Profesion> lista = getServicio().getMaestroService().getMaestroProfesiones();
			HashMap<String, String[]> mapaBusqueda = null;
			mapaBusqueda = UtilBean.obtenerParametrosBusqueda(lista, getBean().getProfesion().getDescripcion(), "id", "descripcion");
			profesiones = mapaBusqueda.get("ids");
		}
//		if (getBean().getFormacion() != null
//				&& getBean().getFormacion().getNivel() != null
//				&& !getBean().getFormacion().getNivel().equals(0)) {
//			nivelFormacion = getBean().getFormacion().getNivel();
//		}
		// Nivel Formacion
		// if (getBean().getFormacion() != null
		// && getBean().getFormacion().getNivel() != null
		// && !getBean().getFormacion().getNivel().equals(0)) {
		// nivelesFormacion = getBean().getFormacion().getNivelFormativo()
		// .getId().split(",");
		//
		// }

		if (getBean().getFormacion() != null
				&& getBean().getFormacion().getNivelFormativo() != null
				&& getBean().getFormacion().getNivelFormativo().getValor() !=null 
				&& !getBean().getFormacion().getNivelFormativo().getValor().equals("")) {
			String[] niveles = getBean().getNivelEducativo().split(",");
			nivelesFormacion = new Long[1];
			if (niveles.length > 0 && niveles[0] != null
					&& !niveles[0].equals("")) {
				nivelesFormacion[1] = Long.valueOf(niveles[1]);
			}
		}
		// Nivel Idioma
		// if (getBean().getProfesionalIdioma() != null
		// && getBean().getProfesionalIdioma().getOverall() != null
		// && !getBean().getProfesionalIdioma().getOverall().equals(0)) {
		// nivelesIdioma = getBean().getProfesionalIdioma().getNivelIdioma()
		// .getValor().split(",");
		// }
		if (getBean().getTipoFormacion() != null
				&& getBean().getFormacion().getCampoEstudio() != null
				&& !getBean().getFormacion().getCampoEstudio().equals("")) {
			camposEstudio = getBean().getFormacion().getCampoEstudio()
					.split(",");
		}
		if (getBean().getProfesionalIdioma() != null
				&& getBean().getProfesionalIdioma().getIdioma() != null
				&& getBean().getProfesionalIdioma().getIdioma()
						.getDescripcion() != null
				&& !getBean().getProfesionalIdioma().getIdioma()
						.getDescripcion().equals("")) {
			if (!getBean().getProfesionalIdioma().getIdioma().getDescripcion()
					.equals("")) {
				idiomas = getBean().getProfesionalIdioma().getIdioma()
						.getDescripcion().split(Constantes.SEPARADOR_CRITERIOS_CV);
			}
		}
//		if (getBean().getProfesionalIdioma() != null
//				&& getBean().getProfesionalIdioma().getOverall() != null
//				&& !getBean().getProfesionalIdioma().getOverall().equals(0)) {
//			nivelIdioma = getBean().getProfesionalIdioma().getOverall();
//		}

		if (getBean().getProfesional() != null
				&& getBean().getProfesional().getDisponibilidadContratacion() != null
				&& getBean().getProfesional().getDisponibilidadContratacion()
						.equals(0)) {
			getBean().getProfesional().setDisponibilidadContratacion(null);
		}
		if (getBean() != null && getBean().getDisponibilidadInmediata()) {
			getBean().getProfesional().setDisponibilidadContratacion(0);
		}
		if (getBean() != null && getBean().getEdades() != null
				&& !getBean().getEdades().equals("")) {
			String[] edadesTxt = getBean().getEdades().split("-");
			edades = new Integer[2];
			if (edadesTxt.length > 0 && edadesTxt[0] != null
					&& !edadesTxt[0].equals("")) {
				edades[0] = Integer.valueOf(edadesTxt[0].replaceAll(" ", ""));
			}
			if (edadesTxt.length > 1 && edadesTxt[1] != null
					&& !edadesTxt[1].equals("")) {
				edades[1] = Integer.valueOf(edadesTxt[1].replaceAll(" ", ""));
			}
			if ((edades[1] != null) && (edades[0] != null)
					&& (edades[0].compareTo(edades[1]) == 1)) {
				Integer intercambio = edades[0];
				edades[0] = edades[1];
				edades[1] = intercambio;
			}
		}
		
		if ((getBean().getIdsLugaresResidenciaDep() != null
				&& !"".equals(getBean().getIdsLugaresResidenciaDep())) && 
				(getBean().getIdsLugaresResidenciaProv() != null
				&& !"".equals(getBean().getIdsLugaresResidenciaProv())) &&
				(getBean().getIdsLugaresResidenciaDis() != null
				&& !"".equals(getBean().getIdsLugaresResidenciaDis()))) {
//			textoBusquedaCV += "," + getBean().getSector().getDescripcion();
			String[] lugaresResidenciaDep = getBean().getIdsLugaresResidenciaDep().split(",");
			String[] lugaresResidenciaProv = getBean().getIdsLugaresResidenciaProv().split(",");
			String[] lugaresResidenciaDis = getBean().getIdsLugaresResidenciaDis().split(",");
			if (lugaresResidenciaDep != null && lugaresResidenciaProv != null && lugaresResidenciaDis != null) {
				lugares = new String[lugaresResidenciaDis.length];
				for (int i = 0; i < lugaresResidenciaDis.length; i++) {
					lugares[i] = lugaresResidenciaDep[i] + lugaresResidenciaProv[i] + lugaresResidenciaDis[i];
				}
			}
		}

		List<String> dnis = new ArrayList<String>();
		dnis.add("0");
		
		if (getBean().getIncluirCV()) {
			
			String consulta = textoBusquedaCV.replaceAll(Constantes.SEPARADOR_CRITERIOS_CV + Constantes.SEPARADOR_CRITERIOS_CV, Constantes.SEPARADOR_CRITERIOS_CV);
			consulta = consulta.replaceAll(",", Constantes.SEPARADOR_CRITERIOS_CV);
			try {
				Hits hits = BuscadorService.buscarEnCV(UtilBean.getParametrosMap().get("CARPETA_CV").toString(), consulta);
//				Hits hits = BuscadorService.buscarEnCVBD(UtilBean.getJdbcIndexDir(), consulta);
				
				for (int i = 0; i < hits.length(); i++) {
					Document doc = hits.doc(i);
					dnis.add(doc.get("dni"));
					logger.info(" \tscore:" + hits.score(i) + doc.get("filename") + " \tdni:" + doc.get("dni"));
				}
				
//				listaProfesionales = (List<Profesional>) getServicio().getProfesionalService().buscarProfesional(dnis);
			} catch (IOException e1) {
				logger.error(e1.getStackTrace());
			}
		}
		
		listaProfesionales = (ArrayList<Profesional>) getServicio()
		.getProfesionalService()
		.buscarProfesionales(ocupacionesExperiencia, cargos,ocupacionesEmpleos, empresas,
				sectores, profesiones, nivelesEducativos,
				camposEstudio, idiomas, nivelesIdiomas,
				getBean().getProfesional(), edades, lugares,dnis);
//		.buscarProfesionales(especialidades, puestos,roles, empresas,
//				sectores, tiposFormacion, nivelFormacionn,
//				camposEstudio, idiomas, nivelIdiomaa,
//				getBean().getProfesional(), edades, null,dnis);
		
		for (Profesional profesional : listaProfesionales) {
			// logger.info(profesional.getPersona().getApellidoPaterno());
			UtilBean.initNullObject(profesional.getPersona());
		}
	}

	/**
	 * Lista de profesionales.
	 *
	 * @return List<Profesional> listaProfesionales contiene el resultado de la consulta
	 */
	public List<Profesional> getProfesionales() {
		return listaProfesionales;
	}

	/**
	 * Eliminar profesional.
	 *
	 * @param ActionEvent e ocurre cuando el usuario realiza una acción
	 */
	public void eliminarProfesional(ActionEvent e) {
		Profesional bean = (Profesional) getRowParameter(e, "profesionalPrm");
		try {
			getServicio().getMaestroService().removeObject(bean);
			setAccionRealizada(Constantes.ACCION_LISTAR);
			agregarMensajeExitoTransaccion("La operación se realizó correctamente");
			buscar(e);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			agregarMensajeErrorTransaccion("Ocurrió un error. No se pudo eliminar");
		}
	}
}
