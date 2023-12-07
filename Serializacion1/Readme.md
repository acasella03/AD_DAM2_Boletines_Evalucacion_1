# Serialización 1

Crear una clase llamada ***mclase*** que implemente la interfaz *serializable* (`implements Serializable`). Dicha clase debe tener tres atributos: 
- Una variable **String (nome)**
- Una variable **int (numero1)**
- Una variable **double (numero2)**.

Desde la clase principal del proyecto (main) instanciar un objeto de la clase ***mclase*** con tres valores: `"ola",-7, 2.7E10` y almacenar dicho objeto en un **fichero** denominado **'serial'** mediante el método `writeObject(obxecto_a_grabar)` de la clase **ObjectOutputStream** (que debe recibir como parámetro un objeto de la clase **FileOutputStream("ruta del fichero a escribir”)**). Cierra el fichero en el método `close()`.

Después crea otro objeto `vacío` de la clase ***mclase*** y carga posteriormente sus atributos con los valores almacenados en el **fichero 'serial'** anteriormente creado. Para esto debes usar el método `readObject()` de la clase **ObjectInputStream** sin olvidarte que **debes castearlo a la clase mclase**.
 
Si todo funciona correctamente hacer un cambio (dejando comentadas las líneas que modificaste para hacer este cambio) y repetir la ejecución del proyecto: ***el cambio consistirá en marcar la variable tipo int de la clase mclase como `'transient'` y comprobar que pongamos el valor que pongamos en ese campo int del objeto a guardar el resultado devuelto será `'0'` (sería un nulo si la variable transient fuera de tipo String)***

<br>

## Resultados de ejecución:
1. Ejecución **antes** del cambio:
    ```
    object1: s=ola; i=-7; d=2.7E10    
    ```

2. Ejecución **después** del cambio:
    ```
    object2: s=ola; i=0; d=2.7E10
    fin de la comprobación: Se recuperan los datos excepto i por ser transient.
    ```