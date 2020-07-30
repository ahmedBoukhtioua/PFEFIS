import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddJobOfferComponent} from "./add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";
import {JobOfferRoutingModule} from "./job-offer-routing.module";
import {FormsModule} from "@angular/forms";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from "@angular/material/icon";
import { ArchivedJobOfferComponent } from './archived-job-offer/archived-job-offer.component';
import {MatDialogModule} from "@angular/material/dialog";



@NgModule({
  declarations: [AddJobOfferComponent,ListJobOfferComponent, ArchivedJobOfferComponent],
  imports: [
    CommonModule,
    FormsModule,
    JobOfferRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatDialogModule
  ]
})
export class JobOfferModule { }
