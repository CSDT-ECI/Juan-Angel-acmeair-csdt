package com.acmeair.morphia.services;

import com.acmeair.entities.Booking;
import com.acmeair.morphia.entities.BookingImpl;
import com.acmeair.morphia.entities.CustomerImpl;
import com.acmeair.morphia.entities.FlightImpl;
import com.acmeair.morphia.repository.BookingRepository;
import com.acmeair.service.CustomerService;
import com.acmeair.service.FlightService;
import com.acmeair.service.KeyGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestBookingServiceImpl {

    BookingRepository bookingRepository = Mockito.mock(BookingRepository.class);

    FlightService flightService = Mockito.mock(FlightService.class);

    CustomerService customerService = Mockito.mock(CustomerService.class);
    KeyGenerator generator = Mockito.mock(KeyGenerator.class);

    BookingServiceImpl bookingService = new BookingServiceImpl(
            bookingRepository,
            flightService,
            customerService,
            generator
    );

    @Test
    public void testShouldGetBookingById() {
        String bookingId = "id";
        Booking bookingExpected = getBookingExpected(bookingId);

        Mockito.when(bookingRepository.getBookingById(bookingId)).thenReturn(bookingExpected);
        Booking booking = bookingService.getBooking("user", bookingId);

        Assertions.assertEquals(bookingExpected, booking);
    }

    @Test
    public void testShouldGetBookingsByUser() {
        String user = "user";
        BookingImpl bookingExpected = (BookingImpl) getBookingExpected("id");

        Mockito.when(bookingRepository.getBookingsByUser(user)).thenReturn(Arrays.asList(bookingExpected));
        List<Booking> bookings = bookingService.getBookingsByUser(user);

        Assertions.assertEquals(1, bookings.size());
        Assertions.assertEquals(bookingExpected, bookings.get(0));

    }

    @Test
    public void testShouldDeleteBooking() {
        String bookingId = "id";
        String user = "user";

        bookingService.cancelBooking(user, bookingId);

        Mockito.verify(bookingRepository).deleteBooking(bookingId);
    }

    @Test
    public void testShouldBookFlight() {
        String customerId = "customerId";
        String flightId = "flightId";
        String BookingId = "1";
        Booking bookingExpected = getBookingExpected(BookingId);

        Mockito.when(flightService.getFlightByFlightId(flightId, null)).thenReturn(new FlightImpl());
        Mockito.when(customerService.getCustomerByUsername(customerId)).thenReturn(new CustomerImpl());
        Mockito.when(generator.generate()).thenReturn(BookingId);

        String bookingId = bookingService.bookFlight(customerId, flightId);

        Assertions.assertEquals(bookingExpected.getBookingId(), bookingId);
    }

    public Booking getBookingExpected(String bookingId) {
        return new BookingImpl(bookingId, new Date(), "customerId", "flightId");
    }
}
