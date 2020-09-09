import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddJobOfferComponent} from "../job-offer/add-job-offer/add-job-offer.component";
import {AddQuizComponent} from "./add-quiz/add-quiz.component";


const routes: Routes = [
  {
    path: 'addQuiz',
    component : AddQuizComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule {


}
