import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccueilUserComponent } from './accueil-user/accueil-user.component';
import { NewUserComponent } from './new-user/new-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { UserRoutingModule} from "./user-routing.module";
import { RouterModule} from "@angular/router";
import { FormsModule } from "@angular/forms";

@NgModule({
  declarations: [AccueilUserComponent, NewUserComponent, ListUserComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    RouterModule,
    FormsModule
  ]
})
export class UserModule { }
