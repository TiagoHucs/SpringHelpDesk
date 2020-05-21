import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChamadoListarComponent } from './chamado-listar/chamado-listar.component';
import { ChamadoCriarComponent } from './chamado-criar/chamado-criar.component';
import { ChamadoEditarComponent } from './chamado-editar/chamado-editar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [ChamadoListarComponent, ChamadoCriarComponent, ChamadoEditarComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule
  ]
})
export class ChamadoModule { }
