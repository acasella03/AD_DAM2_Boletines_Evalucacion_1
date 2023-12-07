package pcidades2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Pcidades2 {

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

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        String nombreArchivoDelimitado = "zonas.txt";
        String nombreArchivoSerializado = "listaz2";

        Connection conn = conexion();
        String codZona;
        String nombreZona;
        int m2;
        int anioActual = 2023;
        int anio;
        int precioPisoM2;
        int precioPiso = 0;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivoSerializado));

        //Lectura de texto delimitado
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivoDelimitado));
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            Listaz2 lista = new Listaz2();
            // Separar los campos usando el método split()
            String[] campos = linea.split("_");

            // Asignar variables a los campos leídos
            codZona = campos[0];
            nombreZona = campos[1];
            precioPisoM2 = parseInt(campos[2]);

            System.out.println("codz: " + codZona + ", nomz: " + nombreZona + ", prezom2: " + precioPisoM2);

            lista.setCodz("codz= " + codZona);

            //Obtener metros cuadrados de la tabla pisos
            int contador = 0;
            int precioTotal = 0;
            String codp = null;
            PreparedStatement obtenerM2 = conn.prepareStatement("SELECT codp,m2,ano from pisos where codp in (SELECT codp from propiedades where codz=?)");
            obtenerM2.setString(1, codZona);
            ResultSet rs1 = obtenerM2.executeQuery();
            while (rs1.next()) {
                codp = rs1.getString("codp");
                m2 = rs1.getInt("m2");
                anio = rs1.getInt("ano");

                System.out.println("código de piso: " + codp);
                System.out.print("m2: " + m2);
                if (anioActual - anio > 30) {
                    precioPiso = (m2 * precioPisoM2) - 20000;
                    System.out.print(", prezo piso: " + precioPiso + " €\n");
                } else if (anioActual - anio > 20 && anioActual - anio <= 30) {
                    precioPiso = (m2 * precioPisoM2) - 10000;
                    System.out.print(", prezo piso: " + precioPiso + " €\n");
                } else if (anioActual - anio > 10 && anioActual - anio <= 20) {
                    precioPiso = (m2 * precioPisoM2) - 5000;
                    System.out.print(", prezo piso: " + precioPiso + " €\n");
                } else if (anioActual - anio <= 10) {
                    precioPiso = m2 * precioPisoM2;
                    System.out.print(", prezo piso: " + precioPiso + " €\n");
                }

                precioTotal = precioTotal + precioPiso;

                contador++;

            }
            System.out.println("número de pisos na zona " + nombreZona + ": " + contador + ", total: " + precioTotal + "\n");

            lista.setNomz(", nomz= " + nombreZona + ", total= ");
            lista.setTotal(precioTotal);
            oos.writeObject(lista);

        }
        //Guardo objeto nulo en la escritura para que en la lectura lo lea bien sin ninguna excepción
        Listaz2 objNulo = null;
        oos.writeObject(objNulo);
        oos.close();
        conn.close();

        // Leer objetos desde el archivo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoSerializado));
        // Objeto para almacenar el objeto leído
        Listaz2 objetoLeido;
        // Bucle mientras se pueda leer un objeto no nulo
        while ((objetoLeido = (Listaz2) ois.readObject()) != null) {
            Listaz2 ciudad = objetoLeido;
            // Imprimir los valores individualmente
            System.out.print(ciudad.getCodz());
            System.out.print(ciudad.getNomz());
            System.out.print(ciudad.getTotal() + "\n");
        }
        System.out.println("Fin del archivo.");
        ois.close();

    }

}
