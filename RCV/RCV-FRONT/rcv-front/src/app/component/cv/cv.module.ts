import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CvRoutingModule } from './cv-routing.module';
import { ListCvComponent } from './list-cv/list-cv.component';
import {AddcvComponent} from "./addcv/addcv.component";

import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddcvComponent,ListCvComponent],
  imports: [
    CommonModule,
    CvRoutingModule,
    FormsModule
  ]
})
export class CvModule { }
