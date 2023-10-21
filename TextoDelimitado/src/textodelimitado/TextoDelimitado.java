package textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextoDelimitado {

    public static void main(String[] args) {
        // Arrays de datos
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        // Grabar en un archivo
        String nombreArchivo = "productos.txt";

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo)))) {
            // Grabar registros en el archivo delimitados por tabuladores
            for (int i = 0; i < cod.length; i++) {
                printWriter.println(cod[i] + "\t" + desc[i] + "\t" + prezo[i]);
            }

            System.out.println("Datos grabados en " + nombreArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer del archivo y formatear la salida
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                // Separar los campos usando el método split()
                String[] campos = linea.split("\t");

                // Formatear la salida
                System.out.println("Codigo:        " + campos[0]);
                System.out.println("Descricion: " + campos[1]);
                System.out.println("Prezo:       " + campos[2] + " €\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
