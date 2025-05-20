package com.gestao.gestaoequipamentos.controllers;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.entities.Equipamento;
import com.gestao.gestaoequipamentos.entities.dto.EquipamentoDTO;
import com.gestao.gestaoequipamentos.service.ColaboradorService;
import com.gestao.gestaoequipamentos.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    //Adicionar novo Colaborador
    @PostMapping
    public ResponseEntity<Equipamento> salve(@RequestBody Equipamento equipamento) {
        Equipamento entity = equipamentoService.salve(equipamento);
        return  ResponseEntity.ok().body(entity);
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> findAll() {
        List<EquipamentoDTO> list = equipamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Busca por id
    @GetMapping(value = {"/id/{id}"})
    public ResponseEntity<EquipamentoDTO> findById(@PathVariable Long id) {
        Equipamento equipamento = equipamentoService.findById(id);
        EquipamentoDTO dto = new EquipamentoDTO(equipamento);
        return ResponseEntity.ok().body(dto);
    }


    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable Long id, @RequestBody EquipamentoDTO dto) {
        Equipamento equipamentoAtualizado = equipamentoService.update(id, dto);
        return ResponseEntity.ok(new EquipamentoDTO(equipamentoAtualizado));
    }
//
//    @PostMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
//    public ResponseEntity<Void> vincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
//        colaboradorService.vincularEquipamento(colaboradorId, equipamentoId);
//        return ResponseEntity.ok().build();
//    }

}
