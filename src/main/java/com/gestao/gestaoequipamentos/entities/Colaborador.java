package com.gestao.gestaoequipamentos.entities;



import com.gestao.gestaoequipamentos.entities.Enums.SistemaOperacional;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
public class Colaborador extends Pessoa {

    private String user;
    private String password;
    private SistemaOperacional sistemaOperacional;
    private List<Equipamentos> equipamentos;

}
