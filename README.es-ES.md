# QA_APItratamientoDatos

Demostración simple de automatización API QA usando Karate y tratamiento de datos de API usando Java.

Para acceder a la versión en inglés de este documento, <a href="README.md">pulse aquí</a>

## Enunciado

En este enlace encontrarás la documentación de la API de una tienda de mascotas: https://petstore.swagger.io/
1. Crea tu usuario mediante petición HTTP y posteriormente recupera sus datos llamando al servicio correspondiente.
2. Recoge mediante petición HTTP, el JSON que retorna el endpoint /pet/findByStatus y lista
mediante una función los nombres de las mascotas que se hayan vendido. El formato de salida deberá estar formado por la tupla {id, name}. Puedes utilizar la estructura de datos que prefieras.
3. Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método que pueda recorrerla para poder identificar cuantas mascotas se llaman igual. Ejemplo de salida: {“William”: 11, “ Floyd”: 2}. Como output, te pediremos el código (puedes separarlo en archivos como quieras) y los resultados de salida de los puntos anteriores. Recuerda que puedes utilizar el lenguaje que prefieras y cualquier mejora adicional será bien considerada.

## Notas del autor (Javier Aguerri)
- Aunque el entregable de esta tarea se ha empaquetado bajo el mismo proyecto de Eclipse (demoAPItesting), hay dos partes diferenciadas. La primera parte corresponde al punto 1 del enunciado, y los ficheros se podrán encontar en <code>src/test/java</code>. La segunda parte corresponde al resto del enunciado, y los ficheros se podrán encontar en <code>src/main/java</code>. 
- El punto 1 del enunciado se ha planteado como un test API automatizado muy simple con Karate y JUnit5 que consta de dos escenarios, uno que crea un usuario y otro que lo recupera. 
- El punto 2 se ha planteado con varias clases de Java, aunque no se ha seguido exactamente el planteamiento del encunciado como se explica a continuación.
	- Se ha creado una clase Pet, que representa una mascota. Esta clase tiene un constructor que toma directamente un parámetro en formato JSON y lo deserializa automáticamente usando la librería gson.
	- También se ha creado una clase PetList, que representa una lista de mascotas (Pet). Esta clase tiene un constructor que toma una lista de mascotas. En la clase principal, se instancia un objeto de esta clase con la respuesta del endpoint correspondiente.
	- Dado que PetList contiene toda la información disponible, me pareció más lógico reorganizar la tarea y dotar a esta clase de dos métodos. El primero (petsByStatusIdName) devuelve una lista de tuplas {id, name} que en la clase principal es serializada a JSON y mostrada por pantalla. El segundo (getNameCount) recorre la lista de mascotas para realizar el conteo de cuántas se llaman igual. 		- El conjunto de clases generado tiene más sentido desde un punto de vista funcional y la capacidad de instanciar objetos Pet directamente a través de la respuesta JSON otorga mayor flexibilidad al proyecto.
	
## Configuración del entorno e instrucciones de ejecución

- Instalar Java JDK 17
- Instalar Eclipse
- Instalar Maven a través de Eclipse (Install New Software > Add Repository > location: https://download.eclipse.org/technology/m2e/releases/latest
- Descargar los ficheros del proyecto mediante Git: <code>git clone git@github.com:JavierAguerri/QA_APItesting.git</code>
- Importar projecto en Eclipse como <code>Existing Maven Projects</code>
- Botón derecho sobre el proyecto > Maven > Update project
- Para ejecutar la primera parte: iniciar la ejecución del proyecto como <code>JUnit test</code>
- Para ejecutar la segunda parte: iniciar la ejecución del proyecto como <code>Java application</code>
