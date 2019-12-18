import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from "./auth.service";

import { Movie } from './movie';
import { Screening } from './screening';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private movieUrl = 'http://localhost:8080/movie';

  constructor(
    private http: HttpClient
  ) { }

  getMovies(): Promise<Movie[]> {
    return this.http.get<Movie[]>(
      this.movieUrl,
      httpOptions
    ).toPromise();
  }

  getMovie(id: number): Promise<Movie> {
    return this.http.get<Movie>(
      `${this.movieUrl}/${id}`,
      httpOptions
    ).toPromise();
  }

  modifyMovie(id: number, movie: Movie): Promise<Movie> {
    return this.http.put<Movie>(
      `${this.movieUrl}/${id}`,
      movie,
      httpOptions
    ).toPromise();
  }

  addMovie(movie: Movie): Promise<Movie> {
    return this.http.post<Movie>(
      this.movieUrl,
      movie,
      httpOptions
    ).toPromise();
  }

  getScreenings(id: number): Promise<Screening[]> {
    return this.http.get<Screening[]>(
      `${this.movieUrl}/${id}/screenings`,
      httpOptions
    ).toPromise();
  }

  deleteMovie(id: number): Promise<Movie> {
    return this.http.delete<Movie>(
      `${this.movieUrl}/${id}`,
      httpOptions
    ).toPromise();
  }
}
