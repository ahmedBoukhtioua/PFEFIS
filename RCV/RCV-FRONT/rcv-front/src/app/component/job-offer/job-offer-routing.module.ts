import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";


const routes: Routes = [

  {
    path: 'listJobOffer',
    component: ListJobOfferComponent
  },
 ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class JobOfferRoutingModule { }
