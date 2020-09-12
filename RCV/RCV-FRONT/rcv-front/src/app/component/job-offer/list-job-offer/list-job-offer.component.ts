import {Component, OnInit, ViewChild} from '@angular/core';
import {jobOffer} from "../../../models/jobOffer";
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";
import {jqxGridComponent} from "jqwidgets-ng/jqxgrid";
import {jqxWindowComponent} from "jqwidgets-ng/jqxwindow";
import {jqxInputComponent} from "jqwidgets-ng/jqxinput";
import {jqxNumberInputComponent} from "jqwidgets-ng/jqxnumberinput";
import {jqxDateTimeInputComponent} from "jqwidgets-ng/jqxdatetimeinput";

import { HttpClient } from '@angular/common/http';

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
    this.jobOfferService.getAllJobOffer().subscribe(
      data => {
        this.ListOffre =data;

      }, error => console.log(error) );

  }
}
