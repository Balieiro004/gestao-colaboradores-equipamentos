package com.gestao.gestaoequipamentos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestao.gestaoequipamentos.entities.Enums.TipoEquipamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEquipamento;

    @Enumerated(EnumType.STRING)
    private TipoEquipamento tipoEquipamento;

    private String modelo;

    @Column(unique = true)
    @NotBlank(message = "A Service tag é obrigatória")
    private String serviceTag;

    @NotNull
    private Long contratoLeasing;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    @JsonBackReference
    private Colaborador colaborador;


    public Equipamento() {

    }

    public Equipamento(long idEquipamento, TipoEquipamento tipoEquipamento, String modelo, String serviceTag, long contratoLeasing) {
        this.idEquipamento = idEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.modelo = modelo;
        this.serviceTag = serviceTag;
        this.contratoLeasing = contratoLeasing;

    }

    public long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public Long getContratoLeasing() {
        return contratoLeasing;
    }

    public void setContratoLeasing(Long contratoLeasing) {
        this.contratoLeasing = contratoLeasing;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
