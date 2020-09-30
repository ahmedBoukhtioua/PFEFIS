import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { HomeComponent } from './component/home/home.component';
import { ProfileComponent } from './component/profile/profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgxSpinnerModule} from "ngx-spinner";
import {JobOfferModule} from "./component/job-offer/job-offer.module";
import { OfferComponent } from './component/offer/offer.component';
import {RouterModule} from "@angular/router";
import {AuthGuard} from "./helpers/auth.guard";
import {QuizModule} from "./component/quiz/quiz.module";
import {CvModule} from "./component/cv/cv.module";
import {ChartsModule} from "ng2-charts";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    OfferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    BrowserAnimationsModule,
    JobOfferModule,
    QuizModule,
    CvModule,
    ChartsModule

  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
