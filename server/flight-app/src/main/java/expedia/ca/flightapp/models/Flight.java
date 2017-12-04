package expedia.ca.flightapp.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "flights")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class Flight {
	@Id
	private String id;
	@NotBlank
	private String flight;
	@NotBlank
	private String departure;

	public Flight() {
		super();
	}

	public Flight(String flight) {
		this.flight = flight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeaprture(String departure) {
		this.departure = departure;
	}

	@Override
	public String toString() {
		return String.format("Flight[flight='%s', departure='%s']", flight, departure);
	}
}