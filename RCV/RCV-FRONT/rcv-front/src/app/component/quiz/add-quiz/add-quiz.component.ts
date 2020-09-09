import { Component, OnInit } from '@angular/core';
import {quiz} from "../../../models/quiz";
import {QuizService} from "../../../services/quiz/quiz.service";
import {user} from "../../../models/user";
import {jobOffer} from "../../../models/jobOffer";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";
import {HttpErrorResponse} from "@angular/common/http";
import {question} from "../../../models/question";
import {option} from "../../../models/option";
import {AuthenticationService} from "../../../services/authentication.service";

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  quiz: quiz= new quiz();
  questionToAdd = new question();
  public skills = [];
  public managers : user;
  quizs: quiz[];
  question:question[];
  option: option[];
  // maps the local data column to fields property
  public localFields: Object = {text: 'Name', value: 'Name'};
  // set the placeholder to MultiSelect Dropdown input element
  public localWaterMark: string = 'Choisir skills';
  div1: boolean;
  div2: boolean;
  div3: boolean;
  public value: [];
  public closeResult: string;
  modifQuiz: quiz;
  errorAdd: boolean = false;
  oneQuiz: quiz;
  isConnected: user;



  constructor(private modalService: NgbModal, private router: Router, private fb: FormBuilder, private quizService: QuizService,private AuthService:AuthenticationService) {


  }


  ngOnInit(): void {
    this.quizs = []
    this.oneQuiz = new quiz()
    this.quiz = new quiz();
    this.quiz.questionsList = Array();
    this.questionToAdd.optionList = [new option(), new option(), new option()];
    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.isConnected=data;

    }),
    this.quizService.getQuiz().subscribe((data) => {
      this.quizs = data


    }, (err) => {


    })

    this.showOffrePage()
  }

  showOffrePage() {
    this.modifQuiz = new quiz();
    this.quiz = new quiz();
    this.value = null

    this.errorAdd = false
    this.div1 = true;
    this.div2 = false;
    this.div3 = false;


  }

  showAjout(){

    this.quizService.getQuiz().subscribe((data)=>{
    },(err)=>{

    });


    this.div1=false;
    this.div2=true;
    this.div3=false;

  }
  showModif(idQuiz) {
    this.quizService.getQuizById(idQuiz).subscribe((data) => {

        this.modifQuiz = data;
      },
      (error: HttpErrorResponse) => {


      })

    this.div1 = false;
    this.div2 = false;
    this.div3 = true;

  }


  public openDetails(content, id) {

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${AddQuizComponent.getDismissReason(reason)}`;
    });
    this.quizService.getQuizById(id).subscribe(data => {


      this.oneQuiz = data
     /* this.quizService.getJobOfferByUser(this.oneQuiz.idRh).subscribe((data) => {
        this.oneQuiz.idRh.fName
      }, (error) => {
      })*/

    }, err => {
    });
  }

  public openArchive(content, id) {

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${AddQuizComponent.getDismissReason(reason)}`;
    });

    this.quizService.getQuizById(id).subscribe(data => {


      this.oneQuiz = data


    }, err => {


    });

  }

  private static getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  AjoutQuiz() {

    // this.offre.skills=this.value

    /* if (!this.offre.skills || !this.offre.manager || !this.offre.equipe) {

       this.errorAdd = true
     } else {*/
     this.quiz.idRh=this.isConnected;
    this.quizService.addQuiz(this.quiz).subscribe(data => {
        this.errorAdd = false;
        this.value = null;


        setTimeout(() => {
          this.ngOnInit()
        }, 2000)
      },
      (err: HttpErrorResponse) => {
        if (err.status === 422) {
          console.log(err)

          this.errorAdd = true

        }


      });
  }



  /*setReplyTypeValue() {

    console.log(this.offre.manager)
    this.offre.equipe=""
    this.offreService.getEquipesByManager(this.offre.manager).subscribe((data)=>{
      this.equipes=data
      this.showEquipe=true

    },(err)=>{})

  }
*/
  archiverQuiz() {
    console.log("ok")
  if(this.oneQuiz.visible == true){this.quizService.notVisibleQuiz(this.oneQuiz,this.oneQuiz.idQuiz).subscribe((data) => {
      console.log(data)
      window.location.reload()
    },
    (err: HttpErrorResponse) => {


    });}
    else{
    this.quizService.visibleQuiz(this.oneQuiz.idQuiz,this.oneQuiz).subscribe((data) => {
        console.log(data)
        window.location.reload()
      },
      (err: HttpErrorResponse) => {


      });
  }

  }


  updateQuiz(id) {

    this.quizService.updateQuiz(id,this.modifQuiz).subscribe((data) => {

      this.errorAdd = true
      this.showOffrePage()

      setTimeout(() => {
        this.ngOnInit()
      }, 1000)


    }, (err: HttpErrorResponse) => {


      if (err.status === 422) {
        this.errorAdd = true

      }


    })


  }

  isManager() {
    return localStorage.getItem("user") === "true";
  }

  AjoutQuestion()
  {
    if(this.quiz.questionsList == undefined)
    {
      this.quiz.questionsList = Array();
    }
    this.quiz.questionsList.push(Object.assign({}, this.questionToAdd));
    this.questionToAdd.question = null;
    this.questionToAdd.optionList = [new option(), new option(), new option()]
  }

}
