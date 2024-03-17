## Observaciones de testing :test_tube:

Se encontro que este proyecto no contaba con pruebas unitarias en sus
componentes por lo que fue necesario realizar una serie de
pasos para lograr añadir pruebas unitarias usando librerias
que permitan su creacion de una forma sencilla y rapida.

### Refactor necesario para agregar pruebas unitarias

1. El primer paso fue añadir las dependencias de Junit y Mockito
al proyecto con el fin de crear las pruebas unitarias y poder
mockear los componentes externos, garantizando de esta forma
la prueba de la logica de negocio exclusivamente. Para esto fue
necesario actualizar la version de gradle hasta la version permitida
por Java 8.
2. Luego fue necesario realizar un refactor en el servicio que se queria probar
ya que este tenia un acoplamiento con la capa de persistencia,
dicho acoplamiento se resolvio con la creacion de una interfaz que defina los
metodos del repositorio y la clase que la implemente sea la responsable de
construir los metodos de la logica de persistencia. Para este desacoplamiento
tambien se utilizo Spring como herramienta de inyeccion de dependencias, donde
fue necesario agregar la dependencia con la version correcta de acuerdo
a la version de gradle y Java, y de esta manera evitar erorres al
construir la aplicacion.
3. Teniendo Spring y el repositorio inyectado se procede con la creacion
de las pruebas unitarias usando Mockito como herramienta para manejar
los mocks y poder realizar unas pruebas unitarias correctas y de calidad.
