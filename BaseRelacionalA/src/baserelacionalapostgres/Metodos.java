package baserelacionalapostgres;

import java.sql.*;
import java.sql.Date;

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

    public void insireProduto(String codigo, String descricion, int prezo, Date dataC) {
        Connection conn = null;
        try {
            conn = conexion();
            // Verificar si ya existe un producto con el mismo código
            String sqlVerificar = "SELECT 1 FROM produtos WHERE codigo = ? LIMIT 1";
            try (PreparedStatement pstmtVerificar = conn.prepareStatement(sqlVerificar)) {
                pstmtVerificar.setString(1, codigo);
                try (ResultSet rs = pstmtVerificar.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("El producto con código " + codigo + " ya existe. No se realizará la inserción.");
                        return;  // Salir del método si el producto ya existe
                    }
                }
            }
            
            // Si no existe, realizar la inserción
            String sql = "INSERT INTO produtos (codigo, descricion, prezo, datac) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, codigo);
                pstmt.setString(2, descricion);
                pstmt.setInt(3, prezo);
                pstmt.setDate(4, dataC);
                pstmt.executeUpdate();
                System.out.println("Producto insertado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            cerrarConexion(conn);
        }
    }

    public void listaProdutos() {
        Connection conn = null;
        try {
            conn = conexion();
            String sql = "SELECT * FROM produtos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String codigo = rs.getString("codigo");
                    String descricion = rs.getString("descricion");
                    int prezo = rs.getInt("prezo");
                    Date dataC = rs.getDate("datac");
                    System.out.println("Código: " + codigo + ", Descricion: " + descricion + ", Prezo: " + prezo + ", Data de Caducidade: " + dataC);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion(conn);
        }
    }
    
    public void buscarProduto(String codigoBuscado) {
    Connection conn = null;
    try {
        conn = conexion();
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigoBuscado);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String codigo = rs.getString("codigo");
                    String descricion = rs.getString("descricion");
                    int prezo = rs.getInt("prezo");
                    Date dataC = rs.getDate("datac");
                    System.out.println("Código: " + codigo + ", Descricion: " + descricion + ", Prezo: " + prezo + ", Data de Caducidade: " + dataC);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cerrarConexion(conn);
    }
}

    public void actualizaPre(String codigo, int novoPrezo) {
        Connection conn = null;
        try {
            conn = conexion();
            String sql = "UPDATE produtos SET prezo = ? WHERE codigo = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, novoPrezo);
                pstmt.setString(2, codigo);
                pstmt.executeUpdate();
                System.out.println("El precio del producto "+codigo+" ha cambiado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion(conn);
        }
    }

    public void eliminaProduto(String codigo) {
        Connection conn = null;
        try {
            conn = conexion();
            String sql = "DELETE FROM produtos WHERE codigo = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, codigo);
                pstmt.executeUpdate();
                System.out.println("El producto "+codigo+" se ha eliminado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion(conn);
        }
    }
}
