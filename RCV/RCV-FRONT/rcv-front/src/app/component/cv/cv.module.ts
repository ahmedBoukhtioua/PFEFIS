import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CvRoutingModule } from './cv-routing.module';
import { ListCvComponent } from './list-cv/list-cv.component';
import {AddcvComponent} from "./addcv/addcv.component";

import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [AddcvComponent,ListCvComponent],
  imports: [
    CommonModule,
    CvRoutingModule,
    FormsModule,
    RouterModule
  ]
})
export class CvModule { }
