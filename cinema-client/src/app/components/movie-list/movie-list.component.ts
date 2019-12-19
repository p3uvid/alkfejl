import { Component, OnInit } from '@angular/core';

import { Movie } from '../../classes/movie';
import { MovieService } from '../../services/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  movies: Movie[] = []

  constructor(
    private movieService: MovieService
  ) { }

  async ngOnInit() {
    this.movies = await this.movieService.getMovies();
  }

}
