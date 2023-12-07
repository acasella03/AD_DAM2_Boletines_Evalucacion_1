package pfungos;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pfungos {
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

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        String nombreArchivoSerializado = "detectados";
        String nombreArchivoDelimitado = "final.txt";

        Connection conn = conexion();
        
        // Objeto para escribir el delimitado
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivoDelimitado)));
        
        // Leer objetos desde el archivo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivoSerializado));
        // Objeto para almacenar el objeto leído
        Detectados objetoLeido;
        // Bucle mientras se pueda leer un objeto no nulo
        while ((objetoLeido = (Detectados) ois.readObject()) != null) {
            Detectados fungo = objetoLeido;
            int numero=fungo.getNumero();
            int codArea=fungo.getCodarea();
            int codFungo=fungo.getCodfungo();
            Double superficieAfectada=fungo.getSuperficie();
            // Imprimir los valores individualmente
            System.out.print("numero: "+numero);
            System.out.print(", codarea: "+codArea);
            System.out.print(", codfungo: "+codFungo);
            System.out.print(", superficieafectada: "+superficieAfectada + "\n");
            
            
            PreparedStatement obtenerCodApst = conn.prepareStatement("UPDATE areas SET numerofungos=numerofungos+1 where coda=?");
            obtenerCodApst.setInt(1, codArea);
            obtenerCodApst.executeUpdate();
            obtenerCodApst.close();
            
            PreparedStatement obtenerHumMediaPst = conn.prepareStatement("SELECT * from areas where coda=?");
            obtenerHumMediaPst.setInt(1, codArea);
            ResultSet rs1=obtenerHumMediaPst.executeQuery();
            int humedadMedia = 0;
            String nomea = null;
            int superficie = 0;
            rs1.next();
                humedadMedia=rs1.getInt("hummedia");
                nomea=rs1.getString("noma");
                superficie=rs1.getInt("superficie");
            obtenerHumMediaPst.close();
            rs1.close();
            
            PreparedStatement obtenerHumLimitePst = conn.prepareStatement("SELECT * from fungos where id=?");
            obtenerHumLimitePst.setInt(1, codFungo);
            ResultSet rs2=obtenerHumLimitePst.executeQuery();
            int humedadLimite = 0;
            String nomef = null;
            rs2.next();
                humedadLimite=rs2.getInt("humlimite");
                nomef=rs2.getString("nomf");
            obtenerHumLimitePst.close();
            rs2.close();
            
            
            
            if(humedadMedia>humedadLimite){
                Double porcentajeDano=superficieAfectada*100/superficie;
                printWriter.println(codArea + "\t" + nomea + "\t" + nomef+"\t"+superficieAfectada+"\t"+porcentajeDano);
                        }
            
        }
        System.out.println("Fin del archivo " + nombreArchivoSerializado);
        System.out.println("Datos grabados en " + nombreArchivoDelimitado);
        ois.close();
        printWriter.close();
        
        conn.close();
        }
    
        
    
}

