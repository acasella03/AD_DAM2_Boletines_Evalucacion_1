package primitivewritechars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveWriteChars {

    public static void main(String[] args) {
        String cadenaAGrabar = "o tempo está xélido";
        String nombreArchivo = "text5.dat";

        // Escribir en el archivo
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            for (int i = 0; i < 2; i++) {
                // Escribir la cadena en el archivo
                dataOutputStream.writeChars(cadenaAGrabar);
                
                // Mostrar la longitud de la cadena en caracteres
                int longitudCadena = cadenaAGrabar.length();
                System.out.println("Escribiendo: " + cadenaAGrabar);
                System.out.println("La longitud de esta cadena en caracteres es: " + longitudCadena + " caracteres");
                
                // Mostrar la cantidad de bytes escritos
                long bytesEscritos = dataOutputStream.size();
                System.out.println("Se han escrito " + bytesEscritos + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer desde el archivo
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(nombreArchivo))) {
            for (int i = 0; i < 2; i++) {
                System.out.println("\nLeyendo la cadena #" + (i + 1) + ":");
                int longitudCadena = cadenaAGrabar.length();
                StringBuilder cadenaLeida = new StringBuilder();
                
                // Leer un caracter de cada vez (2 bytes)
                for (int j = 0; j < longitudCadena; j++) {
                    char caracter = dataInputStream.readChar();
                    cadenaLeida.append(caracter);
                }
                
                System.out.println(cadenaLeida.toString());
                
                // Mostrar la cantidad de bytes restantes por leer
                long bytesRestantes = dataInputStream.available();
                System.out.println("Quedan por leer: " + bytesRestantes + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
