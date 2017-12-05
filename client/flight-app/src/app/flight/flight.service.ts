import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Flight } from '../models/flight';


@Injectable()
export class FlightService {
    private baseUrl = 'http://localhost:4200';

    constructor(private http: Http) { }

    searchFlights(departure: string): Observable<Flight[]> {
        return this.http.get(this.baseUrl + '/api/flights/' + departure)
        .map(response => {
            const data = response.json().data;
            return data;
        });
    }

    private handleError(error: any): Promise<any> {
        console.error('Some error occured', error);
        return Promise.reject(error.message || error);
    }
}
