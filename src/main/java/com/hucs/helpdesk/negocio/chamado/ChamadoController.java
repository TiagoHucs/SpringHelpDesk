package com.hucs.helpdesk.negocio.chamado;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<ChamadoVO>> listar() {
        List<ChamadoVO> lista = mapper.mapAsList(service.listar(), ChamadoVO.class);
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody ChamadoVO chamadoVO) {
        Chamado chamado = mapper.map(chamadoVO, Chamado.class);
        service.criar(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/obter/{id}", method = RequestMethod.GET)
    public ResponseEntity<ChamadoEditarResource> obter(@PathVariable Long id) {
        ChamadoVO chamadoVO = mapper.map(service.obter(id), ChamadoVO.class);
        ChamadoEditarResource resource = ChamadoEditarResource.builder()
                .chamadoVO(chamadoVO)
                .statusList(mapper.mapAsList(EStatusChamado.valuesList(),StatusChamadoVO.class))
                .build();
        return ResponseEntity.ok().body(resource);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody ChamadoVO chamadoVO) {
        Chamado chamado = mapper.map(chamadoVO,Chamado.class);
        service.salvar(chamado);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
