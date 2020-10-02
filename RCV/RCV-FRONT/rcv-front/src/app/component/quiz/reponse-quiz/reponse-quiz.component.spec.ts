import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReponseQuizComponent } from './reponse-quiz.component';

describe('ReponseQuizComponent', () => {
  let component: ReponseQuizComponent;
  let fixture: ComponentFixture<ReponseQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReponseQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReponseQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
