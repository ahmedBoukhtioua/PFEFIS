import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import {AuthenticationService} from "../../services/authentication.service";
import {Router} from "@angular/router";
import {user} from "../../models/user";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: user;
  userUpdate: user;
  isEditError: boolean = false;
  EmptyField: boolean = false;

  constructor(private authService: AuthenticationService, private router: Router) {
    this.user = new user()
    this.userUpdate = new user()

  }

  ngOnInit(): void {
    if (localStorage.getItem('user')) {
      this.authService.getCurrentUser(localStorage.getItem('user')).subscribe(data => {

          this.user = data
          console.log(this.user)

        },
        (err: HttpErrorResponse) => {

        });
    }
  }

  update(id) {
    if (this.user.birthDate === null || this.user.email == "" || this.user.fname === "" || this.user.adress === "" ) {


      this.EmptyField = true;
      this.isEditError = false;


    } else {

      this.authService.updateProfil(id, this.user).subscribe(data => {


        },
        (err: HttpErrorResponse) => {
          if (err.status === 400) {

            this.EmptyField = false;
          }

          if (err.status === 422) {

            this.EmptyField = true;
          }


        })
    }

  }
  annuler() {
    this.router.navigate(['/offer'])
  }
}
