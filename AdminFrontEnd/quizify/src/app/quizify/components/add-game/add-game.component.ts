import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Genre } from '../../tsclasses/genre';
import { JsonService } from '../../services/json.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatStepper, MatSnackBar } from '@angular/material';
import { Game } from '../../tsclasses/game';
import { AdminGameService } from '../../services/admin-game.service';
import { ActivatedRoute } from '@angular/router';

export interface Levels {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddGameComponent implements OnInit {
  private category: Category;
  private categories: Category[];
  private topic: Topic;
  private topics: Topic[];
  private genre: Genre;
  private genres: Genre[];

  private selectedCategory: Category;
  private selectedTopic: Topic;
  private selectedGenre: Genre;
  private selectedLevel: string;
  private gameName: string;
  private gameImageUrl: string;
  private questionNumber: string;
  private timeDuration: string;


  private gameFormGroup: FormGroup;
  private levels: Levels[];
  private rules: string[];

  private game: Game;
  private statusCode: number;

  private isUpdate: boolean;
  

  constructor(
    private jsonServer: JsonService,
    private _formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private gameService: AdminGameService,
    private route: ActivatedRoute
    ) { }

  ngOnInit() {

    this.route.params.subscribe((data: any) => {
      if (data.gameId !== undefined)
      {
        this.gameService.getGame(data.gameId).subscribe((res: any) => {
          this.game = res.body;
          this.selectedCategory = this.game.category;
          this.selectedTopic = this.game.topic;
          this.selectedGenre = this.game.genre;
          this.selectedLevel = this.game.level;
          this.gameName = this.game.name;
          this.gameImageUrl = this.game.imageUrl;
          this.questionNumber = ''+this.game.numOfQuestion;
          this.timeDuration = ''+this.game.timeDuration;

          this.gameFormGroup.setValue({
            selectedLevel: this.selectedLevel,
            gameName: this.gameName,
            gameImageUrl: this.gameImageUrl,
            questionNumber: this.questionNumber,
            timeDuration: this.timeDuration
          });
          
        });

        this.isUpdate = true;
      }
      else 
      {
        this.selectedCategory = new Category();
        this.selectedTopic = new Topic();
        this.selectedGenre = new Genre();
        this.selectedLevel = '';
        this.gameName = '';
        this.gameImageUrl = '';
        this.questionNumber = '';
        this.timeDuration = '';

        this.isUpdate = false;
      }
      
    });

    this.jsonServer.getCategoryFromJsonServer().subscribe((res: any[]) => {
      this.categories = res;
    });

    this.jsonServer.getTopicFromJsonServer().subscribe((res: any[]) => {
      this.topics = res;
    });

    this.jsonServer.getGenreFromJsonServer().subscribe((res: any[]) => {
      this.genres = res;
    });

    this.levels = [
      {value: 'easy', viewValue: 'Easy'},
      {value: 'medium', viewValue: 'Medium'},
      {value: 'hard', viewValue: 'Hard'}
    ];

    this.gameFormGroup = this._formBuilder.group({
      gameName: ['', Validators.required],
      gameImageUrl: ['', Validators.required],
      selectedLevel: ['', Validators.required],
      questionNumber: ['', Validators.required],
      timeDuration: ['', Validators.required]
    });

    this.rules = [];
    this.rules.push('Each Question will have Multiple Options.');
    this.rules.push('Among them only one Option is Correct.');
    this.rules.push('Player can\'t move to Next Question until an Option has been Selected.');
    this.rules.push('Player can change Selected Option.');
    this.rules.push('After timeout Game-Window will be automatically closed.');
  }

  checkCategory(stepper: MatStepper) {
    if (this.selectedCategory.name !== undefined)
      stepper.selectedIndex = 1;
    else
    this.snackBar.open('Please Select A Category !', '', {
      duration: 1500
    });
  }

  checkTopic(stepper: MatStepper) {
    if (this.selectedTopic.name !== undefined)
      stepper.selectedIndex = 2;
    else
    this.snackBar.open('Please Select A Topic !', '', {
      duration: 1500
    });
  }

  checkGenre(stepper: MatStepper) {
    if (this.selectedGenre.name !== undefined)
      stepper.selectedIndex = 3;
    else
    this.snackBar.open('Please Select A Genre !', '', {
      duration: 1500
    });
  }

  checkDetails(stepper: MatStepper) {
    if (
      this.gameFormGroup.get('gameName').value !== '' &&
      this.gameFormGroup.get('gameImageUrl').value !== '' &&
      this.gameFormGroup.get('selectedLevel').value !== '' &&
      this.gameFormGroup.get('questionNumber').value !== '' &&
      this.gameFormGroup.get('timeDuration').value !== ''
      )
      {
        this.gameName = this.gameFormGroup.get('gameName').value;
        this.gameImageUrl = this.gameFormGroup.get('gameImageUrl').value;
        this.selectedLevel = this.gameFormGroup.get('selectedLevel').value;
        this.questionNumber = this.gameFormGroup.get('questionNumber').value;
        this.timeDuration = this.gameFormGroup.get('timeDuration').value;
        stepper.selectedIndex = 4;
      }
    else
    this.snackBar.open('Please Give all Game Details !', '', {
      duration: 1500
    });

  }

  saveGame(stepper: MatStepper) {
    if(this.isUpdate) {
    this.game.name = this.gameName;
    this.game.category = this.selectedCategory;
    this.game.topic = this.selectedTopic;
    this.game.genre = this.selectedGenre;
    this.game.level = this.selectedLevel;
    this.game.imageUrl = this.gameImageUrl;
    this.game.numOfQuestion = Number.parseInt(this.questionNumber);
    this.game.timeDuration = Number.parseInt(this.timeDuration);
      this.gameService.updateGame(this.game).subscribe(
        (response: any) => {
          this.statusCode = response.status;
          if (this.statusCode === 200) {
            console.log('Success', this.statusCode);
            this.snackBar.open('Game Successfully Updated !!!', '', {
              duration: 1500
            });
            stepper.selectedIndex = 5;
          }
        },
        err => {
          const errorStatus = err;
          this.statusCode = parseInt(errorStatus, 10);
          if (this.statusCode === 404) {
            this.snackBar.open('Game Dosen\'t Exists', '', {
              duration: 1500
            });
            this.statusCode = 0;
          }
      });
      this.isUpdate = false;
      
    }
    else {
      this.game = new Game();
    this.game.id = 0;
    this.game.name = this.gameName;
    this.game.category = this.selectedCategory;
    this.game.topic = this.selectedTopic;
    this.game.genre = this.selectedGenre;
    this.game.tag = null;
    this.game.level = this.selectedLevel;
    this.game.imageUrl = this.gameImageUrl;
    this.game.numOfQuestion = Number.parseInt(this.questionNumber);
    this.game.questions = null;
    this.game.timeDuration = Number.parseInt(this.timeDuration);
    this.game.liked = 0;
    this.game.playCount = 0;
    this.game.rules = this.rules;
      this.gameService.saveGame(this.game).subscribe(
        (response: any) => {
          this.statusCode = response.status;
          if (this.statusCode === 200) {
            console.log('Success', this.statusCode);
            this.snackBar.open('Game Successfully Saved !!!', '', {
              duration: 1500
            });
            stepper.selectedIndex = 5;
          }
        },
        err => {
          const errorStatus = err;
          this.statusCode = parseInt(errorStatus, 10);
          if (this.statusCode === 409) {
            this.snackBar.open('Game Already Exists', '', {
              duration: 1500
            });
            this.statusCode = 0;
          }
      });


    }


  }

  numberOnly(event)
  {   
    const k = event.charCode;  //         k = event.keyCode;  (Both can be used)
    return k >= 48 && k <= 57; 
  }
  

}
