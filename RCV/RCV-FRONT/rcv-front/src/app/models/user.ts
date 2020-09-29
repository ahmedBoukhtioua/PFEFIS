import {jobOffer} from './jobOffer';
export class user{
 id : string;
 fname: string;
 email: string;
 adress: string;
  birthDate: Date;
  enable: boolean;
  //Cv: Cv;
  jobOfferList: jobOffer;
  eNumber: string;
  password:string;
  roles = [];

}
