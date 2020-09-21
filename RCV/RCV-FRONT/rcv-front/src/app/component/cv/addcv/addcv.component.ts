import { Component, OnInit } from '@angular/core';
import {CvService} from "../../../services/cv/cv.service";
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../services/authentication.service";
import {user} from "../../../models/user";

@Component({
  selector: 'app-addcv',
  templateUrl: './addcv.component.html',
  styleUrls: ['./addcv.component.css']
})
export class AddcvComponent implements OnInit {
  public note: any;
  currentFileUpload: File;
  selectedFiles: FileList;
  isSuccessful = false;
  display = false ;
  progress: { percentage: number } = { percentage: 0 };
  isConnected : user;

  constructor( private uploadService: CvService ,private router: Router,private AuthService: AuthenticationService) { }

  ngOnInit(): void {
  }
  uploadfile() {

    this.note=10;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload,this.note).subscribe(event => {this.isSuccessful = true;
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
      //this.router.navigate(["/quiz"])
    });

    this.selectedFiles = undefined;
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
}
