package com.hucs.helpdesk.negocio.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Chamado> listar(){
        return service.listar();
    }

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody ChamadoVO vo) {
        service.criar(vo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ResponseEntity<Void> editar(@RequestBody ChamadoVO vo) {
        service.editar(vo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/encerrar", method = RequestMethod.POST)
    public ResponseEntity<Void> encerrar(@RequestBody ChamadoVO vo) {
        service.encerrar(vo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
