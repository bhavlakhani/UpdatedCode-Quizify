

// import { JwtHelperService } from '@auth0/angular-jwt';

import { QuizifyModule } from './quizify/quizify.module';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatCardModule } from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { QuizifyMaterialModule } from './quizify/quizify.material.module';
import { FormsModule } from '@angular/forms';
import { QuestionService } from './quizify/services/question.service';
import { GameserviceService } from './quizify/services/gameservice.service';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './quizify/components/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    // HeaderComponent
  ],
  imports: [
    BrowserModule,
    QuizifyModule,
    AppRoutingModule,
    MatCardModule,
    MatSelectModule,
    BrowserAnimationsModule,
    HttpClientModule,
    QuizifyMaterialModule
      ],
  providers: [QuestionService,
  GameserviceService] ,
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

  bootstrap: [AppComponent]
})
export class AppModule { }
