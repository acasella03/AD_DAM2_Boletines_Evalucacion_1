package archivos;

import java.io.File;

public class Archivos {

    public static void main(String[] args) {
        String rutaAbsoluta = "C:/Users/Angita/Documents/NetBeansProjects/AD_DAM2_Boletines_Evalucacion_1/archivos";
        String directorio1 = "archivosdir";
        String directorio2 = "subdir";
        String nombreFichero1 = "Products1.txt";
        String nombreFichero2 = "Products2.txt";
        File directorios = new File(rutaAbsoluta + "/" + directorio1);

        Metodos metodo = new Metodos();

        //metodo.creaDirectorio(rutaAbsoluta + "/" + directorio1);
        //metodo.eDirectorio(rutaAbsoluta + "/" + directorio1);
        //metodo.creaFicheiro(rutaAbsoluta + "/" + directorio1, nombreFichero1);
        //metodo.eFichero(rutaAbsoluta + "/" + nombreFichero1);
        //metodo.creaDirectorio(rutaAbsoluta + "/" + directorio1 + "/" + directorio2);
        //metodo.creaFicheiro(rutaAbsoluta + "/" + directorio1 + "/" + directorio2, nombreFichero2);
        //metodo.mContenido(rutaAbsoluta+"/"+directorio1);
        //metodo.modoAcceso(rutaAbsoluta+"/"+directorio1, nombreFichero1);
        //metodo.calculaLongitud(rutaAbsoluta+"/"+directorio1, "/"+nombreFichero1);
        //metodo.mLectura(rutaAbsoluta+"/"+directorio1+"/", nombreFichero1);
        //metodo.mEscritura(rutaAbsoluta+"/"+directorio1+"/", nombreFichero1);
        //metodo.borraFichero(rutaAbsoluta+"/"+directorio1+"/", nombreFichero1);
        //metodo.borraFichero(rutaAbsoluta+"/"+directorio1+"/"+directorio2+"/", nombreFichero2);
        //metodo.borraDirectorio(rutaAbsoluta+"/"+directorio1+"/"+directorio2);
        metodo.recur(directorios);
    }

}
