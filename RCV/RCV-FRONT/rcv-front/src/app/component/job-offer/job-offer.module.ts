import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";
import {JobOfferRoutingModule} from "./job-offer-routing.module";
import {FormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";


@NgModule({
  declarations: [ListJobOfferComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    JobOfferRoutingModule,
    MatCardModule,

  ]
})
export class JobOfferModule { }

