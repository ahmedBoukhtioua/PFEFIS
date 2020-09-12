import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';
import { AddQuizComponent } from './add-quiz/add-quiz.component';
import {FormsModule} from "@angular/forms";
import { QuizCandidatComponent } from './quiz-candidat/quiz-candidat.component';


@NgModule({
  declarations: [AddQuizComponent, QuizCandidatComponent],
  imports: [
    CommonModule,
    QuizRoutingModule,
    FormsModule
  ]
})
export class QuizModule { }
