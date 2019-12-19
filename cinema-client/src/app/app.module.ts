import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {
  MatToolbarModule, 
  MatButtonModule, 
  MatIconModule,
  MatListModule,
  MatButtonToggleModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule
} from '@angular/material';

//import { AppRoutingModule } from './app-routing.module';
import { RoutingModule } from './routing/routing.module';

import { AppComponent } from './app.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { HttpClientModule } from '@angular/common/http';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import { ScreeningComponent } from './components/screening/screening.component';
import { MovieEditComponent } from './components/movie-edit/movie-edit.component';
import { BookingComponent } from './components/booking/booking.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SuccessComponent } from './components/success/success.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { BookingPrivateComponent } from './components/booking-private/booking-private.component';
import { LoginComponent } from './components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    MainPageComponent,
    MovieDetailComponent,
    ScreeningComponent,
    MovieEditComponent,
    BookingComponent,
    SuccessComponent,
    BookingPrivateComponent,
    LoginComponent
  ],
  imports: [
    NgbModule,
    BrowserModule,
    //AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule, 
    MatButtonModule, 
    MatIconModule,
    MatListModule,
    MatButtonToggleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    RoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
