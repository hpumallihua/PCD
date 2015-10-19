package pe.gob.trabajo.pcd.vista.bean;

import java.math.BigDecimal;

public class EstimacionBean {

	private BigDecimal nroTrabajadores;
	private Integer nroMes;
	private String calculoPonderado;
	private BigDecimal sumaPonderada;

	public EstimacionBean() {
	}

	public BigDecimal getNroTrabajadores() {
		return nroTrabajadores;
	}

	public void setNroTrabajadores(BigDecimal nroTrabajadores) {
		this.nroTrabajadores = nroTrabajadores;
	}

	public Integer getNroMes() {
		return nroMes;
	}

	public void setNroMes(Integer nroMes) {
		this.nroMes = nroMes;
	}

	public String getCalculoPonderado() {
		return calculoPonderado;
	}

	public void setCalculoPonderado(String calculoPonderado) {
		this.calculoPonderado = calculoPonderado;
	}

	public BigDecimal getSumaPonderada() {
		return sumaPonderada;
	}

	public void setSumaPonderada(BigDecimal sumaPonderada) {
		this.sumaPonderada = sumaPonderada;
	}

	@Override
	public String toString() {
		return "EstimacionBean [nroTrabajadores=" + nroTrabajadores
				+ ", nroMes=" + nroMes + ", calculoPonderado="
				+ calculoPonderado + ", sumaPonderada=" + sumaPonderada + "]";
	}

}
