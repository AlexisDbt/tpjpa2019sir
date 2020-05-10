import {Participants} from "./participants";
import {Mail} from "./mail";

export interface Reunion {
  id: number;
  intitule: string;
  resume: string;
  date: Date;
  participants: Participants[];
  mail: Mail;
}
