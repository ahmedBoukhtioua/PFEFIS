import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {jobOffer} from "../../models/jobOffer";
import {user} from '../../models/user';
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class JobOfferService {
  private baseUrl = 'http://localhost:8181/api/jobOffer'

  constructor(private http: HttpClient) {
  }

  addJobOffer(jobOffer: jobOffer): Observable<Object> {
    console.log(jobOffer);
    return this.http.post(`${this.baseUrl}` + `/add/`, jobOffer);

  }

  updateJoboffer(id:string,job: jobOffer): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update/` +id,job);
  }

  getJobOfferArchived(): Observable<jobOffer[]> {
    return this.http.get<jobOffer[]>(`${this.baseUrl}` + `/findAllArchived`);
  }
  getJobOfferValide(): Observable<jobOffer[]> {
    return this.http.get<jobOffer[]>(`${this.baseUrl}` + `/findAllValide`);
  }
  getAllJobOffer(): Observable<jobOffer[]> {
    return this.http.get<jobOffer[]>(`${this.baseUrl}` + `/findAll`);
  }
  getJobOfferById(id : string): Observable<jobOffer> {
    return this.http.get<jobOffer>(`${this.baseUrl}` + `/findById/`+ `${id}`);
  }
  getManager(): Observable<user> {
    return this.http.get<user>(`${this.baseUrl}` + `/findManagers`);
  }
  archivedJobOffer(id: string,jobOffer: jobOffer ): Observable<jobOffer> {
    return this.http.put<jobOffer>(`${this.baseUrl}` + `/archived/` + id,jobOffer);
  }

  validateJobOffer(jobOffer: jobOffer, id: string): Observable<jobOffer> {
    return this.http.put<jobOffer>(`${this.baseUrl}` + `/validate/` + id,jobOffer);
  }
  getJobOfferByUser(manager: user): Observable<Object> {
    return this.http.get(`${this.baseUrl}` + `/findAllConnected/` + manager);
  }
  deleteJobOffer(id: String): Observable<jobOffer> {
    return this.http.delete<jobOffer>(`${this.baseUrl}` + `/supprimerJobOffer/` + `${id}`);
  }

}
