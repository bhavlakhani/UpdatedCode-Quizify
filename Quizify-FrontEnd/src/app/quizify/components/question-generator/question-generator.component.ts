import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { QuestionService } from '../../services/question.service';
import { Question } from '../../tsclasses/question';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Genre } from '../../tsclasses/genre';

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
  selector: 'app-question-generator',
  templateUrl: './question-generator.component.html',
  styleUrls: ['./question-generator.component.css']
})
export class QuestionGeneratorComponent implements OnInit {
  private types: Types[];
  private levels: Levels[];
  private categories: Categories[];
  private topics: Topics[];
  private genres: Genres[];


  private selectedType = '';

  private tfStatement = '';
  private tfselectedOption = '';
  private tfselectedLevel = '';

  private mcqStatement = '';
  private mcqOption1 = '';
  private mcqOption2 = '';
  private mcqOption3 = '';
  private mcqOption4 = '';
  private mcqSelectedOption = '';
  private mcqSelectedLevel = '';

  private statusCode: number;

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

  private question: Question;


  constructor(private questionService: QuestionService, private snackBar: MatSnackBar) {

    this.entertainment = new Category();
    this.entertainment.id = 1;
    this.entertainment.name='Entertainment';
    this.entertainment.imageUrl='https://mitaanexpress.com/wp-content/uploads/2017/12/336fdcf7d540e4b430a890b63da159c9-1503648561-768x432.png';

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

        this.types = [
          {value: 'mcq', viewValue: 'Multiple Choice'},
          {value: 't/f', viewValue: 'True / False'}
        ];

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

  saveTFQuestion() {
    if (
      this.tfStatement === '' ||
      this.tfselectedOption === '' ||
      this.tfselectedLevel === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 1500});
     } else {
      
      this.question = new Question();
      this.question.id = Date.now();
      switch(this.selectedCategory)
      {
        case 'Entertainment' :
        this.question.category = this.entertainment;
        break;
      }

      switch(this.selectedTopic)
      {
        case 'Movies' : 
        this.question.topic = this.movies;
        break;
        case 'TV Shows':
        this.question.topic = this.tvShows;
      }

      switch(this.selectedGenre)
      {

          case 'Documentary':
          this.question.genre = this.documentary;
          break;
          case 'Reality & Talk Shows':
          this.question.genre = this.talkshow;
          break;
          case 'Action':
          this.question.genre = this.action;
          break;
          case 'Thriller':
          this.question.genre = this.thriller;
          break;
          case 'Comedy':
          this.question.genre = this.comedy;
          break;
          case 'Anime':
          this.question.genre = this.anime;
          break;
          case 'Drama':
          this.question.genre = this.drama;
          break;
          case 'SciFi':
          this.question.genre = this.scifi;
          break;
          case 'Historical':
          this.question.genre = this.historical;
          break;
          case 'Romance':
          this.question.genre = this.romance;
          break;

      }
      this.question.level = this.tfselectedLevel;
      this.question.type = this.selectedType;
      this.question.statement = this.tfStatement;
      this.question.options = new Array();
      this.question.options[0] = 'true';
      this.question.options[1] = 'false';
      this.question.correctAnswer = this.tfselectedOption;
      console.log(this.question);
      this.saveQuestion(this.question);
     }
  }

  saveMcqQuestion() {
    if (
      this.mcqStatement === '' ||
      this.mcqOption1 === '' ||
      this.mcqOption2 === '' ||
      this.mcqOption3 === '' ||
      this.mcqOption4 === '' ||
      this.mcqSelectedOption === '' ||
      this.mcqSelectedLevel === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 1500});
     } else {
      this.question = new Question();
      this.question.id = Date.now();
      switch(this.selectedCategory)
      {
        case 'Entertainment' :
        this.question.category = this.entertainment;
        break;
      }

      switch(this.selectedTopic)
      {
        case 'Movies' : 
        this.question.topic = this.movies;
        break;
        case 'TV Shows':
        this.question.topic = this.tvShows;
      }

      switch(this.selectedGenre)
      {

          case 'Documentary':
          this.question.genre = this.documentary;
          break;
          case 'Reality & Talk Shows':
          this.question.genre = this.talkshow;
          break;
          case 'Action':
          this.question.genre = this.action;
          break;
          case 'Thriller':
          this.question.genre = this.thriller;
          break;
          case 'Comedy':
          this.question.genre = this.comedy;
          break;
          case 'Anime':
          this.question.genre = this.anime;
          break;
          case 'Drama':
          this.question.genre = this.drama;
          break;
          case 'SciFi':
          this.question.genre = this.scifi;
          break;
          case 'Historical':
          this.question.genre = this.historical;
          break;
          case 'Romance':
          this.question.genre = this.romance;
          break;

      }
      this.question.level = this.tfselectedLevel;
      this.question.type = this.selectedType;
      this.question.statement = this.tfStatement;
      this.question.options = new Array();
      this.question.options[0] = this.mcqOption1;
      this.question.options[1] = this.mcqOption2;
      this.question.options[2] = this.mcqOption3;
      this.question.options[3] = this.mcqOption4;
      if (this.mcqSelectedOption === 'mcqOption1') {
        this.question.correctAnswer = this.mcqOption1;
      } else if (this.mcqSelectedOption === 'mcqOption2') {
        this.question.correctAnswer = this.mcqOption2;
      } else if (this.mcqSelectedOption === 'mcqOption3') {
        this.question.correctAnswer = this.mcqOption3;
      } else {
        this.question.correctAnswer = this.mcqOption4;
      }
      console.log(this.question);
      this.saveQuestion(this.question);
     }
  }


  saveQuestion(question: Question) {
    this.questionService.saveQestion(question).subscribe(
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
  }

}
