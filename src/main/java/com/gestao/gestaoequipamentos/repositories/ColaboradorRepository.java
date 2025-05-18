package com.gestao.gestaoequipamentos.repositories;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findByNomeContainingIgnoreCase(String nome);
}
