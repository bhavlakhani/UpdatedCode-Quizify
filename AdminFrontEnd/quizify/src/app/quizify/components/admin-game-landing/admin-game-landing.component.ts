import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AdminGameService } from '../../services/admin-game.service';
import { Game } from '../../tsclasses/game';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-game-landing',
  templateUrl: './admin-game-landing.component.html',
  styleUrls: ['./admin-game-landing.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class AdminGameLandingComponent implements OnInit {
  // private game: Game;
  private games: Array<Game>;
  statusCode: number;

  constructor(private adminGameService: AdminGameService, private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    this.adminGameService.getAllGames().subscribe((res: any) => {
      this.games = [];
      // console.log(res);
      this.games = res.body;
    });
  }

  deleteGame(game) {
    console.log(game);
    this.adminGameService.deleteGame(game).subscribe(
      response => {
        this.statusCode = response.status;
        if (this.statusCode === 200) {
          console.log('Success', this.statusCode);
          this.snackBar.open('Question Successfully Deleted !!!', '', {
            duration: 1500
          });
          this.adminGameService.getAllGames().subscribe((res: any) => {
            this.games = [];
            this.games = res.body;
          });
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 404) {
          this.snackBar.open('Question Not Found !!!', '', {
            duration: 1500
          });
          this.statusCode = 0;
        }
    });
  }

  editGame(id) {
    this.router.navigate(['edit-game', {gameId : id}]);
  }

}
