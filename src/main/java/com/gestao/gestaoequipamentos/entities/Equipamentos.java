package com.gestao.gestaoequipamentos.entities;

import com.gestao.gestaoequipamentos.entities.Enums.TipoEquipamento;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Equipamentos {
    private int idEquipamento;
    private TipoEquipamento tipoEquipamento;
    private String modelo;
    private String serviceTag;
    private int contratoLeasing;
}
