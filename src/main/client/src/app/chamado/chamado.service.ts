import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';
import { Chamado } from './chamado';

@Injectable({
  providedIn: 'root'
})
export class ChamadoService {

  URL: string = 'chamado/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${API_URL}${this.URL}listar`);
  }

  public criar(chamadoVo: Chamado): Observable<any> {
    return this.http.post(`${API_URL}${this.URL}criar`, chamadoVo);
  }

  public obter(id: string): Observable<Chamado> {
    return this.http.get<Chamado>(`${API_URL}${this.URL}obter/${id}`);
  }
}
