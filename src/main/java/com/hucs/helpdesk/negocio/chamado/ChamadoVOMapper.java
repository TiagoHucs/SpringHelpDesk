package com.hucs.helpdesk.negocio.chamado;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class ChamadoVOMapper extends CustomMapper<Chamado, ChamadoVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Chamado.class, ChamadoVO.class)
                .customize(this)
                .byDefault()
                .register();
    }
}
