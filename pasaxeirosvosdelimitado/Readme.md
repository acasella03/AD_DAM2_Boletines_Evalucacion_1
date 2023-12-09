# Pasaxeiros Voos Delimitado

## Software disponible:

Disponemos de los [drivers para postgres.](postgresql-42.2.23.jar)

[voos.sql](voosp.sql): script necesario para crear las tablas en oracle que ya incluyen las inserciones de una serie de datos (pueden verse más abajo). 

[reservas](./reservas.txt): fichero de texto delimitado llamado 'reservas'  que contiene una serie de reservas de vuelos hechas por los pasajeros.

## Que se pide dentro del proyecto:

Crea los métodos que consideres necesarios para poder desarrollar las siguientes acciones (también puedes hacerlo sin métodos):

1) lerReservas(): leer el fichero de texto delimitado 'reservas'.

2) Por cada reserva leída en el apartado anterior debe:
    - Aumentarse en 1 el número de reservas para el pasajero correspondiente a cada reserva leída (campo **nreservas** tabla PASAXEIROS).

    - Insertar en la tabla RESERVASFEITAS los datos correspondientes a reserva leída, recordándose de calcular el campo **prezoreseva** que debe ser igual al **precio del vuelo de ida más el precio del vuelo de vuelta**, recordar que el precio de los vuelos se encuentran en la tabla VOOS. Guía de datos a grabar en la tabla RESERVASFEITAS:

        - Código de reserva y DNI.
        - Nombre.
        - Precio. 

<br>

## Contenidos INICIALES del fichero serializado 'reservas':
   
**codr** ------------> identifica la reserva<br> 
**dni** -------------> indica pasajero que tiene la reserva<br>
**idvooida** --------> indica el vuelo de ida del pasajero<br>
**idvoovolta** ------> indica el vuelo de vuelta del pasajero

| codr  |   dni  |	idvooida | 	idvoovolta  |
| :---: |  :---: |    :---:  |    :---:     |
|  1    | "361a" |		1 	 |	    2 		|
|  2 	| "362b" |		3 	 |	    4 		|
|  3 	| "361a" |		5 	 |	    6 		|

<br>

## Contenidos INICIALES de las tablas PASAXEIROS y VOOS: 

Tabla PASAXEIROS:
| DNI   |   NOME    |   TELF    |   CIDADE  | NRESERVAS |
| ---   | ---       |   ---     |   ---     | :---:     |
|361a   | luis      | 9861a     | vigo      | 0         |
|362b   | ana       | 9861b     | lugo      | 0         |
|363c   | pedro     | 9861c     | lugo      | 0         |
|364d   | ana       | 9861d     | vigo      | 0         |

<br>

Tabla VOOS:
| VOO |     ORIXE   |   DESTINO     | PREZO |
| --- |     ---     |   ---         | ---   |
| 1   | vigo        | estambul      | 150   |
| 2   | estambul    | vigo          | 200   |
| 3   | vigo        | londres       | 80    |
| 4   | londres     | vigo          | 90    |
| 5   |	vigo        | lisboa		| 90    |
| 6   |	lisboa      | vigo 		  	| 100   |
| 7   |	vigo        | viena		  	| 200   |
| 8   |	viena       | vigo 		  	| 250   |
| 9   |	vigo        | tunez		   	| 160   |
| 10  |	tunez       | vigo 		  	| 150   |
| 11  |	vigo        | paris		  	| 200   |
| 12  |	paris       | vigo 		   	| 90    |

<br>

## Contenido de la tabla PASAXEIROS después de ser ACTUALIZADA:
Con los datos procedentes de las lecturas de las reservas que se encuentran en el fichero serializado 'reservas'. (Vemos que el pasajero "361a" tiene 2 reservas porque realmente hay dos reservas que son de dicho pasajero.)

PASAXEIROS
| DNI   |   NOME    |   TELF    |   CIDADE  | NRESERVAS |
| ---   | ---       |   ---     |   ---     | :---:     |
|361a   | luis      | 9861a     | vigo      | 2         |
|362b   | ana       | 9861b     | lugo      | 1         |
|363c   | pedro     | 9861c     | lugo      | 0         |
|364d   | ana       | 9861d     | vigo      | 0         |

<br>

## Contenido de la tabla RESERVASFEITAS después de ser ACTUALIZADA:
Con los datos procedentes de las lecturas de las reservas que se encuentran en el fichero serializado 'reservas'

RESERVASFEITAS
| codr |   dni  | nome  | prezoreserva |
| ---  |   ---  |  ---  |   ---        |
| 1    | "361a" | luis  |    350       |
| 2    | "362b" | ana   |    170       |
| 3    | "361a" | luis  |    190       |