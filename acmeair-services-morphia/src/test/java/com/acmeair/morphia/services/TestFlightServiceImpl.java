package com.acmeair.morphia.services;

import com.acmeair.entities.Flight;
import com.acmeair.entities.FlightSegment;
import com.acmeair.morphia.entities.FlightImpl;
import com.acmeair.morphia.entities.FlightSegmentImpl;
import com.acmeair.morphia.repository.FlightRepository;
import com.acmeair.morphia.repository.FlightSegmentRepository;
import com.acmeair.service.KeyGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestFlightServiceImpl {

    FlightRepository flightRepository = Mockito.mock(FlightRepository.class);

    FlightSegmentRepository flightSegmentRepository = Mockito.mock(FlightSegmentRepository.class);
    KeyGenerator generator = Mockito.mock(KeyGenerator.class);

    FlightServiceImpl flightService = new FlightServiceImpl(
            flightRepository,
            flightSegmentRepository,
            generator
    );


    @Test
    public void testShouldGetFlightById() {
        String flightId = "id";
        Date date = new Date(2024,12,01);
        BigDecimal cost = new BigDecimal(1);
        Flight flightExpected = getFlightExpected(flightId, date, cost);

        Mockito.when(flightRepository.getFlightById(flightId)).thenReturn(flightExpected);
        Flight flight = flightService.getFlight(flightId, "segment");

        Assertions.assertEquals(flightExpected,flight);
    }

    @Test
    public void testShouldGetFlightSegment() {
        String originPort = "origin";
        String destinePort = "destine";
        FlightSegment flightSegmentExpected = getFlightSegmentExpected(originPort, destinePort);

        Mockito.when(flightSegmentRepository.getFlightSegment(
                originPort,
                destinePort
                )).thenReturn(flightSegmentExpected);
        FlightSegment flightSegment = flightService.getFlightSegment(originPort,destinePort);

        Assertions.assertEquals(flightSegmentExpected, flightSegment);
    }

    @Test
    public void testShouldGetDefaultFlightSegment() {
        String originPort = "origin";
        String destinePort = "destine";
        FlightSegment flightSegmentExpected = new FlightSegmentImpl();

        Mockito.when(flightSegmentRepository.getFlightSegment(
                originPort,
                destinePort
        )).thenReturn(null);
        FlightSegment flightSegment = flightService.getFlightSegment(originPort,destinePort);

        Assertions.assertEquals(flightSegmentExpected, flightSegment);
    }


    @Test
    public void testShouldGetFlightBySegment() {
        String flightId = "id";
        String originPort = "origin";
        String destinePort = "destine";
        Date date = new Date(2024,12,01);
        BigDecimal cost = new BigDecimal(1);

        FlightSegment flightSegment = getFlightSegmentExpected(originPort, destinePort);
        Flight flight = getFlightExpected(flightId, date, cost);
        flight.setFlightSegment(flightSegment);
        List<FlightImpl> flightsExpected = Arrays.asList((FlightImpl) flight);

        Mockito.when(flightRepository.getFlightBySegment(flightSegment)).thenReturn(flightsExpected);
        List<Flight> flightsResult = flightService.getFlightBySegment(flightSegment, null);

        Assertions.assertEquals(flightsExpected,flightsResult);
    }

    @Test
    public void testShouldGetFlightBySegmentAndDeptDate() {
        String flightId = "id";
        String originPort = "origin";
        String destinePort = "destine";
        Date date = new Date(2024,12,01);
        BigDecimal cost = new BigDecimal(1);

        FlightSegment flightSegment = getFlightSegmentExpected(originPort, destinePort);
        Flight flight = getFlightExpected(flightId, date, cost);
        flight.setFlightSegment(flightSegment);
        List<FlightImpl> flightsExpected = Arrays.asList((FlightImpl) flight);

        Mockito.when(flightRepository.getFlightBySegmentAndDeptDate(flightSegment, date)).thenReturn(flightsExpected);
        List<Flight> flightsResult = flightService.getFlightBySegment(flightSegment, date);

        Assertions.assertEquals(flightsExpected,flightsResult);
    }


    @Test
    public void testShouldCreateFlight() {
        String flightId = "id";
        Date date = new Date(2024,12,01);
        BigDecimal cost = new BigDecimal(1);
        Flight flightExpected = getFlightExpected(flightId, date, cost);

        Mockito.when(generator.generate()).thenReturn(flightId);

        Flight flight = flightService.createNewFlight(
                "segment",
                date,
                date,
                cost,
                cost,
                1,
                1,
                "a"
        );

        Assertions.assertEquals(flightExpected,flight);
    }


    private static Flight getFlightExpected(String flightId, Date date, BigDecimal cost) {
        return new FlightImpl(
                flightId,
                "segment",
                date,
                date,
                cost,
                cost,
                1,
                1,
                "a"
        );
    }
    private static FlightSegment getFlightSegmentExpected(String originPort, String destinePort) {
        return new FlightSegmentImpl("name", originPort, destinePort, 1);
    }
}
