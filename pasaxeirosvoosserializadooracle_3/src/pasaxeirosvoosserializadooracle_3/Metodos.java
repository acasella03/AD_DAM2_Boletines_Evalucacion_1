package pasaxeirosvoosserializadooracle_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;

public class Metodos {

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

    private void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Leer objetos desde el archivo
    public void lerReservas() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        Connection conn = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reservas"))) {
            conn = conexion();
            // Objeto para almacenar el objeto leído
            Reserva reserva;
            // Bucle mientras se pueda leer un objeto no nulo
            while ((reserva = (Reserva) ois.readObject()) != null) {

                // Imprimir los valores individualmente
                System.out.println("Código: " + reserva.getCodr());
                System.out.println("DNI: " + reserva.getDni());
                System.out.println("ID Ida: " + reserva.getIdvooida());
                System.out.println("ID Vuelta: " + reserva.getIdvoovolta() + "\n");

                //Actualiza el campo nreservas en la tabla de pasajeros
                PreparedStatement ps = conn.prepareStatement("UPDATE pasaxeiros set nreservas = nreservas + 1 WHERE dni=?");
                ps.setString(1, reserva.getDni());
                ps.executeUpdate();

                //Obtener el campo nome desde la tabla pasaxeiros
                String nome = null;
                PreparedStatement obtenerNombre = conn.prepareStatement("SELECT nome FROM pasaxeiros WHERE dni=?");
                obtenerNombre.setString(1, reserva.getDni());
                ResultSet rs = obtenerNombre.executeQuery();
                while (rs.next()) {
                    nome = rs.getString("nome");
                }

                //Calcula el campo prezoreserva sumando los precios de los vuelo de ida y vuelta de la tabla voos
                int precioIda = 0;
                int precioVuelta = 0;
                PreparedStatement obtenerPrecioIda = conn.prepareStatement("SELECT prezo FROM voos WHERE voo=?");
                obtenerPrecioIda.setInt(1, reserva.getIdvooida());
                ResultSet resultadoPrecioIda = obtenerPrecioIda.executeQuery();
                while (resultadoPrecioIda.next()) {
                    precioIda = resultadoPrecioIda.getInt("prezo");
                }
                PreparedStatement obtenerPrecioVuelta = conn.prepareStatement("SELECT prezo FROM voos WHERE voo=?");
                obtenerPrecioVuelta.setInt(1, reserva.getIdvoovolta());
                ResultSet resultadoPrecioVuelta = obtenerPrecioVuelta.executeQuery();
                while (resultadoPrecioVuelta.next()) {
                    precioVuelta = resultadoPrecioVuelta.getInt("prezo");
                }

                int prezoreserva = precioIda + precioVuelta;

                //Inserta los datos en la tabla RESERVASFEITAS
                PreparedStatement ps1 = conn.prepareStatement("INSERT into reservasfeitas (codr,dni,nome,prezoreserva) VALUES (?,?,?,?)");
                ps1.setInt(1, reserva.getCodr());
                ps1.setString(2, reserva.getDni());
                ps1.setString(3, nome);
                ps1.setInt(4, prezoreserva);
                ps1.executeUpdate();

            }
        }
        System.out.println("Fin del archivo.");
        conn.close();
    }
}
