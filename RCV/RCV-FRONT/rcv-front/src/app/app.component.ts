import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./services/token-storage.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "./services/authentication.service";
import {user} from "./models/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;

  email: string;
  iduser:string;
  user1: user;
  title:any;
  constructor(private tokenStorageService: TokenStorageService,public router: Router,private AuthService :AuthenticationService) { }

  ngOnInit() {
    this.user1=new user()
    if(localStorage.getItem('user'))
    {

      this.isLoggedIn=true
      this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
        this.user1=data;
        this.email=data.email;
        this.iduser = data.id;

        console.log(this.user1.roles[0].name)
        if(this.user1.roles[0].name==="ROLE_RH"|| this.user1.roles[0].name==='ROLE_MANAGER')
         {
           localStorage.setItem('isManager','true')
        }
        else {

          localStorage.setItem('isManager','false')
     }
      })

    }
  }

  logout(){

    localStorage.removeItem("user");
    this.router.navigate(['/login'])

  }
  isManager()
  {
    if (localStorage.getItem('isManager')==="true"){
      return true

    }
    else {
      return false

    }
  }
}
