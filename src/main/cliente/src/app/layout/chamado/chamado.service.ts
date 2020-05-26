import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';
import { ChamadoVO, ChamadoEditarResource } from './chamado';

@Injectable({
  providedIn: 'root'
})
export class ChamadoService {

  URL: string = 'chamado/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${API_URL}${this.URL}listar`);
  }

  public criar(chamadoVo: ChamadoVO): Observable<any> {
    return this.http.post(`${API_URL}${this.URL}criar`, chamadoVo);
  }

  public obter(id: string): Observable<ChamadoEditarResource> {
    return this.http.get<ChamadoEditarResource>(`${API_URL}${this.URL}obter/${id}`);
  }

  public salvar(chamadoVo: ChamadoVO): Observable<any> {
    return this.http.post(`${API_URL}${this.URL}salvar`, chamadoVo);
  }
}