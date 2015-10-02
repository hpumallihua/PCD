package pe.gob.trabajo.pcd.vista.bean;

import java.util.Date;

import pe.gob.trabajo.pcd.modelo.dominio.Empresa;
import pe.gob.trabajo.pcd.modelo.dominio.Pedido;
import pe.gob.trabajo.pcd.modelo.dominio.Persona;
import pe.gob.trabajo.pcd.modelo.dominio.Usuario;
import pe.gob.trabajo.pcd.servicio.util.Constantes;


// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSesion.
 */
public class UsuarioSesion {
	
	/** The nombre usuario. */
	String nombreUsuario;
	
	/** The clave. */
	String clave;
	
	/** The persona. */
	Persona persona;
	
	/** The empresa. */
	Empresa empresa;
	
	/** The usuario. */
	Usuario usuario;
	
	/** The pagina inicial. */
	String paginaInicial;
	
	/** The RUC Empresa. */
	String rucEmpresa;
	
	/** The RUC Empresa. */
	String passEmpresa;
	
	/** The DNI Postulante. */
	String dni;
	
	/** The fecha de Nacimiento. */
	Date fechaNacimiento;
	
	/** The DNI Postulante. */
	String sexo;
	
	/** The DNI Postulante. */
	Pedido pedido;
	
	/**
	 * Instantiates a new usuario sesion.
	 */
	public UsuarioSesion() {
		
	}

	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombre usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the new nombre usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Gets the clave.
	 *
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Sets the clave.
	 *
	 * @param clave the new clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the rucEmpresa
	 */
	public String getRucEmpresa() {
		return rucEmpresa;
	}

	/**
	 * @param rucEmpresa the rucEmpresa to set
	 */
	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	/**
	 * @return the passEmpresa
	 */
	public String getPassEmpresa() {
		return passEmpresa;
	}

	/**
	 * @param passEmpresa the passEmpresa to set
	 */
	public void setPassEmpresa(String passEmpresa) {
		this.passEmpresa = passEmpresa;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the persona.
	 *
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Sets the persona.
	 *
	 * @param persona the new persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the pagina inicial.
	 *
	 * @return the pagina inicial
	 */
	public String getPaginaInicial() {
		return paginaInicial;
	}

	/**
	 * Sets the pagina inicial.
	 *
	 * @param paginaInicial the new pagina inicial
	 */
	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}
	
	/**
	 * Al inicio.
	 *
	 * @return the string
	 */
	public String alInicio() {
		return this.paginaInicial;
	}

	/**
	 * Checks if is rol administrador.
	 *
	 * @return true, if is rol administrador
	 */
	public boolean isRolAdministrador() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_ADMINISTRADOR.getId())) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	/**
	 * Checks if is rol auditor.
	 *
	 * @return true, if is rol auditor
	 */
	public boolean isRolConsultorABE() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_CONSULTOR_ABE.getId())) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	/**
	 * Checks if is rol gestor.
	 *
	 * @return true, if is rol gestor
	 */
	public boolean isRolConsultorEmpleo() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_CONSULTOR_EMPLEO.getId())) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	/**
	 * Checks if is rol consultor CUL.
	 *
	 * @return true, if is rol consultor CUL
	 */
	public boolean isRolConsultorCUL() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_CONSULTOR_CUL.getId())) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	/**
	 * Checks if is rol profesional.
	 *
	 * @return true, if is rol profesional
	 */
	public boolean isRolProfesional() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_PROFESIONAL.getId())) {
				retorno = true;
			}
		}
//		if (!(isRolAdministrador() || isRolConsultorEmpleo() || isRolConsultorABE() || isRolConsultorCUL() || isRolEmpleador())) {
//			retorno = true;
//		}
		return retorno;
	}
	
	/**
	 * Checks if is rol profesional.
	 *
	 * @return true, if is rol profesional
	 */
	public boolean isRolEmpleador() {
		boolean retorno = false;
		if (usuario != null && usuario.getRol() != null) {
			if (usuario.getRol().getId().equals(Constantes.ROL_EMPLEADOR.getId())) {
				retorno = true;
			}
		}
//		if (!(isRolAdministrador() || isRolConsultorEmpleo() || isRolConsultorABE() || isRolConsultorCUL() || isRolProfesional())) {
//			retorno = true;
//		}
		return retorno;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
