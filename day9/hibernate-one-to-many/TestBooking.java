package com.cdac.test;

import java.util.Date;

import org.junit.Test;

import com.cdac.dao.BookingAndPassengerDao;
import com.cdac.entity.Booking;
import com.cdac.entity.Passenger;

public class TestBooking {

	@Test
	public void testBookingATicket() {
		Booking booking = new Booking();
		booking.setPnrNo(1234567890);
		booking.setBookingDate(new Date());
		booking.setFees(2500);
		booking.setKahase("Mumbai");
		booking.setKahatak("Goa");
	
		Passenger passenger1 = new Passenger();
		passenger1.setName("Sherin");
		passenger1.setAge(99);
		passenger1.setBooking(booking);
		
		Passenger passenger2 = new Passenger();
		passenger2.setName("Pratik");
		passenger2.setAge(999);
		passenger2.setBooking(booking);
		
		BookingAndPassengerDao dao = new BookingAndPassengerDao();
		dao.addBooking(booking);
		dao.addPassenger(passenger1);
		dao.addPassenger(passenger2);
	}
}
