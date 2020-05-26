import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import decode from 'jwt-decode';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { User } from './login/usuario';
import { API_URL } from '../app.url.dev';

@Injectable()
export class UserService {

  constructor(
    private http: HttpClient,
    private cookieService: CookieService){
    }

  getRole(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    return tokenPayload.role;
  }

  getUsername(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    return tokenPayload.sub;
  }

  getUsername2(): Observable<any> {
    return this.http.get(`${API_URL}perfil`);
  }

  login(user: User){
    return this.http.post(`${API_URL}auth`,user);
  }

  refresh(user: User){
    return this.http.post(`${API_URL}refresh`,user);
  }

  createOrUpdate(user: User){
    if(user.id != null && user.id != ''){
      console.log('user com id vou chamar endpoint de atualizaçaõ')
      return this.http.put(`${API_URL}user/update`,user);
    } else {
      user.id = null;
      console.log('user sem id vou chamar endpoint de criação')
      return this.http.post(`${API_URL}user/cadastrar `, user);
    }
  }

  findAll(page:number,count:number){
    return this.http.get(`${API_URL}api/user/${page}/${count}`);
  }

  findById(id:string){
    return this.http.get(`${API_URL}api/user/${id}`);
  }

  delete(id:string){
    return this.http.delete(`${API_URL}api/user/${id}`);
  }
}