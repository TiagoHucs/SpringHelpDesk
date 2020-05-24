package com.hucs.helpdesk.negocio.chamado;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EStatusChamado {

    ABERTO  ("1", "Aberto"),
    ANDAMENTO ("2", "Em andamento"),
    FECHADO ("3", "Fechado");

    private final String codigo;
    private final String descricao;

    EStatusChamado(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public StatusChamadoVO getStatusChamadoVO(){
        return StatusChamadoVO.builder()
                .codigo(this.getCodigo())
                .descricao(this.getDescricao())
                .build();
    }

    public static EStatusChamado getWithCodigo(String codigo){
        for (EStatusChamado e :EStatusChamado.values()) {
            if(e.getCodigo().equals(codigo)){
                return e;
            }
        }
        return null;
    }

    public static List<EStatusChamado> valuesList(){
        List<EStatusChamado> list = new ArrayList<>();
        for (EStatusChamado e :EStatusChamado.values()) {
            list.add(e);
        }
        return list;
    }

}
