package copycaracteres2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyCaracteres2 {

    public static void main(String[] args) {
        String archivoEntrada = "texto1.txt";
        String archivoSalida = "texto2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoEntrada));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(archivoSalida)))) {

            String linea;

            // Leer línea por línea y escribir en el archivo de salida
            while ((linea = bufferedReader.readLine()) != null) {
                printWriter.println(linea);
            }

            System.out.println("Contenido copiado de " + archivoEntrada + " a " + archivoSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
