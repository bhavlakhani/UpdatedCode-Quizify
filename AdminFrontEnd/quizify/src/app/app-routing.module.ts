import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminGameLandingComponent } from './quizify/components/admin-game-landing/admin-game-landing.component';
import { AdminQuestionLandingComponent } from './quizify/components/admin-question-landing/admin-question-landing.component';
import { AddGameComponent } from './quizify/components/add-game/add-game.component';
import { AddQuestionComponent } from './quizify/components/add-question/add-question.component';

const routes: Routes = [
  {path: 'admin-game', component: AdminGameLandingComponent},
  {path: 'admin-question', component: AdminQuestionLandingComponent},
  {path: 'add-game', component: AddGameComponent},
  {path: 'edit-game', component: AddGameComponent},
  {path: 'add-question', component: AddQuestionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
