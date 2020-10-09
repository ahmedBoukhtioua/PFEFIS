
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {TokenStorageService} from "../token-storage.service";
import {AuthenticationService} from "../authentication.service";
import {user} from "../../models/user";
import {jobOffer} from "../../models/jobOffer";
import {cv} from "../../models/Cv";
import {NavigationEnd, Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CvService {
  private baseUrl = 'http://localhost:8181/';
  user1: user;

  constructor(private http: HttpClient,private router: Router,private AuthService: AuthenticationService) {


  }

  pushFileToStorage(file: File, note,id): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    formdata.append('note', note);
    const req = new HttpRequest('POST', this.baseUrl + 'api/cv/addcv/' + id, formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    console.log(id)

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
  getNombreCVValide(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}` + `api/cv/nombreCvValide`);
  }

  getNombreCVAll(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}` + `api/cv/getAllNombreCV`);
  }
}
