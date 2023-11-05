# Ejercicio: 
## Va a constar de dos ejercicios: [copybytesimaxe](../CopyBytesImaxe/) y [copybytesimaxe2](../CopyBytesImaxe2/)

## APLICACIÓN [copybytesimaxe](../CopyBytesImaxe/):

Vamos a partir del ejercicio [CopyByTexto](../CopyBytesTexto/) para desarrollar éste, así que crea un proyecto denominado **copybytesimaxe** con el mismo código del ejercicio  [CopyByTexto](../CopyBytesTexto/src/copybytestexto/Copybytestexto.java)

1. Ahora haz la prueba de utilizar como fichero origen la imagen [foto.jpg](./foto.jpg) (en vez de *texto1.txt*) y como fichero destino de la copia una imagen que se llame **foto2.jpg** (en vez de *texto2.jpg*).<br>
¿Cuánto ocupa **foto2.jpg**? ¿Ocupa lo mismo que la image original?

2. Ejecuta por segunda vez la aplicación para que se añada de nuevo la imagen [foto.jpg](./foto.jpg)  a la imagen [foto2.jpg](./foto2.jpg).<br>
¿Qué ocurre si abrimos la imagen, se ve la imagen repetida? ¿Cuánto ocupa ahora el arquivo **foto2.jpg**?

3. Lo que estamos haciendo hasta ahora es trabajar con flujos de datos tipo byte, sin diferenciar si el contenido del fichero a copiar contiene datos de texto o binarios.

> [!NOTE]
> Veremos más adelante que cuando se trabaja con flujos de datos tipo texto normalmente se guarda un byte por caracter, pero cuando se trabaja flujos de datos de tipo binario se almacenan imagenes byte a byte o caracteres en un formato que puede escribir diferentes tipos primitivos de datos.

Es decir, en cuanto a lo que hemos hecho hasta ahora, para el sistema no hay diferencia entre copiar un fichero de texto o una imagen puesto que no interpreta el contenido de cada byte sino que simplemente lo lee y lo copia byte a byte (un byte de cada vez).

Esto es aparentemente rápido, pero si el fichero origen es grande y queremos mejorar la velocidad de copia debemos recurrir a otras clases que combinadas con las clases anteriores **(FileInputStream e FileOutputStream)** van a permitirnos mejorar la velocidad de los flujos de datos. 

Para trabajar con ficheros binarios tenemos dos clases que mejoran la velociad de entrada y salida del flujo de datos.<br>
Éstas clases son **BufferedInputStream** y **BuffferedOutputStream**.<br>
La ventaja de usar buffers es que se reduce el número de operaciones de entrada / salida que son hechas por el disco.<br>
Así, por ejemplo, si un buffer puede contener 4000 bytes, sólo se hará la operación de escritura o lectura cuando dicho buffer se llena o cuando el flujo sea cerrado (close). En caso de no usar buffers la grabación de los 4000 bytes requeriría cientos de operaciones de entrada / salida, y ya que cada operación requiere la recolocación de las cabezas del disco ésto lleva mucho tiempo.

Para poder hacer esto Java permite combinar dos o más flujos de datos (Streams) para añadir la funcionalidad que se necesita emparejar una aplicación **(FileInputStream y BufferedInputStream son flujos de datos que se poden combinar)**.<br>
Para combinar flujos de datos en Java debes usar un objeto de una de las clases como argumento para el constructor de la otra clase.

## APLICACIÓN [copybytesimaxe2](../CopyBytesImaxe2/):

Sabiendo que la clase **BufferedInputStream** acepta como argumento de su constructor a un objeto de la clase **FileInputStream**, y que la clase **BuffferedOutputStream** acepta como argumento de su constructor a un objeto de la clase **FileInputStream**, haz otro proyecto llamado **copybytesimaxe2** para aumentar la velocidad de copia haciendo uso de dichas clases. 

> [!IMPORTANT]
> Ten en cuenta que la clase **BufferedInputStream** tiene un método `read()` que permite leer un byte de cada vez y que la clase **FileInputStream** permite detectar el fin del fichero mediante la consulta del valor devuelto en la lectura: si es -1 indica el fin del fichero.<br>
Ten en cuenta también que la clase **BufferedOutputStream** tiene un método `write()` que permite escribir un byte. 

### Una vez que ejecutes el ejercicio:
¿Notaste la diferencia en velocidad a la hora de hacer la copia de la imagen con respecto a cuando NO usaste las clases **BufferedInputStream** y **BufferedOutputStream**?

Si no lo notas escoge una imagen de mayor número de bytes que la proporcionada **(foto.jpg)** o ejecuta varias veces el proyecto [copybytesimaxe](../CopyBytesImaxe/) para hacer crecer en bytes la imagen **foto2.jpg** y después usa ésta como origen de copia en este proyecto ([copybytesimaxe2](../CopyBytesImaxe2/))

