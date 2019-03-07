import { Component, OnInit } from '@angular/core';
import { RouterLink, ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor( private router: Router) { }
   ngOnInit() {
   }
  openProfileMenu() {
    this.router.navigate(['profile']);
  }
  openDetails() {
    this.router.navigate(['profileuser']);
  }
  openHistory() {
    this.router.navigate(['gamehistory']);
  }
}
