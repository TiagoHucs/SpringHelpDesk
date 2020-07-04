import { Component, OnInit } from '@angular/core';
import { ChamadoService } from '../chamado.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ChamadoEditarResource, ChamadoVO, StatusChamadoVO } from '../chamado';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-chamado-editar',
  templateUrl: './chamado-editar.component.html',
  styleUrls: ['./chamado-editar.component.css']
})
export class ChamadoEditarComponent implements OnInit {
  recurso: ChamadoEditarResource;
  formChamado: FormGroup;
  maxDescription: number = 250;
  
  constructor(
    private route: ActivatedRoute,
    private service: ChamadoService,
    private formBuilder: FormBuilder,
    private notifierService: NotifierService) { 
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
    }, err => {
      console.log(err.error);
 //     this.snotifyService.error(err.error.msg);
    });
  }

  getStatusList(){
    return this.recurso.statusList;
  }

  criaFormulario(chamadoVO: ChamadoVO){
    this.formChamado = this.formBuilder.group({
      id : [chamadoVO.id],
      titulo: [chamadoVO.titulo, [Validators.required, Validators.maxLength(50)]],
      descricao: [chamadoVO.descricao, [Validators.required, Validators.maxLength(250)]],
      dataHoraAbertura: [chamadoVO.dataHoraAbertura],
      dataHoraFechamento: [chamadoVO.dataHoraFechamento],
      statusId: [chamadoVO.statusId],
    });
  }

  salvar(){
    let vo = this.formChamado.getRawValue();
    this.service.salvar(vo).subscribe( res => {
      this.notifierService.notify("success","Chamado alterado com sucesso");
    }, error => {
      this.notifierService.notify("error","Erro ao alterar chamado");
    });
  }



  charsLeft(){
    return this.maxDescription - this.formChamado.controls['descricao'].value.length;
  }

}