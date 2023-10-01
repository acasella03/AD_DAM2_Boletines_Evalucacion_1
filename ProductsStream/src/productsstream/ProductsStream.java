package productsstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsStream {

    public static void main(String[] args) {
        
        String nombreArchivo = "productos.txt";
        
        List<Product> productos = new ArrayList<>();
        productos.add(new Product("cod1","parafusos",3.0));
        productos.add(new Product("cod2","cravos",4.0));
        productos.add(new Product("cod3","tachas",6.0));
        productos.add(new Product("cod4","grapas",2.0));
        Product po3=new Product();
        
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
             // Iterar sobre la lista de productos y escribir en el archivo
            for (Product producto : productos) {
                dataOutputStream.writeUTF(producto.getCodigo());
                dataOutputStream.writeUTF(producto.getDescripcion());
                dataOutputStream.writeDouble(producto.getPrecio());
            }
            
                
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(nombreArchivo))) {
            int contador = 0;
            System.out.println("Lista de productos guardados en el archivo productos.txt");
            while (dataInputStream.available() != 0) {
                po3.setCodigo(dataInputStream.readUTF());
                po3.setDescripcion(dataInputStream.readUTF());
                po3.setPrecio(dataInputStream.readDouble());

                System.out.println(po3.getCodigo() + "," + po3.getDescripcion() + "," + po3.getPrecio());
                contador++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
