import {Sondage} from "./sondage";

export interface ReponseSondage {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  sondage: Sondage;
}
