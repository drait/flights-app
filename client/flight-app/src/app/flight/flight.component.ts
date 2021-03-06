import { Component, OnInit } from '@angular/core';
import { FlightService } from './flight.service';
import { Flight } from '../models/flight';
import { Subscription } from 'rxjs/Subscription';

@Component({
    selector: 'app-flight',
    templateUrl: './flight.component.html'
})
export class FlightComponent implements OnInit {
    flights: Flight[];
    departure: string;

    constructor(private FlightService: FlightService) {
    }

    ngOnInit(): void {
    }

    searchFlights(): void {
        this.FlightService.searchFlights(this.departure).subscribe(response => {
            this.flights = response;
        });
    }
}
