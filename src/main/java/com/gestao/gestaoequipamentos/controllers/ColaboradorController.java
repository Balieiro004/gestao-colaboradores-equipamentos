package com.gestao.gestaoequipamentos.controllers;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    //Adicionar novo Colaborador
    @PostMapping
    public ResponseEntity<Colaborador> salve(@RequestBody Colaborador colaborador) {
        Colaborador entity = colaboradorService.salve(colaborador);
        return  ResponseEntity.ok().body(entity);
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> list = colaboradorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Busca por id
    @GetMapping(value = {"/id/{id}"})
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Colaborador entity = colaboradorService.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    //Buscar por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Colaborador>> findByNome(@PathVariable String nome) {
        List<Colaborador> colaboradores = colaboradorService.findByNome(nome);

        if (colaboradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(colaboradores);
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> update(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        Colaborador entity = colaboradorService.update(id, colaborador);
        return ResponseEntity.ok().body(entity);
    }

    //Vincular Equipamento ao Colaborador
    @PostMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
    public ResponseEntity<Colaborador> vincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
        Colaborador entity = colaboradorService.vincularEquipamento(colaboradorId, equipamentoId);
        return ResponseEntity.ok().body(entity);
    }

    //Remover equipamento do colaborador
    @DeleteMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
    public ResponseEntity<Colaborador> desvincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
        Colaborador entity = colaboradorService.desvincularEquipamento(colaboradorId, equipamentoId);
        return ResponseEntity.ok().body(entity);
    }

}
