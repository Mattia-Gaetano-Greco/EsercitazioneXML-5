package src.main.java;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class XMLWriter {
    public static boolean writeAlberghiToXML(HashMap<Integer, Albergo> alberghi, String fileName) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<alberghi>\n";
        for (Albergo m : alberghi.values()) {
            xml += m.toXMLString();
        }
        xml +="</alberghi>";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(xml);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
