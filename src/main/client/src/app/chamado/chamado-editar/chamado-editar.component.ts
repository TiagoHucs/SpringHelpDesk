import { Component, OnInit } from '@angular/core';
import { ChamadoService } from '../chamado.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Chamado } from '../chamado';

@Component({
  selector: 'app-chamado-editar',
  templateUrl: './chamado-editar.component.html',
  styleUrls: ['./chamado-editar.component.css']
})
export class ChamadoEditarComponent implements OnInit {
  recurso: Chamado;
  formChamado: FormGroup;
  
  constructor(
    private route: ActivatedRoute,
    private service: ChamadoService,
    private formBuilder: FormBuilder) { 
  }

  ngOnInit() {
    this.obterIdDaRota();
  }

  obterIdDaRota(){
    this.route.paramMap.subscribe(params => {
      this.obterChamadoOriginal(params.get('id'));
    });
  }

  obterChamadoOriginal(id: string){
    this.service.obter(id).subscribe( res => {
      this.recurso = res;
      this.criaFormulario(this.recurso)
    });
  }

  criaFormulario(chamado: Chamado){
    this.formChamado = this.formBuilder.group({
      id : [chamado.id],
      descricao: [chamado.descricao, [Validators.required, Validators.maxLength(150)]],
      dataHoraAbertura: [chamado.dataHoraAbertura],
      dataHoraFechamento: [chamado.dataHoraFechamento],
      status: [chamado.status],
    });
  }

}