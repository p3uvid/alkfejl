import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MainPageComponent } from "../main-page/main-page.component";
import { MovieListComponent } from "../movie-list/movie-list.component";
import { MovieDetailComponent } from "../movie-detail/movie-detail.component";
import { MovieEditComponent } from "../movie-edit/movie-edit.component";
import { ScreeningComponent } from '../screening/screening.component';
import { BookingComponent } from '../booking/booking.component';
import { SuccessComponent } from '../success/success.component';
import { BookingPrivateComponent } from '../booking-private/booking-private.component';
import { AuthGuard } from '../auth.guard';
import { LoginComponent } from '../login/login.component';

const routes: Routes = [
  {
    path: '',
    component: MainPageComponent
  },
  {
    path: 'movies',
    component: MovieListComponent
  },
  {
    path: 'movies/add',
    component: MovieEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'movies/:id',
    component: MovieDetailComponent
  },
  {
    path: 'movies/:id/edit',
    component: MovieEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'screenings/:id', //vetítések listája az ilyen id-jú filmre
    component: ScreeningComponent
  },
  {
    path: 'screenings',
    redirectTo: '/'
  },
  {
    path: 'booking/private',
    component: BookingPrivateComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'booking/:id', //helyfoglalás az ilyen id-jú vetítésre
    component: BookingComponent
  },
  {
    path: 'booking',
    redirectTo: '/'
  },
  {
    path: 'success',
    component: SuccessComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
