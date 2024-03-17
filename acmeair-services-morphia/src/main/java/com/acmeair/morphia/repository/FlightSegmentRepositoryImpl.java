package com.acmeair.morphia.repository;

import com.acmeair.entities.FlightSegment;
import com.acmeair.morphia.entities.FlightSegmentImpl;
import com.acmeair.morphia.services.util.MongoConnectionManager;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

@Service
public class FlightSegmentRepositoryImpl implements FlightSegmentRepository{

    private Datastore datastore;

    public FlightSegmentRepositoryImpl() {
        datastore = MongoConnectionManager.getConnectionManager().getDatastore();
    }
    @Override
    public FlightSegment getFlightSegment(String fromAirport, String toAirport) {
        Query<FlightSegmentImpl> q = datastore.find(FlightSegmentImpl.class).field("originPort").equal(fromAirport).field("destPort").equal(toAirport);
        return q.get();
    }
}
