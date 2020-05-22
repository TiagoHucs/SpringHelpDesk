package com.hucs.helpdesk.negocio.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

}
