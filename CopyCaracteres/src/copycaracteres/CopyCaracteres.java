package copycaracteres;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCaracteres {

    public static void main(String[] args) {
        String archivoEntrada = "texto1.txt";
        String archivoSalida = "texto2.txt";

        try (FileReader fileReader = new FileReader(archivoEntrada);
             FileWriter fileWriter = new FileWriter(archivoSalida)) {

            int caracter;

            // Leer y escribir caracter por caracter hasta el final del archivo
            while ((caracter = fileReader.read()) != -1) {
                fileWriter.write(caracter);
            }

            System.out.println("Contenido copiado de " + archivoEntrada + " a " + archivoSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
