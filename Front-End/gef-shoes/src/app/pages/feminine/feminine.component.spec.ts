import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeminineComponent } from './feminine.component';

describe('FeminineComponent', () => {
  let component: FeminineComponent;
  let fixture: ComponentFixture<FeminineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeminineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FeminineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
