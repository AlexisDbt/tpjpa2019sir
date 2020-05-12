import { NgModule } from '@angular/core';
import { Routes, RouterModule} from "@angular/router";
import {AccueilUserComponent} from "./accueil-user/accueil-user.component";
import {ListUserComponent} from "./list-user/list-user.component";
import {CommonModule} from "@angular/common";

export const routes: Routes = [
  { path: '', component: AccueilUserComponent,
    children: [
      { path: 'list', component: ListUserComponent }
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: [
    AccueilUserComponent,
    ListUserComponent
  ]
})
export class UserRoutingModule { }
