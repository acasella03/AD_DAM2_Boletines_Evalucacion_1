package archivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos {

    File directorio;
    File fichero;

    /**
     * Detecta si una cadena dada corresponde a un directorio. Se imprime 'es un
     * directorio' o 'no es un directorio'
     *
     * @param cadena String que contiene la ruta absoluta del directorio.
     */
    public void eDirectorio(String cadena) {
        directorio = new File(cadena);
        if (directorio.isDirectory()) {
            System.out.println(cadena + " Es un directorio");
        } else {
            System.out.println(cadena + " No es un directorio");
        }
    }

    /**
     * Comprueba si una cadena dada corresponde a un fichero. Se imprime 'es un
     * fichero' o 'no es un fichero'
     *
     * @param cadena String que contiene la ruta absoluta del directorio
     */
    public void eFichero(String cadena) {
        directorio = new File(cadena);
        if (directorio.isFile()) {
            System.out.println(cadena + " Es un fichero");
        } else {
            System.out.println(cadena + " No es un fichero");
        }
    }

    /**
     * Crea un directorio a partir de una ruta absoluta del mismo. Solo debe
     * crearse dicho directorio cuando no exista previamente
     *
     * @param cadena String que contiene la ruta absoluta del directorio.
     */
    public void creaDirectorio(String cadena) {
        // Crea un objeto File con la ruta completa del directorio
        directorio = new File(cadena);

        // Verifica si el directorio no existe
        if (!directorio.exists()) {
            boolean creado = directorio.mkdir(); // Crea el directorio
            if (creado) {
                System.out.println("Se ha creado el directorio: " + directorio.getAbsolutePath());
            } else {
                System.err.println("No se pudo crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe en la ruta: " + directorio.getAbsolutePath());
        }
    }

    /**
     * Crea un fichero en una ruta absoluta que exista previamente. Solo debe
     * crearse dicho fichero en dicha ruta cuando no exista previamente.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void creaFicheiro(String dirName, String fileName) {
        // Crea un objeto File con la ruta completa del fichero
        fichero = new File(dirName, fileName);

        // Verifica si el fichero no existe
        if (!fichero.exists()) {
            try {
                // Crea el fichero
                boolean creado = fichero.createNewFile();
                if (creado) {
                    System.out.println("Se ha creado el fichero: " + fichero.getAbsolutePath());
                } else {
                    System.err.println("No se pudo crear el fichero.");
                }
            } catch (IOException e) {
                try {
                    throw e;

                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("El fichero ya existe en la ruta: " + fichero.getAbsolutePath());
        }
    }

    /**
     * Imprime: "Escritura si" si se puede escribir en el. "Escritura no" si no
     * se puede escribir en el. "Lectura si" si se puede leer en el. "Lectura
     * no" si no se puede leer en el.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void modoAcceso(String dirName, String fileName) {
        directorio = new File(dirName);
        fichero = new File(directorio + fileName);

        // Verifica si se puede escribir en el fichero
        if (fichero.canWrite()) {
            System.out.println("Escritura si");
        } else {
            System.out.println("Escritura no");
        }

        // Verifica si se puede leer en el fichero
        if (fichero.canRead()) {
            System.out.println("Lectura si");
        } else {
            System.out.println("Lectura no");
        }
    }

    /**
     * Imprime la longitud en bytes de un archivo.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void calculaLongitud(String dirName, String fileName) {
        directorio = new File(dirName);
        fichero = new File(directorio + fileName);
        if (fichero.exists()) {
            long longitudBytes = fichero.length();
            System.out.println("Longitud del archivo " + fichero.getName() + ": " + longitudBytes + " bytes");
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }

    /**
     * Hace el archivo de solo lectura.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void mLectura(String dirName, String fileName) {
        fichero = new File(dirName + fileName);
        if (fichero.exists()) {
            // Intenta establecer el atributo de solo lectura
            boolean exito = fichero.setReadOnly();

            if (exito) {
                System.out.println("El archivo " + fichero.getName() + " ahora es de solo lectura.");
            } else {
                System.err.println("No se pudo establecer el archivo como solo lectura.");
            }
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }

    /**
     * Hace posible escribir en el arquivo.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void mEscritura(String dirName, String fileName) {
        fichero = new File(dirName + fileName);
        if (fichero.exists()) {
            // Intenta habilitar la escritura en el archivo
            boolean exito = fichero.setWritable(true);

            if (exito) {
                System.out.println("Se ha habilitado la escritura en el archivo " + fichero.getName() + ".");
            } else {
                System.err.println("No se pudo habilitar la escritura en el archivo.");
            }
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }

    /**
     * Elimina un fichero.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     * @param fileName String que contiene el nombre del fichero.
     */
    public void borraFichero(String dirName, String fileName) {
        fichero = new File(dirName + fileName);
        if (fichero.exists()) {
            boolean exito = fichero.delete(); // Intenta eliminar el fichero

            if (exito) {
                System.out.println("El fichero " + fichero.getName() + " ha sido eliminado.");
            } else {
                System.err.println("No se pudo eliminar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe en la ruta especificada.");
        }

    }

    /**
     * Elimina un directorio.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     */
    public void borraDirectorio(String dirName) {
        directorio = new File(dirName);
        if (directorio.exists()) {
            boolean exito = directorio.delete(); // Intenta eliminar el directorio

            if (exito) {
                System.out.println("El directorio " + directorio.getName() + " ha sido eliminado.");
            } else {
                System.err.println("No se pudo eliminar el directorio por descendencia.");
            }
        } else {
            System.out.println("El directorio no existe en la ruta especificada.");
        }
    }

    /**
     * Muestra archivos y directorios de primer nivel de una ruta absoluta dada.
     *
     * @param dirName String que contiene la ruta absoluta del directorio.
     */
    public void mContenido(String dirName) {
        directorio = new File(dirName);
        // Verifica si la ruta especificada es un directorio válido
        if (directorio.isDirectory()) {
            // Obtiene una lista de archivos y directorios de primer nivel
            File[] archivosYDirectorios = directorio.listFiles();

            if (archivosYDirectorios != null) {
                for (File archivoODirectorio : archivosYDirectorios) {
                    if (archivoODirectorio.isDirectory()) {
                        System.out.println("Directorio: " + archivoODirectorio.getName());
                    } else {
                        System.out.println("Archivo: " + archivoODirectorio.getName());
                    }
                }
            } else {
                System.err.println("No se pudo listar el contenido de la ruta.");
            }
        } else {
            System.err.println("La ruta especificada no es un directorio válido.");
        }
    }

    /**
     * Muestra archivos y subdirectorios del directorio que se le pase como
     * objecto File.
     *
     * @param File objeto.
     */
    public void recur(Object File) {
        // Verifica si el objeto File representa un directorio válido
        if (directorio.isDirectory()) {
            // Obtiene una lista de archivos y subdirectorios
            File[] archivosYSubdirectorios = directorio.listFiles();

            if (archivosYSubdirectorios != null) {
                for (File archivoOSubdirectorio : archivosYSubdirectorios) {
                    if (archivoOSubdirectorio.isDirectory()) {
                        System.out.println("Directorio: " + archivoOSubdirectorio.getName());
                        // Llama recursivamente al método para listar los subdirectorios
                        recur(archivoOSubdirectorio);
                    } else {
                        System.out.println("Archivo: " + archivoOSubdirectorio.getName());
                    }
                }
            } else {
                System.err.println("No se pudo listar el contenido del directorio.");
            }
        } else {
            System.err.println("El objeto File no representa un directorio válido.");
        }
    }
}
