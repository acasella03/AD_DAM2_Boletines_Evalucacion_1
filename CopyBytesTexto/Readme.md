# Ejercicio CopyBytesTexto 
## En este ejercicio trataremos los flujos de Bytes (binary streams) mediante las clases FileInputStream, FileOutputStream 

> [!NOTE]
> Por cada modificación que se pide deja comentada la línea como estaba antes de la modificación para dejar constancia de todas las modificaciones desarrolladas en el ejercicio.

La clase **FileInputStream** permite leer bytes desde un fichero del sistema. Para ello vamos a utilizar el método `read()` de dicha clase que leerá byte a byte. Cuando se pase al fin del fichero devolverá un valor -1 (por lo tanto hay que preguntar por éste valor para detectar el fin del fichero, y no hacer más lecturas que darían un error). 

**FileOutputStream** es una clase que permite hacer justo lo contrario, escribir bytes en un fichero del sistema. Para ello vamos a utilizar el método `write()` de dicha clase.
 
> [!NOTE]
> La clase **FileOutputStream** acepta en uno de sus contructores un segundo parámetro tipo boolean que si es "True" indica que  el fichero se abre en modo "append" (añadir), es decir que si usamos éste parámetro con valor "True" cuando volvamos a escribir en este fichero su contenido no se sobreescribe. 

> [!IMPORTANT] 
> Recuerda cerrar el **objeto OutputStream** con su método `close()` de ésta forma los datos que puedan quedar en el buffer son trasladados al fichero de destino. 

### PRIMERO
Crea a mano con un editor de texto simple (un editor de texto plano de Cientos y "gedit" por ejemplo) un fichero pequeño de texto llamado **texto1.txt** con las siguientes tres líneas:
```
ola
adeus
cecais
```

### SEGUNDO: APLICACIÓN

1. Desarrolla una aplicación pequeña llamada **copybytestexto** que, usando solamente éstas dos clases y los métodos indicados, copie byte a byte el contenido del fichero de texto llamado **texto1.txt** en otro fichero llamado **texto2.txt**.

2. Hacer la modificación necesaria en la aplicación anterior para que se añada de nuevo el texto del fichero **texto1.txt** al fichero **texto2.txt** (es decir hacer el cambio necesario para que no lo sobreescriba, por lo que cada vez que ejecutemos la apliciación, el fichero de texto **texto2.txt** se verá aumentado su contenido con las tres palabras del **texto1.txt** de nuevo). 