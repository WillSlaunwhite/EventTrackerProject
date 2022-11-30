import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { DatePipe } from '@angular/common';
import { Bet } from '../models/bet';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class BetService {
  constructor(private http: HttpClient, private datePipe: DatePipe) {}
  // private baseUrl = 'http://localhost:8084/';
  // private url = this.baseUrl + 'api/bets';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/bets'


  index(): Observable<Bet[]> {
    return this.http.get<Bet[]>(this.url).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('betService.index(): Error retrieving bet list');
      })
    );
  }

  show(id: number): Observable<Bet> {
    return this.http.get<Bet>(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('betService.show(): Error getting Bet');
      })
    );
  }

  create(bet: Bet): Observable<Bet> {
    bet.completed = false;
    return this.http.post<Bet>(this.url, bet).pipe(
      catchError((err: any) => {
        console.log(err);
        console.log(bet.wagerDate);
        console.log(bet.deadlineDate);
        return throwError('betService.create(): error creating Bet');
      })
    );
  }

  update(bet: Bet) {
    if (bet.completed) {
      bet.completeDate = this.datePipe.transform(Date.now(), 'shortDate');
    } else if (!bet.completed) {
      bet.completeDate = null;
    }
    return this.http.put<Bet>(`${this.url}/${bet.id}`, bet).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('betService.update(): Error updating Bet');
      })
    );
  }

  destroy(id: number) {
    return this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('betService.destroy(): Error deleting Bet');
      })
    );
  }
}
