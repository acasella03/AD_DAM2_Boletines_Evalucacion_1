package exa15brevep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exa15brevep {

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
    
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
        String nombreArchivoSerializado = "platoss";
        
        Connection conn = conexion();
        
        // Leer objetos desde el archivo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoSerializado));
        // Objeto para almacenar el objeto leído
        Platos objetoLeido;
        // Bucle mientras se pueda leer un objeto no nulo
        while ((objetoLeido = (Platos) ois.readObject()) != null) {
            Platos plato=objetoLeido;
            // Imprimir los valores individualmente
            String codp=plato.getCodigop();
            String nombrePlato=plato.getNomep();
            System.out.println(codp+"\n"+nombrePlato);
            
            String codc;
            int peso = 0;
            int grasa = 0;
            int grasaParcial=0;
            int grasaTotal=0;
            //Consultar el peso del plato y codigo del componente
            PreparedStatement obtenerPesoPstmt = conn.prepareStatement("SELECT * FROM composicion where codp=?");
            obtenerPesoPstmt.setString(1, codp);
            ResultSet rs1=obtenerPesoPstmt.executeQuery();
            while(rs1.next()){
                codc=rs1.getString("codc");
                peso=rs1.getInt("peso");
                
                //Consultar grasa
                PreparedStatement obtenerGrasaPstmt = conn.prepareStatement("SELECT graxa FROM componentes where codc=?");
                obtenerGrasaPstmt.setString(1, codc);
                ResultSet rs2=obtenerGrasaPstmt.executeQuery();
                rs2.next();
                    grasa=rs2.getInt("graxa");
                obtenerGrasaPstmt.close();
                rs2.close();
                
                grasaParcial= peso/100*grasa;
                grasaTotal=grasaTotal+grasaParcial;
                
            }
            System.out.println("grasaTotal: "+grasaTotal+ "\n");
            obtenerPesoPstmt.close();
            rs1.close();
            
        }
        System.out.println("Fin del archivo.");
        ois.close();
        conn.close();
    }
}
