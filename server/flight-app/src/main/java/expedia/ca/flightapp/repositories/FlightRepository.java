package expedia.ca.flightapp.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import expedia.ca.flightapp.models.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

}