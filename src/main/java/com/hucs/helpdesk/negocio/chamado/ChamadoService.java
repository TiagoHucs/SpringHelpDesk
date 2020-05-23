package com.hucs.helpdesk.negocio.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ChamadoService {

    @Autowired
    private IChamadoRepository repository;

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

    public void salvar(ChamadoVO vo) {
        Chamado original = obter(vo.getId());
        original.setStatus(EStatusChamado.getWithCodigo(vo.getStatus()));
        original.setDescricao(vo.getDescricao());
        repository.save(original);
    }
}
