# Ejercicio CopyCaracteres:

Vamos a trabajar con flujos de caracteres para lo cual vamos a seguir utilizando las clases de la jerarquia **Writer**.

**FileWriter** permite que conectemos el flujo de caracteres a un fichero en modo escritura.

## Aplicación: 
Utilizando exclusivamente los métodos `read()` y `write()` de las clases **FileReader** y **FileWriter** copia el contenido de un fichero de texto  denominado **texto1.txt** (tienes información de como crearlo más abajo) en otro denominado **texto2.txt**. 
 
## Métodos usados:
* `read()` ---> Retorna un caracter como un int. Si se intenta leer fuera del fichero, se lee un -1.
* `write(int c)` ---> c es un int que representa el caracter a ser escrito.

El contenido del fichero **texto1.txt** puedes crearlo con cualquier editor de texto plano y su contenido debe ser el siguiente:
```
a arbore
o libro
o neno
```
Este ejercicio es muy parecido a [CopyBytesTexto](../CopyBytesTexto/) con la diferencia de que la unidad mínima de información aquí es un caracter y no un byte.                  
            
           
