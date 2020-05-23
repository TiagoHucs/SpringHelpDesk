package com.hucs.helpdesk.negocio.chamado;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
        List<StatusChamadoVO> statusList = service.getStatusList();
        ChamadoEditarResource resource = ChamadoEditarResource.builder()
                .chamadoVO(chamadoVO)
                .statusList(statusList)
                .build();
        return ResponseEntity.ok().body(resource);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody ChamadoVO chamadoVO) {
        service.salvar(chamadoVO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
