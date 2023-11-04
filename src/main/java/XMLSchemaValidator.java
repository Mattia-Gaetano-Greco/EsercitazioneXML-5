package src.main.java; 
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

// best validator online: https://www.liquid-technologies.com/online-xsd-validator
public class XMLSchemaValidator {
    public static boolean validateXMLSchema(String XMLPath, String XSDPath){
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSDPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(XMLPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}