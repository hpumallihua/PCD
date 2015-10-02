package pe.gob.trabajo.pcd.modelo.dominio;

import java.util.Date;

/**
 * TiprmPersona generated by hbm2java
 */
public class Pedido extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {
	
	private static final long serialVersionUID = 6620639202423186067L;
	private Date		fechaRegistro;
	private Date		fechaCierre;
	private Empresa		empleador;
	
	private String		nombre;
	private String		area; 
	private String		reporta;
	private String		coordina;	
	private Integer		personalACargo;
	private Integer		numPersonalACargo;
	private String		planCarrera;
	
	private String		beneficio;
	private Double		remuneracion;
	private String		horario;
	private String 		departamento;
	private String 		provincia;
	private String 		distrito;
	private String 		direccion;
	private String 		nombreLugarResidencia;
	private String 		recursoMaterial;	
	private Integer		tipoContrato;//1:Indeterminado 0:Sujeto a modalidad
	private Integer		duracion;//si tipo es 1 se registra la duracion en meses	
	private Integer		jornada;
	private Date 		fechaInicio;
	private String 		otrosCondicionLaboral;
	
	
	private String 		tareas;
	private String 		operaciones;
	private String 		funciones;	
	private String 		maquinarias;
	private String 		herramientas;	
	//private List<Seguridad> securities;
	//private List<Use> uses;	
	private String 		observaciones;	
	private String 		trabajoGrupo;
	private String 		habilidadSocial;
	private String		nivelEducativo; //formacion
	private Integer		tipoExperiencia;//0:NO 1:SI
	private String		datoExperiencia;//si tipo es 1 se registra el dato de la experiencia
	private String		organigrama;
	private String		condiciones;	
	private String 		infoComplementaria;	
	private String		ambRuidoComennt;
	private Integer		ambRuidoValor;	
	private String		ambIluminaComennt;
	private Integer		ambIluminaValor;	
	private String		ambVentilaComennt;
	private Integer		ambVentilaValor;	
	private String		ambTemperaComennt;
	private Integer		ambTemperaValor;	
	private String		ambHumedadComennt;
	private Integer		ambHumedadValor;	
	private String		ambPolvoComennt;
	private Integer		ambPolvoValor;	
	private String		ambVibraComennt;
	private Integer		ambVibraValor;	
	private String		supresionArquitectura;
	private String		equipamento;
	private String		horariosTrabajo;
	private String		adaptaciones;
	private String		serviciosAsistencia;
	private String		disenoPuesto;
	private String		productosApoyo;
	private String		asignacionTemporal;
	
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public Empresa getEmpleador() {
		return empleador;
	}
	public void setEmpleador(Empresa empleador) {
		this.empleador = empleador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getReporta() {
		return reporta;
	}
	public void setReporta(String reporta) {
		this.reporta = reporta;
	}
	public String getCoordina() {
		return coordina;
	}
	public void setCoordina(String coordina) {
		this.coordina = coordina;
	}
	public Integer getPersonalACargo() {
		return personalACargo;
	}
	public void setPersonalACargo(Integer personalACargo) {
		this.personalACargo = personalACargo;
	}
	public Integer getNumPersonalACargo() {
		return numPersonalACargo;
	}
	public void setNumPersonalACargo(Integer numPersonalACargo) {
		this.numPersonalACargo = numPersonalACargo;
	}
	public String getPlanCarrera() {
		return planCarrera;
	}
	public void setPlanCarrera(String planCarrera) {
		this.planCarrera = planCarrera;
	}
	public Double getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Double remuneracion) {
		this.remuneracion = remuneracion;
	}
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
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
	public String getNombreLugarResidencia() {
		return nombreLugarResidencia;
	}
	public void setNombreLugarResidencia(String nombreLugarResidencia) {
		this.nombreLugarResidencia = nombreLugarResidencia;
	}
	public String getRecursoMaterial() {
		return recursoMaterial;
	}
	public void setRecursoMaterial(String recursoMaterial) {
		this.recursoMaterial = recursoMaterial;
	}
	public Integer getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(Integer tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Integer getJornada() {
		return jornada;
	}
	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}
	public String getOtrosCondicionLaboral() {
		return otrosCondicionLaboral;
	}
	public void setOtrosCondicionLaboral(String otrosCondicionLaboral) {
		this.otrosCondicionLaboral = otrosCondicionLaboral;
	}
	public String getTareas() {
		return tareas;
	}
	public void setTareas(String tareas) {
		this.tareas = tareas;
	}
	public String getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}
	public String getFunciones() {
		return funciones;
	}
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	public String getMaquinarias() {
		return maquinarias;
	}
	public void setMaquinarias(String maquinarias) {
		this.maquinarias = maquinarias;
	}
	public String getHerramientas() {
		return herramientas;
	}
	public void setHerramientas(String herramientas) {
		this.herramientas = herramientas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getTrabajoGrupo() {
		return trabajoGrupo;
	}
	public void setTrabajoGrupo(String trabajoGrupo) {
		this.trabajoGrupo = trabajoGrupo;
	}
	public String getHabilidadSocial() {
		return habilidadSocial;
	}
	public void setHabilidadSocial(String habilidadSocial) {
		this.habilidadSocial = habilidadSocial;
	}
	public String getNivelEducativo() {
		return nivelEducativo;
	}
	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}
	public Integer getTipoExperiencia() {
		return tipoExperiencia;
	}
	public void setTipoExperiencia(Integer tipoExperiencia) {
		this.tipoExperiencia = tipoExperiencia;
	}
	public String getDatoExperiencia() {
		return datoExperiencia;
	}
	public void setDatoExperiencia(String datoExperiencia) {
		this.datoExperiencia = datoExperiencia;
	}
	public String getOrganigrama() {
		return organigrama;
	}
	public void setOrganigrama(String organigrama) {
		this.organigrama = organigrama;
	}
	public String getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public String getInfoComplementaria() {
		return infoComplementaria;
	}
	public void setInfoComplementaria(String infoComplementaria) {
		this.infoComplementaria = infoComplementaria;
	}
	public String getAmbRuidoComennt() {
		return ambRuidoComennt;
	}
	public void setAmbRuidoComennt(String ambRuidoComennt) {
		this.ambRuidoComennt = ambRuidoComennt;
	}
	public Integer getAmbRuidoValor() {
		return ambRuidoValor;
	}
	public void setAmbRuidoValor(Integer ambRuidoValor) {
		this.ambRuidoValor = ambRuidoValor;
	}
	public String getAmbIluminaComennt() {
		return ambIluminaComennt;
	}
	public void setAmbIluminaComennt(String ambIluminaComennt) {
		this.ambIluminaComennt = ambIluminaComennt;
	}
	public Integer getAmbIluminaValor() {
		return ambIluminaValor;
	}
	public void setAmbIluminaValor(Integer ambIluminaValor) {
		this.ambIluminaValor = ambIluminaValor;
	}
	public String getAmbVentilaComennt() {
		return ambVentilaComennt;
	}
	public void setAmbVentilaComennt(String ambVentilaComennt) {
		this.ambVentilaComennt = ambVentilaComennt;
	}
	public Integer getAmbVentilaValor() {
		return ambVentilaValor;
	}
	public void setAmbVentilaValor(Integer ambVentilaValor) {
		this.ambVentilaValor = ambVentilaValor;
	}
	public String getAmbTemperaComennt() {
		return ambTemperaComennt;
	}
	public void setAmbTemperaComennt(String ambTemperaComennt) {
		this.ambTemperaComennt = ambTemperaComennt;
	}
	public Integer getAmbTemperaValor() {
		return ambTemperaValor;
	}
	public void setAmbTemperaValor(Integer ambTemperaValor) {
		this.ambTemperaValor = ambTemperaValor;
	}
	public String getAmbHumedadComennt() {
		return ambHumedadComennt;
	}
	public void setAmbHumedadComennt(String ambHumedadComennt) {
		this.ambHumedadComennt = ambHumedadComennt;
	}
	public Integer getAmbHumedadValor() {
		return ambHumedadValor;
	}
	public void setAmbHumedadValor(Integer ambHumedadValor) {
		this.ambHumedadValor = ambHumedadValor;
	}
	public String getAmbPolvoComennt() {
		return ambPolvoComennt;
	}
	public void setAmbPolvoComennt(String ambPolvoComennt) {
		this.ambPolvoComennt = ambPolvoComennt;
	}
	public Integer getAmbPolvoValor() {
		return ambPolvoValor;
	}
	public void setAmbPolvoValor(Integer ambPolvoValor) {
		this.ambPolvoValor = ambPolvoValor;
	}
	public String getAmbVibraComennt() {
		return ambVibraComennt;
	}
	public void setAmbVibraComennt(String ambVibraComennt) {
		this.ambVibraComennt = ambVibraComennt;
	}
	public Integer getAmbVibraValor() {
		return ambVibraValor;
	}
	public void setAmbVibraValor(Integer ambVibraValor) {
		this.ambVibraValor = ambVibraValor;
	}
	public String getSupresionArquitectura() {
		return supresionArquitectura;
	}
	public void setSupresionArquitectura(String supresionArquitectura) {
		this.supresionArquitectura = supresionArquitectura;
	}
	public String getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	public String getHorariosTrabajo() {
		return horariosTrabajo;
	}
	public void setHorariosTrabajo(String horariosTrabajo) {
		this.horariosTrabajo = horariosTrabajo;
	}
	public String getAdaptaciones() {
		return adaptaciones;
	}
	public void setAdaptaciones(String adaptaciones) {
		this.adaptaciones = adaptaciones;
	}
	public String getServiciosAsistencia() {
		return serviciosAsistencia;
	}
	public void setServiciosAsistencia(String serviciosAsistencia) {
		this.serviciosAsistencia = serviciosAsistencia;
	}
	public String getDisenoPuesto() {
		return disenoPuesto;
	}
	public void setDisenoPuesto(String disenoPuesto) {
		this.disenoPuesto = disenoPuesto;
	}
	public String getProductosApoyo() {
		return productosApoyo;
	}
	public void setProductosApoyo(String productosApoyo) {
		this.productosApoyo = productosApoyo;
	}
	public String getAsignacionTemporal() {
		return asignacionTemporal;
	}
	public void setAsignacionTemporal(String asignacionTemporal) {
		this.asignacionTemporal = asignacionTemporal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	} 
	
	
	

}
