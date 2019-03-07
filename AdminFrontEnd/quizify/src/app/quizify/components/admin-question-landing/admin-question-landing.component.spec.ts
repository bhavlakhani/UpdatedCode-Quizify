import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminQuestionLandingComponent } from './admin-question-landing.component';

describe('AdminQuestionLandingComponent', () => {
  let component: AdminQuestionLandingComponent;
  let fixture: ComponentFixture<AdminQuestionLandingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminQuestionLandingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminQuestionLandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
