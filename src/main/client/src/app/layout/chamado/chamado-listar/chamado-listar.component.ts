import { Component, OnInit } from '@angular/core';
import { ChamadoService } from '../chamado.service';

@Component({
  selector: 'app-chamado-listar',
  templateUrl: './chamado-listar.component.html',
  styleUrls: ['./chamado-listar.component.css']
})
export class ChamadoListarComponent implements OnInit {
  chamados: any[];

  constructor(private service: ChamadoService) { }

  ngOnInit() {
    this.service.listar().subscribe( res => {
      this.chamados = res;
    })
  }

  getClass(codigo: string){
    return codigo == '1' ? 'aberto' : codigo == '2' ? 'andamento' : 'fechado';
  }

  temChamados(){
    return this.chamados.length > 0;
  }

}