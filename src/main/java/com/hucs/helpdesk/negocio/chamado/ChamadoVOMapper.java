package com.hucs.helpdesk.negocio.chamado;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class ChamadoVOMapper extends CustomMapper<Chamado, ChamadoVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private MapperFacade mapper;

    @Override
    public void mapAtoB(Chamado a, ChamadoVO b, MappingContext context) {
        b.setStatusId(a.getStatus().getCodigo());
        b.setStatus(a.getStatus().getStatusChamadoVO());
    }

    @Override
    public void mapBtoA(ChamadoVO b, Chamado a, MappingContext context) {
        if(b.getStatusId() != null){
            a.setStatus(EStatusChamado.getWithCodigo(b.getStatusId()));
        }
        if(b.getStatus() != null){
            a.setStatus(EStatusChamado.getWithCodigo(b.getStatus().getCodigo()));
        }
    }

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Chamado.class, ChamadoVO.class)
                .customize(this)
                .exclude("status")
                .byDefault()
                .register();
    }
}
