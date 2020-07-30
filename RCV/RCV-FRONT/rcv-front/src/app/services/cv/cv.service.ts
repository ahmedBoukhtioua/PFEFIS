
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {TokenStorageService} from "../token-storage.service";

@Injectable({
  providedIn: 'root'
})
export class CvService {
  private baseUrl = 'http://localhost:8181/';
  constructor(private http: HttpClient,private tokenStorageService: TokenStorageService) { }


  pushFileToStorage(file: File, note): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    const user = this.tokenStorageService.getUser();

    formdata.append('file', file);
    formdata.append('note', note);
    const req = new HttpRequest('POST', this.baseUrl + 'api/cv/addcv/' + user.id, formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }
}
