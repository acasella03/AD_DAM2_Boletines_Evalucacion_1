package exa17p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Exa17p {

    public static Connection conexion() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        return DriverManager.getConnection(url, usuario, password);
    }

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, SQLException {
        // Conexion BD
        Connection conn = conexion();
        
        // Ruta al archivo XML
        String nombreArchivoEntrada = "pedidos.xml";

        // ArrayList para almacenar los objetos Pedido
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;

        // Crear un flujo de entrada desde el archivo XML
        FileInputStream fileInputStream = new FileInputStream(nombreArchivoEntrada);

        // Crear una instancia de XMLInputFactory
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        // Crear un XMLStreamReader para procesar el archivo XML
        XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

        // Iterar a través del documento XML
        while (reader.hasNext()) {
            int tipoEvento = reader.next(); //Obtener el tipo de evento actual

            if (tipoEvento == XMLStreamConstants.START_ELEMENT) {
                String nombrelocal = reader.getLocalName(); //Obtener el nombre local del elemento

                if (null != nombrelocal) switch (nombrelocal) {
                    case "Pedido":
                        pedido = new Pedido(); // Crear un nuevo objeto Pedido
                        
                        // Obtener los atributos del elemento "Pedido"
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            String nombreAtributo=reader.getAttributeLocalName(i);
                            String valorAtributo=reader.getAttributeValue(i);
                            
                            // Establecer los valores de los atributos "Codcli" y "Codpro"
                            if("Codcli".equals(nombreAtributo)){
                                pedido.setCodcli(valorAtributo);
                            }else if("Codpro".equals(nombreAtributo)){
                                pedido.setCodpro(valorAtributo);
                            }
                        }
                        break;
                    case "Cantidade":
                        pedido.setCantidade(Integer.parseInt(reader.getElementText())); // Establecer la cantidad del pedido
                        break;
                    case "Data":
                        pedido.setData(reader.getElementText());
                        break;
                    default:
                        break;
                }
            } else if (tipoEvento == XMLStreamConstants.END_ELEMENT) {
                if ("Pedido".equals(reader.getLocalName())) {
                    pedidos.add(pedido);// Agregar el objeto Pedido al ArrayList
                }
            }
        }
        reader.close();

        // Imprimir los objetos Pedido almacenados en el ArrayList
        for (Pedido p : pedidos) {
            //Imprimir los valores de cada pedido
            System.out.println("Código Cliente: " +p.getCodcli());
            System.out.println("Código Producto: " + p.getCodpro());
            System.out.println("Cantidad: " + p.getCantidade());
            System.out.println("Fecha: " + p.getData());
            System.out.println("---------------------");
            
            //Consultar el precio en la tabla produtos
            PreparedStatement obtenerPrecioProductos = conn.prepareStatement("SELECT * FROM produtos WHERE codigop=?");
            obtenerPrecioProductos.setString(1, p.getCodpro());
            ResultSet rs1=obtenerPrecioProductos.executeQuery(); //Objeto que almacenará los resultados de la consulta. Puedes usar rs1 para iterar sobre los resultados y recuperar los valores de las columnas.
            int precio;
            rs1.next();
                precio=rs1.getInt("prezo");
            obtenerPrecioProductos.close();
            rs1.close();
           
            //Insertar registros en la tabla vendas
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vendas (codigoc,codigop,data,total) VALUES (?,?,?,?)");
            pstmt.setString(1,p.getCodcli());
            pstmt.setString(2, p.getCodpro());
            pstmt.setString(3, p.getData());
            pstmt.setInt(4, precio*p.getCantidade());
            pstmt.executeUpdate();
            pstmt.close();
            
            //Actualizar Stock de la tabla produtos
            PreparedStatement actualizarStock=conn.prepareStatement("UPDATE produtos SET stock=stock-? WHERE codigop=?");
            actualizarStock.setInt(1, p.getCantidade());
            actualizarStock.setString(2, p.getCodpro());
            actualizarStock.executeUpdate();
            actualizarStock.close();
            
            //Actualizar Gasto de la tabla clientes
            PreparedStatement actualizarGasto=conn.prepareStatement("UPDATE clientes SET gasto=gasto+? WHERE codigoc=?");
            actualizarGasto.setInt(1, precio*p.getCantidade());
            actualizarGasto.setString(2, p.getCodcli());
            actualizarGasto.executeUpdate();
            actualizarGasto.close();
        }
    }

}
