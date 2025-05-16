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

    //Salvar Colaborador
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
    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Colaborador entity = colaboradorService.findById(id);
        return ResponseEntity.ok().body(entity);
    }

}
