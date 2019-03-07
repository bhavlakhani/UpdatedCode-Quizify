import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminGameLandingComponent } from './components/admin-game-landing/admin-game-landing.component';
import { QuizifyMaterialModule } from '../quizify.material.module';
import { HttpClientModule } from '@angular/common/http';
import { AdminQuestionLandingComponent } from './components/admin-question-landing/admin-question-landing.component';
import { AddGameComponent } from './components/add-game/add-game.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';

@NgModule({
  declarations: [AdminGameLandingComponent, AdminQuestionLandingComponent, AddGameComponent, AddQuestionComponent],
  imports: [
    CommonModule,
    QuizifyMaterialModule,
    HttpClientModule
  ],
  exports: [
    AdminGameLandingComponent,
  ]
})
export class QuizifyModule { }
