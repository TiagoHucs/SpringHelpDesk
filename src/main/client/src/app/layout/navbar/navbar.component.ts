import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import decode from 'jwt-decode';
import { UserService } from '../../security/usuario.service';
import { AuthService } from '../../security/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username: string;

  constructor(private authService: AuthService,
              private router: Router,
              private cookieService: CookieService,
              public userService: UserService){
  }

  ngOnInit(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    console.log(tokenPayload)
    this.username = tokenPayload.sub;
  }


  signOut() : void {
    this.cookieService.delete('token');
    window.location.href = '/login';
    window.location.reload();
  }

}
