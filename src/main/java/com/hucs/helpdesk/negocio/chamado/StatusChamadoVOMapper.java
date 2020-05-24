package com.hucs.helpdesk.negocio.chamado;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StatusChamadoVOMapper extends CustomMapper<EStatusChamado, StatusChamadoVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public void mapAtoB(EStatusChamado a, StatusChamadoVO b, MappingContext context) {
        b.setCodigo(a.getCodigo());
        b.setDescricao(a.getDescricao());
    }

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(EStatusChamado.class, StatusChamadoVO.class)
                .customize(this)
                .exclude("status")
                .byDefault()
                .register();
    }
}
