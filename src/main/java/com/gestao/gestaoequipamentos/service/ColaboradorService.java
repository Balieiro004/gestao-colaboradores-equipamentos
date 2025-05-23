package com.gestao.gestaoequipamentos.service;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.repositories.ColaboradorRepository;
import com.gestao.gestaoequipamentos.repositories.EquipamentosRepository;
import com.gestao.gestaoequipamentos.service.exceptions.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EquipamentosRepository equipamentosRepository;

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
        Colaborador entity = buscarColaboradorPorId(id);
        return entity;
    }

    //Busca por Nome
    public List<Colaborador> findByNome(String nome) {
        return colaboradorRepository.findByNomeContainingIgnoreCase(nome);
    }

    //Atualizar
    @Transactional
    public Colaborador update(Long id, Colaborador colaborador) {
        try{
            Colaborador entity  = colaboradorRepository.getReferenceById(id);
            entity.setNome(colaborador.getNome());
            entity.setDataInicio(colaborador.getDataInicio());
            entity.setNome(colaborador.getUserName());
            entity.setUserPassword(colaborador.getUserPassword());
            entity = colaboradorRepository.save(entity);
            return entity;
        }catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Colaborador não encontrado");
        }
    }

    @Transactional
    public Colaborador vincularEquipamento(Long colaboradorId, Long equipamentoId) {
        Colaborador colaborador = buscarColaboradorPorId(colaboradorId);
        Equipamento equipamento = buscarEquipamentoPorId(equipamentoId);

        if (equipamento.getColaborador() != null && !Objects.equals(equipamento.getColaborador().getId(), colaboradorId)) {
            throw new IllegalStateException("Este equipamento já está vinculado a outro colaborador.");
        }


        colaborador.adicionarEquipamento(equipamento);
        return colaboradorRepository.save(colaborador);
    }

    @Transactional
    public Colaborador desvincularEquipamento(Long colaboradorId, Long equipamentoId) {

        Colaborador colaborador = buscarColaboradorPorId(colaboradorId);
        Equipamento equipamento = buscarEquipamentoPorId(equipamentoId);

        colaborador.removerEquipamento(equipamento);
        return colaboradorRepository.save(colaborador);
    }

    private Colaborador buscarColaboradorPorId(Long colaboradorId) {
        return colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new ControllerNotFoundException("Colaborador não encontrado"));
    }

    private Equipamento buscarEquipamentoPorId(Long equipamentoId) {
        return equipamentosRepository.findById(equipamentoId).orElseThrow(() -> new ControllerNotFoundException("Equipamento não encontrado"));
    }

}
