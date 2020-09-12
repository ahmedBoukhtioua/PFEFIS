import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {quiz} from "../../models/quiz";
import {user} from "../../models/user";
import {reponse} from "../../models/Reponse";
 import {jobOffer} from "../../models/jobOffer";
import {AuthenticationService} from "../authentication.service";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private baseUrl = 'http://localhost:8181/api/quiz'
  private baseUrl1 = 'http://localhost:8181/api/reponse'

  constructor(private http: HttpClient) {
  }

  addQuiz(quiz: quiz): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/addQuiz/`, quiz);

  }

  updateQuiz(id:string,quiz: quiz): Observable<Object> {

    return this.http.put(`${this.baseUrl}` + `/updateQuiz/`+ id,quiz);
  }
  getQuiz(): Observable<quiz[]> {
    return this.http.get<quiz[]>(`${this.baseUrl}` + `/findAll`);
  }
  getQuizVisible(): Observable<quiz[]> {
    return this.http.get<quiz[]>(`${this.baseUrl}` + `/findAllVisible`);
  }
  getQuizNotVisible(): Observable<quiz[]> {
    return this.http.get<quiz[]>(`${this.baseUrl}` + `/findAllNotvisible`);
  }
  getQuizById(id : string): Observable<quiz> {
    return this.http.get<quiz>(`${this.baseUrl}` + `/findById/` + id);
  }

  visibleQuiz(id: string,quiz:quiz ): Observable<quiz> {
    return this.http.put<quiz>(`${this.baseUrl}` + `/visible/` + id ,quiz);
  }

  notVisibleQuiz(quiz: quiz, id: string): Observable<quiz> {
    return this.http.put<quiz>(`${this.baseUrl}` + `/notVisible/` + id,quiz);
  }

  deleteQuiz(id: String): Observable<quiz> {
    return this.http.delete<quiz>(`${this.baseUrl}` + `/delete/` + id);
  }
  getManager(): Observable<user> {
    return this.http.get<user>(`${this.baseUrl}` + `/findManagers`);
  }
  submit(reponse: reponse): Observable<Object> {
    return this.http.post(`${this.baseUrl1}` + `/submit`, reponse);
  }
  getReponseByUser(id:string) : Observable<Object> {
    return this.http.get<reponse>(`${this.baseUrl1}` + `/findReponseOfUser/` + id);
  }

}
