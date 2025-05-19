package com.gestao.gestaoequipamentos.service;

import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.repositories.EquipamentosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentosRepository equipamentosRepository;

    //Salvar novo equiaomento
    @Transactional
    public Equipamento salve(Equipamento equipamento) {
        return equipamentosRepository.save(equipamento);
    }

}
