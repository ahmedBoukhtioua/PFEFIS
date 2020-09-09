import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddJobOfferComponent} from "./add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";
import {ArchivedJobOfferComponent} from "./archived-job-offer/archived-job-offer.component";


const routes: Routes = [
  {
    path: 'addJobOffer',
    component : AddJobOfferComponent
  },
  {
    path: 'listJobOffer',
    component: ListJobOfferComponent
  },
  {
    path: 'archivedJobOffer',
    component: ArchivedJobOfferComponent
  },
 ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class JobOfferRoutingModule { }
