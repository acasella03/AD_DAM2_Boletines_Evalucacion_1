# Ejercicio exa17p
Disponemos de un script denominado 'taboasexamena.sql' que crea tres tablas denominadas clientes, produtos y vendas con ciertos datos que se insertan desde el propio script. Lanzar dicho script como usuario 'oracle' contra la base de datos 'postgres'.

Disponemos de un fichero xml denominado 'produtos.xml' que registra una serie de pedidos por parte de los clientes.

Opcional (no es necesario usar): Disponemos de una clase java Pedidos.java que permite crear un objeto pedido y manipular su contenido. 
  
Desarrollar una aplicación denominada **exa17p** que actualice las tablas con los datos del fichero xml del seguiente modo: 

Para cada pedido del fichero pedidos.xml:
- Deben imprimirse los valores correspondientes a cada pedido.
- El campo stock de la tabla productos debe disminuir en la misma cantidad especificada en el elemento cantidad de dicho pedido.
- El campo gasto de la tabla clientes debe aumentar en una cantidad resultante de multiplicar el precio del producto (tabla produtos) por la cantidad especificada en el elemento cantidad de dicho pedido.
- Debe insertar en la tabla vendas el código del cliente, el código del produto, y la fecha del pedido junto con el total resultante de multiplicar el precio del producto (tabla produtos) por la cantidad especificada en el elemento cantidad de dicho pedido.

## El contenido del fichero XML es el siguiente:
```
<Pedidos>
  <Pedido Codcli="c1" Codpro="p1">
    <Cantidade>2</Cantidade>
    <Data>02/02/2011</Data>
  </Pedido>
  <Pedido Codcli="c2" Codpro="p2">
    <Cantidade>3</Cantidade>
    <Data>03/03/2011</Data>
  </Pedido>
  <Pedido Codcli="c1" Codpro="p2">
    <Cantidade>4</Cantidade>
  <Data>04/04/2011</Data>
  </Pedido>
</Pedidos>
```
## El contenido FINAL de las tres tablas debería ser el siguiente: 

`select * from clientes;`
| COD | NOMEC	|   DIREC   | GASTO |
| --- | ---   | ---       | ---   |
| c1  | juan	| r/burgos	|	100   |
| c2  | ana 	| r/urzaiz	|	60    |
| c3  | luis	| r/faisan	|	0     |
<br>

`select * from produtos;`
| COD |   NOMEP   | PREZO	| STOCK |
|---  | --------- | ---   | ---   |
| p1  | tornillos	| 10    | 998   |
| p2  | arandelas	|	20    | 493   |
| p3  | tuercas		| 30    | 100   |
<br>

`select * from vendas;`
| COD | COD |    DATA     | TOTAL |
|---  | --- | -------     |----   |
| c1  | p1	| 02/02/2011  | 20    |
| c2  | p2	| 03/03/2011  | 60    |
| c1  | p2	| 04/04/2011  | 80    |



