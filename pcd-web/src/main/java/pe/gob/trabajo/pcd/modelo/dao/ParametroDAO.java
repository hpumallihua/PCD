package pe.gob.trabajo.pcd.modelo.dao;

import java.util.Collection;

import pe.gob.trabajo.pcd.modelo.dominio.Parametro;

public interface ParametroDAO extends GenericDao<Parametro, Long> {
	
  public Collection<Parametro> getParametros();

  /**
   * Get a Parametro Object given the id 
   * @param id
//   */
//  public Parametro getParametroById(Long id);
//
//  /**
//   * Save an Parametro Object
//   */
//  public Parametro saveParametro(Parametro parametro);

  
}
