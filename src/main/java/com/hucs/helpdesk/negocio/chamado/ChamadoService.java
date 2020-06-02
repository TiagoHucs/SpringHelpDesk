package com.hucs.helpdesk.negocio.chamado;

import com.hucs.helpdesk.negocio.log.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository repository;

    @LogExecutionTime("Listar chamados")
    public List<Chamado> listar() {
        return repository.findAll();
    }

    public void criar(Chamado c) {
        c.setDataHoraAbertura(LocalDateTime.now());
        c.setStatus(EStatusChamado.ABERTO);
        repository.save(c);
    }

    public Chamado obter(Long id) {
        Optional<Chamado> op = repository.findById(id);
        return op.get();
    }

    protected List<StatusChamadoVO> getStatusList(){
        List<StatusChamadoVO> list = new ArrayList<>();
        for (EStatusChamado enums: EStatusChamado.values()) {
            list.add(enums.getStatusChamadoVO());
        }
        return list;
    }

    public void salvar(Chamado alterado) {
        Chamado original = obter(alterado.getId());
        original.setStatus(alterado.getStatus());
        original.setDescricao(alterado.getDescricao());
        original.setTitulo(alterado.getTitulo());
        repository.save(original);
    }
}
