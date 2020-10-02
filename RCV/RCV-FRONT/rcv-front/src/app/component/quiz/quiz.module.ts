import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';
import { AddQuizComponent } from './add-quiz/add-quiz.component';
import {FormsModule} from "@angular/forms";
import { QuizCandidatComponent } from './quiz-candidat/quiz-candidat.component';
import { ReponseQuizComponent } from './reponse-quiz/reponse-quiz.component';


@NgModule({
  declarations: [AddQuizComponent, QuizCandidatComponent, ReponseQuizComponent],
  imports: [
    CommonModule,
    QuizRoutingModule,
    FormsModule
  ]
})
export class QuizModule { }
