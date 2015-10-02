package pe.gob.trabajo.pcd.servicio.auditoria;

import pe.gob.trabajo.pcd.servicio.comun.GenericService;

import pe.gob.trabajo.pcd.modelo.dominio.AuditData;


// TODO: Auto-generated Javadoc
/**
 * The Interface AuditoriaService.
 */
public interface AuditoriaService extends GenericService<AuditData> {
	
	/**
	 * Grabar auditoria grabados.
	 *
	 * @param entidad the entidad
	 */
	public void grabarAuditoriaGrabados(Object entidad);
	
}
