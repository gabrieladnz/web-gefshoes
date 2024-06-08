import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GefworldComponent } from './gefworld.component';

describe('GefworldComponent', () => {
  let component: GefworldComponent;
  let fixture: ComponentFixture<GefworldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GefworldComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GefworldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
