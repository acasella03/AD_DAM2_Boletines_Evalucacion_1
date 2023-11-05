# Ejercicio PrimitiveUTFChars

En éste ejercicio seguiremos tratando los flujos binarios de datos, pero ahora tratándolos como soporte de tipos de dato primitivos e valores String.

**DataInputStream** dispone de una serie de métodos para que, partiendo de flujos binaros de datos, podamos **leer** tipos primitivos de datos y valores String. 

**DataOutputStream** dispone de una serie de métodos para que, partiendo de flujos binaros de datos, podamos **escribir** tipos primitivos de datos y valores String que previamente fueron codificados en éstos flujos mediante **DataInputStream**.

Dado que **DataInputStream** admite como parámetro cualquier clase heredada de ***InputStream***, y **BufferedInputStream** cumple éste requisito, lo único que tenemos que hacer para poder usar los métodos de **DataInputStream** y pasarle como parámetro un **objeto BufferedInputStream** como lo trabajado en el ejercicio [CopyBytesImaxe2](../CopyBytesImaxe2/) 

Dado que **DataOutputStream** admite como parámetro cualquier clase heredada de ***OutputStream***, y **BufferedOutputStream** cumple éste requisito lo único que tenemos que hacer para poder usar los metodos de **DataOutputStream** y pasarle como parámetro un **objeto BufferedOutputStream** como lo trabajado en el ejercicio [CopyBytesImaxe2](../CopyBytesImaxe2/)

## APLICACIÓN:

El objetivo es desarrollar un proyecto que consistirá en grabar una misma cadena de texto tres veces usando dos métodos distintos (`writeUTF()` y `writeChars()`) en un fichero denominado **text6.dat** para posteriormente recuperalos.<br>
Recuerda que para recuperar una cadena de grabada con `writeUTF()` se debe usar `readUTF()`, pero para recuperar una cadena escrita con `writeChars()` se debe usar `readChar()` que solo lee un caracter de cada vez, esto implica que se debe usar un bucle que haga tantas lecturas como caracteres tiene la cadena original.

Cadena a grabar : ***“Está en casa”***

La primera vez debe grabarse usando `writeUTF(String)`.<br>
La segunda vez debe grabarse usando `writeChars(String)`.<br>
La tercera vez debe grabarse usando de nuevo `writeUTF(String)`.

### El resultado de la ejecucin debería ser el siguiente:
```
writeUTF escribindo: Está en casawriteUTF escribindo: Está en casa
bytes totais escritos: 15 bytes
writeChars escribindo: Está en casa
bytes totais escritos :  39bytes
writeUTF escribindo: Está en casa
bytes totais escritos  54 bytes
bytes totais por ler = 54 bytes
lemos a primeira cadea en UTF: Está en casa
numero de bytes por ler: 39 bytes.
lemos a segunda cadea  con readChar() en bucle:  Está en casa
numero de bytes por ler : 15
lemos a terceira cadea  mediante readUTF:  Está en casa
numero de bytes por ler : 0
```

> [!NOTE]
> Podemos comprobar que si intentamos abrir el fichero de texto con editor gedit no lo permite. Debemos usar nano, vi, emacs u otro editor no gráfico  y comprobaremos la forma en que fueron grabadas las cadenas.
