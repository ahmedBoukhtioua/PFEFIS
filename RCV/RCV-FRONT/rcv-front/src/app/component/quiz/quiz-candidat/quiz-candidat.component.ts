import { Component, OnInit } from '@angular/core';
import {QuizService} from "../../../services/quiz/quiz.service";
import {quiz} from "../../../models/quiz";
import {reponse} from "../../../models/Reponse";
import {AuthenticationService} from "../../../services/authentication.service";
import {user} from "../../../models/user";
import {ej} from "@syncfusion/ej2/dist/ej2";
import data = ej.data;
import {TokenStorageService} from "../../../services/token-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-quiz-candidat',
  templateUrl: './quiz-candidat.component.html',
  styleUrls: ['./quiz-candidat.component.css']
})
export class QuizCandidatComponent implements OnInit {

  constructor(private quizService : QuizService , private AuthService:AuthenticationService,private router: Router) { }
  quiz : quiz;
  reponse : reponse;
  quizs: quiz[];
  isConnected: user;

  ngOnInit(): void {
    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.isConnected=data;

    }),
      this.quizService.getQuiz().subscribe(
        data=>
        {
          this.quizs = data;
          let i = Math.floor((Math.random() * this.quizs.length));

          this.quiz = this.quizs[i];
          this.reponse = new  reponse();
          this.reponse.idUser=this.isConnected;

          this.reponse.idQuiz = this.quiz;
          this.reponse.reponses = [];
        }
      );

  }
  submit()
  {
  this.quizService.submit(this.reponse).subscribe(
    data=>{
      this.router.navigate(["/listJobOffer"])


    }
  )
  }
  choose(value, question)
  {
    this.reponse.reponses.push(value);
  }
}
