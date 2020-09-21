  import { Component, OnInit } from '@angular/core';
  import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
  import {  Label } from 'ng2-charts';
  import {AuthenticationService} from "../../services/authentication.service";
  import {Router,NavigationEnd} from "@angular/router";
  import {JobOfferService} from "../../services/jobOffer/job-offer.service";
  import {HttpErrorResponse} from "@angular/common/http";
  import {CvService} from "../../services/cv/cv.service";
  @Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
  })
  export class HomeComponent implements OnInit {
    navigationSubscription
    public type: ChartType = 'line';
    public doughnutChartLabels = [];
    public doughnutChartData = [];
    public doughnutChartDataCV = [];
    public doughnutChartType = 'doughnut';

    public datasets: ChartDataSets[] = []


    public datasetOffre: ChartDataSets[] = []
    public datasetCV: ChartDataSets[] = []



    public options: ChartOptions = {
      legend: {
        display: false
      }
    };
    showPieCVs: boolean = false;
    showPieOffre: boolean = false;

    allCount = []
    allCountCv = []
    OffreValide= [];

    constructor(private cvService:CvService, private router: Router, private offreService: JobOfferService) {
      this.navigationSubscription = this.router.events.subscribe((e: any) => {
        // If it is a NavigationEnd event re-initalise the component
        if (e instanceof NavigationEnd) {
          this.ngOnInit();
        }
      });
    }

    ngOnInit() {
      this.offreService.getNombreAll().subscribe((data) => {
        this.allCount = data

      }, (err) => {
      })
      this.pieOffre()
      this.cvService.getNombreCVAll().subscribe((data) => {
        this.allCountCv = data

      }, (err) => {
      })
      this.pieCV()



    }


    pieOffre() {

      this.doughnutChartLabels = ['Valide','Archivé']

      this.offreService.getNombreOffreValide().subscribe((data)=>{
        this.doughnutChartData=data
      },(err)=>{})

      this.datasetOffre = [{
        data: this.doughnutChartData,
        backgroundColor: [
          'rgba(57,255,43,0.99)',
          'rgb(169,169,169)',
        ],
        borderColor: [
          'rgb(57,255,43)',
          'rgb(169,169,169)',
        ],
        borderWidth: 1
      }];




    }
    pieCV() {

      this.doughnutChartLabels = ['Valide','Archivé']

      this.cvService.getNombreCVValide().subscribe((data)=>{
        this.doughnutChartDataCV=data
      },(err)=>{})

      this.datasetCV = [{
        data: this.doughnutChartDataCV,
        backgroundColor: [
          'rgba(57,255,43,0.99)',
          'rgb(169,169,169)',
        ],
        borderColor: [
          'rgb(57,255,43)',
          'rgb(169,169,169)',
        ],
        borderWidth: 1
      }];




    }
  }
