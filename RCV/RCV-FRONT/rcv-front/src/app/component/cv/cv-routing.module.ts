import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddcvComponent} from "./addcv/addcv.component";


const routes: Routes = [
  { path: 'addcv', component: AddcvComponent }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CvRoutingModule { }
