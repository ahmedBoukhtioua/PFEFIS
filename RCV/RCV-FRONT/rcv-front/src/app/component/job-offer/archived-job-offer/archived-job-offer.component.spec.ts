import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivedJobOfferComponent } from './archived-job-offer.component';

describe('ArchivedJobOfferComponent', () => {
  let component: ArchivedJobOfferComponent;
  let fixture: ComponentFixture<ArchivedJobOfferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArchivedJobOfferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArchivedJobOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
