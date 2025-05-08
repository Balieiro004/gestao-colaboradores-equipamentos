package com.gestao.gestaoequipamentos.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
public class Pessoa {
    private String nome;
    private Date dataInicio;
}
