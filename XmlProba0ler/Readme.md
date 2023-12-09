# XMLproba0ler

Se trata de leer los contenidos del [documento XML que se generó en el ejercicio anterior](../XmlProba0/autores.xml) usando los métodos apropiados.

Las clases a usar son muy similares:<br>
**XMLInputFactory** <br>
**XMLStreamReader**

### Métodos de la clase XMLStreamreader:
- `hasNext()`: Para preguntar si aún quedan elementos a leer.

- `next()`: Para leer el siguiente elemento.

- `getEventType()`: retorna un entero que indica el tipo de elemento leído.Este entero se corresponde con una constante definida por a interfaz **XMLStreamConstants** y puede ser una de las siguientes:
    - START_ELEMENT
    - END_ELEMENT
    - ATTRIBUTE
    - CHARACTERS
    - COMMENT
    - SPACE
    - DTD

    Para preguntar por ejemplo si el tipo de evento leído es un ***Start Element*** preguntaremos si éste es igual a `XMLStreamConstants.START_ELEMENT`.

- `getLocalName()`: Devuelve el nombre del elemento actual.

- `getAttributeValue(posición_del_atributo_desde_0)`: Devuelve un string con el atributo almacenado en el índice especificado.

- `getElementText()`: Devuelve el valor de un elemento de texto.