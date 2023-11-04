# Base Relacional A
## Tratar de conectarse desde java a Postgres para realizar operaciones de consulta y manipulación de datos contra tablas (select, insert, update, delete) 

### PARTE 1:

- Desde el cliente psql lanzar el script [produtos.sql](./produtos.sql) como usuario postgres contra la base de datos postgres:

```
			psql postgres
			\i <ruta do ficheiro produtos.sql>
```

Esto creará una tabla llamada productos con la siguiente estructura:
```
	CODIGO		VARCHAR2(3)  primary key
	DESCRICION	VARCHAR2(15)
	PREZO		integer
	DATAC		Date

```	
- Comprobar desde sqlplus que la tabla fue creada correctamente:
```
			\d produtos
```

### PARTE 2:  APLICACION baseRelacionalA

- Agregar el driver de postgres a la libreria del proyecto (lo tienes en la ruta /home/postgres/programas/postgres....jar)

- Agregar manualmente el paquete `java.sql.*`, es decir	`import java.sql.*`

- Crear un método llamado **'conexion'** que devuelva un objeto llamado **conn** de tipo **Connection** que se conecte a la base de datos postgres mediante el usuario postgres, con password 'postgres'. El objeto Connection se crea así:
	```
    String driver = "jdbc:postgresql:";
    String host = "//localhost:"; // también podría ser una ip como "192.168.1.14"
    String porto = "5432";
    String sid = "postgres";
    String usuario = "postgres";
    String password = "postgres";
    String url = driver + host+ porto + "/" + sid;
    Connection conn = DriverManager.getConnection(url,usuario,password);
	```

- Crear un método llamado **'insireProduto'** que permita insertar en la tabla produtos una fila, pasándole como parámetros el código, el nombre, el precio y la fecha de caducidad de un producto

- Crear un método llamado **'listaProdutos'** que muestre el contenido de los registros que hay en la base de datos (se debe crear y usar un `resulSet` y volcar el contenido del mismo) 

- Crear un método llamado **'listaProdutoPorCodigo'** que muestre el contenido del registro cuyo código de producto se pase por parámetro

- Crear un método llamado **'actualizaPre'** tal que pasándole el código como parámetro, se actualice el campo precio del registro que corresponde a dicho código

- Crear un método llamado **'eliminaProduto'** tal que pasándole el código  de un registro elimine el registro que corresponde a dichoo código.

## COMPROBACION : 
- Insertar varios registros en la tabla mediante el método **insireProduto** creado anteriormente usando sentencias sql standard. 
Los registros a insertar son:
	```
	p1 , parafusos, 3, 27/12/2020
	p2 , cravos , 4, 6/4/2020
	p3, tachas, 6, 3/7/2020
	```

- Comprobar desde sqlplus que los registros fueron creados y que podemos actualizar o borrar alguno de ellos usando los métodos creados anteriormente. 
  - Es decir:
    - Leer los registros de la tabla produtos del usuario hr mediante el método **listaProdutos()** creado anteriormente.
    - Modifica el registro del código p2 poniendo su precio al doble de lo que tiene actualmente.
    - Borra el registro del código p3.


> [!NOTE]
> Hacer todas las comprobaciones que necesites para asegurarte que funcionan todos las tareas mencionadas.

## METODOS (necesarios para desarrollar ésta aplicación): 

Para insertar, borrar o modificar datos debemos crea previamente un objeto **Statement** mediante el método `createStatement()` del objeto **Connection**. Después, en función de lo que queramos hacer, escogeremos una u otra opción entre los siguientes métodos del objeto **Statement** creado anteriormente:

- Insertar : método `executeUpdate("orde_de_insercion_sql")`
- Consultar (mediante resultset fordwar_only, read_only (por defecto)) : crear un objeto **ResultSet** a partir de aplicar el método `executeQuery("consulta")` al objeto **Statement** y recórrelo con un bucle. La forma de recorrer un objeto resultset (r) y finalizar el mismo e invocar su método `next() :  while (r.next()) {...` 
- Borrar : método `executeUpdate("orde_de_borrado_sql")`
- Modificar: método `executeUpdate("orde_de_modificacion_sql")`

<br>

> [!IMPORTANT]
> Para convertir una fecha en formato String a Date:
>```
> 		Date d = Date.valueOf(fecha);
>```
> Para  pasar una fecha en formato cadena (String) a  java.sql.Date:
> ```
>		SimpleDateFormat format = new SimpleDateFormat("ddMMYYYY");
>		java.util.Date di;
>		di = format.parse("28022021");
>		java.sql.Date df = new java.sql.Date(di.getTime());
>		insireProduto("p5", "cepillos", 6.0, df);
>```
