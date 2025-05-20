package com.gestao.gestaoequipamentos.service;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.entities.dto.EquipamentoDTO;
import com.gestao.gestaoequipamentos.repositories.EquipamentosRepository;
import com.gestao.gestaoequipamentos.service.exceptions.ControllerNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentosRepository equipamentosRepository;

    //Salvar novo equipamento
    @Transactional
    public Equipamento salve(Equipamento equipamento) {
        return equipamentosRepository.save(equipamento);
    }

    //Buscar todos
    public List<EquipamentoDTO> findAll() {
        return equipamentosRepository.findAll()
                .stream()
                .map(EquipamentoDTO::new)
                .collect(Collectors.toList());
    }

    //Busca por ID
    public Equipamento findById(Long id) {
        return equipamentosRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Equipamento não encontrado com ID: " + id));
    }

    //Atualizar Equipamento por Id
    public Equipamento update(Long id, EquipamentoDTO dto) {
        Equipamento equipamento = equipamentosRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Equipamento não encontrado com ID: " + id));

        atualizarCamposEquipamento(equipamento, dto);

        return equipamentosRepository.save(equipamento);
    }

    private void atualizarCamposEquipamento(Equipamento equipamento, EquipamentoDTO dto) {
        equipamento.setTipoEquipamento(dto.getTipoEquipamento());
        equipamento.setModelo(dto.getModelo());
        equipamento.setServiceTag(dto.getServiceTag());
        equipamento.setContratoLeasing(dto.getContratoLeasing());
    }
}
