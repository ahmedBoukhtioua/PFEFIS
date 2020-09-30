import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {TokenStorageService} from "../../services/token-storage.service";
import {user} from "../../models/user";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  user: user;
  constructor(private authService: AuthenticationService, private tokenStorage: TokenStorageService,private router: Router) { }

  ngOnInit() {


  }

  onSubmit() {
    this.authService.login(this.form).subscribe(
      data => {
        localStorage.setItem('user',data.id);
        this.router.navigate(["/offer"])


      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
}
