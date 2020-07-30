import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { HomeComponent } from './component/home/home.component';
import { ProfileComponent } from './component/profile/profile.component';
import {authInterceptorProviders} from "./helpers/auth.interceptor";
import { NgxSpinnerModule } from "ngx-spinner";
import {AddJobOfferComponent} from "./component/job-offer/add-job-offer/add-job-offer.component";
import {ListJobOfferComponent} from "./component/job-offer/list-job-offer/list-job-offer.component";
import { AddcvComponent } from './component/cv/addcv/addcv.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatDialog, MatDialogModule} from "@angular/material/dialog";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    AddcvComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule



  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
