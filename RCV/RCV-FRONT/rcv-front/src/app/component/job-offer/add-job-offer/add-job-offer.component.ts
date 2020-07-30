import { Component, OnInit } from '@angular/core';
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";
import {jobOffer} from "../../../models/jobOffer";

@Component({
  selector: 'app-add-job-offer',
  templateUrl: './add-job-offer.component.html',
  styleUrls: ['./add-job-offer.component.css']
})
export class AddJobOfferComponent implements OnInit {
  jobOffer: jobOffer = new jobOffer();

  constructor(private jobOfferService: JobOfferService) {
  }

  ngOnInit(): void {
  }

  addJobOffer() {
    this.jobOfferService.addJobOffer(this.jobOffer).subscribe(data => console.log(data), error => console.log(error));
  }


}
