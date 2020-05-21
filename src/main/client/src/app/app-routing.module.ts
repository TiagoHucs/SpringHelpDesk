import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChamadoCriarComponent } from './chamado/chamado-criar/chamado-criar.component';
import { ChamadoListarComponent } from './chamado/chamado-listar/chamado-listar.component';
import { ChamadoEditarComponent } from './chamado/chamado-editar/chamado-editar.component';

const routes: Routes = [
  { path: '', redirectTo: 'listar', pathMatch: 'prefix' },
  { path: 'listar', component: ChamadoListarComponent },
  { path: 'criar', component: ChamadoCriarComponent },
  { path: 'editar/:id', component: ChamadoEditarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
