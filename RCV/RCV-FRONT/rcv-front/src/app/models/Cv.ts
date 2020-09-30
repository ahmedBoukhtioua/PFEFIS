import {user} from "./user";
import {divisionList} from "./divisionList";

export class cv{
  id: string;
  user:user;
  divisionList: Array<string> ;
  languesList: Array<string> ;
  note: number;
  picture: string;
  archived: boolean;
  date: Date;


}
