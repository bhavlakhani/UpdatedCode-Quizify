import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { Question } from '../tsclasses/question';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdminQuestionService {
  private errorStatus: string;
  private baseUrl: string;


  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8001/api/v1/questions';
   }

   saveQuestion(question: any) {
    return this.http.post(this.baseUrl+'/question',question, { observe: 'response' })
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
