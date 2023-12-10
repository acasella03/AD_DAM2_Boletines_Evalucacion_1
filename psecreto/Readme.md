# Psecreto

## Disponemos de:
1. Una tabla denominada 'referencia' que contiene tres campos: 
    - p (un numero) 
    - c1 (una letra)
    - c2 (otra letra)

2. Un **fichero serializado** llamado ['clave1'](./clave1) que contiene objetos de la clase ['Clave1.java'](./src/psecreto/Clave1.java) que consta de dos atributos:
    - cla1 (una letra)
    - num1 (un número)

3. Una tabla denominada 'clave2' que contiene dos campos:
    - cla2 (una letra)
    - num2 (un número)

4. Un **fichero de texto delimitado** chamado ['clavesuma'](./clavesuma)  que contiene por cada fila un número y una letra separados por un guión bajo ( _ ). En éste fichero se encuentra una palabra oculta que hay que descubrir.

## Desarrollar un proyecto:
Llamado **'psecreto'** que descubra la palabra secreta oculta en el fichero de texto delimitado 'clavesuma' sabiendo que: 
la suma del número correspondiente a la primera letra de cada fila de la tabla 'referencia' que se encuentra en el fichero serializado 'clave1' más el número correspondiente a la segunda letra de cada fila de la tabla 'referencia' que se encuentra en la tabla 'clave2', da un resultado que es el número correspondiente a la frase del fichero de texto delimitado  'clavesuma' cuya letra corresponde a una de las letras de la palabra oculta buscada.<br>
Cada fila de la tabla 'referencia' se corresponde por orden de aparición con cada una de las letras de la palabra oculta buscada.

## Imagen explicativa del objetivo del proyecto:
![Guía](Imagen%20guía.png)