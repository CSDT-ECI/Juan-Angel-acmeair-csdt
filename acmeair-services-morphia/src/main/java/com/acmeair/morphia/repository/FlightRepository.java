package com.acmeair.morphia.repository;

import com.acmeair.entities.AirportCodeMapping;
import com.acmeair.entities.Flight;
import com.acmeair.entities.FlightSegment;
import com.acmeair.morphia.entities.FlightImpl;

import java.util.Date;
import java.util.List;

public interface FlightRepository {

    Flight getFlightById(String flightId);

    List<FlightImpl> getFlightBySegment(FlightSegment flightSegment);

    List<FlightImpl> getFlightBySegmentAndDeptDate(FlightSegment flightSegment, Date deptDate);

    void storeAirportCodeMapping(AirportCodeMapping airportCodeMapping);

    void storeFlight(Flight flight);
}
