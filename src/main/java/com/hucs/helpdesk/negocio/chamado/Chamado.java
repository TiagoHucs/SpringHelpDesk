package com.hucs.helpdesk.negocio.chamado;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHA_CHAMADO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Chamado {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHA_ID")
    private Long id;

    @Column(name = "CHA_DH_ABERTURA", insertable = true, updatable = false)
    private LocalDateTime dataHoraAbertura;

    @Column(name = "CHA_DH_FECHAMENTO", insertable = true, updatable = true)
    private LocalDateTime dataHoraFechamento;

    @Column(name = "CHA_DS_DESCRICAO")
    private String descricao;

    @Column(name = "CHA_CD_STATUS")
    private EStatusChamado status;
}
