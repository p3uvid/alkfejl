import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../../services/movie.service';
import { Movie } from '../../classes/movie';
import { Location } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'movie-edit',
  templateUrl: './movie-edit.component.html',
  styleUrls: ['./movie-edit.component.css']
})

export class MovieEditComponent implements OnInit, OnChanges {

  id: number = null;
  // movie: Movie = new Movie();
  pageTitle = 'Új film'

  movieForm = this.fb.group({
    title: ['', [Validators.required]],
    description: ['', [Validators.required]],
    director: ['', [Validators.required]],
    actors: ['', [Validators.required]],
    genre: ['', [Validators.required]],
    age_limit: ['', [Validators.required, Validators.pattern(/[+0-9]*/)]],
    playtime: ['', [Validators.required, Validators.pattern(/[+0-9]*/)]],
    premier: ['', [Validators.required]],
  });

  @Input() movie: Movie;
  @Output() save = new EventEmitter<Movie>();

  get title() { return this.movieForm.get('title'); }
  get description() { return this.movieForm.get('description'); }
  get director() { return this.movieForm.get('director'); }
  get actors() { return this.movieForm.get('actors'); }
  get genre() { return this.movieForm.get('genre'); }
  get age_limit() { return this.movieForm.get('age_limit'); }
  get playtime() { return this.movieForm.get('playtime'); }
  get premier() { return this.movieForm.get('premier'); }

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private movieService: MovieService,
    private location: Location,
    private router: Router
  ) { }

  async ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.id = +id;
      this.movie = await this.movieService.getMovie(this.id);
      this.movieForm.patchValue(this.movie);
      this.pageTitle = 'Film szerkesztése';
    }
  }

  ngOnChanges() {
    this.movieForm.patchValue(this.movie);
  }

  async onSubmit(movie: Movie) {
    if (this.id) {
      await this.movieService.modifyMovie(this.id, movie)
      this.location.back();
    } else {
      let movie = new Movie()
      this.save.emit(
        Object.assign(movie, this.movieForm.value)
      );
      await this.movieService.addMovie(movie);
      this.router.navigate(['/movies']);
    }
  }
}
