import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChamadoListarComponent } from './chamado-listar.component';

describe('ChamadoListarComponent', () => {
  let component: ChamadoListarComponent;
  let fixture: ComponentFixture<ChamadoListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChamadoListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChamadoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
