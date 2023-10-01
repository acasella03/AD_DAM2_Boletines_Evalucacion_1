package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveUTFChars {

    public static void main(String[] args) {
        String cadena = "Está en casa"; //cadena que quremos gravar
        String fichero = "text6.dat";//fichero en el que queremos gravarlo

        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))) {
            long tamañoArchivo = 0;

            // Escribir la cadena en UTF en el archivo
            dataOutputStream.writeUTF(cadena);
            System.out.println("Escibiendo en writeUTF:" + cadena);

            // Muestral tamaño del archivo después de cada escritura
            tamañoArchivo = dataOutputStream.size();
            System.out.println("Bytes totales escritos: " + tamañoArchivo + " bytes");

            // Escribe la cadena con Char en el archivo
            dataOutputStream.writeChars(cadena);
            System.out.println("Escibiendo en writeChars:" + cadena);

            // Muestral tamaño del archivo después de cada escritura
            tamañoArchivo = dataOutputStream.size();
            System.out.println("Se han escrito " + tamañoArchivo + " bytes");

            // Escribir la cadena en UTF en el archivo
            dataOutputStream.writeUTF(cadena);
            System.out.println("Escibiendo en writeUTF:" + cadena);

            // Muestral tamaño del archivo después de cada escritura
            tamañoArchivo = dataOutputStream.size();
            System.out.println("Bytes totales escritos: " + tamañoArchivo + " bytes");

            System.out.println("Tamaño final del archivo: " + tamañoArchivo + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lee el archivo con readUTF
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
            // Calcular y mostrar los bytes restantes
            int bytesRestantes = dataInputStream.available();
            System.out.println("Quedan: " + bytesRestantes + " bytes por leer");

            // Leer y mostrar cada cadena desde el archivo
            String cadenaLeida = dataInputStream.readUTF();
            System.out.println("Leemos la cadena en UTF: " + cadenaLeida);

            int bytesRestantes1 = dataInputStream.available();
            System.out.println("Quedan: " + bytesRestantes1 + " bytes por leer");

            int longitudCadena = cadena.length();
            String cadenaLeidaChar = "";//clase de Java para construir y manipular cadenas

            // Lee un caracter de cada vez (2 bytes)
            for (int j = 0; j < longitudCadena; j++) {
                char caracter = dataInputStream.readChar();//guarda cada caracter que lee en la variable caracter
                cadenaLeidaChar = cadenaLeidaChar + caracter;//va añadiendo el caracter que lee a la cadena ya guardada y leida previamente y se monta la cadenA

            }

            int bytesRestantes2 = dataInputStream.available();
            System.out.println("Quedan: " + bytesRestantes2 + " bytes por leer");

            System.out.println("Leemos la cadena en char en el archivo: " + cadenaLeida);

            System.out.println("Ya no queda nada por leer");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
