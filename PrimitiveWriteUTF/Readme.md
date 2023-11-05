# Ejercicio PrimitiveWriteUTF: 

En éste ejercicio seguiremos trabajando los flujos binarios de datos, pero ahora tratándolos como soporte de tipos de dato primitivos y valores String.

**DataOutputStream** es una clase que dispone de una serie de  métodos para que, partiendo de flujos binaros de datos, podamos **escribir** tipos primitivos de datos y valores String.

**DataInputStream** es una clase que dispone de una serie de métodos para que, partiendo de flujos binaros de datos, podamos **leer** tipos primitivos de datos y valores String que previamente fueron codificados en estos flujos mediante **DataOutputStream**.

Dado que **DataInputStream** admite como parámetro cualquier clase heredada de *InputStream*, y **BufferedInputStream** cumple éste requisito, lo único que tenemos que hacer para poder usar los métodos de **DataInputStream** y pasarle como parámetro un **objeto BufferedInputStream** como lo trabajado en el ejercicio [copybytesimaxe2](../CopyBytesImaxe2/). 

Dado que **DataOutputStream** admite como parámetro cualquier clase heredada de *OutputStream*, y **BufferedOutputStream** cumple éste requisito lo único que tenemos que hacer para poder usar los métodos de **DataOutputStream** es pasarle como parámetro un **objeto BufferedOutputStream** como lo trabajado en el ejercicio [copybytesimaxe2](../CopyBytesImaxe2/).

## APLICACIÓN:

El objetivo es desarrollar un proyecto llamado **primitiveWriteUTF** que consistirá en grabar la misma cadena de texto tres veces consecutivas en un fichero denominado **texto3.txt** usando el método `writeUTF` y mostrar el tamaño del fichero cada vez que grabamos una cadena, para posteriormente recuperalos (leer dichas cadenas desde el fichero). 

Cadea a grabar : ***"o tempo está xélido"***

> [!IMPORTANT]
> Para saber si cuando hacemos la lectura alcanzamos el fin del fichero podemos usar el método `available()` de la clase **DataInputStream** que devolverá el valor 0 cuando ya no quede nada por leer.

## Métodos a usar: 

De la clase ***DataOutputStream***:
* `size()` ---> Devuelve el tamaño en bytes del archivo que estamos escribiendo.
* `writeUTF(String)` ---> Escribe la cadena que se pasa como parámetro.

De la clase ***DataInputStream***:
* `available()` ---> Devuelve el valor 0 si ya se leyeron todos los bytes del fichero.
* `readUTF()` ---> Lee cualquier String que fuese grabado previamente en un fichero con el método `writeUTF(String)`.
 
Tener en cuenta que `writeUTF(String)` escribe tipicamente 1 byte por cada caracter del String que le pasamos como parámetro ***( pero puede escribir hasta 3 bytes por caracter dependiendo del caracter )*** y poner antes a dicho String 2 bytes que contienen la longitud en número de bytes del String.

Es decir que si por ejemplo el String a grabar es el texto ***"o tempo está xélido"*** su escritura ocupará 23 bytes porque los caracteres normales y los blancos ocupan 1 byte por caracter, mientras que las vocales con acento ocupan 2 bytes cada una. Echemos un vistazo al cálculo:
```
"o tempo está xélido": tiene 14 caracteres normales + 3 blancos + 2 vocales acentuadas => 2 bytes (que preceden a la cadena para indicar su longitud) + 14 + 3 + 2 * 2 = 23 bytes
``` 

### El resultado de la ejecución podría ser el siguiente:
```
escribindo a cadea: o tempo está xélido
tamano do ficheiro: 23 bytes
escribindo a cadea: o tempo está xélido
tamano do ficheiro: 46 bytes
escribindo a cadea: o tempo está xélido
tamano do ficheiro: 69 bytes
tamano final  do ficheiro: 69 bytes
quedan: 69 bytes por ler
cadea: o tempo está xélido
quedan: 46 bytes por ler
cadea: o tempo está xélido
quedan: 23 bytes por ler
cadea: o tempo está xélido
Xa non queda nada por ler
```

> [!WARNING]
> Podemos comprobar que si intentamos abrir el fichero de texto [text3.txt](./texto3.txt) con editor gedit no lo permite. Debemos usar nano, vi, emacs u otro editor no gráfico y comprobaremos la forma en que fueron grabadas las cadenas.<br>
Podemos ver el contenido del fichero de texto en hexadecimal y en código ASCII desde una terminal con: `hexdump -C nombre_fichero` o bien en binario puro: `xxd -b nombre_fichero`. Mostrar longitud en bytes del fichero: `wc -c nombre_fichero`.


