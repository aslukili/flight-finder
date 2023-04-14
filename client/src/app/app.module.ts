import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatListModule,
  MatNativeDateModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {TicketService} from './service/ticket.service';
import {TicketTableComponent} from './ticket-table/ticket-table.component';
import {TicketFormComponent} from './ticket-form/ticket-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CityService} from './service/city.service';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { RouterModule } from '@angular/router';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    TicketTableComponent,
    TicketFormComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent
  ],
  imports: [
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatNativeDateModule,
    MatToolbarModule,
    MatTableModule,
    MatProgressSpinnerModule,
    RouterModule,
    RouterModule.forRoot([]),
  ],
  providers: [
    TicketService, 
    CityService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
