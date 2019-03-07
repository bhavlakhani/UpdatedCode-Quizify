import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { BehaviorSubject, throwError } from 'rxjs';

import { catchError } from 'rxjs/operators';

import { Question } from '../tsclasses/question';

​

@Injectable({

 providedIn: 'root'

})

export class QuestionService {

​

 private microServiceUrl: string;

​

 private question: Question;

 private quetsions: Array<Question>;

 private quetsionsSubject: BehaviorSubject<Question[]>;

​

 private errorMsg: string;

 private errorStatus: string;

 private errorBody: string;

​

 constructor(private http: HttpClient) {

  this.microServiceUrl = 'http://localhost:8092/question-manager-service/api/v1/';

  }

​

  saveQestion(question: Question) {

   console.log(question);

   return this.http

  .post(this.microServiceUrl + 'questions/question', question, { observe: 'response' })

  .pipe(catchError(this.handleError));

  }

​

  fetchAllQuestions(categoryName: string, topicName: string) {

   return this.http

  .get(this.microServiceUrl + 'categories/' + categoryName + '/' + topicName, { observe: 'response' })

  .pipe(catchError(this.handleError));

  }

​

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

​

  return throwError(this.errorStatus);

 }

​

}
