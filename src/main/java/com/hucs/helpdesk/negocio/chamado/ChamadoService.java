package com.hucs.helpdesk.negocio.chamado;

import com.hucs.helpdesk.negocio.chamado.Chamado;
import com.hucs.helpdesk.negocio.chamado.ChamadoVO;
import com.hucs.helpdesk.negocio.chamado.EStatusChamado;
import com.hucs.helpdesk.negocio.chamado.IChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository repository;

    public List<Chamado> listar() {
        return repository.findAll();
    }

    public void criar(ChamadoVO vo) {
        LocalDateTime agora = LocalDateTime.now();
        Chamado chamado = Chamado.builder()
                .status(EStatusChamado.ABERTO)
                .dataHoraAbertura(agora)
                .descricao(vo.getDescricao())
                .build();

        repository.save(chamado);
    }

    public Chamado obter(Long id) {
        Optional<Chamado> chamadoOp = repository.findById(id);
        Chamado chamado = chamadoOp.get();
        return chamado;
    }

    public void encerrar(ChamadoVO vo) {
        LocalDateTime agora = LocalDateTime.now();
        Optional<Chamado> chamadoOp = repository.findById(vo.getId());
        Chamado chamado = chamadoOp.get();
        chamado.setStatus(EStatusChamado.FECHADO);
        chamado.setDataHoraFechamento(agora);
        repository.save(chamado);
    }

}
