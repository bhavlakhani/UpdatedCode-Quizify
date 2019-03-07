import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Game } from '../tsclasses/game';

@Injectable({
  providedIn: 'root'
})
export class AdminGameService {
  private game: Game;
  private games: Array<Game>;
  private gamesSubject: BehaviorSubject<Game[]>;
  private errorStatus: string;
  private baseUrl: string;

  constructor(private http: HttpClient) {
    // this.baseUrl = 'http://13.232.243.68:8092/game-manager-service/api/v1/game';
    this.baseUrl = 'http://localhost:8092/game-manager-service/api/v1/games';
  }

  getAllGames() {
    // this.games = [];
    // this.gamesSubject = new BehaviorSubject(this.games);
    // this.http.get(this.baseUrl).subscribe((res: any[]) => {
    //   this.gamesSubject.next(res);
    //   // console.log(this.gamesSubject);
    // });
    // return this.gamesSubject;

    return this.http
    .get(this.baseUrl, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  deleteGame(game: Game) {
    // // this.http.delete();
    // this.http.delete('http://0.0.0.0:8106/api/v1/search/'+game.topic.name+'/'+game.genre.name+'/'+game.id, { observe: 'response' })
    // .pipe(catchError(this.handleError));
    // console.log('http://0.0.0.0:8106/api/v1/search/'+game.topic.name+'/'+game.genre.name+'/'+game.id);
    return this.http.delete(this.baseUrl+'/game/'+game.id, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  saveGame(game: Game) {
    return this.http.post(this.baseUrl+'/game',game, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  updateGame(game: Game) {
    console.log(game);
    return this.http.put(this.baseUrl+'/game',game, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  getGame(gameId: number) {
    return this.http.get(this.baseUrl+'/game/'+gameId, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.log('An error occured :', error.error.message);
    } else {
      this.errorStatus = `${error.status}`;
    }
    return throwError(this.errorStatus);
  }
}
