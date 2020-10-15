import { Component, OnInit } from '@angular/core';
import {CvService} from "../../../services/cv/cv.service";
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {NavigationEnd, Router} from "@angular/router";
import {AuthenticationService} from "../../../services/authentication.service";
import {user} from "../../../models/user";

@Component({
  selector: 'app-addcv',
  templateUrl: './addcv.component.html',
  styleUrls: ['./addcv.component.css']
})
export class AddcvComponent implements OnInit {
  public note: any;
  user1:user
  currentFileUpload: File;
  selectedFiles: FileList;
  isSuccessful = false;
  display = false ;
  progress: { percentage: number } = { percentage: 0 };
  isConnected : user;
  navigationSubscription;

  constructor( private uploadService: CvService ,private router: Router,private AuthService: AuthenticationService) {
  this.user1=new user()
    this.navigationSubscription = this.router.events.subscribe((a: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (a instanceof NavigationEnd) {
        this.ngOnInit() ;
      }
    });

  }



  ngOnInit(): void {

    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.isConnected=data;

    })

  }

  uploadfile() {

  console.log(this.isConnected.id)

    this.note=10;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload,this.note,this.isConnected.id).subscribe(event => {this.isSuccessful = true;
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
      if(localStorage.getItem('isManager')==="true"){
        this.router.navigate(["/home"])

      }
      else
      {
        this.router.navigate(["/quiz"])
          this.reloadPage();
      }

    });

    this.selectedFiles = undefined;
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
  reloadPage() {
    window.location.reload();
  }


}
