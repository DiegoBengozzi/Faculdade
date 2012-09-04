import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Numero {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setNamespaceAware(true);
		
		SchemaFactory shemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = shemaFactory.newSchema(new File("xml/numeros.xsd"));
		
		factory.setSchema(schema);
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse("xml/numeros.xml");
		
		percorrer(document);

	}

	public static void percorrer(Node node) {
		System.out.println(node.getNodeName() + " => " + node.getNodeValue());

		Node filho = node.getFirstChild();
		while (filho != null) {
			percorrer(filho);
			filho = filho.getNextSibling();
		}

	}

}
