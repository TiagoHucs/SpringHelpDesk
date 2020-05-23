package com.hucs.helpdesk.negocio.chamado;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoEditarResource {

    private ChamadoVO chamadoVO;
    private List<StatusChamadoVO> statusList;
}
