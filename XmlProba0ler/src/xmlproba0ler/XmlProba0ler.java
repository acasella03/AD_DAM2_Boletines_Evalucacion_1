package xmlproba0ler;

import java.io.FileInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlProba0ler {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("autores.xml");
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            // Iterar a través del documento XML
            while (reader.hasNext()) {
                // Obtener el tipo de evento actual (inicio de elemento, atributo, texto, etc.)
                int eventType = reader.next();

                if (eventType == XMLStreamConstants.START_ELEMENT) {
                    // Si es un elemento de inicio, obtén su nombre local
                    String localName = reader.getLocalName();

                    if ("autor".equals(localName)) {
                        // Si es un elemento "autor", obtén su atributo "codigo"
                        String codigo = reader.getAttributeValue(0);
                        System.out.println("Código del autor: " + codigo);
                    } else if ("nome".equals(localName)) {
                        // Si es un elemento "nome", obtén el contenido de texto
                        String nome = reader.getElementText();
                        System.out.println("Nombre del autor: " + nome);
                    } else if ("titulo".equals(localName)) {
                        // Si es un elemento "titulo", obtén el contenido de texto
                        String titulo = reader.getElementText();
                        System.out.println("Título: " + titulo);
                    }
                }

            }

            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
