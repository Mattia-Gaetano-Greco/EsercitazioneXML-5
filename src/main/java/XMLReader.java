package src.main.java;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

class XMLReader {

    private static HashMap<Integer, Albergo> getAlberghiFromXML(String fileName) {
        HashMap<Integer, Albergo> alberghi = new HashMap<Integer, Albergo>();
        DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder parser = builder.newDocumentBuilder();
            Document document = parser.parse(new File(fileName));
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("albergo");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Albergo albergo = new Albergo(
                        Integer.parseInt(element.getAttribute("id")),
                        element.getElementsByTagName("comune").item(0).getTextContent(),
                        element.getElementsByTagName("provincia").item(0).getTextContent(),
                        element.getElementsByTagName("stelle").item(0).getTextContent(),
                        element.getElementsByTagName("denominazione").item(0).getTextContent()
                    );
                    alberghi.put(albergo.getId(), albergo);
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return alberghi;
    }

    public static HashMap<Integer, Albergo> getAlberghiFromXML(String XMLPath, String XSDPath) {
        if (XMLSchemaValidator.validateXMLSchema(XMLPath, XSDPath))
            return getAlberghiFromXML(XMLPath);
        return null;
    }
    
}