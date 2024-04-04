# Uso de herramientas de inteligencia artificial y frameworks de productividad
En esta sección se describirán los descubrimientos del
uso de herramientas de inteligencia artificial como
habilitadores para la mejora de la productividad y experiencia
del desarrollador en su trabajo diario, además de una análisis en términos
de las métricas de productividad de frameworks como DevEx y SPACE.

## Frameworks de productividad

Aqui se analizaran los frameworks de productividad DevEx y SPACE desde la perspectiva
de los puntos positivos, negativos, propuestas de mejora y métricas aplicables.

### Puntos positivos
*  Se ha implementado de una forma rápida y eficaz refactor en la arquitectura
de un servicio de negocio del proyecto, mejorando su desacoplamiento y mantenibilidad
así mismo, cumpliendo con estándares de buenas prácticas respecto a la inyección de dependencias.

* Se observa una mejora en la implementación de pruebas unitarias gracias a la sugerencia de código proporcionada
por github copilot, lo que permite una mejor cobertura de código y una mayor confianza en la calidad del software.

* Se realizó la integración con springboot para conseguir de esta manera un mejor manejo de inyección de dependencias y construcción de
la aplicación, lo que permite una mejor escalabilidad y mantenibilidad del proyecto al contar con un framework robusto y moderno,
facilitando a la vez la experiencia del desarrollador y la carga cognitiva del equipo.

* Se actualizó el archivo gradle para la integración con springboot y se realizaron ajustes en la arquitectura del proyecto para
cumplir con estándares de calidad y buenas prácticas, tanto a nivel de lógica de negocio como de testing. Mejorando así la calidad y
la mantenibilidad del proyecto al tener una curva de aprendizaje mas ligera la adaptación de nuevos desarrolladores,
teniendo así más generación de valor en un corto tiempo.


*  Al tener una mejor arquitectura separando la lógica de manejo de datos
en un repositorio se logra que el código sea más extensible y escalable,
facilitando a la vez la implementación de nuevas funcionalidades.


### Puntos negativos
* Se evidencia una falta de pruebas unitarias así como de pruebas de integración en el proyecto a lo largo de los demás servicios, lo que puede impactar la calidad
* Todavía se tiene una deuda técnica respecto a los refactors de arquitectura necesarios así como la solución de code smells reportados por 
herramientas como sonar.

* No se cuenta con pipelines de CI/CD para la automatización de pruebas y despliegues, esto tendría un impacto negativo en la
escalabilidad del proyecto y su mantenibilidad al tener desarrollos y despliegues lentos.


### Métricas a implementar

* Cantidad de code smells reportados por herramientas de análisis
estático de código para identificar posibles puntos de mejora y mantener un código
limpio y de calidad.

* Cobertura de pruebas unitarias, esto con el fin de medir el porcentaje de
código que está cubierto por pruebas unitarias o de integración, permitiendo tener
una mayor confianza en la calidad del software y tener una retroalimentación al instante.

* Frecuencia de despliegues, de esta forma se puede medir la eficiencia del equipo en la implementación y entrega de nuevas
  funcionalidades que generen valor al cliente, logrando identificar la productividad de un equipo y tener un feedback constante frente a los cambios.

* Tiempo de onboarding y carga cognitiva, esto con el fin de medir la facilidad de adaptación de nuevos desarrolladores al proyecto
  y la facilidad de comprensión del código, permitiendo tener una mayor eficiencia en la integración de nuevos miembros al equipo.

## Herramientas de inteligencia artificial

En esta parte se usó Github Copilot en este proyecto como
herramienta de apoyo para la realización de un refactor del servicio
[BookingServiceImpl.java](..%2Facmeair-services-morphia%2Fsrc%2Fmain%2Fjava%2Fcom%2Facmeair%2Fmorphia%2Fservices%2FBookingServiceImpl.java)
donde se realizaron ajustes para tener un código más limpio y desacoplado al tener una
mejor inyección de dependencias, además de manejar una mejor arquitectura
al usar repositorios para la lógica de persistencia de datos. Tanto los ajustes en el servicio como la creación del
repositorio se realizaron con la ayuda de Github Copilot. Además se usó
también en la creación de pruebas unitarias para el servicio refactorizado.

Después de la implementación completa del refactor se pudo
evidenciar la capacidad de Github Copilot para entender el contexto del
proyecto actual y sugerir código que se ajuste según el código existente y adaptarse
al contexto presente.

Un ejemplo del código sugerido por Github Copilot para un test unitario es el siguiente
donde se puede ver que es capaz de dar una buena sugerencia a pesar de algunos errores de tipo
o parámetros.


![copilot.png](img%2Fcopilot.png)

En conclusión es evidente el aporte que herramientas como estas
pueden dar a los desarrolladores para mejorar su productividad en
sus labores diarias como la implementación de test unitarios,
refactors, debugging y escritura de documentación técnica. Así mismo es
importante recalcar la labor de los desarrolladores en la validación del
código sugerido y tratar de aportar y complementar estas herramientas con su conocimiento
en casos bordes o posibles situaciones que introduzcan bugs.




