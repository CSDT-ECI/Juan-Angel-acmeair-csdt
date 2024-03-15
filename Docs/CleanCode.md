## Observaciones de Clean Code :white_check_mark:

En este proyecto se están cumpliendo varias prácticas de clean code como lo puede ser
la no duplicidad ya que no se encuentra codigo duplicado a lo largo de los diferentes componentes,
componentes los cuales a su vez cumplen con principios de programación como el principio "S"
en los principios *SOLID*, donde dichos componentes tienen una responsabilidad clara y definida dentro
del contexto de negocio.

También se puede observar gracias a la estructura de paquetes que el proyecto
está enfocado en los diferentes componentes que construyen toda la aplicación,
evitando así código espagueti y de baja calidad. Dicha separación también permite tener
un código más mantenible y escalable, habilitando una arquitectura con bajo acoplamiento.
Esto se puede ver en componentes como las entidades, servicios y controladores donde se logra tener una simplicidad y abstracción.

Sin embargo, por otro lado hay prácticas que no se cumplen como la no abstracción en la capa
de persistencia, incompliendo la "D" de *SOLID*, esto se puede ver en la implementación de los diferentes servicios como
[FlightServiceImpl.java](..%2Facmeair-services-morphia%2Fsrc%2Fmain%2Fjava%2Fcom%2Facmeair%2Fmorphia%2Fservices%2FFlightServiceImpl.java)
donde se tiene un datastore el cual es inicializado dentro del mismo
servicio y se usan operaciones de manejo de datos dentro del mismo servicio estando acopladas esas lógicas, así mismo no se tiene unas practica correcta de inyección de dependencias, esto se puede ver en los distintos controladores donde se instancian los servicios mediante una clase ServiceLocator la cual depende de los beans definidos en vez de usar anotaciones que permitan esta inyección de una forma más transparente y sencilla

Por otro lado el código implementado no es testeable y se tienen malos estándares de nombramiento, por ejemplo
para definir un objeto de tipo *AirportCodeMapping* como acm, junto a esto se tienen clases como
[AcmeAirConstants.java](..%2Facmeair-common%2Fsrc%2Fmain%2Fjava%2Fcom%2Facmeair%2FAcmeAirConstants.java)
la cual es vacía e innecesaria.

A continuación se muestran extractos de código mostrando lo anterior

```
public void initialization() {	
    datastore = MongoConnectionManager.getConnectionManager().getDatastore();
}


protected  FlightSegment getFlightSegment(String fromAirport, String toAirport){
	Query<FlightSegmentImpl> q = datastore.find(FlightSegmentImpl.class).field("originPort").equal(fromAirport).field("destPort").equal(toAirport);
	FlightSegment segment = q.get();
	if (segment == null) {
		segment = new FlightSegmentImpl(); // put a sentinel value of a non-populated flightsegment 
	}
	return segment;
}
```
```
public AirportCodeMapping createAirportCodeMapping(String airportCode, String airportName){
    AirportCodeMapping acm = new AirportCodeMappingImpl(airportCode, airportName);
    return acm;
}
```

```
public class BookingsREST {

	private BookingService bs = ServiceLocator.instance().getService(BookingService.class);
```

Respecto a las prácticas de XP en este tipo de proyectos es de gran valor tener una
filosofía donde se priorice la mejora constante y el coraje para mantener proyecto actualizado,
esto mediante prácticas como el refactor y adopcion de estandares de código que permitan tener
un código mantenible y de calidad el cual se mantenga simple, así mismo es bastante
importante tener mecanismos de integración continua que garanticen la funcionalidad y testeabilidad del código.

