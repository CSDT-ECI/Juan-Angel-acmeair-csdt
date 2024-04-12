package com.acmeair.morphia.repository;

import com.acmeair.entities.Booking;
import com.acmeair.morphia.entities.BookingImpl;
import com.acmeair.morphia.services.util.MongoConnectionManager;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRepositoryImpl implements BookingRepository{

    private Datastore datastore;

    public BookingRepositoryImpl() {
        datastore = MongoConnectionManager.getConnectionManager().getDatastore();
    }


    @Override
    public void saveBooking(Booking booking) {
        datastore.save(booking);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return datastore.find(BookingImpl.class).field("_id").equal(bookingId).get();
    }

    @Override
    public List<BookingImpl> getBookingsByUser(String user) {
        Query<BookingImpl> query = datastore.find(BookingImpl.class).disableValidation().field("customerId").equal(user);
        return query.asList();
    }

    @Override
    public void deleteBooking(String bookingId) {
        datastore.delete(BookingImpl.class, bookingId);
    }

    @Override
    public Long countAll() {
        return datastore.find(BookingImpl.class).countAll();
    }
}
