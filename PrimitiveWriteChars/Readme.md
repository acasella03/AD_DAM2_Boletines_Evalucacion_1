# Ejercicio PrimitiveWriteChars

En éste ejercicio seguiremos tratando los flujos binarios de datos, pero ahora tratándolos como soporte de tipos de datos primitivos y valores String.

**DataInputStream** dispone de una serie de  métodos para que, partiendo  de flujos binaros de datos, podamos **leer** tipos primitivos de datos y valores String. 

**DataOutputStream** dispone de una serie de métodos para que, partiendo  de flujos binaros de datos, podamos escribir tipos primitivos de datos y valores String que previamente fueron codificados en éstos flujos mediante **DataInputStream**

Dado que **DataInputStream** admite como parámetro calquier clase heredada de ***InputStream***, y **BufferedInputStream** cumple éste requisito, lo único que temos que hacer para poder usar los métodos de **DataInputStream** es pasarle como parámetro un **objeto BufferedInputStream** como lo trabajado en el ejercicio [CopyBytesImaxe2](../CopyBytesImaxe2/)

Dado que **DataOutputStream** admite como parámetro cualquier clase heredada de ***OutputStream***, y **BufferedOutputStream** cumple éste requisito lo único que temos que hacer para poder usar los métodos de **DataOutputStream** es pasarle como parámetro un **objeto BufferedOutputStream** como lo trabajado en el ejercicio [CopyBytesImaxe2](../CopyBytesImaxe2/)

## APLICACIÓN:

El objetivo es desarrollar un proyecto que consistirá en grabar una misma cadena de texto dos veces usando el método `writeChars(String)` de la clase **DataOutputStream** en un fichero denominado **text5.dat** para posteriormente recuperalas (leerlos de nuevo) mediante el método `readChar()` de la clase **DataInputStream**.

Tener en cuenta que `writeChars(String)` escribe 2 bytes por caracter(podemos cambiar cualquier vocal de la cadena por esa misma vocal acentuada o una letra ñ y veremos que la longitud de la cadena no varía, al contrario de lo que ocurría con `writeUTF()` donde si variaba).

Tener en cuenta que `readChar()` lee un caracter de cada vez con lo cual habrá que hacer un bucle que ejecute ésta instrucción tantas veces como letras tiene la cadena que queremos leer.  

Cadena a grabar : ***"o tempo está xélido"***

## Métodos a usar:

* `length()` ---> Aplicado a cualquier String, proporciona su longitud en número de caracteres.

De la clase **DataInputStream**:
* `readChar()` ---> Lee un caracter de cada vez (2 bytes).
* `available()` ---> Proporciona cuantos bytes quedan por leer de un fichero.

De la clase **DataOutputStream**:
* `writeChars(String)` ---> Escribe el String (ocupa 2 bytes por caracter).
* `size()` ---> Aplicado a un objeto de tipo **DataOutputStream** nos devuelve lo que ocupa éste en bytes.

> [!NOTE]
> Dado que grabamos dos cadenas de igual longitud, para leerlas debemos repetir el código correspondiente a una lectura dos veces, o hacer un bucle hasta que el contenido a leer (detectable con el método `available()` de la clase **DataInputStream**) sea de una longitud igual a 0.

### El resultado de la ejecución debería ser la siguiente:
```
escribindo  : o tempo está xélido
a lonxitude desta cadea en carateres e: 19 caracteres
levanse escritos:  38 bytes
escribindo  : o tempo está xélido
a lonxitude desta cadea en carateres e: 19 caracteres
levanse escritos :  76 bytes

lemos a primeira cadea:  o tempo está xélido
restan  por ler : 38 bytes 
lemos a segunda cadea o tempo está xélido
restan por ler : 0 bytes
```

> [!NOTE]
> Podemos comprobar que si intentamos abrir el fichero de texto **text4.txt** con editor gedit no lo permite. Debemos usar nano, vi, emacs u otro editor no gráfico y comprobaremos la forma en que fueron grabadas las  cadenas.<br>
Podemos ver el contenido del fichero de texto en hexadecimal y en código ASCII con: `hexdump -C nombre_fichero` o bien en binario puro: `xxd -b nombre_fichero`. Mostrar la longitud en bytes del fichero: `wc -c nombre_fichero`