package pinmobiliaria;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pinmobiliaria {
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
        String nombreArchivoSerializado = "listap";
        String nombreArchivoDelimitado = "listap.txt";
        
        Connection conn = conexion();
        
        String nifP = null;
        String nomP;
        int m2 = 0;
        String codz = null;
        int prezom2 = 0;
        
        // Objeto para escribir el delimitado
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivoDelimitado)));
        
        
        // Leer objetos desde el archivo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoSerializado));
        // Objeto para almacenar el objeto leído
        Listap objetoLeido;
        // Bucle mientras se pueda leer un objeto no nulo
        while ((objetoLeido = (Listap) ois.readObject()) != null) {
            Listap lista = objetoLeido;
            // Imprimir los valores individualmente
            nifP=lista.getNifp();
            nomP=lista.getNomp();
            System.out.print("nif: "+nifP);
            System.out.print(", nome do propietarios: "+nomP+"\n");
            System.out.println("pisos:");
            
            int contador=0;
            int valorTotal=0;
            String codp=null;
            PreparedStatement obtenerCantidadPisosPst = conn.prepareStatement("SELECT * from pisos where nif=?");
            obtenerCantidadPisosPst.setString(1, nifP);
            ResultSet rs1=obtenerCantidadPisosPst.executeQuery();
            while(rs1.next()){
                codp=rs1.getString("codp");
                m2=rs1.getInt("m2");
                codz=rs1.getString("codz");
                contador++; 
                
                PreparedStatement obtenerPrecioM2pst = conn.prepareStatement("SELECT * from zonas where codz=?");
                obtenerPrecioM2pst.setString(1, codz);
                ResultSet rs2=obtenerPrecioM2pst.executeQuery();
                rs2.next();
                prezom2=rs2.getInt("prezom2");
                obtenerPrecioM2pst.close();
                rs2.close();
                
                int totalParcial= prezom2*m2;
                valorTotal+=totalParcial;
                
                System.out.println("metros: "+m2+" codz: "+codz+" prezo m2: "+m2+" total parcial: "+totalParcial);
                
            }
            obtenerCantidadPisosPst.close();
            rs1.close();
           
            
            System.out.println("nif: "+nifP+", numero de pisos: "+contador+", totalfinal: "+valorTotal);
            System.out.println("----------------------");
            
            printWriter.println(nifP+">"+contador+">"+valorTotal);
        
        }
        
        printWriter.close();
        
        System.out.println("Fin del archivo.");
        ois.close();
        
        
        
        
        
        
    }
    
}
