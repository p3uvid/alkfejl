import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Input } from '@angular/core';

import { MovieService } from '../../services/movie.service';
import { Screening } from '../../classes/screening';

@Component({
  selector: 'app-screening',
  templateUrl: './screening.component.html',
  styleUrls: ['./screening.component.css']
})
export class ScreeningComponent implements OnInit {
  id: number;
  screenings: Screening[] = []

  constructor(
    private route: ActivatedRoute,
    private movieService: MovieService
  ) { }

  async ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.id = +id;
      //todo: mielőtt ezt lekérdezzük, meg kell nézni, hogy van-e ilyen id-jú film
      //ne lehessen olyan, hogy .../booking/11 -> 404 error
      this.screenings = await this.movieService.getScreenings(this.id);
    }
  }

}
