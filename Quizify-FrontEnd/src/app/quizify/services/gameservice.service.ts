import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Game } from '../tsclasses/game';

​

@Injectable({

 providedIn: 'root'

})

export class GameserviceService {

​

 private url: string;

 private format: string;

 private game: Game;

​

 constructor(private http: HttpClient) {

  this.format = '&format=json';

  this.url = 'http://localhost:8092/game-manager-service/api/v1/';

​

  // this.tracksSubject = new BehaviorSubject(this.tracks);

 }

​

​

 fetchAllGames(categoryName: string, topicName: string) {

  return this.http

  .get(this.url + 'categories/' + categoryName + '/' + topicName, { observe: 'response' });

 }

​

 getGameService() {

  return this.http.get(`${this.url}/gameservice`);

 }

 getGameServiceById(id) {

  return this.http.get(`${this.url}/gameservice/${id}`);

 }

​

 addGame(game: Game) {

  console.log(game);

  const url2 = 'http://13.232.243.68:8092/game-manager-service/api/v1/games/game';

  return this.http

  .post(url2, game, { observe: 'response' });

 }

​

 updateAddedGame(game: Game) {

  return this.http

  .put(this.url + 'games/game', game, { observe: 'response' });

 }

​

 deleteGame(game: Game) {

  console.log( game);

  return this.http.delete(this.url + 'tracks/track/' + game, { observe: 'response' });

 }

}