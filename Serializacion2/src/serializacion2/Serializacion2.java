package serializacion2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion2 {

    public static void main(String[] args) {
        String nombreArchivo = "productos.txt";
        
        // Datos
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};
        
        // Escribir un objeto null para indicar el final
        Product productoNulo=new Product();
        

        // Crear y escribir objetos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (int i = 0; i < cod.length; i++) {
                Product producto = new Product(cod[i], desc[i], (double)prezo[i]);
                oos.writeObject(producto);
            }            
            oos.writeObject(productoNulo);
            System.out.println("Objetos escritos en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Leer objetos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Objeto para almacenar el objeto leído
            Object objetoLeido;
            // Bucle mientras se pueda leer un objeto no nulo
            while ((objetoLeido = ois.readObject()) != null) {
                // Verificar si el objeto leído es una instancia de la clase Product
                if (objetoLeido instanceof Product) {
                    // Convertir el objeto a la clase Product
                    Product producto = (Product) objetoLeido;
                    // Imprimir los valores individualmente
                    System.out.println("Código: " + producto.getCodigo());
                    System.out.println("Descripción: " + producto.getDescripcion());
                    System.out.println("Precio: " + producto.getPrecio()+"\n");
                }
            }
            System.out.println("Fin del archivo.");
        } catch (EOFException e) {
            System.out.println("Fin del archivo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
}
