import { Component, OnInit } from '@angular/core';
import {QuizService} from "../../../services/quiz/quiz.service";
import {quiz} from "../../../models/quiz";
import {reponse} from "../../../models/Reponse";
import {AuthenticationService} from "../../../services/authentication.service";
import {user} from "../../../models/user";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-quiz-candidat',
  templateUrl: './quiz-candidat.component.html',
  styleUrls: ['./quiz-candidat.component.css']
})
export class QuizCandidatComponent implements OnInit {
  quiz : quiz;
  reponse : reponse;
  quizs: quiz[];
  isConnected: user;
  navigationSubscription;

  constructor(private quizService : QuizService , private AuthService:AuthenticationService,private router: Router) {
    this.quiz=new quiz()
    this.navigationSubscription = this.router.events.subscribe((q: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (q instanceof NavigationEnd) {
        this.ngOnInit();
      }
    });
  }


  ngOnInit(): void {
    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.isConnected=data;

    }),
      this.quizService.getQuizVisible().subscribe(
        data=>
        {
          this.quizs = data;
          let i = Math.floor((Math.random() * this.quizs.length));

          this.quiz = this.quizs[i];
          this.reponse = new  reponse();
          this.reponse.idUser=this.isConnected;
          console.log(this.isConnected)
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

  isManager() {
    return localStorage.getItem("user") === "true";
  }


}
