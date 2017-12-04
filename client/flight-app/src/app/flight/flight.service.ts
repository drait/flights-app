import { Injectable } from '@angular/core';

import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Flight } from '../models/flight';

@Injectable()
export class FlightService {
    private baseUrl = 'http://localhost:8080';

    constructor(private http: Http) { }

    getFlights(): Promise<Flight[]> {
        return this.http.get(this.baseUrl + '/api/flights/')
            .toPromise()
            .then(response => response.json() as Flight[])
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('Some error occured', error);
        return Promise.reject(error.message || error);
    }
}