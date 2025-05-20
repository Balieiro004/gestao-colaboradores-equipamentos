package com.gestao.gestaoequipamentos.entities.dto;

import com.gestao.gestaoequipamentos.entities.Enums.TipoEquipamento;
import com.gestao.gestaoequipamentos.entities.Equipamento;

public class EquipamentoDTO {

    private Long idEquipamento;
    private TipoEquipamento tipoEquipamento;
    private String modelo;
    private String serviceTag;
    private Long contratoLeasing;
    private ColaboradorResumoDTO colaborador;

    public EquipamentoDTO() {

    }

    public EquipamentoDTO(Equipamento equipamento) {
        this.idEquipamento = equipamento.getIdEquipamento();
        this.tipoEquipamento = equipamento.getTipoEquipamento();
        this.modelo = equipamento.getModelo();
        this.serviceTag = equipamento.getServiceTag();
        this.contratoLeasing = (long) equipamento.getContratoLeasing();
        if (equipamento.getColaborador() != null) {
            this.colaborador = new ColaboradorResumoDTO(equipamento.getColaborador());
        }
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
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

    public ColaboradorResumoDTO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorResumoDTO colaborador) {
        this.colaborador = colaborador;
    }
}
