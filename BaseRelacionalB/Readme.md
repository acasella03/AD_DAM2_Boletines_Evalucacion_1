
# Base Relacional B 

## A partir de la tabla produtos creada en el ejercicio [baserelacionalA](../BaseRelacionalA/) y usando un **resultset** de tipo "scrollable, updatable" que devuelve todas las filas de la tabla, desarrollar cuatro métodos. 

### Que permitan:
- Listar el contenido completo del **resultset**.
- Actualizar desde dentro del **resultset**: *por ejemplo* la fila del producto p2 haciendo que su ***precio pase a ser 8***.
- Insertar desde dentro del **resultset** una fila de valores: *por ejemplo* el producto ***p4, martelo, 20***.
- Borrar desde dentro del **resultset**: *por ejemplo* la fila de código ***p3***.

Recuerda que para consultar con posibilidad de actualizar el resultado de lo consultado debo usar un **objeto Statement** creado con las opciones  "scrollable, updatable", y aplicarle después el método **executeQuery("consulta")** para obter el **resultset**. Es decir:
```
Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
```
Y después crear el **objeto ResultSet** a partir de aplicar el método **executeQuery("consulta")** al objeto Statement anterior.

<br>

### Pasos para ***insertar*** un registro desde dentro del resultset:
- Invocar al método `moveToInsertRow()` del objeto ResultSet.
- Introducir valores en los campos del registro que queremos insertar.
- Usar el método `updateString("nome_campo", valor)` del ResultSet (si es un entero sera `updateInt("nome_campo", valor)`).
- Insertar la fila: Invocar al método `insertRow()` del objeto ResultSet.
        
### Pasos para ***actualizar*** un registro (Una vez situado en la fila que queremos modificar del ResultSet):
- Actualizar un campo: Invocar al método `updateString("nome_campo", valor)` del ResultSet (si es un entero sera: `updateInt("nome_campo", valor)`).
- A continuación actualizar la fila que contiene los campos actualizados: Invocar al método `updateRow()`.

### Pasos para ***borrar*** un registro (sobre el que estamos situados):
- Invocar al método `deleteRow()`.

<br>

### Algunos métodos del Resultset (scrollable and updatable):
- `first()`: mueve el cursor a la primera fila del objeto ResultSet.

- `last()`: mueve el cursor a la última fila del objeto ResultSet.

- `isLast()`: retorna un valor verdadero si estamos posicionados en la última fila del objeto ResultSet.

- `close()`: cierra el objeto ResultSet.

- `next()`: mueve el cursor a la próxima fila del objeto ResultSet.

- `previous()`: mueve el cursor a la fila previa a la actual del objeto ResultSet.

<br>
   
> [!IMPORTANT]
> La consulta de todos los campos de una fila debe hacerse explicitando el nombre de la tabla antes del `*` , es decir: `SELECT produtos.* FROM produtos . . .` 