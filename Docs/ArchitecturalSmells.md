## Architectural Smells

Para realizar un análisis de los arquitectural smells presentes en el proyecto,
se ha realizado un análisis de los componentes y módulos del proyecto usando el
plugin Designite para IntelliJ IDEA. Designite es una herramienta que permite identificar
malos olores en el código fuente de un proyecto, tales como malos nombres de clases, métodos demasiado largos, clases con muchos métodos, entre otros.
Además esta herramienta permite identificar patrones de diseño y anti-patrones la arquitectura del proyecto.

Luego de realizar el análisis sobre los distintos servicios y controladores que componen el
proyecto se identificaron malas prácticas en la cantidad de parámetros que reciben los métodos, por ejemplo en 
[FlightServiceImpl.java](..%2Facmeair-services-morphia%2Fsrc%2Fmain%2Fjava%2Fcom%2Facmeair%2Fmorphia%2Fservices%2FFlightServiceImpl.java)
donde el método `createNewFlight` recibe 8 parámetros, lo cual es una mala práctica, por otra parte respecto al diseño de
la arquitectura del proyecto la herramienta no identifico más problemas de arquitectura, esto debido a los refactors
que se han venido haciendo en términos de arquitectura, con el fin de reducir el acoplamiento y mejorar la cohesión de los distintos módulos del proyecto,
refactors que incluyen el desacoplamiento de la lógica de persistencia de los servicios al crear repositorios junto con
una inyección de dependencias usando Spring lo que permite abstraer dicha lógica de inyección.

En la siguiente imagen se puede obervar las recomendaciones dadas por Designite para el modulo `Fl
ightServiceImpl`:
![arq.png](img%2Farq.png)

Sin embargo se puede seguir mejorando la arquitectura del proyecto, por ejemplo se podrían aplicar prácticas de DDD para
tener un código más organizado y que sea guiado por el dominio del negocio, lo que mejora la mantenibilidad y evolución del proyecto.