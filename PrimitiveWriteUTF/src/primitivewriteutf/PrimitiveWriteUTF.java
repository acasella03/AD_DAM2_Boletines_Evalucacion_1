package primitivewriteutf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveWriteUTF {

    public static void main(String[] args) {
        String cadenaAGrabar = "o tempo está xélido";
        String nombreArchivo = "texto3.txt";

        // Escribir en el archivo
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            long tamañoArchivo = 0;
            for (int i = 0; i < 3; i++) {
                // Escribir la cadena en UTF en el archivo
                dataOutputStream.writeUTF(cadenaAGrabar);
                System.out.println("Escribiendo la cadena: " + cadenaAGrabar);

                // Mostrar el tamaño del archivo después de cada escritura
                tamañoArchivo = dataOutputStream.size();
                System.out.println("Tamaño del archivo después de escribir la cadena" + (i + 1) + ": " + tamañoArchivo + " bytes");
            }
            System.out.println("Tamaño final del archivo: " + tamañoArchivo + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer desde el archivo
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(nombreArchivo))) {
            int contador = 0;
            while (dataInputStream.available() > 0) {
                // Calcular y mostrar los bytes restantes
                int bytesRestantes = dataInputStream.available();
                System.out.println("Quedan: " + bytesRestantes + " bytes por leer");
                // Leer y mostrar cada cadena desde el archivo
                String cadenaLeida = dataInputStream.readUTF();
                System.out.println("Lectura de la cadena" + (contador + 1) + " en el archivo: " + cadenaLeida);
                contador++;
            }
            System.out.println("Ya no queda nada por leer");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
