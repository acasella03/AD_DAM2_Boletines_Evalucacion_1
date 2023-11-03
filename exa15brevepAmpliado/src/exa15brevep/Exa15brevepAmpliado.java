package exa15brevep;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Exa15brevepAmpliado {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = conexion();

             // Consulta para obtener los datos de composicion para p1 y p2
           String sql = "SELECT c.codc, c.nomec, c.graxa, co.peso, co.codp " +
                         "FROM composicion co " +
                         "INNER JOIN componentes c ON co.codc = c.codc " +
                         "WHERE co.codp IN ('p1','p2')";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            Map<String, Integer> grasaPorPlato = new HashMap<>();

            // Calcular la grasa parcial por componente y plato
            while (resultSet.next()) {
                String codc = resultSet.getString("codc");
                int graxa = resultSet.getInt("graxa");
                int peso = resultSet.getInt("peso");
                String codp = resultSet.getString("codp");
                int grasaParcial = (peso * graxa) / 100;

                // Agregar la grasa parcial al plato correspondiente
                grasaPorPlato.putIfAbsent(codp, 0);
                grasaPorPlato.put(codp, grasaPorPlato.get(codp) + grasaParcial);
            }

            // Paso 2: Leer el archivo serializado
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("platoss"))) {
                Platos plato;
                //Crear un archivo XML para escribir los datos
                XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
                XMLStreamWriter writer= xmlOutputFactory.createXMLStreamWriter(new FileWriter("totalgraxas.xml"));
                
                writer.writeStartDocument();
                writer.writeStartElement("Platos");
                
                while ((plato = (Platos) ois.readObject()) != null) {
                    String codp = plato.getCodigop();
                    // Paso 4: Imprimir el código, nombre del plato y grasa total
                    if (grasaPorPlato.containsKey(codp)) {
                        writer.writeStartElement("Plato");
                        writer.writeAttribute("Codigop", codp);
                        
                        writer.writeStartElement("nomep");
                        writer.writeCharacters(plato.getNomep());
                        writer.writeEndElement();
                        
                        writer.writeStartElement("graxatotal");
                        writer.writeCharacters(Integer.toString(grasaPorPlato.get(codp)));
                        writer.writeEndElement();
                        
                        writer.writeEndElement();
                    }
                }
                writer.writeEndElement();
                writer.writeEndDocument();
                writer.close();
            } catch (EOFException e) {
                // Fin del archivo
            }

        } catch (SQLException | IOException | ClassNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

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

    public static void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
