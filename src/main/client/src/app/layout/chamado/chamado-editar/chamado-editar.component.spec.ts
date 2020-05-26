import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChamadoEditarComponent } from './chamado-editar.component';

describe('ChamadoEditarComponent', () => {
  let component: ChamadoEditarComponent;
  let fixture: ComponentFixture<ChamadoEditarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChamadoEditarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChamadoEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
