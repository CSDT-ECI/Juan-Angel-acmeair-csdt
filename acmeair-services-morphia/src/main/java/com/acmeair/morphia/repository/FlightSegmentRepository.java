package com.acmeair.morphia.repository;

import com.acmeair.entities.FlightSegment;

public interface FlightSegmentRepository {

    FlightSegment getFlightSegment(String fromAirport, String toAirport);

    void saveFlightSegment(FlightSegment flightSegment);
}
