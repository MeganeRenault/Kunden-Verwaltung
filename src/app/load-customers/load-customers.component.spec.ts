import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadCustomersComponent } from './load-customers.component';

describe('LoadCustomersComponent', () => {
  let component: LoadCustomersComponent;
  let fixture: ComponentFixture<LoadCustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoadCustomersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoadCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
