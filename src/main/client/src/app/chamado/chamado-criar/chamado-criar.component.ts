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
  maxDescription: number = 250;
  
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
      titulo: ['', [Validators.required, Validators.maxLength(50)]],
      descricao: ['', [Validators.required, Validators.maxLength(this.maxDescription)]]
    });
  }

  charsLeft(){
    return this.maxDescription - this.formChamado.controls['descricao'].value.length;
  }

  criar(){
    this.service.criar(this.formChamado.getRawValue()).subscribe( res => {
      alert("Chamado criado com sucesso");
      this.router.navigateByUrl('/listar');
    }, error => {
      alert(error);
    })
  }

}
