import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8084/';
  private url = this.baseUrl + 'api/users'

  constructor(private http: HttpClient,
    ) { }

  index(): Observable<User[]>{
    return this.http.get<User[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('todoService.index(): Error retrieving user list');
      })
    );
  }

}
