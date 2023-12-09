# XMLproba0

## Información:
**SAX** (simple API for XML: usado para convertir datos a XML y viceversa).

Un documento XML esta compuesto de ***elementos***.<br>
Todo elemento XML comieza y termina con una ***etiqueta o tag***.<br>
El tag inical y el final de un elemento tienen el mismo nombre que es elegido por el diseñador del documento.

El ***contenido(content)*** de un elemento es lo que va situado entre los tags iniciales y finales del elemento.

### Ejemplo de elemento:

```
<titulo> blade runner </titulo>
```
        
**Tag inicial**: `<titulo>`

**Contenido**: `blade runner`

**Tag final**: `</titulo>`

El elemento de más alto nivel o ***elemento padre (parent element)*** es el denominado ***elemento raíz***.<br>
**Un documento XML solo puede contener un elemento raíz.**

Dentro de un elemento pueden encontrarse más elementos denominados ***elementos hijos (child elements)***.<br>
El primer elemento de un documento XML es la declaración que indica la versión del XML que va a ser usada por el documento.

Un elemento puede contener uno o varios atributos, que son iguales a ***variable = valor*** que se utilizan normalmente para identificar ciertos elementos de un documento XML.

### Ejemplo de elemento con atributo:
```
<tenda codigo="t1">
```

Para escribir y leer documentos XML vamos a usar **StAX - Streaming API for XML**.

Antes de escribir en un documento XML necesitamos crear un objeto que implemente a interfaz **XMLStreamWriter**. Para hacer esto debemos:
1. Invocar el método estático `newInstance()` de la clase **XMLOutputFactory** para crear un objeto **XMLOutputFactory**.
2. Crear un objeto **XMLStreamWriter** invocando el método  `createXMLStreamWriter(FileWriter object)` del objeto **XMLOutputFactory** creado anteriormente.
3. A partir de ese momento ya se pueden usar los métodos propios del objeto **XMLStreamWriter** para escribir el documento. 

### Métodos XMLStreamWriter:
`writeStartDocument("1.0")`: Escribe la declaración XML con la Versión especificada.

`writeStartElement("tenda");`: Escribe el tag de inicio de un elemento.

`writeAttribute("codigo","t1");`: Escribe un atributo para el elemento actual.

`writeCharacters("urzaiz");`: Escribe el contenido del elemento.

`writer.writeEndElement();`: Escribe el tag de cierre del elemento actual.

## Aplicación: xmlproba0
Graba éste documento XML con nombre **autores.xml** desde java usando los métodos apropiados.

```
<?xm version="1.0"?>
<autores>
    <autor codigo ="a1">
    <nome>Alexandre Dumas </nome>
    <titulo> El conde de montecristo</titulo>
    <titulo> Los miserables </titulo>
    </autor>
    <autor codigo ="a2">
    <nome>Fiodor Dostoyevski</nome>
    <titulo> El idiota</titulo>
    <titulo> Noches blancas </>
    </autor>
<autores>
```

Al finalizar comprueba que funciona abriendo desde un navegador.