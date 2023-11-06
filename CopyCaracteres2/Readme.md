# Ejercicio CopyCaracteres2

**BufferedWriter** permite crear un buffer usando como argumento cualquier objeto heredado de la clase **Writer** como **FileWriter**. 

**PrintWriter** admite también como argumento cualquier objeto heredado de la clase **Writer**, como **FileWriter** o **BufferedWriter**, y permite **escribir** datos en el flujo de salida como tiras de caracteres usando los métodos `print(argument)` y `println(argument)`.
         
* `print(argument)` ---> Escribe la representación en modo caracter del argumento. 
* `println(argument)` ---> Escribe la representación en modo caracter del argumento seguido de un caracter de retorno de línea.
        
**BufferedReader** permite crear un buffer usando como argumento cualquier objeto heredado de la clase **Reader** como **FileReader**, y dispone de los métodos `readLine()` y `read()`.

* `readLine()` ---> Lee una línea de texto y la retorna como un String. ***CUANDO LLEGA AL FINAL DEL FICHERO RETORNA UN NULL.***
* `read()` ---> Lee un solo caracter lo retorna como un int que representa el código ASCII para ese caracter, cuando intenta leer más allá del final del fichero, devuelve un -1

## APLICACIÓN:
Desarrollar lo que se pide en el ejercicio [CopyCaracteres](../CopyCaracteres/Readme.md), pero ahora utilizando los metodos:
* `readLine()` de la clase **BufferedReader**.
* `println(argument)` de la clase **PrintWriter** que a su vez hará uso de **BufferedWriter**.