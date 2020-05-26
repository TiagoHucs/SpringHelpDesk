// src/app/auth/role-guard.service.ts
import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot} from '@angular/router';
import { AuthService } from './auth.service';
import decode from 'jwt-decode';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class RoleGuardService implements CanActivate {

  constructor(
    public auth: AuthService, 
    public router: Router,
    private cookieService: CookieService) {
  }
  
  canActivate(route: ActivatedRouteSnapshot): boolean {

    const expectedRole = route.data.expectedRole;
    const token = this.cookieService.get('token');

    const tokenPayload = decode(token);
    console.log('tokenPayload:')
    console.log(decode(token))
    if (
      !this.auth.isAuthenticated() || 
      tokenPayload.role !== expectedRole
    ) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

}