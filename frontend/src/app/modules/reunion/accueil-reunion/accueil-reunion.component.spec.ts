import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilReunionComponent } from './accueil-reunion.component';

describe('AccueilReunionComponent', () => {
  let component: AccueilReunionComponent;
  let fixture: ComponentFixture<AccueilReunionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilReunionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilReunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
