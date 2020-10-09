import { Component, OnInit } from '@angular/core';
import {QuizService} from "../../../services/quiz/quiz.service";
import {reponse} from "../../../models/Reponse";
import {Router} from "@angular/router";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-reponse-quiz',
  templateUrl: './reponse-quiz.component.html',
  styleUrls: ['./reponse-quiz.component.css']
})
export class ReponseQuizComponent implements OnInit {
  reponses: Array<reponse> = []

  constructor(private modalService: NgbModal, private router: Router, private fb: FormBuilder, private quizService: QuizService ) { }

  ngOnInit(): void {

    this.quizService.getReponseAll().subscribe((data) => {
      this.reponses = data

    }, (err) => {


    })
  }

}
