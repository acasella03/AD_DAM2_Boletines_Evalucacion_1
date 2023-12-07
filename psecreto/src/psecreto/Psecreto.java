package psecreto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Psecreto {

    private static Connection conexion() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        return DriverManager.getConnection(url, usuario, password);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        String nombreArchivoSerializado = "clave1";
        String nombreArchivoDelimitado = "clavesuma";

        Connection conn = conexion();

        //Obtener las letras de la tabla Refrencia
        String c1;
        String c2;
        PreparedStatement obtenerLetrasReferencia = conn.prepareStatement("SELECT * from referencia");
        ResultSet rs = obtenerLetrasReferencia.executeQuery();
        while (rs.next()) {
            c1 = rs.getString("c1");
            c2 = rs.getString("c2");
            //Leer archivo Serializado
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoSerializado));
            //Objeto para almacenar el objeto leído
            Clave1 clave1;
            // Bucle mientras se pueda leer un objeto no nulo
            int numeroClave1 = 0;
            while ((clave1 = (Clave1) ois.readObject()) != null) {
                // Comparar c1 con el clave1 y guardarlo en una variable
                if (c1.equals(clave1.getCla1())) {
                    numeroClave1 = clave1.getNum1();
                    //System.out.println(numeroClave1);
                }
            }
            ois.close();
            PreparedStatement obtenerNumeroClave2 = conn.prepareStatement("SELECT num2 from clave2 WHERE cla2=?");
            obtenerNumeroClave2.setString(1, c2);
            ResultSet rs1 = obtenerNumeroClave2.executeQuery();
            rs1.next();
            int numeroClave2 = rs1.getInt("num2");
            //System.out.println(numeroClave2);

            int sumaClaves = numeroClave1 + numeroClave2;
            //System.out.println(sumaClaves);

            //Leer archivo Delimitado
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivoDelimitado));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar los campos usando el método split()
                String[] campos = linea.split("_");
                //Asignar variables a los campos
                int numero = Integer.parseInt(campos[0]);
                String letra = campos[1];
            
                if(sumaClaves==numero){
                    System.out.print(letra);
                }
            }

        }
        conn.close();
    }
}
