import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';

import { GameEngineService } from '../../services/game-engine.service';

import { Game } from '../../tsclasses/game';

import { ActivatedRoute } from '@angular/router';

import * as jwt_decode from 'jwt-decode';

import { User } from '../../tsclasses/user';

import { LoginToken } from '../../tsclasses/login-token';

import { SinglePlayer } from '../../tsclasses/single-player';
import { Question } from '../../tsclasses/question';
import { MatStepper } from '@angular/material/stepper';
import { MatSnackBar, MatChip } from '@angular/material';

@Component({

  selector: 'app-game-engine',

  templateUrl: './game-engine.component.html',

  styleUrls: ['./game-engine.component.scss'],
  encapsulation: ViewEncapsulation.None

})

export class GameEngineComponent implements OnInit {

  @Input() gameId: number;

  loginToken: LoginToken;

  jti: number;

  private singlePlayer: SinglePlayer;

  private game: Game;
  private questions: Question[];
  private firstQuestion: boolean;
  private endQuestion: boolean;


  constructor( 
    private route: ActivatedRoute,
    private gameengineservice: GameEngineService,
    private snackBar: MatSnackBar
    ) { }
  ngOnInit() {
    this.singlePlayer = new SinglePlayer();
    this.route.params.subscribe((data: any) => {
      this.gameId = data.id;
      console.log(this.gameId);
      try {
        const tokenObtained = localStorage.getItem('token');
        this.loginToken = jwt_decode(tokenObtained);
        console.log('decoded token', jwt_decode(tokenObtained));
        this.jti = this.loginToken.jti;
        console.log('decoded token id', this.loginToken.jti);
        this.gameengineservice.fetchGame(this.gameId , this.jti).subscribe((res: any) => {
          this.singlePlayer.playerId = res.jti;
          this.game = res.game;
          
        } );
      } catch (error) {
        this.jti = 123;
        this.gameengineservice.fetchGame(this.gameId , this.jti).subscribe((res: any) => {
          console.log(res);
          this.singlePlayer.playerId = res.body.playerId;
          this.game = res.body.game;
          console.log(this.game);

          this.questions = this.game.questions;
          this.firstQuestion = true;
          this.endQuestion = false;
        });
      }
    });
  }

  checkStepper(stepper: MatStepper) {
    if(stepper.selectedIndex+1 === 1)
      this.firstQuestion = true;
    else
      this.firstQuestion = false;

    if(stepper.selectedIndex+1 === this.game.numOfQuestion)
      this.endQuestion = true;
    else
      this.endQuestion = false;
  }

  selectdAnswer(questionNumber: number, optionNumber: number, chip: MatChip) {
    console.log(chip);
    chip.color = "primary";
    
    console.log(chip);
    if(this.questions[questionNumber].correctAnswer.trim() === this.questions[questionNumber].options[optionNumber].trim())
    {
      this.snackBar.open('Correct Answer !', '', {
        duration: 1500
      });
    }
    else
    {
      // chip.classList.add('wrong-answer');
      this.snackBar.open('Wrong Answer !', '', {
        duration: 1500
      });
    }

  }


}
