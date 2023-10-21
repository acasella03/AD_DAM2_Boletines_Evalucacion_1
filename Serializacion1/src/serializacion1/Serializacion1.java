package serializacion1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion1 {

    public static void main(String[] args) {

        String nombreArchivo = "serial";
        
        // Instanciar un objeto de la clase MClase con valores dados
        MClase objetoAGrabar = new MClase("ola", -7, 2.7E10);
        
        // Crear un objeto vacío de la clase MClase
        MClase objetoRecuperado = new MClase();

        // Guardar el objeto en un archivo llamado 'serial'
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            objectOutputStream.writeObject(objetoAGrabar);
            System.out.println("Objeto grabado en el archivo 'serial'");
        } catch (IOException ex) {
            ex.getMessage();
        }

        // Cargar los atributos del objeto desde el archivo 'serial'
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            objetoRecuperado = (MClase) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        
        // Imprimir los atributos del objeto recuperado
        if (objetoRecuperado != null) {
            System.out.println("Objeto recuperado: s=" + objetoRecuperado.nome
                    + "; i=" + objetoRecuperado.numero1
                    + "; d=" + objetoRecuperado.numero2);
        }
    }

}
