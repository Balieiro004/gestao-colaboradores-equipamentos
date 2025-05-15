package com.gestao.gestaoequipamentos.repositories;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
