# Texto Delimitado 

Graba en un fichero de texto delimitado mediante los métodos `print` y `println` de la clase **PrintWriter**, los contenidos de los tres arrays seguientes teniendo en cuenta que cada tres elementos que ocupan 
la misma posición en los arrays representan los campos de un registro de una tabla de produtos, donde cada producto tiene un código, una descripción y un precio:
```
String[] cod = {"p1","p2","p3"};
String[] desc = {"parafusos","cravos","tachas"};
int[] prezo = {3,4,5};
```

Ten en cuenta que debes usar como separadores de campo tabuladores: `\t` y que los separadores de registros deben ser retornos de linea: el método `println(argumento)` de la clase **PrintWriter** (`BufferedWriter(FileWriter(File)`) convierte el argumento en una cadena de texto e incluye un salto o retorno de línea al final.
      
Después de grabados dichos valores debes volverlos a leer registro a registro mediante el método `readLine()` de la clase **BufferedReader**, el cual le pasamos como parámetro la clase **FilerReader**.<br>
Cada vez que leas una línea del fichero debes pasar los valores de cada campo a un array mediante a función de cadena `split()` e imprimir dichos valores por separado como se muestra al final de éste enunciado.

El fin del fichero se detecta cuando el método `readLine()` devuelva un **null**.
	
> [!NOTE]
> Se debe investigar como usar a función de cadena **split** para separar los valores de una cadena.

> [!NOTE]
> **Opcional**: Si observas el resultado impreso verás que los precios están escritos con símbolo **€**. Puedes investigar como hacer ésto (hay varias formas de hacerlo).

> [!TIP]
> **Pista**: tienes la clase **NumberFormat** que tiene el método `getCurrencyInstance()` que te permite crear un objeto NumberFormat con formato monetario, con lo cual puedes dar formato monetario a un número.

<br>

## Resultado de la lectura por consola:          
```
Codigo:        p1
Descricion: parafusos
Prezo:       3,00 €

Codigo:        p2
Descricion: cravos 
Prezo:       4,00 €

Codigo:        p3
Descricion: tachas
Prezo:       5,00 €
```