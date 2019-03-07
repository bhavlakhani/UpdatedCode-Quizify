import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGameLandingComponent } from './admin-game-landing.component';

describe('AdminGameLandingComponent', () => {
  let component: AdminGameLandingComponent;
  let fixture: ComponentFixture<AdminGameLandingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminGameLandingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminGameLandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
