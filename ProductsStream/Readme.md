# APLICACIÓN ProductsStream:

Crear un nuevo proyecto denominado **productsStream** con una clase denominada **Product** y una clase principal tal como se describe a continuación:

## Clase Product: 
Debe tener tres variables privadas:
```
codigo		tipo String
descricion	tipo String
prezo		tipo Double
```

El constructor por defecto introducirá cadenas nulas en las variables codigo y descricion y un cero en el prezo.<br>
La clase debe tener otro constructor con tres parámetros (codigo, descricion e prezo).

Los métodos de la clase **Product** son los básicos de cualquiera clase, es decir los necesarios para poder realizar las siguientes operaciones sobres las tres variables:

* Cambiar el código:		`setCodigo(String codigo)`.
* Obtener el código: 		`getCodigo()`.
* Cambiar la descripción: 	`setDescricion(String descricion)`.
* Obtener la descripción: 	`getDescricion()`.
* Cambiar el precioo: 		`setPrezo(Double prezo)`.
* Obtener el precio: 		`getPrezo()`.
	
## Clase principal:
1. Crear un objeto de la clase Product con los argumentos: `"cod1", "parafusos", 3.0` 
2. Guardar los valores del producto creado en un fichero denominado **produtos.txt** mediante los métodos adecuados de **DataOutputStream** (mostrando el final de este texto).
3. Crear otro objeto de la clase Product con los argumentos: `"cod2","cravos", 4.0` y guardarlo como anteriormente.
4. Crear otro  objeto de la clase Product con los argumentos: `"cod3","tachas", 6.0` y guardarlo como anteriormente.
5. Crear otro objeto de la clase Product con los argumentos: `"cod4","grapas", 2.0` y guardarlo como anteriormente.
6. Guardar los valores del producto creado en el fichero [produtos.txt](./productos.txt).
7. Después crear un objeto tipo “producto” nuevo llamado **po3** sin argumentos y cargar sus atributos a partir de los datos de los productos que están guardados en el fichero [produtos.txt](./productos.txt) mediante **DataInputSream**, imprimiendo los valores de dichos productos ***( se entiende que primero cargo los datos del primer producto leído en el objeto po3, e imprimo los valores y luego cargo los datos del siguiente producto leído en el mismo objeto po3 e imprimo sus valores nuevamente )***.

### El resultado de la ejecución debe ser:
```
lista de productos gardados no ficheiro produtos.txt
cod1 , parafusos , 3.0
cod2 , cravos , 4.0
cod3,   tachas, 6.0
cod4 , grapas, 2.0
```

### Métodos usados: 
Cuando guardes los datos en el archivo produtos.txt, usa el método `writeUtf` para guardar el código y los datos de descripción, y el método `writeDouble` para guardar el precio.