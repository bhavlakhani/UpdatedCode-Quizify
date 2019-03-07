import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { GameserviceService } from '../../services/gameservice.service';
import { Game } from '../../tsclasses/game';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Genre } from '../../tsclasses/genre';

// import { Topic } from '../pclasses/topic';
// import { GameserviceService } from './gameservice.service';
// import { Router } from '@angular/router';

export interface Types {
  value: string;
  viewValue: string;
}

export interface Levels {
  value: string;
  viewValue: string;
}

export interface Categories {
  value: string;
  viewValue: string;
}

export interface Topics {
  value: string;
  viewValue: string;
}

export interface Genres {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {

  // topic: Topic[] = [
  //   {value: 'Java', viewValue: 'Java'},
  //   {value: 'Python', viewValue: 'Python'},
  //   {value: 'C++', viewValue: 'C++'}
  // ];

  private types: Types[];
  private levels: Levels[];
  private categories: Categories[];
  private topics: Topics[];
  private genres: Genres[];

  private selectedCategory: string;
  private selectedTopic: string;
  private selectedGenre: string;

  private entertainment: Category;

  private movies: Topic;
  private tvShows: Topic;

  private documentary: Genre;
  private talkshow: Genre;
  private action: Genre;
  private thriller: Genre;
  private comedy: Genre;
  private anime: Genre;
  private romance: Genre;
  private drama: Genre;
  private scifi: Genre;
  private historical: Genre;

    private game: Game;
    private gamecategory: Category;
    private currentTopic: Topic;
    private selectedLevel = '';
    private questionNumber: number;
    private statusCode: number;
    private gameName: string;

    private timeDuration: number;



  constructor(private gameService: GameserviceService, private snackBar: MatSnackBar) {
    this.entertainment = new Category();
    this.entertainment.id = 1;
    this.entertainment.name = 'Entertainment';
    // tslint:disable-next-line:max-line-length
    this.entertainment.imageUrl = 'https://mitaanexpress.com/wp-content/uploads/2017/12/336fdcf7d540e4b430a890b63da159c9-1503648561-768x432.png';

        this.movies = new Topic();
        this.movies.id=1;
        this.movies.name='Movies';
        this.movies.imageUrl='https://image.freepik.com/free-vector/cinema-logo_23-2147503279.jpg?1';

        this.tvShows = new Topic();
        this.tvShows.id=2;
        this.tvShows.name='TV Shows';
        this.tvShows.imageUrl='https://tallypress.com/wp-content/uploads/2016/12/9-Popular-TV-shows-with-a-Malaysian-Flavour-1.jpg';

        this.documentary = new Genre();
        this.documentary.id=1;
        this.documentary.name='Documentary';
        this.documentary.imageUrl='https://www.filmsite.org/images/documentary-genre.jpg';

        this.talkshow = new Genre();
        this.talkshow.id=2;
        this.talkshow.name='Reality & Talk Shows';
        this.talkshow.imageUrl='https://cmkt-image-prd.global.ssl.fastly.net/0.1.0/ps/2661428/580/386/m1/fpnw/wm1/c1-.jpg?1494334679&s=b42e439d379c45825713ec1c3421f902';

        this.action = new Genre();
        this.action.id=3;
        this.action.name='Action';
        this.action.imageUrl='http://bcheights.com/wp-content/uploads/2017/04/isabella-column-online.jpg';

        this.thriller = new Genre();
        this.thriller.id=4;
        this.thriller.name='Thriller';
        this.thriller.imageUrl='https://image.slidesharecdn.com/thrillergenre-141005134450-conversion-gate01/95/thriller-genre-1-638.jpg?cb=1412606265';

        this.comedy = new Genre();
        this.comedy.id=5;
        this.comedy.name='Comedy';
        this.comedy.imageUrl='http://lionhearttheatre.org/wp-content/uploads/2016/01/download-14.jpg';

        this.anime = new Genre();
        this.anime.id=6;
        this.anime.name='Anime';
        this.anime.imageUrl='https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/intermediary/f/7d3e695a-edba-4591-84d3-c8fa7896170a/d477hhk-235dfbf8-1fb0-497b-b8d0-49df393ece70.jpg';

        this.romance = new Genre();
        this.romance.id=7;
        this.romance.name='Romance';
        this.romance.imageUrl='https://image.slidesharecdn.com/media-141105104952-conversion-gate02/95/romance-genre-powerpoint-1-638.jpg?cb=1415184629';

        this.drama = new Genre();
        this.drama.id=8;
        this.drama.name='Drama';
        this.drama.imageUrl='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMqK5BdSyRyCS8B5zTZ0AC3DYc0P4x2dRKMKLLbDUTGeOQPwDJ0g';

        this.scifi = new Genre();
        this.scifi.id=9;
        this.scifi.name='SciFi';
        this.scifi.imageUrl='https://www.indiewire.com/wp-content/uploads/2013/12/sci-fi-genre.jpg';

        this.historical = new Genre();
        this.historical.id=10;
        this.historical.name='Historical';
        this.historical.imageUrl='https://www.listchallenges.com/f/lists/87b065de-25d3-4020-800e-ba0434ecb908.jpg';

        this.levels = [
          {value: 'easy', viewValue: 'Easy'},
          {value: 'medium', viewValue: 'Medium'},
          {value: 'hard', viewValue: 'Hard'}
        ];

        this.categories = [
          {value: 'Entertainment', viewValue: 'Entertainment'},
        ];

        this.topics = [
          {value: 'Movies', viewValue: 'Movies'},
          {value: 'TV Shows', viewValue: 'TV Shows'}
        ];

        this.genres = [
          {value: 'Documentary', viewValue: 'Documentary'},
          {value: 'Reality & Talk Shows', viewValue: 'Reality & Talk Shows'},
          {value: 'Action', viewValue: 'Action'},
          {value: 'Thriller', viewValue: 'Thriller'},
          {value: 'Comedy', viewValue: 'Comedy'},
          {value: 'Anime', viewValue: 'Anime'},
          {value: 'Romance', viewValue: 'Romance'},
          {value: 'Drama', viewValue: 'Drama'},
          {value: 'SciFi', viewValue: 'SciFi'},
          {value: 'Historical', viewValue: 'Historical'}
        ];

   }

  ngOnInit() {
  }


  saveGames() {
    if (
      this.selectedLevel === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 500});
     } else {
      this.game = new Game();
      this.game.name =  this.gameName;
      switch(this.selectedCategory)
      {
        case 'Entertainment' :
        this.game.category = this.entertainment;
        break;
      }

      switch(this.selectedTopic)
      {
        case 'Movies' : 
        this.game.topic = this.movies;
        break;
        case 'TV Shows':
        this.game.topic = this.tvShows;
      }

      switch(this.selectedGenre)
      {

          case 'Documentary':
          this.game.genre = this.documentary;
          break;
          case 'Reality & Talk Shows':
          this.game.genre = this.talkshow;
          break;
          case 'Action':
          this.game.genre = this.action;
          break;
          case 'Thriller':
          this.game.genre = this.thriller;
          break;
          case 'Comedy':
          this.game.genre = this.comedy;
          break;
          case 'Anime':
          this.game.genre = this.anime;
          break;
          case 'Drama':
          this.game.genre = this.drama;
          break;
          case 'SciFi':
          this.game.genre = this.scifi;
          break;
          case 'Historical':
          this.game.genre = this.historical;
          break;
          case 'Romance':
          this.game.genre = this.romance;
          break;

      }
      this.game.level = this.selectedLevel;
      this.game.numOfQuestion = Number(this.questionNumber);
      this.game.playcount = 0;
      this.game.liked=0;
      this.game.timeDuration = this.timeDuration;
      console.log(this.game);
      this.addGame(this.game);
     }
  }
  addGame(game: Game) {
    this.gameService.addGame(game).subscribe(
      response => {
        this.statusCode = response.status;
        if (this.statusCode === 200) {
          console.log('Success', this.statusCode);
          this.snackBar.open('Question Successfully Saved !!!', '', {
            duration: 1500
          });
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 409) {
          this.snackBar.open('Question Already Saved !!!', '', {
            duration: 1500
          });
          this.statusCode = 0;
        }
    });

    // console.log(this.gameService.fetchAllGames(this.gamecategory.name, this.currentTopic.name));

  }

}
