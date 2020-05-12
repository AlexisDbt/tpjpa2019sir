import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccueilReunionComponent } from './accueil-reunion/accueil-reunion.component';
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [AccueilReunionComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class ReunionModule { }
