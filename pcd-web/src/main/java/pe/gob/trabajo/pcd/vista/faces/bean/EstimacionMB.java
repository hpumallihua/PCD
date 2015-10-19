package pe.gob.trabajo.pcd.vista.faces.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.vista.bean.EstimacionBean;
import pe.gob.trabajo.pcd.vista.bean.UsuarioSesion;

// TODO: Auto-generated Javadoc
/**
 * The Class SesionMB.
 */
public class EstimacionMB extends GenericManagedBean {

	/** The logger. */
	private static Logger logger = Logger.getLogger(EstimacionMB.class);

	private List<EstimacionBean> listEstimacion = new ArrayList<EstimacionBean>();
	// private EstimacionBean itemSelected = new EstimacionBean();
	private BigDecimal baseCalculo;
	private BigDecimal baseCalculoRedondeado;
	private BigDecimal cuota;
	private BigDecimal cuotaRedondeado;

	/**
	 * Instantiates a new sesion mb.
	 */
	public EstimacionMB() {
		init();
	}

	@Override
	public void init() {
		
		logger.info("init");

		EstimacionBean estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(1);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(1/12)");
		estimacionBean.setSumaPonderada(estimacionBean.getNroTrabajadores()
				.multiply(new BigDecimal(estimacionBean.getNroMes() * 12)));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(2);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(2/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(3);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(3/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(4);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(4/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(5);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(5/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(6);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(6/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(7);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(7/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(8);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(8/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(9);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(9/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(10);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(10/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(11);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(11/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);

		estimacionBean = new EstimacionBean();
		estimacionBean.setNroTrabajadores(new BigDecimal(0));
		estimacionBean.setNroMes(12);
		estimacionBean.setCalculoPonderado(estimacionBean.getNroTrabajadores()
				+ "(12/12)");
		estimacionBean.setSumaPonderada(new BigDecimal(0));

		listEstimacion.add(estimacionBean);
		
		baseCalculo = new BigDecimal(0);
		baseCalculoRedondeado = new BigDecimal(0);
		cuota = new BigDecimal(0);
		cuotaRedondeado = new BigDecimal(0);

		// setBean(new UsuarioSesion());
	}

	public List<EstimacionBean> getListEstimacion() {
		return listEstimacion;
	}

	public void setListEstimacion(List<EstimacionBean> listEstimacion) {
		this.listEstimacion = listEstimacion;
	}

	/*
	 * public EstimacionBean getItemSelected() { return itemSelected; }
	 * 
	 * public void setItemSelected(EstimacionBean itemSelected) {
	 * this.itemSelected = itemSelected; }
	 */

	public BigDecimal getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(BigDecimal baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public BigDecimal getBaseCalculoRedondeado() {
		return baseCalculoRedondeado;
	}

	public void setBaseCalculoRedondeado(BigDecimal baseCalculoRedondeado) {
		this.baseCalculoRedondeado = baseCalculoRedondeado;
	}

	public BigDecimal getCuota() {
		return cuota;
	}

	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}

	public BigDecimal getCuotaRedondeado() {
		return cuotaRedondeado;
	}

	public void setCuotaRedondeado(BigDecimal cuotaRedondeado) {
		this.cuotaRedondeado = cuotaRedondeado;
	}

	public void calcular(ActionEvent e) {

		EstimacionBean itemSelected = (EstimacionBean) getRowParameter(e,
				"estimacionPrm");

		logger.info("metodo calcular" + itemSelected);

		Iterator<EstimacionBean> itr = listEstimacion.iterator();
		while (itr.hasNext()) {

			EstimacionBean element = itr.next();
			System.out.printf(element + " " + "%n");
			if (element.getNroMes() == itemSelected.getNroMes()) {
				logger.info("IGUALES");
				itemSelected.setCalculoPonderado(itemSelected
						.getNroTrabajadores()
						+ "("
						+ itemSelected.getNroMes()
						+ "/ 12)");
				double div = ((double) itemSelected.getNroMes() / 12);
				logger.info("div=" + div);
				itemSelected.setSumaPonderada(itemSelected.getNroTrabajadores()
						.multiply(new BigDecimal(div))
						.setScale(2, BigDecimal.ROUND_HALF_UP));
				listEstimacion.set(element.getNroMes() - 1, itemSelected);
				break;
			}

		}

		BigDecimal total = BigDecimal.ZERO;
		for (EstimacionBean row : listEstimacion) {
			logger.info("row.getSumaPonderada()=" + row.getSumaPonderada());
			total = total.add(row.getSumaPonderada());
		}
		logger.info("total=" + total);
		setBaseCalculo(total);
		baseCalculoRedondeado = total.setScale(1, BigDecimal.ROUND_HALF_UP);
		logger.info("baseCalculoRedondeado=" + baseCalculoRedondeado);
		double div2 = (double)3 / 100;
		logger.info("div2=" + div2);
		cuota = baseCalculoRedondeado.multiply(new BigDecimal(0.03)).setScale(3, BigDecimal.ROUND_HALF_UP);
		logger.info("cuota=" + cuota);
		cuotaRedondeado = cuota.setScale(1, BigDecimal.ROUND_HALF_UP);
		logger.info("cuotaRedondeado=" + cuotaRedondeado);
	}

}
