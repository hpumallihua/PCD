package pe.gob.trabajo.pcd.modelo.dominio;

// Generated 27/01/2011 05:11:53 PM by Hibernate Tools 3.4.0.Beta1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TiprmPersona generated by hbm2java
 */
public class Persona extends BeanEntidadGenericoAutogenerado implements java.io.Serializable {

	private static final long serialVersionUID = -6544034858563269733L;

	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private Integer sexo;
	private String tipoDocumentoIdentidad;
	private String numeroDocumentoIdentidad;
	private String paisNacimiento;
	private Ubigeo lugarNacimiento;

	private String departamentoNacimiento;
	private String provinciaNacimiento;
	private String distritoNacimiento;

	private String departamentoResidencia;
	private String provinciaResidencia;
	private String distritoResidencia;

	private String nombreLugarResidencia;

	private String telefono;

	private String contacto;

	private String nacionalidad;
	private String paisResidencia;
	private Ubigeo lugarResidencia;
	private String direccion;
	private Date fechaNacimiento;
	private Integer estadoCivil;
	private String fotografia;
	private Profesional profesional;
	private Usuario usuario; //usuario

	// private PersonaDiscapacidad personaDiscapacidad;
	private PersonaDatosMedicos personaDatosMedicos;
	private PersonaMotivacion personaMotivacion;
	private PersonaInteresesOcupacionales personaInteresesOcupacionales;
	private PersonaCondicionesTrabajo personaCondicionesTrabajo;
	private PersonaEvaluacionPerfil personaEvaluacionPerfil;
	//CAMM
	private PersonaPerfilHabilidad personaPerfilHabilidad;

	private Integer esJefeHogar;

	private List<Contacto> contactos = new ArrayList<Contacto>();
	private List<Referencia> referencias = new ArrayList<Referencia>();
	private List<Discapacidad> discapacidades = new ArrayList<Discapacidad>();
	// private List<Usuario> usuarios = new ArrayList<Usuario>();

	private List<PersonaNecesidadApoyo> necesidadesApoyo = new ArrayList<PersonaNecesidadApoyo>();
	private List<PersonaIntegranteFamilia> integrantesFamilia = new ArrayList<PersonaIntegranteFamilia>();
	private List<PersonaDiscapacidad> personaDiscapacidad = new ArrayList<PersonaDiscapacidad>();

	private String[] telefonosFijos = new String[2];
	private String[] telefonosMoviles = new String[2];
	private String[] correosElectronicos = new String[2];

	// camm
	private String telefono2;
	// camm
	private String contacto2;
	// camm
	private Integer tipoTelefono2;
	// camm
	private String correoElectronico;
	// camm
	private Integer tipoTelefono;

	// camm
	private Integer esRegistroConabis;
	// camm
	private String nroDid;
	// camm
	private Integer esLicenciaConducir;
	// camm
	private String categoriaLicencia;
	// camm
	private Integer esVehiculoPropio;
	// camm
	private String vehiculoEspecificar;

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getEsJefeHogar() {

		return (this.esJefeHogar == null) ? 0 : esJefeHogar;

	}

	public void setEsJefeHogar(Integer esJefeHogar) {
		this.esJefeHogar = esJefeHogar;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public String getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public String getDepartamentoNacimiento() {
		return departamentoNacimiento;
	}

	public void setDepartamentoNacimiento(String departamentoNacimiento) {
		this.departamentoNacimiento = departamentoNacimiento;
	}

	public String getProvinciaNacimiento() {
		return provinciaNacimiento;
	}

	public void setProvinciaNacimiento(String provinciaNacimiento) {
		this.provinciaNacimiento = provinciaNacimiento;
	}

	public String getDistritoNacimiento() {
		return distritoNacimiento;
	}

	public void setDistritoNacimiento(String distritoNacimiento) {
		this.distritoNacimiento = distritoNacimiento;
	}

	public String getDepartamentoResidencia() {
		return departamentoResidencia;
	}

	public void setDepartamentoResidencia(String departamentoResidencia) {
		this.departamentoResidencia = departamentoResidencia;
	}

	public String getProvinciaResidencia() {
		return provinciaResidencia;
	}

	public void setProvinciaResidencia(String provinciaResidencia) {
		this.provinciaResidencia = provinciaResidencia;
	}

	public String getDistritoResidencia() {
		return distritoResidencia;
	}

	public void setDistritoResidencia(String distritoResidencia) {
		this.distritoResidencia = distritoResidencia;
	}

	public String getNombreLugarResidencia() {
		return nombreLugarResidencia;
	}

	public void setNombreLugarResidencia(String nombreLugarResidencia) {
		this.nombreLugarResidencia = nombreLugarResidencia;
	}

	public Ubigeo getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(Ubigeo lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Ubigeo getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(Ubigeo lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the personaDiscapacidad
	 */
	// public PersonaDiscapacidad getPersonaDiscapacidad() {
	// return personaDiscapacidad;
	// }

	/**
	 * @param personaDiscapacidad
	 *            the personaDiscapacidad to set
	 */
	// public void setPersonaDiscapacidad(PersonaDiscapacidad
	// personaDiscapacidad) {
	// this.personaDiscapacidad = personaDiscapacidad;
	// }

	public List<PersonaDiscapacidad> getPersonaDiscapacidad() {
		return personaDiscapacidad;
	}

	public void setPersonaDiscapacidad(List<PersonaDiscapacidad> personaDiscapacidad) {
		this.personaDiscapacidad = personaDiscapacidad;
	}

	/**
	 * @return the personaDatosMedicos
	 */
	public PersonaDatosMedicos getPersonaDatosMedicos() {
		return personaDatosMedicos;
	}

	/**
	 * @param personaDatosMedicos
	 *            the personaDatosMedicos to set
	 */
	public void setPersonaDatosMedicos(PersonaDatosMedicos personaDatosMedicos) {
		this.personaDatosMedicos = personaDatosMedicos;
	}

	/**
	 * @return the personaMotivacion
	 */
	public PersonaMotivacion getPersonaMotivacion() {
		return personaMotivacion;
	}

	/**
	 * @param personaMotivacion
	 *            the personaMotivacion to set
	 */
	public void setPersonaMotivacion(PersonaMotivacion personaMotivacion) {
		this.personaMotivacion = personaMotivacion;
	}

	/**
	 * @return the personaInteresesOcupacionales
	 */
	public PersonaInteresesOcupacionales getPersonaInteresesOcupacionales() {
		return personaInteresesOcupacionales;
	}

	/**
	 * @param personaInteresesOcupacionales
	 *            the personaInteresesOcupacionales to set
	 */
	public void setPersonaInteresesOcupacionales(PersonaInteresesOcupacionales personaInteresesOcupacionales) {
		this.personaInteresesOcupacionales = personaInteresesOcupacionales;
	}

	/**
	 * @return the personaCondicionesTrabajo
	 */
	public PersonaCondicionesTrabajo getPersonaCondicionesTrabajo() {
		return personaCondicionesTrabajo;
	}

	/**
	 * @param personaCondicionesTrabajo
	 *            the personaCondicionesTrabajo to set
	 */
	public void setPersonaCondicionesTrabajo(PersonaCondicionesTrabajo personaCondicionesTrabajo) {
		this.personaCondicionesTrabajo = personaCondicionesTrabajo;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public List<Referencia> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	// public List<Usuario> getUsuarios() {
	// return usuarios;
	// }
	// public void setUsuarios(List<Usuario> usuarios) {
	// this.usuarios = usuarios;
	// }

	public List<Discapacidad> getDiscapacidades() {
		return discapacidades;
	}

	public void setDiscapacidades(List<Discapacidad> discapacidades) {
		this.discapacidades = discapacidades;
	}

	/**
	 * @return the necesidadesApoyo
	 */
	public List<PersonaNecesidadApoyo> getNecesidadesApoyo() {
		return necesidadesApoyo;
	}

	/**
	 * @param necesidadesApoyo
	 *            the necesidadesApoyo to set
	 */
	public void setNecesidadesApoyo(List<PersonaNecesidadApoyo> necesidadesApoyo) {
		this.necesidadesApoyo = necesidadesApoyo;
	}

	/**
	 * @return the integrantesFamilia
	 */
	public List<PersonaIntegranteFamilia> getIntegrantesFamilia() {
		return integrantesFamilia;
	}

	/**
	 * @param integrantesFamilia
	 *            the integrantesFamilia to set
	 */
	public void setIntegrantesFamilia(List<PersonaIntegranteFamilia> integrantesFamilia) {
		this.integrantesFamilia = integrantesFamilia;
	}

	public String[] getTelefonosFijos() {
		return telefonosFijos;
	}

	public void setTelefonosFijos(String[] telefonosFijos) {
		this.telefonosFijos = telefonosFijos;
	}

	public String[] getTelefonosMoviles() {
		return telefonosMoviles;
	}

	public void setTelefonosMoviles(String[] telefonosMoviles) {
		this.telefonosMoviles = telefonosMoviles;
	}

	public String[] getCorreosElectronicos() {
		return correosElectronicos;
	}

	public void setCorreosElectronicos(String[] correosElectronicos) {
		this.correosElectronicos = correosElectronicos;
	}

	public List<Contacto> getPersonasContacto() {
		ArrayList<Contacto> lista = new ArrayList<Contacto>();

		for (Contacto contacto : contactos) {
			if (contacto != null) {
				lista.add(contacto);
			}
		}
		return lista;
	}

	public List<Contacto> getDatosContacto() {
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		for (Contacto contacto : contactos) {
			if (contacto != null && getId().equals(contacto.getIdPersonaDestino())) {
				lista.add(contacto);
			}
		}
		return lista;
	}

	public List<Contacto> getDatosContactos() {
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		for (Contacto contacto : contactos) {
			if (contacto != null && !getId().equals(contacto.getIdPersonaDestino())) {
				lista.add(contacto);
			}
		}
		return lista;
	}

	public static Persona construirPersona(Person p) {
		Persona bean = new Persona();
		bean.setId(0L);
		bean.setNumeroDocumentoIdentidad(p.getDni());
		bean.setTipoDocumentoIdentidad("03");
		bean.setApellidoPaterno(p.getApellidoPaterno());
		bean.setApellidoMaterno(p.getApellidoMaterno());
		bean.setSexo(new Integer(p.getCodigoSexo()));
		bean.setNombres(p.getNombres());
		bean.setFechaNacimiento(p.getFechaNacimiento());
		return bean;
	}

	public PersonaEvaluacionPerfil getPersonaEvaluacionPerfil() {
		return personaEvaluacionPerfil;
	}

	public void setPersonaEvaluacionPerfil(PersonaEvaluacionPerfil personaEvaluacionPerfil) {
		this.personaEvaluacionPerfil = personaEvaluacionPerfil;
	}

	public String getContacto2() {
		return contacto2;
	}

	public void setContacto2(String contacto2) {
		this.contacto2 = contacto2;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Integer getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public Integer getTipoTelefono2() {
		return tipoTelefono2;
	}

	public void setTipoTelefono2(Integer tipoTelefono2) {
		this.tipoTelefono2 = tipoTelefono2;
	}

	public Integer getEsRegistroConabis() {

		return (this.esRegistroConabis == null) ? 0 : esRegistroConabis;
	}

	public void setEsRegistroConabis(Integer esRegistroConabis) {
		this.esRegistroConabis = esRegistroConabis;
	}

	public String getNroDid() {
		return nroDid;
	}

	public void setNroDid(String nroDid) {
		this.nroDid = nroDid;
	}

	public Integer getEsLicenciaConducir() {

		return (this.esLicenciaConducir == null) ? 0 : esLicenciaConducir;

	}

	public void setEsLicenciaConducir(Integer esLicenciaConducir) {
		this.esLicenciaConducir = esLicenciaConducir;
	}

	public String getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public void setCategoriaLicencia(String categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}

	public Integer getEsVehiculoPropio() {

		return (this.esVehiculoPropio == null) ? 0 : esVehiculoPropio;

	}

	public void setEsVehiculoPropio(Integer esVehiculoPropio) {
		this.esVehiculoPropio = esVehiculoPropio;
	}

	public String getVehiculoEspecificar() {

		return vehiculoEspecificar;
	}

	public void setVehiculoEspecificar(String vehiculoEspecificar) {
		this.vehiculoEspecificar = vehiculoEspecificar;
	}

	public PersonaPerfilHabilidad getPersonaPerfilHabilidad() {
		return personaPerfilHabilidad;
	}

	public void setPersonaPerfilHabilidad(PersonaPerfilHabilidad personaPerfilHabilidad) {
		this.personaPerfilHabilidad = personaPerfilHabilidad;
	}
}
