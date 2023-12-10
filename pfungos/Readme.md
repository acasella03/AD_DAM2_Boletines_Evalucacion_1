# Pfungos

## Disponemos de:

1. Una clase denominada [Detectados.java](./src/pfungos/Detectados.java) que debes incorporar al proyecto y cuyos atributos se describen a continuación:
    - **private int numero;** --> atributo clave para identificar a una fila de ésta tabla (no se usará para nada).

    - **private int codarea;** --> atributo que identifica a una área de galicia de entre las que corresponden a los objetos tipo area.java

    - **private int codfungo;** --> atributo del código que identifica al hongo encontrado en ésta área.

    - **private Double superficieafectada;** --> atributo numérico que expresa la superficie afectada dentro de ésta área por el hongo.

2. Un fichero serializado llamado **'detectados'** que contiene objetos de la clase [Detectados.java](./src/pfungos/Detectados.java)
    
        numero: 1, codarea: 2, codfungo: 4,superficieafectada:  10.0
        numero: 2, codarea: 2, codfungo: 5,superficieafectada:  2.0
        numero: 3, codarea: 5, codfungo: 12,superficieafectada:  4.0
        numero: 4, codarea: 5, codfungo: 5,superficieafectada:  12.0
        numero: 5, codarea: 6, codfungo: 13,superficieafectada:  10.0
        numero: 6, codarea: 8, codfungo: 6,superficieafectada:  5.0
        numero: 7, codarea: 8, codfungo: 2,superficieafectada:  3.0
        numero: 8, codarea: 11, codfungo: 5,superficieafectada:  4.0

3. Una **tabla** llamada **areas**: 
    - coda --> campo clave que identifica a un área.
    - noma --> campo que contiene el nombre del área.
    - hummedia --> campo que contiene la humedad media del área.
    - superficie --> campo que contiene la superficie del área
    - numerofungos --> campo que contiene el número de hongos encontrados en esa área (inicialmente a cero)
    
    | coda | noma | hummedia | superficie | numerofungos |
    | ---: | :--- | ---:     | ---:       | ---:         |
    |    1 | pos  |       23 |     1000.0 |            0 |
    |    2 | pon  |       21 |     2000.0 |            0 |
    |    3 | poe  |       22 |     1500.0 |            0 |
    |    4 | poo  |       19 |     1600.0 |            0 |
    |    5 | poc  |       20 |     2100.0 |            0 |
    |    6 | pus  |       24 |     1000.0 |            0 |
    |    7 | oun  |       22 |     1200.0 |            0 |
    |    8 | oue  |       23 |     1100.0 |            0 |
    |    9 | ouo  |       24 |     1200.0 |            0 |
    |   10 | ouc  |       21 |     1400.0 |            0 |
    |   11 | pos  |       19 |     1500.0 |            0 |
    |   12 | pon  |       18 |     1300.0 |            0 |
    |   13 | poe  |       20 |     1200.0 |            0 |
    |   14 | poo  |       22 |     1000.0 |            0 |
    |   15 | poc  |       21 |     1100.0 |            0 |
    |   16 | lus  |       17 |     1400.0 |            0 |
    |   17 | lun  |       18 |     2100.0 |            0 |
    |   18 | lue  |       17 |     2300.0 |            0 |
    |   19 | luo  |       18 |     1200.0 |            0 |

4. Otra **tabla** llamada **fungos** que contiene los datos de 15 hongos con la siguiente información para cada hongo:
    - id --> número que identifica al hongo.
    - nomf --> nombre del hongo.
    - humlimite --> número que indica la humedad a partir del cual un hongo se considera peligroso.   

    | id | nomef | humlimite |
    |--- |---    |---        |
    | 1  | a     | 23        |
    | 2  | b     | 25        |
    | 3  | c     | 25        |
    | 4  | d     | 26        |
    | 5  | f     | 17        |
    | 6  | g     | 24        |
    | 7  | h     | 20        |
    | 8  | i     | 19        |
    | 9  | k     | 22        |
    | 10 | j     | 23        |
    | 11 | m     | 24        |
    | 12 | n     | 18        |
    | 13 | t     | 18        |
    | 14 | p     | 19        |
    | 15 | q     | 20        |


## Proyecto:
***Se trata de controlar la proliferación de hongos en Galicia.***

### Se pide:

1. Por cada hongo encontrado:
    > [!TIP]
    > Recordar que cada objeto de la clase **detectados.java** contiene la información de un hongo encontrado en un área, es decir que **los objetos de la clase 'detectados.java' contenidos en el fichero serializado 'detectados' serán nuestros objetos de referencia**. 

    1.1. Aumentar en 1 el atributo **numerofungos** de la fila correspondiente de la **tabla areas**.
    
    1.2. Solamente si la **hummedia** del área es superior a la **humlimite** del hongo invasor correspondiente, debe generarse una fila nueva en un fichero delimitado llamado **'final'** usando como caracter separador un guión normal (-), con la siguiente información:

    - coda --> será el código del área donde se encontró el hongo (éste código es el atributo **codarea** del objeto detectado y leído anteriormente).
    - nomea --> será el nombre del área donde se encontró el hongo (éste nombre será el que se encuentra en la columna **noma** de la **tabla areas** que corresponde al objeto del fichero detectados leído, sabiendo que la relación es la siguiente: ***el atributo codarea de detectados se corresponde con la columna coda de la tabla areas***).
    - nomef --> será el nombre del hongo invasor encontrado en dicha área (éste nombre será el que se encuentra en la tabla fungos que corresponde al objeto detectados leído, sabiendo que la relación es la siguiente: ***el atributo codfungo de detectados se corresponde con la clave id de la tabla fungos***).
    - superficieafectada --> tendrá el contenido del atributo superficie afectada por el hongo
    - porcentaxedanos --> será el resultado de la siguiente expresión: `superficieafectada * 100 / superficie`.

## Objetos de la tabla areas DESPUÉS de ejecutarse la aplicación:
| coda | noma | hummedia | superficie | numerofungos |
| ---: | :--- | ---:     | ---:       | ---:         |
|    1 | pos  |       23 |     1000.0 |            0 |
|    2 | pon  |       21 |     2000.0 |            2 |
|    3 | poe  |       22 |     1500.0 |            0 |
|    4 | poo  |       19 |     1600.0 |            0 |
|    5 | poc  |       20 |     2100.0 |            2 |
|    6 | pus  |       24 |     1000.0 |            1 |
|    7 | oun  |       22 |     1200.0 |            0 |
|    8 | oue  |       23 |     1100.0 |            2 |
|    9 | ouo  |       24 |     1200.0 |            0 |
|   10 | ouc  |       21 |     1400.0 |            0 |
|   11 | pos  |       19 |     1500.0 |            1 |
|   12 | pon  |       18 |     1300.0 |            0 |
|   13 | poe  |       20 |     1200.0 |            0 |
|   14 | poo  |       22 |     1000.0 |            0 |
|   15 | poc  |       21 |     1100.0 |            0 |
|   16 | lus  |       17 |     1400.0 |            0 |
|   17 | lun  |       18 |     2100.0 |            0 |
|   18 | lue  |       17 |     2300.0 |            0 |
|   19 | luo  |       18 |     1200.0 |            0 |

## Contenido del fichero de texto delimitado 'final' DESPUÉS de ejecutada la aplicación:

| coda | noma | nomf | superficiedanada | porcentaxedanos |
|---   |---   |---   |---               |---              |
| 2    | pon  |	f    | 2                | 0.1             |
| 5    | poc  |	n    | 4                | 0.19047619      |
| 5    | poc  |	f    | 12               | 0.571428571     |
| 6    | ous  | t    | 10               | 1               |
| 11   | cos  | f    | 4                | 0.266666667     |

<br>

> [!IMPORTANT]
> Cada vez que quieras probar el proyecto de nuevo recordar lanzar de nuevo el script postgres. 
