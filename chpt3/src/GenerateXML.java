import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;

/**
 * Example of generating simple XML in Java.
 */
public class GenerateXML {
    public static void main (String[] args) throws ParserConfigurationException, TransformerException {
       DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       Document doc = builder.newDocument();

       Element todos = doc.createElement("todos");
       doc.appendChild(todos);

       Element task = doc.createElement("todo");
       task.setAttribute("id", "1");
       todos.appendChild(task);

       Element name = doc.createElement("name");
       name.setTextContent("Buy Beginning Groovy and Grails");
       task.appendChild(name);

       Element note = doc.createElement("note");
       note.setTextContent("Purchase book from Amazon.com for all co-workers.");
       task.appendChild(note);

       // generate pretty printed XML document
       TransformerFactory tranFactory = TransformerFactory.newInstance();
       Transformer aTransformer = tranFactory.newTransformer();
       aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
       aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

       Source src = new DOMSource(doc);
       Result dest = new StreamResult(System.out);
       aTransformer.transform(src, dest);
    }
}
