import {Component, OnInit, ViewChild} from '@angular/core';
import {jobOffer} from "../../../models/jobOffer";
import {JobOfferService} from "../../../services/jobOffer/job-offer.service";
import {ej} from '@syncfusion/ej2-data/dist/global';
import { MatTableDataSource} from "@angular/material/table";
import { MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import data = ej.data;
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-list-job-offer',
  templateUrl: './list-job-offer.component.html',
  styleUrls: ['./list-job-offer.component.css']
})
export class ListJobOfferComponent implements OnInit {

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  displayedColumns: string[] = ['projectName', 'projectDescription', 'startDate', 'endDate', 'manager', 'archivage', 'suppression'];
  dataSource: MatTableDataSource<jobOffer>;
  row;
  rowId ;
  rowProjectName;
  rowProjectDescription;
  rowStartDate;
  rowEndDate;
  rowManager;
  idColumn;
  dialogRef;
  value;
  array: jobOffer[] = [];
  constructor(private jobOfferService: JobOfferService ,public dialog: MatDialog) {
  }
  ngOnInit() {setTimeout(() => {
    this.jobOfferService.getJobOffer().subscribe((data : jobOffer[]) => {
      console.log(data);

      this.array = data;


      this.dataSource = new MatTableDataSource(this.array);
      console.log(this.dataSource.data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sortingDataAccessor = (item, property) => {
        switch (property) {
          case 'projectName': return item.projectName;
          case 'startDate': return item.startDate;
          case 'endDate': return item.endDate;

          default: return item[property];
        }
      };
      this.dataSource.sort = this.sort;
      // @ts-ignore
      this.dataSource.filterPredicate = (order: Order, filter: string) => {
        const transformedFilter = filter.trim().toLowerCase();

        const listAsFlatString = (obj): string => {
          let returnVal = '';

          Object.values(obj).forEach((val) => {
            if (typeof val !== 'object') {
              returnVal = returnVal + ' ' + val;
            } else if (val !== null) {
              returnVal = returnVal + ' ' + listAsFlatString(val);
            }
          });

          return returnVal.trim().toLowerCase();
        };

        return listAsFlatString(order).includes(transformedFilter);
      };

    });
  });

  }
  showDiag(myTemplate, row) {
    this.rowProjectName = row.projectName;
    this.rowProjectDescription = row.projectDescription;
    this.rowStartDate = row.startDate;
    this.rowEndDate = row.endDate;
    this.rowManager = row.manager;

    const dialogRef = this.dialog.open(myTemplate);
  }

  onClick(): void {
    this.dialogRef.close();
  }
  applyFilter(filterValue: string) {
    const filters = filterValue.trim().toLowerCase();
    this.dataSource.filter = filters;
  }

  OnSearchClear() {
    this.value = '';
  }

  updateJobOffer(data)
  {
    this.jobOfferService.updateJoboffer(this.dataSource.data).subscribe(data => console.log(data), error => console.log(error));
  }
  archivedJobOffer(data,row)
  {
    this.jobOfferService.archivedJobOffer(row.id,this.dataSource.data).subscribe(data => console.log(data), error => console.log(error));
    this.deleteRowTable(this.rowId, this.idColumn, this.paginator, this.dataSource);
  }
 /* validateJobOffer(id)
  {
    this.jobOfferService.validateJobOffer(id).subscribe(data => console.log(data), error => console.log(error));
  }*/
  supprimerJobOffer(row) {
    this.rowId = row.id
    this.jobOfferService.deleteJobOffer(this. rowId).subscribe(() => console.log(row.id), error => console.log(error));
    this.deleteRowTable(this.rowId, this.idColumn, this.paginator, this.dataSource);
  }
  deleteRowTable(rowId, idColumn, paginator, dataSource) {
    this.dataSource.data = dataSource.data;
    const itemIndex = this.dataSource.data.findIndex(obj => obj[idColumn] === rowId);
    console.log(itemIndex);
    dataSource.data.splice(itemIndex, 1);
    console.log(dataSource.data);
    dataSource.paginator = paginator;
  }
}
