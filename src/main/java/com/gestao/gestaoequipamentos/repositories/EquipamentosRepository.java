package com.gestao.gestaoequipamentos.repositories;

import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.entities.dto.EquipamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipamentosRepository extends JpaRepository<Equipamento, Long> {
    Optional<List<Equipamento>> findByContratoLeasing(Long contratoLeasing);
    Optional<Equipamento> findByServiceTag(String serviceTag);
}
