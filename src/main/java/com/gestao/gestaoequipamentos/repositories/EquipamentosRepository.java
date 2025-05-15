package com.gestao.gestaoequipamentos.repositories;

import com.gestao.gestaoequipamentos.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentosRepository extends JpaRepository<Equipamento, Long> {
}
