package com.gestao.gestaoequipamentos.controllers;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.entities.Equipamento;
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

//    //Buscar todos
//    @GetMapping
//    public ResponseEntity<List<Colaborador>> findAll() {
//        List<Colaborador> list = colaboradorService.findAll();
//        return ResponseEntity.ok().body(list);
//    }
//
//    //Busca por id
//    @GetMapping(value = {"/id/{id}"})
//    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
//        Colaborador entity = colaboradorService.findById(id);
//        return ResponseEntity.ok().body(entity);
//    }
//
//    //Buscar por nome
//    @GetMapping("/nome/{nome}")
//    public ResponseEntity<List<Colaborador>> findByNome(@PathVariable String nome) {
//        List<Colaborador> colaboradores = colaboradorService.findByNome(nome);
//
//        if (colaboradores.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(colaboradores);
//    }
//
//    //atualizar
//    @PutMapping("/{id}")
//    public ResponseEntity<Colaborador> update(@PathVariable Long id, @RequestBody Colaborador colaborador) {
//        Colaborador entity = colaboradorService.update(id, colaborador);
//        return ResponseEntity.ok().body(entity);
//    }
//
//    @PostMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
//    public ResponseEntity<Void> vincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
//        colaboradorService.vincularEquipamento(colaboradorId, equipamentoId);
//        return ResponseEntity.ok().build();
//    }

}
