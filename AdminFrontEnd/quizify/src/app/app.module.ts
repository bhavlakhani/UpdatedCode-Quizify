import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QuizifyMaterialModule } from './quizify.material.module';
import { QuizifyModule } from './quizify/quizify.module';
import { AdminGameService } from './quizify/services/admin-game.service';
import { JsonService } from './quizify/services/json.service';
import { AdminQuestionService } from './quizify/services/admin-question.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    QuizifyMaterialModule,
    QuizifyModule
  ],
  providers: [AdminGameService, JsonService, AdminQuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
