import { Component, OnInit } from '@angular/core';
import { FlightService } from './flight.service';
import { Flight } from '../models/flight';
import { Subscription } from 'rxjs/Subscription';

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
    }

    searchFlights(): void {
        this.FlightService.searchFlights().subscribe(response => {
            this.flights = response;
        });
    }
}
