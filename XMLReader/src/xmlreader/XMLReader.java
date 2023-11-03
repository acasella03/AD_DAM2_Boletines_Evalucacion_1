package xmlreader;

import java.io.FileInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import serializacion2.Product;

public class XMLReader {

    public static void main(String[] args) {
        // Ruta al archivo XML
        String nombreArchivoEntrada = "products.xml";

        // ArrayList para almacenar los objetos Product
        ArrayList<Product> productos = new ArrayList<>();
        Product producto = null; // Objeto Product actual

        try {
            // Crear un flujo de entrada desde el archivo XML
            FileInputStream fileInputStream = new FileInputStream(nombreArchivoEntrada);

            // Crear una instancia de XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            // Crear un XMLStreamReader para procesar el archivo XML
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            // Iterar a través del documento XML
            while (reader.hasNext()) {
                int eventType = reader.next(); // Obtener el tipo de evento actual

                if (eventType == XMLStreamConstants.START_ELEMENT) {
                    String localName = reader.getLocalName(); // Obtener el nombre local del elemento

                    if ("product".equals(localName)) {
                        producto = new Product(); // Crear un nuevo objeto Product
                    } else if ("codigo".equals(localName)) {
                        producto.setCodigo(reader.getElementText()); // Establecer el código del producto
                    } else if ("descripcion".equals(localName)) {
                        producto.setDescripcion(reader.getElementText()); // Establecer la descripción del producto
                    } else if ("precio".equals(localName)) {
                        String precioText = reader.getElementText(); // Obtener el texto del precio
                        // Verificar si el texto no está vacío ni nulo
                        if (precioText != null && !precioText.trim().isEmpty()) {
                            try {
                                producto.setPrecio(Double.parseDouble(precioText)); // Convertir el texto en un valor double
                            } catch (NumberFormatException e) {
                                System.err.println("Error al convertir precio: " + precioText);
                            }
                        }
                    }
                } else if (eventType == XMLStreamConstants.END_ELEMENT) {
                    if ("product".equals(reader.getLocalName())) {
                        productos.add(producto); // Agregar el objeto Product al ArrayList
                    }
                }
            }

            reader.close();

            // Imprimir los objetos Product almacenados en el ArrayList
            for (Product p : productos) {
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Descripción: " + p.getDescripcion());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
