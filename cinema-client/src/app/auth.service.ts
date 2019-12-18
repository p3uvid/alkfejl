import { Injectable } from '@angular/core';
import { Employee } from './employee';
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
  employee: Employee;
  redirectUrl: string;

  private usersUrl = 'http://localhost:8080/employee';

  constructor(
    private http: HttpClient
  ) { }

  async login(username: string, password: string): Promise<Employee> {
    try {
      const token = btoa(`${username}:${password}`);
      httpOptions.headers = httpOptions.headers.set('Authorization', `Basic ${token}`);
      const user = await this.http.post<Employee>(`${this.usersUrl}/login`, {}, httpOptions).toPromise();
      this.isLoggedIn = true;
      this.employee = user;
      return Promise.resolve(this.employee);
    } catch (e) {
      console.log(e);
      return Promise.reject();
    }
  }
  
  logout() {
    httpOptions.headers = httpOptions.headers.set('Authorization', ``);
    this.isLoggedIn = false;
    this.employee = null;
  }
}
