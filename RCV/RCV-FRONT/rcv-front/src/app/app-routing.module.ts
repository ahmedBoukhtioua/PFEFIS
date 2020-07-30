import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProfileComponent} from "./component/profile/profile.component";
import {RegisterComponent} from "./component/register/register.component";
import {LoginComponent} from "./component/login/login.component";
import {HomeComponent} from "./component/home/home.component";
import {AddcvComponent} from "./component/cv/addcv/addcv.component";
import {JobOfferModule} from "./component/job-offer/job-offer.module";
import {AddJobOfferComponent} from "./component/job-offer/add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./component/job-offer/list-job-offer/list-job-offer.component";


const routes: Routes = [

  { path: 'home', component: HomeComponent },
  { path: 'addcv', component: AddcvComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'addJobOffer', component: AddJobOfferComponent },
  { path: 'listJobOffer', component: ListJobOfferComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
