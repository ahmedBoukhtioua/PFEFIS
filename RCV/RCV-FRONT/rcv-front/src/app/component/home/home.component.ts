  import { Component, OnInit } from '@angular/core';
  import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
  import {  Label } from 'ng2-charts';
  import {AuthenticationService} from "../../services/authentication.service";
  import {Router,NavigationEnd} from "@angular/router";
  import {JobOfferService} from "../../services/jobOffer/job-offer.service";
  import {HttpErrorResponse} from "@angular/common/http";
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
    public doughnutChartType = 'doughnut';
    public labels: Label[] = ['Archivé', 'Valide']

    public datasets: ChartDataSets[] = []


    public datasetOffre: ChartDataSets[] = []

    public options: ChartOptions = {
      legend: {
        display: false
      }
    };
    showPieCVs: boolean = false;
    showPieOffre: boolean = false;

    allCount = []
    OffreValide= [];

    constructor(private authService:AuthenticationService, private router: Router, private offreService: JobOfferService) {
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
    }


    pieOffre() {

      this.doughnutChartLabels = ['Valide','Archivé']

      this.offreService.getNombreOffreValide().subscribe((data)=>{
        this.doughnutChartData=data
      },(err)=>{})

      this.datasetOffre = [{
        data: this.doughnutChartData,
        backgroundColor: [
          'rgba(38,0,242,0.99)',
          'rgb(250,0,10)',
        ],
        borderColor: [
          'rgb(38,0,242)',
          'rgb(250,0,10)',
        ],
        borderWidth: 1
      }];




    }
  }
