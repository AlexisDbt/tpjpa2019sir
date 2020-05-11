import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccueilUserComponent } from './accueil-user/accueil-user.component';
import { NewUserComponent } from './new-user/new-user.component';
import { ListUserComponent } from './list-user/list-user.component';



@NgModule({
  declarations: [AccueilUserComponent, NewUserComponent, ListUserComponent],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
