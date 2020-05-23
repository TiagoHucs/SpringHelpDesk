package com.hucs.helpdesk.negocio.chamado;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusChamadoVO {
    private String codigo;
    private String descricao;
}
