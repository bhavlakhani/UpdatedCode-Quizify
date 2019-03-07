import { Topic } from './../../tsclasses/topic';
// import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms';
import { Register } from '../../tsclasses/register';
import { Genre } from '../../tsclasses/genre';
import {ErrorStateMatcher} from '@angular/material/core';
// import {PasswordMaterialUi} from "password-material-ui";

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
 }


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {

  formGroup2: FormGroup;
  // tslint:disable-next-line:no-inferrable-types
  // isOptional: boolean = false;
  formGroup1: FormGroup;
  formGroup3: FormGroup;
  formGroup4: FormGroup;
  userForm: any;
  value1: String;
  hide = true;
  // disabled = false;
  // ShowFilter = false;
  // limitSelection = false;

  selectedItems: any = [];
 // dropdownSettings: any = {};

  @Input()
  register: Register;
  private name: string;
  private password: string;
  private emailId: string;
  private topiclist:  Array<Topic> = [];
  private genrelist:  Array<Genre> = [];
  private gender: string;
  matcher = new MyErrorStateMatcher();

  private topicsList: Array<Topic> = [];
  private genresList: Array<Genre> = [];
  private selectedTopic:  Array<Topic> = [];
  private selectedGenre: Array<Genre> = [];

  @ViewChild('myStep') myStep;
  myForm: FormGroup;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);


  // tslint:disable-next-line:max-line-length
  constructor(private _formBuilder: FormBuilder, private regserv: RegisterService,  private http: HttpClient) {
 }
 submit(event: any) {
  this.register = new Register();
  this.register.name = this.name;
  this.register.password = this.password;
  this.register.topics = this.topiclist;
  this.register.genres = this.genrelist;
  this.register.gender = this.gender;
  this.register.emailId = this.emailId;
 // this.register.confirmPassword = this.confirmPassword;
   console.log(this.register);
  this.value1 = event.target.value;
  this.regserv.addUser(this.register).subscribe((data: any) => {
   console.log('user data', data);
  });

}
  ngOnInit() {
    this.formGroup1 = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.formGroup2 = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.formGroup3 = this._formBuilder.group({
      thirdCtrl: ['', Validators.required]
    });
    this.formGroup4 = this._formBuilder.group({
      fourCtrl: ['', Validators.required]
    });

    this.regserv.getTopic().subscribe((res: any) => {
      this.topicsList = res;
      console.log(res);
    });

    this.regserv.getGenre().subscribe((res: any) => {
      this.genresList = res;
      console.log(res);
      // console.log(this.genreList);
    });
  }

  addTopic(value) {
    this.topiclist.push(value);
    console.log(value);
  }


  addGenre(value) {
    this.genrelist.push(value);
    console.log(value);
  }

  display() {
    console.log(this.topiclist);
    console.log(this.genrelist);
    this.selectedGenre = this.genrelist;
    this.selectedTopic = this.topiclist;
  }

}
