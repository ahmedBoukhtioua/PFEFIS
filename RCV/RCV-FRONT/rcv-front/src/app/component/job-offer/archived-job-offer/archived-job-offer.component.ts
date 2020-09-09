import {Component, OnInit, ViewChild} from '@angular/core';
import {jobOffer} from "../../../models/jobOffer";
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";
import {jqxGridComponent} from "jqwidgets-ng/jqxgrid";
import {jqxWindowComponent} from "jqwidgets-ng/jqxwindow";
import {jqxInputComponent} from "jqwidgets-ng/jqxinput";
import {jqxNumberInputComponent} from "jqwidgets-ng/jqxnumberinput";
import {jqxDateTimeInputComponent} from "jqwidgets-ng/jqxdatetimeinput";

import { HttpClient } from '@angular/common/http';
import {conditionallyCreateMapObjectLiteral} from "@angular/compiler/src/render3/view/util";

@Component({
  selector: 'app-archived-job-offer',
  templateUrl: './archived-job-offer.component.html',
  styleUrls: ['./archived-job-offer.component.css']
})
export class ArchivedJobOfferComponent  {
 /*


   @ViewChild('myGrid', { static: false }) myGrid: jqxGridComponent;
   @ViewChild('myWindow', { static: false }) myWindow: jqxWindowComponent;
   @ViewChild('projectName', { static: false }) projectName: jqxInputComponent;
   @ViewChild('id', { static: false }) id: jqxInputComponent;
   @ViewChild('projectDescription', { static: false }) projectDescription: jqxInputComponent;
   @ViewChild('startDate', { static: false }) startDate: jqxDateTimeInputComponent;
   @ViewChild('endDate', { static: false }) endDate: jqxDateTimeInputComponent;
   @ViewChild('manager', { static: false }) manager: jqxNumberInputComponent;

   data: jobOffer[];
   editrow: string;

   constructor(private jobOfferService: JobOfferService) {
  }

   public source: any  =
   {
      datatype: 'local',
      datafields: [

        { name: 'projectName', type: 'string' },
        { name: 'id', type: 'string' },
        { name: 'projectDescription', type: 'string' },
        { name: 'startDate', type: 'date' },
        { name: 'endDate', type: 'date' },
        { name: 'manager', type: 'string' },
      ],
      dataType: 'array'

    };

   dataAdapter = new jqx.dataAdapter(this.source);
   tempIndexHolder: string;

   getWidth() : any {
    if (document.body.offsetWidth < 850) {
      return '90%';
    }

    return 850;
  }
   columns: any[] =
   [

   { text: 'id', datafield: 'id', width: 200 },
   { text: 'Project Name', datafield: 'projectName', width: 200 },
   { text: 'Project Description', datafield: 'projectDescription', width: 400 },
   { text: 'Start Date', datafield: 'startDate', width: 200 },
   { text: 'End Date', datafield: 'endDate', width: 200 },
   { text: 'Manager', datafield: 'manager', width: 200 },
   {
      text: 'Edit', datafield: 'Edit', columntype: 'button',
      cellsrenderer: (): string => {
        return 'Edit';
      },
      buttonclick: (row: string): void => {
        //get the data and append in to the inputs
        this.editrow = row;
        let dataRecord = this.myGrid.getrowdatabyid(this.editrow);
        this.id.val(dataRecord.id);
        this.projectName.val(dataRecord.projectName);
        this.projectDescription.val(dataRecord.projectDescription);
        this.startDate.value(dataRecord.startDate);
        this.endDate.value(dataRecord.endDate);
        this.manager.val(dataRecord.manager);
        // show the popup window.
        this.myWindow.position({ x: 68, y: 368 });
        this.myWindow.open();
      }
    }

   ];
   saveBtn(): void {

      let j = new jobOffer();
      j.idJobOffer = this.id.val();
      j.projectName = this.projectName.val();
      j.projectDescription = this.projectDescription.val();
      j.startDate = this.startDate.value();
      j.endDate = this.endDate.value();

      this.jobOfferService.updateJoboffer(j.idJobOffer, j).subscribe(i => {
        console.log(i)
      })

  }
   cancelBtn(): void {
    this.myWindow.hide();
  }


   ngOnInit(): void {
    this.jobOfferService.getJobOfferValide().subscribe(
      data => {
        this.source.localdata = data;
        console.log(this.source.localdata );
        this.dataAdapter = new jqx.dataAdapter(this.source);
      })

  }
   updateJobOffer()
   {

   // this.jobOfferService.updateJoboffer().subscribe(data => console.log(data), error => console.log(error));
  }
   archivedJobOffer()
   {
   // this.jobOfferService.archivedJobOffer().subscribe(data => console.log(data), error => console.log(error));
  }
   /* validateJobOffer(id)
   {
    this.jobOfferService.validateJobOffer(id).subscribe(data => console.log(data), error => console.log(error));
  }*/
    //supprimerJobOffer( {
    // this.jobOfferService.deleteJobOffer().subscribe(() => console.log(row.id), error => console.log(error));
    // }
  /*settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      projectName: {
        title: 'First Name',
        type: 'string',
      },
    },
  };



  source: ServerDataSource;

  constructor(private http: HttpClient) {

    this.source = new ServerDataSource(http, { dataKey: 'resource', endPoint:'http://localhost:8181/api/jobOffer/findAllArchived' })
    console.log(this.source)
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
*/
}
