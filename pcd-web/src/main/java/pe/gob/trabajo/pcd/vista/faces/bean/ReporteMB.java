package pe.gob.trabajo.pcd.vista.faces.bean;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.EstadoCivil;
import pe.gob.trabajo.pcd.modelo.dominio.NivelEducativo;
import pe.gob.trabajo.pcd.modelo.dominio.Oficina;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.PersonaInteresesOcupacionales;
import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.modelo.util.ListaUtil;
import pe.gob.trabajo.pcd.servicio.util.Constantes;
import pe.gob.trabajo.pcd.servicio.util.UtilDate;
import pe.gob.trabajo.pcd.vista.bean.ReporteE1;
import pe.gob.trabajo.pcd.vista.bean.ReporteE2;
import pe.gob.trabajo.pcd.vista.bean.ReporteE3;
import pe.gob.trabajo.pcd.vista.bean.ReporteE4;
import pe.gob.trabajo.pcd.vista.bean.ReporteEmpresa;
import pe.gob.trabajo.pcd.vista.bean.ReporteOferta;
import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;

// TODO: Auto-generated Javadoc
/**
 * The Class SesionMB.
 */
public class ReporteMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ReporteMB.class);

	private String idReporte = "0";
	private String idConsultor = "0";
	private String idOficina = "0";
	private List<SelectItem> itemsReporte = new ArrayList<SelectItem>();
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();

	/**
	 * Instantiates a new sesion mb.
	 */
	public ReporteMB() {
		init();
	}

	@Override
	public void init() {
		setBean(new UsuarioSesion());
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(String idReporte) {
		this.idReporte = idReporte;
	}

	/**
	 * @return the idConsultor
	 */
	public String getIdConsultor() {
		return idConsultor;
	}

	/**
	 * @param idConsultor the idConsultor to set
	 */
	public void setIdConsultor(String idConsultor) {
		this.idConsultor = idConsultor;
	}

	/**
	 * @return the idOficina
	 */
	public String getIdOficina() {
		return idOficina;
	}

	/**
	 * @param idOficina the idOficina to set
	 */
	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public List<SelectItem> getItemsReporte() {
		itemsReporte.clear();
		SelectItem item = new SelectItem("0", "Seleccione reporte");
		itemsReporte.add(item);
		item = new SelectItem("1", "Reporte E1");
		itemsReporte.add(item);
		item = new SelectItem("2", "Reporte E2");
		itemsReporte.add(item);
		item = new SelectItem("3", "Reporte E3");
		itemsReporte.add(item);
		item = new SelectItem("4", "Reporte E4");
		itemsReporte.add(item);
		item = new SelectItem("5", "Listado de Empresas");
		itemsReporte.add(item);
		item = new SelectItem("6", "Listado de Ofertas");
		itemsReporte.add(item);
		return itemsReporte;
	}

	public void setItemsReporte(List<SelectItem> itemsReporte) {
		this.itemsReporte = itemsReporte;
	}

	/**
	 * Pdf.
	 * 
	 * @throws JRException
	 *             the jR exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void pdf() throws JRException, IOException {
		
		fechaInicio = UtilDate.getInicioDia(fechaInicio);
		fechaFin = UtilDate.getFinDia(fechaFin);
		
		JRBeanCollectionDataSource beanCollectionDataSource = null;
		String jasper = "";

		logger.info("idReporte" + idReporte);
		if (idReporte.equalsIgnoreCase("0")) {
			return;
		}

		if (fechaInicio.after(fechaFin)) {
			return;
		}

		String feInicio = new SimpleDateFormat("dd/MM/yyyy")
				.format(fechaInicio);
		String feFin = new SimpleDateFormat("dd/MM/yyyy").format(fechaFin);
		logger.info("Inicio " + fechaInicio);
		logger.info("fin " + fechaFin);
//		logger.info("feInicio" + feInicio);
//		logger.info("feFin" + feFin);

		if (idReporte.equalsIgnoreCase("1")) {
			jasper = "/report/reportE1.jasper";

			String[] direcciones = { "1"};
			String[] profesionales = { "2" };
			String[] tecnicos = { "3" };
			String[] operativos = {"4", "5", "6", "7", "8" };
			String[] noCalificados = { "9" };

			List<ReporteE1> lista = getServicio().getProfesionalService()
					.getReporteE1(direcciones, profesionales, tecnicos,
							operativos, noCalificados, feInicio, feFin);

			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);

		} else if (idReporte.equalsIgnoreCase("2")) {
			jasper = "/report/reportE2.jasper";

			List<ReporteE2> lista = new ArrayList<ReporteE2>();

			String[] grupo1 = { "531", "2" };
			String[] grupo2 = { "1" };
			String[] grupo3 = { "4" };
			String[] grupo4 = { "5", "6" };
			String[] grupo5 = { "7" };
			String[] grupo6 = { "124005", "2" };
			String[] grupo7 = { "3" };
			String[] grupo8 = { "4" };
			String[] grupo9 = { "5", "6" };
			String[] grupo10 = { "7" };
			String[] grupo11 = { "87", "2" };
			String[] grupo12 = { "3" };

			lista = getServicio().getProfesionalService().getReporteE2(grupo1,
					grupo2, grupo3,grupo4, grupo5, grupo6, grupo7, grupo8,
					grupo9, grupo10, grupo11, grupo12, feInicio, feFin);

			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
		} else if (idReporte.equalsIgnoreCase("3")) {
			jasper = "/report/reportE3.jasper";

			List<ReporteE3> lista = new ArrayList<ReporteE3>();

			lista = getServicio().getProfesionalService().getReporteE3(
					feInicio, feFin);

			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
		} else if (idReporte.equalsIgnoreCase("4")) {

			jasper = "/report/reportE4.jasper";
			
			List<ReporteE4> lista = new ArrayList<ReporteE4>();
			
			//ReporteE4 reporteE4 = new ReporteE4();
			//lista.add(reporteE4);
			
			String[] grupo1 = { "383007", "2" };
			String[] grupo2 = { "239011" };
			String[] grupo3 = { "4" };
			String[] grupo4 = { "5", "6" };
			String[] grupo5 = { "7" };
			String[] grupo6 = { "124005", "2" };
			String[] grupo7 = { "3" };
			String[] grupo8 = { "4" };
			String[] grupo9 = { "5", "6" };
			String[] grupo10 = { "7" };
			String[] grupo11 = { "87", "2" };
			String[] grupo12 = { "3" };
			
			lista = getServicio().getProfesionalService().getReporteE4(grupo1,
					grupo2, grupo3,grupo4, grupo5, grupo6, grupo7, grupo8,
					grupo9, grupo10, grupo11, grupo12, feInicio, feFin);
			
			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
			
		} else if (idReporte.equalsIgnoreCase("5")) {

			jasper = "/report/reportListEmpresa.jasper";
			
			List<ReporteEmpresa> lista = new ArrayList<ReporteEmpresa>();
			
			List<Empresa> empresas = getServicio().getEmpresaService().buscarPorRangoFecha(feInicio, feFin);
			
			for(Empresa row : empresas){
				ReporteEmpresa fila = new ReporteEmpresa();
				fila.setId(row.getId());
				fila.setRazonSocial(row.getRazonSocial());
				fila.setCantTrabajadores(row.getNumEmpleados());
				
				lista.add(fila);
			}
			
			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
			
		} else if (idReporte.equalsIgnoreCase("6")) {

			jasper = "/report/reportListOferta.jasper";
			
			List<ReporteOferta> lista = new ArrayList<ReporteOferta>();
			
			lista = getServicio().getProfesionalService().buscarPorRangoFecha(feInicio, feFin);
			
			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
			
		} else {
			jasper = "/report/reportePCD1.jasper";
			List<Long> idConsultores = new ArrayList<Long>();
			List<String> idOficinas = new ArrayList<String>();
			if (idConsultor != null && !idConsultor.equals("")) {
				idConsultores.add(new Long(idConsultor));
			}
			if (idOficina != null && !idOficina.equals("")) {
				idOficinas.add(idOficina);
			}
			
			List<Profesional> lista = getServicio().getProfesionalService().buscarProfesionales(idConsultores, idOficinas, fechaInicio, fechaFin);
			
			beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
		}

		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();

		String reportPath = ctx.getRealPath(jasper);

		// attachment || inline
		Oficina oficina = (Oficina) getServicio().getMaestroService().getProveedorMaestroObjectByPK(idOficina, Oficina.class);
		Persona consultor = (Persona) getServicio().getPersonaService().findObjectByPK(new Long(idConsultor), Persona.class);
		
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("logo", ctx.getResourceAsStream("/images/logo_mintra.jpg"));
		params.put("OFICINA", oficina != null ? oficina : new Oficina());
		params.put("FECHA_INICIO", fechaInicio);
		params.put("FECHA_FIN", fechaFin);
		params.put("CONSULTOR", consultor != null ? consultor : new Persona());
		
		//Crear lista de estados civiles para el reporte
		List<EstadoCivil> listaEstadosCiviles = (List<EstadoCivil>) getServicio().getMaestroService().getAllObject(EstadoCivil.class);
		
		HashMap<Integer, EstadoCivil> estadosCiviles = new HashMap<Integer, EstadoCivil>();
		for (EstadoCivil e:listaEstadosCiviles) {
			estadosCiviles.put(new Integer( e.getId().toString()), e);
		}		
		params.put("ESTADOS_CIVILES", estadosCiviles);
		
		//Crear lista de niveles educativos para el reporte
		List<NivelEducativo> listaNivelesEducativos = (List<NivelEducativo>) getServicio().getMaestroService().getProveedorMaestroObject(NivelEducativo.class);
		
		HashMap<Integer, NivelEducativo> nivelesEducativos = new HashMap<Integer, NivelEducativo>();
		for (NivelEducativo e:listaNivelesEducativos) {
			nivelesEducativos.put(new Integer( e.getId().toString()), e);
		}		
		params.put("NIVELES_EDUCATIVOS", nivelesEducativos);
		
		params.put("INTERESES_PROP", Constantes.INTERESES_OCUPACIONALES_PROP);

		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				params, beanCollectionDataSource);

		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=report.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public static void main(String [] args) {
//		Persona p = new Persona();
//		p.setPersonaInteresesOcupacionales(new PersonaInteresesOcupacionales());
//		p.getPersonaInteresesOcupacionales().setAireLibre5(true);
//		p.getPersonaInteresesOcupacionales().setArtisticas1(true);
//		p.getPersonaInteresesOcupacionales().setCientificoAbstractas2(false);
//		System.out.println(ListaUtil.getInteresesOcupacionales(p, Constantes.getPropertyFile("pe/gob/trabajo/pcd/vista/recursos/intereses.properties")));
		System.out.println(UtilDate.getInicioDia(new Date()));
		System.out.println(UtilDate.getFinDia(new Date()));
	}

}
