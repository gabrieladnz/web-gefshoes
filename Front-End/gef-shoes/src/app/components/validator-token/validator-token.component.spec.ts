import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidatorTokenComponent } from './validator-token.component';

describe('ValidatorTokenComponent', () => {
  let component: ValidatorTokenComponent;
  let fixture: ComponentFixture<ValidatorTokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ValidatorTokenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ValidatorTokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
