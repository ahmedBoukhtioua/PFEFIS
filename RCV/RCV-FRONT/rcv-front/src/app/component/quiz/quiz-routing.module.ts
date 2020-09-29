import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddQuizComponent} from "./add-quiz/add-quiz.component";
import {QuizCandidatComponent} from "./quiz-candidat/quiz-candidat.component";


const routes: Routes = [
  {
    path: 'addQuiz',
    component : AddQuizComponent
  },
  {
    path: 'quiz',
    component : QuizCandidatComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule {


}
