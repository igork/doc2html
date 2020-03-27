package doc2html;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.SAXException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
//import org.apache.tika.TikaException;
//import org.apache.tika.ToXMLContentHandler;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ToXMLContentHandler;
//import org.apache.tuka.metadata.Metadata;
import org.xml.sax.ContentHandler;

public class Convertor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "";
		try {

			text = parseToHTML();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(text);
	}
	
	public static String parseToHTML() throws IOException, SAXException, TikaException {
	    ContentHandler handler = new ToXMLContentHandler();
	    
	    String doc = "Gabi_resume_draft.docx"; //"Benjamin Ford.pdf";
	    
	 
	    AutoDetectParser parser = new AutoDetectParser();
	    Metadata metadata = new Metadata();
	    try (InputStream stream = Convertor.class.getResourceAsStream(doc)) {
	        parser.parse(stream, handler, metadata);
	        return handler.toString();
	    }
	}

}
