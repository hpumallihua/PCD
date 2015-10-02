package pe.gob.trabajo.pcd.servicio.lucene.busqueda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.jdbc.JdbcDirectory;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

import pe.gob.trabajo.pcd.modelo.dominio.Profesional;
import pe.gob.trabajo.pcd.vista.faces.bean.GenericManagedBean;
import pe.gob.trabajo.pcd.vista.faces.util.UtilBean;
// TODO: Auto-generated Javadoc
//import org.apache.poi.

/**
 * The Class Indexer.
 */
public class Indexer {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(Indexer.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
//		args = new String[] {"\\\\192.168.1.61\\archivosBDTI\\cv\\","\\\\192.168.1.61\\archivosBDTI\\cv\\"};
		args = new String[] {"C:\\SILNETFILES\\cv\\","C:\\SILNETFILES\\cv\\"};
		if (args.length != 2) {
			throw new Exception("Usage: java " + Indexer.class.getName()
					+ " <index dir> <data dir>");
		}
		File indexDir = new File(args[0]);
		File dataDir = new File(args[1]);
		long start = new Date().getTime();
		int numIndexed = index(indexDir, dataDir, null);
		long end = new Date().getTime();
		logger.debug("La indexación de " + numIndexed + " archivos tomó "
				+ (end - start) + " milisegundos");
	}
	
	/**
	 * Indexar carpeta.
	 *
	 * @param carpetaIndice the carpeta indice
	 * @param carpetaDatos the carpeta datos
	 * @throws Exception the exception
	 */
	public static void indexarCarpeta(String carpetaIndice, String carpetaDatos) throws Exception {
//		args = new String[] {"\\\\192.168.1.61\\archivosBDTI\\cv\\","\\\\192.168.1.61\\archivosBDTI\\cv\\"};
//		if (args.length != 2) {
//			throw new Exception("Usage: java " + Indexer.class.getName()
//					+ " <index dir> <data dir>");
//		}
		File indexDir = new File(carpetaIndice);
		File dataDir = new File(carpetaDatos);
		long start = new Date().getTime();
		int numIndexed = index(indexDir, dataDir, null);
		long end = new Date().getTime();
		logger.debug("La indexación de " + numIndexed + " archivos tomó "
				+ (end - start) + " millisegundos");
	}
	
	/**
	 * Indexar carpeta bd.
	 *
	 * @param carpetaIndice the carpeta indice
	 * @param carpetaDatos the carpeta datos
	 * @throws Exception the exception
	 */
	public static void indexarCarpetaBD(JdbcDirectory carpetaIndice, String carpetaDatos) throws Exception {
//		File indexDir = new File(carpetaIndice);
		File dataDir = new File(carpetaDatos);
		long start = new Date().getTime();
		int numIndexed = indexBD(carpetaIndice, dataDir, null);
		long end = new Date().getTime();
		logger.debug("La indexación de " + numIndexed + " archivos tomó "
				+ (end - start) + " millisegundos");
	}
	
	/**
	 * Indexar archivo.
	 *
	 * @param rutaArchivo the ruta archivo
	 * @param profesional the profesional
	 */
	public static void indexarArchivo(String rutaArchivo, Profesional profesional){
		File indexDir = new File(rutaArchivo);
		File dataDir = new File(UtilBean.getParametrosMap().get("CARPETA_CV").toString());
		try {
			int numIndexed = indexar(indexDir.getParentFile(), dataDir, profesional);
			logger.debug(numIndexed + " archivos indexados");
		} catch (IOException e) {
			logger.error(e.getStackTrace());
		}
	}
	
	/**
	 * Indexar.
	 *
	 * @param indexDir the index dir
	 * @param dataDir the data dir
	 * @param profesional the profesional
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static int indexar(File indexDir, File dataDir, Profesional profesional) throws IOException {
		
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " no existe o no es una carpeta");
		}
		IndexWriter writer = new IndexWriter(indexDir.getParent(), new StandardAnalyzer(), true);
		writer.setUseCompoundFile(false);
		indexDirectory(writer, indexDir, profesional);
		int numIndexed = writer.docCount();
		writer.optimize();
		writer.close();
		return numIndexed;
	}
	
	// open an index and start file directory traversal
	/**
	 * Index.
	 *
	 * @param indexDir the index dir
	 * @param dataDir the data dir
	 * @param profesional the profesional
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static int index(File indexDir, File dataDir, Profesional profesional) throws IOException {
		
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " no existe o no es una carpeta");
		}
		IndexWriter writer = new IndexWriter(indexDir, new StandardAnalyzer(), true);
		writer.setUseCompoundFile(false);
		indexDirectory(writer, dataDir, profesional);
		int numIndexed = writer.docCount();
		writer.optimize();
		writer.close();
		return numIndexed;
	}
	
	/**
	 * Index bd.
	 *
	 * @param indexDir the index dir
	 * @param dataDir the data dir
	 * @param profesional the profesional
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static int indexBD(JdbcDirectory indexDir, File dataDir, Profesional profesional) throws IOException {
		
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " no existe o no es una carpeta");
		}
		IndexWriter writer = new IndexWriter(indexDir, new StandardAnalyzer(), true);
		writer.setUseCompoundFile(false);
		indexDirectory(writer, dataDir, profesional);
		int numIndexed = writer.docCount();
		writer.optimize();
		writer.close();
		return numIndexed;
	}
	
	// recursive method that calls itself when it finds a directory
	/**
	 * Index directory.
	 *
	 * @param writer the writer
	 * @param dir the dir
	 * @param profesional the profesional
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void indexDirectory(IndexWriter writer, File dir, Profesional profesional)
	throws IOException {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				indexDirectory(writer, f, profesional);
			} else if (f.getName().toLowerCase().endsWith(".txt")) {
				indexFile(writer, f, profesional);
			} else if (f.getName().toLowerCase().endsWith(".pdf")) {
				indexFilePDF(writer, f, profesional);
			}else if (f.getName().toLowerCase().endsWith(".doc") || f.getName().toLowerCase().endsWith(".docx") || 
					f.getName().toLowerCase().endsWith(".xls") || f.getName().toLowerCase().endsWith(".xlsx") || 
					f.getName().toLowerCase().endsWith(".ppt") || f.getName().toLowerCase().endsWith(".pptx") || 
					f.getName().toLowerCase().endsWith(".vsdxx")) {
				indexFileOffice(writer, f, profesional);
			}
		}
	}
	// method to actually index a file using Lucene
	/**
	 * Index file.
	 *
	 * @param writer the writer
	 * @param f the f
	 * @param profesional the profesional
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void indexFile(IndexWriter writer, File f, Profesional profesional)
	throws IOException {
		if (f.isHidden() || !f.exists() || !f.canRead()) {
			return;
		}
//		logger.debug("Indexando " + f.getCanonicalPath());
		Document doc = new Document();
		
		doc.add(new Field("contents", new FileReader(f)));
		Field titleField = new Field("filename", f.getAbsolutePath(), Field.Store.YES, Field.Index.ANALYZED);
		doc.add(titleField);
		if (profesional != null && profesional.getId() != null) {
			Field idField = new Field("id", profesional.getId().toString(), Field.Store.YES, Field.Index.ANALYZED);
			doc.add(idField);				
		}
		Field dniField = new Field("dni", f.getParentFile().getName(), Field.Store.YES, Field.Index.ANALYZED);
		doc.add(dniField);
		writer.addDocument(doc);
	}
	
	/**
	 * Index file pdf.
	 *
	 * @param writer the writer
	 * @param f the f
	 * @param profesional the profesional
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void indexFilePDF(IndexWriter writer, File f, Profesional profesional) throws IOException {
		if (f.isHidden() || !f.exists() || !f.canRead()) {
			return;
		}
//		logger.debug("Indexando " + f.getCanonicalPath());
		FileInputStream fi = new FileInputStream(f);  
		
		PDFParser parser = new PDFParser(fi);  
		parser.parse();  
		COSDocument cd = parser.getDocument();  
		PDFTextStripper stripper = new PDFTextStripper();  
		String text = stripper.getText(new PDDocument(cd));
		cd.close();
		
		Document doc = new Document();
		Field contenidoField = new Field("contents", text.toLowerCase(GenericManagedBean.locale), Field.Store.YES, Field.Index.ANALYZED);
		doc.add(contenidoField);
		Field titleField = new Field("filename", f.getAbsolutePath(), Field.Store.YES, Field.Index.ANALYZED);
		doc.add(titleField);
		if (profesional != null && profesional.getId() != null) {
			Field idField = new Field("id", profesional.getId().toString(), Field.Store.YES, Field.Index.ANALYZED);
			doc.add(idField);				
		}
		Field dniField = new Field("dni", f.getParentFile().getName(), Field.Store.YES, Field.Index.ANALYZED);
		doc.add(dniField);
		writer.addDocument(doc);
	}
	
	/**
	 * Index file office.
	 *
	 * @param writer the writer
	 * @param f the f
	 * @param profesional the profesional
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void indexFileOffice(IndexWriter writer, File f, Profesional profesional) throws IOException {
		if (f.isHidden() || !f.exists() || !f.canRead()) {
			return;
		}
//		logger.debug("Indexando " + f.getCanonicalPath());
		
		FileInputStream fi = new FileInputStream(f);
		String officeText = "";
		
		POITextExtractor poitex;
		try {
			poitex = ExtractorFactory.createExtractor(fi);
			officeText = poitex.getText();
			
			Document doc = new Document();
			Field contenidoField = new Field("contents", officeText.toLowerCase(GenericManagedBean.locale), Field.Store.YES, Field.Index.ANALYZED);
			doc.add(contenidoField);
			Field titleField = new Field("filename", f.getAbsolutePath(), Field.Store.YES, Field.Index.ANALYZED);
			doc.add(titleField);
			if (profesional != null && profesional.getId() != null) {
				Field idField = new Field("id", profesional.getId().toString(), Field.Store.YES, Field.Index.ANALYZED);
				doc.add(idField);				
			}
			Field dniField = new Field("dni", f.getParentFile().getName(), Field.Store.YES, Field.Index.ANALYZED);
			doc.add(dniField);
			writer.addDocument(doc);
			
		} catch (InvalidFormatException e) {
			logger.error(e.getStackTrace());
		} catch (OpenXML4JException e) {
			logger.error(e.getStackTrace());
		} catch (XmlException e) {
			logger.error(e.getStackTrace());
		}
		
	}
	
}

