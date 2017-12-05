import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MatButtonModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { FlightComponent } from './flight/flight.component';
import { FlightService } from './flight/flight.service';

@NgModule({
    declarations: [
        AppComponent,
        FlightComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        HttpModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule
    ],
    providers: [FlightService],
    bootstrap: [AppComponent]
})
export class AppModule { }
