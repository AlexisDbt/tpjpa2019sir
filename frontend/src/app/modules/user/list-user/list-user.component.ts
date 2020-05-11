import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Participants} from "../../../interface/participants";

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  constructor(private userService: UserService) { }

  userList: Participants[] = [];

  ngOnInit() {
    this.userService.getAllParticipants().subscribe(
      res => {
        this.userList = res;
      }
    )
  }

}
