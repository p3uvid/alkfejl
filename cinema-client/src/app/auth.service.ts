import { Injectable } from '@angular/core';
//import { Employee } from './employee';
import { HttpHeaders, HttpClient } from '@angular/common/http';

export const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': '',
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn = true;
  //employee: Employee;
  redirectUrl: string;

  //private usersUrl = 'http://localhost:8080/employees';

  constructor(
    private http: HttpClient
  ) { }

  async login(username: string, password: string): Promise<boolean> {
      return Promise.resolve(true);
    } catch (e) {
    }

}
