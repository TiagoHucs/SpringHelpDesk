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
    private String titulo;
    private String descricao;
    private String statusId;
    private StatusChamadoVO status;

}
