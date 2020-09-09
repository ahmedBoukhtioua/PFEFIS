import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProfileComponent} from "./component/profile/profile.component";
import {RegisterComponent} from "./component/register/register.component";
import {LoginComponent} from "./component/login/login.component";
import {HomeComponent} from "./component/home/home.component";
import {AddcvComponent} from "./component/cv/addcv/addcv.component";
import {AddJobOfferComponent} from "./component/job-offer/add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./component/job-offer/list-job-offer/list-job-offer.component";
import {ArchivedJobOfferComponent} from "./component/job-offer/archived-job-offer/archived-job-offer.component";
import {OfferComponent} from "./component/offer/offer.component";
import {AuthGuard} from "./helpers/auth.guard";
import {AddQuizComponent} from "./component/quiz/add-quiz/add-quiz.component";


const routes: Routes = [

  { path: 'home', component: HomeComponent,canActivate:[AuthGuard],data: { roles: localStorage.getItem("isManager")} },
  { path: 'addcv', component: AddcvComponent,canActivate:[AuthGuard]  },
  { path: 'login', component: LoginComponent  },
  { path: 'addQuiz', component: AddQuizComponent  },
  { path: 'register', component: RegisterComponent},
  { path: 'profile', component: ProfileComponent,canActivate:[AuthGuard] },
  { path: 'addJobOffer', component: AddJobOfferComponent,canActivate:[AuthGuard]  },
  { path: 'listJobOffer', component: ListJobOfferComponent,canActivate:[AuthGuard] },
  { path: 'archivedJobOffer', component: ArchivedJobOfferComponent,canActivate:[AuthGuard] },
  { path: 'offer', component: OfferComponent ,canActivate:[AuthGuard] },

  { path: '', redirectTo: 'home',canActivate:[AuthGuard], pathMatch: 'full' }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
