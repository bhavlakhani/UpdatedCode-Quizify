import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) {
  }

  private loginUrl = 'http://localhost:8095/api/user';  // URL to web api


  login(user: any): Observable<any> {
      return this.http.post<any>(this.loginUrl, user);
  }
  logout() {
    console.log('i have entered in the logout function');
    localStorage.removeItem('token');
    this.router.navigate([`/cards`]);  // after logging out ,it should redirect to homepage
  }

  setCookie(cname: string, cvalue: string, exdays: number) {
      const date = new Date();
      date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
      const expires = `expires=${date.toUTCString()}`;
      document.cookie = `${cname}=${cvalue};${expires};path=/`;
  }

  getCookie(cname: string) {
      const name = cname + '=';
      const ca = document.cookie.split(';');
      for (let i = 0; i < ca.length; i++) {
          let c = ca[i];
          while (c.charAt(0) === ' ') {
              c = c.substring(1);
          }
          if (c.indexOf(name) === 0) {
              return c.substring(name.length, c.length);
          }
      }
      return '';
  }

  deleteCookie(cname: string) {
      document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
}
  // 'No-Auth': 'True' '&grant_type=password
  // userAuthentication(userId, password) {
  //   console.log(userId + '' + password);
  //   const data = 'userId= ' + userId + '&password=' + password ;
  //   const reqHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post('http://13.232.243.68:8095/api/user' , data, { headers: reqHeader });
}
  // loginUser(userId: string, password: string ) {
  //   console.log('be confident jasss');
  //   this.http.post(this.url , {userId: userId, password: password})
  //   .subscribe((resp: any) => {
  //   /// this.router.navigate(['profile']);
  //     localStorage.setItem('auth_token', resp.token);
  //     console.log('auth_token');
  //     });
  // }


    // userId: string, password: string
    // return this.http.post<any>('http://13.232.243.68:8095/api/user', {userId: userId, password: password, role: 'user'})
    //    // this is just the HTTP call,
    //    // we still need to handle the reception of the token
    //    // .shareReplay();
    //    .pipe(map(user => {
    //        // login successful if there's a jwt token in the response
    //        if (user && user.token) {
    //            // store user details and jwt token in local storage to keep user logged in between page refreshes
    //            localStorage.setItem( 'currentUserId', userId);
    //            localStorage.setItem('currentUser', JSON.stringify(user));
    //            localStorage.setItem('role', 'user');
    //        }
    //        return user;
    //    }));


