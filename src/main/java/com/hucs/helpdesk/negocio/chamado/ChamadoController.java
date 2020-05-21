package com.hucs.helpdesk.negocio.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public ResponseEntity<Void> criar(@RequestBody ChamadoVO chamadoVo) {
        service.criar(chamadoVo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/obter/{id}", method = RequestMethod.GET)
    public ResponseEntity<ChamadoVO> obter(@PathVariable Long id) {
        //TODO: criar mapper
        Chamado chamado = service.obter(id);
        ChamadoVO chamadoVO = ChamadoVO.builder()
                .id(chamado.getId())
                .dataHoraAbertura(chamado.getDataHoraAbertura())
                .dataHoraFechamento(chamado.getDataHoraFechamento())
                .status(chamado.getStatus())
                .descricao(chamado.getDescricao())
                .build();
        return ResponseEntity.ok().body(chamadoVO);
    }

    @RequestMapping(value = "/encerrar", method = RequestMethod.POST)
    public ResponseEntity<Void> encerrar(@RequestBody ChamadoVO vo) {
        service.encerrar(vo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
