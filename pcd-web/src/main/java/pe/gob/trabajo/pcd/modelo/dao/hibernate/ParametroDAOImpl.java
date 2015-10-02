package pe.gob.trabajo.pcd.modelo.dao.hibernate;

import java.util.Collection;

import pe.gob.trabajo.pcd.modelo.dao.ParametroDAO;

import pe.gob.trabajo.pcd.modelo.dominio.Parametro;

/**
 * Implementation of MusicDAO implemented by extending Spring's HibernateDaoSupport
 * @author roblambert
 */
//public class ParametroDAOHibernateImpl extends HibernateDaoSupport implements ParametroDAO
public class ParametroDAOImpl extends GenericDaoImpl<Parametro, Long> implements ParametroDAO
{

	public Collection<Parametro> getParametros() {
		return getAll(); 
	}


	

	
//	public Collection<Parametro> getParametros()
//  {
//    return getHibernateTemplate().loadAll(Parametro.class);
//  }
//
//	public Parametro getParametroById(Integer id)
//  {
//		Parametro parametro = (Parametro) getHibernateTemplate().load(Parametro.class, id); 
//    logger.info("Got artist: "+parametro);
//    return parametro;
//  }
//
//	public Parametro saveParametro(Parametro parametro)
//  {
//    getHibernateTemplate().saveOrUpdate(parametro);
//    return parametro;
//  }

//  public Record getRecordById(Integer id)
//  {
//    Record record = (Record) getHibernateTemplate().load(Record.class, id); 
//    logger.info("Got record: "+record);
//    return record;
//  }
//
//  public Record saveRecord(Record record)
//  {
//    getHibernateTemplate().saveOrUpdate(record);
//    return record;
//  } 
//  
//  public Track getTrackById(Integer id)
//  {
//    Track track = (Track) getHibernateTemplate().load(Track.class, id); 
//    logger.info("Got track: "+track);
//    return track; 
//  }
//  
//  public List<Record> searchRecordsByTitle(String title)
//  {
//    return getHibernateTemplate().findByNamedQuery("record.titleLike", "%"+title+"%");
//  }
}