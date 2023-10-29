package xmlproba0;

import java.io.FileWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XmlProba0 {

    public static void main(String[] args) {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(new FileWriter("autores.xml"));

            // Inicio del documento XML
            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");  // Salto de línea

            // Elemento raíz
            writer.writeStartElement("autores");

            // Primer autor
            writer.writeCharacters("\n    ");  // Salto de línea e indentación
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");

            // Elementos dentro del primer autor
            writeElementWithText(writer, "nome", "Alexandre Dumas");
            writeElementWithText(writer, "titulo", "El conde de Montecristo");
            writeElementWithText(writer, "titulo", "Los miserables");

            // Cierre del primer autor
            writer.writeCharacters("\n    ");  // Salto de línea e indentación
            writer.writeEndElement();

            // Segundo autor
            writer.writeCharacters("\n    ");  // Salto de línea e indentación
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            // Elementos dentro del segundo autor
            writeElementWithText(writer, "nome", "Fiodor Dostoyevski");
            writeElementWithText(writer, "titulo", "El idiota");
            writeElementWithText(writer, "titulo", "Noches blancas");

            // Cierre del segundo autor
            writer.writeCharacters("\n    ");  // Salto de línea e indentación
            writer.writeEndElement();

            // Cierre del elemento raíz
            writer.writeCharacters("\n");  // Salto de línea
            writer.writeEndElement();

            // Fin del documento
            writer.writeEndDocument();

            // Cerrar el escritor
            writer.close();

            System.out.println("Documento XML 'autores.xml' creado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para escribir un elemento con contenido de texto
    private static void writeElementWithText(XMLStreamWriter writer, String elementName, String text)
            throws XMLStreamException {
        writer.writeCharacters("\n        ");  // Salto de línea e indentación
        writer.writeStartElement(elementName);
        writer.writeCharacters(text);
        writer.writeEndElement();
    }
}
