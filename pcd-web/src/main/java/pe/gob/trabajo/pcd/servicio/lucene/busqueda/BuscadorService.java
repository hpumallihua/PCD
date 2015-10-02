package pe.gob.trabajo.pcd.servicio.lucene.busqueda;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.jdbc.JdbcDirectory;

import pe.gob.trabajo.pcd.servicio.util.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class BuscadorService.
 */
public class BuscadorService {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(BuscadorService.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		args = new String[] {"C:\\archivosRich","mysql"};
		if (args.length != 2) {
			throw new Exception("Usage: java " + BuscadorService.class.getName() + " <index dir> <query>");
		}
		File indexDir = new File(args[0]);
		String q = args[1];
		if (!indexDir.exists() || !indexDir.isDirectory()) {
			throw new Exception(indexDir
					+ " does not exist or is not a directory.");
		}
		search(indexDir, q.toLowerCase());
	}
	
	/**
	 * Buscar en cv.
	 *
	 * @param indexDirPath the index dir path
	 * @param q the q
	 * @return the hits
	 */
	public static Hits buscarEnCV(String indexDirPath, String q){
		File indexDir = new File(indexDirPath);
		Directory fsDir;
		Hits hits = null;
		try {
			fsDir = FSDirectory.open(indexDir);
			IndexSearcher is = new IndexSearcher(fsDir, true);
			BooleanQuery bq = new BooleanQuery();
			String[] terminosBuscados = q.toLowerCase().split(Constantes.SEPARADOR_CRITERIOS_CV);
			if (terminosBuscados != null) {
				Term[] terminos = new Term[terminosBuscados.length];
				for (int i = 0; i < terminos.length; i++) {
					terminos[i] = new Term("contents",terminosBuscados[i]);
					FuzzyQuery fuzzy = new FuzzyQuery(new Term("contents",terminosBuscados[i]),0.5f,3);
					bq.add(fuzzy,BooleanClause.Occur.SHOULD);
				}
			}
//		
			long start = new Date().getTime();
			hits = is.search(bq);
			long end = new Date().getTime();
			logger.debug(hits.length() + " documento(s) encontrados (en "
					+ (end - start) + " milisegundos) que coinciden con '" + q
					+ "':");
//			for (int i = 0; i < hits.length(); i++) {
//				Document doc = hits.doc(i);
//				logger.info(hits.score(i) + " \tscore:" + doc.get("filename") );
//			for (Object itm : doc.getFields()) {
//				logger.info(itm);
//			}
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
		}
		
		return hits;
	}
	
	/**
	 * Buscar en cvbd.
	 *
	 * @param indexDirPath the index dir path
	 * @param q the q
	 * @return the hits
	 */
	public static Hits buscarEnCVBD(JdbcDirectory indexDirPath, String q){
//		File indexDir = new File(indexDirPath);
//		Directory fsDir;
		Hits hits = null;
		try {
//			fsDir = FSDirectory.open(indexDir);
			IndexSearcher is = new IndexSearcher(indexDirPath, true);
			BooleanQuery bq = new BooleanQuery();
			String[] terminosBuscados = q.toLowerCase().split(",");
			if (terminosBuscados != null) {
				Term[] terminos = new Term[terminosBuscados.length];
				for (int i = 0; i < terminos.length; i++) {
					terminos[i] = new Term("contents",terminosBuscados[i]);
					FuzzyQuery fuzzy = new FuzzyQuery(new Term("contents",terminosBuscados[i]),0.5f,3);
					bq.add(fuzzy,BooleanClause.Occur.SHOULD);
				}
			}
//		
			long start = new Date().getTime();
			hits = is.search(bq);
			long end = new Date().getTime();
			logger.debug(hits.length() + " documento(s) encontrados (en "
					+ (end - start) + " milisegundos) que coinciden con '" + q
					+ "':");
//			for (int i = 0; i < hits.length(); i++) {
//				Document doc = hits.doc(i);
//				logger.info(hits.score(i) + " \tscore:" + doc.get("filename") );
//			for (Object itm : doc.getFields()) {
//				logger.info(itm);
//			}
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
		}
		
		return hits;
	}

	/**
	 * Search.
	 *
	 * @param indexDir the index dir
	 * @param q the q
	 * @throws Exception the exception
	 */
	public static void search(File indexDir, String q) throws Exception {
		
//		IndexSearcher is = new IndexSearcher(new IndexReader)
//		
//		
		Directory fsDir = null;//FSDirectory.getDirectory(indexDir, false);
		fsDir = FSDirectory.open(indexDir);
		IndexSearcher is = null;//new IndexSearcher(fsDir);
		is = new IndexSearcher(fsDir, true);
		
//		Searcher searcher = new IndexSearcher(IndexReader.open("index"));  
//		Query query = new QueryParser("contents",new StandardAnalyzer()).parse(q);  
//		Hits hits = is.search(query);  
		
//		Query query = QueryParser.parse(q, "contents", new StandardAnalyzer());
		
//		MultiPhraseQuery queryVarios = new MultiPhraseQuery();
//		String[] terminosBuscados = q.split(",");
//		if (terminosBuscados != null) {
//			Term[] terminos = new Term[terminosBuscados.length];
//			for (int i = 0; i < terminos.length; i++) {
//				terminos[i] = new Term("contents",terminosBuscados[i]);				
//			}
//			queryVarios.add(terminos);
//		}
		
		
		BooleanQuery bq = new BooleanQuery();
		String[] terminosBuscados = q.split(",");
		if (terminosBuscados != null) {
			Term[] terminos = new Term[terminosBuscados.length];
			for (int i = 0; i < terminos.length; i++) {
				terminos[i] = new Term("contents",terminosBuscados[i]);
				FuzzyQuery fuzzy = new FuzzyQuery(new Term("contents",terminosBuscados[i]),0.7f);
				bq.add(fuzzy,BooleanClause.Occur.MUST);
			}
		}
//		
		long start = new Date().getTime();
//		Hits hits = is.search(query);
//		Hits hits = is.search(queryVarios);
//		Hits hits = is.search(fuzzy);
		Hits hits = is.search(bq);
		long end = new Date().getTime();
		System.err.println("Found " + hits.length() + " document(s) (in "
				+ (end - start) + " milliseconds) that matched query '" + q
				+ "':");
		for (int i = 0; i < hits.length(); i++) {
			Document doc = hits.doc(i);
			
			logger.debug(hits.score(i) + " \tscore:" + doc.get("filename") );
//			for (Object itm : doc.getFields()) {
//				logger.info(itm);
//			}
		}
	}
}