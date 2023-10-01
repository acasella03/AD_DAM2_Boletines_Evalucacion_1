package copybytesimaxe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesImaxe {

    public static void main(String[] args) {
        // Nombre de los archivos de entrada y salida
        String inputFile = "foto.jpg";
        String outputFile = "foto2.jpg";

        // Declaramos las variables FileInputStream, FileOutputStream, BufferedInputStream y BufferedOutputStream
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            // Inicializamos las variables FileInputStream y FileOutputStream
            inputStream = new FileInputStream(inputFile);
            //outputStream = new FileOutputStream(outputFile);
            // Abre el archivo de salida en modo anexar (append)
            outputStream = new FileOutputStream(outputFile, true);

            // Inicializamos los búferes
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int bytesRead;
            byte[] buffer = new byte[1024]; // Tamaño del búfer

            // Leer y escribir utilizando búferes
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("El archivo " + inputFile + " ha sido agregado a " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerramos los streams y búferes al finalizar
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
