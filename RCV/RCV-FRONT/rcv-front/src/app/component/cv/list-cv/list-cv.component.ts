import { Component, OnInit } from '@angular/core';
import {CvService} from "../../../services/cv/cv.service";
import {cv} from "../../../models/Cv";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-list-cv',
  templateUrl: './list-cv.component.html',
  styleUrls: ['./list-cv.component.css']
})
export class ListCvComponent implements OnInit {
cvs:cv[];
OneCv:cv;
public closeResult: string;

  constructor(private modalService: NgbModal, private router: Router, private fb: FormBuilder,private cvservice: CvService) { }

  ngOnInit(): void {
    this.cvservice.getAllCv().subscribe((data) => {
      this.cvs = data

    }, (err) => {


    })

  }
  public openArchive(content, id) {

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${ListCvComponent.getDismissReason(reason)}`;
    });

    this.cvservice.getCvById(id).subscribe(data => {


      this.OneCv = data


    }, err => {


    });

  }
  archiverCv() {
  console.log(this.OneCv);
    if(this.OneCv.archived == false)
    {this.cvservice.archivedCv(this.OneCv.id, this.OneCv).subscribe((data) => {
        window.location.reload()

      },
      (err: HttpErrorResponse) => {


      });}

    else{this.cvservice.validateCv(this.OneCv.id,this.OneCv ).subscribe((data) => {
        window.location.reload()

      },
      (err: HttpErrorResponse) => {

        window.location.reload()

      });}



  }

  private static getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
