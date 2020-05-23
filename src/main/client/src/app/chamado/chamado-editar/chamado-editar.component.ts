import { Component, OnInit } from '@angular/core';
import { ChamadoService } from '../chamado.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ChamadoEditarResource, ChamadoVO } from '../chamado';

@Component({
  selector: 'app-chamado-editar',
  templateUrl: './chamado-editar.component.html',
  styleUrls: ['./chamado-editar.component.css']
})
export class ChamadoEditarComponent implements OnInit {
  recurso: ChamadoEditarResource;
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
      this.criaFormulario(this.recurso.chamadoVO)
    });
  }

  getStatusList(){
    return this.recurso.statusList;
  }

  criaFormulario(chamadoVO: ChamadoVO){
    this.formChamado = this.formBuilder.group({
      id : [chamadoVO.id],
      descricao: [chamadoVO.descricao, [Validators.required, Validators.maxLength(150)]],
      dataHoraAbertura: [chamadoVO.dataHoraAbertura],
      dataHoraFechamento: [chamadoVO.dataHoraFechamento],
      status: [chamadoVO.status],
    });
  }

  salvar(){
    let vo = this.formChamado.getRawValue();
    console.log(vo)
    this.service.salvar(vo).subscribe( res => {
      console.log('salvo com sucesso');
      alert("Chamado alterado com sucesso");
    }, error => {
      alert(error);
    });
  }

}