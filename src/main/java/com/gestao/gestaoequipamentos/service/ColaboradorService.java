package com.gestao.gestaoequipamentos.service;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.repositories.ColaboradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    @Transactional
    public Colaborador salve(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
}
