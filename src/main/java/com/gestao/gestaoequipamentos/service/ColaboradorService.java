package com.gestao.gestaoequipamentos.service;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.repositories.ColaboradorRepository;
import com.gestao.gestaoequipamentos.service.exceptions.ControllerNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    //Salvar novo colaborador
    @Transactional
    public Colaborador salve(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    //Buscar todos
    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    //Busca por ID
    public Colaborador findById(Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        Colaborador entity = colaborador.orElseThrow(() -> new ControllerNotFoundException("Colaborador não encontrado"));
        return entity;
    }


    //Busca por Nome
}
