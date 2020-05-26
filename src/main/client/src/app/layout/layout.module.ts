import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ChamadoCriarComponent } from './chamado/chamado-criar/chamado-criar.component';
import { ChamadoListarComponent } from './chamado/chamado-listar/chamado-listar.component';
import { ChamadoEditarComponent } from './chamado/chamado-editar/chamado-editar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserService } from '../security/usuario.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthGuard } from '../security/auth.guard';
import { RoleGuardService } from '../security/role.guard.service';
import { AuthService } from '../security/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from '../security/auth.interceptor';

@NgModule({
  declarations: [LayoutComponent, ChamadoCriarComponent, ChamadoListarComponent, ChamadoEditarComponent,  NavbarComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class LayoutModule { }
