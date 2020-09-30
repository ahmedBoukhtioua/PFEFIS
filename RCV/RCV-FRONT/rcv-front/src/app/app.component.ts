import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./services/token-storage.service";
import {NavigationEnd,Router} from "@angular/router";
import {AuthenticationService} from "./services/authentication.service";
import {user} from "./models/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  navigationSubscription
  private roles: string[];
  email: string;
  iduser:string;
  user1: user;
  title:any;
  constructor(public router: Router,private AuthService :AuthenticationService) {

    this.navigationSubscription = this.router.events.subscribe((e: any) => {
    // If it is a NavigationEnd event re-initalise the component
    if (e instanceof NavigationEnd) {
      this.ngOnInit();
    }
  }); }



  ngOnInit() {
    if(localStorage.getItem('user'))
    {
      console.log(localStorage.getItem('user'))
      this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
        this.user1=data;
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
    localStorage.removeItem("isManager")
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
