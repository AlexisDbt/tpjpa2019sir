import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListUserComponent } from "./modules/user/list-user/list-user.component";
import { CommonModule} from "@angular/common";

const routes: Routes = [
  {path: 'utilisateurs', loadChildren: './modules/user/user.module#UserModule' },
  {path: 'reunion', loadChildren: './modules/reunion/reunion.module#ReunionModule'},
  {path: 'list-utilisateurs', component: ListUserComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
