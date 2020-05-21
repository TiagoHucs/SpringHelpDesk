import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChamadoCriarComponent } from './chamado-criar.component';

describe('ChamadoCriarComponent', () => {
  let component: ChamadoCriarComponent;
  let fixture: ComponentFixture<ChamadoCriarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChamadoCriarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChamadoCriarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
