import { Component, OnInit } from '@angular/core';
import { ChamadoService } from '../chamado.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chamado-criar',
  templateUrl: './chamado-criar.component.html',
  styleUrls: ['./chamado-criar.component.css']
})
export class ChamadoCriarComponent implements OnInit {
  formChamado: FormGroup;
  
  constructor(
    private router: Router,
    private service: ChamadoService,
    private formBuilder: FormBuilder) { 
  }

  ngOnInit() {
    this.criaFormulario();
  }

  criaFormulario(){
    this.formChamado = this.formBuilder.group({
      descricao: ['', [Validators.required, Validators.maxLength(150)]]
    });
  }

  criar(){
    this.service.criar(this.formChamado.getRawValue()).subscribe( res => {
      console.log('chamado criado')
      this.router.navigateByUrl('/listar');
    }, error => {
      console.log(error)
    })
  }

}
