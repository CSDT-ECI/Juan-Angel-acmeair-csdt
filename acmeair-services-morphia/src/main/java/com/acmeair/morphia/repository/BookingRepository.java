package com.acmeair.morphia.repository;

import com.acmeair.entities.Booking;
import com.acmeair.morphia.entities.BookingImpl;

import java.util.List;

public interface BookingRepository {

    void saveBooking(Booking booking);

    Booking getBookingById(String bookingId);

    List<BookingImpl> getBookingsByUser(String user);

    void deleteBooking(String bookingId);

    Long countAll();
}
