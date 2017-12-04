import { Component, OnInit } from '@angular/core';
import { FlightService } from './flight.service';
import { Flight } from '../models/flight';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {
  flights: Flight[];
  departure: string;

  constructor(private FlightService: FlightService) {
  }

  ngOnInit(): void {
    this.getFlights();
  }

  getFlights(): void {
    this.FlightService.getFlights()
      .then(flights => this.flights = flights);
  }
}
