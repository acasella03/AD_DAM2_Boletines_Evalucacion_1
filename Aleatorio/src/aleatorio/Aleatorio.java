package aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {

    public static void main(String[] args) {
        // Definir los arrays de datos
        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};

        // Definir el tamaño de cada registro en bytes
        int recordSize = 30;

        // Nombre del archivo
        String fileName = "productos.dat";

        // Escribir los registros en el archivo aleatorio
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            for (int i = 0; i < codes.length; i++) {
                // Formatear y rellenar los campos código y descripción
                String formattedCode = String.format("%-3s", codes[i]);
                String formattedDesc = String.format("%-10s", descricion[i]);

                // Escribir el registro en el archivo
                file.writeChars(formattedCode);
                file.writeChars(formattedDesc);
                file.writeInt(prices[i]);
            }

            // Leer y mostrar el contenido del registro en la posición número 2
            file.seek(recordSize); // Posicionarse en el segundo registro
            String code = readString(file, 3).trim(); // Leer y quitar espacios en blanco
            String description = readString(file, 10).trim(); // Leer y quitar espacios en blanco
            int price = file.readInt();

            // Mostrar los resultados
            System.out.println(code);
            System.out.println(description);
            System.out.println(price);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer una cadena de caracteres de longitud específica desde RandomAccessFile
    private static String readString(RandomAccessFile file, int length) throws IOException {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars);
    }

}
