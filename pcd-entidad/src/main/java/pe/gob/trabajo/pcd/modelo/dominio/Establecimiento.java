package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1


/**
 * TiprfPrfsnalCertificacion generated by hbm2java
 */
public class Establecimiento extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {

	private static final long serialVersionUID = 6993472623600983247L;
	
	private Empresa empresa;
	private Long   tipoEstablecimiento;
	private String departamento;
	private String provincia;
	private String distrito;
	private String direccion;
	private String telefono;
	private String flag;
	private String nombreLugarResidencia;
	private String codigoOficinaAsociada;
	private String personaContacto;
	
	public Long getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}
	public void setTipoEstablecimiento(Long tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getNombreLugarResidencia() {
		return nombreLugarResidencia;
	}
	public void setNombreLugarResidencia(String nombreLugarResidencia) {
		this.nombreLugarResidencia = nombreLugarResidencia;
	}
	public void setCodigoOficinaAsociada(String codigoOficinaAsociada) {
		this.codigoOficinaAsociada = codigoOficinaAsociada;
	}
	public String getCodigoOficinaAsociada() {
		return codigoOficinaAsociada;
	}
	public String getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}


}
