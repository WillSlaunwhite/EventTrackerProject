import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8084/';
  // private url = this.baseUrl + 'api/users'

  constructor(private http: HttpClient) { }

  login(username: string, password:string) {
    const credentials = this.generateBasicUserCredentials(username, password);
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest',
      }),
    };

    return this.http.get(this.baseUrl + 'authenticate', httpOptions).pipe(
      tap((res) => {
        localStorage.setItem('credentials', credentials);
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.login(): Error logging in.');
      })
    );
  }

  register(user: User) {
    return this.http.post(this.baseUrl + 'register', user).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.register(): Error registering user.');
      })
    );
  }


  generateBasicUserCredentials(username: string, password: string) {
    return btoa(`${username}:${password}`);
  }

  getCredentials() {
    return localStorage.getItem('credentials');
  }

  logout() {
    localStorage.removeItem('credentials');
  }

  checkLogin() {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }

}
