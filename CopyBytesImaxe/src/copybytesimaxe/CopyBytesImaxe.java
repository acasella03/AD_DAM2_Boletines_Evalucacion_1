package copybytesimaxe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesImaxe {

    public static void main(String[] args) {
        // Nombre de los archivos de entrada y salida
        String inputFile = "foto.jpg";
        String outputFile = "foto2.jpg";

        // Declaramos las variables FileInputStream y FileOutputStream
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            // Inicializamos las variables FileInputStream y FileOutputStream
            inputStream = new FileInputStream(inputFile);
            //outputStream = new FileOutputStream(outputFile);
            //Abre el archivo de salida en modo anexar (append)
            outputStream = new FileOutputStream(outputFile, true);

            int byteRead;
            // Leer byte a byte del archivo de entrada
            while ((byteRead = inputStream.read()) != -1) {
                // Escribir el byte leído en el archivo de salida
                outputStream.write(byteRead);
            }

            System.out.println("El archivo " + inputFile + " ha sido copiado en " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerramos los streams al finalizar
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
