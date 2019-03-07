import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, from } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private microServiceUrl: string;
  private errorStatus: string;
  private errorBody: string;



  constructor(private http: HttpClient) {
    this.microServiceUrl = 'http://13.232.243.68:8092/search-service/api/v1/search/';
   }

  //  saveGenre(genre: string) {
  //    return this.http.post(this.microServiceUrl + 'search-genre', { observe: 'response' })
  //    .pipe(catchError(this.handleError));
  //  }

  //  searchByGenreStartsWith(genreName: string) {

  //   console.log(this.microServiceUrl + 'search-genre/' + genreName);
  //    return this.http.get(this.microServiceUrl + 'search-genre/' + genreName, { observe: 'response' })
  //    .pipe(catchError(this.handleError));
  //  }

  //  saveTopic(genre: string) {
  //   return this.http.post(this.microServiceUrl + 'search-topic', { observe: 'response' })
  //   .pipe(catchError(this.handleError));
  // }

  searchByTopicOrGenreOrQuizStartsWith(searchKey: string) {
    console.log(this.microServiceUrl + searchKey);
    return this.http.get(this.microServiceUrl + searchKey, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.log('An error occured :', error.error.message);
    } else {
      this.errorStatus = `${error.status}`;
      console.log('Error msg', this.errorStatus);
      this.errorBody = `${error.error}`;
      console.log(
        `Backened returned code ${error.status},` + `body was :${error.error}`
      );
    }

    return throwError(this.errorStatus);
  }
}
