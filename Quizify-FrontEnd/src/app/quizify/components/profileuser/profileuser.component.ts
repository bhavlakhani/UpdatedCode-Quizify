// import { Profile } from 'selenium-webdriver/firefox';
import { OnInit, Input, Component } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { Profile } from '../../tsclasses/profile';

@Component({
  selector: 'app-profileuser',
  templateUrl: './profileuser.component.html',
  styleUrls: ['./profileuser.component.scss']
})
export class ProfileUserComponent implements OnInit {

  register: any = [];
 
  @Input()
 
  reg: any;
 
  loginToken:Profile;
 
  jti: any;
 
  constructor(private services: RegisterService) { }
 
  ngOnInit() {
 
   try {
 
    const tokenObtained = localStorage.getItem('token');
 
    // this.loginToken = jwt_decode(tokenObtained);
 
    // console.log('decoded token', jwt_decode(tokenObtained));
 
    this.jti = this.loginToken.jti;
 
    console.log('decoded token id', this.loginToken.jti);
 
    this.services.profile(this.jti).subscribe(data => {
 
     this.reg = data;
 
     // console.log(res);
 
     console.log( this.reg);
 
    });
 
    } catch (error) {
 
     console.log(error);
 
    }
 
   }
 
  }