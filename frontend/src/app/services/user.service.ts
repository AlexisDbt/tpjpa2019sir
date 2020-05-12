import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Participants} from "../interface/participants";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseRoute: string;
  userRoute: string;

  constructor(private http: HttpClient) {
    this.baseRoute = 'http://localhost:4200/rest/';
    this.userRoute = 'participants/'
  }

  getAllParticipants() {
    return this.http.get<Participants[]>(`${this.baseRoute + this.userRoute}`)
  }
}
