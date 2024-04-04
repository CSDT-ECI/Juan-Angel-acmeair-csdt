package com.acmeair.morphia.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.acmeair.morphia.repository.BookingRepository;
import org.mongodb.morphia.Datastore;

import com.acmeair.entities.Booking;
import com.acmeair.entities.Customer;
import com.acmeair.entities.Flight;
import com.acmeair.morphia.MorphiaConstants;
import com.acmeair.morphia.entities.BookingImpl;
import com.acmeair.morphia.services.util.MongoConnectionManager;
import com.acmeair.service.BookingService;
import com.acmeair.service.CustomerService;
import com.acmeair.service.DataService;
import com.acmeair.service.FlightService;
import com.acmeair.service.KeyGenerator;
import com.acmeair.service.ServiceLocator;

import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DataService(name=MorphiaConstants.KEY,description=MorphiaConstants.KEY_DESCRIPTION)
public class BookingServiceImpl implements BookingService, MorphiaConstants {

	//private final static Logger logger = Logger.getLogger(BookingService.class.getName()); 

	Datastore datastore;

	@Autowired
	BookingRepository bookingRepository;
	
	@Inject 
	KeyGenerator keyGenerator;
	
	@Autowired
	private FlightService flightService;

	@Autowired
	private CustomerService customerService;

	public BookingServiceImpl(BookingRepository bookingRepository,
							  FlightService flightService,
							  CustomerService customerService,
							  KeyGenerator keyGenerator)
	{
		this.bookingRepository = bookingRepository;
		this.flightService = flightService;
		this.customerService = customerService;
		this.keyGenerator = keyGenerator;
	}

	public BookingServiceImpl() {
	}

	@PostConstruct
	public void initialization() {	
		datastore = MongoConnectionManager.getConnectionManager().getDatastore();	
	}	


	public String bookFlight(String customerId, String flightId) {
		try{
			Flight flight = flightService.getFlightByFlightId(flightId, null);
			Customer customer = customerService.getCustomerByUsername(customerId);
			String key = keyGenerator.generate().toString();
			
			Booking newBooking = new BookingImpl(key, new Date(), customer, flight);
			bookingRepository.saveBooking(newBooking);

			return newBooking.getBookingId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String bookFlight(String customerId, String flightSegmentId, String flightId) {
		return bookFlight(customerId, flightId);	
	}
	
	@Override
	public Booking getBooking(String user, String bookingId) {
		try{
			return bookingRepository.getBookingById(bookingId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Booking> getBookingsByUser(String user) {
		try{
			List<BookingImpl> bookingImpls = bookingRepository.getBookingsByUser(user);
            return new ArrayList<Booking>(bookingImpls);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void cancelBooking(String user, String bookingId) {
		try{
			bookingRepository.deleteBooking(bookingId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public Long count() {
		return bookingRepository.countAll();
	}	
}
