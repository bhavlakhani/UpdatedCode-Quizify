import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from './../../services/authentication.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router' ;
import { first } from 'rxjs/operators' ;
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../../tsclasses/user';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {
  @Input()
  private user1: User; // variable of class User
  private name: string;
  private password: string;
  isLoginError: boolean ;
  isLoggedIn = false ;
  user = this.fb.group({ // for reactive groups, we are creating form builder groups which is where we create
    // one group and add multiple properties
  name: ['', Validators.required],
  password: ['', Validators.required]
});

constructor(private fb: FormBuilder, private loginService: AuthenticationService
  , private router: Router) { } // using router
// to reroute valid logged in user to some other page
helper = new JwtHelperService();
helper1 = new JwtHelperService();

login() {
  this.user1 = new User();
  this.user1.name = this.name;
  this.user1.password = this.password;
  console.log('i am a user:' + ' ' + this.user1.name); // what u entered in the textbox
  console.log('my password is' + '' + this.user1.password);
  // console.log(this.user);
  this.loginService.login(this.user.value)
  .subscribe(res => {
  console.log('Res: ', res);
  console.log(this.helper.decodeToken(res.token).jti, ' :this is the value of the id');
  console.log(this.helper.decodeToken(res.token).sub, ' :this is the value of the role');
  console.log(this.helper.decodeToken(res.token).aud, ' :this is the value of the username');

    if ((this.helper.decodeToken(res.token).sub === 'admin' )) {
      localStorage.setItem('token' , res.token);
      this.router.navigate([`/adminpage`]);
      this.isLoggedIn = true;
    }
    if ((this.helper.decodeToken(res.token).sub === 'player' )) {
      this.helper1 = this.helper.decodeToken(res.token).aud ;
      console.log(' username value in token :' + this.helper1);
      console.log(' username value from textbox :' + this.user1.name);
       if ( this.helper.decodeToken(res.token).aud === this.user1.name) {
        localStorage.setItem('token' , res.token);
        console.log('token value is' + '' + res.token);
        this.router.navigate([`/cards`]); // it will route to single player engine
        this.isLoggedIn = true;
       }
      }
} ,
error => {
  console.log('wrong credentials');
  window.alert('wrong credentials');
});

}
}







// import { JwtHelperService } from '@auth0/angular-jwt';
// import { AuthenticationService } from './../../services/authentication.service';
// import { Component, OnInit, Input } from '@angular/core';
// import { Router } from '@angular/router' ;
// import { first } from 'rxjs/operators' ;
// import { HttpErrorResponse } from '@angular/common/http';
// import { FormBuilder, Validators } from '@angular/forms';
// import { User } from '../../tsclasses/user';
// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.scss']
// })
// export class LoginComponent  {
//   @Input()
//   private user1: User; // variable of class User
//   private username: string;
//   private password: string;
//   public isLoginError = false;
//  // isLoginError: boolean ;
//   isLoggedIn = false ;
//   user = this.fb.group({ // for reactive groups, we are creating form builder groups which is where we create
//     // one group and add multiple properties
//   username: ['', Validators.required],
//   password: ['', Validators.required]
// });

// constructor(private fb: FormBuilder, private loginService: AuthenticationService, private router: Router) { } // using router
// // to reroute valid logged in user to some other page
// helper = new JwtHelperService();
// helper1 = new JwtHelperService();
// login() {
//   this.user1 = new User();
//   this.user1.username = this.username;
//   this.user1.password = this.password;
//   // console.log('hai', this.user1);
//   console.log('i am a user:' + ' ' + this.user1.username);
//   console.log('my password is' + '' + this.user1.password);
//   // console.log(this.user);
//   this.loginService.login(this.user.value)
//   .subscribe(res => {
//   console.log('Res: ', res);
//   console.log(this.helper.decodeToken(res.token).jti, ' :this is the value of the username');
//   console.log(this.helper.decodeToken(res.token).sub, ' :this is the value of the role');
//      if ((this.helper.decodeToken(res.token).sub === 'admin' )) {
//       localStorage.setItem('token' , res.token);
//       this.router.navigate([`/adminpage`]);
//       this.isLoggedIn = true;
//     }
//     if ((this.helper.decodeToken(res.token).sub === 'player' )) {
//       this.helper1 = this.helper.decodeToken(res.token).jti ;
//       console.log('entered user :' + this.helper1);
//       console.log('entered user :' + this.user1.username);
//       if ( this.helper.decodeToken(res.token).jti === this.user1.username) {
//         localStorage.setItem('token' , res.token);
//         console.log('token value is' + '' + res.token);
//         this.router.navigate([`/cards`]);
//         this.isLoggedIn = true;
//        }
//       }
//  // else {
// // console.log('invalid username');
// // window.alert('invalid credential');
//     });
//   }
//   }
//       // (err: HttpErrorResponse) => {
//       //   console.log('there is some errorr!!!!!');
//       //   this.isLoginError = true;
//       // });
//     //   err => {
//     //     if (err.status === 401) {
//     //       this.isLoginError = true;
//     //         this.router.navigateByUrl('/login');
//     //   }
//     //       }





