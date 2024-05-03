## Observaciones de testing :test_tube:

Se encontró que este proyecto no contaba con pruebas unitarias en sus
componentes por lo que fue necesario realizar una serie de
pasos para lograr añadir pruebas unitarias usando librerías
que permitan su creación de una forma sencilla y rápida.

### Refactor necesario para agregar pruebas unitarias

1. El primer paso fue añadir las dependencias de Junit y Mockito
   al proyecto con el fin de crear las pruebas unitarias y poder
   mockear los componentes externos, garantizando de esta forma
   la prueba de la lógica de negocio exclusivamente. Para esto fue
   necesario actualizar la version de gradle hasta la versión permitida
   por Java 8.
2. Luego fue necesario realizar un refactor en el servicio que se quería probar
   ya que este tenía un acoplamiento con la capa de persistencia,
   dicho acoplamiento se resolvió con la creación de una interfaz que defina los
   métodos del repositorio y la clase que la implemente sea la responsable de
   construir los métodos de la lógica de persistencia. Para este desacoplamiento
   también se utilizó Spring como herramienta de inyección de dependencias, donde
   fue necesario agregar la dependencia con la versión correcta de acuerdo
   a la version de gradle y Java, y de esta manera evitar errores al
   construir la aplicación.
3. Teniendo Spring y el repositorio inyectado se procede con la creación
   de las pruebas unitarias usando Mockito como herramienta para manejar
   los mocks y poder realizar unas pruebas unitarias correctas y de calidad.


