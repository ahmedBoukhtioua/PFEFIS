import {user} from "./user";
import {quiz} from "./quiz";

export class reponse{

  idReponse: string;
  idQuiz: quiz;
  idUser:user;
  date: Date;
  reponses : Array<string>;
  score: number;

}
