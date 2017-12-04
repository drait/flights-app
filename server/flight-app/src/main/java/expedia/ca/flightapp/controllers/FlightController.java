package expedia.ca.flightapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import expedia.ca.flightapp.models.Flight;
import expedia.ca.flightapp.repositories.FlightRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flight> getAllFilghts() {
        return flightRepository.findAll();
    }

    @GetMapping(value="/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") String id) {
        Flight flight = flightRepository.findOne(id);
        if(flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }
    }
}