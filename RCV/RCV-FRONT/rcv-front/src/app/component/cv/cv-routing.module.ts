import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddcvComponent} from "./addcv/addcv.component";
import {ListCvComponent} from "./list-cv/list-cv.component";


const routes: Routes = [
  { path: 'addcv', component: AddcvComponent },
  { path: 'listcv', component: ListCvComponent}
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CvRoutingModule { }
