package xmlwriter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import serializacion2.Product;

public class XMLwriter {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "productos.txt";
        String nombreArchivoSalida = "products.xml";

        ArrayList<Product> productos = new ArrayList<>();

        // Leer objetos desde el archivo de texto y crear una lista de Product
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoEntrada))) {
            Object objetoLeido;
            while ((objetoLeido = ois.readObject()) != null) {
                if (objetoLeido instanceof Product) {
                    productos.add((Product) objetoLeido);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Escribir los productos en formato XML en el archivo products.xml
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(new FileWriter(nombreArchivoSalida));

            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("products");

            for (Product producto : productos) {
                writer.writeCharacters("\n    ");
                writer.writeStartElement("product");

                writer.writeCharacters("\n        ");
                writer.writeStartElement("codigo");
                writer.writeCharacters(producto.getCodigo());
                writer.writeEndElement();

                writer.writeCharacters("\n        ");
                writer.writeStartElement("descripcion");
                writer.writeCharacters(producto.getDescripcion());
                writer.writeEndElement();

                writer.writeCharacters("\n        ");
                writer.writeStartElement("precio");
                writer.writeCharacters(String.valueOf(producto.getPrecio()));
                writer.writeEndElement();

                writer.writeCharacters("\n    ");
                writer.writeEndElement();
            }

            writer.writeCharacters("\n");
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.close();

            System.out.println("Productos convertidos y escritos en " + nombreArchivoSalida);
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

        }}



