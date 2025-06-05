package com.gestao.gestaoequipamentos.controllers;

import com.gestao.gestaoequipamentos.entities.Colaborador;
import com.gestao.gestaoequipamentos.service.ColaboradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colaboradores")
@Tag(name =  "Colaboradores", description = "Endpoints para gerenciamento de colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Operation(summary = "Cadastra um novo colaborador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Colaborador cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "403", description = "Acesso não autorizado"),
            @ApiResponse(responseCode = "409", description = "Violação no banco de dados, ja existe colaborador cadastrado com esse login")
    })
    @PostMapping
    public ResponseEntity<Colaborador> salve(@RequestBody Colaborador colaborador) {
        Colaborador entity = colaboradorService.salve(colaborador);
        return  ResponseEntity.ok().body(entity);
    }

    @Operation(summary = "Lista todos os colaboradores")
    @ApiResponse(responseCode = "200", description = "Lista de colaboradores retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> list = colaboradorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca colaborador por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Colaborador encontrado"),
            @ApiResponse(responseCode = "404", description = "Colaborador não encontrado")
    })
    @GetMapping(value = {"/id/{id}"})
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Colaborador entity = colaboradorService.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @Operation(summary = "Busca colaboradores pelo nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Colaboradores encontrados"),
            @ApiResponse(responseCode = "204", description = "Nenhum colaborador com esse nome")
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Colaborador>> findByNome(@PathVariable String nome) {
        List<Colaborador> colaboradores = colaboradorService.findByNome(nome);

        if (colaboradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(colaboradores);
    }

    @Operation(summary = "Atualiza dados de um colaborador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Colaborador atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Colaborador não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> update(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        Colaborador entity = colaboradorService.update(id, colaborador);
        return ResponseEntity.ok().body(entity);
    }

    @Operation(summary = "Vincula um equipamento a um colaborador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento vinculado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Violação na regra de negocio, equipamento ja vinculado a um colaborador"),
            @ApiResponse(responseCode = "404", description = "Colaborador ou equipamento não encontrado")

    })
    @PostMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
    public ResponseEntity<Colaborador> vincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
        Colaborador entity = colaboradorService.vincularEquipamento(colaboradorId, equipamentoId);
        return ResponseEntity.ok().body(entity);
    }

    @Operation(summary = "Desvincula um equipamento de um colaborador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento desvinculado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Colaborador ou equipamento não encontrado")
    })
    @DeleteMapping("/{colaboradorId}/equipamentos/{equipamentoId}")
    public ResponseEntity<Colaborador> desvincularEquipamento(@PathVariable Long colaboradorId, @PathVariable Long equipamentoId) {
        Colaborador entity = colaboradorService.desvincularEquipamento(colaboradorId, equipamentoId);
        return ResponseEntity.ok().body(entity);
    }

}
