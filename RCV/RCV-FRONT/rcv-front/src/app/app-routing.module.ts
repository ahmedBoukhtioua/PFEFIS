import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProfileComponent} from "./component/profile/profile.component";
import {RegisterComponent} from "./component/register/register.component";
import {LoginComponent} from "./component/login/login.component";
import {HomeComponent} from "./component/home/home.component";
import {AddcvComponent} from "./component/cv/addcv/addcv.component";
import {ListJobOfferComponent} from "./component/job-offer/list-job-offer/list-job-offer.component";
import {OfferComponent} from "./component/offer/offer.component";
import {AuthGuard} from "./helpers/auth.guard";
import {AddQuizComponent} from "./component/quiz/add-quiz/add-quiz.component";
import {QuizCandidatComponent} from "./component/quiz/quiz-candidat/quiz-candidat.component";
import {ListCvComponent} from "./component/cv/list-cv/list-cv.component";
import {ReponseQuizComponent} from "./component/quiz/reponse-quiz/reponse-quiz.component";


const routes: Routes = [

  { path: 'home', component: HomeComponent,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")} },
  { path: 'addcv', component: AddcvComponent,canActivate:[AuthGuard]  },
  { path: 'login', component: LoginComponent   },
  { path: 'addQuiz', component: AddQuizComponent,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")}  },
  { path: 'reponseQuiz', component: ReponseQuizComponent,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")}  },
  { path: 'register', component: RegisterComponent},
  { path: 'profile', component: ProfileComponent,canActivate:[AuthGuard] },
  { path: 'listJobOffer', component: ListJobOfferComponent,canActivate:[AuthGuard] },
  { path: 'offer', component: OfferComponent ,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")} },
  { path: 'quiz', component: QuizCandidatComponent ,canActivate:[AuthGuard]},
  { path: 'listcv', component: ListCvComponent ,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")} },
  { path: '', redirectTo: 'addcv',canActivate:[AuthGuard], pathMatch: 'full' }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
