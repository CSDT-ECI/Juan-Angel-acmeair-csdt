## Observaciones de deuda técnica y refactor :chart_with_upwards_trend:

Se realizo un analisis del proyecto con el objetivo de identificar
falencias del proyecto en terminos de deuda tecnica y calidad.
Dando como resultado una serie de recomendaciones las cuales se enuncian a continucion:

### Estructura del proyecto :construction_worker:
- [ ] La estructura del proyecto puede llegar a ser confusa y dificultará el navegar entre
  archivos por lo que si es posible seria mas comodo tener una estructura del tipo
  `src/java/com/acmeair` en la raíz del proyecto

### Tecnologías utilizadas :wrench:

- [x] Se utilizan tecnologías como WebSphere Liberty y WebSphere eXtreme Scale las cuales
  dificultarian el proceso de despliegue y extensión, por lo que se removerian los
  componentes que están acoplados a esta tecnología.

- [ ] Se utilizaria un framework moderno de programación de aplicaciones web como spring

- [ ] Se observa la inicialización de componentes mediante `new`, por lo cual se usarían anotaciones
  como `Component` y `Autowired`, mejorando así la inyección de dependencias

- [ ] Al manejar una inyección de dependencias y una correcta inicialización de la aplicación spring
  no sería necesario el uso de beans y un módulo de carga de esos como service locator

- [ ] Se observa lógica de persistencia de datos dentro de la lógica de negocio, por lo que debería separarse y abstraerse

- [ ] Se observan que los endpoint no tienen un nombramiento adecuado que permita un versionamiento

- [ ] Se observa nombramiento de variables no descriptivas como `bs` para bookingService

- [ ] Se observa una falta de documentación a nivel de endpoints y apis expuestas


### Pruebas :test_tube:
- [ ] No hay pruebas unitarias que prueben las funcionalidades clave del proyecto