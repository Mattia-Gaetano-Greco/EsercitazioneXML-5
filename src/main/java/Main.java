package src.main.java;
import java.util.HashMap;

public class Main {
    
    // Create, update, read, delete

    // DO A DTD VALIDATOR?
    public static void main(String[] args) {
        int code = 0;
        Scanner input = new Scanner(System.in);
        while (code != 5) {
            if (code == 0) {
                System.out.println("Inserire uno dei seguenti codici per avviare la corrispondente operazione:");
                System.out.println("1 - Creare un elemento in un XML Alberghi");
                System.out.println("2 - Aggiornare un elemento in un XML Alberghi");
                System.out.println("3 - Scrivere a video gli elementi di un XML Alberghi");
                System.out.println("4 - Eliminare un elemento in un XML Alberghi");
                String input = 
            }
            if (code == 1)
        }




        String XMLPath = "";
        if (args.length == 0)
            XMLPath = "src/main/resources/test.xml";
        else
            XMLPath = args[0];
        HashMap<Integer, Albergo> alberghi = XMLReader.getAlberghiFromXML(XMLPath, "src/main/resources/albergo.xsd");
        if (alberghi == null) {
            System.out.println("\nEsecuzione terminata.");
        } else {
            System.out.println("\nDocumento XML ben formato e valido!\n\nMacchine laboratorio: ");
            System.out.println("------");
            for (Albergo m : alberghi.values()) {
                System.out.println(m.toString());
            }
        }
        // write test
        Albergo a1 = new Albergo(13, "Calusco", "Bergamo", "2 Stelle **", "Romani");
        Albergo a2 = new Albergo(14, "Merate", "Lecco", "3 Stelle ***", "Marianela");
        Albergo a3 = new Albergo(15, "Catanzaro Lido", "Catanzaro", "4 Stelle ****", "Hotel Palace");
        HashMap<Integer, Albergo> alberghi2 = new HashMap<Integer, Albergo>();
        alberghi2.put(a1.getId(), a1);
        alberghi2.put(a2.getId(), a2);
        alberghi2.put(a3.getId(), a3);
        XMLWriter.writeAlberghiToXML(alberghi2, "FileDiProva.xml");
    }
}
