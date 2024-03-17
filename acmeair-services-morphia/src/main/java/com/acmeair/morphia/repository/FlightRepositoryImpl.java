package com.acmeair.morphia.repository;

import com.acmeair.entities.AirportCodeMapping;
import com.acmeair.entities.Flight;
import com.acmeair.entities.FlightSegment;
import com.acmeair.morphia.entities.FlightImpl;
import com.acmeair.morphia.services.util.MongoConnectionManager;
import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class FlightRepositoryImpl implements FlightRepository{

    private Datastore datastore;

    public FlightRepositoryImpl() {
        datastore = MongoConnectionManager.getConnectionManager().getDatastore();
    }
    @Override
    public Flight getFlightById(String flightId) {
        return datastore.find(FlightImpl.class).field("_id").equal(flightId).get();
    }

    @Override
    public List<FlightImpl> getFlightBySegment(FlightSegment flightSegment) {
        return datastore.find(FlightImpl.class)
                .disableValidation()
                .field("flightSegmentId")
                .equal(flightSegment.getFlightName())
                .asList();
    }

    @Override
    public List<FlightImpl> getFlightBySegmentAndDeptDate(FlightSegment flightSegment, Date deptDate) {
        return datastore.find(FlightImpl.class)
                .disableValidation().field("flightSegmentId")
                .equal(flightSegment.getFlightName())
                .field("scheduledDepartureTime")
                .equal(deptDate)
                .asList();
    }

    @Override
    public void storeAirportCodeMapping(AirportCodeMapping airportCodeMapping) {
        datastore.save(airportCodeMapping);
    }

    @Override
    public void storeFlight(Flight flight) {
        datastore.save(flight);
    }
}
