# Exercicio 11: Aleatorio

Guardar los contenidos de los tres arrays siguientes en un fichero aleatorio (creado en modo lectura escritura)  teniendo en cuenta que cada tres elementos que ocupan la misma posición en los arrays representan un código, una descripción y un precio:

```
        String[] codes={"p1","p2","p3"};
        String[] descricion ={"parafusos","cravos ","tachas"};
        int[] prices ={3,4,5};
```

[!NOTE] 
Tener en cuenta que asignaremos una longitud fija a cada registro, así para el código asignaremos 3 caracteres(6 bytes), para la descripción 10 caracteres(20bytes),  y el precio por ser un  entero tendrá asignado 4 bytes, siendo el tamaño total del registro de 30 bytes.
      
[!IMPORTANT] 
La clase a usar es **RandomAcessFile** (objecto File, "rw") y para sus métodos de escritura y lectura de tipos primitivos de datos (writeChars(..)  , writeInt(..) , readChar()..readInt()) 
      
Antes de grabar los datos de un registro deberá utilizarse un método que complete los espacios en blanco que faltan en los campos código y descripción hasta completar las longitudes de dichos campos con un caracter cualquiera.

**Pista:** La clase String tiene un método denonimado format que permite dar formato a una cadena: 
```
    String x= String.format("%" + width + "s", t).replace(' ','0')
``` 
Donde:

`width` : Es el ancho final de la cadena en número de caracteres
<br>
`t` : Es la cadena
<br>
`"%"` : Llena con espacios en blanco a la izquierda (con `"%-"` llena con espacios en blanco a la derecha)
<br>
Si además le aplicamos al método `format` el método `replace(' ', '0')` cambiará los blancos por ceros **(ésto es interesante si en un primer momento queremos ver el efecto de aplicar `format` porque los blancos no se ven en la impresión pero los ceros si)**

Una vez almacenados los tres registros en el fichero aleatorio debemos leer y mostrar el contenido de los campos del registro que ocupa a posición número 2 utilizando el método `seek(int n)` de la clase **RandomAccessFile** que permite posicionarnos en el byte indicado dentro de dicho fichero.

Tener en cuenta que al leer el registro tendremos que volver a separar sus contenidos y eliminar los espacios en blanco de las cadenas de texto para poder cargar correctamente dichos valores en las variables java apropiadas (String) excepto el valor que fue grabado con un número entero que simplemente debe ser convertido a un número entero usando casteo.

Es decir el resultado de la consulta debería mostrarse algo parecido a ésto:

```
p2
cravos 
4
```
