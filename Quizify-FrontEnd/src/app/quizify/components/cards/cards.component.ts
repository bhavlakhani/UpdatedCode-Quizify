import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core' ;
import { GameEngineService } from '../../services/game-engine.service';
import { RootContext } from '@angular/core/src/render3/interfaces/view';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { DialogComponent } from '../dialog/dialog.component';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {


  constructor(private cardService: CardService , private gameengineservice: GameEngineService, private searchService: SearchService,
    private router: Router, public dialog: MatDialog) { }
  method: any;
  quiz: any;
  dialogResult: any;

  ngOnInit() {
    for (let i = 0; i < 2; i++) {
    this.cardService.getquiz().subscribe(resposeQuiz => this.quiz = resposeQuiz);
    }
  }
  fetchGameId(gameId: number) {
    console.log(gameId);
    this.router.navigate(['playgame', {id : gameId}]);
   }

   openDialog(q) {
    const dialogRef = this.dialog.open(DialogComponent,  {
      data: { q }
   });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.dialogResult = result;
    });
  }
}
