import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';
import { AddQuizComponent } from './add-quiz/add-quiz.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddQuizComponent],
  imports: [
    CommonModule,
    QuizRoutingModule,
    FormsModule
  ]
})
export class QuizModule { }
