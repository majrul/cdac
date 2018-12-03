package com.cdac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dao.FlightDao;
import com.cdac.entity.Flight;

@Controller
public class AddFlightController {

	@Autowired
	private FlightDao dao;
	
	/*@RequestMapping(value="/addFlightController", method=RequestMethod.POST)
	public String add(HttpServletRequest request) {
		Flight flight = new Flight();
		flight.setFlightNo(Integer.parseInt(request.getParameter("flightNo")));
		flight.setCarrier(request.getParameter("carrier"));
		flight.setSource(request.getParameter("source"));
		flight.setDestination(request.getParameter("destination"));
		
		dao.add(flight);
		
		return "confirmation.html";
	}*/
	
	@RequestMapping(value="/addFlightController", method=RequestMethod.POST)
	public String add(Flight flight) {
		dao.add(flight);
		
		return "confirmation.html";
	}
}

/* this code is provided by spring:
 * the code for storing request data in an object
 
Flight f = new Flight();
f.setFlightNo(request.getParameter("flightNo"));
..
*/
