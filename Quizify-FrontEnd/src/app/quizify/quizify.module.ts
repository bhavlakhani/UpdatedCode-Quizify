import { CardService } from './services/card.service';
import { GamehistoryComponent } from './components/gamehistory/gamehistory.component';
import { ProfileUserComponent } from './components/profileuser/profileuser.component';
import { MatRadioModule } from '@angular/material/radio';
import { RegisterComponent } from './components/register/register.component';
import { QuizifyMaterialModule } from './quizify.material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './components/profile/profile.component';
import { CardsComponent } from './components/cards/cards.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatCardModule, MatCardHeader, MatFormField, MatFormFieldModule,
   MatInputModule, MatButtonModule, MatDialogModule, MatIconModule, MatLabel, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SearchComponent } from './components/search/search.component';
import { GameComponent } from './components/game/game.component';
import { QuestionGeneratorComponent } from './components/question-generator/question-generator.component';
import { HeaderComponent } from './components/header/header.component';
import { GamedetailsService } from './services/gamedetails.service';
import { BrowserModule } from '@angular/platform-browser';
import { CookieService } from 'ngx-cookie-service';
import { GamedetailsComponent } from './components/gamedetails/gamedetails.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { FooterComponent } from './components/footer/footer.component';
import { GameEngineComponent } from './components/game-engine/game-engine.component';
import { AuthGuard } from './components/auth/auth.guard';
import { DialogComponent } from './components/dialog/dialog.component';
import { GameEngineService } from './services/game-engine.service';

import { RuleComponent } from './components/rule/rule.component';
// import {NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown';
@NgModule({
  declarations: [ CardsComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
    SearchComponent,
    ProfileUserComponent,
    GamehistoryComponent,
    GameComponent,
    QuestionGeneratorComponent,
    HeaderComponent,
    GamedetailsComponent,
    AdminpageComponent,
    FooterComponent,
    GameEngineComponent,
    DialogComponent,
    RuleComponent
     ],
     providers: [ CardService, CookieService, GamedetailsService, AuthGuard, GameEngineService,
      { provide: MatDialogModule, useValue: {} },
      { provide: MatIconModule, useValue: [] },
      {
         provide: MatLabel, useValue: {}
      },
      { provide: MatDialogRef, useValue: {} },
      {
        provide: MAT_DIALOG_DATA, useValue: {}
      }
       ],
      entryComponents: [
        DialogComponent,
      ],


  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatCardModule,
    QuizifyMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    BrowserModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
   // NgMultiSelectDropDownModule.forRoot()
  ],
  exports: [ CardsComponent,
    ProfileComponent,
    RegisterComponent,
    LoginComponent,
    SearchComponent,
    ProfileUserComponent,
    GamehistoryComponent,
    GameComponent,
    QuestionGeneratorComponent,
    GamedetailsComponent,
    AdminpageComponent,
    HeaderComponent,
    DialogComponent,
    GameEngineComponent,
    FooterComponent   ],

})
export class QuizifyModule { }
