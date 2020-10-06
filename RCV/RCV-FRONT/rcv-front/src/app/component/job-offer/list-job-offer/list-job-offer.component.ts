import {Component} from '@angular/core';
import {jobOffer} from "../../../models/jobOffer";
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";


@Component({
  selector: 'app-list-job-offer',
  templateUrl: './list-job-offer.component.html',
  styleUrls: ['./list-job-offer.component.css']
})
export class ListJobOfferComponent  {

ListOffre: jobOffer[];
  constructor(private jobOfferService: JobOfferService) {
  }



  ngOnInit(): void {
    this.jobOfferService.getJobOfferValide().subscribe(
      data => {
        this.ListOffre =data;

      }, error => console.log(error) );

  }
}
