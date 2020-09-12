  import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
  import {quiz} from "../models/quiz";
  import {user} from "../models/user";
  import {jobOffer} from "../models/jobOffer";

const AUTH_API = 'http://localhost:8181/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      email: credentials.email,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      email: user.email,
      password: user.password,
      fName: user.FName,
    adress: user.adress,
    birthDate: user.birthDate,
    }, httpOptions);
  }
  getCurrentUser(id: string ): Observable<user> {
    return this.http.get<user>(AUTH_API + `user/` +`${id}`);
  }
  updateProfil(id: string, profil: user): Observable<user> {
    console.log(id);
    return this.http.put<user>(AUTH_API + `updateUser/` + id,profil);
  }
}
