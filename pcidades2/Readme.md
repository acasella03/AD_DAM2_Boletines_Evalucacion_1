# Enunciado:

Disponemos de un **fichero de texto delimitado** llamado ['zonas'](zonas.txt) que contiene el código de una zona, el nombre de la misma y el precio por metro cuadrado separados por guiones bajos ( _ ). 
 
Disponemos de un **script** denominado [taboaspci.sql](taboaspcivariacion2023.sql) que contiene dos tablas llamadas 'propiedades' y 'pisos'. 

Tabla propiedades:
- codp -> código de identificación de un piso.
- codz -> código de la zona donde se encuentra el piso.

Tabla pisos:
- codp      -> código de identificación de un piso.
- enderezo  -> dirección del piso.
- m2        -> superficie en metros cuadrados del piso.
- nif       -> nif del propietario del piso.
- ano       -> año en que se construyó el piso.

Desarrolla una aplicación denominada **'pcidades2'** que muestre los nombres de cada una de las zonas del fichero delimitado 'zonas.txt', el número de pisos situados en cada una de dichas zonas y el valor total de los precios de los pisos de cada una de dichas zonas teniendo en cuenta que el valor de un piso se calcula multiplicando sus metros cuadrados (campo m2 de la tabla pisos) por el precio que tiene la zona por metro cuadrado y restándole una cantidad que depende del número de años que tiene el piso según el siguiente baremo:
- si el piso tiene más de 30 años se restan 20.000
- si el piso tiene más de 20 y hasta 30 años (incluídos) se restan 10.000 
- si el piso tiene más de 10 y hasta 20 años (incluídos) se restan 5.000
- si el piso tiene 10 años o menos de antigüedad no se resta nada. 

Se debe guardar el código, nombre y total de cada zona en un fichero serializado llamado **'listaz2'**:<br>
Se dispone de una la clase java [Listaz2.java](./src/pcidades2/Listaz2.java) para poder guardar los objetos en el fichero de objetos serializado listaz2.

> [!WARNING]
> Es **FUNDAMENTAL** que el nombre del proyecto sea exactamente este: **pcidades2** (todo en minúsculas).

> [!IMPORTANT]
> Si no trabajas con netbeans recuerda que debes crear un paquete que contengan tus clases. Dicho paquete debe llamarse exactamente pcidades2 sino no podrás leer el fichero serializado listaz2.

## Ficheros y tablas poporcionadas:
| Fichero delimitado zonas.txt  |
| :---                          |
| z1_calvario_2300              |
| z2_teis_2100                  |
| z3_rosalia_1000               |
| z4_centro_3000                |
| z5_principe_4000              |
| z6_lavadores_2000             |
| z7_travesia_1000              |
| z8_traviesas_1600             |
| z9_navia_1600                 |
| z10_bouzas_3000               |
| z11_cabral_1400               |
<br>

| Tabla | propiedades: |
| ---      | ---       |
| **codp** | **codz**  | 
| p1       | z2        |
| p2       | z3        |
| p3       | z4        |
| p4       | z5        |
| p5       | z1        |
| p6       | z8        |
| p7       | z9        |
| p8       | z8        |
| p9       | z2        |
| p10      | z3        |
| p11      | z7        |
| p12      | z3        |
| p13      | z2        |
| p14      | z8        |
| p15      | z1        |

| Tabla  | pisos:      |      |       |       |
| ---    | ---         | ---  | ---   | ---   |
|**codp**|**enderezo** |**m2**|**nif**|**ano**|
| p1     | aaa         |  60  | 368l  | 1991  |
| p2     | bbb         |  70  | 3611a | 1992  |
| p3     | ccc         |  80  | 368l  | 2000  |
| p4     | ddd         |  65  | 3616c | 2001  |
| p5     | aaa         | 100  | 3614m | 2010  |
| p6     | bbb         |  50  | 3611a | 2019  |
| p7     | zzz         |  75  | 3612u | 2021  |
| p8     | xxx         |  60  | 3611a | 1991  |
| p9     | rrr         |  80  | 3612u | 1990  |
| p10    | www         |  90  | 365a  | 1995  |
| p11    | yyy         | 120  | 365a  | 1996  |
| p12    | ddd         | 200  | 365a  | 2005  |
| p13    | sss         | 100  | 362b  | 2015  |
| p14    | aaa         |  65  | 362b  | 2020  |
| p15    | hhh         |  60  | 363c  | 1989  |
| p16    | yyy         |  70  | 364d  | 1988  |
| p17    | mmm         |  75  | 364d  | 2003  |
| p18    | eee         |  80  | 3611a | 2007  |
| p19    | bbb         |  90  | 364d  | 2010  |
| p20    | ccc         | 100  | 3611a | 2013  |
| p21    | www         |  60  | 367g  | 2014  |
| p22    | lll         |  40  | 369f  | 2018  |
| p23    | mmm         |  30  | 369f  | 2021  |
| p24    | sss         |  90  | 3614m | 2022  |
| p25    | nnn         |  55  | 367g  | 1995  |
| p26    | ppp         |  65  | 369f  | 2001  |
| p27    | sss         |  75  | 3614m | 2003  |


## Resultado del proyecto:

### Contenido final del fichero serializado listaz2: 
codz=  z1 , nomz= calvario, total=343000 <br>
codz=  z2 , nomz= teis, total=464000 <br>
codz=  z3 , nomz= rosalia, total=325000 <br>
codz=  z4 , nomz= centro, total=230000 <br>
 codz=  z5 , nomz= principe, total=250000 <br>
codz=  z6 , nomz= lavadores, total=0 <br>
 codz=  z7 , nomz= travesia, total=110000 <br>
 codz=  z8 , nomz= traviesas, total=260000 <br>
codz=  z9 , nomz= navia, total=120000 <br>
 codz=  z10 , nomz= bouzas, total=0 <br>
codz=  z11 , nomz= cabral, total=0 <br>

****************************
### Posible salida por pantalla : 

codz : z1 , nomz : calvario, prezom2 : 2300 <br>
codigo de piso : p5 <br>
m2 : 100 , prezo piso : 225000 <br>
codigo de piso : p15 <br>
m2 : 60 , prezo piso : 118000 <br>
numero de pisos na zona calvario : 2 , total : 343000 <br>

codz : z2 , nomz : teis , prezom2 : 2100 <br>
codigo de piso : p1 <br>
m2 : 60 , prezo piso : 106000 <br>
codigo de piso : p9 <br>
m2 : 80 , prezo piso : 148000 <br>
codigo de piso : p13 <br>
m2 : 100 , prezo piso : 210000 <br>
numero de pisos na zona teis : 3 , total : 464000 <br>

codz : z3 , nomz : rosalia , prezom2 : 1000 <br>
codigo de piso : p2 <br>
m2 : 70 , prezo piso : 50000 <br>
codigo de piso : p10 <br>
m2 : 90 , prezo piso : 80000 <br>
codigo de piso : p12 <br>
m2 : 200 , prezo piso : 195000 <br>
numero de pisos na zona rosalia : 3 , total : 325000 <br>

codz : z4 , nomz : centro , prezom2 : 3000 <br>
codigo de piso : p3 <br>
m2 : 80 , prezo piso : 230000 <br>
numero de pisos na zona centro : 1 , total : 230000 <br>

codz : z5 , nomz : principe , prezom2 : 4000 <br>
codigo de piso : p4 <br>
m2 : 65 , prezo piso : 250000 <br>
numero de pisos na zona principe : 1 , total : 250000 <br>

codz : z6 , nomz : lavadores , prezom2 : 2000 <br>
numero de pisos na zona lavadores : 0 , total : 0 <br>

codz : z7 , nomz : travesia , prezom2 : 1000 <br>
codigo de piso : p11 <br>
m2 : 120 , prezo piso : 110000 <br>
numero de pisos na zona travesia : 1 , total : 110000 <br>

codz : z8 , nomz : traviesas , prezom2 : 1600 <br>
codigo de piso : p6 <br>
m2 : 50 , prezo piso : 80000 <br>
codigo de piso : p8 <br>
m2 : 60 , prezo piso : 76000 <br>
codigo de piso : p14 <br>
m2 : 65 , prezo piso : 104000 <br>
numero de pisos na zona traviesas : 3 , total : 260000 <br>

codz : z9 , nomz : navia , prezom2 : 1600 <br>
codigo de piso : p7 <br>
m2 : 75 , prezo piso : 120000 <br>
numero de pisos na zona navia : 1 , total : 120000 <br>

codz : z10 , nomz : bouzas , prezom2 : 3000 <br>
numero de pisos na zona bouzas : 0 , total : 0 <br>

codz : z11 , nomz : cabral , prezom2 : 1400 <br>
numero de pisos na zona cabral : 0 , total : 0 <br>