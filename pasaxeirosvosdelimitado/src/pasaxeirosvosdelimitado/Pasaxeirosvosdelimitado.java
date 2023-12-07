package pasaxeirosvosdelimitado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pasaxeirosvosdelimitado {

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

    private void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        String nombreArchivo = "reservas.txt";

        Connection conn = conexion();

        //Leer del archivo y formatear la salida
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            // Separar los campos usando el método split()
            String[] campos = linea.split(",");
            //Asignar variables a los campos
            int codr = Integer.parseInt(campos[0]);
            String dni = campos[1];
            int idVooIda = Integer.parseInt(campos[2]);
            int idVooVolta = Integer.parseInt(campos[3]);

            //Actualiza el campo nreservas en la tabla de pasajeros
            PreparedStatement ps = conn.prepareStatement("UPDATE pasaxeiros set nreservas = nreservas + 1 WHERE dni=?");
            ps.setString(1, dni);
            ps.executeUpdate();

            //Obtener el campo nome desde la tabla pasaxeiros
            String nome = null;
            PreparedStatement obtenerNombre = conn.prepareStatement("SELECT nome FROM pasaxeiros WHERE dni=?");
            obtenerNombre.setString(1, dni);
            ResultSet rs = obtenerNombre.executeQuery();
            while (rs.next()) {
                nome = rs.getString("nome");
            }

            //Calcula el campo prezoreserva sumando los precios de los vuelo de ida y vuelta de la tabla voos
            int precioIda = 0;
            int precioVuelta = 0;
            PreparedStatement obtenerPrecioIda = conn.prepareStatement("SELECT prezo FROM voos WHERE voo=?");
            obtenerPrecioIda.setInt(1, idVooIda);
            ResultSet resultadoPrecioIda = obtenerPrecioIda.executeQuery();
            while (resultadoPrecioIda.next()) {
                precioIda = resultadoPrecioIda.getInt("prezo");
            }
            PreparedStatement obtenerPrecioVuelta = conn.prepareStatement("SELECT prezo FROM voos WHERE voo=?");
            obtenerPrecioVuelta.setInt(1, idVooVolta);
            ResultSet resultadoPrecioVuelta = obtenerPrecioVuelta.executeQuery();
            while (resultadoPrecioVuelta.next()) {
                precioVuelta = resultadoPrecioVuelta.getInt("prezo");
            }

            int prezoreserva = precioIda + precioVuelta;

            //Inserta los datos en la tabla RESERVASFEITAS
            PreparedStatement ps1 = conn.prepareStatement("INSERT into reservasfeitas (codr,dni,nome,prezoreserva) VALUES (?,?,?,?)");
            ps1.setInt(1, codr);
            ps1.setString(2, dni);
            ps1.setString(3, nome);
            ps1.setInt(4, prezoreserva);
            ps1.executeUpdate();

        }
        conn.close();
    }
}
