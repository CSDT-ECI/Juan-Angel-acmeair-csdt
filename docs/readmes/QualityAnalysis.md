## Análisis de atributos de calidad usando SonarCloud como herramienta

En esta etapa se realizó un análisis estático de código usando SonarCloud,
en dicho análisis se puede obtener un detalle completo en varios aspectos
del proyecto y su arquitectura, estos aspectos se dividen en los bugs
encontrados, code smells, código duplicado, vulnerabilidades y fallos de
seguridad. Gracias a estas categorías podemos filtrar y visualizar
fácilmente qué atributos de calidad son afectados como la mantenibilidad,
seguridad, fiabilidad, rendimiento, etc.

En la siguiente imagen se puede observar el resultado de análisis.

![sonar.png](..%2Fimg%2Fsonar.png)

Aquí se puede observar una gran cantidad de issues relacionados en gran
parte a la mantenibilidad del código debido a una presencia alta de code
smells, teniendo una calificación de A lo cual no es grave sin embargo a
medida que un proyecto va evolucionando puede desencadenar en problemas
que afecten el desarrollo y rendimiento de un producto de software.

Relacionado con la fiabilidad del código se observa un conteo de 61 bugs
teniendo esto una calificación de E por lo que sería prioritario atacar
al igual que los 32 problemas de seguridad reportados, así mismo se
reporta 1 vulnerabilidad. Por otro lado se observa un 14% de duplicidad
en el código lo cual es un indicio de malas prácticas de desarrollo.

### Vulnerabilidades

La vulnerabilidad encontrada corresponde a un tipo de inyección de
código malicioso a través de logs ya que la aplicación al no sanitizar
los datos logueados que viajan a través de la petición http le
permitiría a un atacante insertar datos arbitrarios en un log y así
insertar entradas de registro artificiales, a parte se podrían explotar
otras vulnerabilidades como cross-site scripting (XSS) o code injection
(Log4Shell).

### Problemas de seguridad

Aquí se encontraron 24 problemas relacionados a configuraciones inseguras
donde la mayoría pertenecían a la deshabilitación de características de
debug en entornos productivos ya que se identificaron prints de trazas
de error las cuales podrían llegar a incluir datos sensibles del entorno
de ejecución del programa. Por otra parte también se identificaron
algunos problemas con la creación de cookies la cual debe ser segura
para evitar ataques y explotación de alguna vulnerabilidad, así mismo
se identificó el uso de artefactos remotos en vistas html los cuales
pueden desencadenar en problemas de integridad que puede provocar la
ejecución inesperada de código malicioso en la aplicación.

### Bugs

A continuación se tiene un resumen de los principales bug encontrados.

La mayoría de los bug reportados pertenecen a vistas html donde se
tienen variables sin usar dentro de una vista al igual que se observa
la presencia de malas prácticas en este al tener atributos de la vista
estáticos lo cual no permite tener una vista responsiva, además se
observa el uso de elemento no nativos de html dentro de dicha vista.

```
<div id="toolbar5.checkin" data-dojo-type="dijit.form.Button" data-dojo-props='showLabel:true' onClick="window.location='checkin.html'">Checkin</div>

if (!(dijit.byId('street2AddressInput').value == '')) {
    customerData.address.streetAddress2 = dijit.byId('street2AddressInput').value;
}
```

Se encontraron bugs relacionados con el manejo de las conexiones a
base de datos y streams donde no se siguen las prácticas recomendadas
para la inicialización y cierre de la conexión así como el manejo de
posibles errores.

Relacionado con variables se encontraron una serie de malas prácticas
las cuales son las siguientes: variables mal nombradas que están
escritas bajo snake case, el uso de implantaciones de colecciones al
usar ArrayList directamente y no una interfaz como List, el no uso de
métodos como isEmpty(), y el no retorno de variables inmediatamente
son definidas.

### Code smells

A continuación se tiene un resumen de los principales code smells
encontrados que afectan la mantenibilidad.

En el analisis se encontraron reportes de mal nombramiento de variables,
código comentado, código duplicado en vez de definir constantes,
declaración de arrays de forma incorrecta, no uso de métodos
específicos para parsear variables a integers o booleanos,
uso no recomendado de inyección mediante atributos y no constructor,
manejo de excepciones genéricas y no específicas.

Complejidad cognitiva elevada al tener ifs anidados junto con
clicos lo que resulta en código como el siguiente.

```
for (int jj = 0; jj < airports.size(); jj++) {
    flightService.storeAirportMapping(airports.get(jj));
}
```

Número de parámetros exagerado en métodos y constructores como el siguiente

```
public FlightImpl(String id, String flightSegmentId,
    Date scheduledDepartureTime, Date scheduledArrivalTime,
    BigDecimal firstClassBaseCost, BigDecimal economyClassBaseCost,
    int numFirstClassSeats, int numEconomyClassSeats,
    String airplaneTypeId
)
```

En conclusion se evidencia una gran cantidad de code smells y malas
practicas en el proyecto las cuales pueden afectar la mantenibilidad y otro
atributos de calidad del producto, estos en gran medida se deben al
mal nombramiento de variables junto con metodos demasiado complejos o con parametros largos,
esto es indicio de un diseño incorrecto y falta de modularidad en la arquitectura.















