import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Participants} from "../interface/participants";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseRoute: string;
  userRoute: string;

  constructor(private http: HttpClient) {
    this.baseRoute = 'http://localhost:4200/rest/';
    this.userRoute = 'participants/list'
  }

  getAllParticipants(): Observable<Participants[]> {
    return this.http.get<Participants[]>(`${this.baseRoute + this.userRoute}`);
  }
}
