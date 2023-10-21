package baserelacionalb;

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
    ResultSet rs = null;
    try {
            conn = conexion();
            String sql = "SELECT produtos.* FROM produtos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                rs = pstmt.executeQuery();
                rs.moveToInsertRow();
                rs.updateString("codigo", codigo);
                rs.updateString("descricion", descricion);
                rs.updateInt("prezo", prezo);
                rs.updateDate("datac", dataC);
                rs.insertRow();
                rs.moveToCurrentRow();
                System.out.println("Producto insertado correctamente.");
            }
    } catch (SQLException e) {
        if (e.getSQLState().equals("23505")) {
            // Capturar el error específico de violación de restricción única
            System.out.println("Error: Ya existe un producto con el código " + codigo + ".");
        } else {
            e.printStackTrace();
        }
    } finally {
        cerrarConexion(conn);
    }
}

    public void listaProdutos() {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = conexion();
            String sql = "SELECT produtos.* FROM produtos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                rs = pstmt.executeQuery();
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

    public void actualizaPre(String codigo, int novoPrezo) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = conexion();
            String sql = "SELECT produtos.* FROM produtos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    if (codigo.equals(rs.getString("codigo"))) {
                        rs.updateInt("prezo", novoPrezo);
                        rs.updateRow();
                        System.out.println("El precio del producto " + codigo + " ha cambiado.");
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion(conn);
        }
    }

    public void eliminaProduto(String codigo) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = conexion();
            String sql = "SELECT produtos.* FROM produtos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    if (codigo.equals(rs.getString("codigo"))) {
                        rs.deleteRow();
                        System.out.println("El producto " + codigo + " se ha eliminado.");
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cerrarConexion(conn);
        }
    }
}
