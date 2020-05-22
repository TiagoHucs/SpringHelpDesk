package com.hucs.helpdesk.negocio.chamado;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoVO {

    private Long id;
    private LocalDateTime dataHoraAbertura;
    private LocalDateTime dataHoraFechamento;
    private String descricao;
    private EStatusChamado status;

}
