package com.cdac.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking {

	@Id
	//@GeneratedValue
	private int pnrNo; //pk
	
	private Date bookingDate;
	private String kahase;
	private String kahatak;
	private double fees;
	
	@OneToMany
	private Set<Passenger> passengers;

	public int getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getKahase() {
		return kahase;
	}

	public void setKahase(String kahase) {
		this.kahase = kahase;
	}

	public String getKahatak() {
		return kahatak;
	}

	public void setKahatak(String kahatak) {
		this.kahatak = kahatak;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
