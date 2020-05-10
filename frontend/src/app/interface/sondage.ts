import {Participants} from "./participants";
import {ReponseSondage} from "./reponse-sondage";
import {Propositions} from "./propositions";

export interface Sondage {
  id: number;
  lienWeb: string;
  createur: Participants;
  reponses: ReponseSondage[];
  propositions: Propositions[];
}
