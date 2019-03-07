import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { SearchService } from '../../services/search.service';
import { Router } from '@angular/router';
import { CardService } from '../../services/card.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private cardService: CardService ,
     private searchService: SearchService, public router: Router) { }

  ngOnInit() {

  }
  fetchGameId(gameId: number) {
    console.log('it is game Id', gameId);
    this.router.navigate(['playgame', {id : gameId}]);
    // this.gameengineservice.fetchGame(gameId);
   }


}
