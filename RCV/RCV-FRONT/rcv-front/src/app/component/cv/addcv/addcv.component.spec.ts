import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcvComponent } from './addcv.component';

describe('AddcvComponent', () => {
  let component: AddcvComponent;
  let fixture: ComponentFixture<AddcvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddcvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
