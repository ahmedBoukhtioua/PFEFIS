import {user} from "./user";
import {question} from "./question";

export class quiz{

  idQuiz: string;
  idRh: user;
  quizName: string;
  date: Date;
  visible: boolean;
  questionsList: question[];

}
