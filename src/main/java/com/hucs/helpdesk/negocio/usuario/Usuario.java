package com.hucs.helpdesk.negocio.usuario;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USR_USUARIO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_EMAIL", insertable = true, updatable = false)
    private String email;

    @Column(name = "USR_PASSWORD", insertable = true, updatable = true)
    private String password;

    @Column
    private EProfile profile;
}
