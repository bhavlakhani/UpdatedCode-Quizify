import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JsonService {

  constructor(private http: HttpClient) { }

  getCategoryFromJsonServer()
  {
    return this.http.get('http://localhost:3000/category');
  }

  getTopicFromJsonServer()
  {
    return this.http.get('http://localhost:3000/topic');
  }

  getGenreFromJsonServer()
  {
    return this.http.get('http://localhost:3000/genre');
  }

}
