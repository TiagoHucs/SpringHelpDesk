import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { ChamadoCriarComponent } from './layout/chamado/chamado-criar/chamado-criar.component';
import { ChamadoListarComponent } from './layout/chamado/chamado-listar/chamado-listar.component';
import { LoginComponent } from './security/login/login.component';
import { CadastroComponent } from './security/cadastro/cadastro.component';
import { ChamadoEditarComponent } from './layout/chamado/chamado-editar/chamado-editar.component';


const routes: Routes = [
  { path: '', redirectTo: 'login' , pathMatch: 'prefix' },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'chamados',
    component: LayoutComponent, // this is the component with the <router-outlet> in the template
    children: [ 
      { path: '', redirectTo: 'criar' , pathMatch: 'prefix' },
      {path: 'criar', component: ChamadoCriarComponent},
      {path: 'listar', component: ChamadoListarComponent },
      {path: 'editar/:id', component: ChamadoEditarComponent }
    ] }]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
