package com.gestao.gestaoequipamentos.entities;

import com.gestao.gestaoequipamentos.entities.Enums.TipoEquipamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEquipamento;

    @Enumerated(EnumType.STRING)
    private TipoEquipamento tipoEquipamento;

    private String modelo;
    private String serviceTag;
    private int contratoLeasing;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}
