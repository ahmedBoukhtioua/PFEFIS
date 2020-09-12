
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {TokenStorageService} from "../token-storage.service";
import {AuthenticationService} from "../authentication.service";
import {user} from "../../models/user";
import {jobOffer} from "../../models/jobOffer";
import {cv} from "../../models/Cv";

@Injectable({
  providedIn: 'root'
})
export class CvService {
  private baseUrl = 'http://localhost:8181/';
  constructor(private http: HttpClient,private AuthService: AuthenticationService) { }

  user1: user;
  pushFileToStorage(file: File, note): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    this.AuthService.getCurrentUser(localStorage.getItem('user')).subscribe((data)=>{
      this.user1=data;
      this.user1.id = data.id;

    }),
    formdata.append('file', file);
    formdata.append('note', note);
    const req = new HttpRequest('POST', this.baseUrl + 'api/cv/addcv/' + this.user1.id, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
  getAllCv(): Observable<cv[]> {
    return this.http.get<cv[]>(`${this.baseUrl}` + `api/cv/findAll`);
  }

archivedCv(id: string,cv: cv ): Observable<cv> {
  return this.http.put<cv>(`${this.baseUrl}` + `api/cv/archived/` + id,cv);
}
  validateCv(id: string,cv: cv ): Observable<cv> {
    return this.http.put<cv>(`${this.baseUrl}` + `api/cv/validate/` + id,cv);
  }
  getCvById(id : string): Observable<cv> {
    return this.http.get<cv>(`${this.baseUrl}` + `api/cv/findById/`+ `${id}`);
  }
}
