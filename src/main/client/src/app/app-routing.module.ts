import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { ChamadoCriarComponent } from './layout/chamado/chamado-criar/chamado-criar.component';
import { ChamadoListarComponent } from './layout/chamado/chamado-listar/chamado-listar.component';
import { LoginComponent } from './security/login/login.component';
import { CadastroComponent } from './security/cadastro/cadastro.component';
import { ChamadoEditarComponent } from './layout/chamado/chamado-editar/chamado-editar.component';
import { AuthGuard } from './security/auth.guard';


const routes: Routes = [
  { path: '', redirectTo: 'login' , pathMatch: 'prefix' },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: CadastroComponent, canActivate: [AuthGuard] },
  { path: 'chamados',    component: LayoutComponent, // this is the component with the <router-outlet> in the template
    children: [ 
      { path: '', redirectTo: 'criar' , pathMatch: 'prefix' , canActivate: [AuthGuard] },
      {path: 'criar', component: ChamadoCriarComponent , canActivate: [AuthGuard]},
      {path: 'listar', component: ChamadoListarComponent , canActivate: [AuthGuard] },
      {path: 'editar/:id', component: ChamadoEditarComponent , canActivate: [AuthGuard] }
    ] }]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
