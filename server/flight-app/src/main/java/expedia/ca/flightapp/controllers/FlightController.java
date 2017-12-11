package expedia.ca.flightapp.controllers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import expedia.ca.flightapp.models.Flight;
import expedia.ca.flightapp.repositories.FlightRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FlightController {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	@GetMapping("/flights")
	public List<Flight> getAllFilghts() {
		return flightRepository.findAll();
	}

	@GetMapping(value = "/search/flights/")
	public List<Flight> searchFlights(@PathVariable("departure") String departure) {

		String hour = "07:30 AM";
		// 1. convert the user input to a valid local time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		LocalTime departureTime = LocalTime.parse(hour, formatter);

		// 2. calculate the Min/Max departure times (in secondes) for database lookup
		int departureTimeMin = departureTime.minusHours(5).toSecondOfDay();
		int departureTimeMax = departureTime.plusHours(5).toSecondOfDay();

		// 3. build the query and issue it against the MongoDB database
		Query query = new Query();
		query.addCriteria(Criteria.where("timestamp").lt(departureTimeMax).gt(departureTimeMin));
		List<Flight> flights = mongoTemplate.find(query, Flight.class);

		return flights;

	}
}