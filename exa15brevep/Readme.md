# Ejercicio Tipo Examen

1. Disponemos de dos tablas denominadas **composicion** y **componentes** (en el script [taboasexameb.sql](./taboasexameb.sql)).

    Los campos de la tabla **composicion** son:<br>
    Código del plato (codp)<br>
    Código de un componente del plato<br>
    Peso de dicho componente en dicho plato

    Los campos de la tabla **componentes** son:<br>
    Código de un componente<br>
    Nombre del componente<br>
    Contenido en grasa por cada 100gr de dicho componente

2. Disponemos de una clase java denominada [Platos.java](./src/exa15brevep/Platos.java) que implementa la interface **Serializable**.

3. Disponemos de un fichero denominado [platoss](./platoss) que fue creado mediante serialización de objetos. El contenido de dicho fichero son objetos de la clase platos. En concreto contiene dos objetos con los valores:
    ```
    p1, platocarnico1
    p2, platocarnico2
    ```
 
4. Debes desarrollar una aplicación llamada EXACTAMENTE **exa15brevep** que partiendo del fichero [platoss](./platoss) y de las tablas dadas (script [taboasexameb.sql](./taboasexameb.sql)) imprima el código y nombre de cada objeto de tipo Platos que se encuentran en el fichero **platoss** junto con su contenido en grasas totales

> [!IMPORTANT]
> Tener en cuenta que aunque en la tabla **composicion** tenemos los componentes de tres platos solo debe grabarse el contenido en grasa de los platos p1 y p2 que son los que están referidos en el fichero **platoss**.

### La impresión debería ser algo parecido a lo siguiente:
```
p1
platocarnico1
graxatotal:80

p2
platocarnico2
graxatotal:160
```
> [!IMPORTANT]
> La grasa correspondiente a cada componente del plato se calcula así:
> 
>                   graxa_parcial = peso / 100 * graxa
> 
> La grasa total del plato y la suma de las grasas parciales se calcula así:
> 
>                   graxa_total = graxa_total + graxa parcial