package com.code.ContactSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class xmlutil {


	public static Document getDocument(){
		
		try {
			Document doc = new SAXReader().read(new File("F://JAVA学习资料//MyJAVA//XML//ContactSystem//com//code//ContactSystem//contact.xml"));
			   return doc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
          	
	}
	public static void writeXML(Document doc){
		OutputStream out;
		try {
			out = new FileOutputStream("F://JAVA学习资料//MyJAVA//XML//ContactSystem//com//code//ContactSystem//contact.xml");
			 OutputFormat format = OutputFormat.createPrettyPrint();
			    XMLWriter writer = new XMLWriter(out, format);
			    writer.write(doc);
			    out.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	  
	}
	
	
}
