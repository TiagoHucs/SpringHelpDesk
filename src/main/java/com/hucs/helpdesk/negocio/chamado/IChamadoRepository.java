package com.hucs.helpdesk.negocio.chamado;

import com.hucs.helpdesk.negocio.chamado.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChamadoRepository extends JpaRepository<Chamado, Long> {

}
