import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddJobOfferComponent} from "./add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";
import {JobOfferRoutingModule} from "./job-offer-routing.module";
import {FormsModule} from "@angular/forms";
import {ArchivedJobOfferComponent} from "./archived-job-offer/archived-job-offer.component";
import {MatCardModule} from "@angular/material/card";


@NgModule({
  declarations: [AddJobOfferComponent,ListJobOfferComponent,ArchivedJobOfferComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    JobOfferRoutingModule,
    MatCardModule,

  ]
})
export class JobOfferModule { }

