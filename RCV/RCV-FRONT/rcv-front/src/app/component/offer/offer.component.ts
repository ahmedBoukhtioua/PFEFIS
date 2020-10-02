import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder} from '@angular/forms';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpErrorResponse} from '@angular/common/http';
import {jobOffer} from '../../models/jobOffer';
import {JobOfferService} from "../../services/jobOffer/job-offer.service";
import {user} from "../../models/user";
import {AuthenticationService} from "../../services/authentication.service";
import {cv} from "../../models/Cv";

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  public managers : user;
  offres: Array<jobOffer> = []

  div1: boolean;
  div2: boolean;
  div3: boolean;
  public value: [];
  public closeResult: string;
  offre: jobOffer;
  modifOffre: jobOffer;
  errorAdd: boolean = false;
  OneOffre: jobOffer;
  isConnected: user;
  cvs : Array<cv> = [];


  constructor(private modalService: NgbModal, private router: Router, private fb: FormBuilder, private offreService: JobOfferService,private AuthService:AuthenticationService) {


  }


  ngOnInit(): void {
    this.offres = []
    this.OneOffre = new jobOffer()
    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.isConnected=data;

    }),

    this.offreService.getAllJobOffer().subscribe((data) => {
      this.offres = data

    }, (err) => {


    })

    this.showOffrePage()
  }

  showOffrePage() {
    this.modifOffre = new jobOffer();
    this.offre = new jobOffer();
    this.value = null

    this.errorAdd = false
    this.div1 = true;
    this.div2 = false;
    this.div3 = false;


  }

  showAjout(){

     this.offreService.getManager().subscribe((data)=>{
       this.managers=data
     },(err)=>{

     });


     this.div1=false;
     this.div2=true;
     this.div3=false;

   }
  showModif(id) {
    this.offreService.getJobOfferById(id).subscribe((data) => {

        this.modifOffre = data

      },
      (error: HttpErrorResponse) => {


      })

    this.div1 = false;
    this.div2 = false;
    this.div3 = true;

  }


  public openDetails(content, id) {
  this.cvs = []
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${OfferComponent.getDismissReason(reason)}`;
    });

    this.offreService.getJobOfferById(id).subscribe(data => {


      this.OneOffre = data
    },

      err => {
      });
    this.offreService.getMatchedCv(id).subscribe(data =>{
        this.cvs = data
      },

      err => {
      });
    }

  public openArchive(content, id) {

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${OfferComponent.getDismissReason(reason)}`;
    });

    this.offreService.getJobOfferById(id).subscribe(data => {


      this.OneOffre = data



    }, err => {


    });

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

  AjoutOffre() {

    // this.offre.skills=this.value

   /* if (!this.offre.skills || !this.offre.manager || !this.offre.equipe) {

      this.errorAdd = true
    } else {*/
   this.offre.manager=this.isConnected;
      this.offreService.addJobOffer(this.offre).subscribe(data => {
          this.errorAdd = false
          this.value = null


          setTimeout(() => {
            this.ngOnInit()
          }, 2000)
        },
        (err: HttpErrorResponse) => {
          if (err.status === 422) {
            console.log(err)

            this.errorAdd = true

          }


        });
    }



  /*setReplyTypeValue() {

    console.log(this.offre.manager)
    this.offre.equipe=""
    this.offreService.getEquipesByManager(this.offre.manager).subscribe((data)=>{
      this.equipes=data
      this.showEquipe=true

    },(err)=>{})

  }
*/
  archiverOffre() {
    console.log("ok")
    console.log(this.OneOffre);

    if(this.OneOffre.valide == true)
    {this.offreService.archivedJobOffer(this.OneOffre.idJobOffer, this.OneOffre).subscribe((data) => {
        console.log(data)
        window.location.reload()
      },
      (err: HttpErrorResponse) => {


      });}

      else{this.offreService.validateJobOffer(this.OneOffre,this.OneOffre.idJobOffer ).subscribe((data) => {
        console.log(data)
        window.location.reload()
      },
      (err: HttpErrorResponse) => {


      });}



  }


  updateOffre(id) {

    this.offreService.updateJoboffer(id, this.modifOffre).subscribe((data) => {

      this.errorAdd = true
      this.showOffrePage()

      setTimeout(() => {
        this.ngOnInit()
      }, 1000)


    }, (err: HttpErrorResponse) => {


      if (err.status === 422) {
        this.errorAdd = true

      }


    })


  }

  isManager() {
    return localStorage.getItem("user") === "true";
  }


}
