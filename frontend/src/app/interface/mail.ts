import {Participants} from "./participants";
import {Reunion} from "./reunion";

export interface Mail {
  participants: Participants[];
  reunions: Reunion[];
  lienPause: string;
  code: string;
  lienPad: string;
  id: number;
}
