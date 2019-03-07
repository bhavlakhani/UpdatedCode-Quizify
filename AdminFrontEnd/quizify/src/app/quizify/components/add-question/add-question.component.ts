import { Component, OnInit } from '@angular/core';
import { JsonService } from '../../services/json.service';
import { FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Genre } from '../../tsclasses/genre';
import { Question } from '../../tsclasses/question';
import { AdminQuestionService } from '../../services/admin-question.service';

export interface Levels {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  private category: Category;
  private categories: Category[];
  private topic: Topic;
  private topics: Topic[];
  private genre: Genre;
  private genres: Genre[];
  private levels: Levels[];
  private question: Question;

  private selectedCategory: Category;
  private selectedTopic: Topic;
  private selectedGenre: Genre;

  private tfStatement: string;
  private tfselectedOption: string;
  private tfselectedLevel: string;

  private mcqStatement: string;
  private mcqOption1: string;
  private mcqOption2: string;
  private mcqOption3: string;
  private mcqOption4: string;
  private mcqSelectedOption: string;
  private mcqSelectedLevel: string;


  statusCode: any;


  constructor(
    private jsonServer: JsonService,
    private questionService: AdminQuestionService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
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

    this.selectedCategory = new Category();
    this.selectedTopic = new Topic();
    this.selectedGenre = new Genre();

    this.tfselectedOption = '';
    this.tfStatement = '';
    this.tfselectedLevel = '';

    this.mcqStatement = '';
    this.mcqOption1 = '';
    this.mcqOption2 = '';
    this.mcqOption3 = '';
    this.mcqOption4 = '';
    this.mcqSelectedOption = '';
    this.mcqSelectedLevel = '';
  }

  saveMcqQuestion() {
    if ( 
      this.selectedCategory.name !== undefined &&
      this.selectedTopic.name !== undefined &&
      this.selectedGenre.name !== undefined &&
      this.mcqStatement !== '' &&
      this.mcqOption1 !== '' &&
      this.mcqOption2 !== '' &&
      this.mcqOption3 !== '' &&
      this.mcqOption4 !== '' &&
      this.mcqSelectedOption !== '' &&
      this.mcqSelectedLevel !== ''
      )
      {
        this.question = new Question();
        this.question.id = 0;
        this.question.category = this.selectedCategory;
        this.question.topic = this.selectedTopic;
        this.question.genre = this.selectedGenre;
        this.question.tag = null;
        this.question.level = this.mcqSelectedLevel;
        this.question.type = 'mcq';
        this.question.statement = this.mcqStatement;
        this.question.options = [this.mcqOption1, this.mcqOption2, this.mcqOption3, this.mcqOption3];
        this.question.correctAnswer = this.mcqSelectedOption;
        this.question.playerAnswer = null;

        this.questionService.saveQuestion(this.question).subscribe(
          (response: any) => {
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
              this.snackBar.open('Question Already Exists', '', {
                duration: 1500
              });
              this.statusCode = 0;
            }
        });
        
      }
      else if (this.selectedCategory.name === undefined)
      {
        this.snackBar.open('Please Select A Category !', '', {
          duration: 1500
        });

      }
      else if (this.selectedTopic.name === undefined)
      {
        this.snackBar.open('Please Select A Topic !', '', {
          duration: 1500
        });

      }
      else if (this.selectedGenre.name === undefined)
      {
        this.snackBar.open('Please Select A Genre !', '', {
          duration: 1500
        });
      }
      else if ( 
        this.mcqStatement === '' ||
        this.mcqOption1 === '' ||
        this.mcqOption2 === '' ||
        this.mcqOption3 === '' ||
        this.mcqOption4 === '' ||
        this.mcqSelectedOption === '' ||
        this.mcqSelectedLevel === ''
        )
        {
          this.snackBar.open('Please Give Question Details !', '', {
            duration: 1500
          });
        }
  }

  saveTFQuestion() {
    if ( 
      this.selectedCategory.name !== undefined &&
      this.selectedTopic.name !== undefined &&
      this.selectedGenre.name !== undefined &&
      this.tfStatement !== '' &&
      this.tfselectedOption !== '' &&
      this.tfselectedLevel !== ''
      )
      {
        this.question = new Question();
        this.question.id = 0;
        this.question.category = this.selectedCategory;
        this.question.topic = this.selectedTopic;
        this.question.genre = this.selectedGenre;
        this.question.tag = null;
        this.question.level = this.tfselectedLevel;
        this.question.type = 't/f';
        this.question.statement = this.tfStatement;
        this.question.options = ['true', 'false'];
        this.question.correctAnswer = this.tfselectedOption;
        this.question.playerAnswer = null;

        this.questionService.saveQuestion(this.question).subscribe(
          (response: any) => {
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
              this.snackBar.open('Question Already Exists', '', {
                duration: 1500
              });
              this.statusCode = 0;
            }
        });
        
      }
      else if (this.selectedCategory.name === undefined)
      {
        this.snackBar.open('Please Select A Category !', '', {
          duration: 1500
        });

      }
      else if (this.selectedTopic.name === undefined)
      {
        this.snackBar.open('Please Select A Topic !', '', {
          duration: 1500
        });

      }
      else if (this.selectedGenre.name === undefined)
      {
        this.snackBar.open('Please Select A Genre !', '', {
          duration: 1500
        });
      }
      else if ( 
        this.tfStatement === '' ||
        this.tfselectedOption === '' ||
        this.tfselectedLevel === ''
        )
        {
          this.snackBar.open('Please Give Question Details !', '', {
            duration: 1500
          });
        }
  }

}
