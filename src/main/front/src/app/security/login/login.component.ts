import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { CookieService } from 'ngx-cookie-service';

import { UserService } from '../usuario.service';
import { CurrentUser, User } from './usuario';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup;
  loading: boolean;
  user = new User('', '', '', '');
  message: string;

  constructor(private userService: UserService,
    private router: Router,
    private cookieService: CookieService,
    private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.criaFormulario()
    let token = this.cookieService.get('token');
    if (token) {// refresh de quem ???????????????
      this.userService.refresh(this.user).subscribe((userAuthentication: CurrentUser) => {
        this.cookieService.set('token', userAuthentication.token)
        this.router.navigate(['/']);
      });
    } 
  }

  criaFormulario(){
    this.formLogin = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  login() {
    console.log('logarrrrrrrrrr')
    this.message = '';
    this.loading = true;
    this.userService.login(this.formLogin.getRawValue()).subscribe((userAuthentication: CurrentUser) => {
      this.cookieService.set('token', userAuthentication.token)
      this.router.navigate(['/chamados']);
      this.loading = false;
    }, err => {
      this.message = err.error.message;
      this.loading = false;
    });
  }

  cancelLogin() {
    this.cookieService.delete('token');
    this.message = '';
    window.location.href = '/login';
    window.location.reload();
  }

  getFormGroupClass(isInvalid: boolean, isDirty: boolean): {} {
    return {
      'form-group': true,
      'has-error': isInvalid && isDirty,
      'has-success': !isInvalid && isDirty
    };
  }

  setUsuario() {
    this.user.email = 'usuario@system.com';
    this.user.password = '112233';
    console.log(this.user)
  }

  setAdmin() {
    this.user.email = 'admin@system.com';
    this.user.password = '123456';
    console.log(this.user)
  }
}