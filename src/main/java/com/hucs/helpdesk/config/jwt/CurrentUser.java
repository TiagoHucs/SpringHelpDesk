package com.hucs.helpdesk.config.jwt;

import com.hucs.helpdesk.negocio.usuario.Usuario;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser {
    String token;
    Usuario usuario;
}
