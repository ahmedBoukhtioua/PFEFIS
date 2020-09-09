import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddJobOfferComponent} from "./add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./list-job-offer/list-job-offer.component";
import {JobOfferRoutingModule} from "./job-offer-routing.module";
import {FormsModule} from "@angular/forms";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {jqxDataTableModule} from "jqwidgets-ng/jqxdatatable";
import {ArchivedJobOfferComponent} from "./archived-job-offer/archived-job-offer.component";
import {jqxInputModule} from "jqwidgets-ng/jqxinput";
import {jqxDateTimeInputModule} from "jqwidgets-ng/jqxdatetimeinput";
import {jqxButtonModule} from "jqwidgets-ng/jqxbuttons";
import {jqxWindowModule} from "jqwidgets-ng/jqxwindow";
import {jqxGridModule} from "jqwidgets-ng/jqxgrid";
import {jqxNumberInputModule} from "jqwidgets-ng/jqxnumberinput";

@NgModule({
  declarations: [AddJobOfferComponent,ListJobOfferComponent,ArchivedJobOfferComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    JobOfferRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatDialogModule,
   // Ng2SmartTableModule,
    jqxDataTableModule,
    jqxGridModule,
    jqxInputModule,
    jqxDateTimeInputModule,
    jqxButtonModule,
    jqxWindowModule,
    jqxNumberInputModule,
  ]
})
export class JobOfferModule { }

