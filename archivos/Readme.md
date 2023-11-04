# Archivos: Introdución a archivos y directorios

Java dispone de la clase **File (java.io.File)** que permite realizar operaciones relativas a directorios y archivos (o ficheros).

## Clase java.io.File:

**Constuctor:** File(StringPath)
<br>

**Métodos:**		<br>
exists()			<br>
canRead()			<br>
canWrite()			<br>
isDirectory()		<br>
isFile()			<br>
getName()			<br>
getPath()			<br>
getAbsolutePath()	<br>
length()			<br>
lastModified()		<br>
listRoots()			<br>
listFiles()			<br>
list()				<br>
setReadOnly()		<br>
creatreNewFile()	<br>
setWritable(true)	<br>
delete()			<br>
etc ....


## OBJECTIVO:
Desarrollar un proyecto llamado "archivos" que realice las tareas especificadas a continuación: 

>[!NOTE]
>Todas las tareas de este ejercicio debe desarrollarse utilizando la **Clase File**, su constructor y sus métodos.

1) Método **eDirectorio(cadea)** que detecte si una cadena dada corresponde a un directorio. La cadena debe ser un String que contena la ruta absoluta del directorio. Imprime **'e un directorio'** o **'non e un directorio'**.  

2) Método **eFicheiro(cadea)** que compruebe si una cadena dada corresponde a un ficheiro. La cadena debe ser un String que contenga la ruta absoluta del directorio. Imprime **'e un ficheiro'** o **'non e un ficheiro'**.  

3) Método **creaDirectorio(String)** debe crear un directorio a partir de la ruta absoluta del mismo que se le debe pasar como un String. Solo debe crearse dicho directorio cuando no exista previamente. 

4) Método **creaFicheiro(dirName, fileName)** debe crear un fichero de una ruta absoluta que exista previamente, estos dos valores deben pasarse al método como valores String. Solo debe crearse dicho fichero en dicha ruta cuando no exista previamente.

5) Método **modoAcceso(dirName, fileName)** dado la ruta absoluta y nombre de un archivo, éste método debe imprimir la palabra: **"escritura si"** si se puede escribir en el y **"escritura non"** se no se puede escribir en el, **"lectura si"** si se puede leer en el y **"lectura non"** si no se puede leer en el.

6) Método **calculaLonxitude(dirName, fileName)** dado la ruta absoluta y nombre de un archivo, éste método debe imprimir la longitud en bytes del mismo. 

7) Método **mLectura(dirName, fileName)** dado la ruta absoluta y nombre de un archivo, éste método debe hacer el archivo de solo lectura.
   
8) Método **mEscritura(dirName, fileName)** dado la ruta y nombre de un archivo, éste método debe hacer posible escribir en el archivo.

9) Método **borraFicheiro(dirName, fileName)** dado la ruta y nombre de un archivo debe eliminarlo si es que existe, sino lanzar un mensaje 'fichero inexistente'.

10) Método **borraDirectorio(dirName)** dada una ruta debe eliminarla si es que existe, sino lanzar un mensaje 'ruta inexistente ou con descencencia'. 

11) Método **mContido(dirName)** que muestre archivos y directorios de primer nivel de una ruta absoluta dada. 

12) (Opcional) Método **recur(File)** que muestre archivos y subdirectorios del directorio que se le pase como objeto File.


**********

### Usando los métodos creados anteriormente:

1) Crear el directorio 'arquivosdir' en la ruta '/home/postgres/NetBeansProjects/archivos/' siempre y cuando dicho directorio no exista previamente.<br>
Comprobar que se trata de un directorio mediante el método **eDirectorio**. <br> 
(Comprobar que el directorio fue creado o existe, mediante los comandos del sistema operativo (modo texto), o mediante el entorno gráfico).

2) Crear el archivo Products1.txt en el directorio mencionado anteriormente (arquivosdir) siempre y cuando dicho archivo no exista.<br>
Comprobar que se trata de un fichero mediante el método **eFicheiro**.<br>
(Comprobar que el archivo fue creado o existe mediante comandos del sistema operativo (modo texto) o mediante el entorno gráfico).

3) Crear el directorio 'subdir' en la ruta '/home/postgres/NetBeansProjects/archivos/arquivosdir/' creada anteriormente.<br>
Crear el archivo Products2.txt en el directorio mencionado anteriormente (subdir).  

4) Muestra archivos y subdirectorios de primer nivel de la ruta '/home/postgres/NetBeansProjects/archivos/arquivosdir/'.<br>
Debería mostrarse el siguiente resultado:
	```
		Products1.txt
		subdir
	```
	 
5) Mostrar la siguiente información sobre el primer archivo (Products1.txt) creado:
	- Si es posible o no escribir en el.
	- Si es posible o no leer de el.
	- Su longitud en bytes. 
	- A continuación debes editar manualmente el archivo con editor de texto y escribir un texto cualquiera, por ejemplo la palabra 'ola', y volver a mostrar su longitud en bytes (debería tener el cambio realizado).

6) Forzar a que el mismo archivo referido en el apartado anterior sea de solo lectura.<br>
(Comprobar intentanto editar el archivo manualmente que no se puede escribir nada en dicho archivo).

7) Forzar a que el archivo referido en el apartado anterior pase de nuevo a ser de escritura.<br>
(Comprobar desde el sistema operativo que se puede escribir de nuevo en el  archivo).

8) Borrar el archivo referido en el apartado anterior.<br>
(Comprobar manualmente desde el sistema operativo que el archivo fue borrado).

9) Borrar el resto de archivos y directorios creados anteriormente. 

10) (Opcional) Mostrar usando el método recur(File) todos los subdirectorios y archivos que cuelgan del directorio '/home/postgres/NetBeansProjects/archivos/arquivosdir/'. 