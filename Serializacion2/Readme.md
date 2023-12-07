# Serialización 2

Utilizando la serializacion de objetos y partiendo del array siguiente:
```
String[] cod = {"p1","p2","p3"};
String[] desc = {"parafusos","cravos ","tachas"};
int[] prezo = {3,4,5};
```

**Crea tres objetos tipo product** (esta clase ya la tienes hecha en un ejercicio anterior [productStream](../ProductsStream/)) y almacénalos en un fichero secuencial binario (**FileOutputStream**) utilizando los métodos adecuados de la clase **ObjectOutputStream**.

El objetivo como siempre es que, después de escritos, puedas leerlos desde dicho fichero e imprimirlos por consola. Hacer éste ejercicio utilizando el **bucle while** para leer los objetos almacenados suponiendo que no sabemos cuántos objetos hay almacenados.

> [!NOTE]
> El método `close()` del **ObjectOutputStream** no mete un **null** cuando se ejecuta dicho método por lo que si uso un bucle while para leerlo hasta el final no tengo forma de saber donde finaliza, dándome el error **"/Exception during deserialization: java.io.EOFException"**
> 
> Lo que podemos hacer es guardar un **null** justo antes de lanzar el `close()` de esta manera **cuando lea los objetos puedo preguntar si el objeto leído es un null para detener el bucle de lectura**.
>
> Otra cosa que podemos hacer es usar el método `available()` para ver cuanto queda por leer del fichero, si no queda nada finalizamos y ya está.
> 
> [!WARNING] Pero **¡CUIDADO!**:  el método `available()` de la clase **ObjectInputStream** NO devuelve el número de bytes que quedan por leer si no el número de bytes bloqueados, pero **PODEMOS usar el método `available()` de la clase ***FileInputStream*** porque al fin y al cabo **ObjectInputStream** está leyendo los objetos serializados a través de dicha clase**.